package org.eclipse.docker.language.ui;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import org.eclipse.docker.language.DockerConfig;
import org.eclipse.docker.language.ui.Hosts;
import org.eclipse.docker.language.ui.IPDialog;
import org.eclipse.docker.language.ui.swt.ResourceManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("all")
public class ConfigurationDialog extends TitleAreaDialog {
  private Text certificateText;
  
  private ListViewer listViewer;
  
  private DockerConfig config;
  
  /**
   * Create the dialog.
   * @param parentShell
   * @param config
   */
  public ConfigurationDialog(final Shell parentShell, final DockerConfig config) {
    super(parentShell);
    this.setHelpAvailable(false);
    this.config = config;
  }
  
  /**
   * Create contents of the dialog.
   * @param parent
   */
  @Override
  protected Control createDialogArea(final Composite parent) {
    Image _pluginImage = ResourceManager.getPluginImage("org.eclipse.docker.language.ui", "icons/logo.png");
    this.setTitleImage(_pluginImage);
    this.setMessage("select a docker host and provide certificate path", IMessageProvider.INFORMATION);
    this.setTitle("Docker host Configuration");
    Control _createDialogArea = super.createDialogArea(parent);
    Composite area = ((Composite) _createDialogArea);
    Composite container = new Composite(area, SWT.NONE);
    FormLayout _formLayout = new FormLayout();
    container.setLayout(_formLayout);
    GridData _gridData = new GridData(GridData.FILL_BOTH);
    container.setLayoutData(_gridData);
    ListViewer _listViewer = new ListViewer(container, (SWT.BORDER | SWT.V_SCROLL));
    this.listViewer = _listViewer;
    List list = this.listViewer.getList();
    FormData fd_list = new FormData();
    ArrayContentProvider _arrayContentProvider = new ArrayContentProvider();
    this.listViewer.setContentProvider(_arrayContentProvider);
    LabelProvider _labelProvider = new LabelProvider();
    this.listViewer.setLabelProvider(_labelProvider);
    FormAttachment _formAttachment = new FormAttachment(0, 416);
    fd_list.bottom = _formAttachment;
    FormAttachment _formAttachment_1 = new FormAttachment(0, 830);
    fd_list.right = _formAttachment_1;
    FormAttachment _formAttachment_2 = new FormAttachment(0, 10);
    fd_list.top = _formAttachment_2;
    FormAttachment _formAttachment_3 = new FormAttachment(0, 10);
    fd_list.left = _formAttachment_3;
    list.setLayoutData(fd_list);
    Hosts _instance = Hosts.getInstance();
    Set<String> _hosts = _instance.getHosts();
    this.listViewer.setInput(_hosts);
    boolean _and = false;
    String _uri = this.config.getUri();
    boolean _tripleNotEquals = (_uri != null);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      Hosts _instance_1 = Hosts.getInstance();
      Set<String> _hosts_1 = _instance_1.getHosts();
      String _uri_1 = this.config.getUri();
      boolean _contains = _hosts_1.contains(_uri_1);
      _and = _contains;
    }
    if (_and) {
      String _uri_2 = this.config.getUri();
      StructuredSelection _structuredSelection = new StructuredSelection(_uri_2);
      this.listViewer.setSelection(_structuredSelection);
    }
    Button addButton = new Button(container, SWT.NONE);
    Image _pluginImage_1 = ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/obj16/add_obj.png");
    addButton.setImage(_pluginImage_1);
    FormData fd_addButton = new FormData();
    FormAttachment _formAttachment_4 = new FormAttachment(0, 9);
    fd_addButton.top = _formAttachment_4;
    FormAttachment _formAttachment_5 = new FormAttachment(100, (-21));
    fd_addButton.right = _formAttachment_5;
    FormAttachment _formAttachment_6 = new FormAttachment(list, 6);
    fd_addButton.left = _formAttachment_6;
    addButton.setLayoutData(fd_addButton);
    addButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        Display _default = Display.getDefault();
        Shell _activeShell = _default.getActiveShell();
        IPDialog dialog = new IPDialog(_activeShell, ConfigurationDialog.this.listViewer);
        dialog.open();
      }
    });
    Button removeButton = new Button(container, SWT.NONE);
    Image _pluginImage_2 = ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/obj16/delete_obj.gif");
    removeButton.setImage(_pluginImage_2);
    FormData fd_removeButton = new FormData();
    FormAttachment _formAttachment_7 = new FormAttachment(100, (-21));
    fd_removeButton.right = _formAttachment_7;
    FormAttachment _formAttachment_8 = new FormAttachment(list, 6);
    fd_removeButton.left = _formAttachment_8;
    FormAttachment _formAttachment_9 = new FormAttachment(addButton, 21);
    fd_removeButton.top = _formAttachment_9;
    removeButton.setLayoutData(fd_removeButton);
    removeButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        List list = ConfigurationDialog.this.listViewer.getList();
        String[] _items = list.getItems();
        int _length = _items.length;
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          String[] _selection = list.getSelection();
          ArrayList<String> newArrayList = Lists.<String>newArrayList(_selection);
          boolean _and = false;
          int _size = newArrayList.size();
          boolean _greaterThan_1 = (_size > 0);
          if (!_greaterThan_1) {
            _and = false;
          } else {
            String _get = newArrayList.get(0);
            boolean _tripleNotEquals = (_get != null);
            _and = _tripleNotEquals;
          }
          if (_and) {
            final String removed = newArrayList.get(0);
            Hosts _instance = Hosts.getInstance();
            Set<String> _hosts = _instance.getHosts();
            _hosts.remove(removed);
            Hosts _instance_1 = Hosts.getInstance();
            Set<String> _hosts_1 = _instance_1.getHosts();
            ConfigurationDialog.this.listViewer.setInput(_hosts_1);
            ConfigurationDialog.this.listViewer.refresh();
          }
        }
      }
    });
    Text _text = new Text(container, SWT.BORDER);
    this.certificateText = _text;
    FormData fd_certificateText = new FormData();
    FormAttachment _formAttachment_10 = new FormAttachment(list, 26);
    fd_certificateText.top = _formAttachment_10;
    FormAttachment _formAttachment_11 = new FormAttachment(0, 10);
    fd_certificateText.left = _formAttachment_11;
    this.certificateText.setLayoutData(fd_certificateText);
    String _dockerCertPath = this.config.getDockerCertPath();
    boolean _tripleNotEquals_1 = (_dockerCertPath != null);
    if (_tripleNotEquals_1) {
      String _dockerCertPath_1 = this.config.getDockerCertPath();
      this.certificateText.setText(_dockerCertPath_1);
    }
    Button certificateButton = new Button(container, SWT.NONE);
    FormAttachment _formAttachment_12 = new FormAttachment(100, (-155));
    fd_certificateText.right = _formAttachment_12;
    FormData fd_certificateButton = new FormData();
    FormAttachment _formAttachment_13 = new FormAttachment(list, 66, SWT.BOTTOM);
    fd_certificateButton.bottom = _formAttachment_13;
    FormAttachment _formAttachment_14 = new FormAttachment(this.certificateText, (-2), SWT.TOP);
    fd_certificateButton.top = _formAttachment_14;
    FormAttachment _formAttachment_15 = new FormAttachment(addButton, 0, SWT.RIGHT);
    fd_certificateButton.right = _formAttachment_15;
    certificateButton.setLayoutData(fd_certificateButton);
    certificateButton.setText("certificate");
    certificateButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        Display _current = Display.getCurrent();
        Shell _activeShell = _current.getActiveShell();
        DirectoryDialog dialog = new DirectoryDialog(_activeShell);
        String _open = dialog.open();
        ConfigurationDialog.this.certificateText.setText(_open);
        super.widgetSelected(e);
      }
    });
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
    return new Point(931, 824);
  }
  
  @Override
  protected void okPressed() {
    List list = this.listViewer.getList();
    String[] _items = list.getItems();
    int _length = _items.length;
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      String[] _selection = list.getSelection();
      ArrayList<String> newArrayList = Lists.<String>newArrayList(_selection);
      boolean _and = false;
      boolean _and_1 = false;
      int _size = newArrayList.size();
      boolean _greaterThan_1 = (_size > 0);
      if (!_greaterThan_1) {
        _and_1 = false;
      } else {
        String _get = newArrayList.get(0);
        boolean _tripleNotEquals = (_get != null);
        _and_1 = _tripleNotEquals;
      }
      if (!_and_1) {
        _and = false;
      } else {
        String _text = this.certificateText.getText();
        File _file = new File(_text);
        boolean _exists = _file.exists();
        _and = _exists;
      }
      if (_and) {
        String _text_1 = this.certificateText.getText();
        this.config.setDockerCertPath(_text_1);
        String _get_1 = newArrayList.get(0);
        this.config.setUri(_get_1);
        Hosts _instance = Hosts.getInstance();
        Set<String> _hosts = _instance.getHosts();
        String _uri = this.config.getUri();
        _hosts.add(_uri);
        super.okPressed();
      } else {
        int _size_1 = newArrayList.size();
        boolean _tripleEquals = (_size_1 == 0);
        if (_tripleEquals) {
          this.setMessage("please select a host ", IMessageProvider.ERROR);
        } else {
          String _text_2 = this.certificateText.getText();
          File _file_1 = new File(_text_2);
          boolean _exists_1 = _file_1.exists();
          boolean _not = (!_exists_1);
          if (_not) {
            this.setMessage("please provide certificate path ", IMessageProvider.ERROR);
          }
        }
      }
    } else {
      this.setMessage("please select a host and provide certificate path ", IMessageProvider.ERROR);
    }
  }
}
