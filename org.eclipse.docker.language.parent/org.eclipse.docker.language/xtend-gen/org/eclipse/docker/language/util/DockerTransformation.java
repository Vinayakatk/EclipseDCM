package org.eclipse.docker.language.util;

import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.docker.language.container.Container;
import org.eclipse.docker.language.container.ContainerFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DockerTransformation {
  public Container toContainer(final com.github.dockerjava.api.model.Container container) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(container);
    final Container _result;
    synchronized (_createCache_toContainer) {
      if (_createCache_toContainer.containsKey(_cacheKey)) {
        return _createCache_toContainer.get(_cacheKey);
      }
      Container _createContainer = ContainerFactory.eINSTANCE.createContainer();
      _result = _createContainer;
      _createCache_toContainer.put(_cacheKey, _result);
    }
    _init_toContainer(_result, container);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Container> _createCache_toContainer = CollectionLiterals.newHashMap();
  
  private void _init_toContainer(final Container it, final com.github.dockerjava.api.model.Container container) {
    String[] _names = container.getNames();
    String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_names)));
    String _replaceFirst = _head.replaceFirst("/", "");
    it.setName(_replaceFirst);
  }
}
