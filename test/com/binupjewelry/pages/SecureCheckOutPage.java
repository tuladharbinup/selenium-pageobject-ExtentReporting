package com.binupjewelry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.binupjewelry.base.BasePage;
import com.binupjewelry.base.DriverContext;
import com.binupjewelry.utilities.HelperUtil;

public class SecureCheckOutPage extends BasePage {
	@FindBy(how=How.ID, using = "stripe_cardname")
    public WebElement txtNameOnCard;
	
	@FindBy(how=How.ID, using = "stripe_cardnumber")
	public WebElement txtCardNumber;
	
	@FindBy(how=How.ID, using = "stripe_card_month")
	public WebElement txtExpiry;
	
	@FindBy(how=How.ID, using = "stripe_card_cvc")
	public WebElement txtCVC;
	
	@FindBy(how=How.ID, using = "stripe_card_postalcode")
	public WebElement txtZipCode;
	
	@FindBy(how=How.ID, using = "btnCompleteOrderStripe")
    public WebElement btnCompleteOrder;
	
	@FindBy(how=How.CSS, using = "#payment_failed_stripe input")
    public WebElement checboxPaymentTerm;
	
	public void completeCreditCardInformation(String name,String cardNumber, String expiryMM, String expiryYYYY,String CVC, String zip) throws InterruptedException {
		HelperUtil.sendKeys(txtNameOnCard, name);
	
		txtCardNumber.clear();
		Thread.sleep(100);
		txtCardNumber.sendKeys(cardNumber.substring(0, 4));		
		Thread.sleep(100);
		txtCardNumber.sendKeys(cardNumber.substring(4, 8));		
		Thread.sleep(100);
		txtCardNumber.sendKeys(cardNumber.substring(8, 12));		
		Thread.sleep(100);
		txtCardNumber.sendKeys(cardNumber.substring(12, 16));			
		Thread.sleep(100);
		
		txtExpiry.clear();
		txtExpiry.sendKeys(expiryMM);
		txtExpiry.sendKeys(expiryYYYY);
		
		HelperUtil.sendKeys(txtCVC, CVC);
		HelperUtil.sendKeys(txtZipCode, zip);

    }
	
	public void clickCompleteOrder() {
		HelperUtil.clickElement(btnCompleteOrder);
	    }
	
	public void checkRadioTermsAndConditions() {
		HelperUtil.clickElement(checboxPaymentTerm);
	    }
	
}
