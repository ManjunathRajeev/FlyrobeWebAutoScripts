package com.flyrobe.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePO 
{
	public CartPagePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cart-menu")
	private WebElement eleCartIcn;
	public WebElement getEleCartIcn()
	{
		eleCartIcn.click();
		return eleCartIcn;
	}
	
	@FindBy(xpath="//div[@class='position-relative pull-right']")
	private WebElement eleCartRentWomWearBtn;
	public WebElement getEleCartRentWomWearBtn()
	{
		eleCartRentWomWearBtn.click();
		return eleCartRentWomWearBtn;
	}
	
	@FindBy(xpath="//div[@class='position-relative pull-left']")
	private WebElement eleCartRentMenWearBtn;
	public WebElement getEleCartRentMenWearBtn()
	{
		eleCartRentMenWearBtn.click();
		return eleCartRentMenWearBtn;
	}
	
	@FindBy(xpath="//div[@class='topBottomPadding15 top-margin-20']")
	private WebElement eleEmptyCartTxt;
	public WebElement getEleEmptyCartTxt()
	{
		String emptyCart = eleEmptyCartTxt.getText();
		return eleCartRentMenWearBtn;
	}

}
