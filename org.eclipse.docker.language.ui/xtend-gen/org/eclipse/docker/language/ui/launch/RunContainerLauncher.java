package org.eclipse.docker.language.ui.launch;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.docker.language.DockerInterpreter;
import org.eclipse.docker.language.container.Docker;
import org.eclipse.docker.language.ui.internal.ContainerActivator;
import org.eclipse.docker.language.ui.launch.DockerConsole;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

@SuppressWarnings("all")
public class RunContainerLauncher implements ILaunchShortcut, ILaunchShortcut2, ILaunchConfigurationDelegate {
  @Inject
  private DockerInterpreter interpreter;
  
  private DockerConsole console = new DockerConsole();
  
  @Inject
  private Provider<ResourceSet> resourceSet;
  
  @Override
  public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor) throws CoreException {
    System.out.println("called launch");
  }
  
  @Override
  public ILaunchConfiguration[] getLaunchConfigurations(final ISelection selection) {
    System.out.println("called selected launch configuration");
    return null;
  }
  
  @Override
  public ILaunchConfiguration[] getLaunchConfigurations(final IEditorPart editorpart) {
    System.out.println("called editor launch configuration");
    return null;
  }
  
  @Override
  public IResource getLaunchableResource(final ISelection selection) {
    System.out.println("called selectable resource");
    if ((selection instanceof IStructuredSelection)) {
      Object[] _array = ((IStructuredSelection) selection).toArray();
      for (final Object element : _array) {
        if ((element instanceof IFile)) {
          return ((IResource) element);
        }
      }
    }
    return null;
  }
  
  @Override
  public IResource getLaunchableResource(final IEditorPart editorpart) {
    final IEditorInput input = editorpart.getEditorInput();
    if ((input instanceof FileEditorInput)) {
      return ((FileEditorInput) input).getFile();
    }
    return null;
  }
  
  @Override
  public void launch(final ISelection selection, final String mode) {
    Display _current = Display.getCurrent();
    _current.asyncExec(
      new Runnable() {
        @Override
        public void run() {
          if ((selection instanceof IStructuredSelection)) {
            Object element = ((IStructuredSelection) selection).getFirstElement();
            if ((element instanceof IFile)) {
              IFile f = ((IFile) element);
              ContainerActivator _instance = ContainerActivator.getInstance();
              Injector injector = _instance.getInjector(
                ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
              ResourceSet instance = injector.<ResourceSet>getInstance(ResourceSet.class);
              IPath _location = f.getLocation();
              String _oSString = _location.toOSString();
              final URI createURI = URI.createFileURI(_oSString);
              Resource resource = instance.getResource(createURI, true);
              EList<EObject> _contents = resource.getContents();
              EObject _get = _contents.get(0);
              final Docker docker = ((Docker) _get);
              RunContainerLauncher.this.interpreter.interpret(resource);
            }
          }
        }
      });
  }
  
  @Override
  public void launch(final IEditorPart editor, final String mode) {
    System.out.println("called editor launch ");
    Display _current = Display.getCurrent();
    _current.asyncExec(
      new Runnable() {
        @Override
        public void run() {
          IEditorInput _editorInput = editor.getEditorInput();
          if ((_editorInput instanceof IFileEditorInput)) {
            IEditorInput _editorInput_1 = editor.getEditorInput();
            IFile _file = ((IFileEditorInput) _editorInput_1).getFile();
            IPath _fullPath = _file.getFullPath();
            String _oSString = _fullPath.toOSString();
            URI element = URI.createFileURI(_oSString);
            ContainerActivator _instance = ContainerActivator.getInstance();
            Injector injector = _instance.getInjector(
              ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
            ResourceSet instance = injector.<ResourceSet>getInstance(ResourceSet.class);
            Resource resource = instance.getResource(element, true);
            EList<EObject> _contents = resource.getContents();
            EObject _get = _contents.get(0);
            final Docker docker = ((Docker) _get);
            RunContainerLauncher.this.interpreter.interpret(resource);
          }
        }
      });
  }
}
