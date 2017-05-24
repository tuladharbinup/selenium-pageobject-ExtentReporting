package com.binupjewelry.pojo;
/**
 * Created by binup on 5/13/2017.
 */
import com.binupjewelry.config.Settings;
import com.binupjewelry.utilities.ExcelUtil;

public class Authentication {
	public Authentication() {
			loadAuthenticationFromExcel();
		}

	private String userName;
	private String passWord;
	
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	

    public void loadAuthenticationFromExcel(){
         System.out.println("LOAD_INFO: Loading Authentication data from excel...");
         try {
        	 ExcelUtil.setExcelFile(Settings.excelPath,"Authentication");
        	 setUserName(ExcelUtil.ReadCell("Username", 1));
        	 setPassWord(ExcelUtil.ReadCell("Password", 1));
        	 System.out.println("UserName: "+getUserName()+", Password: "+getPassWord()+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
               
        }
   }

