package com.flyrobe.pom;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flyrobe.generic.ReusableMethods;

public class WomenEthnicNewArivalPO 
{
	public WomenEthnicNewArivalPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='hover-menu occasion-nav'])[1]")
	private WebElement eleWomenLst;
	public WebElement getEleWomenLst(WebDriver driver) throws AWTException
	{
		eleWomenLst.click();
		Robot rob = new Robot();
		rob.mouseMove(110, 64);
		return eleWomenLst;
	}
	
	@FindBy(xpath="(//a[text()='ETHNIC NEW ARRIVALS'])[3]")
	private WebElement eleWomEthnicNewArrvlLnk;
	public WebElement getEleWomEthnicNewArrvlLnk(WebDriver driver) throws AWTException, InterruptedException
	{
//		ReusableMethods.locatorWait(driver, By.xpath("//a[text()='ETHNIC WEAR']"));
		eleWomEthnicNewArrvlLnk.click();
		ReusableMethods.implictWait(driver);
		return eleWomEthnicNewArrvlLnk;
	}
}
