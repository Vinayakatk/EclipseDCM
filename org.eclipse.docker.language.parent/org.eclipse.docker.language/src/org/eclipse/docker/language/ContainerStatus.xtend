package org.eclipse.docker.language

import org.eclipse.docker.language.container.Container
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ContainerStatus {
	private Container container
	private String status
}