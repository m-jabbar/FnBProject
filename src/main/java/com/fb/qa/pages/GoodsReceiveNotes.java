package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class GoodsReceiveNotes extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/goods-received-note']")
	private WebElement goodsReceiveNotes;

	@FindBy(xpath = "//a[normalize-space()='Add Good Received Note']")
	private WebElement addGoodsReceiveNote;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
	private WebElement materialInspectionNum;

	@FindBy(id = "react-select-2-option-0")
	private WebElement materialInspectionNumList;

	@FindBy(name = "deliveryChallanNumber")
	private WebElement deliveryNum;

	@FindBy(xpath = "//input[@name='attachments']")
	private WebElement uploadFile;

	@FindBy(xpath = "//input[@placeholder='Select Date']")
	private WebElement selectDate;

	@FindBy(xpath = "//div[@title='01 Jul 2023']")
	private WebElement selectExpireDate;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//button[@title='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIcon;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	public GoodsReceiveNotes(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goodsReceiveNotes() {
		goodsReceiveNotes.click();
	}

	public void addGoodsReceiveNote() {
		addGoodsReceiveNote.click();
	}

	public void selectMaterialInspectionNum() {
		materialInspectionNum.click();
		materialInspectionNumList.click();
	}

	public void enterDeliveryNum() {
		deliveryNum.click();
		deliveryNum.sendKeys("111");
	}

	public void uploadFileProcess() {
		uploadFile.sendKeys("D:\\Jabbar'd data\\Before new OS 27-4-23\\pom.png");
	}

	public void selectDateProcess() {
		selectDate.click();
		selectExpireDate.click();
		scrollDown(driver, 0, 800);
		okBtn.click();
	}

	public void submitBtn() {
		scrollDown(driver, 600, 0);
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
