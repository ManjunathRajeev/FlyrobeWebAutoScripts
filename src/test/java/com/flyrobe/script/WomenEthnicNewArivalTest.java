package com.flyrobe.script;

import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.WomenEthnicNewArivalPO;

import junit.framework.Assert;

public class WomenEthnicNewArivalTest extends Browsers
{
	WomenEthnicNewArivalPO newEthnic;
	CommonMethodsPO women;
	
	@Test()
	public void women() throws Exception
	{
		newEthnic=new WomenEthnicNewArivalPO(driver);
		women=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Women Category....");
		women.getEleWomenLst(driver);
		newEthnic.getEleWomEthnicNewArrvlLnk(driver);
		women.getEleProdCount(driver);
		women.getELeProdCard();
		women.getEleSortByBtn(driver);
		women.getEleSortByPopular();
		women.getEleSortByBtn(driver);
		women.getEleSortByLowPrice();
		women.getEleSortByBtn(driver);
		women.getEleSortByHighPrice();
		women.getEleOkayGotItBtn();
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
