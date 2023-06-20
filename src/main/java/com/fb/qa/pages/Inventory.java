package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class Inventory extends TestBase {
	public WebDriver driver;

	@FindBy(xpath = "//a[@href='/inventory']")
	WebElement inventory;

	@FindBy(xpath = "//a[normalize-space()='Add Inventory']")
	WebElement addInventory;

	@FindBy(xpath = "//select[@name='type']")
	WebElement selectInventoryType;

	@FindBy(xpath = "//input[@placeholder='Reference']")
	WebElement enterReference;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement selectProduct;

	@FindBy(id = "react-select-2-option-1")
	WebElement selectProductValue;

	@FindBy(xpath = "//select[@name='location']")
	WebElement selectLocation;

	@FindBy(xpath = "//input[@placeholder='Quantity']")
	WebElement enterQuantity;

	@FindBy(xpath = "//input[@placeholder='Select Date']")
	WebElement clickOnDate;

	@FindBy(xpath = "//input[@placeholder='Select Date']")
	WebElement selectExpiryDate;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement clickOnOK;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	WebElement submitBtn;

	@FindBy(xpath = "//div[contains(text(),'Inventory has been created')]")
	WebElement toastMessageVeri;

	public Inventory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnInventory() {
		inventory.click();
	}

	public void clickOnAddInventory() {
		addInventory.click();
	}

	public void selectInventoryType() {
		selectInventoryType.click();
		Select selctinvType = new Select(selectInventoryType);
		selctinvType.selectByIndex(1);
	}

	public void enterReferenceNo() {
		enterReference.click();
		enterReference.sendKeys("MR-123456278");
	}

	public void selectProduct() {
		selectProduct.click();
		selectProductValue.click();
	}

	public void selectLocation() {
		selectLocation.click();
		Select selctlocation = new Select(selectLocation);
		selctlocation.selectByVisibleText("C4");
	}

	public void enterQuantity() {
		enterQuantity.click();
		enterQuantity.sendKeys("5");
	}
	public void dateSelection() {
		clickOnDate.click();
		selectExpiryDate.click();
		TestBase scroll = new TestBase();
		scroll.scrollDown(driver, 0, 200);
		clickOnOK.click();
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public String getToastMessage() {
		return toastMessageVeri.getText();
	}
}
