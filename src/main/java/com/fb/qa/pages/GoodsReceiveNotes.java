package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;


public class GoodsReceiveNotes extends TestBase {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/goods-received-note']")
	WebElement goodsRecieveNote;
	
	@FindBy(xpath = "//a[normalize-space()='Add Good Received Note']")
	WebElement addGoodsRecieveNote;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	WebElement materialInspectionNum;
	
	@FindBy(id = "react-select-2-option-0")
	WebElement materialInspectionNumList;
	
	@FindBy(name = "deliveryChallanNumber")
	WebElement deliveryNum;
	
	@FindBy(xpath = "//input[@name='attachments']")
	WebElement uploadFile;
	
	@FindBy(xpath = "//input[@placeholder='Select Date']")
	WebElement selectDate;
	
	@FindBy(xpath = "//div[@title='08 May 2023 (Today)']")
	WebElement selectDateFromCalender;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement okBtn;

	@FindBy(xpath = "//button[@title='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	WebElement approveIconEle;
	
	@FindBy(xpath = "//button[@id='liveToastBtn']")
	WebElement approveBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	WebElement againApproveBtn;
	
	public GoodsReceiveNotes(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnGoodsRecieveNotes() {
		goodsRecieveNote.click();
		
	}

	public void clickOnAddGoodsRecieveNotes() {
		addGoodsRecieveNote.click();
	}
	
	public void materialInspectionList() {
		materialInspectionNum.click();
		materialInspectionNumList.click();
	}
	 
	public void enterDeliveryNum() {
		deliveryNum.click();
		deliveryNum.sendKeys("111");
//		deliveryNum.sendKeys(Keys.TAB);
	}
	
	public void uploadFileProcess() {
		uploadFile.sendKeys("D:\\Jabbar'd data\\Before new OS 27-4-23\\pom.png");
	}
	public void selectDateProcess() {
	    selectDate.click();
	    String formattedDate = getFormattedCurrentDate();
	    String calendarXPath = "//input[@placeholder='Select Date']";
	    selectDateFromCalendar(calendarXPath, formattedDate);
	    TestBase base = new TestBase();
	    base.scrollDown(driver, 0, 800);
	    okBtn.click();
	}
	
	public void clickOnSubmitBtn() {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 1000);
		submitBtn.click();
	}

	public void clickOnApproveIcon() {
		approveIconEle.click();
	}

	public void clickOnApproveBtn() throws InterruptedException {
		TestBase base = new TestBase();
		base.scrollDown(driver, 0, 600);
		approveBtn.click();
	}
	
	public void clickAgainOnApproveBtn() throws InterruptedException {
		Thread.sleep(1000);
		againApproveBtn.click();
	}

	
}
