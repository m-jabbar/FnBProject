package com.fb.qa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fb.qa.base.TestBase;

public class Budgets extends TestBase {

	@FindBy(xpath = "//a[@href='/budgets']")
	private WebElement budgets;

	@FindBy(xpath = "//a[normalize-space()='Add Budget']")
	private WebElement addBudget;

	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement titleInput;

	@FindBy(xpath = "//input[@name='startDate']")
	private WebElement startDateInput;

//	@FindBy(xpath = "//div[@aria-label='Choose Tuesday, May 9th, 2023']")
//	private WebElement selectStartDate;

	@FindBy(xpath = "//input[@name='endDate']")
	private WebElement endDateInput;

	@FindBy(xpath ="//div[@aria-label='Choose Friday, July 28th, 2023']")
	private WebElement selectEndDate;

	@FindBy(name = "sections.0.title")
	private WebElement sectionTitleInput;

	@FindBy(id = "react-select-2-input")
	private WebElement productList;

	@FindBy(id = "react-select-2-option-1")
	private WebElement selectionOfProduct;

	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement enterQuantity;

	@FindBy(xpath = "//input[@placeholder='Rate']")
	private WebElement enterRate;

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	private WebElement submitBudget;

	@FindBy(xpath = "//div[contains(@role,\"alert\")]")
	private WebElement toastMessage;

	@FindBy(xpath = "//button[@title='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/div[1]/a[2]/span[1]")
	private WebElement approveIcon;

	@FindBy(xpath ="//button[contains(@class, \"btn btn-lg  btn-primary me-3\")]")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary']//span[@class='indicator-label'][normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	public Budgets(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnBudgets() {
		budgets.click();
	}

	public void clickOnAddBudget() {
		addBudget.click();
	}

	public void enterTitle() {
		String uniqueTitle = "BudgetTitle_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
		titleInput.click();
		titleInput.sendKeys(uniqueTitle);
	}

	public void selectStartDate() {
		getFormattedCurrentDate();
	}

	/*
	 * public void selectStartDate() { startDateInput.click();
	 * selectStartDate.click(); }
	 */
	public void selectEndDate() {
		endDateInput.click();
		selectEndDate.click();
	}

	public void enterSectionTitle() {
		String baseTitle = "Funds";
		String uniqueString = RandomStringUtils.randomAlphabetic(5); // Adjust the length as needed
		String title = baseTitle + " " + uniqueString;
		sectionTitleInput.click();
		sectionTitleInput.sendKeys(title);
	}

	public void selectProductFromList() {
		productList.click();
		selectionOfProduct.click();
	}

	public void enterQuantity(String quantity) {
		enterQuantity.click();
		enterQuantity.sendKeys(quantity);
	}

	public void enterRate(String rate) {
		enterRate.click();
		enterRate.sendKeys(rate);
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public String getToastMessage() {
		return toastMessage.getText();
	}

	public void approveIcon() {
		approveIcon.click();
	}

	public void approveBtn() {
		approveBtn.click();
	}

	public void popupApproveBtn() {
		popupApproveBtn.click();
	}
}
