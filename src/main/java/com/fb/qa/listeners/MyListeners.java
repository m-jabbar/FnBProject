
package com.fb.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
		failTestCases(TestBase.driver, methodName);
	}

	public void failTestCases(WebDriver driver, String testMethodName) {
		if (driver != null) {
			try {
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String filePath = "C:\\Users\\muhammad.jabbar\\eclipse-workspace\\FBProject\\screenshots\\"
						+ testMethodName + ".jpg";
				FileUtils.copyFile(srcFile, new File(filePath));
				System.out.println("Screenshot captured for method: " + testMethodName + " at path: " + filePath);
			} catch (IOException e) {
				System.err.println("Error while capturing or saving the screenshot: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.err.println("Driver is null, cannot capture screenshot for method: " + testMethodName);
		}
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
