package com.mobile_test.qa.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hook {

	public static AndroidDriver<WebElement> driver;
	public static Properties prop;

	public Hook() throws IOException {
	}

	@Before()
	public void startServer() throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", ConfigFileReader.getApplicationUrl("platformName"));
		cap.setCapability("platformVersion", ConfigFileReader.getApplicationUrl("platformVersion"));
		cap.setCapability("udid", ConfigFileReader.getApplicationUrl("udid"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigFileReader.getApplicationUrl("deviceName"));
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigFileReader.getApplicationUrl("app_package"));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigFileReader.getApplicationUrl("app_activity"));
		driver = new AndroidDriver<WebElement>(new URL(ConfigFileReader.getApplicationUrl("hub.url")), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://portailpro.gouv.fr/");
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			try {
				scenario.write("current page url is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlateformDontSupportScrennshots) {
				System.err.println(somePlateformDontSupportScrennshots.getMessage());
			}
		}

		driver.quit();
	}

	public static AndroidDriver<WebElement> getDriver() {
		return driver;
	}
}
