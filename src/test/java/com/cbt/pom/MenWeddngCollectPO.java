package com.cbt.pom;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cbt.generic.ReusableMethods;

public class MenWeddngCollectPO 
{
	public MenWeddngCollectPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Rent Wngedding Collections']")
	private WebElement eleMenWeddngCollctnLnk;
	public WebElement getEleMenWeddngCollctnLnk(WebDriver driver) throws AWTException
	{
		eleMenWeddngCollctnLnk.click();
		ReusableMethods.implictWait(driver);
		return eleMenWeddngCollctnLnk;
	}
	
}
