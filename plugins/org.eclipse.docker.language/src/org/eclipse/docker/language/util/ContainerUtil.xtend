package org.eclipse.docker.language.util

import org.eclipse.docker.language.container.Container
import org.eclipse.docker.language.container.Docker
import com.google.inject.Singleton
import com.google.inject.Inject
import com.google.inject.Provider
import com.github.dockerjava.api.DockerClient

@Singleton
class ContainerUtil {
	@Inject
	private extension DockerTransformation
	
	DockerClient dockerClient
	
	@Inject
	public new(Provider<DockerClient> provider) {
		dockerClient = provider.get
	}
	def isContainerRuning(String name){
		
	}
	def nameClashes(String name){
		
	}
	def static Container getContainer(Docker docker,String name){
		docker.containerRegion.containers.findFirst[it.name==name]
	}
	
	def getRunningContainers(){
		var containers = dockerClient.listContainersCmd.exec
		containers.map[toContainer]
	}
	
	def static getName(com.github.dockerjava.api.model.Container container){
		container.names.head.substring(1,container.names.head.length)
	}
	
	
	
	
}