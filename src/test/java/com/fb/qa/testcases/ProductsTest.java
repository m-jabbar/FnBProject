package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.Products;
@Listeners(MyListeners.class)
public class ProductsTest extends TestBase {
	public ProductsTest() {
		super();
	}
	HomePage homePage;
	Products products;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homePage = new HomePage(driver);
		products = homePage.clickOnProducts();
	}
	@Test
	public void ProductCategoryProcess() throws InterruptedException {
		products.clickOnProducts();
		Thread.sleep(1000);
		products.clickOnAddProducts();
		Thread.sleep(1000);
		products.selectCategory();
		Thread.sleep(1000);
		products.enterCode();
		Thread.sleep(1000);
		products.selectUOM();
		Thread.sleep(1000);
		products.enterName();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();

	}

	

}
