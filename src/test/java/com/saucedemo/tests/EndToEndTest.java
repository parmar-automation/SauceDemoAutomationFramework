package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutStepOnePage;
import com.saucedemo.pages.CheckoutStepTwoPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class EndToEndTest  extends BaseTest {
	
	@Test
	public void verifyEndToEndPurchase() {
		//1. Login process (LoginPage)
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(prop.getProperty("user"));
		logger.info("UserName Enter Kar Diya gya hai");
		lp.enterPassword(prop.getProperty("password"));
		logger.info("Password Enter Kar Diya gya hai");
		lp.clickLogin();
		logger.info("Login Successfully ho gya he");
		
		// 2. Add Product & Go to cart(InvenoryPage)
		
		InventoryPage ip = new InventoryPage(driver);
		ip.addProductToCart();
		// yha humne cart icon click karne ka method use kiya jo humne pahle bnaya tha
		
		driver.get("https://www.saucedemo.com/cart.html");
		
		// 3. Cart Validation & CheckOut (CartPage)
		
		CartPage cp = new CartPage (driver);
		
		String item = cp.getItemName();
		
		Assert.assertEquals(item, "Sauce Labs Backpack", "Cart mein galat item hai!");
		cp.clickCheckout();
		
		//4. Enter Shipping details (CheckOutStepOnepage)
		
		CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
		stepOne.enterShippingDetails("Rahul", "Sharma", "452001");
		
		//5. final finifh (checkoutSteoTwoPage)
		
		CheckoutStepTwoPage steptwo = new CheckoutStepTwoPage(driver);
		steptwo.clickFinish();
		
		//6. Final validation 
		
		String finalMsg = steptwo.getSuccessMessage();
		
		Assert.assertEquals(finalMsg, "Thank you for your order!", "order unsuccessfully!");
		
		System.out.println("Badhai ho! END-to-END Tst Pass Ho Gya : Order placed Successfully!");
		
	}

}
