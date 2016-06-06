package org.eclipse.docker.language.util;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ContainerTool {
  private static ContainerTool tool;
  
  private List<String> runningContainers;
  
  private List<String> defined;
  
  public static ContainerTool getTool() {
    ContainerTool _xifexpression = null;
    boolean _equals = Objects.equal(ContainerTool.tool, null);
    if (_equals) {
      ContainerTool _containerTool = new ContainerTool();
      _xifexpression = ContainerTool.tool = _containerTool;
    } else {
      _xifexpression = ContainerTool.tool;
    }
    return _xifexpression;
  }
  
  public boolean addContainer(final String name) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(this.runningContainers, null);
      if (_equals) {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        this.runningContainers = _newArrayList;
      }
      _xblockexpression = this.runningContainers.add(name);
    }
    return _xblockexpression;
  }
  
  public boolean isToolLaunchedContainer(final String name) {
    return this.runningContainers.contains(name);
  }
}
