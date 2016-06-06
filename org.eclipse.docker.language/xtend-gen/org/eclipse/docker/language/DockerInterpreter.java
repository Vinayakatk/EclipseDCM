package org.eclipse.docker.language;

import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public interface DockerInterpreter {
  public abstract void interpret(final Resource resource);
}
