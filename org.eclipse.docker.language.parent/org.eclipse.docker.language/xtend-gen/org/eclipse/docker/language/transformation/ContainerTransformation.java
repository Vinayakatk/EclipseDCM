package org.eclipse.docker.language.transformation;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.Container;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.docker.language.TableModel.CData;
import org.eclipse.docker.language.TableModel.TModelSingleton;
import org.eclipse.docker.language.TableModel.TableModelFactory;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Singleton
@SuppressWarnings("all")
public class ContainerTransformation {
  @Accessors
  private Map<String, String> idToName;
  
  public static volatile Boolean changed = Boolean.valueOf(true);
  
  private DockerClient dockerClient;
  
  @Inject
  private Provider<DockerClient> provider;
  
  public ContainerTransformation() {
    HashMap<String, String> _newHashMap = Maps.<String, String>newHashMap();
    this.idToName = _newHashMap;
  }
  
  public TModelSingleton transform() {
    TModelSingleton _xblockexpression = null;
    {
      this.idToName.clear();
      DockerClient _get = this.provider.get();
      this.dockerClient = _get;
      ListContainersCmd _listContainersCmd = this.dockerClient.listContainersCmd();
      ListContainersCmd _withShowAll = _listContainersCmd.withShowAll(true);
      final List<Container> list = _withShowAll.exec();
      final Function1<Container, CData> _function = (Container it) -> {
        return this.toCData(it);
      };
      List<CData> datas = ListExtensions.<Container, CData>map(list, _function);
      TModelSingleton model = TModelSingleton.getModel();
      List<CData> _entries = model.getEntries();
      _entries.clear();
      List<CData> _entries_1 = model.getEntries();
      Iterables.<CData>addAll(_entries_1, datas);
      _xblockexpression = model;
    }
    return _xblockexpression;
  }
  
  public CData toCData(final Container container) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(container);
    final CData _result;
    synchronized (_createCache_toCData) {
      if (_createCache_toCData.containsKey(_cacheKey)) {
        return _createCache_toCData.get(_cacheKey);
      }
      CData _createCData = TableModelFactory.eINSTANCE.createCData();
      _result = _createCData;
      _createCache_toCData.put(_cacheKey, _result);
    }
    _init_toCData(_result, container);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, CData> _createCache_toCData = CollectionLiterals.newHashMap();
  
  private void _init_toCData(final CData x, final Container container) {
    String[] _names = container.getNames();
    String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_names)));
    String[] _names_1 = container.getNames();
    String _head_1 = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_names_1)));
    int _length = _head_1.length();
    String _substring = _head.substring(1, _length);
    x.setName(_substring);
    String _id = container.getId();
    String _name = x.getName();
    this.idToName.put(_id, _name);
    String _status = container.getStatus();
    x.setStatus(_status);
  }
  
  @Pure
  public Map<String, String> getIdToName() {
    return this.idToName;
  }
  
  public void setIdToName(final Map<String, String> idToName) {
    this.idToName = idToName;
  }
}
