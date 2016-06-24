package org.eclipse.docker.language.util


import org.eclipse.docker.language.container.ContainerFactory
import com.github.dockerjava.api.model.Container

class DockerTransformation {
	def create it: ContainerFactory.eINSTANCE.createContainer() toContainer(Container container){
		it.name = container.names.head.replaceFirst("/","")
	}
}