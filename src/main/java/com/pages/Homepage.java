package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.basepage.TestBase;
import com.util.utility;

public class Homepage extends TestBase {
	

	//public  utility ut;
	
	
	public Homepage()
	{
		
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//div[@class='title']")
	public WebElement MidTransPillow;
	@FindBy(xpath="//span[contains(text(),'20,000')]")
	public WebElement priceTag;
	@FindBy(xpath="//div[@class='cart-content buying']")
	public WebElement CartPopWindow;
	@FindBy(xpath="//a[@class='btn buy']")
	public WebElement ClickBuyNow;
	@FindBy(xpath="//input[@value='Budi']")
	public WebElement verifyname;
	@FindBy(xpath="//*[text()='20,000']")
	public WebElement total;
	@FindBy(xpath="//input[@value='budi@utomo.com']")
	public WebElement MailVerify;
	@FindBy(xpath="//input[@value='081808466410']")
	public WebElement ContactVerify;
	@FindBy(xpath="//input[@value='Jakarta']")
	public WebElement CountryVerification;
	@FindBy(xpath="//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")
	public WebElement Addresverify;
	@FindBy(css=".cart-checkout")
	public WebElement ClickOnChecout;
	
	@FindBy(xpath="//div[@clas='header-order-id']")
	public WebElement OrderId;
	@FindBy(xpath="//iframe[@id='snap-midtrans']")
	public WebElement iframe1;
	@FindBy(xpath="//div[@class='order-summary-section']")
	public WebElement clickOnpopUp;
	@FindBy(xpath="//img[@alt='expand']")
	public WebElement ClickOnOrderSummary;
	@FindBy(xpath="//span[normalize-space()='Midtrans Pillow']")
	public WebElement ProductName;
	@FindBy(xpath="//td[@class='order-summary-content float-right']")
	public WebElement ProductPrice;
	@FindBy(xpath = "//div[@class='list-title text-actionable-bold']")
	public List<WebElement> PaymentOptions;
	@FindBy(xpath="//a[@href='#/credit-card']")
	public WebElement CreditCardPayments;
	@FindBy(xpath="//span[@class='title-text text-actionable-bold']")

	public WebElement CardDetailsScreen;
	@FindBy(xpath="//input[@autocomplete='cc-number']")
	public WebElement CardNumber;
	@FindBy(xpath="//div[@class='header-amount']")
	public WebElement VerifyPriceOnCardScreen;
	@FindBy(id="card-expiry")
	public WebElement ExpireDate;
	@FindBy(id="card-cvv")
	public WebElement CardCvv;
	@FindBy(xpath="//button[@type='button']")
	public WebElement PayNowBtn;
	@FindBy(xpath="//iframe[@class='iframe-3ds']")
	public WebElement iframe2;
	@FindBy(id="merchant_name")
	public WebElement merchantName;
	@FindBy(id="txn_amount")
	public WebElement Amount;
	@FindBy(id="card_number")
	public WebElement CardNum;
	@FindBy(id="otp")
	public WebElement otp;
	@FindBy(xpath="//button[@class='btn btn-sm btn-success']")
	public WebElement ClickOnOkBtn;
	@FindBy(xpath="//span[normalize-space()='Thank you for your purchase.']")
	public WebElement VerifyPurchaseDone;
	@FindBy(xpath="//span[normalize-space()='Sorry, something went wrong.']")
	public WebElement PurchaseNotSuccess;
	@FindBy(xpath="//label[@for='466']")
	public WebElement Promo;
	//@FindBy(xpath="//span[normalize-space()='Thank you for your purchase.']")
	
	
	//Tc-01
	public void Verify_Product_Added_Into_CartWithCost()
	{
		 ExplicitWait().until(ExpectedConditions.visibilityOf(MidTransPillow)).isDisplayed();
		 ExplicitWait().until(ExpectedConditions.visibilityOf(priceTag)).isDisplayed();
		 Assert.assertEquals(MidTransPillow.getText(), prop.getProperty("productName"));
		 Assert.assertEquals(priceTag.getText(), prop.getProperty("ProductPrice"));
		
	}
	//Tc-02
	public void Verify_clickingOn_BuyNow_button_redirect_popUp()
	{
		
		ExplicitWait().until(ExpectedConditions.visibilityOf(ClickBuyNow)).click();
	    Assert.assertTrue(ExplicitWait().until(ExpectedConditions.visibilityOf(CartPopWindow)).isDisplayed());
		
	}
	//Tc-03
	
	public void VerifyName_email_phone_address_zipcode_Are_Displayed()
	{
		ExplicitWait().until(ExpectedConditions.visibilityOf(verifyname)).isDisplayed();
		ExplicitWait().until(ExpectedConditions.visibilityOf(MailVerify)).isDisplayed();
		ExplicitWait().until(ExpectedConditions.visibilityOf(ContactVerify)).isDisplayed();
		ExplicitWait().until(ExpectedConditions.visibilityOf(Addresverify)).isDisplayed();
		ExplicitWait().until(ExpectedConditions.visibilityOf(CountryVerification)).isDisplayed();
		ExplicitWait().until(ExpectedConditions.visibilityOf(total)).isDisplayed();
	}
	
	//Tc-04
	
	public void ClearAndSendKeys(WebElement element,String text)
	{
		
		ExplicitWait().until(ExpectedConditions.visibilityOf(element)).clear();
		ExplicitWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
		
		
	}
	public void VerifyName_email_phone_address_zipcode_Are_Editable()
	{
		
		ClearAndSendKeys(verifyname,prop.getProperty("name"));
		ClearAndSendKeys(MailVerify,prop.getProperty("email"));
		ClearAndSendKeys(ContactVerify,prop.getProperty("phone"));
		ClearAndSendKeys(CountryVerification,prop.getProperty("city"));
		ClearAndSendKeys(Addresverify,prop.getProperty("Address"));
		
	}
	
	
	public void Checkout_button_click()
	{
		
		ExplicitWait().until(ExpectedConditions.visibilityOf(ClickOnChecout)).click();
	//	driver.switchTo().frame(iframe1);
        //explicitWait().until(ExpectedConditions.visibilityOf(OrderId));
	//ExplicitWait().until(ExpectedConditions.visibilityOf(OrderId));
	//ExplicitWait().until(ExpectedConditions.elementToBeClickable(ClickOnOrderSummary));
	//Assert.assertTrue(ExplicitWait().until(ExpectedConditions.visibilityOf(OrderId)).isDisplayed(),"Yes");
			
		//driver.switchTo().frame(iframe1);
		
		
		
		//ExplicitWait().until(ExpectedConditions.visibilityOf(ClickOnOrderSummary)).click();
	}
	//Tc=05
	public void OrderSummary_value_verify() throws InterruptedException  
	{
		
		//ExplicitWait().until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("snap-midtrans")))));
		//driver.switchTo().frame(iframe1);
		//Thread.sleep(2000);
	     driver.switchTo().frame(iframe1);
	   //  Thread.sleep(5000);
	        //explicitWait().until(ExpectedConditions.visibilityOf(OrderId));
		//ExplicitWait().until(ExpectedConditions.visibilityOf(OrderId));
		//ExplicitWait().until(ExpectedConditions.elementToBeClickable(ClickOnOrderSummary));
		Assert.assertTrue(ExplicitWait().until(ExpectedConditions.visibilityOf(OrderId)).isDisplayed(),"Yes");
		
				
				
		
		
		
	}
	//Tc06
	
	public void Verifyall_the_product_details_on_order_summery_popup()
	{
		
		 driver.switchTo().frame(iframe1);
		 ExplicitWait().until(ExpectedConditions.elementToBeClickable(ClickOnOrderSummary));
		 Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(ProductName)).getText(),prop.getProperty("productName"));
		 Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(ProductPrice)).getText(),prop.getProperty("ProductPrice"));
		 
	}
	//Tc-07
	public void verify_clicking_on_continue_button_on_order_summery()
	{
		
		driver.switchTo().frame(iframe1);
		ExplicitWait().until(ExpectedConditions.elementToBeClickable(ClickOnOrderSummary)).click();
		Assert.assertTrue(ExplicitWait().until(ExpectedConditions.visibilityOf(OrderId)).isDisplayed());
		
		
	}
	//Tc-08
	
	public void verify_all_the_payment_options()
	{
		driver.switchTo().frame(iframe1);
		String[] Exp = {"GoPay","Bank transfer", "Credit/debit card",  "ShopeePay", "QRIS", "Alfa Group","Indomaret","Akulaku PayLater","Kredivo", "UOB EZ Pay","BCA KlikPay", "OCTO Clicks","BRImo", "Danamon Online Banking","klikBCA"};
		for(int i=0;i<PaymentOptions.size();i++)
		{
			
			Assert.assertTrue(Exp[i].contains(PaymentOptions.get(i).getText()),"Option Matched");
		}
		
	}
	
	//Tc-09
	
	public void ClickOnCreditOrDebit()
	{
		driver.switchTo().frame(iframe1);
		ExplicitWait().until(ExpectedConditions.elementToBeClickable(CreditCardPayments)).click();
		Assert.assertTrue(ExplicitWait().until(ExpectedConditions.visibilityOf(CardDetailsScreen)).isDisplayed());
		
		
		
		
	}
	//Tc-10
	public void VerifyOrderAmount_onCardScreen()
	{
		
		driver.switchTo().frame(iframe1);
		Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(VerifyPriceOnCardScreen)).getText(), prop.getProperty("ProductPrice"));
		
		
		
		
	}
	//Tc-11
	public void EnterCreditCardDetails()
	{
		driver.switchTo().frame(iframe1);
		ExplicitWait().until(ExpectedConditions.visibilityOf(CardNumber)).sendKeys(prop.getProperty("card"));
		ExplicitWait().until(ExpectedConditions.visibilityOf(CardCvv)).sendKeys(prop.getProperty("CVV"));
		ExplicitWait().until(ExpectedConditions.visibilityOf(ExpireDate)).sendKeys(prop.getProperty("ExpiryDate"));
		ExplicitWait().until(ExpectedConditions.elementToBeClickable(Promo)).click();
		boolean bool=ExplicitWait().until(ExpectedConditions.visibilityOf(Promo)).isEnabled();
		
		if(bool==true)
		{
			
			
			Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(VerifyPriceOnCardScreen)).getText(), prop.getProperty("Amount_promo"));
		}
		
		
		
		
		
		ExplicitWait().until(ExpectedConditions.elementToBeClickable(PayNowBtn)).click();
		
		
		
		
		
	}
	
	//Tc-12
	
	public void ClickOnPayNpwAn_Redirect_to_paymentscreen() throws InterruptedException
	{
		
		ExplicitWait().until(ExpectedConditions.elementToBeClickable(PayNowBtn)).click();
		Thread.sleep(2000);
		ExplicitWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe2));
		Thread.sleep(5000);
		Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(merchantName)).getText(), prop.getProperty("merchant_name"));
		Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(Amount)).getText(), prop.getProperty("Amount"));
		Assert.assertEquals(ExplicitWait().until(ExpectedConditions.visibilityOf(CardNum)).getText(), prop.getProperty("cardNumber"));
		//ExplicitWait().until(ExpectedConditions.visibilityOf(otp)).sendKeys(prop.getProperty("password"));
		//ExplicitWait().until(ExpectedConditions.visibilityOf(ClickOnOkBtn)).click();
		
	
		
		
		
		
		
			
		
	}
	
	//tc-13
	public void verifyOkButton_with_valid_otp() throws InterruptedException
	{
		ExplicitWait().until(ExpectedConditions.elementToBeClickable(PayNowBtn)).click();
		Thread.sleep(2000);
		ExplicitWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe2));
		Thread.sleep(5000);
		ExplicitWait().until(ExpectedConditions.visibilityOf(otp)).sendKeys(prop.getProperty("password"));
		ExplicitWait().until(ExpectedConditions.visibilityOf(ClickOnOkBtn)).click();
		
		String str=ExplicitWait().until(ExpectedConditions.visibilityOf(VerifyPurchaseDone)).getText();
		if(str.equals(prop.getProperty("WelComeMessage")))
		{
			
			System.out.println("Purchase Done");
		}else
		{
			
			System.out.println("purchase Unsuccessful");
		}
		
	}
	                                         

	
	
	
	
	

	
	
	

}
