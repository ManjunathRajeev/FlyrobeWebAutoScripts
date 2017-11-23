package com.flyrobe.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReusableMethods 
{
	public static WebDriver driver;
	public static JavascriptExecutor js;
	
	public static void locatorWait(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void scrollToElement(WebElement element,WebDriver driver)
	{
		js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}
	
	public static void scrollToTop(WebDriver driver)
	{
		js =(JavascriptExecutor)driver;
		js.executeScript("scroll(0, -250);");
	}
	
	public static void implictWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}
