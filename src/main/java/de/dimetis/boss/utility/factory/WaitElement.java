package de.dimetis.boss.utility.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.dimetis.boss.config.Constants;
import de.dimetis.boss.config.Constants.WaitStrategy;
import de.dimetis.boss.driver.DriverManager;

public class WaitElement {

	@SuppressWarnings("deprecation")
	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitstrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Constants.getExplicitwait())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitstrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
