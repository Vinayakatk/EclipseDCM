package org.eclipse.docker.language.util

import java.util.List

class ContainerTool {
	private static ContainerTool tool
	private var List<String> runningContainers
	private var List<String> defined
	
	
	
	def static getTool(){
		if(tool==null){
			tool= new ContainerTool
		}
		else tool
	}
	
	def addContainer(String name){
		if(runningContainers==null) runningContainers = newArrayList()
		runningContainers.add(name)
	}
	
	def isToolLaunchedContainer(String name){
		runningContainers.contains(name)
	}
}