package com.cbt.pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class WomenEthnicWearPO 
{
	public WomenEthnicWearPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='ETHNIC WEAR']")
	private WebElement eleWomEthnicWearLnk;
	public WebElement getEleWomEthnicWearLnk(WebDriver driver) throws AWTException, InterruptedException
	{
//		ReusableMethods.locatorWait(driver, By.xpath("//a[text()='ETHNIC WEAR']"));
		eleWomEthnicWearLnk.click();
		ReusableMethods.implictWait(driver);
		return eleWomEthnicWearLnk;
	}
}
