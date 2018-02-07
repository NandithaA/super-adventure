package com.superadventure;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BrowserSelect {
	
	LoginPage lpage;
	HomePage home;
	
	@BeforeTest
	public void setUp()
	{
		driver=initializeBrowser();
	//	driver.get("https://www.jetblue.com");
	}
	
	@BeforeMethod
	public void refreshLoginPage()
	{
		home=new HomePage(driver);
		home.login().click();
		lpage=new LoginPage(driver);
	}
	
	@Test(dataProvider="getUserData")
	public void userCredentials(String username, String password, String type)
	{
		lpage.username().sendKeys(username);
		lpage.password().sendKeys(password);
		lpage.submit().click();
		System.out.println(type);
	}
	
	@DataProvider
	public Object[][] getUserData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="nanditha.raj@gmail.com";
		data[0][1]="abcd1234";
		data[0][2]="Valid User";
		
		data[1][0]="nanditha1.raj@gmail.com";
		data[1][1]="abcd12342";
		data[1][2]="Invalid User";
		
		return data;
	}
	
	@AfterTest
	public void cleanUp()
	{
		driver.close();
	}
	
}
