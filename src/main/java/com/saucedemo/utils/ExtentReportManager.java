package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    
    // Ye 'extent' object hamara main Scorecard hai
    public static ExtentReports extent;
    
    public static ExtentTest test;

    public static ExtentReports getReporter() {
        if (extent == null) {
            // 1. Batana ki report kahan save hogi (Reports folder ke andar)
            ExtentSparkReporter spark = new ExtentSparkReporter("Reports/ExtentReport.html");

            // 2. Report ki setting (Design)
            spark.config().setReportName("SauceDemo Automation Result");
            spark.config().setDocumentTitle("Test Report");
            spark.config().setTheme(Theme.DARK); // Dark mode professional dikhta hai

            // 3. ExtentReports Engine initialize karna
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // 4. Extra Information (Interview mein impact dalne ke liye)
            extent.setSystemInfo("Tester", "Parma"); 
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}