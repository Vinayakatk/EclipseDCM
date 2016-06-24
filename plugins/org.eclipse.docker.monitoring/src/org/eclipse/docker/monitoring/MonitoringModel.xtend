package org.eclipse.docker.monitoring

import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.Active

@Accessors
class MonitoringModel {
	private CPUMonitoring cpu
	private MemoryMonitoring memory
	private NetworkMonitoring network
	private IOMonitoring io

	new() {
		createModels
	}

	def createModels() {
		cpu = new CPUMonitoring
		memory = new MemoryMonitoring
		network = new NetworkMonitoring
		io = new IOMonitoring
	}

}

class NetworkMonitoring {
	private int transmit
	private int receive
	def setTransmit(int value){
		transmit=value
	}
	def getTransmit(){transmit}
	def setReceive(int value){
		receive=value
	}
	def getReceive(){receive}
	
}


class IOMonitoring {
	private int read
	def setRead(int value){
		read=value
	}
	def getRead(){read}
	private int write
	def setWrite(int value){
		write=value
	}
	def getWrite(){write}
}


class MemoryMonitoring {
	private int limit
	def setLimit(int value){
		limit=value
	}
	def getLimit(){limit}
	private int utilized
	def setUtilized(int value){
		utilized=value
	}
	def getUtilized(){utilized}
	private float perc
	def setPerc(float value){
		perc=value
	}
	def getPerc(){perc}
}


class CPUMonitoring {
	private float percentage
		def setPercentage(float value){
		percentage=value
	}
	def getPercentage(){percentage}
}
