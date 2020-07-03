package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.common.BaseFunctions;

public class HomePage extends BaseFunctions{
	private WebDriver driver;
	//BaseFunctions bf = new BaseFunctions(driver);
	
	@FindBy(id="search_query_top")	
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;
	
	/*@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[2]")
	WebElement searchMsg;*/
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement searchLink;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[1]")
	WebElement searchListText;
	
	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isSearchVisible() {
		return isElementVisible(searchBox);
	}
	
	public boolean isSearchLink() {
		return isElementVisible(searchLink);
	}
	
	public boolean openURL(String url) {
		boolean retVal=false;
		driver.get(url);
		retVal=true;
		return retVal;
	}
	
	public String getHomeTitle() {
		return driver.getTitle();
	}
	
	public void typeInSearch(String value) {
		typeInInputXpath(searchBox, value);
	}
	
	public void clickOnSearch() {
		clickXpath(searchButton);
	}
	
	public String getSearchListText() {
		return searchListText.getText();
	}
}
