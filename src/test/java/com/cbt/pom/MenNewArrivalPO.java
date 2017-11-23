package com.cbt.pom;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class MenNewArrivalPO 
{
	public MenNewArrivalPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@title='Rent New Arrivals'])[2]")
	private WebElement eleMenNewArrivlLnk;
	public WebElement getEleMenNewArrivlLnk(WebDriver driver) throws AWTException
	{
		eleMenNewArrivlLnk.click();
		ReusableMethods.implictWait(driver);
		return eleMenNewArrivlLnk;
	}
	
}
