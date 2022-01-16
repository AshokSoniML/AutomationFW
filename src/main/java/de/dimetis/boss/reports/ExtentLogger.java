package de.dimetis.boss.reports;

import com.aventstack.extentreports.MediaEntityBuilder;

import de.dimetis.boss.config.Constants.ConfigProperties;
import de.dimetis.boss.utility.factory.ScreenshotUtils;
import de.dimetis.boss.utility.properties.PropertitesUtils;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertitesUtils.get(ConfigProperties.PASSEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getImages()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertitesUtils.get(ConfigProperties.FAILEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getImages()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertitesUtils.get(ConfigProperties.SKIPEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getImages()).build());
		} else {
			skip(message);
		}
	}

}
