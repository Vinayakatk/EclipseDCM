package org.eclipse.docker.monitoring.events

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.docker.monitoring.IOMonitoring
 
@Accessors
class IOEvent {
	String name
	IOMonitoring ioMonitoring
}