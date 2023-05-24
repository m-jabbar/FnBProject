package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.Assets;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
@Listeners(MyListeners.class)
public class AssetsTest extends TestBase{
	public AssetsTest() {
		super();
	}
	
	LoginPage loginPage;
	HomePage homepage;
	Assets assets;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		assets = homepage.clickOnAssets();
	}
	@Test
	public void AssetsProcess() throws InterruptedException {
		assets.clickOnAssets();
		Thread.sleep(1000);
		assets.clickOnAddAssets();
		Thread.sleep(1000);
		assets.addAssetsNo();
		Thread.sleep(1000);
		assets.selectGoodsReceiveNo();
		Thread.sleep(1000);
		assets.selectProduct();
		Thread.sleep(1000);
		assets.selectLocation();
		Thread.sleep(1000);
		assets.submitBtn();
		Thread.sleep(1000);
		String toastMessage = assets.getToastMessage();
	    Assert.assertEquals(toastMessage, "Asset has been created", "Title is matched");
	    System.out.println("Congrats your test is passed");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

}
