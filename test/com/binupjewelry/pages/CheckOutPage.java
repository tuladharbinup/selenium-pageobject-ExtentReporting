package com.binupjewelry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.binupjewelry.base.BasePage;
import com.binupjewelry.base.DriverContext;
import com.binupjewelry.utilities.HelperUtil;

public class CheckOutPage extends BasePage{
	@FindBy(how=How.CSS, using = ".add_new_address")
    public WebElement btnAddAddress;
	
	@FindBy(how=How.ID, using = "shipping_fname")
    public WebElement txtFName;
	
	@FindBy(how=How.ID, using = "shipping_lname")
    public WebElement txtLName;
	
	@FindBy(how=How.ID, using = "shipping_address1")
    public WebElement txtAddress1;
	
	@FindBy(how=How.ID, using = "shipping_city")
    public WebElement txtCity;	
	
	@FindBy(how=How.ID, using = "ddlShippingCountry")
    public WebElement drpdownCountry;
		
	@FindBy(how=How.ID, using = "ddlStates")
    public WebElement drpdownState;
	
	@FindBy(how=How.ID, using = "shipping_zipcode")
    public WebElement txtZip;
	
	@FindBy(how=How.ID, using = "btnConfirmAddress")
    public WebElement btnContinueShippingOptions;
	
	@FindBy(how=How.XPATH, using = "//input[@value='Continue to Payment']")
    public WebElement btnContinueToPayment;
	
	
	public void clickAddAddress() {
		HelperUtil.clickElement(btnAddAddress);		
	    }
	
	public void createShippingInfo(String fname,String lname, String addressLine1, String city, String country, String state, String zip) throws InterruptedException {
		HelperUtil.sendKeys(txtFName, fname);
		HelperUtil.sendKeys(txtLName, lname);
		HelperUtil.sendKeys(txtAddress1, addressLine1);
		HelperUtil.sendKeys(txtCity, city);
		
		Select selectCountry=new Select(drpdownCountry);
		selectCountry.selectByVisibleText(country);
		Thread.sleep(2000);
		
		Select selectState=new Select(drpdownState);	
		if (selectState.getOptions().size()>0) {
			System.out.println("\n Number of States found in dropdown: "+selectState.getOptions().size());			
			selectState.selectByVisibleText(state);		
		}
		else {
				System.out.println("No state is available to select");
		}

        HelperUtil.sendKeys(txtZip, zip);        
    }	
	
	public void clickContinueToShippingOptions() {
		HelperUtil.clickElement(btnContinueShippingOptions);
	    }
	
	public void clickContinueToPayment() {
		HelperUtil.clickElement(btnContinueToPayment);
	    }	
	
	
}