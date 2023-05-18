package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class SuppliersBills extends TestBase {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='/supplier-bills']")
	WebElement suppliersBills;
	
	@FindBy(xpath="//a[normalize-space()='Add Supplier Bill']")
	WebElement addSuppliersBills;
	
	@FindBy(xpath="//div[@class='multi-select__input-container css-ackcql']")
	WebElement goodsReceiveNo;
	
	@FindBy(id="react-select-2-option-1")
	WebElement goodsReceiveNoValue;
	
	@FindBy(xpath="//span[normalize-space()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconClick;
	
	@FindBy(xpath="//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;
	
	@FindBy(xpath="//div[contains(text(),'Supplier bill has been approved')]")
	WebElement toastMessageVeri;
	
	
	public SuppliersBills(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSuppliersBills() {
		suppliersBills.click();
	}
	
	public void clickOnAddSuppliersBills() {
		addSuppliersBills.click();
	}
	
	public void goodsReceiveNum() {
		goodsReceiveNo.click();
		goodsReceiveNoValue.click();
	}
	public void submitBtn() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 600);
		submitBtn.click();
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
	public String getToastMessage() {
		return toastMessageVeri.getText();
	}
	
}
