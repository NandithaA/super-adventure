package com.superadventure;

import org.openqa.selenium.*;

public class HomePage {
	
	public WebDriver driver;
	
	By login=By.cssSelector("a[class='sign-in jb-primary-link']");
	By navigationbar_right=By.xpath("//div[@class='main-nav']");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		System.out.println(driver.toString());
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	public WebElement navigationBarRight()
	{
		return driver.findElement(navigationbar_right);
	}

}
