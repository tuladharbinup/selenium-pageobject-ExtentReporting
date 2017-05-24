package com.binupjewelry.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.binupjewelry.base.BasePage;
import com.binupjewelry.utilities.HelperUtil;

public class HomePage extends BasePage {

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Sign In")
    //@FindBy(how= How.CSS, using=".icon-user-add")
    public WebElement lnkSignIn;

    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Sign Out")
    public WebElement lnkSignOut; 
    
    @FindBy(how=How.CSS, using = ".basket_myaccount_intro_title")
    public WebElement txtWelcome;
    
    @FindBy(how=How.LINK_TEXT, using = "View Products")
    public WebElement menuViewProducts;
    
    @FindBy(how=How.XPATH, using = "//a[contains(text(),'Rings')]")
    public WebElement subMenuRings;
    
    @FindBy(how=How.LINK_TEXT, using = "Home")
    public WebElement btnHome;
    
    @FindBy(how=How.LINK_TEXT, using = "Basket")
    public WebElement lnkBasket;
    
    @FindBy(how=How.ID, using = "txtQuickSearch")
    public WebElement txtSearch;
    
    @FindBy(how=How.ID, using = "search_button")
    public WebElement btnSearch;

    public void clickSignIn() {
    	HelperUtil.clickElement(lnkSignIn);    	
    }
    
    public String getWelcomeMessage() {
        return txtWelcome.getText();
    }
    
    public void selectHomeMenu() {
    	HelperUtil.clickElement(btnHome);   	  	
    }
    
    public void clickBasketMenu() {
    	HelperUtil.clickElement(lnkBasket);    	     
   }
    
    public void clickSignOut() {
    	HelperUtil.clickElement(lnkSignOut);
    }
    
    public void searchProduct(String searchText) {
    	HelperUtil.sendKeys(txtSearch, searchText);    	
    	HelperUtil.clickElement(btnSearch);       	
    }
}
