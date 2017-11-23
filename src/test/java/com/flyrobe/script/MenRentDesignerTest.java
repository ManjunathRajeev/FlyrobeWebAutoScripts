package com.flyrobe.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.MenRentDesignerPO;

import junit.framework.Assert;

public class MenRentDesignerTest extends Browsers
{
	MenRentDesignerPO design;
	CommonMethodsPO men;
	
	@Test()
	public void menbrandCollection() throws Exception
	{
		design=new MenRentDesignerPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Men Rent By Brands Category Started....");
		men.getEleMenLst(driver);
		design.getEleMenRentDesgnrTab(driver);
		design.getEleMenRentDesgnrSubLnk();
		for(WebElement designRent:design.getEleMenRentDesgnrSubLnk())
		{	
		  System.out.println(" The sub category : " + designRent.getText() + " of Men brand Collectiong Started...");
		  designRent.click();	
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

