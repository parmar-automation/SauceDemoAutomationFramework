package com.saucedemo.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saucedemo.utils.ExtentReportManager;

// BaseTest ko extend karna zaroori hai agar aapko captureScreenshot use karna hai
public class Listeners extends BaseTest implements ITestListener {

    // 1. Report Manager se scorecard mangwana
    ExtentReports extent = ExtentReportManager.getReporter();
   

    @Override
    public void onTestStart(ITestResult result) {
        // Jaise hi test shuru ho, report mein entry banao
        String testName = result.getMethod().getMethodName();
        ExtentReportManager.test = extent.createTest(testName);
        System.out.println("Test shuru ho raha he: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Pass hone par green entry
    	ExtentReportManager.test.log(Status.PASS, "Badhai ho ! Test Pass ho gya: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        
        // 1. Screenshot lo aur uska rasta mangwao
        String filePath = captureScreenshot(testName);
        
        // 2. Report mein Red entry aur screenshot dono jodiye
        ExtentReportManager.test.fail("Test Fail ho gaya hai. Screenshot dekhiye niche:", 
                  com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
        
        ExtentReportManager.test.fail(result.getThrowable()); // Error message bhi dikhao
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	ExtentReportManager.test.log(Status.SKIP, "Test skip ho gya he.");
    }

    @Override
    public void onFinish(ITestContext context) {
        // SABSE ZAROORI: Report ko save/flush karna
        if (extent != null) {
            extent.flush();
        }
        System.out.println("Saare tests khatam, report generate ho gayi!");
    }
}