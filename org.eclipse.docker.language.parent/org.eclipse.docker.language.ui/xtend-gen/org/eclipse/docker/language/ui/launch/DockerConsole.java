package org.eclipse.docker.language.ui.launch;

import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class DockerConsole {
  @Accessors
  private MessageConsoleStream str = null;
  
  public DockerConsole() {
  }
  
  public void write(final String text) {
    try {
      this.str.println(text);
      this.str.flush();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public MessageConsoleStream getStr() {
    return this.str;
  }
  
  public void setStr(final MessageConsoleStream str) {
    this.str = str;
  }
}
