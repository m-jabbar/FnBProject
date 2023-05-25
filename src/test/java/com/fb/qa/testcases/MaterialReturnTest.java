package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MaterialReturn;
@Listeners(MyListeners.class)
public class MaterialReturnTest extends TestBase{
	public MaterialReturnTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homepage;
	MaterialReturn materialReturn;

	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		materialReturn = homepage.clickOnMaterialReturn();
	}

	@Test(priority = 1)
	public void MaterialReturnProcess() throws InterruptedException {
		materialReturn.clickOnMaterialReturn();
		Thread.sleep(1000);
		materialReturn.clickOnAddMaterialReturn();
		Thread.sleep(1000);
		materialReturn.materialReturnList();
		Thread.sleep(1000);
		materialReturn.selectLocation();
		Thread.sleep(1000);
		materialReturn.selectProvideDepartment();
		Thread.sleep(1000);
		materialReturn.selectReceivedDepartment();
		Thread.sleep(1000);
//		materialReturn.enterQuantity();
//		Thread.sleep(1000);
		materialReturn.enterRemarksAndSubmit();
		Thread.sleep(1000);
		System.out.println("Congrats your test1 is passed");
	}

	@Test(priority = 2)
	public void ApproveMaterialReturn() throws InterruptedException {
		materialReturn.clickOnMaterialReturn();
		Thread.sleep(1000);
		materialReturn.approveIcon();
		Thread.sleep(1000);
		materialReturn.clickOnApproveBtn();
		Thread.sleep(1000);
		materialReturn.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congrats your test is passed");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		super.tearDown();
	}

}
