package de.dimetis.boss.utility.factory;

public final class DynamicXpathUtils {

	private DynamicXpathUtils() {	}
	
	public static String getXpath(String xpath, String value) {
		return xpath.replace("%valueString%", value);
	}
}
