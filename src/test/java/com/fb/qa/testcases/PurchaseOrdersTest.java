package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.PurchaseOrders;
@Listeners(MyListeners.class)
public class PurchaseOrdersTest extends TestBase {

	public PurchaseOrdersTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homepage;
	PurchaseOrders purchaseorders;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		purchaseorders = homepage.clickOnPurchaseOrders();
	}
	
	
	@Test(priority=1)
	public void PurchaseOrdersProcess() throws InterruptedException {
		purchaseorders.clickOnPurchaseOrders();
		Thread.sleep(2000);
		purchaseorders.clickOnAddPurchaseOrders();
		Thread.sleep(2000);
		purchaseorders.selectPurcahseFor();
		Thread.sleep(1000);
		purchaseorders.selectSupplier();
		Thread.sleep(2000);
		purchaseorders.selectProduct();
		Thread.sleep(1000);
		purchaseorders.enterQunatityValue();
		Thread.sleep(1000);
		purchaseorders.enterRateValue();
		Thread.sleep(1000);
		purchaseorders.enterTaxValue();
		Thread.sleep(1000);
		purchaseorders.enterDiscountValue();
		Thread.sleep(1000);
		purchaseorders.clickOnSubmitBtn();
		Thread.sleep(2000);
//		purchaseorders.approvePurchaseProcess();
		
	}
	
	@Test(priority=2)
	public void ApprovePurchaseOrdersProcess() throws InterruptedException {
		purchaseorders.clickOnPurchaseOrders();
		Thread.sleep(1000);
		purchaseorders.approvePurchaseProcess();
		Thread.sleep(2000);
		
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

}
