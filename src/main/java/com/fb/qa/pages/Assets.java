package com.fb.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fb.qa.base.TestBase;

public class Assets extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/assets']")
	private WebElement assets;

	@FindBy(xpath = "//a[normalize-space()='Add Asset']")
	private WebElement addAssets;

	@FindBy(xpath = "//input[@placeholder='Asset No.']")
	private WebElement addAssetsNo;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
	private WebElement goodsReceiveNo;

	@FindBy(id = "react-select-2-option-1")
	private WebElement selectGoodsReceiveNo;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement selectProduct;

	@FindBy(id = "react-select-3-option-0")
	private WebElement selectProductValue;

	@FindBy(xpath = "//select[@name='location']")
	private WebElement selectLocation;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[contains(text(),'Asset has been created')]")
	private WebElement toastMessageVeri;

	public Assets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAssets() {
		assets.click();
	}

	public void clickOnAddAssets() {
		addAssets.click();
	}

	public void enterAssetsNo() {
		addAssetsNo.click();
		String baseValue = "MR-";
		String uniqueValue = baseValue + System.currentTimeMillis(); // Adding timestamp to create unique value
		addAssetsNo.sendKeys(uniqueValue);
	}

	public void selectGoodsReceiveNo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(goodsReceiveNo));
		goodsReceiveNo.click();
		selectGoodsReceiveNo.click();
	}

	public void selectProduct() {
		selectProduct.click();
		selectProductValue.click();
	}

	public void selectLocation() {
		selectLocation.click();
		new Select(selectLocation).selectByIndex(1);
	}

	public void clickSubmitBtn() {
		submitBtn.click();
	}

	public String getToastMessage() {
		return toastMessageVeri.getText();
	}
}
