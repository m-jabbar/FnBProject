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

	@FindBy(xpath = "//a[contains(@href,'/purchase-orders')]")
	private WebElement purchaseOrders;

	@FindBy(xpath = "//div[@title='Add Purchase Order']//a[@id='kt_toolbar_primary_button']")
	private WebElement addPurchaseOrders;

	@FindBy(name = "purchaseFor")
	private WebElement selectPurchaseFor;

	@FindBy(name = "supplier.id")
	private WebElement selectSupplier;

	@FindBy(xpath = "//div[contains(@class, \"multi-select__control css-13cymwt-control\" )]")
	private WebElement selectProduct;

	@FindBy(id = "react-select-2-option-0")
	private WebElement selectProductListValue;

	@FindBy(name = "items.0.quantity")
	private WebElement enterQuantityValue;

	@FindBy(name = "items.0.rate")
	private WebElement enterRateValue;

	@FindBy(name = "items.0.tax")
	private WebElement enterTaxValue;

	@FindBy(name = "items.0.discount")
	private WebElement enterDiscountValue;

	@FindBy(id = "liveToastBtn")
	private WebElement submitBtn;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/a[2]/button[1]/span[1]")
	private WebElement approveIconElement;

	@FindBy(id = "liveToastBtn")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	private WebElement againApproveBtn;

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

	public void selectPurchaseFor() {
		new Select(selectPurchaseFor).selectByIndex(2);;
	}

	public void selectSupplier() {
		selectSupplier.click();
		new Select(selectSupplier).selectByIndex(1);
	}

	public void selectProduct() {
		selectProduct.click();
		selectProductListValue.click();
	}

	public void enterQuantityValue() {
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

	public void clickOnApproveIcon() {
		approveIconElement.click();
	}

	public void clickOnApproveBtn() {
		approveBtn.click();
	}

	public void clickOnAgainApproveBtn() {
		againApproveBtn.click();
	}
}
