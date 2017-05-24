package com.binupjewelry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.binupjewelry.base.BasePage;
import com.binupjewelry.base.DriverContext;
import com.binupjewelry.utilities.HelperUtil;



public class SearchPage extends BasePage {
	
	@FindBy(how=How.CSS, using = "#products_list h4")
    public WebElement searchResultText;
	
	@FindBy(how = How.LINK_TEXT, using ="Details")
	    public WebElement btnDetails;
	
	 public Integer getSearchResultNumber() {
		 HelperUtil.waitForElementToBeVisible(searchResultText);
		 String searchMessage=searchResultText.getText();
		 String[] msg=searchMessage.split(" ");
		 return Integer.parseInt(msg[0]); 
		 
	    }
	 public void clickDetails() {
		 HelperUtil.clickElement(btnDetails); 		 
	    }
	 
	

}
