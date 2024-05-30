package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.ProductCategory;

@Listeners(MyListeners.class)
public class ProductCategoryTest extends TestBase {
	HomePage homePage;
	private ProductCategory productCategory;

	public ProductCategoryTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.driver = initialization();
		homePage = new HomePage(driver);
		productCategory = homePage.clickOnProductCategory();
	}

	@Test
	public void ProductCategoryProcess() throws InterruptedException {

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
