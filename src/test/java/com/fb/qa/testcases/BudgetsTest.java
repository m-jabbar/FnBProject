package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.listeners.MyListeners;
import com.fb.qa.pages.Budgets;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
@Listeners(MyListeners.class)
public class BudgetsTest extends TestBase {
	public BudgetsTest() {
		super();
	}
	LoginPage loginPage;
	HomePage homepage;
	Budgets budgets;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		this.driver = initilization();
		loginPage = new LoginPage(this.driver);
		homepage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		budgets = homepage.clickOnBudgets();
	}
	@Test
	public void BudgetsProcess() throws InterruptedException {
		budgets.clickOnBudgets();
		Thread.sleep(1000);
		budgets.clickOnAddBudgets();
		Thread.sleep(1000);
		budgets.addTitle();
		Thread.sleep(1000);
		budgets.startDateProcess();
		Thread.sleep(1000);
		budgets.endDateProcess();
		Thread.sleep(1000);
		budgets.sectionTitleProcess();
		Thread.sleep(1000);
		budgets.selectProductListProcess();
		Thread.sleep(1000);
		budgets.enterQuantity();
		Thread.sleep(1000);
		budgets.enterRate();
		Thread.sleep(1000);
		budgets.submitBtn();
		Thread.sleep(1000);
		/*
		 * String toastMessage = budgets.getToastMessage();
		 * Assert.assertEquals(toastMessage, "Budget has been created",
		 * "Title is matched");
		 */
	    System.out.println("Congrats your test1 is passed");
	}
	
	@Test(priority = 2)
	public void ApproveBudgets() throws InterruptedException {
		budgets.clickOnBudgets();
		budgets.approveIcon();
		Thread.sleep(1000);
		budgets.clickOnApproveBtn();
		Thread.sleep(1000);
		budgets.clickAgainOnApproveBtn();
		Thread.sleep(1000);
		/*
		 * String toastMessage1 = budgets.getToastMessage();
		 * Assert.assertEquals(toastMessage1, "Budget has been approved",
		 * "Title is matched");
		 */
		System.out.println("Congrats your tes2t is passed");
	}


	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();

	}

}
