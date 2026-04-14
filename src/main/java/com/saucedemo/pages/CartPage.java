package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//1. Locators find karna 
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(className="inventory_item_name")
	WebElement itemNameInCart;
	
	// 2. Actions
	public String getItemName() {
		return
		itemNameInCart.getText();
	}
	public void clickCheckout() {
		checkoutBtn.click();
	}

}
