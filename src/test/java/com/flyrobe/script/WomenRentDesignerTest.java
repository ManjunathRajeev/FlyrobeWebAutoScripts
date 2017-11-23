package com.flyrobe.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.WomenEthnicClothPO;
import com.flyrobe.pom.WomenRentDesignerPO;

import junit.framework.Assert;

public class WomenRentDesignerTest extends Browsers
{
	WomenRentDesignerPO design;
	CommonMethodsPO women;
	
	@Test()
	public void women() throws Exception
	{
		design=new WomenRentDesignerPO(driver);
		women=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Women Category Started....");
		women.getEleWomenLst(driver);
		design.getEleWomRentDesgnrTab(driver);

		for(WebElement designRent:design.getEleRentDesgnrSubLnk())
		{	
		  System.out.println(" The sub category : " + designRent.getText() + " of Women Rent by Designers Started...");
		  designRent.click();	
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

