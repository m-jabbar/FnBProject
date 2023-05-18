package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class OutwardPage extends TestBase {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/outward']//div[@class='icon']//img[@alt='icon']")
	WebElement outwardElement;

	@FindBy(xpath = "//a[normalize-space()='Add Outward']")
	WebElement addOutwardElement;

	@FindBy(xpath = "//div[@class='multi-select__control css-13cymwt-control']")
	WebElement materialIssuanceNumElement;
	
	@FindBy(id = "react-select-2-option-0")
	WebElement selectValueFromList;
	
	@FindBy(xpath = "//input[@name='items.0.remarks']")
	WebElement giveRemarksElement;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[3]/button[1]")
	WebElement submitBtnElement;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconElement;
	
	@FindBy(xpath = "//button[@id='liveToastBtn']")
	WebElement approveBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement popupApproveBtn;
	
	
	public OutwardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public String getPageTitle() { return driver.getTitle(); }
	 */

	public void clickOnOutward() {
		outwardElement.click();
	}

	public void clickOnAddOutward() {
		addOutwardElement.click();
	}

	public void selectIssuanceNum() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(materialIssuanceNumElement));
		materialIssuanceNumElement.click();
		selectValueFromList.click();
	}
	
	public void giveRemarks() {
		giveRemarksElement.click();
		giveRemarksElement.sendKeys("OK");
	}

	public void clickSubmitBtn() throws InterruptedException {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1000);
		submitBtnElement.click();
	}
	public void approveProcess() throws InterruptedException {
		approveIconElement.click();
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1000);
		approveBtn.click();
		popupApproveBtn.click();

	}

	
}
