package com.javacodegeeks.patterns.proxypattern.remoteproxy;

import java.rmi.Remote;

public interface ReportGenerator extends Remote {
	
	public String generateDailyReport();

}
