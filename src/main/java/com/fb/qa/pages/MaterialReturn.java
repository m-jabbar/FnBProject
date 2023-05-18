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

	@FindBy(xpath = "//div[@class='multi-select__input-container css-ackcql']")
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
	WebElement enterQuantity;
	
	@FindBy(name = "items.0.remarks")
	WebElement enterRemarks;
	
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
		select.selectByIndex(1);
	}
	
	public void selectProvideDepartment() {
		providedDepartment.click();
		Select select = new Select(providedDepartment);
		select.selectByIndex(1);
	}
	
	public void selectReceivedDepartment() {
		receivingDepartment.click();
		Select select = new Select(receivingDepartment);
		select.selectByIndex(1);
	}
	public void enterQuantity() {
		enterQuantity.click();
		enterQuantity.sendKeys(Keys.CLEAR);
		enterQuantity.sendKeys("1");
	}
	public void enterRemarks() {
		enterRemarks.click();
		enterRemarks.sendKeys("Accepted");
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
