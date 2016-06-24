package org.eclipse.docker.language.ui

import com.google.common.collect.Lists
import java.io.File
import java.util.ArrayList
import org.eclipse.docker.language.DockerConfig
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.ListViewer
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.FormAttachment
import org.eclipse.swt.layout.FormData
import org.eclipse.swt.layout.FormLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.List
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text
import org.eclipse.docker.language.ui.swt.ResourceManager

class ConfigurationDialog extends TitleAreaDialog {
	Text certificateText
	ListViewer listViewer
	DockerConfig config

	/** 
	 * Create the dialog.
	 * @param parentShell
	 * @param config
	 */
	new(Shell parentShell, DockerConfig config) {
		super(parentShell)
		setHelpAvailable(false)
		this.config = config
	// setErrorMessage("");
	}

	/** 
	 * Create contents of the dialog.
	 * @param parent
	 */
	override protected Control createDialogArea(Composite parent) {
		setTitleImage(ResourceManager.getPluginImage("org.eclipse.docker.language.ui", "icons/logo.png"))
		setMessage("select a docker host and provide certificate path", IMessageProvider.INFORMATION)
		setTitle("Docker host Configuration")
		var Composite area = (super.createDialogArea(parent) as Composite)
		var Composite container = new Composite(area, SWT.NONE)
		container.setLayout(new FormLayout())
		container.setLayoutData(new GridData(GridData.FILL_BOTH))
		listViewer = new ListViewer(container, SWT.BORDER.bitwiseOr(SWT.V_SCROLL))
		var List list = listViewer.getList()
		var FormData fd_list = new FormData()
		listViewer.setContentProvider(new ArrayContentProvider())
		listViewer.setLabelProvider(new LabelProvider())
		fd_list.bottom = new FormAttachment(0, 416)
		fd_list.right = new FormAttachment(0, 830)
		fd_list.top = new FormAttachment(0, 10)
		fd_list.left = new FormAttachment(0, 10)
		list.setLayoutData(fd_list)
		listViewer.setInput(Hosts.getInstance().getHosts())
		if (config.getUri() !== null && Hosts.getInstance().getHosts().contains(config.getUri())) {
			listViewer.setSelection(new StructuredSelection(config.getUri()))
		}
		var Button addButton = new Button(container, SWT.NONE)
		addButton.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/obj16/add_obj.png"))
		var FormData fd_addButton = new FormData()
		fd_addButton.top = new FormAttachment(0, 9)
		fd_addButton.right = new FormAttachment(100, -21)
		fd_addButton.left = new FormAttachment(list, 6)
		addButton.setLayoutData(fd_addButton)
		addButton.addSelectionListener(new SelectionAdapter() {
			override void widgetSelected(SelectionEvent e) {
				var IPDialog dialog = new IPDialog(Display.getDefault().getActiveShell(), listViewer)
				dialog.open()
			}
		})
		var Button removeButton = new Button(container, SWT.NONE)
		removeButton.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/obj16/delete_obj.gif"))
		var FormData fd_removeButton = new FormData()
		fd_removeButton.right = new FormAttachment(100, -21)
		fd_removeButton.left = new FormAttachment(list, 6)
		fd_removeButton.top = new FormAttachment(addButton, 21)
		removeButton.setLayoutData(fd_removeButton)
		removeButton.addSelectionListener(new SelectionAdapter() {
			override void widgetSelected(SelectionEvent e) {
				var List list = listViewer.getList()
				if (list.getItems().length > 0) {
					var ArrayList<String> newArrayList = Lists.newArrayList(list.getSelection())
					if (newArrayList.size() > 0 && newArrayList.get(0) !== null) {
						val removed = newArrayList.get(0)

						Hosts.getInstance().hosts.remove(removed)
						listViewer.input = Hosts.instance.hosts
						listViewer.refresh

					}
				}
			}
		})
		certificateText = new Text(container, SWT.BORDER)
		var FormData fd_certificateText = new FormData()
		fd_certificateText.top = new FormAttachment(list, 26)
		fd_certificateText.left = new FormAttachment(0, 10)
		certificateText.setLayoutData(fd_certificateText)
		if (config.getDockerCertPath() !== null) {
			certificateText.setText(config.getDockerCertPath())
		}
		var Button certificateButton = new Button(container, SWT.NONE)
		fd_certificateText.right = new FormAttachment(100, -155)
		var FormData fd_certificateButton = new FormData()
		fd_certificateButton.bottom = new FormAttachment(list, 66, SWT.BOTTOM)
		fd_certificateButton.top = new FormAttachment(certificateText, -2, SWT.TOP)
		fd_certificateButton.right = new FormAttachment(addButton, 0, SWT.RIGHT)
		certificateButton.setLayoutData(fd_certificateButton)
		certificateButton.setText("certificate")
		certificateButton.addSelectionListener(new SelectionAdapter() {
			override void widgetSelected(SelectionEvent e) {
				var DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell())
				certificateText.setText(dialog.open())
				super.widgetSelected(e)
			}
		})
		return container
	}

	/** 
	 * Create contents of the button bar.
	 * @param parent
	 */
	override protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true)
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false)
	}

	/** 
	 * Return the initial size of the dialog.
	 */
	override protected Point getInitialSize() {
		return new Point(931, 824)
	}

	override protected void okPressed() {
		var List list = listViewer.getList()
		if (list.getItems().length > 0) {
			var ArrayList<String> newArrayList = Lists.newArrayList(list.getSelection())
			if (newArrayList.size() > 0 && newArrayList.get(0) !== null &&
				new File(certificateText.getText()).exists()) {
				config.setDockerCertPath(certificateText.getText())
				config.setUri(newArrayList.get(0))
				Hosts.instance.hosts.add(config.uri);
				
				super.okPressed()
			} else {
				if (newArrayList.size() === 0) {
					setMessage("please select a host ", IMessageProvider.ERROR)
				} else if (!new File(certificateText.getText()).exists()) {
					setMessage("please provide certificate path ", IMessageProvider.ERROR)
				}
			}
		} else {
			setMessage("please select a host and provide certificate path ", IMessageProvider.ERROR)
		}
	}

}
