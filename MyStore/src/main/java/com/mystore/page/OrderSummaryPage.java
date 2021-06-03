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
public class OrderSummaryPage extends BaseClass {
	
	@FindBy(xpath="//button/span[text()='I confirm my order']")
	WebElement confirmBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrder() {
		ActionDriver.click(getDriver(), confirmBtn);
		return new OrderConfirmationPage();
	}

}
