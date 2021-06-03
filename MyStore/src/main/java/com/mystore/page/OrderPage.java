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
public class OrderPage extends BaseClass {

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToChkOutBtn;
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String prodUnitPrice= unitPrice.getText();
		System.out.println("getUnitPrice()>>"+prodUnitPrice);
		prodUnitPrice=prodUnitPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(prodUnitPrice);
		System.out.println("getUnitPrice()>><<"+finalUnitPrice);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String prodTotalPrice= totalPrice.getText();
		System.out.println("getTotalPrice()>>"+prodTotalPrice);
		prodTotalPrice=prodTotalPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(prodTotalPrice);
		System.out.println("getTotalPrice()>><<"+finalTotalPrice);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnProceedToChkOut() {
		ActionDriver.click(getDriver(), proceedToChkOutBtn);
		return new LoginPage();
	}
	
}
