package com.fb.qa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.fb.qa.base.TestBase;

public class MaterialInspection extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,'/material-inspection')]")
	private WebElement materialInspection;

	@FindBy(id = "kt_toolbar_primary_button")
	private WebElement addMaterialInspection;

	@FindBy(xpath = "//div[@class='multi-select__input-container css-19bb58m']")
	private WebElement purchaseOrderNum;

	@FindBy(id = "react-select-2-option-0")
	private WebElement purchaseOrderNumList;

	@FindBy(name = "invoiceNo")
	private WebElement invoiceNumberInput;

	@FindBy(name = "location")
	private WebElement locationSelect;

	@FindBy(css = "input[name^='items'][name$='remarks']")
	private List<WebElement> remarksFields;

	@FindBy(id = "liveToastBtn")
	private WebElement submitBtn;

	@FindBy(xpath = "//tbody/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIcon;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	public MaterialInspection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMaterialInspection() {
		materialInspection.click();
	}

	public void clickOnAddMaterialInspection() {
		addMaterialInspection.click();
	}

	public void selectPurchaseOrderNumber() {
		purchaseOrderNum.click();
		purchaseOrderNumList.click();
	}

	public void enterInvoiceNumber() {
		invoiceNumberInput.click();
		invoiceNumberInput.sendKeys("1");
//		invoiceNumberInput.sendKeys(Keys.RETURN);
	}

	public void selectLocation() {
		locationSelect.click();
		Select select = new Select(locationSelect);
		select.selectByIndex(2);
	}

	public void enterRemarksInAllFields() {
		scrollDown(driver, 500, 0);
		String remarksText = "Ok";

		for (WebElement remarksField : remarksFields) {
			remarksField.click();
			remarksField.clear();
			remarksField.sendKeys(remarksText);
		}
	}

	public void submitBtn() {
		scrollDown(driver, 700, 0);
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
