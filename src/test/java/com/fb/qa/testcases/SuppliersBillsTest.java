package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.SuppliersBills;

@Listeners(MyListeners.class)
public class SuppliersBillsTest extends TestBase {
	HomePage homepage;
	SuppliersBills suppliersBills;

	public SuppliersBillsTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initialization();
		homepage = new HomePage(driver);
		suppliersBills = homepage.clickOnSuppliersBills();
	}

	@Test(priority = 1, description = "Suppliers Bills Process")
	public void suppliersBillsProcess() throws InterruptedException {
		suppliersBills.addSuppliersBills();
		Thread.sleep(1000);
		suppliersBills.selectGoodsReceiveNum();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		suppliersBills.submitBtn();
		Thread.sleep(3000);
		System.out.println("Congratulations! Test 1 - Suppliers Bills Process is passed");
	}

	@Test(priority = 2, description = "Approve Suppliers")
	public void approveSuppliers() throws InterruptedException {
		suppliersBills.approveIcon();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		suppliersBills.approveBtn();
		Thread.sleep(1000);
		suppliersBills.popupApproveBtn();
		Thread.sleep(1000);
		String toastMessage = suppliersBills.getToastMessage();
		Assert.assertEquals(toastMessage, "Supplier bill has been approved", "Toast message is matched");
		System.out.println("Congratulations! Test 2 - Approve Suppliers is passed");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
