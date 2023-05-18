package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class Budgets extends TestBase {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='/budgets']")
	WebElement budgets;
	
	@FindBy(xpath="//a[normalize-space()='Add Budget']")
	WebElement addBudgets;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement addTitle;
	
	@FindBy(xpath="//input[@name='startDate']")
	WebElement startDate;
	
	
	@FindBy(xpath="//div[@aria-label='Choose Tuesday, May 9th, 2023']")
	WebElement selectStartDate;
	
	@FindBy(xpath="//input[@name='endDate']")
	WebElement endDate;
	
	@FindBy(xpath="//div[@aria-label='Choose Friday, May 26th, 2023']")
	WebElement selectEndDate;
	
	@FindBy(name="sections.0.title")
	WebElement addSectionTitle;
	
	@FindBy(xpath="//div[@class='multi-select__input-container css-ackcql']")
	WebElement clickOnProductList;
	
	@FindBy(id="react-select-2-option-0")
	WebElement selectValueFromProductList;
	
	@FindBy(name="sections.0.items.0.quantity")
	WebElement enterQuantity;
	
	@FindBy(name="sections.0.items.0.rate")
	WebElement enterRate;
	
	@FindBy(xpath="//button[@title='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[contains(@role,\"alert\")]")
	WebElement toastMessageVeri;

	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/div[1]/a[2]/span[1]")
	WebElement approveIconClick;
	
	@FindBy(xpath="//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;
	
	@FindBy(xpath="//div[@class='Toastify']")
	WebElement toastMessageVeri1;
	
	
	
	public Budgets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBudgets() {
		budgets.click();
	}
	public void clickOnAddBudgets() {
		addBudgets.click();
	}
	public void addTitle() {
		addTitle.click();
		addTitle.sendKeys("This is our budget1234");
	}
	public void startDateProcess() {
		startDate.click();
		selectStartDate.click();
	}
	public void endDateProcess() {
		endDate.click();
		selectEndDate.click();
	}
	public void sectionTitleProcess() {
		addSectionTitle.click();
		addSectionTitle.sendKeys("This is title1");
	}

	public void selectProductListProcess() {
		clickOnProductList.click();
		selectValueFromProductList.click();
	}
	
	public void enterQuantity() {
		enterQuantity.click();
		enterQuantity.sendKeys("1");
	}
	
	public void enterRate() {
		enterRate.click();
		enterRate.sendKeys("100");
	}
	
	
	public void submitBtn() {
		submitBtn.click();
	}

	public String getToastMessage() {
		return toastMessageVeri.getText();
	}
	public void approveIcon() {
		approveIconClick.click();
	}
	
	public void clickOnApproveBtn() {
		approveBtn.click();
	}
	public void clickAgainOnApproveBtn() {
		againApproveBtn.click();
	}
	public String getToastMessage1() {
		return toastMessageVeri1.getText();
	}
	
}
