package com.fb.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class MaterialReturn extends TestBase  {
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

	@FindBy(name = "items.0.quantity")
	WebElement enter1stQuantity;
	
	@FindBy(name = "items.1.quantity")
	WebElement enter12ndQuantity;
	
	@FindBy(name = "items.2.quantity")
	WebElement enter3rdQuantity;
	
	@FindBy(name = "items.0.remarks")
	WebElement enter1stRemarks;
	
	@FindBy(name = "items.1.remarks")
	WebElement enter2ndRemarks;
	
	@FindBy(name = "items.2.remarks")
	WebElement enter3rdRemarks;
	
	
	
	
	@FindBy(id = "liveToastBtn")
	WebElement submitBtn;
	
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconClick;
	
	@FindBy(xpath="//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary float-right']")
	WebElement againApproveBtn;
	
	@FindBy(xpath="//div[contains(text(),'Supplier has been approved (jabbar1)')]")
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
	public void enter1stQuantity() {
		enter1stQuantity.click();
		enter1stQuantity.sendKeys(Keys.CLEAR);
		enter1stQuantity.sendKeys("1");
	}
	public void enter1stRemarks() {
		enter1stRemarks.click();
		enter1stRemarks.sendKeys("Accepted");
	}
	
	public void enter2ndQuantity() {
		enter1stQuantity.click();
		enter1stQuantity.sendKeys(Keys.CLEAR);
		enter1stQuantity.sendKeys("1");
	}
	public void enter2ndRemarks() {
		enter2ndRemarks.click();
		enter2ndRemarks.sendKeys("Accepted");
	}
	
	public void enter3rdQuantity() {
		enter3rdQuantity.click();
		enter3rdQuantity.sendKeys(Keys.CLEAR);
		enter3rdQuantity.sendKeys("1");
	}
	public void enter3rdRemarks() {
		enter3rdRemarks.click();
		enter3rdRemarks.sendKeys("Accepted");
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
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
