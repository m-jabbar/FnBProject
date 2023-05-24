package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase {
	public WebDriver driver;
	
	//Page Factory
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[2]/input")
	WebElement emailInput;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/form/div[3]/input")
	WebElement passwordInput;
	
	
	@FindBy(id="kt_sign_in_submit")
	WebElement loginButton;
	
//	@FindBy(id="kt_sign_in_submit")
//	WebElement getTitle;
	
	@FindBy(xpath="//img[contains(@class,\"logo-default\")]")
	WebElement logo;

	//initilization of page object
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage login(String email, String password)
	{
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return new HomePage(driver);
	}
}
