package com.cbt.script;

import org.testng.annotations.Test;

import com.cbt.generic.Browsers;
import com.cbt.generic.CommonMethodsPO;
import com.cbt.pom.MenNewArrivalPO;
import junit.framework.Assert;

public class MenNewArrivalTest extends Browsers
{
	MenNewArrivalPO newArrival;
	CommonMethodsPO men;
	
	@Test()
	public void men() throws Exception
	{
		newArrival=new MenNewArrivalPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("men Category....");
		men.getEleMenLst(driver);
		newArrival.getEleMenNewArrivlLnk(driver);
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
	}
}
