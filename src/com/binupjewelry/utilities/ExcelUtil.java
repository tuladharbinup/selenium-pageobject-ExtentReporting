package com.binupjewelry.utilities;
/**
 * Created by binup on 5/13/2017.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.binupjewelry.config.Settings;

	public class ExcelUtil {
		private static XSSFSheet ExcelWSheet;	 
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		private static Hashtable<String,String> dict= new Hashtable<String,String>();

	//This method is used to set the File path and open the Excel sheet
	public static void setExcelFile(String Path,String SheetName) throws Exception {
			try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			
			// Access the required sheet with test data
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			ColumnDictionary();
			ExcelFile.close();
			} 
			catch (Exception e){
				throw (e);
			}
	}

	//This method is to read the test data from the Excel cell by passing Row number and Column number as parameters
	public static String getCellData(int RowNum, int ColNum) throws Exception{
			try{
				Cell cell= ExcelWSheet.getRow(RowNum).getCell(ColNum);
				//cell.setCellType(Cell.CELL_TYPE_STRING);
				//String CellData = cell.getStringCellValue();
				DataFormatter df = new DataFormatter();
				String CellData = df.formatCellValue(cell);
				return CellData;
				}
			catch (Exception e){
				return"";
				}
	}

	//This method is to write in the Excel cell
	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
		try{
				Row  = ExcelWSheet.getRow(RowNum);
				Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
		if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
				} 
		else {
				Cell.setCellValue(Result);
				}

		//Writing in the excel from path location below
		FileOutputStream fileOut = new FileOutputStream(Settings.excelPath);
		ExcelWBook.write(fileOut);
		fileOut.flush();
		fileOut.close();
				}
		catch(Exception e){
					throw (e);
			}
	
		}
	
	//Returns the Number of Rows
	public static int RowCount()
	{
		return ExcelWSheet.getPhysicalNumberOfRows();
	}
	
    //Read Column Names
    private static int GetCell(String colName)
    {
        try {
            int value;
            value = Integer.parseInt(dict.get(colName)); 
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }
    
    //Read cell value by passing column name and row number
    public static String ReadCell(String columnName, int rowNumber) throws Exception
    {
        return getCellData(rowNumber,GetCell(columnName));
    }
    
    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary() throws Exception
    {
    	Row HeaderRow = ExcelWSheet.getRow(0);
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for(int col=0;col < HeaderRow.getPhysicalNumberOfCells();col++)
        {
            dict.put(getCellData(0,col), Integer.toString(col));  
        }

    }
    

}
