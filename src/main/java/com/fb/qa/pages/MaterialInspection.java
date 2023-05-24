package com.fb.qa.pages;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class MaterialInspection extends TestBase {

	public WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,\"/material-inspection\")]")
	WebElement materialInspection;

	@FindBy(id = "kt_toolbar_primary_button")
	WebElement addMaterialInspection;

	@FindBy(xpath = "//div[@class='multi-select__input-container css-19bb58m']")
	WebElement purchaseOrderNum;

	@FindBy(id = "react-select-2-option-0")
	WebElement purchaseOrderNumList;

	@FindBy(name = "invoiceNo")
	WebElement enterInvoiceNo;

	@FindBy(name = "location")
	WebElement selectLocation;

	@FindBy(name = "items.0.remarks")
	WebElement giveRemarks;

	@FindBy(name = "items.1.remarks")
	WebElement give2ndRemarks;

	@FindBy(name = "items.2.remarks")
	WebElement give3rdRemarks;

	@FindBy(name = "items.3.remarks")
	WebElement give4thRemarks;

	@FindBy(name = "items.4.remarks")
	WebElement give5thRemarks;

	@FindBy(name = "items.5.remarks")
	WebElement give6thRemarks;

	@FindBy(name = "items.6.remarks")
	WebElement give7thRemarks;
	
	
	@FindBy(id = "liveToastBtn")
	WebElement submitBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconEle;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;

	public MaterialInspection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions
	public void clickOnMaterialInspection() {
		materialInspection.click();
	}

	public void clickOnAddMaterialInspection() {
		addMaterialInspection.click();
	}

	public void selectPurcahsenumvalue() {
		purchaseOrderNum.click();
		purchaseOrderNumList.click();
	}

	public void enterInvoiceNum() {
		enterInvoiceNo.click();
		enterInvoiceNo.sendKeys("1");
		enterInvoiceNo.sendKeys(Keys.RETURN);
	}

	public void selectLocation() {
		selectLocation.click();
		Select select = new Select(selectLocation);
		select.selectByIndex(2);
	}
	
	public void giveRemarksAndSubmit() {
	    giveRemarks.click();
	    giveRemarks.sendKeys("Ok Issues");
	    giveRemarks.sendKeys(Keys.TAB);

	    TestBase base = new TestBase();
	    base.scrollDown(driver, 0, 800);

	    int fieldCount = 1;
	    boolean isFieldPresent = true;

	    while (isFieldPresent && fieldCount <= 6) {
	        WebElement remarksField = getRemarksFieldByIndex(fieldCount);

	        if (isElementPresent(remarksField)) {
	            remarksField.click();
	            remarksField.sendKeys("Ok");
	            fieldCount++;
	        } else {
	            isFieldPresent = false;
	        }
	    }

	    if (fieldCount <= 2) {
	        submitBtn.click();
	    } else {
	        clickSubmitButton();
	    }
	}

	private void clickSubmitButton() {
	    try {
	        submitBtn.click();
	    } catch (NoSuchElementException e) {
	        System.out.println("Submit button not found.");
	    }
	}

	private WebElement getRemarksFieldByIndex(int index) {
	    return driver.findElement(By.name("items." + (index - 1) + ".remarks"));
	}

	private boolean isElementPresent(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	//also working
	/*public void giveRemarksAndSubmit() {
	    giveRemarks.click();
	    giveRemarks.sendKeys("Ok Issues");
	    giveRemarks.sendKeys(Keys.TAB);

	    TestBase base = new TestBase();
	    base.scrollDown(driver, 0, 600);

	    WebElement remarksField = null;
	    int fieldCount = 1;

	    while (isElementPresent(getRemarksFieldByIndex(fieldCount))) {
	        remarksField = getRemarksFieldByIndex(fieldCount);
	        remarksField.click();
	        remarksField.sendKeys("Ok");

	        fieldCount++;
	    }

	    submitBtn.click();
	}

	private WebElement getRemarksFieldByIndex(int index) {
	    return driver.findElement(By.name("items." + (index - 1) + ".remarks"));
	}

	private boolean isElementPresent(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}*/

	public void approveProcess() throws InterruptedException {
		approveIconEle.click();
		Thread.sleep(3000);
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 800);
		approveBtn.click();
		againApproveBtn.click();

	}

}
