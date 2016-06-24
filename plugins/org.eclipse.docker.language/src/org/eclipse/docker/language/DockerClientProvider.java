package org.eclipse.docker.language;

import java.io.File;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;


public class DockerClientProvider implements Provider<DockerClient>{

	@Inject
	private DockerConfig config;
	@Override
	public DockerClient get() {
		System.out.println(config);
		 DockerClientConfig dockerClientConfig = DockerClientConfig.createDefaultConfigBuilder().
				 
				withDockerCertPath(config.getDockerCertPath()).withUri("https://"+config.getUri()).build();
		
			DockerClient dockerClient = DockerClientBuilder.getInstance(dockerClientConfig).build();
		
			
		return dockerClient;
	}

}
