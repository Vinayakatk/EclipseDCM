package org.eclipse.docker.language.ui.events;

import com.google.common.base.Objects;

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
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(value, "start")) {
        _matched=true;
        return StringStateMatch.State.start;
      }
    }
    if (!_matched) {
      if (Objects.equal(value, "pause")) {
        _matched=true;
        return StringStateMatch.State.pause;
      }
    }
    if (!_matched) {
      if (Objects.equal(value, "unpause")) {
        _matched=true;
        return StringStateMatch.State.unpause;
      }
    }
    if (!_matched) {
      if (Objects.equal(value, "destroy")) {
        _matched=true;
        return StringStateMatch.State.destroy;
      }
    }
    if (!_matched) {
      if (Objects.equal(value, "stop")) {
        _matched=true;
        return StringStateMatch.State.stop;
      }
    }
    if (!_matched) {
      if (Objects.equal(value, "create")) {
        _matched=true;
        return StringStateMatch.State.create;
      }
    }
    if (!_matched) {
      if (Objects.equal(value, null)) {
        _matched=true;
        return StringStateMatch.State.none;
      }
    }
    return null;
  }
}
