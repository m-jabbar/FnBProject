package com.fb.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fb.qa.base.TestBase;
import com.fb.qa.util.MyExtentReport;

public class MyListeners extends TestBase implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		extentReport = MyExtentReport.generateExtentReport();
	}

	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "Execution is Started");
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName + "Execution is Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println("Test failed, capturing screenshot for method: " + methodName);
		failTestCases(driver, methodName);
	}

	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + "Execution skipped");
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
