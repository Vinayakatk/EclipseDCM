package org.eclipse.docker.monitoring;

@SuppressWarnings("all")
public class CPUMonitoring {
  private float percentage;
  
  public float setPercentage(final float value) {
    return this.percentage = value;
  }
  
  public float getPercentage() {
    return this.percentage;
  }
}
