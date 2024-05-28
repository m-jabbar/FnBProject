package com.fb.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fb.qa.base.TestBase;

public class MaterialRequisitionPage extends TestBase {
	public WebDriver driver;
	@FindBy(xpath = "//a[contains(@href, 'material-requisition')]")
	WebElement materialReq;

	@FindBy(xpath = "//a[normalize-space()='Add Material Requisition']")
	WebElement addMaterialReq;

	@FindBy(xpath = "//select[@name='department']")
	WebElement departmentList;

	@FindBy(xpath = "//select[@name='location']")
	WebElement locationList;

	@FindBy(xpath = "//div[@class='multi-select__value-container css-hlgwow']")
	WebElement productList;

	@FindBy(id = "react-select-2-option-1")
	WebElement selectProductList;

	@FindBy(xpath = "//input[contains(@name, \"items.0.quantity\")]")
	WebElement quantity;

	@FindBy(xpath = "//button[contains(@class,'btn btn-lg btn-primary me-3')]")
	WebElement submitBtn;

//	@FindBy(xpath = "//div[@role='alert']")
//	private WebElement alert;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement toastMessage;

	@FindBy(xpath = "//tbody/tr[1]/td[11]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveMaterialIcon;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']")
	WebElement popupApproveBtn;

	@FindBy(xpath = "//body/script[1]")
	WebElement toastMessage1;

	public MaterialRequisitionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public void clickOnMaterialRequisition() {
		materialReq.click();
	}

	public void clickOnAddMaterialReq() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addMaterialReq));
		addMaterialReq.click();
	}

	public void selectDepartment() {
		departmentList.click();
		new Select(departmentList).selectByIndex(3);
	}

	public void selectLocation() {
		locationList.click();
		new Select(locationList).selectByVisibleText("C4");
	}

	public void selectProduct() throws InterruptedException {
		scrollDown(driver, 0, 1500);
		productList.click();
		selectProductList.click();
	}

	public void enterQuantity() throws InterruptedException {
		quantity.click();
		quantity.sendKeys("1");

	}

	public void submitBtn() throws InterruptedException {
		submitBtn.click();
	}

	/*
	 * public void alertMessage() { try { Alert alert = driver.switchTo().alert();
	 * String text = alert.getText(); System.out.println("Alert text: " + text);
	 * alert.accept(); } catch (NoAlertPresentException ex) {
	 * System.out.println("No alert is present: " + ex.getMessage()); }
	 * 
	 * }
	 */

	public String getToastMessage() {
		return toastMessage.getText();
	}

	public void approveMaterialIcon() throws InterruptedException {
		approveMaterialIcon.click();
	}

	public void approveBtn() throws InterruptedException {
		scrollDown(driver, 0, 500);
		approveBtn.click();
	}

	public void popupApproveBtn() throws InterruptedException {
		popupApproveBtn.click();
		Thread.sleep(1000);
	}
}
