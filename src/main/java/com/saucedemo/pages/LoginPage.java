package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver driver;
	
	//1. Constructor mein PageFactory ko initialie karna 
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		// Yeh line magic hai, ye saare @FindBy elements ko active kar deti hai
		
		PageFactory.initElements(driver, this);
	}
	//2. Modern Locators (Annotations)
	
	@FindBy(id ="user-name")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	//3. Method (Ab driver.find ki jarurat nhi)
	
	public void enterUsername(String user) {
		usernameField.sendKeys(user);
	}
	public void enterPassword(String pass) {
		passwordField.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}

	
}

//public class LoginPage {
//	
//	WebDriver driver;
//	
//	// 1. Locators (username, Password, Login Button)
//	
//	By usernameField = By.id("user-name");
//	
//	By passwordField = By.id("password");
//	
//	By loginButton = By.id("login-button");
//	
//	// 2. Constructor (Driver ko initialie karne ke liye)
//	
//	public LoginPage(WebDriver driver) {
//		
//		this.driver = driver;
//	}
//	
//	// 3. Method (Actions jo hum page par karenge)
//	
//	public void enterUsername(String user) {
//		
//		driver.findElement(usernameField).sendKeys(user);
//	}
//	
//	public void enterPassword(String pass) {
//		driver.findElement(passwordField).sendKeys(pass);
//	}
//	
//	public void clickLogin() {
//		driver.findElement(loginButton).click(); 
//	}
//}
//
