package org.eclipse.docker.monitoring.view;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.event.HyperlinkListener;

import org.eclipse.docker.language.DockerConfig;
import org.eclipse.docker.language.ui.ConfigurationDialog;
import org.eclipse.docker.language.ui.internal.LanguageActivator;
import org.eclipse.docker.language.util.ContainerUtil;
import org.eclipse.docker.monitoring.ContainerStatsCallback;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Statistics;
import com.github.dockerjava.core.async.ResultCallbackTemplate;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swt.FXCanvas;

public class MonitorView extends ViewPart {

	// public static final String ID = "org.eclipse.docker.language.ui.llll";
	private EventBus bus;
	// //$NON-NLS-1$
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private String containerName;
	private DockerClient dockerClient;

	private DockerConfig config;

	public MonitorView() {

	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) { 
		if (containerName != null && config.getUri() != null) {
			
			try {
				dockerClient.pingCmd().exec();
			} catch (Exception e) {
				System.out.println("cannot connect");
				
				Label lblNoDockerRunning = new Label(parent, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
				lblNoDockerRunning.setImage(null);
				lblNoDockerRunning.setForeground(new Color(Display.getCurrent(), 255,0,0));
				lblNoDockerRunning.setBounds(10, 31, 418, 137);
				lblNoDockerRunning.setText("docker is not running on selected host ["+config.getUri()+"], \r\nplease select other host address");

				return;
			}
			List<Container> containers = dockerClient.listContainersCmd().withShowAll(true).exec();
			boolean exists = IterableExtensions.exists(containers, new Functions.Function1<Container, Boolean>() {
			@Override
			public Boolean apply(Container p) {
				
				String name = ContainerUtil.getName(p);
				return name.equals(containerName);
			}});
			if(!exists)return;
			InspectContainerResponse exec = dockerClient.inspectContainerCmd(containerName).exec();
			String id = exec.getId();
			System.out.println(id);
			ResultCallbackTemplate<ContainerStatsCallback, Statistics> exec2 = dockerClient.statsCmd().withContainerId(id)
					.exec(new ContainerStatsCallback(containerName));

			try {
				exec2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			Composite container = new Composite(parent, SWT.NONE);
			container.setLayout(new FillLayout(SWT.HORIZONTAL));

			ScrolledForm scrldfrmNewScrolledform = formToolkit.createScrolledForm(container);
			formToolkit.paintBordersFor(scrldfrmNewScrolledform);
			scrldfrmNewScrolledform.setText(containerName+" ["+config.getUri()+']');
			scrldfrmNewScrolledform.getBody().setLayout(new FormLayout());

			Section sctnNewSection = formToolkit.createSection(scrldfrmNewScrolledform.getBody(),
					Section.TWISTIE | Section.TITLE_BAR);
			FormData fd_sctnNewSection = new FormData();
			fd_sctnNewSection.bottom = new FormAttachment(51);
			fd_sctnNewSection.top = new FormAttachment(0, 21);
			fd_sctnNewSection.left = new FormAttachment(0, 10);
			sctnNewSection.setLayoutData(fd_sctnNewSection);
			formToolkit.paintBordersFor(sctnNewSection);
			sctnNewSection.setText("cpu utilization");
			sctnNewSection.setExpanded(true);

			Section sctnNewSection_1 = formToolkit.createSection(scrldfrmNewScrolledform.getBody(),
					Section.TWISTIE | Section.TITLE_BAR);
			FormData fd_sctnNewSection_1 = new FormData();
			fd_sctnNewSection_1.top = new FormAttachment(0, 21);
			fd_sctnNewSection_1.right = new FormAttachment(100, -36);
			fd_sctnNewSection_1.left = new FormAttachment(49, 22);
			sctnNewSection_1.setLayoutData(fd_sctnNewSection_1);
			formToolkit.paintBordersFor(sctnNewSection_1);
			sctnNewSection_1.setText("network utilization");
			sctnNewSection_1.setExpanded(true);

			Section sctnNewSection_2 = formToolkit.createSection(scrldfrmNewScrolledform.getBody(),
					Section.TWISTIE | Section.TITLE_BAR);
			fd_sctnNewSection.right = new FormAttachment(sctnNewSection_2, 0, SWT.RIGHT);
			FormData fd_sctnNewSection_2 = new FormData();
			fd_sctnNewSection_2.top = new FormAttachment(sctnNewSection, 42);
			fd_sctnNewSection_2.bottom = new FormAttachment(100, -18);
			fd_sctnNewSection_2.left = new FormAttachment(0, 10);

			Composite composite = formToolkit.createComposite(sctnNewSection, SWT.NONE);
			formToolkit.paintBordersFor(composite);
			sctnNewSection.setClient(composite);
			composite.setLayout(new FillLayout(SWT.HORIZONTAL));
			sctnNewSection_2.setLayoutData(fd_sctnNewSection_2);
			formToolkit.paintBordersFor(sctnNewSection_2);
			sctnNewSection_2.setText("memory utilization");
			sctnNewSection_2.setExpanded(true);

			Section sctnNewSection_3 = formToolkit.createSection(scrldfrmNewScrolledform.getBody(),
					Section.TWISTIE | Section.TITLE_BAR);
			fd_sctnNewSection_2.right = new FormAttachment(sctnNewSection_3, -50);
			fd_sctnNewSection_1.bottom = new FormAttachment(sctnNewSection_3, -48);
			FormData fd_sctnNewSection_3 = new FormData();
			fd_sctnNewSection_3.right = new FormAttachment(sctnNewSection_1, 0, SWT.RIGHT);
			fd_sctnNewSection_3.left = new FormAttachment(sctnNewSection_1, 0, SWT.LEFT);
			fd_sctnNewSection_3.top = new FormAttachment(sctnNewSection_2, 0, SWT.TOP);

			Composite composite_2 = formToolkit.createComposite(sctnNewSection_1, SWT.NONE);
			formToolkit.paintBordersFor(composite_2);
			sctnNewSection_1.setClient(composite_2);
			composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
			fd_sctnNewSection_3.bottom = new FormAttachment(100, -15);

			Composite composite_1 = formToolkit.createComposite(sctnNewSection_2, SWT.NONE);
			formToolkit.paintBordersFor(composite_1);
			sctnNewSection_2.setClient(composite_1);
			composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
			sctnNewSection_3.setLayoutData(fd_sctnNewSection_3);
			formToolkit.paintBordersFor(sctnNewSection_3);
			sctnNewSection_3.setText("io utilization");
			sctnNewSection_3.setExpanded(true);

			Composite composite_3 = formToolkit.createComposite(sctnNewSection_3, SWT.NONE);
			formToolkit.paintBordersFor(composite_3);
			sctnNewSection_3.setClient(composite_3);
			composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
			Platform.setImplicitExit(false);
		
			FXCanvas c = new FXCanvas(composite, SWT.NONE);

			CpuMonitorChart c1 = new CpuMonitorChart(bus,containerName);
			try {
				c1.start(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MemoryMonitoringChart c2 = new MemoryMonitoringChart(bus,containerName);
			try {
				c2.start(new FXCanvas(composite_1, SWT.NONE));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NetworkMonitoringChart c3 = new NetworkMonitoringChart(bus,containerName);
			try {
				c3.start(new FXCanvas(composite_2, SWT.NONE));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			IOMonitoringChart c4 = new IOMonitoringChart(bus,containerName);
			try {
				c4.start(new FXCanvas(composite_3, SWT.NONE));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void setFocus() {

	}

	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		String secondaryId = site.getSecondaryId();
		Injector injector = LanguageActivator.getInstance()
				.getInjector(LanguageActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
		bus = injector.getInstance(EventBus.class);
		bus.register(this);
		Provider<DockerClient> provider = injector.getProvider(DockerClient.class);
		dockerClient = provider.get();

		containerName = secondaryId;
		config = injector.getInstance(DockerConfig.class);
		super.init(site, memento);
	}

}
