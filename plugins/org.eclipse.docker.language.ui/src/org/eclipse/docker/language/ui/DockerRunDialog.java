package org.eclipse.docker.language.ui;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.docker.language.DockerInterpreter;

public class DockerRunDialog extends TitleAreaDialog {

	private Button run;
	private Button build;
	private DockerInterpreter interpreter;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */


	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		
		setMessage("select the run option you prefer to execute");
		setTitle("Run Docker");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		build = new Button(container, SWT.CHECK);
		
		FormData fd_btnBuildImages = new FormData();
		fd_btnBuildImages.left = new FormAttachment(0, 28);
		fd_btnBuildImages.top = new FormAttachment(0, 40);
		build.setLayoutData(fd_btnBuildImages);
		build.setText("build Images");
		
		run = new Button(container, SWT.CHECK);
		FormData fd_btnRunContainers = new FormData();
		fd_btnRunContainers.top = new FormAttachment(build, 28);
		fd_btnRunContainers.left = new FormAttachment(build, 0, SWT.LEFT);
		run.setLayoutData(fd_btnRunContainers);
		run.setText("run Containers");
		

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(652, 533);
	}
	@Override
	protected void okPressed() {
		if(build.isEnabled()){
			interpreter.setBuild(true);
		}
		if(run.isEnabled()){
			interpreter.setRun(true);
		}
		
		super.okPressed();
	}

	public DockerRunDialog(Shell shell, DockerInterpreter interpreter) {
		super(shell);
		this.interpreter = interpreter;
	}
}
