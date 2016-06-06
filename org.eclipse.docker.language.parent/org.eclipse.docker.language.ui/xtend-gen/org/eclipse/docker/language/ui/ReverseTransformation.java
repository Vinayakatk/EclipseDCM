package org.eclipse.docker.language.ui;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.docker.language.TableModel.CData;
import org.eclipse.docker.language.TableModel.TableModelFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ReverseTransformation {
  public ReverseTransformation() {
  }
  
  public List<CData> transform(final List<String> entries) {
    return this.loadTModel(entries);
  }
  
  public List<CData> loadTModel(final List<String> entries) {
    final Function1<String, CData> _function = (String it) -> {
      return this.toCData(it);
    };
    return ListExtensions.<String, CData>map(entries, _function);
  }
  
  public CData toCData(final String data) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(data);
    final CData _result;
    synchronized (_createCache_toCData) {
      if (_createCache_toCData.containsKey(_cacheKey)) {
        return _createCache_toCData.get(_cacheKey);
      }
      CData _createCData = TableModelFactory.eINSTANCE.createCData();
      _result = _createCData;
      _createCache_toCData.put(_cacheKey, _result);
    }
    _init_toCData(_result, data);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, CData> _createCache_toCData = CollectionLiterals.newHashMap();
  
  private void _init_toCData(final CData x, final String data) {
    Splitter _on = Splitter.on("@");
    Iterable<String> entries = _on.split(data);
    final Iterable<String> _converted_entries = (Iterable<String>)entries;
    String _get = ((String[])Conversions.unwrapArray(_converted_entries, String.class))[0];
    x.setName(_get);
    final Iterable<String> _converted_entries_1 = (Iterable<String>)entries;
    String _get_1 = ((String[])Conversions.unwrapArray(_converted_entries_1, String.class))[1];
    x.setStatus(_get_1);
  }
}
