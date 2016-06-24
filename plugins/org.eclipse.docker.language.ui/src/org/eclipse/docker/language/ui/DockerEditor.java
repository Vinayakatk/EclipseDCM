package org.eclipse.docker.language.ui;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.docker.language.DockerConfig;
import org.eclipse.docker.language.StringStateMatch.State;
import org.eclipse.docker.language.TableModel.CData;
import org.eclipse.docker.language.TableModel.TModelSingleton;
import org.eclipse.docker.language.container.ContainerFactory;
import org.eclipse.docker.language.transformation.ContainerTransformation;
import org.eclipse.docker.language.ui.events.DEvent;
import org.eclipse.docker.language.ui.internal.LanguageActivator;
import org.eclipse.docker.language.ui.swt.ResourceManager;
import org.eclipse.docker.language.ui.swt.SWTResourceManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.internal.UILockListener;
import org.eclipse.ui.internal.UISynchronizer;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import com.github.dockerjava.api.DockerClient;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provider;

import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

public class DockerEditor extends XtextEditor {
	public DockerEditor() {

	}

	@Inject
	org.eclipse.docker.language.ui.events.EventsMonitoring monitoring;

	@Inject
	Provider<DockerClient> provider;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;
	@Inject
	private DockerConfig config;

	@Inject
	Provider<ResourceSet> resources;

	@Inject
	private ContainerTransformation transformation;

	private TableViewer tableViewer;

	private volatile String selectedContainer;
	private Text text;

	private Button connect;

	@Override
	public void createPartControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmDockerEditor = formToolkit.createForm(container);
		frmDockerEditor.setImage(ResourceManager.getPluginImage("org.eclipse.docker.language.ui", "icons/docker.jpg"));
		formToolkit.paintBordersFor(frmDockerEditor);
		frmDockerEditor.setText("Docker Editor");

		// Button button = formToolkit.createButton(frmDockerEditor.getBody(),
		// "New Button", SWT.NONE);

		Hyperlink hprlnkNewHyperlink = formToolkit.createHyperlink(frmDockerEditor.getHead(), "configure", SWT.NONE);
		// Hyperlink hprlnkNewHyperlink2 =
		// formToolkit.createHyperlink(frmDockerEditor.getHead(), "configure2",
		// SWT.NONE);
		frmDockerEditor.setHeadClient(hprlnkNewHyperlink);
		formToolkit.paintBordersFor(hprlnkNewHyperlink);
		frmDockerEditor.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));
		hprlnkNewHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				ConfigurationDialog d = new ConfigurationDialog(Display.getCurrent().getActiveShell(), config);
				d.create();
				d.open();
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		Section sctnNewSection = formToolkit.createSection(frmDockerEditor.getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("");
		sctnNewSection.setExpanded(true);

		connect = formToolkit.createButton(sctnNewSection, "Connect", SWT.NONE);
		connect.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		connect.setImage(ResourceManager.getPluginImage("org.eclipse.docker.language.ui", "icons/docker.jpg"));
		sctnNewSection.setTextClient(connect);
		connect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				try {
					provider.get().pingCmd().exec();
				} catch (Exception e1) {
					System.out.println("cannot connect");

					MessageDialog.openError(Display.getCurrent().getActiveShell(), " Cannot connect to host Error",
							"please enter a valid Host address which has a running Docker instance");
					return;
				}
				TModelSingleton model = transformation.transform();
				tableViewer.setInput(model.getEntries());
				tableViewer.refresh();

				monitoring.monitor();

				super.widgetSelected(e);
			}
		});

		Composite composite = formToolkit.createComposite(sctnNewSection, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new FormLayout());

		Section sctnNewSection_2 = formToolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnNewSection_2 = new FormData();
		fd_sctnNewSection_2.bottom = new FormAttachment(100, -15);
		fd_sctnNewSection_2.right = new FormAttachment(100, -621);
		fd_sctnNewSection_2.top = new FormAttachment(1);
		fd_sctnNewSection_2.left = new FormAttachment(0);
		sctnNewSection_2.setLayoutData(fd_sctnNewSection_2);
		System.out.println(getPartProperties().keySet().toString());
		formToolkit.paintBordersFor(sctnNewSection_2);
		sctnNewSection_2.setExpanded(true);

		Composite composite_2 = formToolkit.createComposite(sctnNewSection_2, SWT.NO_REDRAW_RESIZE);
		formToolkit.paintBordersFor(composite_2);
		sctnNewSection_2.setClient(composite_2);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));

		// super.createPartControl(composite_2);

		Section sctnNewSection_1 = formToolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnNewSection_1 = new FormData();
		fd_sctnNewSection_1.top = new FormAttachment(sctnNewSection_2, 0, SWT.TOP);
		fd_sctnNewSection_1.left = new FormAttachment(sctnNewSection_2, 6);
		fd_sctnNewSection_1.right = new FormAttachment(100);
		fd_sctnNewSection_1.bottom = new FormAttachment(100, -6);
		sctnNewSection_1.setLayoutData(fd_sctnNewSection_1);
		formToolkit.paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setExpanded(true);

		Composite composite_1 = formToolkit.createComposite(sctnNewSection_1, SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnNewSection_1.setClient(composite_1);
		composite_1.setLayout(new FormLayout());

		tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(100, -10);
		fd_table.left = new FormAttachment(0);
		fd_table.right = new FormAttachment(0, 603);
		table.setLayoutData(fd_table);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		table.setBackgroundMode(SWT.INHERIT_DEFAULT);
		table.setCapture(true);
		table.setLayoutDeferred(true);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		formToolkit.paintBordersFor(table);
		Menu contextMenu = new Menu(table);
		table.setMenu(contextMenu);
		MenuItem mItem1 = new MenuItem(contextMenu, SWT.None);
		mItem1.setText("Open Container monitoring");
		mItem1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {

					if (config.getUri() == null) {
						ConfigurationDialog d = new ConfigurationDialog(Display.getCurrent().getActiveShell(), config);
						d.create();
						d.open();
					}
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					activePage.hideView(
							activePage.findViewReference("org.eclipse.docker.monitoring.view", selectedContainer));
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.showView("org.eclipse.docker.monitoring.view", selectedContainer, 1);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.widgetSelected(e);
			}
		});
		table.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				TableItem[] selection = table.getSelection();
				if (selection.length != 0 && (event.button == 3)) {
					contextMenu.setVisible(true);
					selectedContainer = selection[0].getText();

				}

			}

		});

		tableViewer.setContentProvider(new ArrayContentProvider());

		TableViewerColumn containerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnCol = containerColumn.getColumn();
		tblclmnCol.setImage(ResourceManager.getPluginImage("org.eclipse.docker.language.ui", "icons/docker.jpg"));
		tblclmnCol.setMoveable(true);
		tblclmnCol.setWidth(350);
		tblclmnCol.setText("containers");
		containerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof CData) {
					CData data = (CData) element;
					return data.getName();
				} else if (element instanceof String) {

					Iterable<String> split = Splitter.on("@").split(element.toString());
					return Lists.newArrayList(split).get(0).toString();
				}
				return "";
			}
		});

		TableViewerColumn statusColumn = new TableViewerColumn(tableViewer, SWT.CENTER);
		TableColumn tblclmnCol_1 = statusColumn.getColumn();
		tblclmnCol_1.setWidth(150);
		tblclmnCol_1.setText("status");
		statusColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof CData) {
					CData data = (CData) element;
					return data.getStatus();
				} else if (element instanceof String) {

					Iterable<String> split = Splitter.on("@").split(element.toString());
					return Lists.newArrayList(split).get(1).toString();
				}
				return "";
			}
		});

		text = new Text(composite_1, SWT.BORDER);
		fd_table.top = new FormAttachment(text, 6);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(table, 0, SWT.RIGHT);
		fd_text.top = new FormAttachment(0);
		fd_text.left = new FormAttachment(0);
		text.setLayoutData(fd_text);
		formToolkit.adapt(text, true, true);

		ContainerFilter filter = new ContainerFilter();
		tableViewer.setFilters(new ViewerFilter[] { filter });
		text.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					filter.setSearchName(text.getText());
					tableViewer.refresh();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Button clear = new Button(sctnNewSection_1, SWT.NONE);
		clear.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/dlcl16/removeall.png"));
		formToolkit.adapt(clear, true, true);
		sctnNewSection_1.setTextClient(clear);
		clear.setText("clear");
		clear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TModelSingleton.getModel().getEntries().clear();
				tableViewer.setInput(null);
				tableViewer.refresh();
				// monitoring.stopMonitoring();
				super.widgetSelected(e);
			}
		});
		tableViewer.setInput(TModelSingleton.getModel().getEntries());
		tableViewer.refresh();
		EventHandler handler = new EventHandler() {

			@Override
			public void handleEvent(org.osgi.service.event.Event event) {
				System.out.println("received");
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Display.getDefault().syncExec(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								TModelSingleton model = transformation.transform();
								tableViewer.setInput(model.getEntries());
								tableViewer.refresh();

							}
						});
					}
				}).start();
				;

			}
		};
		Dictionary<String, String> d = new Hashtable<>();
		d.put(EventConstants.EVENT_TOPIC, "state");
		LanguageActivator.getInstance().getBundle().getBundleContext().registerService(EventHandler.class, handler, d);

		super.createPartControl(composite_2);

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		DockerPreferenceManager.loadData(this);
		super.init(site, input);
	}

	class ContainerFilter extends ViewerFilter {
		private String searchName;

		public String getSearchName() {
			return searchName;
		}

		public void setSearchName(String searchName) {
			this.searchName = searchName;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof CData && searchName != null && !searchName.isEmpty()) {
				CData data = (CData) element;

				if (data.getName().contains(searchName)) {
					return true;
				} else {
					return false;
				}
			}
			return true;

		}

	}

}
