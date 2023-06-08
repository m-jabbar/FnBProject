package com.fb.qa.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.InventoryReports;
import com.fb.qa.pages.LoginPage;

public class InventoryReportsTest extends TestBase {
	WebDriverWait wait;

	public InventoryReportsTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	InventoryReports inventoryReports;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventoryReports = homepage.clickOnInventoryReports();
	}

	@Test(priority = 1)
	public void materialReqProcess() throws InterruptedException {
		inventoryReports.clickQRCodeByID(getFormattedCurrentDate());
		Thread.sleep(1000);
	
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();

	}

}
