package org.eclipse.docker.monitoring;

@SuppressWarnings("all")
public class NetworkMonitoring {
  private int transmit;
  
  private int receive;
  
  public int setTransmit(final int value) {
    return this.transmit = value;
  }
  
  public int getTransmit() {
    return this.transmit;
  }
  
  public int setReceive(final int value) {
    return this.receive = value;
  }
  
  public int getReceive() {
    return this.receive;
  }
}
