package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class Locations extends TestBase {
	
	public Locations(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
