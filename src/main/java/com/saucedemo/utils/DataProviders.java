package com.saucedemo.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getAllData() {
        String path = System.getProperty("user.dir") + "/src/test/resources/testData/TestData.xlsx";
        String sheetName = "Sheet1";

        int rowCount = ExcelUtils.getRowCount(path, sheetName);
        int colCount = ExcelUtils.getColumnCount(path, sheetName);

        // 2D Array banana (Rows x Columns)
        // rowCount index 0 se shuru hota hai, isliye hum asli data rows gin rahe hain
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) { // Row 1 se shuru (Row 0 header hai)
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = ExcelUtils.getCellData(path, sheetName, i, j);
            }
        }
        return data;
    }
}