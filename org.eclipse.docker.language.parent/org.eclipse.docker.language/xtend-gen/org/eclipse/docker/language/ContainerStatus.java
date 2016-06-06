package org.eclipse.docker.language;

import org.eclipse.docker.language.container.Container;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ContainerStatus {
  private Container container;
  
  private String status;
  
  @Pure
  public Container getContainer() {
    return this.container;
  }
  
  public void setContainer(final Container container) {
    this.container = container;
  }
  
  @Pure
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(final String status) {
    this.status = status;
  }
}
