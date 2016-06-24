package org.eclipse.docker.language

import java.util.List

class StringStateMatch {
	def static state(String value) {
		switch (value) {
			case "start": {
				return State.start
			}
			case "killdie": {
				return State.kill
			}
			case "restart": {
				return State.restart
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
			case "killkilldiestop": {
				return State.stop
			}
			case "die": {
				return State.die
			}
			case "create": {
				return State.create
			}
			case "resizeattach": {
				return State.none
			}
			case "attachstartresize": {
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
