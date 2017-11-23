package com.cbt.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class MenRentDesignerPO 
{
	public MenRentDesignerPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='RENT BY DESIGNERS']")
	private WebElement eleMenRentDesgnrTab;
	public WebElement getEleMenRentDesgnrTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleMenRentDesgnrTab, driver);
		Thread.sleep(3000);
		return eleMenRentDesgnrTab;
	}
	
	@FindBy(xpath="//ul[@class='pl-0 mb-25'][2]//li[@class='men-left-accessories']//a[@class='a-submenu-link']")
	private List<WebElement> eleMenRentDesgnrSubLnk;
	public List<WebElement> getEleMenRentDesgnrSubLnk()
	{
		return eleMenRentDesgnrSubLnk;
	}
}
