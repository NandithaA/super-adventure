package com.superadventure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By username=By.id("username");
	By password=By.id("password");
	By submit=By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		System.out.println(driver.toString());
	}
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
	}

}
