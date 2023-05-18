package com.fb.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class PurchaseOrders extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"kt_content_container\"]/section/div/div/div/div/div/div/div[5]/a")
	WebElement purchaseOrders;
	
	@FindBy(xpath = "//div[@title='Add Purchase Order']//a[@id='kt_toolbar_primary_button']")
	WebElement addPurchaseOrders;
	
	@FindBy(name = "purchaseFor")
	WebElement selectPurchaseFor;
	
	@FindBy(name = "supplier.id")
	WebElement selectSupplier;
	 
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement selectProduct;
	
	@FindBy(id = "react-select-2-option-0")
	WebElement selectProductListValue;
	
	@FindBy(name = "items.0.quantity")
	WebElement enterQuantityValue;
	
	@FindBy(name = "items.0.rate")
	WebElement enterRateValue;
	
	@FindBy(name = "items.0.tax")
	WebElement enterTaxValue;
	
	@FindBy(name = "items.0.discount")
	WebElement enterDiscountValue;
	
	
	@FindBy(id = "liveToastBtn")
	WebElement submitBtn;
	
	
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/a[2]/button[1]/span[1]")
	WebElement approveIconElement;
	
	@FindBy(id = "liveToastBtn")
	WebElement approveBtn;
	
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	WebElement againApproveBtn;
	
	
	
	
	public PurchaseOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPurchaseOrders() {
		purchaseOrders.click();
	}
	
	public void clickOnAddPurchaseOrders() {
		addPurchaseOrders.click();
	}
	
	public void selectPurcahseFor() {
		Select dropdown = new Select (selectPurchaseFor);
		dropdown.selectByValue("Entertainment of All Centres");
	}
	
	public void selectSupplier() {
		selectSupplier.click();
		Select dropdown = new Select (selectSupplier);
		dropdown.selectByIndex(1);
	}
	
	public void selectProduct() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1500);
		selectProduct.click();
		selectProductListValue.click();
	}
	public void enterQunatityValue() {
		enterQuantityValue.click();
		enterQuantityValue.sendKeys("1");
		enterQuantityValue.sendKeys(Keys.TAB);
	}
	
	public void enterRateValue() {
		enterRateValue.click();
		enterRateValue.sendKeys("500");
		enterRateValue.sendKeys(Keys.TAB);
	}
	
	
	public void enterTaxValue() {
		enterTaxValue.click();
		enterTaxValue.sendKeys("50");
		enterTaxValue.sendKeys(Keys.TAB);
	}

	public void enterDiscountValue() {
		enterDiscountValue.click();
		enterDiscountValue.sendKeys("50");
		enterDiscountValue.sendKeys(Keys.TAB);
	}

	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	
	public void approvePurchaseProcess() throws InterruptedException {
		approveIconElement.click();
		Thread.sleep(2000);
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1400);
		Thread.sleep(2000);
		approveBtn.click();
		Thread.sleep(1000);
		againApproveBtn.click();
	}
	
	
}
