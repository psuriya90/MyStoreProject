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
public class LoginPage extends BaseClass {
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(name="passwd")
	WebElement passWord;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccnt;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccntBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage loginFromSignIn(String uName,String pWord) {
		ActionDriver.type(userName, uName);
		ActionDriver.type(passWord, pWord);
		ActionDriver.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage loginFromOrder(String uName,String pWord) {
		ActionDriver.type(userName, uName);
		ActionDriver.type(passWord, pWord);
		ActionDriver.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccnt(String newEmail) {
		ActionDriver.type(emailForNewAccnt, newEmail);
		ActionDriver.click(getDriver(),createNewAccntBtn);
		return new AccountCreationPage();
	}
}
