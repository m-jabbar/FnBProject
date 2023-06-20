package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.MaterialReturn;

@Listeners(MyListeners.class)
public class MaterialReturnTest extends TestBase {
	private HomePage homepage;
	private MaterialReturn materialReturn;

	public MaterialReturnTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homepage = new HomePage(driver);
		materialReturn = homepage.clickOnMaterialReturn();
	}

	@Test(priority = 1, description = "Create a new Material return")
	public void materialReturnProcess() throws InterruptedException {
		materialReturn.clickOnAddMaterialReturn();
		Thread.sleep(1000);
		materialReturn.selectMaterialReturnList();
		Thread.sleep(1000);
		materialReturn.selectLocation();
		Thread.sleep(1000);
		materialReturn.selectProvidedDepartment();
		Thread.sleep(1000);
		materialReturn.selectReceivedDepartment();
		Thread.sleep(1000);
		materialReturn.enterRemarks();
		Thread.sleep(1000);
		materialReturn.clickSubmitBtn();
		Thread.sleep(3000);
		System.out.println("Congratulations! Test 1 passed.");
	}

	@Test(priority = 2, description = "Approve Material Return")
	public void approveMaterialReturn() throws InterruptedException {
		materialReturn.clickApproveIcon();
		Thread.sleep(1000);
		materialReturn.clickOnApproveBtn();
		Thread.sleep(1000);
		materialReturn.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		System.out.println("Congratulations! Test 2 passed.");
	}

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
}
