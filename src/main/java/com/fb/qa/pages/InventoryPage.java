package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class InventoryPage extends TestBase {
	public WebDriver driver;

	@FindBy(xpath = "//a[@href='/inventory']")
	private WebElement inventory;

	@FindBy(xpath = "//a[normalize-space()='Add Inventory']")
	private WebElement addInventory;

	@FindBy(xpath = "//select[@name='type']")
	private WebElement selectInventoryType;

	@FindBy(xpath = "//input[@placeholder='Reference']")
	private WebElement enterReferenceNo;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement selectProduct;

	@FindBy(id = "react-select-2-option-1")
	private WebElement selectProductValue;

	@FindBy(xpath = "//select[@name='location']")
	private WebElement selectLocation;

	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement enterQuantity;

	@FindBy(xpath = "//input[@placeholder='Select Date']")
	private WebElement selectDate;

	@FindBy(xpath ="//span[normalize-space()='31']")
	private WebElement selectExpiryDate;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement okButton;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[contains(text(),'Inventory has been created')]")
	private WebElement toastMessage;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickInventoryLink() {
		inventory.click();
	}

	public void addInventory() {
		addInventory.click();
	}

	public void selectInventoryType() {
		selectInventoryType.click();
		new Select(selectInventoryType).selectByIndex(1);
	}

	public void enterReference(String reference) {
		enterReferenceNo.click();
		enterReferenceNo.sendKeys(reference);
	}

	public void selectProduct() {
		selectProduct.click();
		selectProductValue.click();
	}

	public void selectLocation() {
		selectLocation.click();
		new Select(selectLocation).selectByIndex(7);
		;
	}

	public void enterQuantity(String quantity) {
		enterQuantity.clear();
		enterQuantity.sendKeys(quantity);
	}

	public void selectExpiryDate() {
		selectDate.click();
		selectExpiryDate.click();
		okButton.click();
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public String getToastMessage() {
		return toastMessage.getText();
	}
}
