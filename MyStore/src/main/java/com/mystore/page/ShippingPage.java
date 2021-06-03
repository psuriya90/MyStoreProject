/**
 * 
 */
package com.mystore.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.action.ActionDriver;
import com.mystore.base.BaseClass;

/**
 * @author Sys
 *
 */
public class ShippingPage extends BaseClass {
	
	@FindBy(id="uniform-cgv")
	WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToChkOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnTerms() {
		ActionDriver.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToChkOut() {
		ActionDriver.click(getDriver(), proceedToChkOutBtn);
		return new PaymentPage();
	}
	

}
