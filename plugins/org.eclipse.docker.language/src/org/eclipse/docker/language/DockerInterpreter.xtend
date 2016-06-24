package org.eclipse.docker.language

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.docker.language.container.Container

interface DockerInterpreter {
	def void interpret(Resource resource);
	def void setRun(Boolean value)
	def void setBuild(Boolean value)
	
}