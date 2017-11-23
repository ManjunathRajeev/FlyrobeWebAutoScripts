package com.cbt.script;

import org.testng.annotations.Test;

import com.cbt.generic.Browsers;
import com.cbt.generic.CommonMethodsPO;
import com.cbt.pom.MenWeddngCollectPO;

import junit.framework.Assert;

public class MenWeddngCollectTest extends Browsers
{
	MenWeddngCollectPO wedding;
	CommonMethodsPO men;
	
	@Test()
	public void men() throws Exception
	{
		wedding=new MenWeddngCollectPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("men Category....");
		men.getEleMenLst(driver);
		wedding.getEleMenWeddngCollctnLnk(driver);
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
