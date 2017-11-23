
package com.cbt.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cbt.generic.Browsers;
import com.cbt.generic.CommonMethodsPO;
import com.cbt.pom.MenRentBrandPO;

import junit.framework.Assert;

public class MenRentBrandTest extends Browsers
{
	MenRentBrandPO brand;
	CommonMethodsPO men;
	
	@Test()
	public void menbrandCollection() throws Exception
	{
		brand=new MenRentBrandPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Men Rent By Brands Category Started....");
		men.getEleMenLst(driver);
		brand.getEleMenRentBrandTab(driver);
		brand.getEleMenRentBrandSubLnk();
		for(WebElement brandRent:brand.getEleMenRentBrandSubLnk())
		{	
		  System.out.println(" The sub category : " + brandRent.getText() + " of Men brand Collectiong Started...");
		  brandRent.click();	
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
