package com.mobile_test.qa.demo.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobile_test.qa.utils.ConfigFileReader;
import com.mobile_test.qa.utils.Hook;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DemoPage {
	
	AndroidDriver<WebElement> driver;
	private final static String propertyFilePath= "src/test/resources/configs/config.properties";
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	public DemoPage(AndroidDriver<WebElement> driver) {
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void getUrl() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(propertyFilePath);
		prop.load(fis);
		Hook.driver.get(prop.getProperty("home.url"));
	}

}
