package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.basepage.TestBase;

public class summaryPage extends TestBase {
	
	
	public summaryPage()
	{
		
		PageFactory.initElements( driver,this);
	}
	
	public void SummaryPageDisplayed()
	{
		
		//driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
		driver.switchTo().frame("snap-midtrans");
	}

}
