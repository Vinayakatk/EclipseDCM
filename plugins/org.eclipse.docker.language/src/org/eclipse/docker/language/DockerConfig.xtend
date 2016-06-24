package org.eclipse.docker.language

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
@Singleton
class DockerConfig {
     String version;
  	
     String uri;
     String username;
     String password;
     String email;
     String serverAddress;
    
     String dockerCertPath;

}