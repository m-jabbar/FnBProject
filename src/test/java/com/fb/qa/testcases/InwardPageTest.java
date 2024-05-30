package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.InwardPage;

@Listeners(MyListeners.class)
public class InwardPageTest extends TestBase {
	public InwardPageTest() {
		super();
	}

	HomePage homepage;
	InwardPage inward;

	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.driver = initialization();
		homepage = new HomePage(driver);
		inward = homepage.clickOnInward();
	}

	@Test(priority = 1, description = "Inward Process")
	public void inwardProcess() throws InterruptedException {
		inward.clickOnAddInward();
		Thread.sleep(1000);
		inward.selectInwardNumber();
		Thread.sleep(1000);
		inward.enterRemarksInAllFields();
		Thread.sleep(1000);
		inward.submitBtn();
		Thread.sleep(1000);
		System.out.println("Congratulation! Your Inward Process Test passed.");
	}

	@Test(priority = 2, description = "Approve Inward")
	public void approveInwardTest() throws InterruptedException {
		inward.approveIcon();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		inward.approveBtn();
		Thread.sleep(1000);
		inward.popupApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congratulation! Your approve Inward Process Test passed.");

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();
	}
}
