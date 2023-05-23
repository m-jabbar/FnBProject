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
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		materialRequisition = homepage.clickOnMaterialRequisition();
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		String PageTitle = materialRequisition.verifyPageTitle();
		Assert.assertEquals(PageTitle, "F&B System");
	}

	@Test(priority = 2)
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
	    System.out.println("Congrats your test is passed");
	}

	
	@Test(priority=3)
	public void approveMaterialProcess() throws InterruptedException {
		materialRequisition.approveMateriaIcon();
		Thread.sleep(1000);
		materialRequisition.approveSumbitBtn();
		Thread.sleep(1000);
		materialRequisition.againApproveSumbitBtn();
		Thread.sleep(1000);
//		String toastMessage = materialRequisition.getToastMessage();
//	    Assert.assertEquals(toastMessage, "Material Requisition has been approved (	MR-1681388931957)", "Title is matched");
	    System.out.println("Congrats your test is passed");
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();

	}

}
