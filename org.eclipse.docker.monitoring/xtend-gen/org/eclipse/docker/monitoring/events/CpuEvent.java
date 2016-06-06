package org.eclipse.docker.monitoring.events;

import org.eclipse.docker.monitoring.CPUMonitoring;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class CpuEvent {
  private String name;
  
  private CPUMonitoring monitoring;
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public CPUMonitoring getMonitoring() {
    return this.monitoring;
  }
  
  public void setMonitoring(final CPUMonitoring monitoring) {
    this.monitoring = monitoring;
  }
}
