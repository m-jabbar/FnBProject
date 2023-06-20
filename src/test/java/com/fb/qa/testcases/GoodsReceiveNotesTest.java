package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.GoodsReceiveNotes;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

@Listeners(MyListeners.class)
public class GoodsReceiveNotesTest extends TestBase {

	public GoodsReceiveNotesTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	GoodsReceiveNotes goodsReceiveNotes;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homepage = new HomePage(driver);
		goodsReceiveNotes = homepage.clickOnGoodsReceiveNotes();
	}

	@Test
	public void GoodsRecieveProcess() throws InterruptedException {
		goodsReceiveNotes.clickOnGoodsRecieveNotes();
		Thread.sleep(1000);
		goodsReceiveNotes.clickOnAddGoodsRecieveNotes();
		Thread.sleep(1000);
		goodsReceiveNotes.materialInspectionList();
		Thread.sleep(1000);
		goodsReceiveNotes.enterDeliveryNum();
		Thread.sleep(2000);
		goodsReceiveNotes.uploadFileProcess();
		Thread.sleep(3000);
		goodsReceiveNotes.selectDateProcess();
		Thread.sleep(2000);
		goodsReceiveNotes.clickOnSubmitBtn();
		Thread.sleep(3000);
		System.out.println("Congratulation");

	}

	@Test(priority = 2, description = "Approve a Goods Receive Notes")
	public void approveBudgetTest() throws InterruptedException {
		goodsReceiveNotes.clickOnApproveIcon();
		Thread.sleep(1000);
		goodsReceiveNotes.clickOnApproveBtn();
		Thread.sleep(1000);
		goodsReceiveNotes.clickAgainOnApproveBtn();
		Thread.sleep(1000);

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}
}
