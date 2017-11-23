package com.flyrobe.script;

import java.io.IOException;

import org.testng.annotations.Test;

import com.flyrobe.generic.Browsers;
import com.flyrobe.pom.LoginPagePO;

import junit.framework.Assert;


public class LoginPageTest extends Browsers
{
	public static LoginPagePO login; 
	

	@Test()
	public static void selectCity() throws Exception 
	{
		login = new LoginPagePO(driver);
    	login.getEleSelCityLst();
    	Assert.assertTrue(login.getEleSelectedCity().getText() + " City is successfully selected", login.getEleSelectedCity().isDisplayed());
	}
	
	@Test(priority=2)
	public void login() throws IOException, InterruptedException
	{
		login = new LoginPagePO(driver);
		login.getEleLoginBtn();
		login.getEleGoogleAcctBtn();
		login.getEleGmailTxtFld(driver);
		login.getEleGmailNxtBtn();
		login.getElePwdTxtFld(driver);
		login.getElePwdNxtBtn(driver);
		Assert.assertTrue("Succesfully logged", login.getEleMenuDropDwnArrw(driver).isDisplayed());
	}
	
	@Test(priority=3)
	public void logout() throws InterruptedException
	{
		login.getEleMenuDropDwnArrw(driver);
		login.getEleLogoutBtn();
		
	}

}