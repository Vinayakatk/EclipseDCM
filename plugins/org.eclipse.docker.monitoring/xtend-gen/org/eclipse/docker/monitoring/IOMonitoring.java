package org.eclipse.docker.monitoring;

@SuppressWarnings("all")
public class IOMonitoring {
  private int read;
  
  public int setRead(final int value) {
    return this.read = value;
  }
  
  public int getRead() {
    return this.read;
  }
  
  private int write;
  
  public int setWrite(final int value) {
    return this.write = value;
  }
  
  public int getWrite() {
    return this.write;
  }
}
