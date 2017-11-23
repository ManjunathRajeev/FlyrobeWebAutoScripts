package com.cbt.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cbt.generic.Browsers;
import com.cbt.generic.CommonMethodsPO;

import com.cbt.pom.MenRentStylePO;

import junit.framework.Assert;

public class MenRentStyleTest extends Browsers
{
	MenRentStylePO style;
	CommonMethodsPO men;
	
	@Test()
	public void menbrandCollection() throws Exception
	{
		style=new MenRentStylePO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Men Rent By Brands Category Started....");
		men.getEleMenLst(driver);
		style.getEleMenRentStyleTab(driver);
		style.getEleMenRentStyleSubLnk();
		for(WebElement styleRent:style.getEleMenRentStyleSubLnk())
		{	
		  System.out.println(" The sub category : " + styleRent.getText() + " of Men brand Collectiong Started...");
		  styleRent.click();	
		  Thread.sleep(3000);
		  men.getEleProdCount(driver);
		  men.getELeProdCard();
		  men.getEleSortByBtn(driver);
		  men.getEleSortByPopular();
		  men.getEleSortByBtn(driver);
		  men.getEleSortByLowPrice();
		  men.getEleSortByBtn(driver);
	   	  men.getEleSortByHighPrice();
		  men.getEleOkayGotItBtn();
		  men.getEleProdDelverDateIcn();
		  men.getEleCalendarDate();
		  Assert.assertTrue("Date is succesfully selected", men.getEleClearBtn().isDisplayed());
		  men.getEleTopSizeFilter(driver);
		  men.getEleCategoryFilter(driver);
		  men.getEleOcassionFilter(driver);
		  men.getElePriceFilter(driver);
		  men.getEleBrandFilter(driver);
		  driver.navigate().back();
		  Thread.sleep(4000);
		}
	}
}
