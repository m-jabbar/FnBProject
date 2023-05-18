package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class Products extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement products;
	
	@FindBy(xpath="//a[@id='kt_toolbar_primary_button']")
	WebElement addProducts;
	
	@FindBy(xpath="//select[@name='category']")
	WebElement selectCategory;
	
	@FindBy(xpath="//input[@placeholder='Add Code']")
	WebElement enterCode;
	
	@FindBy(xpath="//select[@name='UOM']")
	WebElement selectUOM;
	
	@FindBy(xpath="//input[@placeholder='Add name']")
	WebElement enterName;
	
	@FindBy(xpath="//span[@class='indicator-label']")
	WebElement submitBtn;
	
	
	
	
	public Products(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnProducts() {
		products.click();
	}
	
	public void clickOnAddProducts() {
		addProducts.click();
	}
	
	public void selectCategory () {
		Select cname = new Select(selectCategory);
		cname.selectByIndex(2);
	}

	public void enterCode () {
		enterCode.click();
		enterCode.sendKeys("1234567891234");
	}

	public void selectUOM () {
		Select uom = new Select(selectUOM);
		uom.selectByIndex(1);
	}
	
	public void enterName () {
		enterName.click();
		enterName.sendKeys("Vegitable");
	}
	
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	
	
}
