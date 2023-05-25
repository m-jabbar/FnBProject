package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MaterialInspection;

public class MaterialInspectionTest extends TestBase {

	public MaterialInspectionTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	MaterialInspection materialInspection;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		materialInspection = homepage.clickOnMaterialInspection();
	}

	@Test
	public void MaterialInspectionProcess() throws InterruptedException {

		materialInspection.clickOnMaterialInspection();
		Thread.sleep(1000);
		materialInspection.clickOnAddMaterialInspection();
		Thread.sleep(1000);
		materialInspection.selectPurcahsenumvalue();
		Thread.sleep(1000);
		materialInspection.enterInvoiceNum();
		Thread.sleep(1000);
		materialInspection.selectLocation();
		Thread.sleep(1000);
		materialInspection.enterRemarksAndSubmit();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void ApproveInspectionProcess() throws InterruptedException {
		materialInspection.clickOnMaterialInspection();
		Thread.sleep(3000);
		materialInspection.approveProcess();
		Thread.sleep(1000);
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}
}
