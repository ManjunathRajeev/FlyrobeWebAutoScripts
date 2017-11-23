package com.flyrobe.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WishlistPagePO 
{
	public WishlistPagePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
