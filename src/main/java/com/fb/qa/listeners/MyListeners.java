package com.fb.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
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

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failed test");
		failTestCases(result.getMethod().getMethodName());
		
		/*String testName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		if (driver != null) {
			try {
				File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenshotPath = System
						.getProperty("C:\\Users\\muhammad.jabbar\\eclipse-workspace\\fbProject\\Screenshots\\scr.png");
				FileUtils.copyFile(srcScreenshot, new File(screenshotPath));
				FileHandler.copy(srcScreenshot, new File(screenshotPath));
				extentTest.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "Execution failed");*/
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
