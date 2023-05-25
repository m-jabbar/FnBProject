package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MaterialIssuancePage;
@Listeners(MyListeners.class)
public class MaterialIssuanceTest extends TestBase {

	public MaterialIssuanceTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	MaterialIssuancePage materialIssuance;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		materialIssuance = homepage.clickOnMaterialIssuance();
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		String PageTitle = materialIssuance.getPageTitle();
		Assert.assertEquals(PageTitle, "F&B System");
	}

	@Test(priority = 2)
	public void materialIssuanceProcess() throws InterruptedException {
		materialIssuance.clickOnAddMaterialIssuance();
		Thread.sleep(2000);
		materialIssuance.selectMaterialNum();
		Thread.sleep(1000);
		materialIssuance.addQRCode();
		Thread.sleep(1000);
		materialIssuance.enterQuantity();
		Thread.sleep(1000);
		materialIssuance.giveAssetsNum();
		Thread.sleep(1000);
		materialIssuance.giveRemarks();
		Thread.sleep(1000);
		materialIssuance.clickSubmitBtn();
		Thread.sleep(1000);
		materialIssuance.approveMaterialProcess();
		Thread.sleep(2000);
		/*
		 * String toastMessage = addmaterialreq.getToastMessage();
		 * Assert.assertEquals(toastMessage, "Material Issuance has been created",
		 * "Title is matched"); System.out.println("Congrats your test is passed");
		 */
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();

	}
}
