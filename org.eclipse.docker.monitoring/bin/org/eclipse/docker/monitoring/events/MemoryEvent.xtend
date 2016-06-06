package org.eclipse.docker.monitoring.events

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.docker.monitoring.MemoryMonitoring

@Accessors
class MemoryEvent {
	String name
	 MemoryMonitoring memoryMonitoring
}