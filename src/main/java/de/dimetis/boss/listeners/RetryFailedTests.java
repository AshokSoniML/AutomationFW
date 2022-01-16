package de.dimetis.boss.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import de.dimetis.boss.config.Constants.ConfigProperties;
import de.dimetis.boss.utility.properties.PropertitesUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(PropertitesUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = count < retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
