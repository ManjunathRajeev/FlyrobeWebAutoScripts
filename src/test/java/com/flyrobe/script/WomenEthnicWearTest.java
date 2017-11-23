package com.flyrobe.script;

import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.WomenEthnicWearPO;

import junit.framework.Assert;

public class WomenEthnicWearTest extends Browsers
{
	WomenEthnicWearPO wearEthnic;
	CommonMethodsPO women;
	
	@Test()
	public void women() throws Exception
	{
		wearEthnic=new WomenEthnicWearPO(driver);
		women=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Women Category....");
		women.getEleWomenLst(driver);
		wearEthnic.getEleWomEthnicWearLnk(driver);
		women.getEleProdCount(driver);
		women.getELeProdCard();
		women.getEleSortByBtn(driver);
		women.getEleSortByPopular();
		women.getEleSortByBtn(driver);
		women.getEleSortByLowPrice();
		women.getEleSortByBtn(driver);
		women.getEleSortByHighPrice();
		women.getEleProdDelverDateIcn();
		women.getEleCalendarDate();
		Assert.assertTrue("Date is succesfully selected", women.getEleClearBtn().isDisplayed());
		women.getEleTopSizeFilter(driver);
		women.getEleCategoryFilter(driver);
		women.getEleOcassionFilter(driver);
		women.getElePriceFilter(driver);
		women.getEleBrandFilter(driver);
	}
}
