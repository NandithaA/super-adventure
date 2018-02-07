package com.superadventure;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSelect {
	
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(BrowserSelect.class.getName()); 
	
	public WebDriver initializeBrowser()
	{
		try{
			//String propfile="C:\\Projects\\super-adventure\\WebsiteTest\\src\\main\\java\\resources\\Inputdata.properties";
			Properties prop=new Properties();
			InputStream instr=this.getClass().getResourceAsStream("Inputdata.properties");
			prop.load(instr);
			//log.info("Properties are loaded from the location: "+propfile);
			String browsername=prop.getProperty("browser");
			System.out.println("Type of Browser selected:  "+browsername);
			if(browsername.equalsIgnoreCase("CHROME"))
			{
			//	System.setProperty("webdriver.chrome.driver", prop.getProperty("browserlocation"));
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				driver=new ChromeDriver(chromeOptions);
				log.debug("Chrome properties are set.");
			}
				
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		}
		catch(Exception ex)
		{
			log.error("Exception thrown in Browser class"+ex.toString());
			
		}
		return driver;
	}
}
