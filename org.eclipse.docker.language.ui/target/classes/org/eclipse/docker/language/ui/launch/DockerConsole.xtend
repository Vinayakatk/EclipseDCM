package org.eclipse.docker.language.ui.launch

import com.google.inject.Singleton
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsole
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.console.IConsoleConstants
import org.eclipse.ui.console.IConsoleView
import org.eclipse.ui.console.MessageConsoleStream
import org.eclipse.xtend.lib.annotations.Accessors

class DockerConsole {
	@Accessors	
	var MessageConsoleStream str = null
	

	new() {
		
	}

	def void write(String text) {
		
		str.println(text)
		str.flush
	}
}
