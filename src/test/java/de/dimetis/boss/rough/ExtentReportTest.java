package de.dimetis.boss.rough;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportTest {

	@Test
	public void testExtentReport() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("ExntentReportTest.html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY,ViewName.AUTHOR}).apply();
		ExtentSparkReporter failedSpark = new ExtentSparkReporter("Failed-test-result-report.html").filter().statusFilter().as(new Status[] {Status.FAIL,Status.SKIP}).apply();
		failedSpark.config().setDocumentTitle("Failed test case report");
		/*
		 * final File CONF = new File(System.getProperty("user.dir") + "/src/test/resources/conf/reportConfig.xml"); 
		 * spark.loadXMLConfig(CONF);
		 */

		/*
		 * final File CONF = new File(System.getProperty("user.dir") +
		 * "/src/test/resources/json/reportConfig.json"); spark.loadJSONConfig(CONF);
		 */

		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Document Title of Extent Report");
		spark.config().setReportName("Report name of Extent Report"); 
		extent.attachReporter(spark, failedSpark);
		
		
		ExtentTest test = extent.createTest("First test case").assignAuthor("Ashok").assignCategory("SMOKE").assignDevice("Chrome");
		test.info("Information details");
		test.pass("Passed details");
		
		

		ExtentTest test1 = extent.createTest("Scenod test case").assignAuthor("Hosamani").assignCategory("REGRESSION").assignDevice("Firefox");
		test1.info("Information details");
		test1.fail("Failed details");
		
		ExtentTest test2 = extent.createTest("Scenod test case").assignAuthor("Hosamani").assignCategory("REGRESSION").assignDevice("Firefox");
		test2.info("Information details");
		test2.skip("Skipped Details");
		
		
		extent.flush();
	}
}
