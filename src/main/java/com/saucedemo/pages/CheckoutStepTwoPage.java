package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage {
	WebDriver driver;
	public CheckoutStepTwoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="finish")
	WebElement finishBtn;
	
	@FindBy(className="complete-header")
	WebElement successMsg;
	
	public void clickFinish() {
		finishBtn.click();
	}
	public String getSuccessMessage() {
		return successMsg.getText();
	}

}
