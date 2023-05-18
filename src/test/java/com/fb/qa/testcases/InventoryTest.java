package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.Inventory;
import com.fb.qa.pages.LoginPage;

public class InventoryTest extends TestBase{
	public InventoryTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homepage;
	Inventory inventory;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventory = homepage.clickOnInventory();
	}
	@Test
	public void InventoryProcess() throws InterruptedException {
		inventory.clickOnInventory();
		Thread.sleep(1000);
		inventory.clickOnAddInventory();
		Thread.sleep(1000);
		inventory.selectInventoryType();
		Thread.sleep(1000);
		inventory.enterReferenceNo();
		Thread.sleep(1000);
		inventory.selectProduct();
		Thread.sleep(1000);
		inventory.selectLocation();
		Thread.sleep(1000);
		inventory.enterQuantity();
		Thread.sleep(1000);
		inventory.dateSelection();
		Thread.sleep(1000);
		inventory.submitBtn();
		Thread.sleep(1000);
		String toastMessage = inventory.getToastMessage();
	    Assert.assertEquals(toastMessage, "Inventory has been created", "Title is matched");
	    System.out.println("Congrats your test is passed");
	
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();
	}

}
