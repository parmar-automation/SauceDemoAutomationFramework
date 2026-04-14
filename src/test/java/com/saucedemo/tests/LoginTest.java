package com.saucedemo.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutStepOnePage;
import com.saucedemo.pages.CheckoutStepTwoPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.DataProviders;
import com.saucedemo.utils.ExcelUtils;
import com.saucedemo.utils.ExtentReportManager;

public class LoginTest extends BaseTest {
	
	// DataProvider ka rasta batana aur uski class mention karna
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLoginWithMultipleUsers(String user, String pass) {
	    LoginPage lp = new LoginPage(driver);
	    
	    // yeh line extent report me iteration ki details dikhayegi
	    
	    ExtentReportManager.test.info("Starting test with user: " + user);
	    
	    lp.enterUsername(user);
	    lp.enterPassword(pass);
        lp.clickLogin();
        
        // --- Assertion Yahan Lagega ---
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        
        // Agar URL match nahi hua toh ye message print karega aur test fail kar dega
        Assert.assertEquals(actualUrl, expectedUrl, "Login fail ho gaya: URL match nahi kar raha!");
        // ------------------------------

        logger.info("Excel se data utha kar login kar diya gya he : " + user);
	    
	    logger.info("Excel se data utha kar login kar diya gya he : " + user);
	    
	    // Success message in report 
	    
	    ExtentReportManager.test.pass("Successfully logged in with user: " + user);
	    
	    // Yahan aap logout ka logic bhi daal sakte hain taaki agla user login kar sake
	}
	
	
	
//	@Test(priority=1, enabled = true)
//	public void verifySuccessfulLogin() {
//
//		// LoginPage ka object banana                                      //		// Action perform karna
////		lp.enterUsername("standard_user");  // // purana code hai ye
////		lp.enterPassword("secret_sauce");
//		LoginPage lp = new LoginPage(driver);
//		// ab yha hume prop object ka use karke config se data uthayenge
//		
//		lp.enterUsername(prop.getProperty("user"));
//		lp.enterPassword(prop.getProperty("password"));
//
//		lp.clickLogin();
//		
//		// Check karna ki deshboaard open huwa ya nhi
//		
//		String expectedUrl = "https://www.saucedemo.com/inventory.html";
//		String actualUrl = driver.getCurrentUrl();
//		
////		if(actualUrl.equals(expectedUrl))
////		{
////			System.out.println("Login Successful: Test Passed");
////		}else {
////			System.out.println("Login Failed: test Failed!");
////		}
//		
//		Assert.assertEquals(actualUrl, expectedUrl, "URL match nhi huwa, shayad login fail ho gya!");
//	}
	
	//////===== Uper jo comment kiya he uskoab data provider se kar rha hu
	
	@Test(dataProvider="LoginData", enabled = false) //provider ka name yha likhe
	public void verifyMultipuleLogins(String username, String password) {

	
		LoginPage lp = new LoginPage(driver);
		// ab prop.getproperty ki jago direct arguments use honge
		
		lp.enterUsername(username);
		lp.enterPassword(password);

		lp.clickLogin();
		
		// Check karna ki deshboaard open huwa ya nhi
		
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		
//		if(actualUrl.equals(expectedUrl))
//		{
//			System.out.println("Login Successful: Test Passed");
//		}else {
//			System.out.println("Login Failed: test Failed!");
//		}
		
		Assert.assertEquals(actualUrl, expectedUrl, "URL match nhi huwa, shayad login fail ho gya!");
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] getData(){
		// 2rows or 2 colums (username , password)
		Object[][] data = new Object[3][2];
		//1st set : sahi user ke liye
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		//2nd set "Wrong user ke lue"
		data[1][0]="Wrong_User";
		data[1][1]="secret_sauce";
		//3rd set ek or sahi user
		data[2][0]="problem_user";
		data[2][1]="secret_sauce";
		
		return data;
	}
	
	// EXCEL SE DATA LEKAR LOGIN KAR RHE HAI
	@Test(enabled = false)
	public void verifyLogin() {
	    LoginPage lp = new LoginPage(driver);
	    
	    // Excel ka path (BaseTest mein bhi rakh sakte hain baad mein)
	    String path = System.getProperty("user.dir") + "/src/test/resources/testData/TestData.xlsx";
	    
	    // Excel se data mangwana
	    String userFromExcel = ExcelUtils.getCellData(path, "Sheet1", 1, 0);
	    String passFromExcel = ExcelUtils.getCellData(path, "Sheet1", 1, 1);
	    
	    // Login process mein Excel ka data pass karna
	    lp.enterUsername(userFromExcel);
	    lp.enterPassword(passFromExcel);
	    lp.clickLogin();
	    
	    logger.info("Excel se data utha kar login kar diya gaya hai");
	}
	
	@Test(priority=2 , enabled = false)
	public void verifyProductAddToCart() {
		
		//1. Login Process 
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUsername("standard_user");
		
		lp.enterPassword("secret_sauce");
		
		lp.clickLogin();
		
		// 2. product Add to Cart Process
		
		InventoryPage ip = new InventoryPage(driver);
		ip.addProductToCart();
		
		// 3. Assertion (Industry Standard Tarika )
		
		String actualCount = ip.getCartCount();
		String expectedCount = "1";
		
		// Ager count matching nahi hoga toh testng error dega
		
		Assert.assertEquals(actualCount, expectedCount, "Cart count mismatch!");
		
		System.out.println("Product added successfully. Cart Count: + actualCount");
	}
	
	@Test (priority=3, enabled = false)
	public void verifyProductSorting() {
		// 1. Login 
        LoginPage lp = new LoginPage(driver);
		
		lp.enterUsername("standard_user");
		
		lp.enterPassword("secret_sauce");
		
		lp.clickLogin();
		
		//2. DroupdownChange 
		
		InventoryPage ip = new InventoryPage(driver);
		
		ip.sortProductByPriceLowToHigh();
		
		// 3. Verification (Optional: Console mein me cconfirm karte he00)
		
		System.out.println("Products sorted by price : Low to high");
		
	}
	
	@Test(priority=5, enabled = false)
	public void testScreenshotOnFailure() {
		// 1. Login
				LoginPage lp = new LoginPage(driver);
				
		        lp.enterUsername("Wrong_user");
				
				lp.enterPassword("secret_sauce");
				
				lp.clickLogin();
				
				// hum check kar rhe ki login huwa jo ki nhi hoga 
				
				// ab yahan assertion (check) lagaye 
				
				String actualUrl = driver.getCurrentUrl();
				Assert.assertTrue(actualUrl.contains("inventory.html"), "Login fail ho gya!");
				
			
					
				
		
		
	}
	
	@Test(priority=4, enabled = false)
	public void verifyWindowHandle() throws InterruptedException {
		// 1. Login
		LoginPage lp = new LoginPage(driver);
		
        lp.enterUsername("standard_user");
		
		lp.enterPassword("secret_sauce");
		
		lp.clickLogin();
		
		// 2. Parent Window ki Id save karein
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("main window Title: " + driver.getTitle());
		
		// 3. Twitter par click kare 
		
		InventoryPage ip = new InventoryPage(driver);
		
		ip.clickTwitter();
		
		// 4. Saari Window Ki IDs Nikale
		
		java.util.Set<String> allWindows = driver.getWindowHandles();
		
		for (String window : allWindows ) {
			if(! window.equals(parentWindow)) {
				
				// 5 . new window par switch kare
				
				driver.switchTo().window(window);
				
				// Explicit wait (Wait until title is NOT empty)
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				// wait karna he jab tak title me twiter na aajaye
				
				wait.until(ExpectedConditions.urlContains("https://x.com/saucelabs"));
			
				
				System.out.println("new teb URL: " + driver.getCurrentUrl());
				System.out.println("new tab ka title: " + driver.getTitle());
				
				// 6 . nya teb band kare bad me karunga abhi open hi rakhata hu iske liche code likhana he driver.close()
				Thread.sleep(4000);
				driver.close();
			}
		}
		
		// 7. wapas purani window par switch kiya
		
		driver.switchTo().window(parentWindow);
		System.out.println("ab wapis jis windows par aaya uska title: " + driver.getTitle());
		
		
	}

}
