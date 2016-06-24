package org.eclipse.docker.monitoring;

import com.github.dockerjava.api.model.Statistics;
import com.github.dockerjava.core.async.ResultCallbackTemplate;
import com.google.common.eventbus.EventBus;
import com.google.inject.Injector;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Platform;
import org.eclipse.docker.language.ui.internal.LanguageActivator;
import org.eclipse.docker.monitoring.CPUMonitoring;
import org.eclipse.docker.monitoring.IOMonitoring;
import org.eclipse.docker.monitoring.MemoryMonitoring;
import org.eclipse.docker.monitoring.MonitoringModel;
import org.eclipse.docker.monitoring.NetworkMonitoring;
import org.eclipse.docker.monitoring.StatsCallback;
import org.eclipse.docker.monitoring.events.CpuEvent;
import org.eclipse.docker.monitoring.events.IOEvent;
import org.eclipse.docker.monitoring.events.MemoryEvent;
import org.eclipse.docker.monitoring.events.NetworkEvent;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ContainerStatsCallback extends ResultCallbackTemplate<ContainerStatsCallback, Statistics> {
  private MonitoringModel model;
  
  private StatsCallback data;
  
  private EventBus bus;
  
  private String name;
  
  public ContainerStatsCallback(final String name) {
    this.name = name;
    LanguageActivator _instance = LanguageActivator.getInstance();
    Injector injector = _instance.getInjector(LanguageActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
    EventBus _instance_1 = injector.<EventBus>getInstance(EventBus.class);
    this.bus = _instance_1;
    MonitoringModel _monitoringModel = new MonitoringModel();
    this.model = _monitoringModel;
    StatsCallback _statsCallback = new StatsCallback(this.model, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0);
    this.data = _statsCallback;
  }
  
  public void onNext(final Statistics stats) {
    Platform.setImplicitExit(false);
    Platform.runLater(new Runnable() {
      public void run() {
        if ((stats != null)) {
          Map<String, Object> _cpuStats = stats.getCpuStats();
          Object _get = _cpuStats.get("cpu_usage");
          LinkedHashMap<?, ?> usage = ((LinkedHashMap<?, ?>) _get);
          Map<String, Object> _cpuStats_1 = stats.getCpuStats();
          Object sysCpuObject = _cpuStats_1.get("system_cpu_usage");
          Long sys = new Long((((Long) sysCpuObject)).longValue());
          Object totalUsageObject = usage.get("total_usage");
          Long cpu = new Long((((Long) totalUsageObject)).longValue());
          float perc = 0.0f;
          float _prevsyscpu = ContainerStatsCallback.this.data.getPrevsyscpu();
          float sysDelta = ((sys).longValue() - _prevsyscpu);
          long _prevcpu = ContainerStatsCallback.this.data.getPrevcpu();
          long cpuDelat = ((cpu).longValue() - _prevcpu);
          if (((sysDelta > 0.0) && (cpuDelat > 0.0))) {
            ContainerStatsCallback.this.data.setPrevcpu((cpu).longValue());
            ContainerStatsCallback.this.data.setPrevsyscpu((sys).longValue());
            Object _get_1 = usage.get("percpu_usage");
            int _size = ((List<?>) _get_1).size();
            float _multiply = ((cpuDelat / sysDelta) * _size);
            float _multiply_1 = (_multiply * 100);
            perc = _multiply_1;
          }
          ContainerStatsCallback.this.data.setPrevcpu((cpu).longValue());
          ContainerStatsCallback.this.data.setPrevsyscpu((sys).longValue());
          float _prevPerc = ContainerStatsCallback.this.data.getPrevPerc();
          boolean _tripleNotEquals = (_prevPerc != perc);
          if (_tripleNotEquals) {
            ContainerStatsCallback.this.data.setPrevPerc(perc);
            BigDecimal _valueOf = BigDecimal.valueOf(perc);
            BigDecimal _setScale = _valueOf.setScale(2, RoundingMode.HALF_UP);
            float doubleValue = _setScale.floatValue();
            MonitoringModel _model = ContainerStatsCallback.this.data.getModel();
            CPUMonitoring _cpu = _model.getCpu();
            _cpu.setPercentage(doubleValue);
            CpuEvent _cpuEvent = new CpuEvent();
            final Procedure1<CpuEvent> _function = new Procedure1<CpuEvent>() {
              public void apply(final CpuEvent it) {
                it.setName(ContainerStatsCallback.this.name);
                MonitoringModel _model = ContainerStatsCallback.this.data.getModel();
                CPUMonitoring _cpu = _model.getCpu();
                it.setMonitoring(_cpu);
              }
            };
            CpuEvent _doubleArrow = ObjectExtensions.<CpuEvent>operator_doubleArrow(_cpuEvent, _function);
            ContainerStatsCallback.this.bus.post(_doubleArrow);
          }
          Map<String, Object> _memoryStats = stats.getMemoryStats();
          Object _get_2 = _memoryStats.get("usage");
          int memoryUsage = (((Integer) _get_2)).intValue();
          Map<String, Object> _memoryStats_1 = stats.getMemoryStats();
          Object _get_3 = _memoryStats_1.get("limit");
          int memoryLimit = (((Integer) _get_3)).intValue();
          MonitoringModel _model_1 = ContainerStatsCallback.this.data.getModel();
          MemoryMonitoring _memory = _model_1.getMemory();
          _memory.setLimit(memoryLimit);
          MonitoringModel _model_2 = ContainerStatsCallback.this.data.getModel();
          MemoryMonitoring _memory_1 = _model_2.getMemory();
          _memory_1.setUtilized(memoryUsage);
          float _floatValue = Integer.valueOf(memoryUsage).floatValue();
          float _floatValue_1 = Integer.valueOf(memoryLimit).floatValue();
          float _divide = (_floatValue / _floatValue_1);
          float UsagePerc = (_divide * 100);
          float _preMemUsage = ContainerStatsCallback.this.data.getPreMemUsage();
          float deltaMemory = (UsagePerc - _preMemUsage);
          if ((deltaMemory > 0.0)) {
            ContainerStatsCallback.this.data.setPreMemUsage(UsagePerc);
            MonitoringModel _model_3 = ContainerStatsCallback.this.data.getModel();
            MemoryMonitoring _memory_2 = _model_3.getMemory();
            _memory_2.setPerc(UsagePerc);
            MemoryEvent _memoryEvent = new MemoryEvent();
            final Procedure1<MemoryEvent> _function_1 = new Procedure1<MemoryEvent>() {
              public void apply(final MemoryEvent it) {
                it.setName(ContainerStatsCallback.this.name);
                MonitoringModel _model = ContainerStatsCallback.this.data.getModel();
                MemoryMonitoring _memory = _model.getMemory();
                it.setMemoryMonitoring(_memory);
              }
            };
            MemoryEvent _doubleArrow_1 = ObjectExtensions.<MemoryEvent>operator_doubleArrow(_memoryEvent, _function_1);
            ContainerStatsCallback.this.bus.post(_doubleArrow_1);
          }
          Map<String, Object> _networks = stats.getNetworks();
          Collection<Object> values = _networks.values();
          Iterator<Object> _iterator = values.iterator();
          Object _next = _iterator.next();
          LinkedHashMap<?, ?> p = ((LinkedHashMap<?, ?>) _next);
          Object rxObject = p.get("rx_bytes");
          String _string = rxObject.toString();
          Integer rxBytes = Integer.valueOf(_string);
          Object txObject = p.get("tx_bytes");
          String _string_1 = txObject.toString();
          Integer txBytes = Integer.valueOf(_string_1);
          int _prerx = ContainerStatsCallback.this.data.getPrerx();
          int rxDelta = ((rxBytes).intValue() - _prerx);
          int _pretx = ContainerStatsCallback.this.data.getPretx();
          int txDelta = ((txBytes).intValue() - _pretx);
          if (((rxDelta > 0) || (txDelta > 0))) {
            ContainerStatsCallback.this.data.setPrerx((rxBytes).intValue());
            ContainerStatsCallback.this.data.setPretx((txBytes).intValue());
            MonitoringModel _model_4 = ContainerStatsCallback.this.data.getModel();
            NetworkMonitoring _network = _model_4.getNetwork();
            int _intValue = Integer.valueOf(((rxBytes).intValue() / 1024)).intValue();
            _network.setReceive(_intValue);
            MonitoringModel _model_5 = ContainerStatsCallback.this.data.getModel();
            NetworkMonitoring _network_1 = _model_5.getNetwork();
            int _intValue_1 = Integer.valueOf(((txBytes).intValue() / 1024)).intValue();
            _network_1.setTransmit(_intValue_1);
            NetworkEvent _networkEvent = new NetworkEvent();
            final Procedure1<NetworkEvent> _function_2 = new Procedure1<NetworkEvent>() {
              public void apply(final NetworkEvent it) {
                it.setName(ContainerStatsCallback.this.name);
                MonitoringModel _model = ContainerStatsCallback.this.data.getModel();
                NetworkMonitoring _network = _model.getNetwork();
                it.setNetworkMonitoring(_network);
              }
            };
            NetworkEvent _doubleArrow_2 = ObjectExtensions.<NetworkEvent>operator_doubleArrow(_networkEvent, _function_2);
            ContainerStatsCallback.this.bus.post(_doubleArrow_2);
          }
          Map<String, Object> _blkioStats = stats.getBlkioStats();
          Object _get_4 = _blkioStats.get("io_service_bytes_recursive");
          ArrayList<?> io = ((ArrayList<?>) _get_4);
          Integer readBytes = Integer.valueOf(0);
          Integer writeBytes = Integer.valueOf(0);
          for (final Object object : io) {
            {
              Object op = ((LinkedHashMap<?, ?>) object).get("op");
              boolean _equals = op.equals("Read");
              if (_equals) {
                Object read = ((LinkedHashMap<?, ?>) object).get("value");
                String _string_2 = read.toString();
                Integer _valueOf_1 = Integer.valueOf(_string_2);
                readBytes = _valueOf_1;
              }
              String _string_3 = op.toString();
              boolean _equals_1 = _string_3.equals("Write");
              if (_equals_1) {
                Object write = ((LinkedHashMap<?, ?>) object).get("value");
                String _string_4 = write.toString();
                Integer _valueOf_2 = Integer.valueOf(_string_4);
                writeBytes = _valueOf_2;
              }
            }
          }
          int _preread = ContainerStatsCallback.this.data.getPreread();
          int readDelta = ((readBytes).intValue() - _preread);
          int _prewrite = ContainerStatsCallback.this.data.getPrewrite();
          int writeDelta = ((writeBytes).intValue() - _prewrite);
          if (((readDelta > 0) || (writeDelta > 0))) {
            ContainerStatsCallback.this.data.setPreread((readBytes).intValue());
            ContainerStatsCallback.this.data.setPrewrite((writeBytes).intValue());
            MonitoringModel _model_6 = ContainerStatsCallback.this.data.getModel();
            IOMonitoring _io = _model_6.getIo();
            int _intValue_2 = Integer.valueOf(((readBytes).intValue() / 1024)).intValue();
            _io.setRead(_intValue_2);
            MonitoringModel _model_7 = ContainerStatsCallback.this.data.getModel();
            IOMonitoring _io_1 = _model_7.getIo();
            int _intValue_3 = Integer.valueOf(((writeBytes).intValue() / 1024)).intValue();
            _io_1.setWrite(_intValue_3);
            IOEvent _iOEvent = new IOEvent();
            final Procedure1<IOEvent> _function_3 = new Procedure1<IOEvent>() {
              public void apply(final IOEvent it) {
                it.setName(ContainerStatsCallback.this.name);
                MonitoringModel _model = ContainerStatsCallback.this.data.getModel();
                IOMonitoring _io = _model.getIo();
                it.setIoMonitoring(_io);
              }
            };
            IOEvent _doubleArrow_3 = ObjectExtensions.<IOEvent>operator_doubleArrow(_iOEvent, _function_3);
            ContainerStatsCallback.this.bus.post(_doubleArrow_3);
          }
        }
      }
    });
  }
}
