package com.bddSetup;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		//format={"pretty","html:report/testResult.html"},
        features = "src/main/resources/feature/MyStoreSearch.feature",
        glue = {"com.bddSetup"},
        plugin = {"pretty","html:report/testResult.html"}
)
public class BDDSetup { // NOSONAR SonarLint does not know about @RunWith(Cucumber.class)
	//uncomment following for using Reporter plugin. This project uses Extent report plugin
	 /*@AfterClass
	    public static void teardown() {
	        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("os", "Mac OSX");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	    }*/
}