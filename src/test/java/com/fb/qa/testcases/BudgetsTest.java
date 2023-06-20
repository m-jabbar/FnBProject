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

@Listeners(MyListeners.class)
public class BudgetsTest extends TestBase {

	private HomePage homePage;
	private Budgets budgets;

	public BudgetsTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = initialization();
		homePage = new HomePage(driver);
		budgets = homePage.clickOnBudgets();
	}

	@Test(priority = 1, description = "Create a new budget")
	public void createBudgetTest() throws InterruptedException {
		budgets.clickOnAddBudget();
		Thread.sleep(1000);
		budgets.enterTitle();
		Thread.sleep(1000);
		budgets.selectStartDate();
		Thread.sleep(1000);
		budgets.selectEndDate();
		Thread.sleep(1000);
		budgets.enterSectionTitle();
		Thread.sleep(1000);
		budgets.selectProductFromList();
		Thread.sleep(1000);
		budgets.enterQuantity("1");
		Thread.sleep(1000);
		budgets.enterRate("100");
		Thread.sleep(1000);
		budgets.submitBudget();
		Thread.sleep(1000);
		String toastMessage = budgets.getToastMessage();
		Assert.assertEquals(toastMessage, "Budget has been created", "Title is matched");
		Thread.sleep(3000);
		System.out.println("Budget creation test passed.");
	}

	@Test(priority = 2, description = "Approve a budget")
	public void approveBudgetTest() throws InterruptedException {
		budgets.clickOnApproveIcon();
		Thread.sleep(1000);
		scrollDown(driver, 0, 500);
		budgets.clickOnApproveButton();
		Thread.sleep(1000);
		budgets.clickAgainOnApproveButton();
		Thread.sleep(1000);
		String toastMessage1 = budgets.getToastMessage();
		Assert.assertEquals(toastMessage1, "Budget has been approved", "Title is matched");
		Thread.sleep(2000);
		System.out.println("Budget approval test passed.");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.quit();
	}
}
