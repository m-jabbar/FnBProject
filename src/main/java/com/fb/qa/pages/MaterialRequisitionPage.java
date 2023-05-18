package com.fb.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.fb.qa.base.TestBase;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaterialRequisitionPage extends TestBase {
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(@href, 'material-requisition')]")
	WebElement materialReq;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]")
	WebElement addMaterialReq;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[1]/div[2]/select[1]")
	WebElement departmentList;

	@FindBy(xpath = "//select[@name='location']")
	WebElement locationList;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement productList;
	
	@FindBy(id = "react-select-2-option-2")
	WebElement selectProductList;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/input[1]")
	WebElement quantity;

	@FindBy(xpath = "//button[contains(@class,\"btn btn-lg btn-primary me-3\")]")
	WebElement submitbtn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement toastMessage;

	@FindBy(xpath = "//tbody/tr[1]/td[11]/div[1]/a[1]/button[1]/span[1]")
	WebElement clickOnApproveMaterial;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	WebElement submitApproveBtn;

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
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(departmentList));
		departmentList.click();
		Select select = new Select(departmentList);
		select.selectByIndex(1);
	}

	public void selectLocation() {
		locationList.click();
		Select select = new Select(locationList);
		select.selectByIndex(1);
	}

	public void selectProduct() throws InterruptedException {
		TestBase scroll = new TestBase();
		scroll.scrollDown(driver, 0, 1500);
		productList.click();
		selectProductList.click();
	}

	public void enterQuantity() throws InterruptedException {
		quantity.click();
		quantity.sendKeys("1");
		quantity.sendKeys(Keys.TAB);

	}

	public void submitBtn() throws InterruptedException {
		submitbtn.click();
	}

	public String getToastMessage() {
		return toastMessage.getText();
	}

	public void approveMateriaIcon() throws InterruptedException {
		clickOnApproveMaterial.click();
	}

	public void approveSumbitBtn() throws InterruptedException {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 500);
		submitApproveBtn.click();
	}

	public void againApproveSumbitBtn() throws InterruptedException {
		popupApproveBtn.click();
//		toastMessage1.getText();
		Thread.sleep(1000);
	}

}
