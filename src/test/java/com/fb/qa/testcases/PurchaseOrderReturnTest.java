package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.PurchaseOrderReturn;
@Listeners(MyListeners.class)
public class PurchaseOrderReturnTest extends TestBase{
	public PurchaseOrderReturnTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	PurchaseOrderReturn purchaseOrderReturn;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		purchaseOrderReturn = homepage.clickOnPurchaseOrderReturn();
	}

	@Test(priority = 1)
	public void SuppliersProcess() throws InterruptedException {
		purchaseOrderReturn.clickOnPurcahseOrderReturn();
		Thread.sleep(1000);
		purchaseOrderReturn.clickOnAddPurcahseOrderReturn();
		Thread.sleep(1000);
		purchaseOrderReturn.selectOrderNo();
		Thread.sleep(1000);
		purchaseOrderReturn.uploadFile();
		Thread.sleep(1000);
		purchaseOrderReturn.submitBtn();
		Thread.sleep(1000);
		System.out.println("Congrats your test1 is passed");
	}

	@Test(priority = 2)
	public void ApprovePurchaseOrderReturn() throws InterruptedException {
		purchaseOrderReturn.clickOnPurcahseOrderReturn();
		Thread.sleep(1000);
		purchaseOrderReturn.approveIcon();
		Thread.sleep(1000);
		purchaseOrderReturn.clickOnApproveBtn();
		Thread.sleep(1000);
		purchaseOrderReturn.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats your test2 is passed");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();
	}

}
