package org.eclipse.docker.language.ui

import java.beans.PropertyChangeEvent
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

class Hosts {
//	private PropertyChangeSupport support = new PropertyChangeSupport(this)
	@Accessors
	private Set<String> hosts
	private static Hosts SingletonHosts

	def static getInstance() {
		if(SingletonHosts == null) SingletonHosts = new Hosts => [hosts = newHashSet()]
		SingletonHosts
	}

}
