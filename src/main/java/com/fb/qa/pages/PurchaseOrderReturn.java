package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class PurchaseOrderReturn extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/purchase-order-returns']//div[@class='icon']//img[@alt='icon']")
	private WebElement purchaseOrderReturn;

	@FindBy(xpath = "//a[@id='kt_toolbar_primary_button']")
	private WebElement addPurchaseOrderReturn;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement purchaseOrderNo;

	@FindBy(id = "react-select-2-option-1")
	private WebElement selectPurchaseOrderNo;

	@FindBy(xpath = "//input[@name='attachments']")
	private WebElement uploadFile;

	@FindBy(id = "liveToastBtn")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[contains(@class, \"btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1\")]")
	private WebElement approveIcon;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	public PurchaseOrderReturn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void purchaseOrderReturn() {
		purchaseOrderReturn.click();
	}

	public void addPurchaseOrderReturn() {
		addPurchaseOrderReturn.click();
	}

	public void selectPurchaseOrderNo() {
		purchaseOrderNo.click();
		selectPurchaseOrderNo.click();
	}

	public void uploadFile() {
		uploadFile.sendKeys("D:\\R2D2 Bug Reporting\\10-5-23\\invalid email error.png");
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public void approveIcon() {
		approveIcon.click();
	}

	public void clickOnApproveBtn() {
		scrollDown(driver, 0, 600);
		approveBtn.click();
	}

	public void clickAgainOnApproveBtn() {
		popupApproveBtn.click();
	}
}
