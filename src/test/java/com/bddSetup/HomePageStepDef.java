package com.bddSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.common.ExtentManager;
import com.test.pages.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import cucumber.annotation.*;
//import cucumber.annotation.en.*;
import cucumber.api.java.en.And;
//import org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.Reporter;

public class HomePageStepDef {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private HomePage home =null;
	private Scenario scenario;
	@Before
	public void setUp(Scenario scn) {
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
    	//driver = new FirefoxDriver();
		this.scenario = scn;
		driver = new ChromeDriver();
    	home = new HomePage(driver);
    	//Extent report setup
    	extent = new ExtentReports(System.getProperty("user.dir") +"/report/extentReport.html", true);
    	extent.loadConfig(new File(System.getProperty("user.dir")+ "\\config.xml"));
    	//Reporter.addScenarioLog("Running scenario for multiple tests");
    	test = extent.startTest("Multiple item search " +scenario.getName()  , "Multiple item search"  ); 
	}
	@Given("^MyStore Page is visible$")
	  public void MyStore_Page_is_visible() throws Throwable {
		Assert.assertEquals(true, home.openURL("http://automationpractice.com/index.php/"));		 
		if (home.getHomeTitle().equalsIgnoreCase("My Store")) {
			  test.log(LogStatus.PASS, "My Store Page is loaded");
			  //Reporter.addStepLog("My Store Page is loaded");
		  }else {
			  test.log(LogStatus.FAIL, "My Store Page is not loaded");
			  //Reporter.addStepLog("My Store Page is not loaded");
		  }	      
		  //Assert.assertEquals(home.getHomeTitle(), "My Store");
	}
	
	@And("^\"SearchBox\" is visible$")
	public void searchBoxVisible() throws Throwable {
	  //Assert.assertEquals(true, home.isSearchVisible());
		if (home.isSearchVisible()) {
			  test.log(LogStatus.PASS, "Search Box is visible");
			  //Reporter.addStepLog("Search Box is visible");
		}else {
			  test.log(LogStatus.FAIL, "Search Box is not visible");
			  //Reporter.addStepLog("Search Box is not visible");
		}
	}
	@When("^I enter (.*?) in \"SearchBox\"$")
	public void whenEnterText(String textToSearch) throws Throwable {
		home.typeInSearch(textToSearch);
		test.log(LogStatus.INFO , "Entered text "+ textToSearch +"in search box");
		//Reporter.addStepLog("Entered text "+ textToSearch +"in search box");
	}
	@When("^click on SearchButton$")
	public void click_on() throws Throwable {
		home.clickOnSearch();
		test.log(LogStatus.INFO , "clicked on search button");
		//Reporter.addStepLog("clicked on search button");
	}
	@Then("^I should see a (.*) text$")
	public void then(String searchListText) throws Throwable {
		if (home.getSearchListText().equalsIgnoreCase(searchListText)) {
			test.log(LogStatus.PASS, "Search results "+ searchListText +" are visible");
			//Reporter.addStepLog("Search results "+ searchListText +"are visible");
		}else {		  
			//test.log(LogStatus.FAIL, "Search results "+searchListText+" are not visible");
			String imagePath = System.getProperty("user.dir") + "/report/screenshots/" + "Ishouldseea";
			test.log(LogStatus.FAIL, test.addScreenCapture(ExtentManager.CaptureScreen(driver,imagePath)));
			//Reporter.addStepLog("Search results "+ searchListText +"are not visible");
		}
	}	
	@After
	public void tear() {
	  extent.endTest(test);
	  extent.flush();
	  extent.close();
	  driver.quit();
	} 

}
