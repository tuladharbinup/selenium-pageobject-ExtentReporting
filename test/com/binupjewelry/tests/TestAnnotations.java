package com.binupjewelry.tests;
import java.lang.reflect.Method;

/**
 * Created by binup on 5/13/2017.
 */
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.binupjewelry.config.ConfigReader;
import com.binupjewelry.config.Settings;
import com.binupjewelry.utilities.ExtentReportUtil;
import com.binupjewelry.base.DriverContext;

public class TestAnnotations {
	
	@BeforeSuite(alwaysRun = true)
    public void setupTestSuite() {
		System.out.println("Beginning Test initialization.....");		
        ConfigReader.PopulateSettings();
        System.setProperty("webdriver.gecko.driver",Settings.geekoDriverPath);
        
        DriverContext.driver = new FirefoxDriver();	
        System.out.println("Navigating to test URL: " +Settings.AUT);
        DriverContext.driver.get(Settings.AUT);
        DriverContext.driver.manage().window().maximize();   
        
        //creating html report
        ExtentReportUtil.createHTMLReport();
        
        System.out.println("Test initialization Completed");

    }
	
	@BeforeClass
    public void beforeClass() {
		ExtentReportUtil report= new ExtentReportUtil();
		report.createParentTest(getClass().getSimpleName().toString());        
    }
	
	 @BeforeMethod
	 public  void beforeMethod(Method method) {
		ExtentReportUtil report= new ExtentReportUtil();
		report.createChildTest(method);      
		
	  }

	 @AfterMethod
	 public void afterMethod(ITestResult result) {
		 	ExtentReportUtil report= new ExtentReportUtil();
			report.createTestResult(result);
	    }
	 
	@AfterSuite
    public void TearDownTestSuite() {	        
        // close application
       // DriverContext.driver.close();		 		 
        }
}
