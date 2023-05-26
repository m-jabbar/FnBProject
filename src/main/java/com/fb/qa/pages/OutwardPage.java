package com.fb.qa.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	List<WebElement> remarksFields;

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

	public void enterRemarksInAllFields() {
		String idPrefix = "input.";
		String idSuffix = ".remarks";
		int elementNumber = 0;

		while (true) {
			String id = idPrefix + elementNumber + idSuffix;

			  // get element and enter the input
			enterRemarks.sendKeys("ok");
			
			WebElement remarksField;
			try {
				remarksField = driver.findElement(By.name("item.1.remarks"));
			} catch (NoSuchElementException e) {
				break;
			}
			remarksField.click();
			remarksField.sendKeys("Ok");

			// Check if the next element is present
			elementNumber += 1;
			id = idPrefix + elementNumber + idSuffix;
			try {
				driver.findElement(By.name(id));
			} catch (NoSuchElementException e) {
				break;
			}
		}

	}
	/*
	 * remarksFields = new ArrayList<>(); remarksFields.add(enterRemarks);
	 * remarksFields.add(enter2ndRemarks); remarksFields.add(enter3rdRemarks);
	 * remarksFields.add(enter4thRemarks); remarksFields.add(enter5thRemarks);
	 * remarksFields.add(enter6thRemarks); // Add additional remarks fields as
	 * needed
	 * 
	 * for (WebElement remarksField : remarksFields) { if
	 * (isFieldPresent(remarksField)) { enterRemarks(remarksField, "Ok Issues" +
	 * remarksFields.indexOf(remarksField)); } else { break; // Break the loop if
	 * the next field is not present } } }
	 * 
	 * private void enterRemarks(WebElement field, String remarks) {
	 * field.sendKeys(remarks); }
	 * 
	 * private boolean isFieldPresent(WebElement field) { try { return
	 * field.isDisplayed(); } catch (org.openqa.selenium.NoSuchElementException e) {
	 * return false; } }
	 */
	/*
	 * if (isFieldPresent(enterRemarks)) { enterRemarks(enterRemarks, "Ok"); } else
	 * { return; // Break the loop if the next field is not present } if
	 * (isFieldPresent(enter2ndRemarks)) { enterRemarks(enter2ndRemarks, "Issued");
	 * } else { return; // Break the loop if the next field is not present } if
	 * (isFieldPresent(enter3rdRemarks)) { enterRemarks(enter3rdRemarks,
	 * "Remarks for field 3"); } else { return; // Break the loop if the next field
	 * is not present } if (isFieldPresent(enter4thRemarks)) {
	 * enterRemarks(enter4thRemarks, "Remarks for field 4"); } else { return; //
	 * Break the loop if the next field is not present } if
	 * (isFieldPresent(enter5thRemarks)) { enterRemarks(enter5thRemarks,
	 * "Remarks for field 5"); } else { return; // Break the loop if the next field
	 * is not present } if (isFieldPresent(enter6thRemarks)) {
	 * enterRemarks(enter6thRemarks, "Remarks for field 6"); } else { return; //
	 * Break the loop if the next field is not present } // Add additional if
	 * conditions for other fields if needed }
	 * 
	 * private void enterRemarks(WebElement field, String remarks) {
	 * field.sendKeys(remarks); }
	 * 
	 * private boolean isFieldPresent(WebElement field) { try { return
	 * field.isDisplayed(); } catch (org.openqa.selenium.NoSuchElementException e) {
	 * return false; } }
	 */

	public void submitBtn() throws InterruptedException {
		submitBtn.click();
	}

	public void approveProcess() throws InterruptedException {
		approveIconElement.click();
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1000);
		approveBtn.click();
		popupApproveBtn.click();

	}

}
