package org.eclipse.docker.monitoring;

@SuppressWarnings("all")
public class MemoryMonitoring {
  private int limit;
  
  public int setLimit(final int value) {
    return this.limit = value;
  }
  
  public int getLimit() {
    return this.limit;
  }
  
  private int utilized;
  
  public int setUtilized(final int value) {
    return this.utilized = value;
  }
  
  public int getUtilized() {
    return this.utilized;
  }
  
  private float perc;
  
  public float setPerc(final float value) {
    return this.perc = value;
  }
  
  public float getPerc() {
    return this.perc;
  }
}
