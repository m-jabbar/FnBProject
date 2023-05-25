package com.fb.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class MaterialReturn extends TestBase {
	public WebDriver driver;

	@FindBy(xpath = "//a[@href='/material-return']")
	WebElement materialReturn;

	@FindBy(xpath = "//a[normalize-space()='Add Material Return']")
	WebElement addMaterialReturn;

	@FindBy(xpath = "//div[@class='multi-select__control css-13cymwt-control']")
	WebElement materialIssuanceNo;

	@FindBy(id = "react-select-2-option-0")
	WebElement selectMaterialIssuanceNo;

	@FindBy(xpath = "//select[@name='location']")
	WebElement selectLoacation;

	@FindBy(xpath = "//select[@name='providedToDepartment']")
	WebElement providedDepartment;

	@FindBy(xpath = "//select[@name='receivedByDepartment']")
	WebElement receivingDepartment;

	@FindBy(name = "items.0.remarks")
	WebElement enterRemarks;

	@FindBy(name = "items.1.remarks")
	WebElement enter2ndRemarks;

	@FindBy(name = "items.2.remarks")
	WebElement enter3rdRemarks;

	@FindBy(id = "liveToastBtn")
	WebElement submitBtn;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconClick;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	WebElement againApproveBtn;

	@FindBy(xpath = "//div[contains(text(),'Supplier has been approved (jabbar1)')]")
	WebElement toastMessageVeri1;

	public MaterialReturn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMaterialReturn() {
		materialReturn.click();
	}

	public void clickOnAddMaterialReturn() {
		addMaterialReturn.click();
	}

	public void materialReturnList() {
		materialIssuanceNo.click();
		selectMaterialIssuanceNo.click();
	}

	public void selectLocation() {
		selectLoacation.click();
		Select select = new Select(selectLoacation);
		select.selectByIndex(2);
	}

	public void selectProvideDepartment() {
		providedDepartment.click();
		Select select = new Select(providedDepartment);
		select.selectByIndex(2);
	}

	public void selectReceivedDepartment() {
		receivingDepartment.click();
		Select select = new Select(receivingDepartment);
		select.selectByIndex(2);
	}

	/*
	 * public void enter1stQuantity() { enter1stQuantity.click();
	 * enter1stQuantity.sendKeys(Keys.CLEAR); enter1stQuantity.sendKeys("1"); }
	 */

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

		        if (remarksField.getAttribute("value").isEmpty()) {
		            allFieldsFilled = false;
		            break;
		        }
		    } else if (i == 0) {
		        // Handle the case where only one field is present
		        allFieldsFilled = false;
		        break;
		    }
		}

		if (allFieldsFilled) {
		    submitBtn.click();}
		}


	/*
	 * if (isElementPresent(enter1stRemarks)) { enterRemarks(enter1stRemarks,
	 * "Ok Issues"); clickSubmitButton(); } else { int fieldCount = 1; boolean
	 * isFieldPresent = true;
	 * 
	 * while (isFieldPresent) { WebElement remarksField =
	 * getRemarksFieldByIndex(fieldCount);
	 * 
	 * if (isElementPresent(remarksField)) { enterRemarks(remarksField, "Ok");
	 * fieldCount++; } else { isFieldPresent = false; } }
	 * 
	 * clickSubmitButton(); } }
	 * 
	 * private void enterRemarks(WebElement remarksField, String remarks) {
	 * remarksField.click(); remarksField.sendKeys(remarks); }
	 * 
	 * private boolean isElementPresent(WebElement remarksField) { try { return
	 * remarksField.isDisplayed(); } catch (NoSuchElementException e) { return
	 * false; } }
	 * 
	 * private WebElement getRemarksFieldByIndex(int fieldCount) { String fieldName
	 * = "items[" + (fieldCount - 1) + "].remarks"; return
	 * driver.findElement(By.name(fieldName)); }
	 * 
	 * private void clickSubmitButton() { try { submitBtn.click(); } catch
	 * (NoSuchElementException e) { System.out.println("Submit button not found.");
	 * } }
	 */
	public void approveIcon() {
		approveIconClick.click();
	}

	public void clickOnApproveBtn() {
		approveBtn.click();
	}

	public void clickAgainOnApproveBtn() {
		againApproveBtn.click();
	}
}
