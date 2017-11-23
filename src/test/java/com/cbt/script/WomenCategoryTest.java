package com.cbt.script;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cbt.generic.Browsers;
import com.cbt.generic.CommonMethodsPO;
import com.cbt.pom.WomenCategoryPO;
import com.cbt.pom.WomenEthnicNewArivalPO;

import junit.framework.Assert;

public class WomenCategoryTest extends Browsers
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
