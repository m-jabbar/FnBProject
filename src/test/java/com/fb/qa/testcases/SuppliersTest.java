package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.Suppliers;

public class SuppliersTest extends TestBase {

	public SuppliersTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	Suppliers suppliers;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		suppliers = homepage.clickOnSuppliers();
	}

	@Test(priority = 1)
	public void SuppliersProcess() throws InterruptedException {
		suppliers.clickOnSuppliers();
		Thread.sleep(1000);
		suppliers.clickOnAddSuupliers();
		Thread.sleep(1000);
		suppliers.enterName();
		Thread.sleep(1000);
		suppliers.addAddres();
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
		suppliers.proCapacity();
		Thread.sleep(1000);
		suppliers.fbrRegisterNo();
		Thread.sleep(1000);
		suppliers.orderCapacity();
		Thread.sleep(1000);
		suppliers.selectMarketPR();
		Thread.sleep(1000);
		suppliers.selectcutomerRelation();
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
		System.out.println("Congrats your test1 is passed");
	}

	@Test(priority = 2)
	public void ApproveSuupliers() throws InterruptedException {
		suppliers.clickOnSuppliers();
		suppliers.approveIcon();
		Thread.sleep(1000);
		suppliers.clickOnApproveBtn();
		Thread.sleep(1000);
		suppliers.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		String toastMessage1 = suppliers.getToastMessage();
		Assert.assertEquals(toastMessage1, "Supplier has been approved (jabbar123)", "Title is matched");
		System.out.println("Congrats your test is passed");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();
	}
}
