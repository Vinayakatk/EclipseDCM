package org.eclipse.docker.monitoring;

import org.eclipse.docker.monitoring.MonitoringModel;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class StatsCallback {
  private MonitoringModel model;
  
  private long prevcpu;
  
  private float prevsyscpu;
  
  private float prevPerc;
  
  private float preMemUsage;
  
  private int prerx;
  
  private int pretx;
  
  private int preread;
  
  private int prewrite;
  
  public StatsCallback(final MonitoringModel model, final int prevcpu, final float prevsyscpu, final float prevPerc, final float preMemUsage, final int prerx, final int pretx, final int preread, final int prewrite) {
    this.model = model;
    this.prevcpu = prevcpu;
    this.prevsyscpu = prevsyscpu;
    this.prevPerc = prevPerc;
    this.preMemUsage = preMemUsage;
    this.prerx = prerx;
    this.pretx = pretx;
    this.preread = preread;
    this.prewrite = prewrite;
  }
  
  @Pure
  public MonitoringModel getModel() {
    return this.model;
  }
  
  public void setModel(final MonitoringModel model) {
    this.model = model;
  }
  
  @Pure
  public long getPrevcpu() {
    return this.prevcpu;
  }
  
  public void setPrevcpu(final long prevcpu) {
    this.prevcpu = prevcpu;
  }
  
  @Pure
  public float getPrevsyscpu() {
    return this.prevsyscpu;
  }
  
  public void setPrevsyscpu(final float prevsyscpu) {
    this.prevsyscpu = prevsyscpu;
  }
  
  @Pure
  public float getPrevPerc() {
    return this.prevPerc;
  }
  
  public void setPrevPerc(final float prevPerc) {
    this.prevPerc = prevPerc;
  }
  
  @Pure
  public float getPreMemUsage() {
    return this.preMemUsage;
  }
  
  public void setPreMemUsage(final float preMemUsage) {
    this.preMemUsage = preMemUsage;
  }
  
  @Pure
  public int getPrerx() {
    return this.prerx;
  }
  
  public void setPrerx(final int prerx) {
    this.prerx = prerx;
  }
  
  @Pure
  public int getPretx() {
    return this.pretx;
  }
  
  public void setPretx(final int pretx) {
    this.pretx = pretx;
  }
  
  @Pure
  public int getPreread() {
    return this.preread;
  }
  
  public void setPreread(final int preread) {
    this.preread = preread;
  }
  
  @Pure
  public int getPrewrite() {
    return this.prewrite;
  }
  
  public void setPrewrite(final int prewrite) {
    this.prewrite = prewrite;
  }
}
