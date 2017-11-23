package com.flyrobe.pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.thread.graph.IWorker;

import com.flyrobe.generic.ExcelData;
import com.flyrobe.generic.ExcelTestData;
import com.flyrobe.generic.ReusableMethods;

public class LoginPagePO 
{
	ExcelTestData data = new ExcelTestData();
	
	public LoginPagePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label")
	private List<WebElement> eleSelCityLst;
	public List<WebElement> getEleSelCityLst() throws Exception
	{
		int totalCity = eleSelCityLst.size();
		String rowValue = ExcelData.readDataFromExcel("cityName", "Bengaluru");
		System.out.println("Total City List is = " + totalCity);
		for(int i = 0;i<totalCity;i++)
		{
			if(eleSelCityLst.get(i).getText().equals(rowValue))
			{
				System.out.println(eleSelCityLst.get(i).getText() + " is found in the list and here we go.....");
				eleSelCityLst.get(i).click();
				break;
			}
			System.out.println("Still Searching..........");
		}
		return eleSelCityLst;
	}
	
	@FindBy(xpath="//a[@title='select city']")
	private WebElement eleSelectedCity;
	public WebElement getEleSelectedCity()
	{
		return eleSelectedCity;
	}
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	private WebElement eleLoginBtn;
	public WebElement getEleLoginBtn()
	{
		eleLoginBtn.click();
		return eleLoginBtn;
	}
	
	@FindBy(xpath="//button[contains(text(),'GOOGLE')]")
	private WebElement eleGoogleAcctBtn;
	public WebElement getEleGoogleAcctBtn() throws IOException
	{
		eleGoogleAcctBtn.click();
		return eleGoogleAcctBtn;
	}
	
	@FindBy(id="identifierId")
	private WebElement eleGmailTxtFld;
	public WebElement getEleGmailTxtFld(WebDriver driver) throws IOException, InterruptedException
	{
		String email = ExcelData.readDataFromExcel("UN", "cbtcrowd710@gmail.com");
		System.out.println(email);
		String parentWindow = driver.getWindowHandle();
		
		for(String childWindow :driver.getWindowHandles())
		{
			driver.switchTo().window(childWindow);
		}
		ReusableMethods.locatorWait(driver, By.id("identifierId"));
		eleGmailTxtFld.sendKeys(email);
		return eleGmailTxtFld;
	}
	
	@FindBy(id="identifierNext")
	private WebElement eleGmailNxtBtn;
	public WebElement getEleGmailNxtBtn()
	{
		eleGmailNxtBtn.click();
		return eleGmailNxtBtn;
	}
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement elePwdTxtFld;
	public WebElement getElePwdTxtFld(WebDriver driver) throws IOException
	{
		String passWord = ExcelData.readDataFromExcel("Pwd", "pear@123");
		ReusableMethods.locatorWait(driver, By.xpath("//input[@type='password']"));
		elePwdTxtFld.sendKeys(passWord);
		return eleGmailNxtBtn;
	}
	
	@FindBy(id="passwordNext")
	private WebElement elePwdNxtBtn;
	public WebElement getElePwdNxtBtn(WebDriver driver) throws InterruptedException
	{
		elePwdNxtBtn.click();
		Thread.sleep(10000);
		Set<String> winh = driver.getWindowHandles();
		for(String handle : winh)
		{
			System.out.println(driver.switchTo().window(handle).getTitle());
			if(!driver.getTitle().equals("Rent Women's & Men's Clothing Online | Dresses, Lehengas, Suits & more - Flyrobe.com "))
			{
				driver.switchTo().window(handle);
			}
			else
				break;
		}
		return elePwdNxtBtn;
	}
	
	@FindBy(id="demo-menu-lower-right")
	private WebElement eleMenuDropDwnArrw;
	public WebElement getEleMenuDropDwnArrw(WebDriver driver) throws InterruptedException
	{	
		Assert.assertTrue(eleMenuDropDwnArrw.isDisplayed(), "Login Successfully");
		eleMenuDropDwnArrw.click();
		return eleMenuDropDwnArrw;
	}
	
	@FindBy(id="//li[text()='Logout']")
	private WebElement eleLogoutBtn;
	public WebElement getEleLogoutBtn()
	{
		eleLogoutBtn.click();
		return eleMenuDropDwnArrw;
	}
	
}
