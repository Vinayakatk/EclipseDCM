package org.eclipse.docker.language

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.command.CreateContainerCmd
import com.github.dockerjava.api.model.BuildResponseItem
import com.github.dockerjava.api.model.Capability
import com.github.dockerjava.api.model.Ports
import com.github.dockerjava.api.model.RestartPolicy
import com.github.dockerjava.core.command.BuildImageResultCallback
import com.google.inject.Provider
import java.io.File
import java.util.List
import javax.inject.Inject
import org.eclipse.docker.language.container.AccessMode
import org.eclipse.docker.language.container.Bind
import org.eclipse.docker.language.container.Binding
import org.eclipse.docker.language.container.Container
import org.eclipse.docker.language.container.ContainerPackage
import org.eclipse.docker.language.container.Device
import org.eclipse.docker.language.container.ExposedPort
import org.eclipse.docker.language.container.Image
import org.eclipse.docker.language.container.Label
import org.eclipse.docker.language.container.Link
import org.eclipse.docker.language.container.PortBinding
import org.eclipse.docker.language.container.Ulimit
import org.eclipse.docker.language.container.Volume
import org.eclipse.docker.language.container.VolumesFrom
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.ui.util.ResourceUtil
import org.eclipse.docker.language.container.Docker

class DockerInterpreterImpl implements DockerInterpreter {

	
	
	DockerClient dockerClient
	@Inject
	public new(Provider<DockerClient> provider) {
		dockerClient = provider.get
	}

	override interpret(Resource resource) {
		 var docker = (resource.contents.get(0) as Docker)
		docker.runtime.sequence.forEach[it.interpret]
	}

	def dispatch void interpret(Container container) {
	

		var command = dockerClient.createContainerCmd(container.image)
		if (container.eGet(ContainerPackage.eINSTANCE.container_Name) != null) {
			command.withName(container.name)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Binds) != null) {
			container.binds.interpretBinds(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_CapabilityAdd) != null) {
			container.capabilityAdd.interpretCapAdd(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_CapabilityDrop) != null) {
			container.capabilityDrop.interpretCapDrop(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Commands) != null) {
			container.commands.interpretCommands(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_ContainerIDFile) != null) {
			container.containerIDFile.interpretContainerIDFile(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_CpusetCpus) != null) {
			container.cpusetCpus.interpretCpusetCpus(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_CpuPeriod) != null) {
			container.cpuPeriod.intrepretCpuPeriod(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_CpusetMems) != null) {
			container.cpusetMems.interpretCpusetMems(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_CpuShares) != null) {
			container.cpuShares.interpretCpuShares(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Devices) != null) {
			container.devices.interpretDevices(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Dns) != null) {
			container.dns.interpretDns(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_DnsSearch) != null) {
			container.dnsSearch.interpretDnsSearch(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_DomainName) != null) {
			container.domainName.interpretDomainName(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Entrypoint) != null) {
			container.entrypoint.interpretEntryPOint(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Env) != null) {
			container.env.interpretEnv(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_ExposedPorts) != null) {
			container.exposedPorts.interpretExposedPOrts(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_ExtraHosts) != null) {
			container.extraHosts.interpretExtraHosts(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Labels) != null) {
			container.labels.interpretLabels(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Links) != null) {
			container.links.interpretLinks(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_MacAddress) != null) {
			container.macAddress.interpretMac(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Memory) != null) {
			container.memory.interpretMemory(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_MemorySwap) != null) {
			container.memorySwap.interpretMemorySwap(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_DisableNetwork) != null) {
			container.disableNetwork.interpretDisableNetwork(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_NetworkMode) != null) {
			container.networkMode.interpretMode(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_PortBindings) != null) {
			container.portBindings.interpretPortBindings(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Privileged) != null) {
			container.privileged.intrepretPrivileged(command)
		}

		if (container.eGet(ContainerPackage.eINSTANCE.container_PublishAllPorts) != null) {
			container.publishAllPorts.interpretPublishAllPorts(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_ReadonlyRootfs) != null) {
			container.readonlyRootfs.interpretReadonlyRootfs(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_PidMode) != null) {
			container.pidMode.interpretPidMode(command)
		}
//		if (container.eGet(ContainerPackage.eINSTANCE.container_CgroupParent) != null) {
//			container.cgroupParent.interpretCgroupParent(command)
//		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_WorkingDir) != null) {
			container.workingDir.interpretWorkingDir(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_User) != null) {
			container.user.interpretUser(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Tty) != null) {
			container.tty.interpretTTy(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_RestartPolicy) != null) {
			container.restartPolicy.interpretRestartPolicy(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Volumes) != null) {
			container.volumes.interpretVolumes(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_VolumesFrom) != null) {
			container.volumesFrom.interpretVolumesFrom(command)
		}
		if (container.eGet(ContainerPackage.eINSTANCE.container_Ulimits) != null) {
			container.ulimits.interpretULimits(command)
		}
		var response=command.exec
		println(response.id)

	}

	def void interpretCpusetMems(String value, CreateContainerCmd command) {
		command.withCpusetMems(value)
	}

	def void interpretDevices(EList<Device> list, CreateContainerCmd command) {
		command.withDevices(list.map[toDevice])
	}

	def toDevice(Device dev) {
		var dev2 = new com.github.dockerjava.api.model.Device(dev.CGroupPermissions, dev.pathInContainer,
			dev.pathOnHost)
		dev2
	}

	def void interpretDns(EList<String> list, CreateContainerCmd command) {
		command.withDns(list)
	}

	def void interpretDnsSearch(EList<String> list, CreateContainerCmd command) {
		command.withDnsSearch(list)
	}

	def interpretDomainName(String string, CreateContainerCmd command) {
		command.withDomainName(string)
	}

	def void interpretCpuShares(int value, CreateContainerCmd command) {
		command.withCpuShares(value)
	}

	def void interpretEntryPOint(EList<String> list, CreateContainerCmd command) {
		command.withEntrypoint(list)
	}

	def void interpretEnv(EList<String> list, CreateContainerCmd command) {
		command.withEnv(list)
	}

	def void interpretExposedPOrts(EList<ExposedPort> list, CreateContainerCmd command) {
		command.withExposedPorts(list.map[toExposedPort])
	}

	def toExposedPort(ExposedPort port) {
		switch (port.protocol) {
			case TCP: com.github.dockerjava.api.model.ExposedPort.tcp(new Integer(port.port))
			case UDP: com.github.dockerjava.api.model.ExposedPort.udp(new Integer(port.port))
		}
	}

	def void interpretExtraHosts(EList<String> list, CreateContainerCmd command) {
		command.withExtraHosts(list)
	}

	def void interpretLabels(EList<Label> list, CreateContainerCmd command) {
		var map = newHashMap()
		for (element : list) {
			map.put(element.key, element.value)
		}
		command.withLabels(map)

	}

	def void interpretLinks(EList<Link> list, CreateContainerCmd command) {
		command.withLinks(list.map[toLink])
	}

	def toLink(Link link) {
		new com.github.dockerjava.api.model.Link(link.containerLink,link.alias)
	}

	def interpretMac(String string, CreateContainerCmd command) {
		command.withMacAddress(string)
	}

	def void interpretMemory(long value, CreateContainerCmd command) {
		command.withMemoryLimit(value)
	}

	def void interpretMemorySwap(long value, CreateContainerCmd command) {
		command.withMemorySwap(value)
	}

	def void interpretDisableNetwork(boolean value, CreateContainerCmd command) {
		command.withNetworkDisabled(value)
	}

	def interpretMode(String string, CreateContainerCmd command) {
		command.withNetworkMode(string)
	}

	def void interpretPortBindings(EList<PortBinding> list, CreateContainerCmd command) {
		command.withPortBindings(list.map[toBindings])
	}

	def toBindings(PortBinding bindings) {
		var bnd = bindings.binding.toBinding
		var exp = bindings.exposedPort.toExposedPort
		new com.github.dockerjava.api.model.PortBinding(bnd, exp)

	}

	def toBinding(Binding binding) {
		Ports.Binding(binding.hostPort)
	}

	def void intrepretPrivileged(boolean value, CreateContainerCmd command) {
		command.withPrivileged(value)
	}

	def void interpretReadonlyRootfs(boolean value, CreateContainerCmd command) {
		command.withReadonlyRootfs(value)
	}

	def interpretPidMode(String string, CreateContainerCmd command) {
		command.withPidMode(string)
	}

//	def interpretCgroupParent(String string, CreateContainerCmd command) {
//		command.with
//	}
	def interpretWorkingDir(String string, CreateContainerCmd command) {
		command.withWorkingDir(string)
	}

	def interpretUser(String string, CreateContainerCmd command) {
		command.withUser(string)
	}

	def void interpretPublishAllPorts(boolean value, CreateContainerCmd command) {
		command.withPublishAllPorts(value)
	}

	def void interpretTTy(boolean tty, CreateContainerCmd command) {
		command.withTty(tty)
	}

	def void interpretRestartPolicy(org.eclipse.docker.language.container.RestartPolicy policy, CreateContainerCmd command) {
		command.withRestartPolicy(policy.toPolicy)
	}

	def toPolicy(org.eclipse.docker.language.container.RestartPolicy policy) {
		switch (policy.value) {
			case "always": {
				RestartPolicy.alwaysRestart
			}
			case "onFailure": {
				RestartPolicy.onFailureRestart(policy.maximumRetryCount)

			}
			case "none": {
				RestartPolicy.noRestart
			}
			default: {
				RestartPolicy.alwaysRestart

			}
		}
	}

	def void interpretVolumes(EList<Volume> list, CreateContainerCmd command) {
		command.withVolumes(list.map[toVolume])
	}

	def void interpretVolumesFrom(EList<VolumesFrom> list, CreateContainerCmd command) {
		command.withVolumesFrom(list.map[toVolumesFrom])
	}
	
	def toVolumesFrom(VolumesFrom from) {
		if(from.accessMode!=null){
			new com.github.dockerjava.api.model.VolumesFrom(from.container,switch (from.accessMode) {
				case RO: {
					com.github.dockerjava.api.model.AccessMode.ro
				}
				case RW: {
					com.github.dockerjava.api.model.AccessMode.rw
				}
			}
				
			)
		}
		else{
			new com.github.dockerjava.api.model.VolumesFrom(from.container)
		}
	}

	def void interpretULimits(EList<Ulimit> list, CreateContainerCmd command) {
		command.withUlimits(list.map[toUlimit])
	}

	def toUlimit(Ulimit limit) {
		var limit2 = new com.github.dockerjava.api.model.Ulimit(limit.name, limit.soft, limit.hard)
		limit2

	}

	def void interpretCapDrop(EList<org.eclipse.docker.language.container.Capability> list,
		CreateContainerCmd command) {
		command.withCapAdd(list.map[toCapability])
	}

	def void interpretCapAdd(EList<org.eclipse.docker.language.container.Capability> list, CreateContainerCmd command) {
		command.withCapAdd(list.map[toCapability])
	}

	def interpretContainerIDFile(String string, CreateContainerCmd command) {
		command.withContainerIDFile(string)
	}

	def void intrepretCpuPeriod(int cpuPeriod, CreateContainerCmd command) {
		command.withCpuPeriod(cpuPeriod)
	}

	def void interpretCommands(EList<String> list, CreateContainerCmd command) {
		command.withCmd(list)
	}

	def void interpretImage(String image, CreateContainerCmd command) {
		command.withImage(image)
	}
	
	def void interpretImage(Image image) {
		val buildImageCmd = dockerClient.buildImageCmd
		val BuildImageResultCallback callback = new BuildImageResultCallback() {
	    @Override
	    override void onNext(BuildResponseItem item) {
	       System.out.println("" + item);
	       super.onNext(item);
	    	}
		};

		if (image.eGet(ContainerPackage.eINSTANCE.image_Tag) != null) {
			buildImageCmd.withTag(image.tag)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_ForceRM) != null) {
			buildImageCmd.withForcerm(image.forceRM)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Cpusetcpus) != null) {
			buildImageCmd.withCpusetcpus(image.cpusetcpus)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Cpushares) != null) {
			buildImageCmd.withCpushares(image.cpushares)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_DockerFilelocation) != null) {
		var resource = image.eResource
		var absFile=new File(image.dockerFilelocation)
			if(absFile.isAbsolute) buildImageCmd.withDockerfile(absFile)
			else{
			var file = ResourceUtil.getFile(resource).project.getFile(image.dockerFilelocation).location.toFile
			buildImageCmd.withDockerfile(file)
		}}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Memory) != null) {
			buildImageCmd.withMemory(image.memory)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Memswap) != null) {
			buildImageCmd.withMemswap(image.memswap)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_NoCache) != null) {
			buildImageCmd.withNoCache(image.noCache)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Name) != null) {
			
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Pull) != null) {
			buildImageCmd.withPull(image.pull)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Quiet) != null) {
			buildImageCmd.withQuiet(image.quiet)
		}
		if (image.eGet(ContainerPackage.eINSTANCE.image_Remove) != null) {
			buildImageCmd.withRemove(image.remove)
		}
//		if (image.eGet(ContainerPackage.eINSTANCE.image_Buildargs) != null) {
//			buildImageCmd.with
//		}
		buildImageCmd.exec(callback).awaitImageId

	}

	def toCapability(org.eclipse.docker.language.container.Capability cap) {
		switch (cap) {
			case ALL: Capability.ALL
			case AUDIT_CONTROL: Capability.AUDIT_CONTROL
			case AUDIT_WRITE: Capability.AUDIT_WRITE
			case BLOCK_SUSPEND: Capability.BLOCK_SUSPEND
			case CHOWN: Capability.CHOWN
			case DAC_OVERRIDE: Capability.DAC_OVERRIDE
			case DAC_READ_SEARCH: Capability.DAC_READ_SEARCH
			case FOWNER: Capability.FOWNER
			case FSETID: Capability.FSETID
			case IPC_LOCK: Capability.IPC_LOCK
			case IPC_OWNER: Capability.IPC_OWNER
			case KILL: Capability.KILL
			case LEASE: Capability.LEASE
			case LINUX_IMMUTABLE: Capability.LINUX_IMMUTABLE
			case MAC_ADMIN: Capability.MAC_ADMIN
			case MAC_OVERRIDE: Capability.MAC_OVERRIDE
			case MKNOD: Capability.MKNOD
			case NET_ADMIN: Capability.NET_ADMIN
			case NET_BIND_SERVICE: Capability.NET_BIND_SERVICE
			case NET_BROADCAST: Capability.NET_BROADCAST
			case NET_RAW: Capability.NET_RAW
			case SETFCAP: Capability.SETFCAP
			case SETGID: Capability.SETGID
			case SETPCAP: Capability.SETPCAP
			case SETUID: Capability.SETUID
			case SYS_ADMIN: Capability.SYS_ADMIN
			case SYS_BOOT: Capability.SYS_BOOT
			case SYS_CHROOT: Capability.SYS_CHROOT
			case SYS_MODULE: Capability.SYS_MODULE
			case SYS_NICE: Capability.SYS_NICE
			case SYS_PACCT: Capability.SYS_PACCT
			case SYS_PTRACE: Capability.SYS_PTRACE
			case SYS_RAWIO: Capability.SYS_RAWIO
			case SYS_RESOURCE: Capability.SYS_RESOURCE
			case SYS_TIME: Capability.SYS_TIME
			case SYSLOG: Capability.SYSLOG
			case SYS_TTY_CONFIG: Capability.SYS_TTY_CONFIG
		}
	}

	def void interpretBinds(List<Bind> binds, CreateContainerCmd command) {

		var binds2 = binds.map[toBind]
		command.withBinds(binds2)
	}

	def toBind(Bind bind) {
		if (bind.accessMode1 == null) {
			new com.github.dockerjava.api.model.Bind(bind.location, bind.volume.toVolume)
		} else {
			new com.github.dockerjava.api.model.Bind(bind.location, bind.volume.toVolume, switch (bind.accessMode1) {
				case AccessMode.RO: com.github.dockerjava.api.model.AccessMode.ro
				case AccessMode.RW: com.github.dockerjava.api.model.AccessMode.rw
			})
		}
	}

	def toVolume(Volume vol) {
		var volume = new com.github.dockerjava.api.model.Volume(vol.path)
		volume
	}

	def void interpretCpusetCpus(String cpusetCpus, CreateContainerCmd command) {
		command.withCpuset(cpusetCpus)
	}

}
