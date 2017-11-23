package com.flyrobe.generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestngListners implements ITestListener 
{
	private static String fileSeperator = System.getProperty("file.separator");

	public void onFinish(ITestContext finish) 
	{
		System.out.println(" Finished Testing : " + finish.getName());
	}

	public void onStart(ITestContext start)
	{
		System.out.println(" Started Testing :  " + start.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
			
	}
	
	public String failedDate()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateInfo=dateFormat.format(date);
		return dateInfo;
	}

	public void onTestFailure(ITestResult fail) 
	{	
		 System.out.println(" *****Errorr " + fail.getName() + " Test gas faield***** ");
		 String instanceName =fail.getInstanceName();
		 String className = instanceName.substring(instanceName.lastIndexOf('.')+1);
		 String methodName = fail.getName().toString().trim();
		 String screenShotName = className + "_" + methodName + ".png";
		 takeScreenShot(Browsers.driver, screenShotName, className);
	}
	
	public void takeScreenShot(WebDriver driver,String screenShotName, String testName)
	{
		try 
		{
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File screenShotLocation = new File("Screenshots" + fileSeperator + "Results" + fileSeperator + testName,screenShotName);
			FileUtils.copyFile(screenShot, screenShotLocation);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult skip) 
	{
		System.out.println(" Test Excecution skipped :  " + skip.getName());
	}

	public void onTestStart(ITestResult start) 
	{
		System.out.println(" Execution Started :  " + start.getName());
	}

	public void onTestSuccess(ITestResult success) 
	{
		System.out.println(" Test Excecution Passed :  " + success.getName());	
	}
}
