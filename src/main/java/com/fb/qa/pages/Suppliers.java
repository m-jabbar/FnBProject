package com.fb.qa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;

public class Suppliers extends TestBase {
	
	public WebDriver driver;
	 
	@FindBy(xpath="//a[@href='/suppliers']")
	WebElement suppliers;
	
	@FindBy(xpath="//a[normalize-space()='Add Supplier']")
	WebElement addSuppliers;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement enterName;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	WebElement addAddress;
	
	@FindBy(xpath="//input[@placeholder='City']")
	WebElement addCity;
	
	@FindBy(xpath="//input[@placeholder='Phone No.']")
	WebElement addPhoneNo;
	
	@FindBy(xpath="//input[@placeholder='NTN']")
	WebElement addNTNNo;
	
	@FindBy(xpath="//input[@placeholder='STRN']")
	WebElement addSTRN;
	
	@FindBy(xpath="//input[@placeholder='Bank Name']")
	WebElement addBankName;
	
	@FindBy(xpath="//input[@placeholder='Account Title']")
	WebElement addAccountTitle;
	
	@FindBy(xpath="//input[@placeholder='PK24 SCBL 1234 5678 9025 1526']")
	WebElement addIBANNo;
	
	@FindBy(xpath="//input[@placeholder='Production Capactiy']")
	WebElement proCapacity;
	
	@FindBy(xpath="//input[@placeholder='FBR Registration Status']")
	WebElement fbrRegisterNo;
	
	@FindBy(xpath="//input[@placeholder='Order Capacity']")
	WebElement orderCapacity;
	
	@FindBy(xpath="//select[@name='evaluation.marketPR']")
	WebElement marketPR;
	
	@FindBy(xpath="//select[@name='evaluation.customerRelationManagement']")
	WebElement cutomerRelation;
	
	@FindBy(xpath="//input[@placeholder='Payments Terms']")
	WebElement paymentTerms;
	
	@FindBy(name="products.0.name")
	WebElement productName;
	
	
	@FindBy(xpath="//input[@placeholder='description']")
	WebElement description;
	
	@FindBy(id="liveToastBtn")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[contains(text(),'Supplier has been created')]")
	WebElement toastMessageVeri;
	
	
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/a[1]")
	WebElement approveIconClick;
	
	@FindBy(xpath="//span[normalize-space()='Approve']")
	WebElement approveBtn;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;
	
	@FindBy(xpath="//div[contains(text(),'Supplier has been approved (jabbar1)')]")
	WebElement toastMessageVeri1;
	
	
	public Suppliers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSuppliers() {
		suppliers.click();
	}
	
	public void clickOnAddSuupliers() {
		addSuppliers.click();
	}
	
	public void enterName() {
		enterName.click();
		String uniqueName = "jabbar123" + RandomStringUtils.randomAlphabetic(5);
	    enterName.sendKeys(uniqueName);
	}
	public void addAddres() {
		addAddress.click();
		addAddress.sendKeys("Johar Town");
	}
	public void addCity() {
		addCity.click();
		addCity.sendKeys("Lahore");
	}
	public void addPhoneNo() {
		addPhoneNo.click();
		addPhoneNo.sendKeys("03022122123");
	}
	public void addNTNNo() {
		addNTNNo.click();
		addNTNNo.sendKeys("12345678");
	}
	public void addSTRN() {
		addSTRN.click();
		addSTRN.sendKeys("1234568");
	}
	public void addBankName() {
		addBankName.click();
		addBankName.sendKeys("SCBL Pakistan");
	}
	public void addAccountTitle() {
		addAccountTitle.click();
		addAccountTitle.sendKeys("Compnay Name");
	}
	public void addIBANNo() {
		addIBANNo.click();
		addIBANNo.sendKeys("PK24 SCBL 1234 5678 9025 1526");
	}
	public void proCapacity() {
		TestBase test = new TestBase();
		test.scrollDown(driver, 0, 600);
		proCapacity.click();
		proCapacity.sendKeys("30");
	}
	public void fbrRegisterNo() {
		fbrRegisterNo.click();
		fbrRegisterNo.sendKeys("PK123 23 321");
	}
	
	public void orderCapacity() {
		orderCapacity.click();
		orderCapacity.sendKeys("50");
	}
	public void selectMarketPR() {
		marketPR.click();
		Select select = new Select(marketPR);
		select.selectByIndex(1);
	}
	public void selectcutomerRelation() {
		cutomerRelation.click();
		Select select = new Select(cutomerRelation);
		select.selectByIndex(1);
	}
	public void paymentTerms() {
		paymentTerms.click();
		paymentTerms.sendKeys("T&Cs Applies");
	}
	public void productName() {
		productName.click();
		productName.sendKeys("Vegitableee");
	}

	public void giveDescription() {
		description.click();
		description.sendKeys("it is good product");
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
	public String getToastMessage() {
		return toastMessageVeri.getText();
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
	public String getToastMessage1() {
		return toastMessageVeri1.getText();
	}
}
