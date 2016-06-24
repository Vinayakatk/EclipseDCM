package org.eclipse.docker.language.ui.events;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.eclipse.docker.language.ui.events.StringStateMatch.State;
import org.eclipse.docker.language.ui.internal.LanguageActivator;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.EventAdmin;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Event;
import com.github.dockerjava.core.command.EventsResultCallback;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class EventsMonitoring {
	private EventsResultCallback callBack;
	private DockerClient dockerClient;
	public EventsMonitoring() {
	

		
	}
	public void monitor() {
		Display.getCurrent().asyncExec(new Runnable() {
			
			@Override
			public void run() {
			
		Thread thread = new Thread(new Runnable() {
			
			

			@Override
			public void run() {
				// TODO Auto-generated constructor stub
				// TODO Auto-generated method stub
				Injector injector = LanguageActivator.getInstance()
						.getInjector(LanguageActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
				Provider<DockerClient> provider = injector.getProvider(DockerClient.class);
				
			
						
						
				dockerClient = provider.get();
				injector.getInstance(EventBus.class);
				
			
				callBack = dockerClient.eventsCmd().exec(new EventsResultCallback() {
					
					@Override
					public void onNext(Event item) {
						if (item != null && item.getStatus()!=null && item.getId()!=null){
							
							State state = StringStateMatch.state(item.getStatus());
							System.out.println(state);
							
							if(state!=null){
								System.out.println("posting");
								ServiceReference<EventAdmin> serviceReference = LanguageActivator.getInstance().getBundle().getBundleContext().getServiceReference(EventAdmin.class);
								if (serviceReference!=null) {
									EventAdmin service = LanguageActivator.getInstance().getBundle().getBundleContext().getService(serviceReference);
									HashMap<String, Object> newHashMap = Maps.newHashMap();
									service.postEvent(new org.osgi.service.event.Event("state", newHashMap));
								}
							}
						}
						super.onNext(item);
					}

					@Override
					public void onStart(Closeable stream) {
						System.out.println("started");
						super.onStart(stream);
					}

					@Override
					public void onComplete() {
						System.out.println("complete");
					}

					@Override
					public void onError(Throwable arg0) {
						try {
							throw arg0;
						} catch (Throwable e) {
							e.printStackTrace();
						}
					}
				});
				try {
					callBack.awaitCompletion(999999999, TimeUnit.DAYS);

				} catch (InterruptedException e) {

					e.printStackTrace();	
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		// TODO Auto-generated method stub
		
			}
		});
		
	}
	public void stopMonitoring(){
		try {
			callBack.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
