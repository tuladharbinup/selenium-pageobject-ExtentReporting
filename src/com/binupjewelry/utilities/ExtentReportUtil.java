package com.binupjewelry.utilities;

import java.io.File;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportUtil {
	private static final String OUTPUT_FOLDER = "htmlTestReports/";
    private static final String FILE_NAME = "index.html";
    private static final String DOCUMENT_TITLE = "Binup-Jewelry Automation Report";
    private static final String REPORT_NAME = "Regression Test Cycle";    
    private static final String PARENT_TEST_DESCRIPTION = "Binup-Jewelry Test Report";
	
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	
		
	public static void createHTMLReport() {		  		
		extent = createInstance(OUTPUT_FOLDER + FILE_NAME);		
	}
	
	
	public synchronized void createParentTest(String classname) {
        ExtentTest parent = extent.createTest(classname, PARENT_TEST_DESCRIPTION); //pass method.getName() if you need class name
        parentTest.set(parent);
    }
	
	public synchronized void createChildTest(Method method) {
	        ExtentTest child = parentTest.get().createNode(method.getName());	        
	        test.set(child);
	        
	    }
	
	 public synchronized void createTestResult(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE)
	            test.get().fail(result.getThrowable());
	        else if (result.getStatus() == ITestResult.SKIP)
	            test.get().skip(result.getThrowable());
	        else
	            test.get().pass("Test passed");

	        extent.flush();
	    }
	
	private static ExtentReports createInstance(String fileName) {
		
		File file = new File(System.getProperty("user.dir") +"//"+OUTPUT_FOLDER);
	        if (!file.exists()) {
	            if (file.mkdir()) {
	                System.out.println("Created Directory for Report--> "+System.getProperty("user.dir") +"\\"+OUTPUT_FOLDER);
	            } else {
	                System.out.println("Failed to create directory! " +System.getProperty("user.dir") +"\\"+OUTPUT_FOLDER);
	            }
	        }
		
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(DOCUMENT_TITLE);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(REPORT_NAME);  
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }
	
}
