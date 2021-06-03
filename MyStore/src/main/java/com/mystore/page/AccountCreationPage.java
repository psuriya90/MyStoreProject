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
public class AccountCreationPage extends BaseClass {
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement createAccntTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateCreateAccntPageTitle() {
		return ActionDriver.isDisplayed(getDriver(), createAccntTitle);
	}

}
