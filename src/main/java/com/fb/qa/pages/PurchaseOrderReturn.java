package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class PurchaseOrderReturn extends TestBase {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/purchase-order-returns']//div[@class='icon']//img[@alt='icon']")
	WebElement purchaseOrderReturn;

	@FindBy(xpath = "//a[@id='kt_toolbar_primary_button']")
	WebElement addPurchaseOrderReturn;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement purchaseOrderNo;

	@FindBy(id = "react-select-2-option-1")
	WebElement selectPurchaseOrderNo;
	
	@FindBy(xpath = "//input[@name='attachments']")
	WebElement uploadFile;
	
	@FindBy(id = "liveToastBtn")
	WebElement submitBtn;
	
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/div[1]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconClick;
	
	@FindBy(xpath="//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;
	
//	@FindBy(xpath="//div[contains(text(),'Supplier has been approved (jabbar1)')]")
//	WebElement toastMessageVeri1;
	
	public PurchaseOrderReturn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPurcahseOrderReturn() {
		purchaseOrderReturn.click();
	}
	public void clickOnAddPurcahseOrderReturn() {
		addPurchaseOrderReturn.click();
	}
	public void selectOrderNo() {
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
		approveIconClick.click();
	}
	
	public void clickOnApproveBtn() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 600);
		approveBtn.click();
	}
	public void clickAgainOnApproveBtn() {
		againApproveBtn.click();
	}

}
