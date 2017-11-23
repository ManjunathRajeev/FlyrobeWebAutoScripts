package com.flyrobe.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flyrobe.generic.ReusableMethods;

public class MenRentStylePO 
{
	public MenRentStylePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='RENT BY STYLE']")
	private WebElement eleMenRentStyleTab;
	public WebElement getEleMenRentStyleTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleMenRentStyleTab, driver);
//		Thread.sleep(3000);
		ReusableMethods.implictWait(driver);
		return eleMenRentStyleTab;
	}
	
	@FindBy(xpath="//ul[2]//li//a")
	private List<WebElement> eleMenRentStyleSubLnk;
	public List<WebElement> getEleMenRentStyleSubLnk()
	{
		return eleMenRentStyleSubLnk;
	}
}
