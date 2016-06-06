package org.eclipse.docker.language.util;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.docker.language.container.Container;
import org.eclipse.docker.language.container.ContainerSection;
import org.eclipse.docker.language.container.Docker;
import org.eclipse.docker.language.util.DockerTransformation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Singleton
@SuppressWarnings("all")
public class ContainerUtil {
  @Inject
  @Extension
  private DockerTransformation _dockerTransformation;
  
  private DockerClient dockerClient;
  
  @Inject
  public ContainerUtil(final Provider<DockerClient> provider) {
    DockerClient _get = provider.get();
    this.dockerClient = _get;
  }
  
  public Object isContainerRuning(final String name) {
    return null;
  }
  
  public Object nameClashes(final String name) {
    return null;
  }
  
  public static Container getContainer(final Docker docker, final String name) {
    ContainerSection _containerRegion = docker.getContainerRegion();
    EList<Container> _containers = _containerRegion.getContainers();
    final Function1<Container, Boolean> _function = (Container it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    return IterableExtensions.<Container>findFirst(_containers, _function);
  }
  
  public List<Container> getRunningContainers() {
    List<Container> _xblockexpression = null;
    {
      ListContainersCmd _listContainersCmd = this.dockerClient.listContainersCmd();
      List<com.github.dockerjava.api.model.Container> containers = _listContainersCmd.exec();
      final Function1<com.github.dockerjava.api.model.Container, Container> _function = (com.github.dockerjava.api.model.Container it) -> {
        return this._dockerTransformation.toContainer(it);
      };
      _xblockexpression = ListExtensions.<com.github.dockerjava.api.model.Container, Container>map(containers, _function);
    }
    return _xblockexpression;
  }
  
  public static String getName(final com.github.dockerjava.api.model.Container container) {
    String[] _names = container.getNames();
    String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_names)));
    String[] _names_1 = container.getNames();
    String _head_1 = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_names_1)));
    int _length = _head_1.length();
    return _head.substring(1, _length);
  }
}
