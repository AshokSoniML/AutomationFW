package de.dimetis.boss.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import de.dimetis.boss.config.Constants.WaitStrategy;
import de.dimetis.boss.utility.factory.WaitElement;

public class BasePage {

	protected void doClick(By by, WaitStrategy waitstrtaegy) {
		WebElement element = WaitElement.performExplicitWait(waitstrtaegy, by);
		element.click();
	}

	protected void doClear(By by, WaitStrategy waitstrtaegy) {
		WebElement element = WaitElement.performExplicitWait(waitstrtaegy, by);
		element.clear();
	}

	protected void doSendkeys(By by, String value, WaitStrategy waitstrtaegy) {
		WebElement element = WaitElement.performExplicitWait(waitstrtaegy, by);
		element.sendKeys(value);
	}

}
