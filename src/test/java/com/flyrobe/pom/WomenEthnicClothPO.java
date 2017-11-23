package com.flyrobe.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flyrobe.generic.ReusableMethods;

public class WomenEthnicClothPO 
{
	public WomenEthnicClothPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='ETHNIC CLOTHING']")
	private WebElement eleWomEthnicClothngTab;
	public WebElement getEleWomEthnicClothngTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleWomEthnicClothngTab, driver);
		ReusableMethods.implictWait(driver);
		return eleWomEthnicClothngTab;
	}
	
	@FindBy(xpath="//ul[@class='pl-0 mb-25'][1]//li[@class='men-left-accessories']//a[@class='a-submenu-link']")
	private List<WebElement> eleWomEthnicClothngSubLnk;
	public List<WebElement> getEleWomEthnicClothngSubLnk()
	{
		return eleWomEthnicClothngSubLnk;
	}
}
