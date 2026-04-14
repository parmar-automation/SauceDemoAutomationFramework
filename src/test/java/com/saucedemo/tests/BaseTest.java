package com.saucedemo.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	
	public static Logger logger;
	
	public static Properties prop;
	
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp() {
		
		loadConfig(); // sabse pahle file load hogi
		
		// 1. driver ka name properties file se uthayaye
		
		String browserName = prop.getProperty("browser");
		
		logger = LogManager.getLogger(this.getClass());
		logger.info("--- Test Caase Executaion Shuru ho Rhi Hai ---");
		
		// 2. browser select karne ka logic( Abhi sirf crome hai)
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		// 3. Website URL bhi properties file se uthaye
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));	
	
	}
	
	// 1. void ki jagah String likhiye
	public String captureScreenshot(String testName) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    
	    String timestamp = new java.text.SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	    
	    // 2. Path ko ek variable mein store kijiye
	    String destinationPath = System.getProperty("user.dir") + "/Screenshot/" + testName + "_" + timestamp + ".png";
	    
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    File finalDestination = new File(destinationPath);

	    try {
	        org.apache.commons.io.FileUtils.copyFile(source, finalDestination);
	        System.out.println("ScreenShot captured at: " + destinationPath);
	    } catch (java.io.IOException e) {
	        e.printStackTrace();
	    }
	    
	    // 3. Sabse zaroori: Ye path wapas bhejiye
	    return destinationPath; 
	}
	      
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
