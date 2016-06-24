package org.eclipse.docker.monitoring.events;

import org.eclipse.docker.monitoring.MemoryMonitoring;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class MemoryEvent {
  private String name;
  
  private MemoryMonitoring memoryMonitoring;
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public MemoryMonitoring getMemoryMonitoring() {
    return this.memoryMonitoring;
  }
  
  public void setMemoryMonitoring(final MemoryMonitoring memoryMonitoring) {
    this.memoryMonitoring = memoryMonitoring;
  }
}
