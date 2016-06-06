package org.eclipse.docker.language

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.docker.language.container.Container

interface DockerInterpreter {
	def void interpret(Resource resource);
	
}