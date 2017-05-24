package com.binupjewelry.config;
/**
 * Created by binup on 5/13/2017.
 */
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 public static void PopulateSettings()
	    {
	        ConfigReader reader = new ConfigReader();
	        reader.ReadProperty();

	    }
	    private void ReadProperty(){

	        try {
	            Properties p=new Properties();
	            p.load(getClass().getResourceAsStream("GlobalConfig.properties"));
	            
	            Settings.AUT = p.getProperty("AUT");
	            Settings.geekoDriverPath = p.getProperty("geekoDriverPath");
	            Settings.excelPath = p.getProperty("excelPath");


	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
