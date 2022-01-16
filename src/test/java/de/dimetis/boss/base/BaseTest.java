package de.dimetis.boss.base;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import de.dimetis.boss.driver.Driver;

public class BaseTest {
	
	protected BaseTest(){
		
	}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void beforeMethod(Object[] data) {
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}
	
	
	@AfterMethod
	public void afterMethod() {
		Driver.closeDriver();
	}
	
}
