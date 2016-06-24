package org.eclipse.docker.monitoring.events

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.docker.monitoring.NetworkMonitoring
 
@Accessors
class NetworkEvent {
	String name
	NetworkMonitoring networkMonitoring
}