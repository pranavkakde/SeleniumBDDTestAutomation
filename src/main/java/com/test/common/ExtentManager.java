package com.test.common;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	 
	public static ExtentReports Instance(){
		 ExtentReports extent;
		 String Path = "./ExtentReport.html";
		 System.out.println(Path);
		 extent = new ExtentReports(Path, false);
		 extent.config()
		              .documentTitle("Automation Report")
		              .reportName("Regression");
		 
		 return extent;
       }
	public static String CaptureScreen(WebDriver driver, String ImagesPath){
	    TakesScreenshot oScn = (TakesScreenshot) driver;
	    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
	    File oDest = new File(ImagesPath+".jpg");
	    try {
	    	Files.copy(oScnShot, oDest);
	    }catch(IOException e){System.out.println(e.getMessage());}
	    return ImagesPath+".jpg";
	}
}