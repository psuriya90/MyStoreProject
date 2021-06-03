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
public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnPayment() {
		ActionDriver.click(getDriver(), payByBankWire);
		return new OrderSummaryPage();
	}
}
