package org.eclipse.docker.language.transformation

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.model.Container
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.docker.language.TableModel.TableModelFactory
import org.eclipse.docker.language.TableModel.TModelSingleton
import java.util.Map
import com.google.inject.Singleton
import com.google.common.collect.Maps
import org.eclipse.xtend.lib.annotations.Accessors

@Singleton
class ContainerTransformation {
	@Accessors
	private Map<String,String> idToName
	
	public static volatile Boolean changed = true;
	DockerClient dockerClient
	
	@Inject
	Provider<DockerClient> provider
	
	new (){
		idToName = Maps.newHashMap
	}
	def transform(){
		idToName.clear
		dockerClient = provider.get
		val list = dockerClient.listContainersCmd.withShowAll(true).exec
		var datas = list.map[toCData]
		var model = TModelSingleton.model
		model.entries.clear
		model.entries+=datas
		model
	}
	
	def create x : TableModelFactory.eINSTANCE.createCData toCData(Container container){
		x.name=container.names.head.substring(1,container.names.head.length)
		idToName.put(container.id,x.name)
		x.status=container.status
		
	}   
}