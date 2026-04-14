package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
	
	WebDriver driver;
	
	public CheckoutStepOnePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators for the form
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement zipCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	// Action to fill the form 
	
	public void enterShippingDetails(String fname, String lname, String zip) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		zipCode.sendKeys(zip);
		continueBtn.click();
		
	}

}
