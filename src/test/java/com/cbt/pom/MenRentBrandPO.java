
package com.cbt.pom;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class MenRentBrandPO 
{
	public MenRentBrandPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='RENT BY BRANDS']")
	private WebElement eleMenRentBrandTab;
	public WebElement getEleMenRentBrandTab(WebDriver driver) throws AWTException, InterruptedException
	{
		ReusableMethods.scrollToElement(eleMenRentBrandTab, driver);
		Thread.sleep(3000);
		return eleMenRentBrandTab;
	}
	
	@FindBy(xpath="//ul[3]//li//a[@class='a-submenu-link']")
	private List<WebElement> eleMenRentBrandSubLnk;
	public List<WebElement> getEleMenRentBrandSubLnk()
	{
		int accsCount = eleMenRentBrandSubLnk.size();
		for(int i=1;i<accsCount;i++)
		{
			eleMenRentBrandSubLnk.get(i).click();
		}
		return eleMenRentBrandSubLnk;
	}
}

