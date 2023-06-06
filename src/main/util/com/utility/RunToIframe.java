package com.utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunToIframe {
	
	
	

	public static void main(String[] args) throws InterruptedException,IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/shaheenhaider/eclipse-workspace/MidtransPillow/Drivers/chromedriver");
		driver=new ChromeDriver();
		driver.get("https://demo.midtrans.com/");
		driver.findElement(By.xpath("//a[@class='btn buy']")).click();
		driver.findElement(By.xpath("//div[@class='cart-checkout']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("snap-midtrans");
		driver.quit();
		

	}

}
