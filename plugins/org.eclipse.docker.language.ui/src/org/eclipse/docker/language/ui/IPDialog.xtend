package org.eclipse.docker.language.ui

import com.google.common.collect.Lists
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.viewers.ListViewer
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.FormAttachment
import org.eclipse.swt.layout.FormData
import org.eclipse.swt.layout.FormLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text

class IPDialog extends Dialog {
	ListViewer viewer
	Text txtIpAdress
	Text txtPort

	/** 
	 * Create the dialog.
	 * @param parentShell
	 * @param listViewer 
	 */
	new(Shell parentShell, ListViewer list) {
		super(parentShell)
		viewer = list
	}

	/** 
	 * Create contents of the dialog.
	 * @param parent
	 */
	override protected Control createDialogArea(Composite parent) {
		var Composite container = (super.createDialogArea(parent) as Composite)
		container.setLayout(new FormLayout())
		var Label lblDockerhost = new Label(container, SWT.NONE)
		var FormData fd_lblDockerhost = new FormData()
		fd_lblDockerhost.top = new FormAttachment(0, 10)
		fd_lblDockerhost.left = new FormAttachment(0, 21)
		lblDockerhost.setLayoutData(fd_lblDockerhost)
		lblDockerhost.setText("DOCKER_HOST")
		txtIpAdress = new Text(container, SWT.BORDER.bitwiseOr(SWT.SINGLE))
		txtIpAdress.setText("enter IP address")
		var FormData fd_txtIpAdress = new FormData()
		fd_txtIpAdress.right = new FormAttachment(0, 313)
		fd_txtIpAdress.top = new FormAttachment(lblDockerhost, 28)
		fd_txtIpAdress.left = new FormAttachment(0, 10)
		txtIpAdress.setLayoutData(fd_txtIpAdress)
		txtPort = new Text(container, SWT.BORDER.bitwiseOr(SWT.SINGLE))
		txtPort.setText("port")
		var FormData fd_txtPort = new FormData()
		fd_txtPort.right = new FormAttachment(txtIpAdress, 121, SWT.RIGHT)
		fd_txtPort.top = new FormAttachment(0, 70)
		fd_txtPort.left = new FormAttachment(txtIpAdress, 14)
		txtPort.setLayoutData(fd_txtPort)
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
		return new Point(457, 302)
	}

	override protected void okPressed() {
		if (txtIpAdress.getText().matches("\\d+(\\.\\d+){3}") && txtPort.getText().matches("[0-9]+")) {
			val String entry = '''«txtIpAdress.getText()»:«txtPort.getText()»'''

			Hosts.getInstance().hosts.add(entry)
			var list = viewer.list
			var items = Lists.newArrayList(list.items)
			items += entry
			viewer.input = items
			viewer.refresh
			super.okPressed
		} else {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), " IP Address Format Error",
				"please enter valid IP address and Port number")
		}
	}

}
