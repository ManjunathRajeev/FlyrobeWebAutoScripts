package com.flyrobe.generic;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.flyrobe.pom.LoginPagePO;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class Browsers 
{
	public static WebDriver driver;
	public ArrayList<String> dataSheetList ;
//	public ExcelTestData data;
	
	@Parameters({"browser"})
	@BeforeClass()
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Firefox"))
		{
		    FirefoxDriverManager.getInstance().setup();
		    driver=new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("http://www.flyrobe.com");
		
		}
		else if (browser.equalsIgnoreCase("Chrome"))
		{
			
			ChromeDriverManager.getInstance().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://www.flyrobe.com");
		}
	}
	
	@AfterClass()
	public void closeBrowser()
	{
//		driver.close();
	}
}
