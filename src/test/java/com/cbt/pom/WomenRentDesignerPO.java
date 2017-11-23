package com.cbt.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class WomenRentDesignerPO 
{
	public WomenRentDesignerPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[text()='RENT BY DESIGNERS']")
	private WebElement eleWomRentDesgnrTab;
	public WebElement getEleWomRentDesgnrTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleWomRentDesgnrTab, driver);
		
		ReusableMethods.implictWait(driver);
		return eleWomRentDesgnrTab;
	}
	
	@FindBy(xpath="//ul[3]//li//a")
	private List<WebElement> eleWomRentDesgnrSubLnk;
	public List<WebElement> getEleRentDesgnrSubLnk()
	{
		return eleWomRentDesgnrSubLnk;
	}
}
