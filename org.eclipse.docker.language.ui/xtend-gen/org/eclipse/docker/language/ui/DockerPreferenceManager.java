package org.eclipse.docker.language.ui;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Injector;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.docker.language.DockerConfig;
import org.eclipse.docker.language.TableModel.CData;
import org.eclipse.docker.language.TableModel.TModelSingleton;
import org.eclipse.docker.language.ui.DockerEditor;
import org.eclipse.docker.language.ui.Hosts;
import org.eclipse.docker.language.ui.ReverseTransformation;
import org.eclipse.docker.language.ui.internal.ContainerActivator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

@SuppressWarnings("all")
public class DockerPreferenceManager {
  private static String PLUGIN_ID = "org.eclipse.docker.language.ui";
  
  public static void saveData() {
    try {
      IEclipsePreferences node = ConfigurationScope.INSTANCE.getNode(DockerPreferenceManager.PLUGIN_ID);
      Preferences host = node.node("host");
      Joiner _on = Joiner.on("#");
      Hosts _instance = Hosts.getInstance();
      Set<String> _hosts = _instance.getHosts();
      String joinedHosts = _on.join(_hosts);
      host.put("hosts", joinedHosts);
      ContainerActivator _instance_1 = ContainerActivator.getInstance();
      Injector _injector = _instance_1.getInjector(
        ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
      DockerConfig config = _injector.<DockerConfig>getInstance(DockerConfig.class);
      String certPath = config.getDockerCertPath();
      host.put("certPath", certPath);
      String _uri = config.getUri();
      host.put("currentHost", _uri);
      IEclipsePreferences instancePref = InstanceScope.INSTANCE.getNode(DockerPreferenceManager.PLUGIN_ID);
      Preferences table = instancePref.node("table");
      TModelSingleton tmodel = TModelSingleton.getModel();
      List<CData> entries = tmodel.getEntries();
      Joiner _on_1 = Joiner.on("#");
      final Function1<CData, String> _function = (CData it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("@");
        String _status = it.getStatus();
        _builder.append(_status, "");
        return _builder.toString();
      };
      List<String> _map = ListExtensions.<CData, String>map(entries, _function);
      String entriesString = _on_1.join(_map);
      table.put("entries", entriesString);
      node.flush();
    } catch (final Throwable _t) {
      if (_t instanceof BackingStoreException) {
        final BackingStoreException e = (BackingStoreException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void loadData(final DockerEditor editor) {
    IEclipsePreferences node = ConfigurationScope.INSTANCE.getNode(DockerPreferenceManager.PLUGIN_ID);
    Preferences host = node.node("host");
    if ((host != null)) {
      String sequence = host.get("hosts", null);
      boolean _and = false;
      if (!(sequence != null)) {
        _and = false;
      } else {
        boolean _isEmpty = sequence.isEmpty();
        boolean _not = (!_isEmpty);
        _and = _not;
      }
      if (_and) {
        Splitter _on = Splitter.on("#");
        Iterable<String> splittedHosts = _on.split(sequence);
        HashSet<String> hosts = Sets.<String>newHashSet(splittedHosts);
        Hosts _instance = Hosts.getInstance();
        _instance.setHosts(hosts);
      }
      ContainerActivator _instance_1 = ContainerActivator.getInstance();
      Injector _injector = _instance_1.getInjector(
        ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
      DockerConfig config = _injector.<DockerConfig>getInstance(DockerConfig.class);
      String certPath = host.get("certPath", null);
      boolean _and_1 = false;
      if (!(certPath != null)) {
        _and_1 = false;
      } else {
        boolean _isEmpty_1 = certPath.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        _and_1 = _not_1;
      }
      if (_and_1) {
        config.setDockerCertPath(certPath);
      }
      String current = host.get("currentHost", null);
      boolean _notEquals = (!Objects.equal(current, null));
      if (_notEquals) {
        config.setUri(current);
      }
    }
    IEclipsePreferences instancePref = InstanceScope.INSTANCE.getNode(DockerPreferenceManager.PLUGIN_ID);
    Preferences table = instancePref.node("table");
    boolean _notEquals_1 = (!Objects.equal(table, null));
    if (_notEquals_1) {
      String entriesString = table.get("entries", null);
      boolean _and_2 = false;
      boolean _notEquals_2 = (!Objects.equal(entriesString, null));
      if (!_notEquals_2) {
        _and_2 = false;
      } else {
        boolean _isEmpty_2 = entriesString.isEmpty();
        boolean _not_2 = (!_isEmpty_2);
        _and_2 = _not_2;
      }
      if (_and_2) {
        Splitter _on_1 = Splitter.on("#");
        Iterable<String> entries = _on_1.split(entriesString);
        List<String> list = IterableExtensions.<String>toList(entries);
        ReverseTransformation _reverseTransformation = new ReverseTransformation();
        List<CData> datas = _reverseTransformation.transform(list);
        TModelSingleton _model = TModelSingleton.getModel();
        List<CData> _entries = _model.getEntries();
        _entries.clear();
        TModelSingleton _model_1 = TModelSingleton.getModel();
        List<CData> _entries_1 = _model_1.getEntries();
        Iterables.<CData>addAll(_entries_1, datas);
      }
    }
  }
}
