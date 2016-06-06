package org.eclipse.docker.diagram;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectContainerCmd;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.command.PingCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Link;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.krendering.KColor;
import de.cau.cs.kieler.core.krendering.KRendering;
import de.cau.cs.kieler.core.krendering.KRenderingFactory;
import de.cau.cs.kieler.core.krendering.KRoundedBendsPolyline;
import de.cau.cs.kieler.core.krendering.KRoundedRectangle;
import de.cau.cs.kieler.core.krendering.extensions.KColorExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KContainerRenderingExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KEdgeExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KLabelExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KNodeExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KPolylineExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KPortExtensions;
import de.cau.cs.kieler.core.krendering.extensions.KRenderingExtensions;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.options.SizeConstraint;
import de.cau.cs.kieler.kiml.util.KimlUtil;
import de.cau.cs.kieler.klighd.KlighdConstants;
import de.cau.cs.kieler.klighd.syntheses.AbstractDiagramSynthesis;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.docker.language.container.Docker;
import org.eclipse.docker.language.transformation.ContainerTransformation;
import org.eclipse.docker.language.ui.internal.ContainerActivator;
import org.eclipse.docker.language.util.ContainerUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DockerDiagramSynthesis extends AbstractDiagramSynthesis<Docker> {
  @Inject
  @Extension
  private KNodeExtensions _kNodeExtensions;
  
  @Inject
  @Extension
  private KEdgeExtensions _kEdgeExtensions;
  
  @Inject
  @Extension
  private KPortExtensions _kPortExtensions;
  
  @Inject
  @Extension
  private KLabelExtensions _kLabelExtensions;
  
  @Inject
  @Extension
  private KRenderingExtensions _kRenderingExtensions;
  
  @Inject
  @Extension
  private KContainerRenderingExtensions _kContainerRenderingExtensions;
  
  @Inject
  @Extension
  private KPolylineExtensions _kPolylineExtensions;
  
  @Inject
  @Extension
  private KColorExtensions _kColorExtensions;
  
  @Extension
  private KRenderingFactory _kRenderingFactory = KRenderingFactory.eINSTANCE;
  
  private Docker docker;
  
  private Provider<DockerClient> provider;
  
  private ContainerTransformation transformation;
  
  private Docker cloned;
  
  private List<Container> containers;
  
  @Override
  public KNode transform(final Docker model) {
    this.docker = model;
    Docker _cloneWithProxies = EcoreUtil2.<Docker>cloneWithProxies(model);
    this.cloned = _cloneWithProxies;
    ContainerActivator _instance = ContainerActivator.getInstance();
    Injector injector = _instance.getInjector(ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
    ContainerTransformation _instance_1 = injector.<ContainerTransformation>getInstance(ContainerTransformation.class);
    this.transformation = _instance_1;
    Provider<DockerClient> _provider = injector.<DockerClient>getProvider(DockerClient.class);
    this.provider = _provider;
    KNode _createNode = this._kNodeExtensions.createNode(model);
    final KNode root = this.<KNode>associateWith(_createNode, model);
    try {
      DockerClient _get = this.provider.get();
      PingCmd _pingCmd = _get.pingCmd();
      _pingCmd.exec();
      this.fillClonedModel(this.cloned, root);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        InputOutput.<String>println("cannot display");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return root;
  }
  
  public void fillClonedModel(final Docker docker, final KNode root) {
    final DockerClient dockerClient = this.provider.get();
    ListContainersCmd _listContainersCmd = dockerClient.listContainersCmd();
    List<Container> _exec = _listContainersCmd.exec();
    this.containers = _exec;
    Iterable<Container> _filterNull = IterableExtensions.<Container>filterNull(this.containers);
    final Consumer<Container> _function = (Container s) -> {
      EList<KNode> _children = root.getChildren();
      KNode _transform = this.transform(s);
      _children.add(_transform);
    };
    _filterNull.forEach(_function);
    final Consumer<Container> _function_1 = (Container it) -> {
      final Container container = it;
      String _id = it.getId();
      InspectContainerCmd _inspectContainerCmd = dockerClient.inspectContainerCmd(_id);
      final InspectContainerResponse response = _inspectContainerCmd.exec();
      HostConfig _hostConfig = response.getHostConfig();
      Link[] links = _hostConfig.getLinks();
      final Link[] _converted_links = (Link[])links;
      final Consumer<Link> _function_2 = (Link it_1) -> {
        String _name = it_1.getName();
        String _alias = it_1.getAlias();
        String _name_1 = ContainerUtil.getName(container);
        String _plus = (_name_1 + ":");
        String _alias_1 = it_1.getAlias();
        String _plus_1 = (_plus + _alias_1);
        this.transform(_name, _alias, container, _plus_1);
      };
      ((List<Link>)Conversions.doWrapArray(_converted_links)).forEach(_function_2);
    };
    this.containers.forEach(_function_1);
  }
  
  private KNode transform(final org.eclipse.docker.language.container.Container container) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(container);
    final KNode _result;
    synchronized (_createCache_transform) {
      if (_createCache_transform.containsKey(_cacheKey)) {
        return _createCache_transform.get(_cacheKey);
      }
      KNode _createNode = this._kNodeExtensions.createNode(container);
      KNode _associateWith = this.<KNode>associateWith(_createNode, container);
      _result = _associateWith;
      _createCache_transform.put(_cacheKey, _result);
    }
    _init_transform(_result, container);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, KNode> _createCache_transform = CollectionLiterals.newHashMap();
  
  private void _init_transform(final KNode containerNode, final org.eclipse.docker.language.container.Container container) {
    KNode _setNodeSize = this._kNodeExtensions.setNodeSize(containerNode, 40, 20);
    KRoundedRectangle _addRoundedRectangle = this._kRenderingExtensions.addRoundedRectangle(_setNodeSize, 4, 4);
    KRoundedRectangle _associateWith = this.<KRoundedRectangle>associateWith(_addRoundedRectangle, containerNode);
    final Procedure1<KRoundedRectangle> _function = (KRoundedRectangle it) -> {
      KColor _color = this._kColorExtensions.getColor("yellow");
      this._kRenderingExtensions.setForeground(it, _color);
      KColor _color_1 = this._kColorExtensions.getColor("red");
      this._kRenderingExtensions.setBackground(it, _color_1);
      KColor _color_2 = this._kColorExtensions.getColor("red");
      this._kRenderingExtensions.setShadow(it, _color_2);
    };
    ObjectExtensions.<KRoundedRectangle>operator_doubleArrow(_associateWith, _function);
    String _name = container.getName();
    KLabel _addInsideCenteredNodeLabel = this._kLabelExtensions.addInsideCenteredNodeLabel(containerNode, _name, KlighdConstants.DEFAULT_FONT_SIZE, 
      KlighdConstants.DEFAULT_FONT_NAME);
    this.<KLabel>associateWith(_addInsideCenteredNodeLabel, containerNode);
    EnumSet<SizeConstraint> _of = EnumSet.<SizeConstraint>of(SizeConstraint.MINIMUM_SIZE, SizeConstraint.NODE_LABELS);
    this._kNodeExtensions.<EnumSet<SizeConstraint>>addLayoutParam(containerNode, LayoutOptions.SIZE_CONSTRAINT, _of);
  }
  
  private KEdge transform(final String containerTarget, final String alias, final Container container, final String edgeString) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(containerTarget, alias, container, edgeString);
    final KEdge _result;
    synchronized (_createCache_transform_1) {
      if (_createCache_transform_1.containsKey(_cacheKey)) {
        return _createCache_transform_1.get(_cacheKey);
      }
      KEdge _createEdge = this._kEdgeExtensions.createEdge(edgeString);
      KEdge _associateWith = this.<KEdge>associateWith(_createEdge, edgeString);
      _result = _associateWith;
      _createCache_transform_1.put(_cacheKey, _result);
    }
    _init_transform(_result, containerTarget, alias, container, edgeString);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, KEdge> _createCache_transform_1 = CollectionLiterals.newHashMap();
  
  private void _init_transform(final KEdge transEdge, final String containerTarget, final String alias, final Container container, final String edgeString) {
    KRoundedBendsPolyline _addRoundedBendsPolyline = this._kEdgeExtensions.addRoundedBendsPolyline(transEdge, 2, 2);
    KRendering _addHeadArrowDecorator = this._kPolylineExtensions.addHeadArrowDecorator(_addRoundedBendsPolyline);
    final Procedure1<KRendering> _function = (KRendering it) -> {
      KColor _color = this._kColorExtensions.getColor("red");
      this._kRenderingExtensions.setBackground(it, _color);
      KColor _color_1 = this._kColorExtensions.getColor("black");
      this._kRenderingExtensions.setShadow(it, _color_1);
    };
    ObjectExtensions.<KRendering>operator_doubleArrow(_addHeadArrowDecorator, _function);
    final KLabel label = KimlUtil.createInitializedLabel(transEdge);
    String _xifexpression = null;
    boolean _equals = Objects.equal(alias, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      _xifexpression = alias;
    }
    final String labelText = _xifexpression;
    this._kLabelExtensions.configureCenterEdgeLabel(label, labelText, KlighdConstants.DEFAULT_FONT_SIZE, KlighdConstants.DEFAULT_FONT_NAME);
    final Function1<Container, Boolean> _function_1 = (Container it) -> {
      String _name = ContainerUtil.getName(it);
      return Boolean.valueOf(Objects.equal(_name, containerTarget));
    };
    Container tar = IterableExtensions.<Container>findFirst(this.containers, _function_1);
    KNode _node = this._kNodeExtensions.getNode(tar);
    transEdge.setTarget(_node);
    KNode _node_1 = this._kNodeExtensions.getNode(container);
    transEdge.setSource(_node_1);
  }
  
  private KNode transform(final Container container) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(container);
    final KNode _result;
    synchronized (_createCache_transform_2) {
      if (_createCache_transform_2.containsKey(_cacheKey)) {
        return _createCache_transform_2.get(_cacheKey);
      }
      KNode _createNode = this._kNodeExtensions.createNode(container);
      KNode _associateWith = this.<KNode>associateWith(_createNode, container);
      _result = _associateWith;
      _createCache_transform_2.put(_cacheKey, _result);
    }
    _init_transform_1(_result, container);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, KNode> _createCache_transform_2 = CollectionLiterals.newHashMap();
  
  private void _init_transform_1(final KNode containerNode, final Container container) {
    KNode _setNodeSize = this._kNodeExtensions.setNodeSize(containerNode, 40, 20);
    KRoundedRectangle _addRoundedRectangle = this._kRenderingExtensions.addRoundedRectangle(_setNodeSize, 4, 4);
    KRoundedRectangle _associateWith = this.<KRoundedRectangle>associateWith(_addRoundedRectangle, containerNode);
    final Procedure1<KRoundedRectangle> _function = (KRoundedRectangle it) -> {
      KColor _color = this._kColorExtensions.getColor("yellow");
      this._kRenderingExtensions.setForeground(it, _color);
      KColor _color_1 = this._kColorExtensions.getColor("green");
      this._kRenderingExtensions.setBackground(it, _color_1);
      KColor _color_2 = this._kColorExtensions.getColor("red");
      this._kRenderingExtensions.setShadow(it, _color_2);
    };
    ObjectExtensions.<KRoundedRectangle>operator_doubleArrow(_associateWith, _function);
    Map<String, String> _idToName = this.transformation.getIdToName();
    String _id = container.getId();
    String cname = _idToName.get(_id);
    KLabel _addInsideCenteredNodeLabel = this._kLabelExtensions.addInsideCenteredNodeLabel(containerNode, cname, 
      KlighdConstants.DEFAULT_FONT_SIZE, KlighdConstants.DEFAULT_FONT_NAME);
    this.<KLabel>associateWith(_addInsideCenteredNodeLabel, containerNode);
    EnumSet<SizeConstraint> _of = EnumSet.<SizeConstraint>of(SizeConstraint.MINIMUM_SIZE, SizeConstraint.NODE_LABELS);
    this._kNodeExtensions.<EnumSet<SizeConstraint>>addLayoutParam(containerNode, LayoutOptions.SIZE_CONSTRAINT, _of);
  }
  
  private KEdge transform(final org.eclipse.docker.language.container.Link trans) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(trans);
    final KEdge _result;
    synchronized (_createCache_transform_3) {
      if (_createCache_transform_3.containsKey(_cacheKey)) {
        return _createCache_transform_3.get(_cacheKey);
      }
      KEdge _createEdge = this._kEdgeExtensions.createEdge(trans);
      KEdge _associateWith = this.<KEdge>associateWith(_createEdge, trans);
      _result = _associateWith;
      _createCache_transform_3.put(_cacheKey, _result);
    }
    _init_transform_2(_result, trans);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, KEdge> _createCache_transform_3 = CollectionLiterals.newHashMap();
  
  private void _init_transform_2(final KEdge transEdge, final org.eclipse.docker.language.container.Link trans) {
    KRoundedBendsPolyline _addRoundedBendsPolyline = this._kEdgeExtensions.addRoundedBendsPolyline(transEdge, 2, 2);
    KRendering _addHeadArrowDecorator = this._kPolylineExtensions.addHeadArrowDecorator(_addRoundedBendsPolyline);
    final Procedure1<KRendering> _function = (KRendering it) -> {
      KColor _color = this._kColorExtensions.getColor("red");
      this._kRenderingExtensions.setBackground(it, _color);
      KColor _color_1 = this._kColorExtensions.getColor("black");
      this._kRenderingExtensions.setShadow(it, _color_1);
    };
    ObjectExtensions.<KRendering>operator_doubleArrow(_addHeadArrowDecorator, _function);
    EObject _eContainer = trans.eContainer();
    org.eclipse.docker.language.container.Container container = ((org.eclipse.docker.language.container.Container) _eContainer);
    final KLabel label = KimlUtil.createInitializedLabel(transEdge);
    String _xifexpression = null;
    String _alias = trans.getAlias();
    boolean _equals = Objects.equal(_alias, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      _xifexpression = trans.getAlias();
    }
    final String labelText = _xifexpression;
    this._kLabelExtensions.configureCenterEdgeLabel(label, labelText, KlighdConstants.DEFAULT_FONT_SIZE, KlighdConstants.DEFAULT_FONT_NAME);
    String _containerLink = trans.getContainerLink();
    org.eclipse.docker.language.container.Container _container = ContainerUtil.getContainer(this.docker, _containerLink);
    KNode _node = this._kNodeExtensions.getNode(_container);
    transEdge.setTarget(_node);
    KNode _node_1 = this._kNodeExtensions.getNode(container);
    transEdge.setSource(_node_1);
  }
}
