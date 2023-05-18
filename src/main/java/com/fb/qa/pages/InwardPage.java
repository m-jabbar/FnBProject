package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class InwardPage extends TestBase {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/inward']//div[@class='icon']//img[@alt='icon']")
	WebElement inwardElement;

	@FindBy(xpath = "//a[normalize-space()='Add Inward']")
	WebElement addInwardElement;
	
	@FindBy(xpath = "//div[@class='multi-select__input-container css-19bb58m']")
	WebElement inwardNumber;
	
	@FindBy(id = "react-select-2-option-0")
	WebElement inwardNumberList;
	
	@FindBy(xpath = "//input[@placeholder='Remarks']")
	WebElement giveRemarksElement;
	
	@FindBy(xpath = "//span[normalize-space()='Submit']")
	WebElement submitBtn;
	
	
	@FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconElement;
	
	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	WebElement popupApproveBtn;
	
	public InwardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnInward() {
		inwardElement.click();
	}

	public void clickOnAddInward() {
		addInwardElement.click();
	}
	
	public void outwardList() {
		inwardNumber.click();
		inwardNumberList.click();
	}
	
	public void giveRemarks() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1000);
		giveRemarksElement.click();
		giveRemarksElement.sendKeys("Ok");
	}
	
	
	public void submitBtn() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 500);
		submitBtn.click();
	}
	
	public void ApproveInward() {
		approveIconElement.click();
		approveBtn.click();
		popupApproveBtn.click();
	}
}
