package com.superadventure;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BrowserSelect {
	
	HomePage home;
	@BeforeTest
	public void launchBrowser ()
	{
		driver=initializeBrowser();
	}
	
	@BeforeMethod
	public void loadWebPage()
	{
	//driver.get("https://www.jetblue.com");
	home=new HomePage(driver);
	//rest -status code	
	
	}
	
	@Test
	public void visibilityOfNavigationBarRight()
	{
		
		Assert.assertTrue(home.navigationBarRight().isDisplayed(),"Navigation Bar is not displayed");
	}
	
	@Test
	public void clickOnLogin() 
	{
		home.login().click();
	}
	
	
	

	@AfterTest
	public void closeBrowser()
	{
		if (driver!=null)
		{
			driver.close();
		}
	}
}
