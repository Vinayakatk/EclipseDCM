package org.eclipse.docker.language.ui.launch

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate
import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.debug.ui.ILaunchShortcut2
import org.eclipse.docker.language.container.Docker
import org.eclipse.docker.language.ui.internal.ContainerActivator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.docker.language.DockerInterpreter
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.ui.IFileEditorInput
import com.google.inject.Provider
import org.eclipse.docker.language.ui.DockerRunDialog

class RunContainerLauncher implements ILaunchShortcut, ILaunchShortcut2, ILaunchConfigurationDelegate {
	@Inject DockerInterpreter interpreter
	DockerConsole console = new DockerConsole

	@Inject
	Provider<ResourceSet> resourceSet

	override void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
		IProgressMonitor monitor) throws CoreException {

		System::out.println("called launch")
	}

	override ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		System::out.println("called selected launch configuration")
		return null
	}

	override ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
		System::out.println("called editor launch configuration")
		return null
	}

	override IResource getLaunchableResource(ISelection selection) {
		System::out.println("called selectable resource")
		if (selection instanceof IStructuredSelection) {
			for (Object element : ((selection as IStructuredSelection)).toArray()) {
				if(element instanceof IFile) return (element as IResource)
			}
		}
		return null
	}

	override IResource getLaunchableResource(IEditorPart editorpart) {
		val IEditorInput input = editorpart.getEditorInput()
		if(input instanceof FileEditorInput) return ((input as FileEditorInput)).getFile()
		return null
	}

	override void launch(ISelection selection, String mode) {

		Display.current.asyncExec(
			new Runnable() {

				override run() {
					if (selection instanceof IStructuredSelection) {
						var Object element = ((selection as IStructuredSelection)).getFirstElement()
						if (element instanceof IFile) {
							var IFile f = (element as IFile)
							var Injector injector = ContainerActivator::getInstance().getInjector(
								ContainerActivator::ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER)
							var ResourceSet instance = injector.getInstance(typeof(ResourceSet))
							val createURI = URI::createFileURI(f.location.toOSString)
							var Resource resource = instance.getResource(createURI, true)

							val docker = resource.contents.get(0) as Docker
							interpreter.interpret(resource)

						}
					}
				}

			})

	// do magic
	}

	override void launch(IEditorPart editor, String mode) {
		System::out.println("called editor launch ") // do magoic

		Display.current.asyncExec(
			new Runnable() {

				override run() {
					if (editor.editorInput instanceof IFileEditorInput) {
						var element = URI.createFileURI(
							((editor.editorInput as IFileEditorInput)).file.fullPath.toOSString)
						
							var Injector injector = ContainerActivator::getInstance().getInjector(
								ContainerActivator::ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER)
							var ResourceSet instance = injector.getInstance(typeof(ResourceSet))

							var Resource resource = instance.getResource(element, true)

							val docker = resource.contents.get(0) as Docker
							var dialog = new DockerRunDialog(Display.current.activeShell,interpreter)
							
							interpreter.interpret(resource)

						
					}
				}

			})

	// do magic
	}
}
