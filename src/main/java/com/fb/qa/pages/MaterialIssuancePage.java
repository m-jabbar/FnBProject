package com.fb.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fb.qa.base.TestBase;

public class MaterialIssuancePage extends TestBase {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(@href, \"/material-issuance\")]")
	WebElement materialIssuance;;

	@FindBy(xpath ="//a[normalize-space()='Add Material Issuance']")
	WebElement addMaterialIssuance;
	
	@FindBy(xpath = "//div[contains(@class,\"multi-select__input-container css-19bb58m\")]")
	WebElement materialReqNo;
	
	@FindBy(id = "react-select-2-option-0")
	WebElement selectMaterialReqNo;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
	WebElement addQRCode;

	
	@FindBy(name = "items.0.quantity")
	WebElement enterQuantity;
	
	@FindBy(name = "items.0.assetNumber")
	WebElement giveAssetsNum;

	@FindBy(name = "items.0.remarks")
	WebElement giveRemarks;

	@FindBy(xpath= "//span[normalize-space()='Submit']")
	WebElement submitBtn;

//	@FindBy(xpath ="//div[@role='alert']")
//	WebElement toastMessageElement;
 
	@FindBy(xpath = "//tbody/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIcon;

	@FindBy(id = "liveToastBtn")
	WebElement approveButton;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
	WebElement confirmButton;

	public MaterialIssuancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnMaterialIssuance() {
		materialIssuance.click();
	}

	public void clickOnAddMaterialIssuance() {
		addMaterialIssuance.click();
	}

	public void selectMaterialNum() throws InterruptedException {
		materialReqNo.click();
		selectMaterialReqNo.click();
	}

	public void addQRCode() throws InterruptedException {
		addQRCode.click();
		addQRCode.sendKeys("123");
	}
	
	public void enterQuantity() throws InterruptedException {
//		enterQuantity.click();
		enterQuantity.sendKeys(Keys.CLEAR);
		enterQuantity.sendKeys("1");
	}
	
	
	public void giveAssetsNum() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 600);
		giveAssetsNum.click();
		giveAssetsNum.sendKeys("aaaa");
	}

	public void giveRemarks() {

		giveRemarks.click();
		giveRemarks.sendKeys("Ok");
	}

	public void clickSubmitBtn() throws InterruptedException {
//		driver.get(driver.getCurrentUrl());
		submitBtn.click();

	}

	/*public String getToastMessage() {
		return toastMessageElement.getText();
	}*/


	public void approveMaterialProcess() {
		approveIcon.click();
		approveIcon.click();
		approveIcon.click();
	}

}
