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
public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement prodResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean isProductAvailable() {
		return ActionDriver.isDisplayed(getDriver(), prodResult);
	}
	
	public AddToCartPage clickOnProduct() {
		ActionDriver.click(getDriver(), prodResult);
		return new AddToCartPage();
	}
	

}
