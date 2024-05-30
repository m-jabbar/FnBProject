package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.MaterialInspection;

public class MaterialInspectionTest extends TestBase {

	public MaterialInspectionTest() {
		super();
	}

	HomePage homepage;
	MaterialInspection materialInspection;

	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.driver = initialization();
		homepage = new HomePage(driver);
		materialInspection = homepage.clickOnMaterialInspection();
	}

	@Test(priority = 1, description = "Perform Material Inspection Process")
	public void testMaterialInspectionProcess() throws InterruptedException {
		materialInspection.clickOnAddMaterialInspection();
		Thread.sleep(1000);
		materialInspection.selectPurchaseOrderNumber();
		Thread.sleep(1000);
		materialInspection.enterInvoiceNumber();
		Thread.sleep(1000);
		materialInspection.selectLocation();
		Thread.sleep(1000);
		materialInspection.enterRemarksInAllFields();
		Thread.sleep(1000);
		materialInspection.submitBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! Your Inspection Test is Passed");
	}

	@Test(priority = 2, description = "Perform Approval for Material Inspection")
	public void testApproveInspectionProcess() throws InterruptedException {
		materialInspection.approveIcon();
		Thread.sleep(1000);
		materialInspection.approveBtn();
		Thread.sleep(1000);
		materialInspection.popupApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! Your Approve Inspection Test is Passed");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();
	}
}
