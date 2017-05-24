package com.binupjewelry.pojo;
/**
 * Created by binup on 5/13/2017.
 */
import com.binupjewelry.config.Settings;
import com.binupjewelry.utilities.ExcelUtil;

public class ShippingInfo {
	private String firstName;
	private String lastName;
	private String addressLine1;	
	private String addressLine2;	
	private String city;	
	private String country;	
	private String state;	
	private String zip;


	public ShippingInfo() {
			loadShippingInfoFromExcel();
		}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

    public void loadShippingInfoFromExcel(){
         System.out.println("LOAD_INFO: Loading ShippingInfo data from excel...");
         try {
        	 ExcelUtil.setExcelFile(Settings.excelPath,"ShippingInfo");
        	 setFirstName(ExcelUtil.ReadCell("FirstName", 1));
        	 setLastName(ExcelUtil.ReadCell("LastName", 1));
        	 setAddressLine1(ExcelUtil.ReadCell("AddressLine1", 1));
        	 setAddressLine2(ExcelUtil.ReadCell("AddressLine2", 1));
        	 setCity(ExcelUtil.ReadCell("City", 1));
        	 setCountry(ExcelUtil.ReadCell("Country", 1));
        	 setState(ExcelUtil.ReadCell("State", 1));
        	 setZip(ExcelUtil.ReadCell("Zip", 1));   	 							
        	 System.out.println("Added Shipping information for: "+getFirstName()+" "+getLastName()+" at zipcode "+getZip()+"\n");
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
               
        }
   

}
