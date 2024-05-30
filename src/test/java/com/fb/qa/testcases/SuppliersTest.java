package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.Suppliers;

@Listeners(MyListeners.class)
public class SuppliersTest extends TestBase {

	public SuppliersTest() {
		super();
	}

	HomePage homepage;
	Suppliers suppliers;

	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.driver = initialization();
		homepage = new HomePage(driver);
		suppliers = homepage.clickOnSuppliers();
	}

	@Test(priority = 1, description = "Test to add a supplier")
	public void SuppliersProcess() throws InterruptedException {
		suppliers.addSuppliers();
		Thread.sleep(1000);
		suppliers.enterName();
		Thread.sleep(1000);
		suppliers.addAddress();
		Thread.sleep(1000);
		suppliers.addCity();
		Thread.sleep(1000);
		suppliers.addPhoneNo();
		Thread.sleep(1000);
		suppliers.addNTNNo();
		Thread.sleep(1000);
		suppliers.addSTRN();
		Thread.sleep(1000);
		suppliers.addBankName();
		Thread.sleep(1000);
		suppliers.addAccountTitle();
		Thread.sleep(1000);
		suppliers.addIBANNo();
		Thread.sleep(1000);
		scrollDown(driver, 0, 600);
		suppliers.proCapacity();
		Thread.sleep(1000);
//		suppliers.fbrRegisterStatus();
		Thread.sleep(1000);
		suppliers.orderCapacity();
		Thread.sleep(1000);
		suppliers.selectMarketPR();
		Thread.sleep(1000);
		suppliers.selectCustomerRelation();
		Thread.sleep(1000);
		suppliers.paymentTerms();
		Thread.sleep(1000);
		suppliers.productName();
		Thread.sleep(1000);
		suppliers.giveDescription();
		Thread.sleep(1000);
		suppliers.submitBtn();
		Thread.sleep(1000);
		String toastMessage = suppliers.getToastMessage();
		Assert.assertEquals(toastMessage, "Supplier has been created", "Title is matched");
		System.out.println("Congratulations! Your Add Supplier test is Passed");
	}

	@Test(priority = 2, description = "Test to approve a supplier")
	public void ApproveSuppliers() throws InterruptedException {
		suppliers.approveIcon();
		scrollDown(driver, 0, 900);
		Thread.sleep(1000);
		suppliers.approveBtn();
		Thread.sleep(1000);
		suppliers.popupApproveBtn();
		Thread.sleep(1000);
		/*
		 * String toastMessage1 = suppliers.getToastMessage();
		 * Assert.assertEquals(toastMessage1, "Supplier has been approved (jabbar123)",
		 * "Title is matched");
		 */
		System.out.println("Congratulations! Your Approve Supplier test is Passed");
	}

	@AfterMethod
	public void tearDown() {
		    super.tearDown();
	}

}
