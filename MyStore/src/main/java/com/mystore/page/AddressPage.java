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
public class AddressPage extends BaseClass {

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToChkOutBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnProceedToChkOut() {
		ActionDriver.click(getDriver(), proceedToChkOutBtn);
		return new ShippingPage();
	}

}
