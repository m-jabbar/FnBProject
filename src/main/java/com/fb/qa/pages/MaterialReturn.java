package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class MaterialReturn extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/material-return']")
	private WebElement materialReturn;

	@FindBy(xpath = "//a[normalize-space()='Add Material Return']")
	private WebElement addMaterialReturn;

	@FindBy(css = ".multi-select__control")
	private WebElement materialIssuanceNo;

	@FindBy(id = "react-select-2-option-0")
	private WebElement selectMaterialIssuanceNo;

	@FindBy(name = "location")
	private WebElement selectLocation;

	@FindBy(name = "providedToDepartment")
	private WebElement providedDepartment;

	@FindBy(name = "receivedByDepartment")
	private WebElement receivingDepartment;

	@FindBy(css = "input[name^='items'][name$='.remarks']")
	private java.util.List<WebElement> remarksFields;

	@FindBy(id = "liveToastBtn")
	private WebElement submitBtn;

	@FindBy(css = "div.toast-message")
	private WebElement toastMessageVerify;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIcon;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	private WebElement popupApproveBtn;

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

	public void selectMaterialReturnList() {
		materialIssuanceNo.click();
		selectMaterialIssuanceNo.click();
	}

	public void selectLocation() {
		new Select(selectLocation).selectByIndex(2);
	}

	public void selectProvidedDepartment() {
		new Select(providedDepartment).selectByIndex(2);
	}

	public void selectReceivedDepartment() {
		new Select(receivingDepartment).selectByIndex(2);
	}

	public void enterRemarks() {
		scrollDown(driver, 0, 600);

		for (WebElement remarksField : remarksFields) {
			remarksField.click();
			remarksField.sendKeys("Ok");
		}
	}

	public void submitBtn() {
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
