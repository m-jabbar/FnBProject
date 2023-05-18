package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MaterialIssuancePage;
import com.fb.qa.pages.OutwardPage;

public class OutwardPageTest extends TestBase {
	public OutwardPageTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	MaterialIssuancePage addmaterialreq;
	OutwardPage Outward;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Outward = homepage.clickOnOutward();
	}
	
	@Test(priority = 1)
	public void outwardProcess() throws InterruptedException {
		Outward.clickOnOutward();
		Outward.clickOnAddOutward();
		Thread.sleep(1000);
		Outward.selectIssuanceNum();
		Outward.giveRemarks();
		Thread.sleep(1000);
		Outward.clickSubmitBtn();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void approveOutwardProcess() throws InterruptedException {
		Outward.clickOnOutward();
		Thread.sleep(1000);
		Outward.approveProcess();
		Thread.sleep(2000);
	}
	

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}
}
