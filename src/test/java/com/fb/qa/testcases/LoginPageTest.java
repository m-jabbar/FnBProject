package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
@Listeners(MyListeners.class)
public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		loginPage = new LoginPage(driver);
	}

	@Test()
	public void login() {
	homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}