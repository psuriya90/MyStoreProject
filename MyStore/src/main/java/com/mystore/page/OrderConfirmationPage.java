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
public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//div/p/strong[text()='Your order on My Store is complete.']")
	WebElement orderConfirmMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateOrderConfirmationMsg() {
		String confirmMsg=orderConfirmMsg.getText();
		return confirmMsg;
	}
}
