package com.saucedemo.pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
	
	WebDriver driver;
	//1. Constructor: pageFactory initilie kaarne ke liye
	public InventoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	//2. Page Factory Locators (@FindBy)
	
	@FindBy(id ="add-to-cart-sauce-labs-backpack")
	WebElement addToCartBtn;
	
	@FindBy(className="shopping_cart_badge")
	WebElement cartBadge;
	
	@FindBy(className="product_sort_container")
	WebElement sortDropdown;
	
	@FindBy(xpath="//a[@href='https://twitter.com/saucelabs']")
	WebElement twitterIcon;
	
	
	//3. Action (Methods)
	
	public void addProductToCart() {
		addToCartBtn.click();
	}
	public String getCartCount() {
		return
		cartBadge.getText();
		
	}
	public void sortProductByPriceLowToHigh() {
		Select select = new Select(sortDropdown);
		// price low to high karne ke liye value use karenge
		
		select.selectByValue("lohi");
	}
	public void clickTwitter() {
		twitterIcon.click();
	}
	
	
	
}


//public class InventoryPage {
//	WebDriver driver;
//	// 1. Locators 
//	// Hum "Sauce Labs BackPack " ko add karenge 
//	
//	By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
//	By cartBadge = By.className("shopping_cart_badge");
//	By sortDropdown = By.className("product_sort_container");
//	By twitterIcon = By.xpath("//a[@href='https://twitter.com/saucelabs']");
//	
//	// 2. Constructor
//	
//	public InventoryPage(WebDriver driver) {
//		this.driver = driver;
//		
//	}
//	// 3. Actions
//	public void addProductToCart() {
//		driver.findElement(addToCartBtn).click();
//	}
//	
//	public String getCartCount() {
//		return driver.findElement(cartBadge).getText();
//	}
//	
//	public void sortProductByPriceLowToHigh() {
//		WebElement dropdownElement = driver.findElement(sortDropdown);
//		Select select = new Select(dropdownElement);
//		
//		// Price (low to high) select karne ke liye value use karenge 
//		
//		select.selectByValue("lohi");
//	}
//	
//	public void clickTwitter() {
//		driver.findElement(twitterIcon).click();
//	}
//}
