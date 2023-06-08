package com.fb.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryReports {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='/inventory/report']")
    private WebElement inventoryReports;

    @FindBy(id = "815096000809-20230606")
    private WebElement qrCode;

    public InventoryReports(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	/*
	 * public String getQRCodeValue() { return qrCode.getText(); }
	 */

    public void clickQRCodeByID(String qrCodeID) {
    	inventoryReports.click();
        String qrCodeLocator = String.format("id=815096000809-20230606", qrCodeID);
        WebElement qrCodeElement = driver.findElement(By.xpath(qrCodeLocator));
        qrCodeElement.click();
    }

    public String getQRCodeValueByID(String qrCodeID) {
        String qrCodeLocator = String.format("//span[@id='%s']", qrCodeID);
        WebElement qrCodeElement = driver.findElement(By.xpath(qrCodeLocator));
        return qrCodeElement.getText();
    }
}
