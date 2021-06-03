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
public class AddToCartPage extends BaseClass{

	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMsg;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToChkOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectQuantity(String qnty) {
		ActionDriver.type(quantity,qnty);
	}
	
	public void selectSize(String sz) {
		ActionDriver.selectByVisibleText(size, sz);
	}
	
	public void clickOnAddToCart() {
		ActionDriver.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddToCart() {
		ActionDriver.fluentWait(addToCartMsg, 10);
		return ActionDriver.isDisplayed(getDriver(), addToCartMsg);
	}
	
	public OrderPage clickOnProceedToChkOut() { 
		ActionDriver.fluentWait(proceedToChkOutBtn, 10);
		ActionDriver.jsClick(getDriver(), proceedToChkOutBtn);
		return new OrderPage();
	}
}
