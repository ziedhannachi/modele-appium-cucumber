package com.mobile_test.qa; 
 
import org.junit.runner.RunWith; 
 
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions; 

import cucumber.api.SnippetType;
import cucumber.api.CucumberOptions; 
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
        excludeCoverageTags = {"@flaky"},
        includeCoverageTags = {"@passed"},
        outputFolder = "target")

@CucumberOptions(features = { "src/test/features" }, plugin = { "pretty", "pretty:target/cucumber-pretty.txt", "html:target/cucumber",
		"json:target/cucumber.json", "usage:target/cucumber-usage.json"
		,"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/mobile-test-report.html"	}, snippets = SnippetType.CAMELCASE,
		tags = {"@demo"}, monochrome = true)
 
public class RunCukeTest{
	 
	public static int retries = 0;
	public RunCukeTest() {}
	public static boolean retryCheck(Throwable e ) {
		return !e.getMessage().contains("configuration failed");
	}
		 
}