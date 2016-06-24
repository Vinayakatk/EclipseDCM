package org.eclipse.docker.monitoring

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class StatsCallback {
	MonitoringModel model
	long prevcpu
	float prevsyscpu
	float prevPerc
	float preMemUsage
	int prerx
	int pretx
	int preread
	int prewrite

	new(MonitoringModel model, int prevcpu, float prevsyscpu, float prevPerc, float preMemUsage, int prerx, int pretx,
		int preread, int prewrite) {
		this.model = model
		this.prevcpu = prevcpu
		this.prevsyscpu = prevsyscpu
		this.prevPerc = prevPerc
		this.preMemUsage = preMemUsage
		this.prerx = prerx
		this.pretx = pretx
		this.preread = preread
		this.prewrite = prewrite
	}
}
