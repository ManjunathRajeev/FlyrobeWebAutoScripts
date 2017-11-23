package com.cbt.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class WomenRentCollectnPO 
{
	public WomenRentCollectnPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[text()='RENT BY COLLECTION']")
	private WebElement eleWomRentCollctnTab;
	public WebElement getEleWomRentCollctnTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleWomRentCollctnTab, driver);
	
		ReusableMethods.implictWait(driver);
		return eleWomRentCollctnTab;
	}
	
	@FindBy(xpath="//ul[4]//li//a")
	private List<WebElement> eleWomRentCollctnSubLnk;
	public List<WebElement> getEleRentCollctnSubLnk()
	{
		return eleWomRentCollctnSubLnk;
	}
}
