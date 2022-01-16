package de.dimetis.boss.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import de.dimetis.boss.reports.ExtentLogger;
import de.dimetis.boss.reports.ExtentReport;
import de.dimetis.boss.utility.factory.CustomAnnotation;

public class ListenersClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		try {
			ISuiteListener.super.onStart(suite);
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ISuiteListener.super.onFinish(suite);
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ITestListener.super.onTestFailure(result);
			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed", true);
			ExtentLogger.fail(result.getThrowable().toString(),true);
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}
	
	
}
