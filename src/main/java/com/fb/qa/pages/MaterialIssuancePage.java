package com.fb.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class MaterialIssuancePage extends TestBase {
	private WebDriver driver;
	private String qrCode = "123456789-20230731";

	@FindBy(xpath = "//a[contains(@href, \"/material-issuance\")]")
	private WebElement materialIssuanceLink;

	@FindBy(xpath = "//a[normalize-space()='Add Material Issuance']")
	private WebElement addMaterialIssuanceLink;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]")
	private WebElement materialReqNoField;

	@FindBy(id = "react-select-2-option-0")
	private WebElement selectMaterialReqNoOption;

	@FindBy(xpath = "//input[@placeholder='QR Code']")
	private WebElement firstQRCodeField;

	@FindBy(xpath = "//tbody/tr[2]/td[7]/div[1]/button[1]/span[1]")
	private List<WebElement> deleteButtons;

	@FindBy(name = "items.0.quantity")
	private WebElement quantityField;

	@FindBy(name = "items.0.assetNumber")
	private WebElement assetNumberField;

	@FindBy(name = "items.0.remarks")
	private WebElement remarksField;

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIcon;

	@FindBy(id = "liveToastBtn")
	private WebElement approveBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
	private WebElement popupApproveBtn;

	public MaterialIssuancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnMaterialIssuance() {
		materialIssuanceLink.click();
	}

	public void clickOnAddMaterialIssuance() {
		addMaterialIssuanceLink.click();
	}

	public void selectMaterialReqNo() throws InterruptedException {
		materialReqNoField.click();
		selectMaterialReqNoOption.click();
	}

	public void addQRCode() throws InterruptedException {
		// Enter the QR code in the first field
		firstQRCodeField.clear();
		firstQRCodeField.sendKeys(qrCode);
		firstQRCodeField.sendKeys(Keys.ENTER);

		// Click on delete button for any additional QR code fields that appear
		for (WebElement deleteButton : deleteButtons) {
			deleteButton.click();
			Thread.sleep(500); // Add a small delay for stability
		}
	}

	public void enterQuantity() throws InterruptedException {
		quantityField.sendKeys(Keys.CLEAR);
		quantityField.sendKeys("1");
	}

	public void enterAssetNumber() {
		scrollDown(driver, 0, 600);
		assetNumberField.click();
		assetNumberField.sendKeys("aaaa");
	}

	public void enterRemarks() {
		remarksField.click();
		remarksField.sendKeys("Ok");
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
