package com.test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseFunctions {
	WebDriver driver;
	
	public BaseFunctions(WebDriver test){
		this.driver = test;
	}
	
	public void typeInInputXpath(WebElement elem, String valueToType) {
		elem.sendKeys(valueToType);
	}
	public void clickXpath(WebElement elem) {
		elem.click();
	}
	public void typeText(WebElement elem, String value) {
		elem.sendKeys(value);
	}
	public boolean isElementVisible(WebElement elem) {
		if (elem.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	}
}
