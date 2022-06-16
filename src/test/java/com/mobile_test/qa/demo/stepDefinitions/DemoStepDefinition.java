package com.mobile_test.qa.demo.stepDefinitions;

import org.openqa.selenium.WebElement;

import com.mobile_test.qa.demo.pages.DemoPage;
import com.mobile_test.qa.utils.Hook;

import cucumber.api.java.en.Given;
import io.appium.java_client.android.AndroidDriver;

public class DemoStepDefinition {

	private AndroidDriver<WebElement> driver;
	private DemoPage demoPage = new DemoPage(driver);

	public DemoStepDefinition() {
		driver = Hook.driver;
	}

	@Given("^Open url in firefox navigator$")
	public void openUrlInFirefoxNavigator() throws Throwable {
		System.out.println("Open url in firefox navigator");
		demoPage.getUrl();
	}

}
