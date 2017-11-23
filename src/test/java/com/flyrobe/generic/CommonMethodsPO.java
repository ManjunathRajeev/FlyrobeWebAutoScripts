package com.flyrobe.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flyrobe.generic.ReusableMethods;

import junit.framework.Assert;

public class CommonMethodsPO 
{
	public CommonMethodsPO(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}	
	
		
	@FindBy(xpath="(//div[@class='hover-menu occasion-nav'])[1]")
	private WebElement eleWomenLst;
	public WebElement getEleWomenLst(WebDriver driver) throws AWTException
	{
		eleWomenLst.click();
		System.out.println("WoMen Category Started...");
		Robot rob = new Robot();
		rob.mouseMove(110, 64);
		return eleWomenLst;
	}

	@FindBy(xpath="(//div[@class='hover-menu occasion-nav'])[2]")
	private WebElement eleMenLst;
	public WebElement getEleMenLst(WebDriver driver) throws AWTException
	{
		eleMenLst.click();
		System.out.println("Men Category Started...");
		Robot rob = new Robot();
		rob.mouseMove(110, 64);
		return eleMenLst;
	}
	
	@FindBy(xpath="//span[@class='small-font mob-block mdl-cell--hide-phone mdl-cell--hide-tablet ng-binding']")
	private WebElement eleProdPageSize;
	public int getEleProdPageSize()
	{
		String prodCount = eleProdPageSize.getText();
		String totCount = prodCount.substring(8);
		int totProdCount = Integer.parseInt(totCount);
		System.out.println("After Converting to int = " + totProdCount);
		return totProdCount;
	}
	
	@FindBy(xpath="//img[@class='product-img']")
	private List<WebElement> eleProdImage;
	public List<WebElement> getEleProdImage()
	{
		return eleProdImage;	
	}
	
	@FindBy(xpath="//div[@class='customFitContain ng-scope']")
	private List<WebElement> eleProdCustomTag;
	public List<WebElement> getEleProdCustomTag()
	{
		return eleProdCustomTag;	
	}
	
	@FindBy(xpath="//div[@class='letter-spacing1 brand-name small-font ng-binding']")
	private List<WebElement> eleProdName;
	public List<WebElement> getEleProdName()
	{	
		return eleProdName;
	}
	
	@FindBy(xpath="//div[@class='letter-spacing1 productDesc times-roman italic text-muted ng-binding']")
	private List<WebElement> eleProdDesc;
	public List<WebElement> getEleProdDesc()
	{	
		return eleProdDesc;
	}
	
	@FindBy(xpath="//div[@ng-if='!product.is_on_sale']")
	private List<WebElement> eleProdRentPrice;
	public List<WebElement> getEleProdRentPrice()
	{	
		for(WebElement ren:eleProdRentPrice)
		{
		String rent = ren.getText();
		String price = rent.substring(1,5);
		System.out.println("RentPrice details of the dress " + eleProdName.iterator() + " is = " +  rent + "and " + " price = " + price);
//		int rentPrice = Integer.parseInt(price);
//		System.out.println("RentPrice after converting  = " + rentPrice);
		}
		return eleProdRentPrice;
	}
	
	@FindBy(xpath="//div[@class='mdl-cell mdl-cell--6-col mdl-cell--2-col-phone mdl-cell--4-col-tablet text-right text-muted small-font']")
	private List<WebElement> eleProdPrice;
	public List<WebElement> getEleProdPrice()
	{	
		return eleProdPrice;
	}
	
	@FindBy(xpath="(//img[@class='product-img'])[last()]")
	private WebElement eleProdCount;
	public WebElement getEleProdCount(WebDriver driver) throws ClientProtocolException, IOException, InterruptedException, AWTException
	{
	  int count =0;
	  int totProd=0;
	  count = eleProdImage.size();
	  System.out.println("Product per page Count = " + count );
	
Loop1:	  for(int i=count;i<getEleProdPageSize();i++)
	   {
		 if(count!=getEleProdPageSize())
		 {
		  ReusableMethods.implictWait(driver);
		  System.out.println(count + " is not equal to " + getEleProdPageSize());
		  ReusableMethods.scrollToElement(eleProdCount, driver);
		  ReusableMethods.implictWait(driver);
		  totProd = eleProdImage.size();
		  count=totProd;
		  Thread.sleep(3000);
		  System.out.println("After Scroll ethnic wear product count in women category is = " + totProd);
		 }
		 else
		 {
		   System.out.println(count + " is  equal to " + getEleProdPageSize());
		   break Loop1;
		 }
		 }
		int finalProdCount = eleProdImage.size();
		System.out.println("Total Ethnic Wear products in Women Category is = " + finalProdCount);
		return eleProdCount;
	}
	
	@FindBy(xpath="//product-card")
	private List<WebElement> eleProdCard;
	public List<WebElement> getELeProdCard() throws ClientProtocolException, IOException
	{
		int invalidImg=0;
		int validImg=0;
		int customFit=0;
		int noCustomFit=0;
		
		for(int i=0;i<2;i++)
		{
		  if(eleProdCard.get(i).isDisplayed())
	    	{
				HttpResponse urlresp = new DefaultHttpClient().execute(new HttpGet(eleProdImage.get(i).getAttribute("src")));	 
				int resp_Code = urlresp.getStatusLine().getStatusCode();
					System.out.println("Validating " + i + " product started " );
					System.out.println(" ---------------------------------------------- ");
	         if(resp_Code ==200 && eleProdImage.get(i).getAttribute("src").contains("jpg"))
			 {
			    validImg++;
				System.out.println(" Valid image count= " + validImg);
				String prodName = eleProdName.get(i).getText();
		    	String prodDesc = eleProdDesc.get(i).getText();
		    	String prodRentPrice = eleProdRentPrice.get(i).getText();
		    	String prodprice = eleProdPrice.get(i).getText();
		    	String custom = eleProdCustomTag.get(i).getText();
		    	System.out.println("Product image URL link of " + i + " is ==> " + eleProdImage.get(i).getAttribute("src") + " and below are the product details");
		    	System.out.println("    ***********************************************     ");
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodName );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodDesc );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodRentPrice );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodprice );
		    	
		    	  if(eleProdCustomTag.get(i).isDisplayed())
		    	   {
		    		 customFit++;
		    		 System.out.println( custom + " tag is available for the product " + prodName);
		    	   }
		    	   else
		    	   {
		    		 noCustomFit++;
		    		 System.out.println( custom + " tag is not available for the product " + prodName);
		    	   }
				}
			  else
			  {
				invalidImg++;
				System.out.println(" Invalid image count= " + invalidImg);
				String prodName = eleProdName.get(i).getText();
		    	String prodDesc = eleProdDesc.get(i).getText();
		    	String prodRentPrice = eleProdRentPrice.get(i).getText();
		    	String prodprice = eleProdPrice.get(i).getText();
		    	String custom = eleProdCustomTag.get(i).getText();
		    	System.out.println("Product image URL link of " + i + " is ==> " + eleProdImage.get(i).getAttribute("src") + " and below are the product details");
		    	System.out.println("      ************************************************      ");
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodName );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodDesc );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodRentPrice );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodprice );
		    	
		    	  if(eleProdCustomTag.get(i).isDisplayed())
		    	   {
		    		 customFit++;
		    		 System.out.println( custom + " tag is available for the product " + prodName);
		    	   }
		    	   else
		    	   {
		    		 noCustomFit++;
		    		 System.out.println( custom + " tag is not available for the product " + prodName);
				}
			}
		}
			
	}
		System.out.println();
		System.out.println("Complete Women's New Arraival Ethnic Wear Details are...... ");
		System.out.println("******************************************************");
		System.out.println(" Total Invalid image count in Women Ethnic Wear= " + invalidImg);
		System.out.println(" Total valid image count in Women Ethnic Wear = " + validImg);
		System.out.println(" Total custom fit tag count in Women Ethnic Wear = " + customFit++);
		System.out.println(" Total nocustom fit tag count in Women Ethnic Wear = " + noCustomFit++);
		System.out.println("******************************************************");
		
		return eleProdCard;
  }
	
	@FindBy(xpath="//i[text()='arrow_drop_down']")
	private WebElement eleSortByBtn;
	public WebElement getEleSortByBtn(WebDriver driver) throws InterruptedException, AWTException
	{
		ReusableMethods.scrollToTop(driver);
		Thread.sleep(3000);
		eleSortByBtn.click();
		return eleSortByBtn;
	}
	
	@FindBy(xpath="(//li[@ng-click='sortBy(3)'])[2]")
//	(//li[text()='Popularity'])[2]
	private WebElement eleSortByPopular;
	public WebElement getEleSortByPopular() throws InterruptedException
	{
		eleSortByPopular.click();
		System.out.println("Sorting Product started by Popularity");
		Thread.sleep(3000);
		return eleSortByPopular;
	}

	@FindBy(xpath="(//li[@ng-click='sortBy(1)'])[2]")
//	(//li[text()='Price: Low to High'])[2]
	private WebElement eleSortByLowPrice;
	public WebElement getEleSortByLowPrice() throws InterruptedException
	{
		eleSortByLowPrice.click();
		System.out.println("Sorting Product started by Low to High");
		Thread.sleep(3000);
		getEleProdRentPrice();
		Thread.sleep(3000);
		return eleSortByLowPrice;
	}

	@FindBy(xpath="(//li[@ng-click='sortBy(2)'])[2]")
//	(//li[text()='Price: High to Low'])[2]
	private WebElement eleSortByHighPrice;
	public WebElement getEleSortByHighPrice() throws InterruptedException
	{
		eleSortByHighPrice.click();
		System.out.println("Sorting of Product started by High to Low");
		Thread.sleep(3000);
		getEleProdRentPrice();
		Thread.sleep(3000);
		return eleSortByHighPrice;
	}
	
	@FindBy(xpath="//button[@ng-click='setToolkit()']")
	//button[@ng-click='setToolkit()']
	private WebElement eleOkayGotItBtn;
	public WebElement getEleOkayGotItBtn()
	{
		eleOkayGotItBtn.click();
		return eleOkayGotItBtn;
	}
	

	@FindBy(xpath="//input[@type='text']")
	////i[@ng-click='dateIcon()'] 
	private WebElement eleProdDelverDateIcn;
	public WebElement getEleProdDelverDateIcn()
	{
		eleProdDelverDateIcn.click();
		return eleProdDelverDateIcn;
	}
	
	@FindBy(xpath="//div[@class='xdsoft_mounthpicker']")
	private WebElement eleCalendarMonth;
	public String getEleCalendarMonth()
	{
		String month = eleCalendarMonth.getText().trim();
		return month;
	}
	
	@FindBy(xpath="//tbody//td")
	private List<WebElement> eleCalendarDate;
	public List<WebElement> getEleCalendarDate()
	{
	  Date date = new Date();
	  SimpleDateFormat  formatter = new SimpleDateFormat("MMM dd,yyyy",Locale.ENGLISH);
	  String s = formatter.format(date);
	  System.out.println(s);
	  Calendar my = new GregorianCalendar();
	  int todayDate = my.get(Calendar.DAY_OF_MONTH)+4;
	  System.out.println("Today Date is " + todayDate);

	Loop1:	for(WebElement appDate : eleCalendarDate)
			{
			  String appDte = appDate.getText();
			  int appCalDate = Integer.parseInt(appDte);
			  if(appCalDate==todayDate)
			  {
				  String selDate = appDate.getText();
				  System.out.println(" Date is = " + selDate + " and the Month - Year is " + getEleCalendarMonth());
				  appDate.click();
				  break;
			   }
			  
			else
			{
				System.out.println("App Calendaer date " + appCalDate + " is not Clickable");
				continue Loop1;
			}
			  }
		
		return eleCalendarDate;
	 }
	
	@FindBy(xpath="//span[@class='ng-binding ng-scope']")
	private WebElement eleSelectedOption;
	public String getSelectedOption()
	{
		String selDate = eleSelectedOption.getText();
		return selDate;
	}
	
	@FindBy(xpath="//span[@class='ng-binding ng-scope']")
	private WebElement eleClearBtn;
	public WebElement getEleClearBtn()
	{
		return eleClearBtn;
	}
	
	@FindBy(xpath="//label[@ng-repeat='size in filters.top_size']")
	private List<WebElement> eleTopSizeFilter;
	public List<WebElement> getEleTopSizeFilter(WebDriver driver)
	{
		int sizeCount = eleTopSizeFilter.size();
		System.out.println("There are " + sizeCount + "sizes filter available for the women product");
		
		for(WebElement size:eleTopSizeFilter)
		{
		try
		{
		  if(size.isSelected()==false)
		  {
			  size.click();
			  ReusableMethods.implictWait(driver);
			  System.out.println(" Size " + size.getText() + "is selected");
			  getEleProdPageSize();
			  getEleProdCount(driver);
			  size.click();
			  ReusableMethods.implictWait(driver);
		  }
		} 
		catch(Exception e)
		{
			System.out.println("Error is checkbox");
		}	  
	}
		return eleTopSizeFilter;
	}		

	@FindBy(xpath="//div[@class='slide-content display-block filter-part mob-categories']//label")
	private List<WebElement> eleCategoryFilter;
	public List<WebElement> getEleCategoryFilter(WebDriver driver)
	{
		int categoryCount = eleCategoryFilter.size();
		System.out.println("There are " + categoryCount + "sizes filter available for the women product");
	
	for(WebElement category:eleCategoryFilter)
	{
	try
	{
	  if(category.isSelected()==false)
	  {
		  category.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + category.getText() + "is selected");
		  getEleProdPageSize();
		  getEleProdCount(driver);
		  category.click();
		  ReusableMethods.implictWait(driver);
	  }
	} 
	catch(Exception e)
	{
		System.out.println("Error is checkbox");
	}	  
}
	return eleCategoryFilter;
}	
	
	@FindBy(xpath="//i[text()='add']")
	private WebElement eleFiltersAddIcn;
	public WebElement getEleFiltersAddIcn()
	{
		return eleFiltersAddIcn;
	}
	
	@FindBy(xpath="//div[@data-filter='occasion']//label")
	private List<WebElement> eleOccasionFilter;
	public List<WebElement> getEleOcassionFilter(WebDriver driver)
	{
		if(eleFiltersAddIcn.isDisplayed())
		{
			eleFiltersAddIcn.click();
		}
		else
		{
		int occasionCount = eleOccasionFilter.size();
		System.out.println("There are " + occasionCount + "sizes filter available for the women product");
	
	for(WebElement occasion:eleOccasionFilter)
	{
	try
	{
	  if(occasion.isSelected()==false)
	  {
		  occasion.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + occasion.getText() + "is selected");
		  getEleProdPageSize();
		  getEleProdCount(driver);
		  occasion.click();
		  ReusableMethods.implictWait(driver);  
	  }
	} 
	catch(Exception e)
	{
		System.out.println("Error is checkbox");
	}	 
	}
	}
	return eleOccasionFilter;
}	

	@FindBy(xpath="//div[@class='slide-content show-none filter-part mob-prices']//label")
	private List<WebElement> elePriceFilter;
	public List<WebElement> getElePriceFilter(WebDriver driver)
	{
		if(eleFiltersAddIcn.isDisplayed())
		{
			eleFiltersAddIcn.click();
		}
		else
		{
		int occasionCount = elePriceFilter.size();
		System.out.println("There are " + occasionCount + "sizes filter available for the women product");
	
	for(WebElement occasion:elePriceFilter)
	{
	try
	{
	  if(occasion.isSelected()==false)
	  {
		  occasion.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + occasion.getText() + "is selected");
		  getEleProdPageSize();
		  getEleProdCount(driver);
		  occasion.click();
		  ReusableMethods.implictWait(driver);
	  }
	} 
	catch(Exception e)
	{
		System.out.println("Error is checkbox");
	}	 
	}
	}
	return elePriceFilter;
}	

	@FindBy(xpath="//div[@class='brand-filter-section']//label")
	private List<WebElement> eleBrandFilter;
	public List<WebElement> getEleBrandFilter(WebDriver driver)
	{
		if(eleFiltersAddIcn.isDisplayed())
		{
			eleFiltersAddIcn.click();
		}
		else
		{
		int occasionCount = eleBrandFilter.size();
		System.out.println("There are " + occasionCount + "sizes filter available for the women product");
	
	for(WebElement brand:eleBrandFilter)
	{
	try
	{
	  if(brand.isSelected()==false)
	  {
		  brand.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + brand.getText() + "is selected");
		  getEleProdPageSize();
		  getEleProdCount(driver);
		  brand.click();
		  ReusableMethods.implictWait(driver);
	  }
	} 
	catch(Exception e)
	{
		System.out.println("Error is checkbox");
	}	 
	}
	}
	return eleBrandFilter;
}	
	
	@FindBy(xpath="//label[@ng-repeat='b_size in filters.bottom_size']")
	private List<WebElement> eleBottomSizeFilter;
	public List<WebElement> getEleBottomSizeFilter(WebDriver driver)
	{
		int sizeCount = eleBottomSizeFilter.size();
		System.out.println("There are " + sizeCount + "sizes filter available for the women product");
		
		for(WebElement size:eleBottomSizeFilter)
		{
		try
		{
		  if(size.isSelected()==false)
		  {
			  size.click();
			  ReusableMethods.implictWait(driver);
			  System.out.println(" Size " + size.getText() + "is selected");
			  getEleProdPageSize();
			  getEleProdCount(driver);
			  size.click();
			  ReusableMethods.implictWait(driver);
		  }
		} 
		catch(Exception e)
		{
			System.out.println("Error is checkbox");
		}	  
	}
		return eleBottomSizeFilter;
	}		

}

	
	