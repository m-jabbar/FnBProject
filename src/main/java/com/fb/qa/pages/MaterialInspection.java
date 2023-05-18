package com.fb.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class MaterialInspection extends TestBase{

	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"kt_content_container\"]/section/div/div/div/div/div/div/div[6]/a")
	WebElement materialInspection;
	
	@FindBy(id = "kt_toolbar_primary_button")
	WebElement addMaterialInspection;
	
	@FindBy(xpath = "//div[@class='multi-select__input-container css-19bb58m']")
	WebElement purchaseOrderNum;
	
	@FindBy(id = "react-select-2-option-0")
	WebElement purchaseOrderNumList;
	
	@FindBy(name = "invoiceNo")
	WebElement enterInvoiceNo;
	
	@FindBy(name = "location")
	WebElement selectLocation;
	
	@FindBy(name = "items.0.remarks")
	WebElement giveRemarks;
	
	@FindBy(id = "liveToastBtn")
	WebElement submitBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconEle;
	
	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;
	

	
	public MaterialInspection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public void clickOnMaterialInspection() {
		materialInspection.click();
	}
	
	public void clickOnAddMaterialInspection() {
		addMaterialInspection.click();
	}
	
	public void selectPurcahsenumvalue() {
		purchaseOrderNum.click();
		purchaseOrderNumList.click();
	}
	
	public void enterInvoiceNum() {
		enterInvoiceNo.click();
		enterInvoiceNo.sendKeys("1");
		enterInvoiceNo.sendKeys(Keys.RETURN);
	}
	
	public void selectLocation() {
		selectLocation.click();
		Select select = new Select(selectLocation);
		select.selectByIndex(1);
	}
	
	public void giveRemarksAndSubmit() {
		giveRemarks.click();
		giveRemarks.sendKeys("Ok Issues");
		giveRemarks.sendKeys(Keys.TAB);
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 600);
		submitBtn.click();
	}
	
	public void approveProcess() {
		approveIconEle.click();
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1400);
		approveBtn.click();
		againApproveBtn.click();
		
	}
	
	
}
