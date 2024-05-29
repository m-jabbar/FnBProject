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

	@FindBy(xpath = "//a[@href='/suppliers']")
	private WebElement suppliers;

	@FindBy(xpath = "//a[normalize-space()='Add Supplier']")
	private WebElement addSuppliers;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement enterName;

	@FindBy(xpath = "//input[@placeholder='Address']")
	private WebElement addAddress;

	@FindBy(xpath = "//input[@placeholder='City']")
	private WebElement addCity;

	@FindBy(xpath = "//input[@placeholder='Phone No.']")
	private WebElement addPhoneNo;

	@FindBy(xpath = "//input[@placeholder='NTN']")
	private WebElement addNTNNo;

	@FindBy(xpath = "//input[@placeholder='STRN']")
	private WebElement addSTRN;

	@FindBy(xpath = "//input[@placeholder='Bank Name']")
	private WebElement addBankName;

	@FindBy(xpath = "//input[@placeholder='Account Title']")
	private WebElement addAccountTitle;

	@FindBy(xpath = "//input[@placeholder='PK24 SCBL 1234 5678 9025 1526']")
	private WebElement addIBANNo;

	@FindBy(xpath = "//input[@placeholder='Production Capactiy']")
	private WebElement proCapacity;

	@FindBy(xpath = "//input[@placeholder='FBR Registration Status']")
	private WebElement fbrRegisterNo;

	@FindBy(xpath = "//input[@placeholder='Order Capacity']")
	private WebElement orderCapacity;

	@FindBy(xpath = "//select[@name='evaluation.marketPR']")
	private WebElement marketPR;

	@FindBy(xpath = "//select[@name='evaluation.customerRelationManagement']")
	private WebElement customerRelation;

	@FindBy(xpath = "//input[@placeholder='Payments Terms']")
	private WebElement paymentTerms;

	@FindBy(name = "products.0.name")
	private WebElement productName;

	@FindBy(xpath = "//input[@placeholder='description']")
	private WebElement description;

	@FindBy(id = "liveToastBtn")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[contains(text(),'Supplier has been created')]")
	private WebElement toastMessageVerification;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/a[1]")
	private WebElement approveIcon;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	@FindBy(xpath = "//div[contains(text(),'Supplier has been approved (jabbar1)')]")
	private WebElement toastMessageVeri1;

	public Suppliers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSuppliers() {
		suppliers.click();
	}

	public void addSuppliers() {
		addSuppliers.click();
	}

	public void enterName() {
		enterName.click();
		String uniqueName = "jabbar123" + RandomStringUtils.randomAlphabetic(5);
		enterName.sendKeys(uniqueName);
	}

	public void addAddress() {
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
		addAccountTitle.sendKeys("Company Name");
	}

	public void addIBANNo() {
		addIBANNo.click();
		addIBANNo.sendKeys("PK24 SCBL 1234 5678 9025 1526");
	}

	public void proCapacity() {
		proCapacity.click();
		proCapacity.sendKeys("30");
	}

	public void fbrRegisterStatus() {
		fbrRegisterNo.click();
		fbrRegisterNo.sendKeys("PK123 23 321");
	}

	public void orderCapacity() {
		orderCapacity.click();
		orderCapacity.sendKeys("50");
	}

	public void selectMarketPR() {
		marketPR.click();
		new Select(marketPR).selectByIndex(1);
	}

	public void selectCustomerRelation() {
		customerRelation.click();
		new Select(customerRelation).selectByIndex(2);
	}

	public void paymentTerms() {
		paymentTerms.click();
		paymentTerms.sendKeys("T&Cs Apply");
	}

	public void productName() {
		productName.click();
		productName.sendKeys("Vegetable");
	}

	public void giveDescription() {
		description.click();
		description.sendKeys("It is a good product");
	}

	public void submitBtn() {
		submitBtn.click();
	}

	public String getToastMessage() {
		return toastMessageVerification.getText();
	}

	public void approveIcon() {
//		approveIcon.click();
	}

	public void approveBtn() {
		approveBtn.click();
	}

	public void popupApproveBtn() {
		popupApproveBtn.click();
	}

	public String getToastMessage1() {
		return toastMessageVeri1.getText();
	}
}
