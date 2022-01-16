package de.dimetis.boss.pagefactory.pages;

import org.openqa.selenium.By;

import de.dimetis.boss.base.BasePage;
import de.dimetis.boss.config.Constants.WaitStrategy;
import de.dimetis.boss.reports.ExtentLogger;

public final class AdministratorPage extends BasePage {

	
	private final By logOut = By.xpath("//img[contains(@src,'/images/logout.png')]");
	private final By linkOfSecurity = By.xpath("//div[text()='Security']");
	
	
	public AdministratorPage clickOnSecurity() throws Exception {
		doClick(linkOfSecurity, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("Successfully clicked on security modules",true);
		return this;
	}
	
	public LogindexPage clickOnLogOut() throws Exception {
		doClick(logOut, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("successfully clicked on logout button",true);
		return new LogindexPage();
	}
}
