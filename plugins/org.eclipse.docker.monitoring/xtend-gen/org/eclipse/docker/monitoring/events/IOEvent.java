package org.eclipse.docker.monitoring.events;

import org.eclipse.docker.monitoring.IOMonitoring;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class IOEvent {
  private String name;
  
  private IOMonitoring ioMonitoring;
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public IOMonitoring getIoMonitoring() {
    return this.ioMonitoring;
  }
  
  public void setIoMonitoring(final IOMonitoring ioMonitoring) {
    this.ioMonitoring = ioMonitoring;
  }
}
