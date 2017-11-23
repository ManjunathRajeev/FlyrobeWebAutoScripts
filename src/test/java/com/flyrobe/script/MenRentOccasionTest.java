package com.flyrobe.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.MenRentOccasionPO;

import junit.framework.Assert;

public class MenRentOccasionTest extends Browsers
{
	MenRentOccasionPO occasion;
	CommonMethodsPO men;
	
	@Test()
	public void menbrandCollection() throws Exception
	{
		occasion=new MenRentOccasionPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Men Rent By Brands Category Started....");
		men.getEleMenLst(driver);
		occasion.getEleMenRentOccasnTab(driver);
		occasion.getEleMenRentOccsnSubLnk();
		for(WebElement occasionRent:occasion.getEleMenRentOccsnSubLnk())
		{	
		  System.out.println(" The sub category : " + occasionRent.getText() + " of Men brand Collectiong Started...");
		  occasionRent.click();	
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


