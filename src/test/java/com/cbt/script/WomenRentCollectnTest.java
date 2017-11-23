
package com.cbt.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cbt.generic.Browsers;
import com.cbt.generic.CommonMethodsPO;
import com.cbt.pom.WomenEthnicClothPO;
import com.cbt.pom.WomenRentCollectnPO;

import junit.framework.Assert;

public class WomenRentCollectnTest extends Browsers
{
	WomenRentCollectnPO collect;
	CommonMethodsPO women;
	
	@Test()
	public void women() throws Exception
	{
		collect=new WomenRentCollectnPO(driver);
		women=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Women Category Started....");
		women.getEleWomenLst(driver);
		collect.getEleWomRentCollctnTab(driver);

		for(WebElement collectRent:collect.getEleRentCollctnSubLnk())
		{	
		  System.out.println(" The sub category : " + collectRent.getText() + " of Women Rent by Collectiong Started...");
		  collectRent.click();	
		  Thread.sleep(3000);
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
		  driver.navigate().back();
		  Thread.sleep(4000);
	}
}
}

