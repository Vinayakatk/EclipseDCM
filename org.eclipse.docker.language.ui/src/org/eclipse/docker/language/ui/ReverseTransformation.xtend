package org.eclipse.docker.language.ui

import java.util.List
import org.eclipse.docker.language.TableModel.TableModelFactory
import com.google.common.base.Splitter
import org.eclipse.docker.language.ui.internal.LanguageActivator
import com.google.inject.Injector
import org.eclipse.docker.language.transformation.ContainerTransformation

class ReverseTransformation {
//	var Injector injector
	
//	ContainerTransformation transformation
	
	new() {
//		injector = LanguageActivator.instance.getInjector(LanguageActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER)
//		transformation = injector.getInstance(ContainerTransformation)
	}
	
	def transform(List<String> entries) {
		loadTModel(entries)
	}

	def loadTModel(List<String> entries) {
		entries.map [
			toCData
		]
	}

	def create x : TableModelFactory.eINSTANCE.createCData  toCData(String data) {
		var entries = Splitter.on("@").split(data)
		x.name = entries.get(0)
		x.status=entries.get(1)
//		x.id = entries.get(2)
//		transformation.idToName.put(x.id,x.name)
	}
}
