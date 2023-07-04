package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.fb.qa.base.TestBase;

public class ProductCategory extends TestBase {
	WebDriver wait;
	public WebDriver driver;
	
	@FindBy(xpath="//a[@href=\"/product-categories\"]")
	WebElement productCategory;
	
	@FindBy(xpath="//a[@id='kt_toolbar_primary_button']")
	WebElement addProductCategory;
	
	@FindBy(name="name")
	WebElement productName;

	@FindBy(xpath="//select[@name='assetType']")
	WebElement assestType;
	
	@FindBy(xpath="//div[@class='multi-select__input-container css-ackcql']")
	WebElement parentCategory;
	
	@FindBy(id="react-select-2-option-0")
	WebElement parentCategoryListValue;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	
	
	public ProductCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnProductCategory() {
		productCategory.click();
	}
	public void clickOnAddProductCategory() {
		addProductCategory.click();
	}
	
	public void selectProductName() {
		productName.click();
		productName.sendKeys("New Product");
		
	}
	public void selectAssestType () {
		Select pname = new Select(assestType);
		pname.selectByIndex(1);
	}
	
	public void selectParentCategoryListValue() {
		parentCategory.click();
		parentCategoryListValue.click();
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
}
