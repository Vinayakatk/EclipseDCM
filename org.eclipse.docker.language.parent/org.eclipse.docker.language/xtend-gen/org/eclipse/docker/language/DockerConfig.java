package org.eclipse.docker.language;

import com.google.inject.Singleton;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@Singleton
@SuppressWarnings("all")
public class DockerConfig {
  private String version;
  
  private String uri;
  
  private String username;
  
  private String password;
  
  private String email;
  
  private String serverAddress;
  
  private String dockerCertPath;
  
  @Pure
  public String getVersion() {
    return this.version;
  }
  
  public void setVersion(final String version) {
    this.version = version;
  }
  
  @Pure
  public String getUri() {
    return this.uri;
  }
  
  public void setUri(final String uri) {
    this.uri = uri;
  }
  
  @Pure
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(final String username) {
    this.username = username;
  }
  
  @Pure
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(final String password) {
    this.password = password;
  }
  
  @Pure
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(final String email) {
    this.email = email;
  }
  
  @Pure
  public String getServerAddress() {
    return this.serverAddress;
  }
  
  public void setServerAddress(final String serverAddress) {
    this.serverAddress = serverAddress;
  }
  
  @Pure
  public String getDockerCertPath() {
    return this.dockerCertPath;
  }
  
  public void setDockerCertPath(final String dockerCertPath) {
    this.dockerCertPath = dockerCertPath;
  }
}
