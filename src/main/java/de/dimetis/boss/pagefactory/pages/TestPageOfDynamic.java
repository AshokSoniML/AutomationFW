package de.dimetis.boss.pagefactory.pages;

import org.openqa.selenium.By;

import de.dimetis.boss.base.BasePage;
import de.dimetis.boss.config.Constants.WaitStrategy;
import de.dimetis.boss.utility.factory.DynamicXpathUtils;

public class TestPageOfDynamic extends BasePage{

	private String link = "//a[text()='%replaceable%']";
	
	public void clickOnLink(String linkText) {
		String nPath = DynamicXpathUtils.getXpath(link, linkText);
		doClick(By.xpath(nPath), WaitStrategy.PRESENCE);
	}
}
