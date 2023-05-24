package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.InwardPage;
import com.fb.qa.pages.LoginPage;

@Listeners(MyListeners.class)
public class InwardPageTest extends TestBase {
	public InwardPageTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	InwardPage inward;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inward = homepage.clickOnInward();
	}

	@Test
	public void InwardProcess() throws InterruptedException {
		inward.clickOnInward();
		Thread.sleep(1000);
		inward.clickOnAddInward();
		Thread.sleep(1000);
		inward.outwardList();
		Thread.sleep(1000);
		inward.giveRemarks();
		Thread.sleep(1000);
		inward.submitBtn();
		Thread.sleep(1000);
		inward.ApproveInward();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

}
