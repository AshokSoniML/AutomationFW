package de.dimetis.boss.rough;

import java.util.Map;

import org.testng.annotations.Test;

import de.dimetis.boss.base.BaseTest;
import de.dimetis.boss.config.Constants.CategoryType;
import de.dimetis.boss.pagefactory.pages.AdministratorPage;
import de.dimetis.boss.pagefactory.pages.LogindexPage;
import de.dimetis.boss.utility.factory.CustomAnnotation;

public class LoginOfAdministrator extends BaseTest {

	private LoginOfAdministrator() { }
	
	LogindexPage login;
	AdministratorPage admin;

	@CustomAnnotation(author = { "Ashok" }, category = {CategoryType.SMOKE })
	@Test
	public void testForLoginLinkmanager(Map<String, String> data) throws Exception {
		login = new LogindexPage();
		//Assertions.assertThat(DriverManager.getDriver().getTitle()).isNotNull();
		
		admin = login.entryOfUsername(data.get("username")).entryOfPassword(data.get("password")).clickOnLogin();
		admin.clickOnSecurity().clickOnLogOut();
	}
	
	@Test
	public void testForLogin(Map<String, String> data) throws Exception {
		login = new LogindexPage();
		admin = login.entryOfUsername(data.get("username")).entryOfPassword(data.get("password")).clickOnLogin();
		admin.clickOnSecurity().clickOnLogOut();
	}
}
