package com.binupjewelry.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.binupjewelry.enums.Products;
import com.binupjewelry.pages.CartPage;
import com.binupjewelry.pages.CheckOutPage;
import com.binupjewelry.pages.ProductDetailPage;
import com.binupjewelry.pages.SecureCheckOutPage;
import com.binupjewelry.pojo.CreditCardInfo;
import com.binupjewelry.pojo.ShippingInfo;
import com.binupjewelry.utilities.ExtentReportUtil;
import com.binupjewelry.utilities.HelperUtil;

public class BuyRingTest extends TestAnnotations {
	Products testProduct=Products.PandoraSilverRoseRing;	
	
	@Test (priority=3)		
    public void BuyRing() throws InterruptedException, IOException { 
		System.out.println("\n EXECUTING TEST--> Buy Ring");   
		ExtentReportUtil.test.get().assignCategory("Functional Test");
		ExtentReportUtil.test.get().assignAuthor("Binup");
		
		//Instantiating POJO objects
    	ShippingInfo testShippingInfo= new ShippingInfo();
    	CreditCardInfo creditCardInfo=new CreditCardInfo();
    	
    	//Instantiating Page objects   	
    	ProductDetailPage productDetailPage=new ProductDetailPage();
    	CartPage cartPage=new CartPage();
    	CheckOutPage checkOutPage=new CheckOutPage();
    	SecureCheckOutPage secureCheckOutPage=new SecureCheckOutPage(); 
    	
    	productDetailPage.verifyProductTitle(testProduct.getProductTitle());
        productDetailPage.clickBuy();   
        ExtentReportUtil.test.get().log(Status.INFO, "Successfully clicked Buy");
        
        cartPage.clickCheckOut();
        cartPage.verifyClickCheckOut();
        
        checkOutPage.clickAddAddress();        
        checkOutPage.createShippingInfo(testShippingInfo.getFirstName(), testShippingInfo.getLastName(), testShippingInfo.getAddressLine1(), testShippingInfo.getCity(), testShippingInfo.getCountry(), testShippingInfo.getState(), testShippingInfo.getZip());
        
        checkOutPage.clickContinueToShippingOptions();        
        checkOutPage.clickContinueToPayment();
        
        secureCheckOutPage.completeCreditCardInformation(creditCardInfo.getNameOnCard(), creditCardInfo.getCardNumber(), creditCardInfo.getExpiryMM(), creditCardInfo.getExpiryYYYY(), creditCardInfo.getCVC(), creditCardInfo.getZip());
        
        secureCheckOutPage.clickCompleteOrder();
        secureCheckOutPage.checkRadioTermsAndConditions();
        secureCheckOutPage.clickCompleteOrder();        
		
        ExtentReportUtil.test.get().log(Status.INFO, "Successfully placed Order");
        
        //Take screenshot at the end
        HelperUtil.grabScreenShot("TCsearchAndBuyRing");
        
        //log with snapshot
        String snapshotPath=HelperUtil.grabScreenShotForReport();
        ExtentReportUtil.test.get().pass("Snapshot saved under: "+snapshotPath, MediaEntityBuilder.createScreenCaptureFromPath(snapshotPath).build());
        
		
	}
	
	@Test (priority=4, dependsOnMethods = {"BuyRing"})		
    public void FailTestExample() {
		ExtentReportUtil.test.get().assignCategory("Functional Test");
		ExtentReportUtil.test.get().assignAuthor("Binup");
		ExtentReportUtil.test.get().log(Status.FAIL, "Example to show what FAIL step looks like");
		Assert.assertEquals(1, 2);
	}

}
