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
	GoodsReceiveNotes goodsReceiveNote;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage = loginPage.login("abdullah.bilal@nxb.com.pk", "Qajob@1234");
		goodsReceiveNote = homepage.clickOnGoodsRecieveNotes();
	}

	@Test
	public void GoodsRecieveProcess() throws InterruptedException {
		goodsReceiveNote.clickOnGoodsRecieveNotes();
		Thread.sleep(1000);
		goodsReceiveNote.clickOnAddGoodsRecieveNotes();
		Thread.sleep(1000);
		goodsReceiveNote.materialInspectionList();
		Thread.sleep(1000);
		goodsReceiveNote.enterDeliveryNum();
		Thread.sleep(2000);
		goodsReceiveNote.uploadFileProcess();
		Thread.sleep(3000);
		goodsReceiveNote.selectDateProcess();
		Thread.sleep(2000);
		goodsReceiveNote.clickOnSubmitBtn();
		Thread.sleep(1000);
		goodsReceiveNote.clickOnApproveIcon();
		Thread.sleep(1000);
		goodsReceiveNote.clickOnApproveBtn();
		Thread.sleep(1000);
		goodsReceiveNote.clickAgainOnApproveBtn();
		Thread.sleep(1000);

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}
}
