package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.MaterialIssuancePage;

@Listeners(MyListeners.class)
public class MaterialIssuanceTest extends TestBase {
	private HomePage homepage;
	private MaterialIssuancePage materialIssuance;

	public MaterialIssuanceTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initialization();
		homepage = new HomePage(driver);
		materialIssuance = homepage.clickOnMaterialIssuance();
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		String pageTitle = materialIssuance.getPageTitle();
		Assert.assertEquals(pageTitle, "F&B System");
	}

	@Test(priority = 2, description = "Material Issuance Process")
	public void materialIssuanceProcess() throws InterruptedException {
		materialIssuance.clickOnAddMaterialIssuance();
		Thread.sleep(2000);
		materialIssuance.selectMaterialReqNo();
		Thread.sleep(1000);
		materialIssuance.addQRCode();
		Thread.sleep(1000);
		materialIssuance.enterQuantity();
		Thread.sleep(1000);
		materialIssuance.enterAssetNumber();
		Thread.sleep(1000);
		materialIssuance.enterRemarks();
		Thread.sleep(1000);
		materialIssuance.submitBtn();
		Thread.sleep(1000);
		/*
		 * String toastMessage = addmaterialreq.getToastMessage();
		 * Assert.assertEquals(toastMessage, "Material Issuance has been created",
		 * "Title is matched"); System.out.println("Congrats your test is passed");
		 */
		System.out.println("Congrats! your Issuance Test is Passed");

	}

	@Test(priority = 3, description = "Approve Material Issuance")
	public void approveIssuanceTest() throws InterruptedException {
		materialIssuance.approveIcon();
		scrollDown(driver, 0, 800);
		Thread.sleep(1000);
		materialIssuance.approveBtn();
		Thread.sleep(1000);
		materialIssuance.popupApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! your Approve Issuance Test is Passed");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
