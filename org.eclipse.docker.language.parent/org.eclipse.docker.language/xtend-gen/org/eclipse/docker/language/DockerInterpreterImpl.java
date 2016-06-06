package org.eclipse.docker.language;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageCmd;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import com.google.common.base.Objects;
import com.google.inject.Provider;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.docker.language.DockerInterpreter;
import org.eclipse.docker.language.container.AccessMode;
import org.eclipse.docker.language.container.Bind;
import org.eclipse.docker.language.container.Binding;
import org.eclipse.docker.language.container.Capability;
import org.eclipse.docker.language.container.Container;
import org.eclipse.docker.language.container.ContainerPackage;
import org.eclipse.docker.language.container.Device;
import org.eclipse.docker.language.container.Docker;
import org.eclipse.docker.language.container.ExposedPort;
import org.eclipse.docker.language.container.Image;
import org.eclipse.docker.language.container.InternalProtocol;
import org.eclipse.docker.language.container.Label;
import org.eclipse.docker.language.container.Link;
import org.eclipse.docker.language.container.PortBinding;
import org.eclipse.docker.language.container.RestartPolicy;
import org.eclipse.docker.language.container.RunContainerDefination;
import org.eclipse.docker.language.container.Ulimit;
import org.eclipse.docker.language.container.Volume;
import org.eclipse.docker.language.container.VolumesFrom;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DockerInterpreterImpl implements DockerInterpreter {
  private DockerClient dockerClient;
  
  @Inject
  public DockerInterpreterImpl(final Provider<DockerClient> provider) {
    DockerClient _get = provider.get();
    this.dockerClient = _get;
  }
  
  @Override
  public void interpret(final Resource resource) {
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    Docker docker = ((Docker) _get);
    RunContainerDefination _runtime = docker.getRuntime();
    EList<Container> _sequence = _runtime.getSequence();
    final Consumer<Container> _function = (Container it) -> {
      this.interpret(it);
    };
    _sequence.forEach(_function);
  }
  
  protected void _interpret(final Container container) {
    String _image = container.getImage();
    CreateContainerCmd command = this.dockerClient.createContainerCmd(_image);
    EAttribute _container_Name = ContainerPackage.eINSTANCE.getContainer_Name();
    Object _eGet = container.eGet(_container_Name);
    boolean _notEquals = (!Objects.equal(_eGet, null));
    if (_notEquals) {
      String _name = container.getName();
      command.withName(_name);
    }
    EReference _container_Binds = ContainerPackage.eINSTANCE.getContainer_Binds();
    Object _eGet_1 = container.eGet(_container_Binds);
    boolean _notEquals_1 = (!Objects.equal(_eGet_1, null));
    if (_notEquals_1) {
      EList<Bind> _binds = container.getBinds();
      this.interpretBinds(_binds, command);
    }
    EAttribute _container_CapabilityAdd = ContainerPackage.eINSTANCE.getContainer_CapabilityAdd();
    Object _eGet_2 = container.eGet(_container_CapabilityAdd);
    boolean _notEquals_2 = (!Objects.equal(_eGet_2, null));
    if (_notEquals_2) {
      EList<Capability> _capabilityAdd = container.getCapabilityAdd();
      this.interpretCapAdd(_capabilityAdd, command);
    }
    EAttribute _container_CapabilityDrop = ContainerPackage.eINSTANCE.getContainer_CapabilityDrop();
    Object _eGet_3 = container.eGet(_container_CapabilityDrop);
    boolean _notEquals_3 = (!Objects.equal(_eGet_3, null));
    if (_notEquals_3) {
      EList<Capability> _capabilityDrop = container.getCapabilityDrop();
      this.interpretCapDrop(_capabilityDrop, command);
    }
    EAttribute _container_Commands = ContainerPackage.eINSTANCE.getContainer_Commands();
    Object _eGet_4 = container.eGet(_container_Commands);
    boolean _notEquals_4 = (!Objects.equal(_eGet_4, null));
    if (_notEquals_4) {
      EList<String> _commands = container.getCommands();
      this.interpretCommands(_commands, command);
    }
    EAttribute _container_ContainerIDFile = ContainerPackage.eINSTANCE.getContainer_ContainerIDFile();
    Object _eGet_5 = container.eGet(_container_ContainerIDFile);
    boolean _notEquals_5 = (!Objects.equal(_eGet_5, null));
    if (_notEquals_5) {
      String _containerIDFile = container.getContainerIDFile();
      this.interpretContainerIDFile(_containerIDFile, command);
    }
    EAttribute _container_CpusetCpus = ContainerPackage.eINSTANCE.getContainer_CpusetCpus();
    Object _eGet_6 = container.eGet(_container_CpusetCpus);
    boolean _notEquals_6 = (!Objects.equal(_eGet_6, null));
    if (_notEquals_6) {
      String _cpusetCpus = container.getCpusetCpus();
      this.interpretCpusetCpus(_cpusetCpus, command);
    }
    EAttribute _container_CpuPeriod = ContainerPackage.eINSTANCE.getContainer_CpuPeriod();
    Object _eGet_7 = container.eGet(_container_CpuPeriod);
    boolean _notEquals_7 = (!Objects.equal(_eGet_7, null));
    if (_notEquals_7) {
      int _cpuPeriod = container.getCpuPeriod();
      this.intrepretCpuPeriod(_cpuPeriod, command);
    }
    EAttribute _container_CpusetMems = ContainerPackage.eINSTANCE.getContainer_CpusetMems();
    Object _eGet_8 = container.eGet(_container_CpusetMems);
    boolean _notEquals_8 = (!Objects.equal(_eGet_8, null));
    if (_notEquals_8) {
      String _cpusetMems = container.getCpusetMems();
      this.interpretCpusetMems(_cpusetMems, command);
    }
    EAttribute _container_CpuShares = ContainerPackage.eINSTANCE.getContainer_CpuShares();
    Object _eGet_9 = container.eGet(_container_CpuShares);
    boolean _notEquals_9 = (!Objects.equal(_eGet_9, null));
    if (_notEquals_9) {
      int _cpuShares = container.getCpuShares();
      this.interpretCpuShares(_cpuShares, command);
    }
    EReference _container_Devices = ContainerPackage.eINSTANCE.getContainer_Devices();
    Object _eGet_10 = container.eGet(_container_Devices);
    boolean _notEquals_10 = (!Objects.equal(_eGet_10, null));
    if (_notEquals_10) {
      EList<Device> _devices = container.getDevices();
      this.interpretDevices(_devices, command);
    }
    EAttribute _container_Dns = ContainerPackage.eINSTANCE.getContainer_Dns();
    Object _eGet_11 = container.eGet(_container_Dns);
    boolean _notEquals_11 = (!Objects.equal(_eGet_11, null));
    if (_notEquals_11) {
      EList<String> _dns = container.getDns();
      this.interpretDns(_dns, command);
    }
    EAttribute _container_DnsSearch = ContainerPackage.eINSTANCE.getContainer_DnsSearch();
    Object _eGet_12 = container.eGet(_container_DnsSearch);
    boolean _notEquals_12 = (!Objects.equal(_eGet_12, null));
    if (_notEquals_12) {
      EList<String> _dnsSearch = container.getDnsSearch();
      this.interpretDnsSearch(_dnsSearch, command);
    }
    EAttribute _container_DomainName = ContainerPackage.eINSTANCE.getContainer_DomainName();
    Object _eGet_13 = container.eGet(_container_DomainName);
    boolean _notEquals_13 = (!Objects.equal(_eGet_13, null));
    if (_notEquals_13) {
      String _domainName = container.getDomainName();
      this.interpretDomainName(_domainName, command);
    }
    EAttribute _container_Entrypoint = ContainerPackage.eINSTANCE.getContainer_Entrypoint();
    Object _eGet_14 = container.eGet(_container_Entrypoint);
    boolean _notEquals_14 = (!Objects.equal(_eGet_14, null));
    if (_notEquals_14) {
      EList<String> _entrypoint = container.getEntrypoint();
      this.interpretEntryPOint(_entrypoint, command);
    }
    EAttribute _container_Env = ContainerPackage.eINSTANCE.getContainer_Env();
    Object _eGet_15 = container.eGet(_container_Env);
    boolean _notEquals_15 = (!Objects.equal(_eGet_15, null));
    if (_notEquals_15) {
      EList<String> _env = container.getEnv();
      this.interpretEnv(_env, command);
    }
    EReference _container_ExposedPorts = ContainerPackage.eINSTANCE.getContainer_ExposedPorts();
    Object _eGet_16 = container.eGet(_container_ExposedPorts);
    boolean _notEquals_16 = (!Objects.equal(_eGet_16, null));
    if (_notEquals_16) {
      EList<ExposedPort> _exposedPorts = container.getExposedPorts();
      this.interpretExposedPOrts(_exposedPorts, command);
    }
    EAttribute _container_ExtraHosts = ContainerPackage.eINSTANCE.getContainer_ExtraHosts();
    Object _eGet_17 = container.eGet(_container_ExtraHosts);
    boolean _notEquals_17 = (!Objects.equal(_eGet_17, null));
    if (_notEquals_17) {
      EList<String> _extraHosts = container.getExtraHosts();
      this.interpretExtraHosts(_extraHosts, command);
    }
    EReference _container_Labels = ContainerPackage.eINSTANCE.getContainer_Labels();
    Object _eGet_18 = container.eGet(_container_Labels);
    boolean _notEquals_18 = (!Objects.equal(_eGet_18, null));
    if (_notEquals_18) {
      EList<Label> _labels = container.getLabels();
      this.interpretLabels(_labels, command);
    }
    EReference _container_Links = ContainerPackage.eINSTANCE.getContainer_Links();
    Object _eGet_19 = container.eGet(_container_Links);
    boolean _notEquals_19 = (!Objects.equal(_eGet_19, null));
    if (_notEquals_19) {
      EList<Link> _links = container.getLinks();
      this.interpretLinks(_links, command);
    }
    EAttribute _container_MacAddress = ContainerPackage.eINSTANCE.getContainer_MacAddress();
    Object _eGet_20 = container.eGet(_container_MacAddress);
    boolean _notEquals_20 = (!Objects.equal(_eGet_20, null));
    if (_notEquals_20) {
      String _macAddress = container.getMacAddress();
      this.interpretMac(_macAddress, command);
    }
    EAttribute _container_Memory = ContainerPackage.eINSTANCE.getContainer_Memory();
    Object _eGet_21 = container.eGet(_container_Memory);
    boolean _notEquals_21 = (!Objects.equal(_eGet_21, null));
    if (_notEquals_21) {
      long _memory = container.getMemory();
      this.interpretMemory(_memory, command);
    }
    EAttribute _container_MemorySwap = ContainerPackage.eINSTANCE.getContainer_MemorySwap();
    Object _eGet_22 = container.eGet(_container_MemorySwap);
    boolean _notEquals_22 = (!Objects.equal(_eGet_22, null));
    if (_notEquals_22) {
      long _memorySwap = container.getMemorySwap();
      this.interpretMemorySwap(_memorySwap, command);
    }
    EAttribute _container_DisableNetwork = ContainerPackage.eINSTANCE.getContainer_DisableNetwork();
    Object _eGet_23 = container.eGet(_container_DisableNetwork);
    boolean _notEquals_23 = (!Objects.equal(_eGet_23, null));
    if (_notEquals_23) {
      boolean _isDisableNetwork = container.isDisableNetwork();
      this.interpretDisableNetwork(_isDisableNetwork, command);
    }
    EAttribute _container_NetworkMode = ContainerPackage.eINSTANCE.getContainer_NetworkMode();
    Object _eGet_24 = container.eGet(_container_NetworkMode);
    boolean _notEquals_24 = (!Objects.equal(_eGet_24, null));
    if (_notEquals_24) {
      String _networkMode = container.getNetworkMode();
      this.interpretMode(_networkMode, command);
    }
    EReference _container_PortBindings = ContainerPackage.eINSTANCE.getContainer_PortBindings();
    Object _eGet_25 = container.eGet(_container_PortBindings);
    boolean _notEquals_25 = (!Objects.equal(_eGet_25, null));
    if (_notEquals_25) {
      EList<PortBinding> _portBindings = container.getPortBindings();
      this.interpretPortBindings(_portBindings, command);
    }
    EAttribute _container_Privileged = ContainerPackage.eINSTANCE.getContainer_Privileged();
    Object _eGet_26 = container.eGet(_container_Privileged);
    boolean _notEquals_26 = (!Objects.equal(_eGet_26, null));
    if (_notEquals_26) {
      boolean _isPrivileged = container.isPrivileged();
      this.intrepretPrivileged(_isPrivileged, command);
    }
    EAttribute _container_PublishAllPorts = ContainerPackage.eINSTANCE.getContainer_PublishAllPorts();
    Object _eGet_27 = container.eGet(_container_PublishAllPorts);
    boolean _notEquals_27 = (!Objects.equal(_eGet_27, null));
    if (_notEquals_27) {
      boolean _isPublishAllPorts = container.isPublishAllPorts();
      this.interpretPublishAllPorts(_isPublishAllPorts, command);
    }
    EAttribute _container_ReadonlyRootfs = ContainerPackage.eINSTANCE.getContainer_ReadonlyRootfs();
    Object _eGet_28 = container.eGet(_container_ReadonlyRootfs);
    boolean _notEquals_28 = (!Objects.equal(_eGet_28, null));
    if (_notEquals_28) {
      boolean _isReadonlyRootfs = container.isReadonlyRootfs();
      this.interpretReadonlyRootfs(_isReadonlyRootfs, command);
    }
    EAttribute _container_PidMode = ContainerPackage.eINSTANCE.getContainer_PidMode();
    Object _eGet_29 = container.eGet(_container_PidMode);
    boolean _notEquals_29 = (!Objects.equal(_eGet_29, null));
    if (_notEquals_29) {
      String _pidMode = container.getPidMode();
      this.interpretPidMode(_pidMode, command);
    }
    EAttribute _container_WorkingDir = ContainerPackage.eINSTANCE.getContainer_WorkingDir();
    Object _eGet_30 = container.eGet(_container_WorkingDir);
    boolean _notEquals_30 = (!Objects.equal(_eGet_30, null));
    if (_notEquals_30) {
      String _workingDir = container.getWorkingDir();
      this.interpretWorkingDir(_workingDir, command);
    }
    EAttribute _container_User = ContainerPackage.eINSTANCE.getContainer_User();
    Object _eGet_31 = container.eGet(_container_User);
    boolean _notEquals_31 = (!Objects.equal(_eGet_31, null));
    if (_notEquals_31) {
      String _user = container.getUser();
      this.interpretUser(_user, command);
    }
    EAttribute _container_Tty = ContainerPackage.eINSTANCE.getContainer_Tty();
    Object _eGet_32 = container.eGet(_container_Tty);
    boolean _notEquals_32 = (!Objects.equal(_eGet_32, null));
    if (_notEquals_32) {
      boolean _isTty = container.isTty();
      this.interpretTTy(_isTty, command);
    }
    EReference _container_RestartPolicy = ContainerPackage.eINSTANCE.getContainer_RestartPolicy();
    Object _eGet_33 = container.eGet(_container_RestartPolicy);
    boolean _notEquals_33 = (!Objects.equal(_eGet_33, null));
    if (_notEquals_33) {
      RestartPolicy _restartPolicy = container.getRestartPolicy();
      this.interpretRestartPolicy(_restartPolicy, command);
    }
    EReference _container_Volumes = ContainerPackage.eINSTANCE.getContainer_Volumes();
    Object _eGet_34 = container.eGet(_container_Volumes);
    boolean _notEquals_34 = (!Objects.equal(_eGet_34, null));
    if (_notEquals_34) {
      EList<Volume> _volumes = container.getVolumes();
      this.interpretVolumes(_volumes, command);
    }
    EReference _container_VolumesFrom = ContainerPackage.eINSTANCE.getContainer_VolumesFrom();
    Object _eGet_35 = container.eGet(_container_VolumesFrom);
    boolean _notEquals_35 = (!Objects.equal(_eGet_35, null));
    if (_notEquals_35) {
      EList<VolumesFrom> _volumesFrom = container.getVolumesFrom();
      this.interpretVolumesFrom(_volumesFrom, command);
    }
    EReference _container_Ulimits = ContainerPackage.eINSTANCE.getContainer_Ulimits();
    Object _eGet_36 = container.eGet(_container_Ulimits);
    boolean _notEquals_36 = (!Objects.equal(_eGet_36, null));
    if (_notEquals_36) {
      EList<Ulimit> _ulimits = container.getUlimits();
      this.interpretULimits(_ulimits, command);
    }
    CreateContainerResponse response = command.exec();
    String _id = response.getId();
    InputOutput.<String>println(_id);
  }
  
  public void interpretCpusetMems(final String value, final CreateContainerCmd command) {
    command.withCpusetMems(value);
  }
  
  public void interpretDevices(final EList<Device> list, final CreateContainerCmd command) {
    final Function1<Device, com.github.dockerjava.api.model.Device> _function = (Device it) -> {
      return this.toDevice(it);
    };
    List<com.github.dockerjava.api.model.Device> _map = ListExtensions.<Device, com.github.dockerjava.api.model.Device>map(list, _function);
    command.withDevices(((com.github.dockerjava.api.model.Device[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.Device.class)));
  }
  
  public com.github.dockerjava.api.model.Device toDevice(final Device dev) {
    com.github.dockerjava.api.model.Device _xblockexpression = null;
    {
      String _cGroupPermissions = dev.getCGroupPermissions();
      String _pathInContainer = dev.getPathInContainer();
      String _pathOnHost = dev.getPathOnHost();
      com.github.dockerjava.api.model.Device dev2 = new com.github.dockerjava.api.model.Device(_cGroupPermissions, _pathInContainer, _pathOnHost);
      _xblockexpression = dev2;
    }
    return _xblockexpression;
  }
  
  public void interpretDns(final EList<String> list, final CreateContainerCmd command) {
    command.withDns(((String[])Conversions.unwrapArray(list, String.class)));
  }
  
  public void interpretDnsSearch(final EList<String> list, final CreateContainerCmd command) {
    command.withDnsSearch(((String[])Conversions.unwrapArray(list, String.class)));
  }
  
  public CreateContainerCmd interpretDomainName(final String string, final CreateContainerCmd command) {
    return command.withDomainName(string);
  }
  
  public void interpretCpuShares(final int value, final CreateContainerCmd command) {
    command.withCpuShares(value);
  }
  
  public void interpretEntryPOint(final EList<String> list, final CreateContainerCmd command) {
    command.withEntrypoint(((String[])Conversions.unwrapArray(list, String.class)));
  }
  
  public void interpretEnv(final EList<String> list, final CreateContainerCmd command) {
    command.withEnv(((String[])Conversions.unwrapArray(list, String.class)));
  }
  
  public void interpretExposedPOrts(final EList<ExposedPort> list, final CreateContainerCmd command) {
    final Function1<ExposedPort, com.github.dockerjava.api.model.ExposedPort> _function = (ExposedPort it) -> {
      return this.toExposedPort(it);
    };
    List<com.github.dockerjava.api.model.ExposedPort> _map = ListExtensions.<ExposedPort, com.github.dockerjava.api.model.ExposedPort>map(list, _function);
    command.withExposedPorts(((com.github.dockerjava.api.model.ExposedPort[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.ExposedPort.class)));
  }
  
  public com.github.dockerjava.api.model.ExposedPort toExposedPort(final ExposedPort port) {
    com.github.dockerjava.api.model.ExposedPort _switchResult = null;
    InternalProtocol _protocol = port.getProtocol();
    if (_protocol != null) {
      switch (_protocol) {
        case TCP:
          String _port = port.getPort();
          Integer _integer = new Integer(_port);
          _switchResult = com.github.dockerjava.api.model.ExposedPort.tcp((_integer).intValue());
          break;
        case UDP:
          String _port_1 = port.getPort();
          Integer _integer_1 = new Integer(_port_1);
          _switchResult = com.github.dockerjava.api.model.ExposedPort.udp((_integer_1).intValue());
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public void interpretExtraHosts(final EList<String> list, final CreateContainerCmd command) {
    command.withExtraHosts(((String[])Conversions.unwrapArray(list, String.class)));
  }
  
  public void interpretLabels(final EList<Label> list, final CreateContainerCmd command) {
    HashMap<String, String> map = CollectionLiterals.<String, String>newHashMap();
    for (final Label element : list) {
      String _key = element.getKey();
      String _value = element.getValue();
      map.put(_key, _value);
    }
    command.withLabels(map);
  }
  
  public void interpretLinks(final EList<Link> list, final CreateContainerCmd command) {
    final Function1<Link, com.github.dockerjava.api.model.Link> _function = (Link it) -> {
      return this.toLink(it);
    };
    List<com.github.dockerjava.api.model.Link> _map = ListExtensions.<Link, com.github.dockerjava.api.model.Link>map(list, _function);
    command.withLinks(((com.github.dockerjava.api.model.Link[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.Link.class)));
  }
  
  public com.github.dockerjava.api.model.Link toLink(final Link link) {
    String _containerLink = link.getContainerLink();
    String _alias = link.getAlias();
    return new com.github.dockerjava.api.model.Link(_containerLink, _alias);
  }
  
  public CreateContainerCmd interpretMac(final String string, final CreateContainerCmd command) {
    return command.withMacAddress(string);
  }
  
  public void interpretMemory(final long value, final CreateContainerCmd command) {
    command.withMemoryLimit(value);
  }
  
  public void interpretMemorySwap(final long value, final CreateContainerCmd command) {
    command.withMemorySwap(value);
  }
  
  public void interpretDisableNetwork(final boolean value, final CreateContainerCmd command) {
    command.withNetworkDisabled(value);
  }
  
  public CreateContainerCmd interpretMode(final String string, final CreateContainerCmd command) {
    return command.withNetworkMode(string);
  }
  
  public void interpretPortBindings(final EList<PortBinding> list, final CreateContainerCmd command) {
    final Function1<PortBinding, com.github.dockerjava.api.model.PortBinding> _function = (PortBinding it) -> {
      return this.toBindings(it);
    };
    List<com.github.dockerjava.api.model.PortBinding> _map = ListExtensions.<PortBinding, com.github.dockerjava.api.model.PortBinding>map(list, _function);
    command.withPortBindings(((com.github.dockerjava.api.model.PortBinding[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.PortBinding.class)));
  }
  
  public com.github.dockerjava.api.model.PortBinding toBindings(final PortBinding bindings) {
    com.github.dockerjava.api.model.PortBinding _xblockexpression = null;
    {
      Binding _binding = bindings.getBinding();
      Ports.Binding bnd = this.toBinding(_binding);
      ExposedPort _exposedPort = bindings.getExposedPort();
      com.github.dockerjava.api.model.ExposedPort exp = this.toExposedPort(_exposedPort);
      _xblockexpression = new com.github.dockerjava.api.model.PortBinding(bnd, exp);
    }
    return _xblockexpression;
  }
  
  public Ports.Binding toBinding(final Binding binding) {
    int _hostPort = binding.getHostPort();
    return Ports.Binding(Integer.valueOf(_hostPort));
  }
  
  public void intrepretPrivileged(final boolean value, final CreateContainerCmd command) {
    command.withPrivileged(value);
  }
  
  public void interpretReadonlyRootfs(final boolean value, final CreateContainerCmd command) {
    command.withReadonlyRootfs(value);
  }
  
  public CreateContainerCmd interpretPidMode(final String string, final CreateContainerCmd command) {
    return command.withPidMode(string);
  }
  
  public CreateContainerCmd interpretWorkingDir(final String string, final CreateContainerCmd command) {
    return command.withWorkingDir(string);
  }
  
  public CreateContainerCmd interpretUser(final String string, final CreateContainerCmd command) {
    return command.withUser(string);
  }
  
  public void interpretPublishAllPorts(final boolean value, final CreateContainerCmd command) {
    command.withPublishAllPorts(value);
  }
  
  public void interpretTTy(final boolean tty, final CreateContainerCmd command) {
    command.withTty(tty);
  }
  
  public void interpretRestartPolicy(final RestartPolicy policy, final CreateContainerCmd command) {
    com.github.dockerjava.api.model.RestartPolicy _policy = this.toPolicy(policy);
    command.withRestartPolicy(_policy);
  }
  
  public com.github.dockerjava.api.model.RestartPolicy toPolicy(final RestartPolicy policy) {
    com.github.dockerjava.api.model.RestartPolicy _switchResult = null;
    String _value = policy.getValue();
    switch (_value) {
      case "always":
        _switchResult = com.github.dockerjava.api.model.RestartPolicy.alwaysRestart();
        break;
      case "onFailure":
        int _maximumRetryCount = policy.getMaximumRetryCount();
        _switchResult = com.github.dockerjava.api.model.RestartPolicy.onFailureRestart(_maximumRetryCount);
        break;
      case "none":
        _switchResult = com.github.dockerjava.api.model.RestartPolicy.noRestart();
        break;
      default:
        _switchResult = com.github.dockerjava.api.model.RestartPolicy.alwaysRestart();
        break;
    }
    return _switchResult;
  }
  
  public void interpretVolumes(final EList<Volume> list, final CreateContainerCmd command) {
    final Function1<Volume, com.github.dockerjava.api.model.Volume> _function = (Volume it) -> {
      return this.toVolume(it);
    };
    List<com.github.dockerjava.api.model.Volume> _map = ListExtensions.<Volume, com.github.dockerjava.api.model.Volume>map(list, _function);
    command.withVolumes(((com.github.dockerjava.api.model.Volume[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.Volume.class)));
  }
  
  public void interpretVolumesFrom(final EList<VolumesFrom> list, final CreateContainerCmd command) {
    final Function1<VolumesFrom, com.github.dockerjava.api.model.VolumesFrom> _function = (VolumesFrom it) -> {
      return this.toVolumesFrom(it);
    };
    List<com.github.dockerjava.api.model.VolumesFrom> _map = ListExtensions.<VolumesFrom, com.github.dockerjava.api.model.VolumesFrom>map(list, _function);
    command.withVolumesFrom(((com.github.dockerjava.api.model.VolumesFrom[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.VolumesFrom.class)));
  }
  
  public com.github.dockerjava.api.model.VolumesFrom toVolumesFrom(final VolumesFrom from) {
    com.github.dockerjava.api.model.VolumesFrom _xifexpression = null;
    AccessMode _accessMode = from.getAccessMode();
    boolean _notEquals = (!Objects.equal(_accessMode, null));
    if (_notEquals) {
      String _container = from.getContainer();
      com.github.dockerjava.api.model.AccessMode _switchResult = null;
      AccessMode _accessMode_1 = from.getAccessMode();
      if (_accessMode_1 != null) {
        switch (_accessMode_1) {
          case RO:
            _switchResult = com.github.dockerjava.api.model.AccessMode.ro;
            break;
          case RW:
            _switchResult = com.github.dockerjava.api.model.AccessMode.rw;
            break;
          default:
            break;
        }
      }
      _xifexpression = new com.github.dockerjava.api.model.VolumesFrom(_container, _switchResult);
    } else {
      String _container_1 = from.getContainer();
      _xifexpression = new com.github.dockerjava.api.model.VolumesFrom(_container_1);
    }
    return _xifexpression;
  }
  
  public void interpretULimits(final EList<Ulimit> list, final CreateContainerCmd command) {
    final Function1<Ulimit, com.github.dockerjava.api.model.Ulimit> _function = (Ulimit it) -> {
      return this.toUlimit(it);
    };
    List<com.github.dockerjava.api.model.Ulimit> _map = ListExtensions.<Ulimit, com.github.dockerjava.api.model.Ulimit>map(list, _function);
    command.withUlimits(((com.github.dockerjava.api.model.Ulimit[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.Ulimit.class)));
  }
  
  public com.github.dockerjava.api.model.Ulimit toUlimit(final Ulimit limit) {
    com.github.dockerjava.api.model.Ulimit _xblockexpression = null;
    {
      String _name = limit.getName();
      int _soft = limit.getSoft();
      int _hard = limit.getHard();
      com.github.dockerjava.api.model.Ulimit limit2 = new com.github.dockerjava.api.model.Ulimit(_name, _soft, _hard);
      _xblockexpression = limit2;
    }
    return _xblockexpression;
  }
  
  public void interpretCapDrop(final EList<Capability> list, final CreateContainerCmd command) {
    final Function1<Capability, com.github.dockerjava.api.model.Capability> _function = (Capability it) -> {
      return this.toCapability(it);
    };
    List<com.github.dockerjava.api.model.Capability> _map = ListExtensions.<Capability, com.github.dockerjava.api.model.Capability>map(list, _function);
    command.withCapAdd(((com.github.dockerjava.api.model.Capability[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.Capability.class)));
  }
  
  public void interpretCapAdd(final EList<Capability> list, final CreateContainerCmd command) {
    final Function1<Capability, com.github.dockerjava.api.model.Capability> _function = (Capability it) -> {
      return this.toCapability(it);
    };
    List<com.github.dockerjava.api.model.Capability> _map = ListExtensions.<Capability, com.github.dockerjava.api.model.Capability>map(list, _function);
    command.withCapAdd(((com.github.dockerjava.api.model.Capability[])Conversions.unwrapArray(_map, com.github.dockerjava.api.model.Capability.class)));
  }
  
  public CreateContainerCmd interpretContainerIDFile(final String string, final CreateContainerCmd command) {
    return command.withContainerIDFile(string);
  }
  
  public void intrepretCpuPeriod(final int cpuPeriod, final CreateContainerCmd command) {
    command.withCpuPeriod(Integer.valueOf(cpuPeriod));
  }
  
  public void interpretCommands(final EList<String> list, final CreateContainerCmd command) {
    command.withCmd(((String[])Conversions.unwrapArray(list, String.class)));
  }
  
  public void interpretImage(final String image, final CreateContainerCmd command) {
    command.withImage(image);
  }
  
  public void interpretImage(final Image image) {
    final BuildImageCmd buildImageCmd = this.dockerClient.buildImageCmd();
    final BuildImageResultCallback callback = new BuildImageResultCallback() {
      @Override
      public void onNext(final BuildResponseItem item) {
        System.out.println(("" + item));
        super.onNext(item);
      }
    };
    EAttribute _image_Tag = ContainerPackage.eINSTANCE.getImage_Tag();
    Object _eGet = image.eGet(_image_Tag);
    boolean _notEquals = (!Objects.equal(_eGet, null));
    if (_notEquals) {
      String _tag = image.getTag();
      buildImageCmd.withTag(_tag);
    }
    EAttribute _image_ForceRM = ContainerPackage.eINSTANCE.getImage_ForceRM();
    Object _eGet_1 = image.eGet(_image_ForceRM);
    boolean _notEquals_1 = (!Objects.equal(_eGet_1, null));
    if (_notEquals_1) {
      boolean _isForceRM = image.isForceRM();
      buildImageCmd.withForcerm(Boolean.valueOf(_isForceRM));
    }
    EAttribute _image_Cpusetcpus = ContainerPackage.eINSTANCE.getImage_Cpusetcpus();
    Object _eGet_2 = image.eGet(_image_Cpusetcpus);
    boolean _notEquals_2 = (!Objects.equal(_eGet_2, null));
    if (_notEquals_2) {
      String _cpusetcpus = image.getCpusetcpus();
      buildImageCmd.withCpusetcpus(_cpusetcpus);
    }
    EAttribute _image_Cpushares = ContainerPackage.eINSTANCE.getImage_Cpushares();
    Object _eGet_3 = image.eGet(_image_Cpushares);
    boolean _notEquals_3 = (!Objects.equal(_eGet_3, null));
    if (_notEquals_3) {
      String _cpushares = image.getCpushares();
      buildImageCmd.withCpushares(_cpushares);
    }
    EAttribute _image_DockerFilelocation = ContainerPackage.eINSTANCE.getImage_DockerFilelocation();
    Object _eGet_4 = image.eGet(_image_DockerFilelocation);
    boolean _notEquals_4 = (!Objects.equal(_eGet_4, null));
    if (_notEquals_4) {
      Resource resource = image.eResource();
      String _dockerFilelocation = image.getDockerFilelocation();
      File absFile = new File(_dockerFilelocation);
      boolean _isAbsolute = absFile.isAbsolute();
      if (_isAbsolute) {
        buildImageCmd.withDockerfile(absFile);
      } else {
        IFile _file = ResourceUtil.getFile(resource);
        IProject _project = _file.getProject();
        String _dockerFilelocation_1 = image.getDockerFilelocation();
        IFile _file_1 = _project.getFile(_dockerFilelocation_1);
        IPath _location = _file_1.getLocation();
        File file = _location.toFile();
        buildImageCmd.withDockerfile(file);
      }
    }
    EAttribute _image_Memory = ContainerPackage.eINSTANCE.getImage_Memory();
    Object _eGet_5 = image.eGet(_image_Memory);
    boolean _notEquals_5 = (!Objects.equal(_eGet_5, null));
    if (_notEquals_5) {
      long _memory = image.getMemory();
      buildImageCmd.withMemory(_memory);
    }
    EAttribute _image_Memswap = ContainerPackage.eINSTANCE.getImage_Memswap();
    Object _eGet_6 = image.eGet(_image_Memswap);
    boolean _notEquals_6 = (!Objects.equal(_eGet_6, null));
    if (_notEquals_6) {
      long _memswap = image.getMemswap();
      buildImageCmd.withMemswap(_memswap);
    }
    EAttribute _image_NoCache = ContainerPackage.eINSTANCE.getImage_NoCache();
    Object _eGet_7 = image.eGet(_image_NoCache);
    boolean _notEquals_7 = (!Objects.equal(_eGet_7, null));
    if (_notEquals_7) {
      boolean _isNoCache = image.isNoCache();
      buildImageCmd.withNoCache(_isNoCache);
    }
    EAttribute _image_Name = ContainerPackage.eINSTANCE.getImage_Name();
    Object _eGet_8 = image.eGet(_image_Name);
    boolean _notEquals_8 = (!Objects.equal(_eGet_8, null));
    if (_notEquals_8) {
    }
    EAttribute _image_Pull = ContainerPackage.eINSTANCE.getImage_Pull();
    Object _eGet_9 = image.eGet(_image_Pull);
    boolean _notEquals_9 = (!Objects.equal(_eGet_9, null));
    if (_notEquals_9) {
      boolean _isPull = image.isPull();
      buildImageCmd.withPull(_isPull);
    }
    EAttribute _image_Quiet = ContainerPackage.eINSTANCE.getImage_Quiet();
    Object _eGet_10 = image.eGet(_image_Quiet);
    boolean _notEquals_10 = (!Objects.equal(_eGet_10, null));
    if (_notEquals_10) {
      boolean _isQuiet = image.isQuiet();
      buildImageCmd.withQuiet(_isQuiet);
    }
    EAttribute _image_Remove = ContainerPackage.eINSTANCE.getImage_Remove();
    Object _eGet_11 = image.eGet(_image_Remove);
    boolean _notEquals_11 = (!Objects.equal(_eGet_11, null));
    if (_notEquals_11) {
      boolean _isRemove = image.isRemove();
      buildImageCmd.withRemove(_isRemove);
    }
    BuildImageResultCallback _exec = buildImageCmd.<BuildImageResultCallback>exec(callback);
    _exec.awaitImageId();
  }
  
  public com.github.dockerjava.api.model.Capability toCapability(final Capability cap) {
    com.github.dockerjava.api.model.Capability _switchResult = null;
    if (cap != null) {
      switch (cap) {
        case ALL:
          _switchResult = com.github.dockerjava.api.model.Capability.ALL;
          break;
        case AUDIT_CONTROL:
          _switchResult = com.github.dockerjava.api.model.Capability.AUDIT_CONTROL;
          break;
        case AUDIT_WRITE:
          _switchResult = com.github.dockerjava.api.model.Capability.AUDIT_WRITE;
          break;
        case BLOCK_SUSPEND:
          _switchResult = com.github.dockerjava.api.model.Capability.BLOCK_SUSPEND;
          break;
        case CHOWN:
          _switchResult = com.github.dockerjava.api.model.Capability.CHOWN;
          break;
        case DAC_OVERRIDE:
          _switchResult = com.github.dockerjava.api.model.Capability.DAC_OVERRIDE;
          break;
        case DAC_READ_SEARCH:
          _switchResult = com.github.dockerjava.api.model.Capability.DAC_READ_SEARCH;
          break;
        case FOWNER:
          _switchResult = com.github.dockerjava.api.model.Capability.FOWNER;
          break;
        case FSETID:
          _switchResult = com.github.dockerjava.api.model.Capability.FSETID;
          break;
        case IPC_LOCK:
          _switchResult = com.github.dockerjava.api.model.Capability.IPC_LOCK;
          break;
        case IPC_OWNER:
          _switchResult = com.github.dockerjava.api.model.Capability.IPC_OWNER;
          break;
        case KILL:
          _switchResult = com.github.dockerjava.api.model.Capability.KILL;
          break;
        case LEASE:
          _switchResult = com.github.dockerjava.api.model.Capability.LEASE;
          break;
        case LINUX_IMMUTABLE:
          _switchResult = com.github.dockerjava.api.model.Capability.LINUX_IMMUTABLE;
          break;
        case MAC_ADMIN:
          _switchResult = com.github.dockerjava.api.model.Capability.MAC_ADMIN;
          break;
        case MAC_OVERRIDE:
          _switchResult = com.github.dockerjava.api.model.Capability.MAC_OVERRIDE;
          break;
        case MKNOD:
          _switchResult = com.github.dockerjava.api.model.Capability.MKNOD;
          break;
        case NET_ADMIN:
          _switchResult = com.github.dockerjava.api.model.Capability.NET_ADMIN;
          break;
        case NET_BIND_SERVICE:
          _switchResult = com.github.dockerjava.api.model.Capability.NET_BIND_SERVICE;
          break;
        case NET_BROADCAST:
          _switchResult = com.github.dockerjava.api.model.Capability.NET_BROADCAST;
          break;
        case NET_RAW:
          _switchResult = com.github.dockerjava.api.model.Capability.NET_RAW;
          break;
        case SETFCAP:
          _switchResult = com.github.dockerjava.api.model.Capability.SETFCAP;
          break;
        case SETGID:
          _switchResult = com.github.dockerjava.api.model.Capability.SETGID;
          break;
        case SETPCAP:
          _switchResult = com.github.dockerjava.api.model.Capability.SETPCAP;
          break;
        case SETUID:
          _switchResult = com.github.dockerjava.api.model.Capability.SETUID;
          break;
        case SYS_ADMIN:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_ADMIN;
          break;
        case SYS_BOOT:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_BOOT;
          break;
        case SYS_CHROOT:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_CHROOT;
          break;
        case SYS_MODULE:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_MODULE;
          break;
        case SYS_NICE:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_NICE;
          break;
        case SYS_PACCT:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_PACCT;
          break;
        case SYS_PTRACE:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_PTRACE;
          break;
        case SYS_RAWIO:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_RAWIO;
          break;
        case SYS_RESOURCE:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_RESOURCE;
          break;
        case SYS_TIME:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_TIME;
          break;
        case SYSLOG:
          _switchResult = com.github.dockerjava.api.model.Capability.SYSLOG;
          break;
        case SYS_TTY_CONFIG:
          _switchResult = com.github.dockerjava.api.model.Capability.SYS_TTY_CONFIG;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public void interpretBinds(final List<Bind> binds, final CreateContainerCmd command) {
    final Function1<Bind, com.github.dockerjava.api.model.Bind> _function = (Bind it) -> {
      return this.toBind(it);
    };
    List<com.github.dockerjava.api.model.Bind> binds2 = ListExtensions.<Bind, com.github.dockerjava.api.model.Bind>map(binds, _function);
    final List<com.github.dockerjava.api.model.Bind> _converted_binds2 = (List<com.github.dockerjava.api.model.Bind>)binds2;
    command.withBinds(((com.github.dockerjava.api.model.Bind[])Conversions.unwrapArray(_converted_binds2, com.github.dockerjava.api.model.Bind.class)));
  }
  
  public com.github.dockerjava.api.model.Bind toBind(final Bind bind) {
    com.github.dockerjava.api.model.Bind _xifexpression = null;
    AccessMode _accessMode1 = bind.getAccessMode1();
    boolean _equals = Objects.equal(_accessMode1, null);
    if (_equals) {
      String _location = bind.getLocation();
      Volume _volume = bind.getVolume();
      com.github.dockerjava.api.model.Volume _volume_1 = this.toVolume(_volume);
      _xifexpression = new com.github.dockerjava.api.model.Bind(_location, _volume_1);
    } else {
      String _location_1 = bind.getLocation();
      Volume _volume_2 = bind.getVolume();
      com.github.dockerjava.api.model.Volume _volume_3 = this.toVolume(_volume_2);
      com.github.dockerjava.api.model.AccessMode _switchResult = null;
      AccessMode _accessMode1_1 = bind.getAccessMode1();
      if (_accessMode1_1 != null) {
        switch (_accessMode1_1) {
          case RO:
            _switchResult = com.github.dockerjava.api.model.AccessMode.ro;
            break;
          case RW:
            _switchResult = com.github.dockerjava.api.model.AccessMode.rw;
            break;
          default:
            break;
        }
      }
      _xifexpression = new com.github.dockerjava.api.model.Bind(_location_1, _volume_3, _switchResult);
    }
    return _xifexpression;
  }
  
  public com.github.dockerjava.api.model.Volume toVolume(final Volume vol) {
    com.github.dockerjava.api.model.Volume _xblockexpression = null;
    {
      String _path = vol.getPath();
      com.github.dockerjava.api.model.Volume volume = new com.github.dockerjava.api.model.Volume(_path);
      _xblockexpression = volume;
    }
    return _xblockexpression;
  }
  
  public void interpretCpusetCpus(final String cpusetCpus, final CreateContainerCmd command) {
    command.withCpuset(cpusetCpus);
  }
  
  public void interpret(final Container container) {
    _interpret(container);
    return;
  }
}
