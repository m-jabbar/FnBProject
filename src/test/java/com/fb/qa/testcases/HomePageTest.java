package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;

public class HomePageTest extends TestBase {

	private HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		/*
		 * this.driver=initialization(); homepage =
		 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 */
		try {
			this.driver = initialization();
//			new LoginPage(driver);
			homepage = new HomePage(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String expectedTitle = "F&B System";
		String actualTitle = homepage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not matched");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();
	}
}
