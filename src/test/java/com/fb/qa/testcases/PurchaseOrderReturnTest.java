package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.PurchaseOrderReturn;

@Listeners(MyListeners.class)
public class PurchaseOrderReturnTest extends TestBase {
	public PurchaseOrderReturnTest() {
		super();
	}

	HomePage homepage;
	PurchaseOrderReturn purchaseOrderReturn;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initialization();
		homepage = new HomePage(driver);
		purchaseOrderReturn = homepage.clickOnPurchaseOrderReturn();
	}

	@Test(priority = 1, description = "Purchase Order Process")
	public void purchaseOrderProcess() throws InterruptedException {
		purchaseOrderReturn.addPurchaseOrderReturn();
		Thread.sleep(1000);
		purchaseOrderReturn.selectPurchaseOrderNo();
		Thread.sleep(1000);
		purchaseOrderReturn.uploadFile();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		purchaseOrderReturn.submitBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! Your Purchase Order Test is Passed");
	}

	@Test(priority = 2, description = "Approve Purchase Order Process")
	public void approvePurchaseOrderReturn() throws InterruptedException {
		purchaseOrderReturn.approveIcon();
		Thread.sleep(1000);
		purchaseOrderReturn.clickOnApproveBtn();
		Thread.sleep(1000);
		scrollDown(driver, 0, 1000);
		purchaseOrderReturn.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! Your Approve Purchase Order Test is Passed");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
