package com.cbt.pom;

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
import com.cbt.generic.ReusableMethods;

public class WomenCategoryPO 
{
	public WomenCategoryPO(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}	
	
		
	@FindBy(xpath="(//div[@class='hover-menu occasion-nav'])[1]")
	private WebElement eleWomenLst;
	public WebElement getEleWomenLst(WebDriver driver) throws AWTException
	{
		eleWomenLst.click();
		Robot rob = new Robot();
		rob.mouseMove(110, 64);
		return eleWomenLst;
	}
	
	@FindBy(xpath="(//a[text()='ETHNIC NEW ARRIVALS'])[3]")
	private WebElement eleWomEthnicWearLnk;
	public WebElement getEleWomEthnicWearLnk(WebDriver driver) throws AWTException, InterruptedException
	{
//		ReusableMethods.locatorWait(driver, By.xpath("//a[text()='ETHNIC WEAR']"));
		eleWomEthnicWearLnk.click();
		ReusableMethods.implictWait(driver);
		return eleWomEthnicWearLnk;
	}
	
	@FindBy(xpath="//span[@class='small-font mob-block mdl-cell--hide-phone mdl-cell--hide-tablet ng-binding']")
	private WebElement eleWomProdPageCount;
	public int getEleWomProdPageCount()
	{
		String prodCount = eleWomProdPageCount.getText();
		String totCount = prodCount.substring(8);
		int totProdCount = Integer.parseInt(totCount);
		System.out.println("After Converting to int = " + totProdCount);
		return totProdCount;
	}
	
	@FindBy(xpath="//img[@class='product-img']")
	private List<WebElement> eleWomEthnicProdImage;
	public List<WebElement> getEleWomEthnicProdImage()
	{
		return eleWomEthnicProdImage;	
	}
	
	@FindBy(xpath="//div[@class='customFitContain ng-scope']")
	private List<WebElement> eleWomEthnicProdCustom;
	public List<WebElement> getEleWomEthnicProdCustom()
	{
		return eleWomEthnicProdCustom;	
	}
	
	@FindBy(xpath="//div[@class='letter-spacing1 brand-name small-font ng-binding']")
	private List<WebElement> eleWomEthnicProdName;
	public List<WebElement> getEleWomEthnicProdName()
	{	
		return eleWomEthnicProdName;
	}
	
	@FindBy(xpath="//div[@class='letter-spacing1 productDesc times-roman italic text-muted ng-binding']")
	private List<WebElement> eleWomEthnicProdDesc;
	public List<WebElement> getEleWomEthnicProdDesc()
	{	
		return eleWomEthnicProdDesc;
	}
	
	@FindBy(xpath="//div[@ng-if='!product.is_on_sale']")
	private List<WebElement> eleWomEthnicProdRentPrice;
	public List<WebElement> getEleWomEthnicProdRentPrice()
	{	
		for(WebElement ren:eleWomEthnicProdRentPrice)
		{
		String rent = ren.getText();
		String price = rent.substring(1,5);
		System.out.println("RentPrice before converting  = " + rent + "and " + " price = " + price);
		int rentPrice = Integer.parseInt(price);
		System.out.println("RentPrice after converting  = " + rentPrice);
		}
		return eleWomEthnicBottomSizeFilter;
	}
	
	@FindBy(xpath="//div[@class='mdl-cell mdl-cell--6-col mdl-cell--2-col-phone mdl-cell--4-col-tablet text-right text-muted small-font']")
	private List<WebElement> eleWomEthnicProdPrice;
	public List<WebElement> getEleWomEthnicProdPrice()
	{	
		return eleWomEthnicProdPrice;
	}
	
	@FindBy(xpath="(//img[@class='product-img'])[last()]")
	private WebElement eleWomEthnicProdCount;
	public WebElement getEleWomEthnicProdCount(WebDriver driver) throws ClientProtocolException, IOException, InterruptedException, AWTException
	{
	  int count =0;
	  int totProd=0;
	  count = eleWomEthnicProdImage.size();
	  System.out.println("Product per page Count = " + count );
	
Loop1:	  for(int i=count;i<getEleWomProdPageCount();i++)
	   {
		 if(count!=getEleWomProdPageCount())
		 {
		  ReusableMethods.implictWait(driver);
		  System.out.println(count + " is not equal to " + getEleWomProdPageCount());
		  ReusableMethods.scrollToElement(eleWomEthnicProdCount, driver);
//		  JavascriptExecutor js =(JavascriptExecutor)driver;
//		  js.executeScript("arguments[0].scrollIntoView();", eleWomEthnicProdCount);
		  ReusableMethods.implictWait(driver);
		  totProd = eleWomEthnicProdImage.size();
		  count=totProd;
		  Thread.sleep(3000);
		  System.out.println("After Scroll ethnic wear product count in women category is = " + totProd);
		 }
		 else
		 {
		   System.out.println(count + " is  equal to " + getEleWomProdPageCount());
		   break Loop1;
		 }
		 }
		int finalProdCount = eleWomEthnicProdImage.size();
		System.out.println("Total Ethnic Wear products in Women Category is = " + finalProdCount);
		return eleWomEthnicProdCount;
	}
	
	@FindBy(xpath="//product-card")
	private List<WebElement> eleWomEthnicProdCard;
	public List<WebElement> getELeWomEthnicProdCard() throws ClientProtocolException, IOException
	{
		int invalidImg=0;
		int validImg=0;
		int customFit=0;
		int noCustomFit=0;
		
		for(int i=0;i<2;i++)
		{
		  if(eleWomEthnicProdCard.get(i).isDisplayed())
	    	{
				HttpResponse urlresp = new DefaultHttpClient().execute(new HttpGet(eleWomEthnicProdImage.get(i).getAttribute("src")));	 
				int resp_Code = urlresp.getStatusLine().getStatusCode();
					System.out.println("Validating " + i + " product started " );
					System.out.println(" ---------------------------------------------- ");
	         if(resp_Code ==200 && eleWomEthnicProdImage.get(i).getAttribute("src").contains("jpg"))
			 {
			    validImg++;
				System.out.println(" Valid image count= " + validImg);
				String prodName = eleWomEthnicProdName.get(i).getText();
		    	String prodDesc = eleWomEthnicProdDesc.get(i).getText();
		    	String prodRentPrice = eleWomEthnicProdRentPrice.get(i).getText();
		    	String prodprice = eleWomEthnicProdPrice.get(i).getText();
		    	String custom = eleWomEthnicProdCustom.get(i).getText();
		    	System.out.println("Product image URL link of " + i + " is ==> " + eleWomEthnicProdImage.get(i).getAttribute("src") + " and below are the product details");
		    	System.out.println("    ***********************************************     ");
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodName );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodDesc );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodRentPrice );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodprice );
		    	
		    	  if(eleWomEthnicProdCustom.get(i).isDisplayed())
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
				String prodName = eleWomEthnicProdName.get(i).getText();
		    	String prodDesc = eleWomEthnicProdDesc.get(i).getText();
		    	String prodRentPrice = eleWomEthnicProdRentPrice.get(i).getText();
		    	String prodprice = eleWomEthnicProdPrice.get(i).getText();
		    	String custom = eleWomEthnicProdCustom.get(i).getText();
		    	System.out.println("Product image URL link of " + i + " is ==> " + eleWomEthnicProdImage.get(i).getAttribute("src") + " and below are the product details");
		    	System.out.println("      ************************************************      ");
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodName );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodDesc );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodRentPrice );
		    	System.out.println(" Product name of " + i + " product in the list is==> " + prodprice );
		    	
		    	  if(eleWomEthnicProdCustom.get(i).isDisplayed())
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
		
		return eleWomEthnicProdCard;
  }
	
	@FindBy(xpath="//i[text()='arrow_drop_down']")
	private WebElement eleWomEthnicSortBtn;
	public WebElement getEleWomEthnicSortBtn(WebDriver driver) throws InterruptedException, AWTException
	{
		ReusableMethods.scrollToTop(driver);
		Thread.sleep(3000);
		eleWomEthnicSortBtn.click();
		return eleWomEthnicSortBtn;
	}
	
	@FindBy(xpath="(//li[text()='Popularity'])[2]")
	private WebElement eleWomEthnicSortPopular;
	public WebElement getEleWomEthnicSortPopular() throws InterruptedException
	{
		eleWomEthnicSortPopular.click();
		Thread.sleep(3000);
		return eleWomEthnicSortPopular;
	}

	@FindBy(xpath="(//li[text()='Price: Low to High'])[2]")
	private WebElement eleWomEthnicSortLowPrice;
	public WebElement getEleWomEthnicSortLowPrice() throws InterruptedException
	{
		eleWomEthnicSortLowPrice.click();
		Thread.sleep(3000);
		getEleWomEthnicProdRentPrice();
		return eleWomEthnicSortLowPrice;
	}

	@FindBy(xpath="(//li[text()='Price: High to Low'])[2]")
	private WebElement eleWomEthnicSortHighPrice;
	public WebElement getEleWomEthnicSortHighPrice() throws InterruptedException
	{
		Thread.sleep(3000);
		eleWomEthnicSortHighPrice.click();
		getEleWomEthnicProdRentPrice();
		return eleWomEthnicSortHighPrice;
	}

	@FindBy(xpath="//i[@ng-click='dateIcon()']")
	private WebElement eleWomEthnicDelverDateIcn;
	public WebElement getEleWomEthnicDelverDateIcn()
	{
		eleWomEthnicDelverDateIcn.click();
		return eleWomEthnicDelverDateIcn;
	}
	
	@FindBy(xpath="//div[@class='xdsoft_mounthpicker']")
	private WebElement eleWomEthnicCalMonth;
	public String getEleWomEthnicCalMonth()
	{
		String month = eleWomEthnicCalMonth.getText().trim();
		
		return month;
	}
	
	@FindBy(xpath="//tbody//td")
	private List<WebElement> eleWomEthnicCalDate;
	public List<WebElement> getEleWomEthnicCalDate()
	{
	  Date date = new Date();
	  SimpleDateFormat  formatter = new SimpleDateFormat("MMM dd,yyyy",Locale.ENGLISH);
	  String s = formatter.format(date);
	  System.out.println(s);
	  Calendar my = new GregorianCalendar();
	  int todayDate = my.get(Calendar.DAY_OF_MONTH)+4;
	  System.out.println("Today Date is " + todayDate);

	Loop1:	for(WebElement appDate : eleWomEthnicCalDate)
			{
			  String appDte = appDate.getText();
			  int appCalDate = Integer.parseInt(appDte);
			  if(appCalDate==todayDate)
			  {
				  String selDate = appDate.getText();
				  System.out.println(" Date is = " + selDate + " and the Month - Year is " + getEleWomEthnicCalMonth());
				  appDate.click();
				  break;
			   }
			  
			else
			{
				System.out.println("App Calendaer date " + appCalDate + " is not Clickable");
				continue Loop1;
			}
			  }
		
		return eleWomEthnicCalDate;
	 }
	
	@FindBy(xpath="//span[@class='ng-binding ng-scope']")
	private WebElement eleWomEthnicSelOption;
	public String getEleWomEthnicSelOption()
	{
		String selDate = eleWomEthnicSelOption.getText();
		return selDate;
	}
	
	@FindBy(xpath="//span[@class='ng-binding ng-scope']")
	private WebElement eleWomEthnicClearBtn;
	public WebElement getEleWomEthnicClearBtn()
	{
		return eleWomEthnicClearBtn;
	}
	
	@FindBy(xpath="//label[@ng-repeat='size in filters.top_size']")
	private List<WebElement> eleWomEthnicTopSizeFilter;
	public List<WebElement> getEleWomEthnicTopSizeFilter(WebDriver driver)
	{
		int sizeCount = eleWomEthnicTopSizeFilter.size();
		System.out.println("There are " + sizeCount + "sizes filter available for the women product");
		
		for(WebElement size:eleWomEthnicTopSizeFilter)
		{
		try
		{
		  if(size.isSelected()==false)
		  {
			  size.click();
			  ReusableMethods.implictWait(driver);
			  System.out.println(" Size " + size.getText() + "is selected");
			  getEleWomProdPageCount();
			  getEleWomEthnicProdCount(driver);
			  size.click();
			  ReusableMethods.implictWait(driver);
		  }
		} 
		catch(Exception e)
		{
			System.out.println("Error is checkbox");
		}	  
	}
		return eleWomEthnicTopSizeFilter;
	}		

	@FindBy(xpath="//div[@class='slide-content display-block filter-part mob-categories']//label")
	private List<WebElement> eleWomEthnicCategoryFilter;
	public List<WebElement> getEleWomEthnicCategoryFilter(WebDriver driver)
	{
		int categoryCount = eleWomEthnicCategoryFilter.size();
		System.out.println("There are " + categoryCount + "sizes filter available for the women product");
	
	for(WebElement category:eleWomEthnicCategoryFilter)
	{
	try
	{
	  if(category.isSelected()==false)
	  {
		  category.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + category.getText() + "is selected");
		  getEleWomProdPageCount();
		  getEleWomEthnicProdCount(driver);
		  category.click();
		  ReusableMethods.implictWait(driver);
	  }
	} 
	catch(Exception e)
	{
		System.out.println("Error is checkbox");
	}	  
}
	return eleWomEthnicCategoryFilter;
}	
	
	@FindBy(xpath="//i[text()='add']")
	private WebElement eleWomEthnicAddIcn;
	public WebElement getEleWomEthnicAddIcn()
	{
		
		return eleWomEthnicAddIcn;
	}
	
	@FindBy(xpath="//div[@data-filter='occasion']//label")
	private List<WebElement> eleWomEthnicOccasionFilter;
	public List<WebElement> getEleWomEthnicOcassionFilter(WebDriver driver)
	{
		if(eleWomEthnicAddIcn.isDisplayed())
		{
			eleWomEthnicAddIcn.click();
		}
		else
		{
		int occasionCount = eleWomEthnicOccasionFilter.size();
		System.out.println("There are " + occasionCount + "sizes filter available for the women product");
	
	for(WebElement occasion:eleWomEthnicOccasionFilter)
	{
	try
	{
	  if(occasion.isSelected()==false)
	  {
		  occasion.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + occasion.getText() + "is selected");
		  getEleWomProdPageCount();
		  getEleWomEthnicProdCount(driver);
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
	return eleWomEthnicOccasionFilter;
}	

	@FindBy(xpath="//div[@class='slide-content show-none filter-part mob-prices']//label")
	private List<WebElement> eleWomEthnicPriceFilter;
	public List<WebElement> getEleWomEthnicPriceFilter(WebDriver driver)
	{
		if(eleWomEthnicAddIcn.isDisplayed())
		{
			eleWomEthnicAddIcn.click();
		}
		else
		{
		int occasionCount = eleWomEthnicPriceFilter.size();
		System.out.println("There are " + occasionCount + "sizes filter available for the women product");
	
	for(WebElement occasion:eleWomEthnicPriceFilter)
	{
	try
	{
	  if(occasion.isSelected()==false)
	  {
		  occasion.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + occasion.getText() + "is selected");
		  getEleWomProdPageCount();
		  getEleWomEthnicProdCount(driver);
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
	return eleWomEthnicPriceFilter;
}	

	@FindBy(xpath="//div[@class='brand-filter-section']//label")
	private List<WebElement> eleWomEthnicBrandFilter;
	public List<WebElement> getEleWomEthnicBrandFilter(WebDriver driver)
	{
		if(eleWomEthnicAddIcn.isDisplayed())
		{
			eleWomEthnicAddIcn.click();
		}
		else
		{
		int occasionCount = eleWomEthnicBrandFilter.size();
		System.out.println("There are " + occasionCount + "sizes filter available for the women product");
	
	for(WebElement brand:eleWomEthnicBrandFilter)
	{
	try
	{
	  if(brand.isSelected()==false)
	  {
		  brand.click();
		  ReusableMethods.implictWait(driver);
		  System.out.println(" Category " + brand.getText() + "is selected");
		  getEleWomProdPageCount();
		  getEleWomEthnicProdCount(driver);
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
	return eleWomEthnicBrandFilter;
}	
	
	@FindBy(xpath="//label[@ng-repeat='b_size in filters.bottom_size']")
	private List<WebElement> eleWomEthnicBottomSizeFilter;
	public List<WebElement> getEleWomEthnicBottomSizeFilter(WebDriver driver)
	{
		int sizeCount = eleWomEthnicBottomSizeFilter.size();
		System.out.println("There are " + sizeCount + "sizes filter available for the women product");
		
		for(WebElement size:eleWomEthnicBottomSizeFilter)
		{
		try
		{
		  if(size.isSelected()==false)
		  {
			  size.click();
			  ReusableMethods.implictWait(driver);
			  System.out.println(" Size " + size.getText() + "is selected");
			  getEleWomProdPageCount();
			  getEleWomEthnicProdCount(driver);
			  size.click();
			  ReusableMethods.implictWait(driver);
		  }
		} 
		catch(Exception e)
		{
			System.out.println("Error is checkbox");
		}	  
	}
		return eleWomEthnicBottomSizeFilter;
	}		

}

	
	