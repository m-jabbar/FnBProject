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

public class Assets extends TestBase  {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='/assets']")
	WebElement assets;
	
	@FindBy(xpath="//a[normalize-space()='Add Asset']")
	WebElement addAssets;
	
	@FindBy(xpath="//input[@placeholder='Asset No.']")
	WebElement addAssetsNo;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
	WebElement goodsReceiveNo;
	
	@FindBy(id="react-select-2-option-1")
	WebElement selectGoodsReceiveNo;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement selectProduct;
	
	@FindBy(id="react-select-3-option-0")
	WebElement selectProductValue;
	
	@FindBy(xpath="//select[@name='location']")
	WebElement selectLocation;
	
	@FindBy(xpath="//button[@id='liveToastBtn']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[contains(text(),'Asset has been created')]")
	WebElement toastMessageVeri;
	
	
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
	public void addAssetsNo() {
		addAssetsNo.click();
		addAssetsNo.sendKeys("MR-1679298587741");
	}
	public void selectGoodsReceiveNo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(goodsReceiveNo));
//		TestBase wait = new TestBase(driver);
//		wait.waitForElementToBeClickable(goodsReceiveNo);
		goodsReceiveNo.click();
		selectGoodsReceiveNo.click();
	}
	public void selectProduct() {
		selectProduct.click();
		selectProductValue.click();
	}
	public void selectLocation() {
		selectLocation.click();
		Select select = new Select(selectLocation);
		select.selectByIndex(1);
	}
	public void submitBtn() {
		submitBtn.click();
	}
	public String getToastMessage() {
		return toastMessageVeri.getText();
	}
	
}
