package com.fb.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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
	
	@FindBy(name = "items.0.remarks")
	WebElement enterRemarks;
	
	@FindBy(name = "items.1.remarks")
	WebElement enter2ndRemarks;
	
	@FindBy(name = "items.2.remarks")
	WebElement enter3rdRemarks;
	
	@FindBy(name = "items.3.remarks")
	WebElement enter4thRemarks;
	
	@FindBy(name = "items.4.remarks")
	WebElement enter5thRemarks;
	
	@FindBy(name = "items.5.remarks")
	WebElement enter6thRemarks;
	
	@FindBy(name = "items.6.remarks")
	WebElement enter7thRemarks;
	
	@FindBy(name = "items.7.remarks")
	WebElement enter8thRemarks;
	
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[3]/button[1]")
	WebElement submitBtn;

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
	  public String getPageTitle() { return driver.getTitle(); }
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
	public void enterRemarksAndSubmit() {
		WebElement[] remarksFields = { enterRemarks, enter2ndRemarks };
		boolean allFieldsFilled = true;

		for (int i = 0; i < remarksFields.length; i++) {
		    WebElement remarksField = remarksFields[i];
		    if (remarksField.isDisplayed()) {
		        TestBase base = new TestBase();
		        base.scrollDown(driver, 0, 1000);
		        remarksField.click();
		        remarksField.sendKeys("Issues");

		        if (remarksField.getAttribute("Value").isEmpty()) {
		            allFieldsFilled = false;
		            break;
		        }
		    } else {
		        break;
		    }
		}

		if (allFieldsFilled) {
		    submitBtn.click();}
		}

	/*
	 * WebElement[] remarksFields = { enterRemarks, enter2ndRemarks,
	 * enter3rdRemarks, enter4thRemarks, enter5thRemarks, enter6thRemarks }; boolean
	 * isElementPresent = true;
	 * 
	 * for (WebElement remarksField : remarksFields) { if (isElementPresent &&
	 * remarksField.isDisplayed()) { TestBase base = new TestBase();
	 * base.scrollDown(driver, 0, 1000); remarksField.click();
	 * remarksField.sendKeys("Issues"); } else { break; } } submitBtn.click(); }
	 */
	 


	
	/*
	 * public void clickSubmitBtn() throws InterruptedException { TestBase base =
	 * new TestBase(); base.scrollDown(driver, 0, 1000); submitBtn.click(); }
	 */
	 
	public void approveProcess() throws InterruptedException {
		approveIconElement.click();
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1000);
		approveBtn.click();
		popupApproveBtn.click();

	}

	
}
