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

@Listeners(MyListeners.class)
public class AssetsTest extends TestBase {
	private HomePage homepage;
	private Assets assets;

	public AssetsTest() {
		super();
	}
// before method
	@BeforeMethod
	public void setup() throws InterruptedException {
		TestBase.driver = initialization();
		homepage = new HomePage(driver);
		assets = homepage.clickOnAssets();
	}

	@Test
	public void testAssetsProcess() throws InterruptedException {
		assets.clickOnAddAssets();
		Thread.sleep(1000);
		assets.enterAssetsNo();
		Thread.sleep(1000);
		assets.selectGoodsReceiveNo();
		Thread.sleep(1000);
		assets.selectProduct();
		Thread.sleep(1000);
//		assets.selectLocation();
		Thread.sleep(1000);
		assets.clickSubmitBtn();
		Thread.sleep(1000);
		String toastMessage = assets.getToastMessage();
		Assert.assertEquals(toastMessage, "Asset has been created", "Toast message is matched");
		System.out.println("Congratulations! Test passed.");
	}

	@AfterMethod
	public void teardown() {
		super.tearDown();
	}
}
