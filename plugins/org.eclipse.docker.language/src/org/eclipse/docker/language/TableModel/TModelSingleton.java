package org.eclipse.docker.language.TableModel;

import java.util.List;

import com.google.common.collect.Lists;

public class TModelSingleton {
	private static  TModelSingleton tmodel=null;
	private List<CData> entries;
	public List<CData> getEntries() {
		return entries;
	}
	
	private TModelSingleton() {
		entries = Lists.newArrayList();
	}
	
	public static TModelSingleton getModel(){
		if(tmodel==null)tmodel= new TModelSingleton();
		return tmodel;
	}

}
