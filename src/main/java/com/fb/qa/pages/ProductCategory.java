package com.fb.qa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.fb.qa.base.TestBase;

public class ProductCategory extends TestBase {
	WebDriver wait;
	public WebDriver driver;

	@FindBy(xpath = "//a[@href=\"/product-categories\"]")
	WebElement productCategory;

	@FindBy(xpath = "//a[@id='kt_toolbar_primary_button']")
	WebElement addProductCategory;

	@FindBy(name = "name")
	WebElement productName;

	@FindBy(xpath = "//select[@name='assetType']")
	WebElement assestType;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement parentCategory;

	@FindBy(id = "react-select-2-option-0")
	WebElement parentCategoryListValue;

	@FindBy(xpath = "//button[@type='submit']")
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
		String baseTitle = "Items";
		String uniqueString = RandomStringUtils.randomAlphabetic(3); // Adjust the length as needed
		String title = baseTitle + " " + uniqueString;
		productName.sendKeys(title);

	}

	public void selectAssestType() {
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
