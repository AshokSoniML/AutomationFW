package de.dimetis.boss.listeners;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RunnerClass {

	@BeforeSuite
	public void setUpSuite() {
		System.out.println("Before suite in runner ");
	}

	@AfterSuite
	public void tearDownSuite() {
		System.out.println("After suite in runner ");
	}

	@BeforeMethod
	public void setUpMethod() {
		System.out.println("Before method in runner ");
	}

	@AfterMethod
	public void tearDownMethod() {
		System.out.println("After metho in runner ");
	}

	@Test
	public void testOne() {
		System.out.println("Test 1 is running");
	}

	@Test
	public void testTwo() {
		System.out.println("Test 2 is running");
	}

	@Test
	public void testThree() {
		System.out.println("Test 3 is running");
	}

}
