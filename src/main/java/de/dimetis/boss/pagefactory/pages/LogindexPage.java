	package de.dimetis.boss.pagefactory.pages;

import org.openqa.selenium.By;

import de.dimetis.boss.base.BasePage;
import de.dimetis.boss.config.Constants.WaitStrategy;
import de.dimetis.boss.reports.ExtentLogger;
import de.dimetis.boss.utility.factory.DecodeUtils;

public final class LogindexPage extends BasePage {

	private final By inputOfUsername = By.name("username"); 
	private final By inputOfPassword = By.name("Password"); 
	private final By btnLoginOfBLMO = By.xpath("//div[text()='Login']");
	
	public LogindexPage entryOfUsername(String userName) {
		doSendkeys(inputOfUsername, userName, WaitStrategy.PRESENCE);
		ExtentLogger.pass(userName +"is entered successfully");
		return this;
	}
	
	public LogindexPage entryOfPassword(String password) {
		doSendkeys(inputOfPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE);
		ExtentLogger.pass("Password filed is entered successfully");
		return this;
	}
	
	public AdministratorPage clickOnLogin() throws Exception {
		doClick(btnLoginOfBLMO, WaitStrategy.CLICKABLE);
		ExtentLogger.pass("clicked login button successfully",true);
		return new AdministratorPage();
	}
	
}
