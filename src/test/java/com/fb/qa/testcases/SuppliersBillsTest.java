package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.SuppliersBills;

public class SuppliersBillsTest extends TestBase {
	public SuppliersBillsTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	SuppliersBills suppliersBills;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		suppliersBills = homepage.clickOnSuppliersBills();
	}

	@Test(priority = 1)
	public void SuppliersBillsProcess() throws InterruptedException {
		suppliersBills.clickOnSuppliersBills();
		Thread.sleep(1000);
		suppliersBills.clickOnAddSuppliersBills();
		Thread.sleep(1000);
		suppliersBills.goodsReceiveNum();
		Thread.sleep(1000);
		suppliersBills.submitBtn();
		Thread.sleep(3000);
		System.out.println("Congrats your test1 is passed");
	}

	@Test(priority = 2)
	public void ApproveSuupliers() throws InterruptedException {
		suppliersBills.clickOnSuppliersBills();
		Thread.sleep(1000);
		suppliersBills.approveIcon();
		Thread.sleep(1000);
		suppliersBills.clickOnApproveBtn();
		Thread.sleep(1000);
		suppliersBills.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		String toastMessage = suppliersBills.getToastMessage();
		Assert.assertEquals(toastMessage, "Supplier bill has been approved", "Title is matched");
		System.out.println("Congrats your test2 is passed");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();
	}

}
