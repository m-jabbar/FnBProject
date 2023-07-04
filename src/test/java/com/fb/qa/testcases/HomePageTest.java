package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	private LoginPage loginPage;
	private HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String expectedTitle = "F&B System";
		String actualTitle = homepage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not matched");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		super.tearDown();
	}
}
