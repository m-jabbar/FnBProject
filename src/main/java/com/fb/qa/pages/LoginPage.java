package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase {
	private WebDriver driver;

	// Page Factory
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/form/div[2]/input")
	private WebElement enterUsername;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/form/div[3]/input")
	private WebElement enterPassword;

	@FindBy(id = "kt_sign_in_submit")
	private WebElement loginButton;

	@FindBy(xpath = "//img[contains(@class,\"logo-default\")]")
	private WebElement logo;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		enterUsername.sendKeys(username);
	}

	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public HomePage login(String email, String password) {
		enterUsername.sendKeys(email);
		enterPassword.sendKeys(password);
		loginButton.click();

		return new HomePage(driver);
	}
}
