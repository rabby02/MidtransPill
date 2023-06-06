package com.pageTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basepage.TestBase;
import com.pages.Homepage;
import com.pages.summaryPage;
import com.util.utility;

public class HomepageTest extends TestBase{
	
	
	
	
	public Homepage hp;
	public utility ut;
	public summaryPage sp;
	
	public HomepageTest()
	{
		
		super();
	}
	
	@BeforeClass
	public void SetUp()
	{
	
			Initialization();
		
		   hp=new Homepage();
	    	ut=new utility();
	    	sp=new summaryPage();
		
	}
	
	@Test(testName="Verify_Product_Added_Into_CartWithCost",priority=1, groups= {"regression"})
	public void VerifyProductAndPrice()
	{
		
		hp.Verify_Product_Added_Into_CartWithCost();
		System.out.println("Tc-01 Successfully Executed");
	}
	
	@Test(testName="Verify_clickingOn_BuyNow_button_redirect_popUp",priority=2, groups= {"regression","smoke"})
	
	public void VerifYcheckOutWindow()
	{
		
		
		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		System.out.println("Tc-02 Successfully Executed");
		
	}
	
	@Test(testName="VerifyName_email_phone_address_zipcode_Are_Displayed",priority=3,groups= {"regression"})
	public void VerifyCheckOutInputs()
	{
		
		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.VerifyName_email_phone_address_zipcode_Are_Displayed();
		System.out.println("Tc-03 Successfully Executed");
	}
	
	@Test(testName="VerifyName_email_phone_address_zipcode_Are_Editable",priority=4,groups= {"regression"})
	public void VerifyInputEditableOrNot()
	{
		
		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.VerifyName_email_phone_address_zipcode_Are_Editable();
		System.out.println("Tc-04 Successfully Executed");
		
	}
	
	@Test(testName="Order Summary popup ",priority=5,groups= {"regression","smoke"})
	public void ClickOnCheckOutandOrderSummaryPopup() throws InterruptedException 
	{
		
		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		
		
		hp.Checkout_button_click();
		hp.OrderSummary_value_verify();
		
		//ut.HoldExecution(7);
		
		
	
		
	}
	@Test(testName="Verify all the product details on order summery popup ",priority=6,groups= {"regression"})
	public void OrderSummary_value_verification() throws InterruptedException
	{
        hp.Verify_clickingOn_BuyNow_button_redirect_popUp();	
		hp.Checkout_button_click();
		hp.OrderSummary_value_verify();
		hp.Verifyall_the_product_details_on_order_summery_popup();
		
		
		
	}
	
	@Test(testName="Verify clicking on continue button",priority=7,groups= {"regression","smoke"})
	public void User_redirect_to_payment_screen() throws InterruptedException
	{
		
		 hp.Verify_clickingOn_BuyNow_button_redirect_popUp();	
			hp.Checkout_button_click();
			hp.OrderSummary_value_verify();
			hp.Verifyall_the_product_details_on_order_summery_popup();
			hp.verify_clicking_on_continue_button_on_order_summery();
			
		
	}
	
	@Test(testName="Verify all the payment options listed on payment page",priority=8,groups= {"regression"})
	
	public void ListOfPaymentOption()
	{
		
		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.Checkout_button_click();
		hp.verify_all_the_payment_options();
		
	}
	
	
	@Test(testName="click on credit and debit card",priority=9,groups= {"regression","smoke"})
	public void click_on_Creditcard()
	{
		
		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.Checkout_button_click();
		hp.ClickOnCreditOrDebit();
	}
	
	@Test(testName="Verify order amount on card details screen",priority=10,groups= {"regression"})
	public void verifyOrderOncardScreen()
	{

		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.Checkout_button_click();
		hp.ClickOnCreditOrDebit();
		hp.VerifyOrderAmount_onCardScreen();
		
	}
	@Test(testName="Enter Card Credentials",priority=11,groups= {"regression","smoke"})
	public void Put_card_Details_credentials()
	{

		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.Checkout_button_click();
		hp.ClickOnCreditOrDebit();
		hp.VerifyOrderAmount_onCardScreen();
		hp.EnterCreditCardDetails();
		
	}
	@Test(testName="Redirect_to_bank_screen",priority=12,groups= {"regression"})
	public void Redirect_to_bank_after_click_on_payNow() throws InterruptedException
	{

		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.Checkout_button_click();
		hp.ClickOnCreditOrDebit();
		hp.VerifyOrderAmount_onCardScreen();
		hp.EnterCreditCardDetails();
		hp.ClickOnPayNpwAn_Redirect_to_paymentscreen();
		
	}
	
	@Test(testName="clickOnOkbutton",priority=13,groups= {"regression","smoke"})
	public void click_on_Ok() throws InterruptedException
	{

		hp.Verify_clickingOn_BuyNow_button_redirect_popUp();
		hp.Checkout_button_click();
		hp.ClickOnCreditOrDebit();
		hp.VerifyOrderAmount_onCardScreen();
		hp.EnterCreditCardDetails();
		hp.ClickOnPayNpwAn_Redirect_to_paymentscreen();
		hp.verifyOkButton_with_valid_otp();
		
	}
	
	
	
	
	
	

		

	
	@AfterClass
	public void TearDown()
	{
		
		driver.quit();
	}
	
	

	
	
}
