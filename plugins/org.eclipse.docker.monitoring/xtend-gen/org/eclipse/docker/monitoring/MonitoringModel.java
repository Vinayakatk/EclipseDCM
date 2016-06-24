package org.eclipse.docker.monitoring;

import org.eclipse.docker.monitoring.CPUMonitoring;
import org.eclipse.docker.monitoring.IOMonitoring;
import org.eclipse.docker.monitoring.MemoryMonitoring;
import org.eclipse.docker.monitoring.NetworkMonitoring;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class MonitoringModel {
  private CPUMonitoring cpu;
  
  private MemoryMonitoring memory;
  
  private NetworkMonitoring network;
  
  private IOMonitoring io;
  
  public MonitoringModel() {
    this.createModels();
  }
  
  public IOMonitoring createModels() {
    IOMonitoring _xblockexpression = null;
    {
      CPUMonitoring _cPUMonitoring = new CPUMonitoring();
      this.cpu = _cPUMonitoring;
      MemoryMonitoring _memoryMonitoring = new MemoryMonitoring();
      this.memory = _memoryMonitoring;
      NetworkMonitoring _networkMonitoring = new NetworkMonitoring();
      this.network = _networkMonitoring;
      IOMonitoring _iOMonitoring = new IOMonitoring();
      _xblockexpression = this.io = _iOMonitoring;
    }
    return _xblockexpression;
  }
  
  @Pure
  public CPUMonitoring getCpu() {
    return this.cpu;
  }
  
  public void setCpu(final CPUMonitoring cpu) {
    this.cpu = cpu;
  }
  
  @Pure
  public MemoryMonitoring getMemory() {
    return this.memory;
  }
  
  public void setMemory(final MemoryMonitoring memory) {
    this.memory = memory;
  }
  
  @Pure
  public NetworkMonitoring getNetwork() {
    return this.network;
  }
  
  public void setNetwork(final NetworkMonitoring network) {
    this.network = network;
  }
  
  @Pure
  public IOMonitoring getIo() {
    return this.io;
  }
  
  public void setIo(final IOMonitoring io) {
    this.io = io;
  }
}
