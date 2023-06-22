package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.PurchaseOrders;

@Listeners(MyListeners.class)
public class PurchaseOrdersTest extends TestBase {
	private HomePage homepage;
	private PurchaseOrders purchaseOrders;

	public PurchaseOrdersTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homepage = new HomePage(driver);
		purchaseOrders = homepage.clickOnPurchaseOrders();
	}

	@Test(priority = 1, description = "Create a new Purchase Order")
	public void purchaseOrderProcess() throws InterruptedException {
		purchaseOrders.addPurchaseOrders();
		Thread.sleep(2000);
		purchaseOrders.selectPurchaseFor();
		Thread.sleep(1000);
		purchaseOrders.selectSupplier();
		Thread.sleep(2000);
		scrollDown(driver, 0, 800);
		purchaseOrders.selectProduct();
		Thread.sleep(1000);
		purchaseOrders.enterQuantityValue();
		Thread.sleep(1000);
		purchaseOrders.enterRateValue();
		Thread.sleep(1000);
		purchaseOrders.enterTaxValue();
		Thread.sleep(1000);
		purchaseOrders.enterDiscountValue();
		Thread.sleep(1000);
		purchaseOrders.submitBtn();
		Thread.sleep(2000);
		System.out.println("Congrats! your Purchase Orders Test is Passed");
	}

	@Test(priority = 2, description = "Approve Purchase Order")
	public void approvePurchaseOrderProcess() throws InterruptedException {
		purchaseOrders.approveIcon();
		Thread.sleep(1000);
		scrollDown(driver, 0, 1000);
		purchaseOrders.approveBtn();
		Thread.sleep(1000);
		purchaseOrders.popupApproveBtn();
		Thread.sleep(2000);
		System.out.println("Congrats! your Approve Purchase Orders Test is Passed");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
