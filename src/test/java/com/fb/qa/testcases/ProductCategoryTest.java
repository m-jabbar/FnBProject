package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProductCategory;
@Listeners(MyListeners.class)
public class ProductCategoryTest extends TestBase{
	public ProductCategoryTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homepage;
	ProductCategory productCategory;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initialization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productCategory = homepage.clickOnProductCategory();
	}
	@Test
	public void ProductCategoryProcess() throws InterruptedException {
		
		productCategory.clickOnProductCategory();
		Thread.sleep(1000);
		productCategory.clickOnAddProductCategory();
		Thread.sleep(1000);
		productCategory.selectProductName();
		Thread.sleep(1000);
		productCategory.selectAssestType();
		Thread.sleep(1000);
		productCategory.selectParentCategoryListValue();
		Thread.sleep(1000);
		productCategory.submitBtn();
		Thread.sleep(1000);
		
		
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();

	}
	

}
