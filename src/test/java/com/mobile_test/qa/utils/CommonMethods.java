package com.mobile_test.qa.utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itextpdf.text.pdf.parser.clipper.Clipper.Direction;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonMethods extends AbstractPage{
	
	public static Properties prop;
	public CommonMethods(WebDriver driver) {
		super(driver);
	}
	
	public void SwipeLeftRight(AndroidDriver<WebElement> driver, Direction leftToRight) throws Throwable{
		//left or right
		System.out.println("[Btv][Android] : Swipe "+leftToRight+"...");
		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();
		System.out.println("[Btv][Android] : Screen Size = "+size);
		int startX = 0, startY=0, endX = 0, endY = 0;
		if (leftToRight.equals("left")) {	
			startX = (int) (size.width * 0.90);
			endX = (int) (size.width * 0.10);
			//startY = size.height / 2;
			startY = (int) (size.height * 0.80); // it can be valid for swipe on fullscreen mode
			System.out.println("[Btv][Android] : Screen high = "+size.height);
			endY = startY;
			System.out.println("[Btv][Android] : startX = " + startX + " ,startY = " + startY + " , endX = " + endX + ", endY = " + endY);
		}else if (leftToRight.equals("right")) {
			startX = (int) (size.width * 0.20);
			endX = (int) (size.width * 0.80);
			startY = size.height / 2;
			endY = startY;
			System.out.println("[Btv][Android] : startX = " + startX + " ,startY = " + startY + " , endX = " + endX + ", endY = " + endY);	
		}
		TouchAction swipe = new TouchAction(driver)
	            .press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	            .moveTo(PointOption.point(endX,endY))
	            .release()
	            .perform();
	}
	 
	

}
