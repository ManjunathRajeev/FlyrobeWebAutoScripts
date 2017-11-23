package com.flyrobe.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.MenGroomCollectPO;

import junit.framework.Assert;

public class MenGroomCollectTest extends Browsers
{
	MenGroomCollectPO groom;
	CommonMethodsPO men;
	
	@Test()
	public void menGroomCollection() throws Exception
	{
		groom=new MenGroomCollectPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Men Groom Collection Category Started....");
		men.getEleMenLst(driver);
		groom.getEleMenGroomCollctTab(driver);
		groom.getEleMenGroomCollctnSubLnk();
		for(WebElement gromCollc:groom.getEleMenGroomCollctnSubLnk())
		{
		
		  System.out.println(" The sub category : " + gromCollc.getText() + " of Men Groom Collectiong Started...");
		  gromCollc.click();	
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
