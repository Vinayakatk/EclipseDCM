package org.eclipse.docker.monitoring.events

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.docker.monitoring.CPUMonitoring
 
@Accessors
class CpuEvent {
	String name
	CPUMonitoring monitoring
}