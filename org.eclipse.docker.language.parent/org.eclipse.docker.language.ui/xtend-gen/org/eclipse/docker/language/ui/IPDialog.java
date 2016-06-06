package org.eclipse.docker.language.ui;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Set;
import org.eclipse.docker.language.ui.Hosts;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class IPDialog extends Dialog {
  private ListViewer viewer;
  
  private Text txtIpAdress;
  
  private Text txtPort;
  
  /**
   * Create the dialog.
   * @param parentShell
   * @param listViewer
   */
  public IPDialog(final Shell parentShell, final ListViewer list) {
    super(parentShell);
    this.viewer = list;
  }
  
  /**
   * Create contents of the dialog.
   * @param parent
   */
  @Override
  protected Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    Composite container = ((Composite) _createDialogArea);
    FormLayout _formLayout = new FormLayout();
    container.setLayout(_formLayout);
    Label lblDockerhost = new Label(container, SWT.NONE);
    FormData fd_lblDockerhost = new FormData();
    FormAttachment _formAttachment = new FormAttachment(0, 10);
    fd_lblDockerhost.top = _formAttachment;
    FormAttachment _formAttachment_1 = new FormAttachment(0, 21);
    fd_lblDockerhost.left = _formAttachment_1;
    lblDockerhost.setLayoutData(fd_lblDockerhost);
    lblDockerhost.setText("DOCKER_HOST");
    Text _text = new Text(container, (SWT.BORDER | SWT.SINGLE));
    this.txtIpAdress = _text;
    this.txtIpAdress.setText("enter IP address");
    FormData fd_txtIpAdress = new FormData();
    FormAttachment _formAttachment_2 = new FormAttachment(0, 313);
    fd_txtIpAdress.right = _formAttachment_2;
    FormAttachment _formAttachment_3 = new FormAttachment(lblDockerhost, 28);
    fd_txtIpAdress.top = _formAttachment_3;
    FormAttachment _formAttachment_4 = new FormAttachment(0, 10);
    fd_txtIpAdress.left = _formAttachment_4;
    this.txtIpAdress.setLayoutData(fd_txtIpAdress);
    Text _text_1 = new Text(container, (SWT.BORDER | SWT.SINGLE));
    this.txtPort = _text_1;
    this.txtPort.setText("port");
    FormData fd_txtPort = new FormData();
    FormAttachment _formAttachment_5 = new FormAttachment(this.txtIpAdress, 121, SWT.RIGHT);
    fd_txtPort.right = _formAttachment_5;
    FormAttachment _formAttachment_6 = new FormAttachment(0, 70);
    fd_txtPort.top = _formAttachment_6;
    FormAttachment _formAttachment_7 = new FormAttachment(this.txtIpAdress, 14);
    fd_txtPort.left = _formAttachment_7;
    this.txtPort.setLayoutData(fd_txtPort);
    return container;
  }
  
  /**
   * Create contents of the button bar.
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }
  
  /**
   * Return the initial size of the dialog.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(457, 302);
  }
  
  @Override
  protected void okPressed() {
    boolean _and = false;
    String _text = this.txtIpAdress.getText();
    boolean _matches = _text.matches("\\d+(\\.\\d+){3}");
    if (!_matches) {
      _and = false;
    } else {
      String _text_1 = this.txtPort.getText();
      boolean _matches_1 = _text_1.matches("[0-9]+");
      _and = _matches_1;
    }
    if (_and) {
      StringConcatenation _builder = new StringConcatenation();
      String _text_2 = this.txtIpAdress.getText();
      _builder.append(_text_2, "");
      _builder.append(":");
      String _text_3 = this.txtPort.getText();
      _builder.append(_text_3, "");
      final String entry = _builder.toString();
      Hosts _instance = Hosts.getInstance();
      Set<String> _hosts = _instance.getHosts();
      _hosts.add(entry);
      List list = this.viewer.getList();
      String[] _items = list.getItems();
      ArrayList<String> items = Lists.<String>newArrayList(_items);
      items.add(entry);
      this.viewer.setInput(items);
      this.viewer.refresh();
      super.okPressed();
    } else {
      Display _current = Display.getCurrent();
      Shell _activeShell = _current.getActiveShell();
      MessageDialog.openError(_activeShell, " IP Address Format Error", 
        "please enter valid IP address and Port number");
    }
  }
}
