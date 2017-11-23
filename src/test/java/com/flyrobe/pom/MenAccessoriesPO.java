package com.flyrobe.pom;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flyrobe.generic.ReusableMethods;

public class MenAccessoriesPO 
{
	public MenAccessoriesPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='ACCESSORIES']")
	private WebElement eleMenAccessoryTab;
	public WebElement getEleMenAccessoryTab(WebDriver driver) throws InterruptedException, AWTException
	{
		ReusableMethods.scrollToElement(eleMenAccessoryTab, driver);
		Thread.sleep(3000);
		Robot rob= new Robot();
		rob.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		return eleMenAccessoryTab;
	}
	
	@FindBy(xpath="(//ul[@class='pl-0 mb-25'][5]//li[@class='men-left-accessories']//a[@class='a-submenu-link'])")
	private List<WebElement> eleMenAccesrySubLnk;
	public List<WebElement> getEleMenAccesrySubLnk() throws InterruptedException
	{
		return eleMenAccesrySubLnk;
	}
}
