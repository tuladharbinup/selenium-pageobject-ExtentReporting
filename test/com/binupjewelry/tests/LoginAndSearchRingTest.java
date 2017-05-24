package com.binupjewelry.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.binupjewelry.enums.Products;
import com.binupjewelry.pages.CartPage;
import com.binupjewelry.pages.CheckOutPage;
import com.binupjewelry.pages.HomePage;
import com.binupjewelry.pages.LoginPage;
import com.binupjewelry.pages.ProductDetailPage;
import com.binupjewelry.pages.SearchPage;
import com.binupjewelry.pages.SecureCheckOutPage;
import com.binupjewelry.pojo.Authentication;
import com.binupjewelry.pojo.CreditCardInfo;
import com.binupjewelry.pojo.ShippingInfo;
import com.binupjewelry.utilities.ExtentReportUtil;
import com.binupjewelry.utilities.HelperUtil;

/**
 * Created by binup on 5/13/2017.
 */
public class LoginAndSearchRingTest extends TestAnnotations {
	
	Products testProduct=Products.PandoraSilverRoseRing;
	
	@Test (priority=1)
	public void login() throws IOException {
		System.out.println("\n EXECUTING TEST--> Login "); 
		ExtentReportUtil.test.get().assignCategory("Smoke Test");
		ExtentReportUtil.test.get().assignAuthor("Binup");
		//Instantiating POJO objects
    	Authentication testUser=new Authentication();
    	
    	//Instantiating Page objects
    	HomePage homePage= new HomePage();
    	LoginPage loginPage = new LoginPage();
    	
    	homePage.clickSignIn();        
        loginPage.Login(testUser.getUserName(), testUser.getPassWord());
        HelperUtil.waitForElementToBeVisible(homePage.lnkSignOut);
        
        //report logging
        ExtentReportUtil.test.get().log(Status.INFO, "Login is Sucessful");
                        
        //report log with snapshot
        String snapshotPath=HelperUtil.grabScreenShotForReport();
        ExtentReportUtil.test.get().pass("Snapshot saved under: "+snapshotPath, MediaEntityBuilder.createScreenCaptureFromPath(snapshotPath).build());
        
        //test with snapshot
        ExtentReportUtil.test.get().addScreenCaptureFromPath(snapshotPath);
	}
	
	@Test (priority=2 , dependsOnMethods = { "login" })		
    public void searchRing() throws InterruptedException, IOException {    	
    	System.out.println("\n EXECUTING TEST--> Search Ring");   
    	ExtentReportUtil.test.get().assignCategory("Functional Test");
		ExtentReportUtil.test.get().assignAuthor("Binup");
    	
    	//Instantiating Page objects
    	HomePage homePage= new HomePage();
    	SearchPage searchPage = new SearchPage();    	   	
    	        
        homePage.selectHomeMenu();
        homePage.searchProduct(testProduct.getProductTitle());        
        System.out.println("\nSearch result number: "+searchPage.getSearchResultNumber());
        searchPage.clickDetails();

        ExtentReportUtil.test.get().log(Status.INFO, "Search is Sucessful");
       
    }
	
	
	
}
