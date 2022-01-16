package de.dimetis.boss.config;

import de.dimetis.boss.utility.properties.PropertitesUtils;

public final class Constants {
	
	private Constants() {	}
	
	public enum WaitStrategy{
		CLICKABLE,
		PRESENCE,
		VISIBLE,
		NONE
	}
	
	public enum ConfigProperties{
		URL,
		OVERRIDEREPORTS,
		PASSEDSCREENSHOTS,
		FAILEDSCREENSHOTS,
		SKIPEDSCREENSHOTS,
		RETRYFAILEDTESTS,
		BROWSER;
	}
	
	
	public enum CategoryType{
		SMOKE,
		SANITY,
		REGRESSION
	}

	private static final int EXPLICITWAIT = 10;
	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "/conf/config.properties";
	private static final String JSONCONFIGFILEPATH = RESOURCEPATH + "/json/config.json";
	private static final String PASSEDREPORTSPATH = RESOURCEPATH + "/reports/passReports";
	private static final String FAILEDREPORTSPATH = RESOURCEPATH + "/reports/failedReports";
	private static final String REPORTCONFIGFILEPATH = RESOURCEPATH + "/conf/reportConfig.xml";
	private static final String EXCELPATH = RESOURCEPATH + "/excel/testData.xlsx";
	
	
	
	
	
	/**
	 * @return the getExcelpath
	 */
	public static String getExcelpath() {
		return EXCELPATH;
	}

	/**
	 * @return the report config file path
	 */
	public static String getReportconfigfilepath() {
		return REPORTCONFIGFILEPATH;
	}

	/**
	 * @return the failed reports path
	 * @throws Exception 
	 */
	public static String getFailedreportspath() throws Exception {
		if(PropertitesUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return FAILEDREPORTSPATH+"/"+"Failed_result_"+System.currentTimeMillis()+".html";
		}else {
			return FAILEDREPORTSPATH;
		}
	}

	/**
	 * @return the resource path
	 */
	public static String getResourcepath() {
		return RESOURCEPATH;
	}

	/**
	 * @return the passed reports path
	 * @throws Exception 
	 */
	public static String getPassedreportspath() throws Exception {
		if(PropertitesUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return PASSEDREPORTSPATH+"/"+"Index_"+System.currentTimeMillis()+".html";
		}else {
			return PASSEDREPORTSPATH;
		}
		
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}
}
