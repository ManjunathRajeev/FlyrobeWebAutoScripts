package com.cbt.pom;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class MenGroomCollectPO 
{
	public MenGroomCollectPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//li[@class='men-left-list font-base-demi'])[4]")
	private WebElement eleMenGroomCollctTab;
	public WebElement getEleMenGroomCollctTab(WebDriver driver) throws InterruptedException
	{
		ReusableMethods.scrollToElement(eleMenGroomCollctTab, driver);
		Thread.sleep(3000);
//		Robot rob= new Robot();
//		rob.keyPress(KeyEvent.VK_PAGE_UP);
//		Thread.sleep(3000);
		return eleMenGroomCollctTab;
	}
	
	@FindBy(xpath="//ul[5]//li//a[@class='a-submenu-link']")
	private List<WebElement> eleMenGroomCollctnSubLnk;
	public List<WebElement> getEleMenGroomCollctnSubLnk()
	{
		return eleMenGroomCollctnSubLnk;
	}
	
//	@FindBy(xpath="//ul[@class='pl-0 mb-25'][3]//li[@class='men-left-list-sets font-base-regular']")
//	private WebElement eleMenGroomWearLnk;
//	public WebElement getEleMenGroomWearLnk()
//	{
//		eleMenGroomWearLnk.click();
//		return eleMenGroomWearLnk;
//	}

}
