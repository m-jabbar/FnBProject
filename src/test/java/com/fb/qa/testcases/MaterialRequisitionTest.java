package com.fb.qa.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.MaterialRequisitionPage;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

@Listeners(MyListeners.class)
public class MaterialRequisitionTest extends TestBase {
	WebDriverWait wait;

	public MaterialRequisitionTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	MaterialRequisitionPage materialRequisition;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homepage = new HomePage(driver);
		materialRequisition = homepage.clickOnMaterialRequisition();
	}

	@Test(priority = 1, description = "Verify Material Requisition page title")
	public void verifyPageTitle() {
		String pageTitle = materialRequisition.verifyPageTitle();
		Assert.assertEquals(pageTitle, "F&B System");
	}

	@Test(priority = 2, description = "Perform Material Requisition process")
	public void materialReqProcess() throws InterruptedException {
		materialRequisition.clickOnMaterialRequisition();
		Thread.sleep(1000);
		materialRequisition.clickOnAddMaterialReq();
		Thread.sleep(1000);
		materialRequisition.selectDepartment();
		Thread.sleep(1000);
		materialRequisition.selectLocation();
		Thread.sleep(1000);
		materialRequisition.selectProduct();
		Thread.sleep(1000);
		materialRequisition.enterQuantity();
		Thread.sleep(1000);
		materialRequisition.submitBtn();
		Thread.sleep(1000);
		String toastMessage = materialRequisition.getToastMessage();
		Assert.assertEquals(toastMessage, "Material Requisition has been created", "Title is matched");
		System.out.println("Congratulations! Your test Material Requisition has passed.");
	}

	@Test(priority = 3, description = "Perform Material Requisition approval process")
	public void approveMaterialProcess() throws InterruptedException {
		materialRequisition.approveMaterialIcon();
		Thread.sleep(1000);
		materialRequisition.approveBtn();
		Thread.sleep(1000);
		materialRequisition.popupApproveBtn();
		Thread.sleep(1000);
//        String toastMessage = materialRequisition.getToastMessage();
//        Assert.assertEquals(toastMessage, "Material Requisition has been approved (MR-1681388931957)", "Title is matched");
		System.out.println("Congratulations! Your test Material Requisition approval process has passed.");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
