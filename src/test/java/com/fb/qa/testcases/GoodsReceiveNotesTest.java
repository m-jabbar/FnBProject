package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.GoodsReceiveNotes;
import com.fb.qa.pages.HomePage;

@Listeners(MyListeners.class)
public class GoodsReceiveNotesTest extends TestBase {

	public GoodsReceiveNotesTest() {
		super();
	}

	HomePage homepage;
	GoodsReceiveNotes goodsReceiveNotes;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initialization();
		homepage = new HomePage(driver);
		goodsReceiveNotes = homepage.clickOnGoodsReceiveNotes();
	}

	@Test
	public void goodsReceiveProcess() throws InterruptedException {
		goodsReceiveNotes.addGoodsReceiveNote();
		Thread.sleep(1000);
		goodsReceiveNotes.selectMaterialInspectionNum();
		Thread.sleep(1000);
		goodsReceiveNotes.enterDeliveryNum();
		Thread.sleep(2000);
		goodsReceiveNotes.uploadFileProcess();
		Thread.sleep(3000);
		goodsReceiveNotes.selectDateProcess();
		Thread.sleep(2000);
		goodsReceiveNotes.submitBtn();
		Thread.sleep(3000);
		System.out.println("Congrats! Your Goods Receive Notes Test Passed");
	}

	@Test(priority = 2, description = "Approve a Goods Receive Notes")
	public void approveGoodsReceiveTest() throws InterruptedException {
		goodsReceiveNotes.approveIcon();
		Thread.sleep(1000);
		goodsReceiveNotes.approveBtn();
		Thread.sleep(1000);
		goodsReceiveNotes.popupApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats! Your Approve Goods Receive Notes Test Passed");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		super.tearDown();
	}
}
