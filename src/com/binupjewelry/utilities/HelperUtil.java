package com.binupjewelry.utilities;
/**
 * Created by binup on 5/13/2017.
 */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import com.binupjewelry.base.DriverContext;

public class HelperUtil {	
	private static WebDriver driver=DriverContext.driver;	
	
    public static void clickElement(WebElement element) {        
        waitForElementToBeClickable(element);
        try {
            element.click();
            System.out.println("Successfully clicked Element: "+element);
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", element));
        }
    }
    
    public static void sendKeys(WebElement element, String value) {
    	waitForElementToBeVisible(element);
        element.clear();
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, element));
        }
    }
	
	public static void waitForElementToBeVisible(WebElement element){		
		WebDriverWait wait = new WebDriverWait(driver, 15);
			try {				
				wait.until(ExpectedConditions.visibilityOf(element));
				System.out.println("Element "+element+" is present");
			}
			catch (NoSuchElementException ex)	
			{
				System.out.println("Element was not found "+ex.getAdditionalInformation());
			}
			catch (Exception ex)
			{
				System.out.println("General exception "+ex.getMessage());
			}
		
	}
	
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	public static void ImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void grabScreenShot(String imageFileName) {
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") +"//screenshots//"+imageFileName+".PNG"));
			System.out.println("Successfully saved snapshot at location: "+System.getProperty("user.dir") +"\\screenshots\\"+imageFileName+".PNG");
		} catch (IOException e) {
			System.out.println("Exception "+e.getMessage());
		}
	}
	
	public static String grabScreenShotForReport() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String dest=System.getProperty("user.dir") +"\\htmlTestReports\\img\\screenshot_"+timeStamp+".PNG";
			FileUtils.copyFile(screenshotFile, new File(dest));
			return dest;
		} catch (IOException e) {
			System.out.println("Exception "+e.getMessage());
			return null;
		}
		
	}
	
	
	public static boolean IsDisplayed(WebElement element) {
		
		try {
			return element.isDisplayed();
		}
		catch (NoSuchElementException ex)	
		{
			System.out.println("Element was not found "+ex.getAdditionalInformation());
			return false;
		}
		catch (Exception ex)
		{
			System.out.println("General exception "+ex.getMessage());
			return false;
		}				
	}
	
	public static void DragAndDrop(WebElement sourceElement, WebElement destElement) {
		Actions action=new Actions(driver);
		action.dragAndDrop(sourceElement, destElement).perform();
	}
	
	public static void Hover(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public static void HoverAndClick(WebElement elementToHover, WebElement elementToClick) {
		Actions action=new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}
	
    public static String getCurrentURL() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            throw new TestException(String.format("Current URL is: %s", driver.getCurrentUrl()));
        }
    }
	

	

}
