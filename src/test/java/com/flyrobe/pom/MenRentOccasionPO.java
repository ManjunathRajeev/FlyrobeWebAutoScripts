package com.flyrobe.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flyrobe.generic.ReusableMethods;

public class MenRentOccasionPO 
{
	public MenRentOccasionPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='RENT BY OCCASION']")
	private WebElement eleMenRentOccasnTab;
	public WebElement getEleMenRentOccasnTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleMenRentOccasnTab, driver);
		Thread.sleep(3000);
		return eleMenRentOccasnTab;
	}
	
	@FindBy(xpath="//ul[@class='pl-0 mb-25'][4]//li[@class='men-left-accessories']")
	private List<WebElement> eleMenRentOccsnSubLnk;
	public List<WebElement> getEleMenRentOccsnSubLnk()
	{
		return eleMenRentOccsnSubLnk;
	}
}
