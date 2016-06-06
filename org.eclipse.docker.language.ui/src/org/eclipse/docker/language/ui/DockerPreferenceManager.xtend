package org.eclipse.docker.language.ui

import java.util.HashSet
import org.eclipse.core.runtime.preferences.ConfigurationScope
import org.eclipse.core.runtime.preferences.IEclipsePreferences
import org.eclipse.docker.language.DockerConfig
import org.eclipse.docker.language.TableModel.CData
import org.eclipse.docker.language.TableModel.TModel
import org.eclipse.docker.language.TableModel.TableModelFactory
import org.eclipse.docker.language.ui.internal.ContainerActivator
import org.eclipse.emf.common.util.EList
import org.osgi.service.prefs.BackingStoreException
import org.osgi.service.prefs.Preferences
import com.google.common.base.Joiner
import com.google.common.base.Splitter
import com.google.common.collect.Sets
import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.docker.language.TableModel.TModelSingleton
import java.util.List

class DockerPreferenceManager {
	static String PLUGIN_ID = "org.eclipse.docker.language.ui"

	def static void saveData() {
		try {
			var IEclipsePreferences node = ConfigurationScope.INSTANCE.getNode(PLUGIN_ID)
			var Preferences host = node.node("host")
			var String joinedHosts = Joiner.on("#").join(Hosts.getInstance().getHosts())
			host.put("hosts", joinedHosts)
			
			var DockerConfig config = ContainerActivator.getInstance().getInjector(
				ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER).getInstance(DockerConfig)
			var String certPath = config.getDockerCertPath()
			host.put("certPath", certPath)
			host.put("currentHost",config.uri)
			var instancePref = InstanceScope.INSTANCE.getNode(PLUGIN_ID)
			var table = instancePref.node("table")
			var TModelSingleton tmodel = TModelSingleton.model
			var List<CData> entries = tmodel.getEntries()
			var entriesString = Joiner.on("#").join(entries.map['''«name»@«status»'''])
			table.put("entries", entriesString)
			node.flush()
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace()
		}

	}

	def static void loadData(DockerEditor editor) {
		var IEclipsePreferences node = ConfigurationScope.INSTANCE.getNode(PLUGIN_ID)
		var Preferences host = node.node("host")
		if (host !== null) {
			var String sequence = host.get("hosts", null)
			if (sequence !== null && !sequence.isEmpty()) {
				var Iterable<String> splittedHosts = Splitter.on("#").split(sequence)
				var HashSet<String> hosts = Sets.newHashSet(splittedHosts)
				Hosts.getInstance().setHosts(hosts)
			}
		
			var DockerConfig config = ContainerActivator.getInstance().getInjector(
				ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER).getInstance(DockerConfig)
			var String certPath = host.get("certPath", null)
			if(certPath !== null && !certPath.isEmpty()) config.setDockerCertPath(certPath)
			var current = host.get("currentHost",null)
			if(current!=null){
				
				config.uri = current
				
			}
		}
		var instancePref = InstanceScope.INSTANCE.getNode(PLUGIN_ID)
		var table = instancePref.node("table")
		if (table != null) {
			var entriesString = table.get("entries", null)
			if (entriesString != null && !entriesString.isEmpty) {
				var entries = Splitter.on("#").split(entriesString)
				var list = entries.toList
				var datas = new ReverseTransformation().transform(list)
				TModelSingleton.model.entries.clear
				TModelSingleton.model.entries+=datas
			}
		}
	}

	
}
