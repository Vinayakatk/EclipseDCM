package org.eclipse.docker.language.ui.launch;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class IPAddressHolder {
  private static IPAddressHolder holder;
  
  private List<String> ips;
  
  public static IPAddressHolder getInstance() {
    IPAddressHolder _xblockexpression = null;
    {
      boolean _equals = Objects.equal(IPAddressHolder.holder, null);
      if (_equals) {
        new IPAddressHolder();
      }
      _xblockexpression = IPAddressHolder.holder;
    }
    return _xblockexpression;
  }
  
  public boolean addIp(final String ip) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(this.ips, null);
      if (_equals) {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        this.ips = _newArrayList;
      }
      _xblockexpression = this.ips.add(ip);
    }
    return _xblockexpression;
  }
  
  public List<String> getIPs() {
    return this.ips;
  }
}
