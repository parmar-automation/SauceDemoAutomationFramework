package com.saucedemo.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelUtils {
    
    // Ye objects Excel ke different parts ko represent karte hain
    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
        try {
            // 1. File ko stream mein open karna
            fis = new FileInputStream(filePath);
            
            // 2. Poori Workbook (Excel File) ko load karna
            workbook = new XSSFWorkbook(fis);
            
            // 3. Specific Sheet (e.g. Sheet1) par jana
            sheet = workbook.getSheet(sheetName);
            
            // 4. Row aur Column se cell ka data uthana
            row = sheet.getRow(rowNum);
            cell = row.getCell(colNum);
            
            String data = cell.getStringCellValue();
            
            workbook.close();
            fis.close();
            
            return data;
            
        } catch (Exception e) {
            return ""; // Agar koi error aaye toh khali string bhej do
        }
    }
    
    // uper ka jo kam he wo humne bina data provider se data enter karwaya ab niche wala hum data provider se karenge 
    
    // Excel me total kitni rows hai
    public static int getRowCount(String filePath, String sheetName) {
    	try {
    		fis = new FileInputStream(filePath);
    		workbook = new XSSFWorkbook(fis);
    		sheet = workbook.getSheet(sheetName);
    		
    		int rowCount = sheet.getLastRowNum();
    		workbook.close();
    		return rowCount;
    	}catch (Exception e) {
    		return 0;
    	}
    }
    
    // Excel me totel kitne colum he
    
    public static int getColumnCount(String filePath, String sheetName) {
    	try {
    		fis = new FileInputStream(filePath);
    		workbook = new XSSFWorkbook(fis);
    		sheet = workbook.getSheet(sheetName);
    		
    		int colCount = sheet.getRow(0).getLastCellNum();
    		workbook.close();
    		return colCount;
    		
    		
    	}catch (Exception e) {
    		return 0;
    	}
    }
}
