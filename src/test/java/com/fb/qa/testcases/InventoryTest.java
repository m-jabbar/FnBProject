package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.InventoryPage;
import com.fb.qa.pages.LoginPage;

@Listeners(MyListeners.class)
public class InventoryTest extends TestBase {
	public InventoryTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	InventoryPage inventory;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initialization();
		homepage = new HomePage(driver);
		inventory = homepage.clickOnInventory();
	}

	@Test
	public void inventoryProcess() throws InterruptedException {
		inventory.addInventory();
		Thread.sleep(1000);
		inventory.selectInventoryType();
		Thread.sleep(1000);
		inventory.enterReference("It Is Mine");
		Thread.sleep(1000);
		inventory.selectProduct();
		Thread.sleep(1000);
		inventory.selectLocation();
		Thread.sleep(1000);
		inventory.enterQuantity("10");
		Thread.sleep(1000);
		inventory.selectExpiryDate();
		Thread.sleep(1000);
		scrollDown(driver, 0, 200);
		inventory.submitBtn();
		Thread.sleep(1000);
		String toastMessage = inventory.getToastMessage();
		Assert.assertEquals(toastMessage, "Inventory has been created", "Title is matched");
		System.out.println("Congratulations! Your test has passed.");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
