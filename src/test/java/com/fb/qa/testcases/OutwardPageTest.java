package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MaterialIssuancePage;
import com.fb.qa.pages.OutwardPage;

@Listeners(MyListeners.class)
public class OutwardPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	MaterialIssuancePage addmaterialreq;
	OutwardPage outwardPage;

	public OutwardPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homepage = new HomePage(driver);
		outwardPage = homepage.clickOnOutward();
	}

	@Test(priority = 1, description = "Perform the outward process")
	public void outwardProcess() throws InterruptedException {
		outwardPage.clickOnAddOutward();
		Thread.sleep(1000);
		outwardPage.selectIssuanceNum();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		outwardPage.enterRemarksInAllFields();
		Thread.sleep(1000);
		outwardPage.submitBtn();
		Thread.sleep(2000);
		System.out.println("Congrats! your Outward Test is Passed");

	}

	@Test(priority = 2, description = "Approve the outward process")
	public void approveOutwardProcess() throws InterruptedException {
		outwardPage.approveIcon();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		outwardPage.approveBtn();
		Thread.sleep(1000);
		outwardPage.popupApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! your Approve Outward Test is Passed");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();
	}
}
