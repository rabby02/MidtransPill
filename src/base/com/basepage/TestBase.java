package com.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Homepage;

public class TestBase {
	

   // public HomepageTest homePageTest;
	

	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	
	
	public static WebDriverWait ExplicitWait()
	{
	     wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	return wait;
		
	}
	
	public TestBase()
	{
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/shaheenhaider/eclipse-workspace/MidtransPillow/Configurations/config.properties");
			prop.load(ip);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void Initialization() 
	{
		
		ChromeOptions op =new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		
		//WebDriver driver = new FirefoxDriver(options);
		
		String browserName =prop.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/shaheenhaider/eclipse-workspace/MidtransPillow/Drivers/chromedriver");
			driver=new ChromeDriver(op);
			
			
		}
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	
	

}


