package org.eclipse.docker.language;

@SuppressWarnings("all")
public class StringStateMatch {
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
    
    kill;
  }
  
  public static StringStateMatch.State state(final String value) {
    switch (value) {
      case "start":
        return StringStateMatch.State.start;
      case "killdie":
        return StringStateMatch.State.kill;
      case "restart":
        return StringStateMatch.State.restart;
      case "pause":
        return StringStateMatch.State.pause;
      case "unpause":
        return StringStateMatch.State.unpause;
      case "destroy":
        return StringStateMatch.State.destroy;
      case "killkilldiestop":
        return StringStateMatch.State.stop;
      case "die":
        return StringStateMatch.State.die;
      case "create":
        return StringStateMatch.State.create;
      case "resizeattach":
        return StringStateMatch.State.none;
      case "attachstartresize":
        return StringStateMatch.State.none;
      default:
        return null;
    }
  }
}
