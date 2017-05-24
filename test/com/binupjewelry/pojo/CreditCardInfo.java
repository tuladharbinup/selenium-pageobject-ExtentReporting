package com.binupjewelry.pojo;
/**
 * Created by binup on 5/13/2017.
 */
import com.binupjewelry.config.Settings;
import com.binupjewelry.utilities.ExcelUtil;

public class CreditCardInfo {
	
	private String nameOnCard;
	private String cardNumber;
	private String expiryMM;	
	private String expiryYYYY;	
	private String CVC;	
	private String zip;

	public CreditCardInfo() {
			loadCreditCardInfoFromExcel();
		}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMM() {
		return expiryMM;
	}
	public void setExpiryMM(String expiryMM) {
		this.expiryMM = expiryMM;
	}

	public String getExpiryYYYY() {
		return expiryYYYY;
	}
	public void setExpiryYYYY(String expiryYYYY) {
		this.expiryYYYY = expiryYYYY;
	}

	public String getCVC() {
		return CVC;
	}
	public void setCVC(String cVC) {
		CVC = cVC;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

    public void loadCreditCardInfoFromExcel(){
         System.out.println("LOAD_INFO: Loading CreditCardInfo data from excel...");
         try {
        	 ExcelUtil.setExcelFile(Settings.excelPath,"CreditCardInfo");
        	 setNameOnCard(ExcelUtil.ReadCell("NameOnCard", 1));
        	 setCardNumber(ExcelUtil.ReadCell("CardNumber", 1));
        	 setExpiryMM(ExcelUtil.ReadCell("ExpiryMM", 1));
        	 setExpiryYYYY(ExcelUtil.ReadCell("ExpiryYYYY", 1));
        	 setCVC(ExcelUtil.ReadCell("CVC", 1));
        	 setZip(ExcelUtil.ReadCell("Zip", 1));   	 							
        	 System.out.println("Added Credit card information for: "+getNameOnCard()+"\n");
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
               
        }
   

}
