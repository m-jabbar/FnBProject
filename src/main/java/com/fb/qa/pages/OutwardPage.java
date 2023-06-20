package com.fb.qa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fb.qa.base.TestBase;

public class OutwardPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//a[@href='/outward']//div[@class='icon']//img[@alt='icon']")
	private WebElement outwardElement;

	@FindBy(xpath = "//a[normalize-space()='Add Outward']")
	private WebElement addOutwardElement;

	@FindBy(xpath = "//div[@class='multi-select__control css-13cymwt-control']")
	private WebElement materialIssuanceNumElement;

	@FindBy(id = "react-select-2-option-0")
	private WebElement selectValueFromList;

	@FindBy(css = "input[name^='items'][name$='remarks']")
	private List<WebElement> remarksFields;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	private WebElement submitBtn;

	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/a[1]/button[1]/span[1]")
	private WebElement approveIconElement;

	@FindBy(xpath = "//button[@id='liveToastBtn']")
	private WebElement approveBtn;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary float-right']//span[@class='indicator-label'][normalize-space()='Approve']")
	private WebElement popupApproveBtn;

	public OutwardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnOutward() {
		outwardElement.click();
	}

	public void clickOnAddOutward() {
		addOutwardElement.click();
	}

	public void selectIssuanceNum() {
		materialIssuanceNumElement.click();
		selectValueFromList.click();
	}

	public void enterRemarksInAllFields() {
		String remarksText = "Ok";

		for (WebElement remarksField : remarksFields) {
			remarksField.click();
			remarksField.clear();
			remarksField.sendKeys(remarksText);
		}
	}

	public void submitBtn() {
		scrollDown(driver, 600, 0);
		submitBtn.click();
	}

	public void clickOnApproveIcon() {
		approveIconElement.click();
	}

	public void clickOnApproveButton() {
		approveBtn.click();
	}

	public void clickOnPopupApproveButton() {
		popupApproveBtn.click();
	}

}
