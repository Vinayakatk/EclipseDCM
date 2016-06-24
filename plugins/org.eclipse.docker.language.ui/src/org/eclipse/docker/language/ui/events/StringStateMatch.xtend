package org.eclipse.docker.language.ui.events

import java.util.List

class StringStateMatch {
	def static state(String value) {
		switch (value) {
			case "start": {
				return State.start
			}
			
			case "pause": {
				return State.pause
			}
			case "unpause": {
				return State.unpause
			}
			case "destroy": {
				return State.destroy
			}
			case "stop": {
				return State.stop
			}
			
			case "create": {
				return State.create
			}
			case null: {
				return State.none
			}
			default: {
				return null
			}
		}

	}

	public enum State {
		create,
		none,
		start,
		pause,
		unpause,
		destroy,
		stop,
		die,
		restart,
		kill
	}
}
