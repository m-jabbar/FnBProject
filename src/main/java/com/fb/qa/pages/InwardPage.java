package com.fb.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class InwardPage extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/inward']//div[@class='icon']//img[@alt='icon']")
	private WebElement inwardElement;

	@FindBy(xpath = "//a[normalize-space()='Add Inward']")
	private WebElement addInwardElement;

	@FindBy(xpath = "//div[@class='multi-select__input-container css-19bb58m']")
	private WebElement inwardNumber;

	@FindBy(id = "react-select-2-option-0")
	private WebElement inwardNumberList;

	@FindBy(css = "input[name^='items'][name$='remarks']")
	private List<WebElement> remarksFields;

	/*
	 * @FindBy(xpath = "//input[@placeholder='Remarks']") private WebElement
	 * giveRemarksElement;
	 */

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIcon;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	private WebElement popupApproveBtn;

	public InwardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnInward() {
		inwardElement.click();
	}

	public void clickOnAddInward() {
		addInwardElement.click();
	}

	public void selectInwardNumber() {
		inwardNumber.click();
		inwardNumberList.click();
	}

	public void enterRemarksInAllFields() {
		String remarksText = "Ok";

		for (WebElement remarksField : remarksFields) {
			remarksField.click();
			remarksField.clear();
			remarksField.sendKeys(remarksText);
		}
	}
	/*
	 * scrollDown(driver, 0, 600); String idPrefix = "items."; String idSuffix =
	 * ".remarks"; int elementNumber = 0;
	 * 
	 * while (true) { String locatorName = idPrefix + elementNumber + idSuffix;
	 * 
	 * List<WebElement> remarksFields = driver.findElements(By.name(locatorName));
	 * if (remarksFields.isEmpty()) { break; }
	 * 
	 * WebElement remarksField = remarksFields.get(0); remarksField.click();
	 * remarksField.sendKeys("Ok");
	 * 
	 * elementNumber++; }
	 * 
	 * }
	 */

	public void submitBtn() {
		scrollDown(driver, 0, 500);
		submitBtn.click();
	}

	public void approveIcon() {
		approveIcon.click();
	}

	public void approveBtn() {
		approveBtn.click();
	}

	public void popupApproveBtn() {
		popupApproveBtn.click();
	}
}
