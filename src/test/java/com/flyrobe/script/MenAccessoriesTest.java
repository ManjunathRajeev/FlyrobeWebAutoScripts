package com.flyrobe.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.generic.CommonMethodsPO;
import com.flyrobe.pom.MenAccessoriesPO;

import junit.framework.Assert;

public class MenAccessoriesTest extends Browsers
{
	MenAccessoriesPO accessory;
	CommonMethodsPO men;
	
	@Test()
	public void menAccessories() throws Exception
	{
		accessory=new MenAccessoriesPO(driver);
		men=new CommonMethodsPO(driver);
		LoginPageTest.selectCity();
		System.out.println("Testing Men Accessories Category Started....");
		men.getEleMenLst(driver);
		accessory.getEleMenAccessoryTab(driver);
		accessory.getEleMenAccesrySubLnk();
		for(WebElement accss:accessory.getEleMenAccesrySubLnk())
		{
		
			System.out.println(" The sub category : " + accss.getText() + " of Men Accessories Started...");
			accss.click();	
		
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
