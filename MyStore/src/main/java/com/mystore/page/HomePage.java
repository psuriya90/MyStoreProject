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
public class HomePage extends BaseClass {
	
	@FindBy(xpath="//a[@title='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistoryDetails;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);	
	}
	
	public boolean validateMyWishList() {
		return ActionDriver.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistoryDetails() {
		return ActionDriver.isDisplayed(getDriver(), orderHistoryDetails);
	}
	
	public String getCurrentUrl() {
		String homePageUrl=getDriver().getCurrentUrl();
		return homePageUrl;
	}

}
