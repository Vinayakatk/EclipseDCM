package org.eclipse.docker.language.ui.launch

import java.util.List

class IPAddressHolder {
	private static IPAddressHolder holder
	private List<String>ips
	
	def static getInstance(){
		if(holder==null){ new IPAddressHolder}
		holder
	}
	def addIp(String ip){
		if(ips==null) ips=newArrayList()
		ips.add(ip)
	}
	def getIPs(){ips}
}
