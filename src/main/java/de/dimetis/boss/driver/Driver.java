package de.dimetis.boss.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import de.dimetis.boss.config.Constants.ConfigProperties;
import de.dimetis.boss.utility.properties.PropertitesUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	
	/**
	 * @author Ashok V H
	 * ${date}
	 * 
	 * 
	 * 
	 */
	
	private Driver() { 	}
	
	public static void initDriver(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			} else if (browser.equalsIgnoreCase("ie")) {

				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new InternetExplorerDriver());
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().get(PropertitesUtils.get(ConfigProperties.URL));
		}

	}
	
	public static void closeDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
