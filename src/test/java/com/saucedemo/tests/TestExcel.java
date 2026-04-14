package com.saucedemo.tests;
import com.saucedemo.utils.ExcelUtils;

public class TestExcel {
    public static void main(String[] args) {
        // Excel file ka pura rasta (Path)
        String path = System.getProperty("user.dir") + "/src/test/resources/testData/TestData.xlsx";
        
        // ExcelUtils se data mangwana (Sheet1, Row 1, Column 0 - Username ke liye)
        String user = ExcelUtils.getCellData(path, "Sheet1", 1, 0);
        String pass = ExcelUtils.getCellData(path, "Sheet1", 1, 1);
        
        System.out.println("Excel se mila Username: " + user);
        System.out.println("Excel se mila Password: " + pass);
    }
}