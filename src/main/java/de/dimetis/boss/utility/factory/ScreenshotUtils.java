package de.dimetis.boss.utility.factory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import de.dimetis.boss.driver.DriverManager;

public final class ScreenshotUtils {

	private ScreenshotUtils() { }
	
	public static String getImages() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
