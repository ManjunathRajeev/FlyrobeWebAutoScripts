package com.cbt.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class WomenRentOccasionPO 
{
	public WomenRentOccasionPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='RENT BY OCCASION']")
	private WebElement eleWomRentOccasionTab;
	public WebElement getEleWomRentOccasionTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleWomRentOccasionTab, driver);
		ReusableMethods.implictWait(driver);
		return eleWomRentOccasionTab;
	}
	
	@FindBy(xpath="//ul[@class='pl-0 mb-25'][4]//li[@class='men-left-accessories']//a")
	private List<WebElement> eleWomRentOccasionSubLnk;
	public List<WebElement> getEleRentOccasionSubLnk()
	{
		return eleWomRentOccasionSubLnk;
	}
}
