package org.eclipse.docker.diagram

import de.cau.cs.kieler.core.kgraph.KEdge
import de.cau.cs.kieler.core.kgraph.KNode
import de.cau.cs.kieler.core.krendering.KRenderingFactory
import de.cau.cs.kieler.core.krendering.extensions.KColorExtensions
import de.cau.cs.kieler.core.krendering.extensions.KContainerRenderingExtensions
import de.cau.cs.kieler.core.krendering.extensions.KEdgeExtensions
import de.cau.cs.kieler.core.krendering.extensions.KLabelExtensions
import de.cau.cs.kieler.core.krendering.extensions.KNodeExtensions
import de.cau.cs.kieler.core.krendering.extensions.KPolylineExtensions
import de.cau.cs.kieler.core.krendering.extensions.KPortExtensions
import de.cau.cs.kieler.core.krendering.extensions.KRenderingExtensions
import de.cau.cs.kieler.kiml.options.LayoutOptions
import de.cau.cs.kieler.kiml.options.SizeConstraint
import de.cau.cs.kieler.kiml.util.KimlUtil
import de.cau.cs.kieler.klighd.KlighdConstants
import de.cau.cs.kieler.klighd.syntheses.AbstractDiagramSynthesis
import java.util.EnumSet

import org.eclipse.docker.language.container.Container
import org.eclipse.docker.language.container.Docker
import org.eclipse.docker.language.container.Link
import org.eclipse.ltk.internal.core.refactoring.resource.undostates.ContainerUndoState
import org.eclipse.docker.language.util.ContainerUtil
import org.eclipse.xtext.EcoreUtil2
import com.google.inject.Provider
import org.eclipse.docker.language.DockerClientProvider
import com.google.inject.Inject
import com.github.dockerjava.api.DockerClient
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Label
import org.eclipse.docker.language.transformation.ContainerTransformation
import org.eclipse.docker.language.ui.internal.LanguageActivator
import java.util.List

class DockerDiagramSynthesis extends AbstractDiagramSynthesis<Docker> {

	@Inject extension KNodeExtensions
	@Inject extension KEdgeExtensions
	@Inject extension KPortExtensions
	@Inject extension KLabelExtensions
	@Inject extension KRenderingExtensions
	@Inject extension KContainerRenderingExtensions
	@Inject extension KPolylineExtensions
	@Inject extension KColorExtensions
	extension KRenderingFactory = KRenderingFactory.eINSTANCE
	Docker docker
	Provider<DockerClient> provider
	ContainerTransformation transformation
	Docker cloned
	
	List<com.github.dockerjava.api.model.Container> containers

	override KNode transform(Docker model) {
		docker = model
		cloned = EcoreUtil2.cloneWithProxies(model)
		var injector = LanguageActivator.instance.getInjector(LanguageActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER)
		transformation = injector.getInstance(ContainerTransformation)
		provider = injector.getProvider(DockerClient)
		val root = model.createNode().associateWith(model);
		try {
			provider.get.pingCmd().exec();
			fillClonedModel(cloned, root)
		} catch (Exception e) {

			println("cannot display")
		}

//		model.containerRegion.containers.filterNull.forEach[s|root.children += transform(s)]
//		model.containerRegion.containers.filterNull.forEach[c|c.links.filterNull.forEach[transform(it)]]

		return root;
	}

	def fillClonedModel(Docker docker, KNode root) {
		val dockerClient = provider.get
		containers = dockerClient.listContainersCmd.exec
		containers.filterNull.forEach[s|root.children += transform(s)]
		containers.forEach [
			val container = it
			val response = dockerClient.inspectContainerCmd(it.id).exec
			var links = response.hostConfig.links
			links.forEach [
				transform(it.name, it.alias, container,ContainerUtil.getName(container)+":"+it.alias)
			]
		]
	}

	def private create containerNode : container.createNode().associateWith(container) transform(Container container) {

		containerNode.setNodeSize(40, 20).addRoundedRectangle(4, 4).associateWith(containerNode) => [
			foreground = "yellow".color
			background = "red".color
			shadow = "red".color

		];

		containerNode.addInsideCenteredNodeLabel(container.name, KlighdConstants.DEFAULT_FONT_SIZE,
			KlighdConstants.DEFAULT_FONT_NAME).associateWith(containerNode);
		containerNode.addLayoutParam(LayoutOptions.SIZE_CONSTRAINT,
			EnumSet.of(SizeConstraint.MINIMUM_SIZE, SizeConstraint.NODE_LABELS));
//			containerNode.outgoingEdges.addAll(container.links.filterNull.map[ t | transform(t) ])
	}

	private def KEdge create transEdge : edgeString.createEdge().associateWith(edgeString) transform(String containerTarget,
		String alias, com.github.dockerjava.api.model.Container container,String edgeString) {

		transEdge.addRoundedBendsPolyline(2, 2).addHeadArrowDecorator() => [
			background = "red".color
			shadow = "black".color
		];

		val label = KimlUtil.createInitializedLabel(transEdge);
		val labelText = if(alias == null) "" else alias

		label.configureCenterEdgeLabel(labelText, KlighdConstants.DEFAULT_FONT_SIZE, KlighdConstants.DEFAULT_FONT_NAME);
		var tar = containers.findFirst[ContainerUtil.getName(it)==containerTarget]
		transEdge.target = tar.node
		transEdge.source = container.node

	}

	def private create containerNode : container.createNode().associateWith(container) transform(
		com.github.dockerjava.api.model.Container container) {

		containerNode.setNodeSize(40, 20).addRoundedRectangle(4, 4).associateWith(containerNode) => [
			foreground = "yellow".color
			background = "green".color
			shadow = "red".color

		];
		var cname = transformation.idToName.get(container.id)
		containerNode.addInsideCenteredNodeLabel(cname,
			KlighdConstants.DEFAULT_FONT_SIZE, KlighdConstants.DEFAULT_FONT_NAME).associateWith(containerNode);
		containerNode.addLayoutParam(LayoutOptions.SIZE_CONSTRAINT,
			EnumSet.of(SizeConstraint.MINIMUM_SIZE, SizeConstraint.NODE_LABELS));
//			containerNode.outgoingEdges.addAll(container.links.filterNull.map[ t | transform(t) ])
	}

	private def KEdge create transEdge : trans.createEdge().associateWith(trans) transform(Link trans) {

		transEdge.addRoundedBendsPolyline(2, 2).addHeadArrowDecorator() => [
			background = "red".color
			shadow = "black".color
		];

		var container = trans.eContainer as Container
		val label = KimlUtil.createInitializedLabel(transEdge);
		val labelText = if(trans.alias == null) "" else trans.alias

		label.configureCenterEdgeLabel(labelText, KlighdConstants.DEFAULT_FONT_SIZE, KlighdConstants.DEFAULT_FONT_NAME);
		transEdge.target = ContainerUtil.getContainer(docker, trans.containerLink).node
		transEdge.source = container.node

	}

}
