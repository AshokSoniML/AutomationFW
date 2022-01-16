package de.dimetis.boss.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNIC {

	
	WebDriver driChrome;
	WebDriver driFirefox;
	
	
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driChrome = new ChromeDriver();
		driChrome.manage().window().maximize();
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		driChrome.get("https://www.flipkart.com/");
	}
	
	@Test(priority = 0)
	public void testService() {
		
		driChrome.findElement(By.xpath("//a[text()='Login']")).click();
		// menu-item-20197
		
		
	}
	
	//@Test(priority = 1)
	public void testProduct() {
		driChrome.findElement(By.id("menu-item-20197")).click();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Method function execuated");
	}
}
