package org.eclipse.docker.language.ui;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Hosts {
  @Accessors
  private Set<String> hosts;
  
  private static Hosts SingletonHosts;
  
  public static Hosts getInstance() {
    Hosts _xblockexpression = null;
    {
      boolean _equals = Objects.equal(Hosts.SingletonHosts, null);
      if (_equals) {
        Hosts _hosts = new Hosts();
        final Procedure1<Hosts> _function = (Hosts it) -> {
          HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet();
          it.hosts = _newHashSet;
        };
        Hosts _doubleArrow = ObjectExtensions.<Hosts>operator_doubleArrow(_hosts, _function);
        Hosts.SingletonHosts = _doubleArrow;
      }
      _xblockexpression = Hosts.SingletonHosts;
    }
    return _xblockexpression;
  }
  
  @Pure
  public Set<String> getHosts() {
    return this.hosts;
  }
  
  public void setHosts(final Set<String> hosts) {
    this.hosts = hosts;
  }
}
