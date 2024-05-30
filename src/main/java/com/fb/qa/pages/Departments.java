package com.fb.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class Departments extends TestBase {
	
	public Departments(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
