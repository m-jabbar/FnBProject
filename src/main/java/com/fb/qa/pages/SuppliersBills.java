package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class SuppliersBills extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/supplier-bills']")
	private WebElement suppliersBills;

	@FindBy(xpath = "//a[normalize-space()='Add Supplier Bill']")
	private WebElement addSuppliersBills;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	private WebElement goodsReceiveNo;

	@FindBy(id = "react-select-2-option-1")
	private WebElement goodsReceiveNoValue;

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIcon;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	@FindBy(xpath = "//div[contains(text(),'Supplier bill has been approved')]")
	private WebElement toastMessageVeri;

	public SuppliersBills(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void suppliersBills() {
		suppliersBills.click();
	}

	public void addSuppliersBills() {
		addSuppliersBills.click();
	}

	public void selectGoodsReceiveNum() {
		goodsReceiveNo.click();
		goodsReceiveNoValue.click();
	}

	public void submitBtn() {
		scrollDown(driver, 0, 600);
		submitBtn.click();
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

	public String getToastMessage() {
		return toastMessageVeri.getText();
	}

}
