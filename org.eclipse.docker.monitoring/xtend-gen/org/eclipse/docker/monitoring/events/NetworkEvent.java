package org.eclipse.docker.monitoring.events;

import org.eclipse.docker.monitoring.NetworkMonitoring;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class NetworkEvent {
  private String name;
  
  private NetworkMonitoring networkMonitoring;
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public NetworkMonitoring getNetworkMonitoring() {
    return this.networkMonitoring;
  }
  
  public void setNetworkMonitoring(final NetworkMonitoring networkMonitoring) {
    this.networkMonitoring = networkMonitoring;
  }
}
