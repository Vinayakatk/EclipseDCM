package org.eclipse.docker.diagram;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.docker.language.container.Docker;
import org.eclipse.docker.language.ui.internal.ContainerActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;

import com.google.inject.Injector;

import de.cau.cs.kieler.klighd.IDiagramWorkbenchPart;
import de.cau.cs.kieler.klighd.ui.DiagramViewManager;

/**
 * A simple handler for opening diagrams.
 */
public class OpenDiagramHandler extends AbstractHandler {

    /**
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
    	Injector injector = ContainerActivator.getInstance().getInjector(ContainerActivator.ORG_ECLIPSE_DOCKER_LANGUAGE_CONTAINER);
    	Docker docker = injector.getInstance(Docker.class);
//        final ISelection selection = HandlerUtil.getCurrentSelection(event);

//        if (selection instanceof IStructuredSelection) {
//            final IStructuredSelection sSelection  = (IStructuredSelection) selection;
//
//            final Object firstElement = sSelection.getFirstElement();
//            final Object model;
//
//            if (firstElement instanceof IFile) {
//                try {
//                    final ResourceSet rs = new ResourceSetImpl();
//                    final Resource r = rs.getResource(URI.createPlatformResourceURI(
//                            ((IFile) firstElement).getFullPath().toString(), true), true);
//                    EcoreUtil.resolveAll(r);
//
//                    if (r.getContents().size() > 0) {
//                        model = r.getContents().get(0);
//                        r.unload();
//                    } else {
//                        r.unload();
//                        return null;
//                    }
//
//                } catch (Exception e) {
//                    final String message = "Could not load selected file.";
//                    StatusManager.getManager().handle(
//                            new Status(IStatus.ERROR, this.getClass().getCanonicalName(), message, e),
//                            StatusManager.SHOW);
//                    return null;
//                }
//            } else {
//                model = firstElement;
//            }

            DiagramViewManager.createView(
                    "org.eclipse.docker.diagram.DockerDiagram", "Docker Diagram", docker);
//        } else {
//            MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Unsupported element",
//                    "KLighD diagram synthesis is unsupported for the current selection "
//                            + selection.toString() + ".");
//        }
        return null;
    }
}
