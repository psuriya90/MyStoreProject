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
	
	HomePage homePage;
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement createAccntTitle;
	
	@FindBy(id="id_gender1")
	WebElement gender1;
	
	@FindBy(id="id_gender2")
	WebElement gender2;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="firstname")
	WebElement cfName;
	
	@FindBy(id="lastname")
	WebElement clName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement aliasAddress;
	
	@FindBy(id="submitAccount")
	WebElement registerBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createNewAccount(String gender,String fName,String lName,
			String pswd,String day,String month,String year,String cmpy,String address,String cty,
			String ste,String postalCode,String cntry,String mobileNum) {
		if(gender.equalsIgnoreCase("Mr.")) {
			ActionDriver.click(getDriver(), gender1);
		}else {
			ActionDriver.click(getDriver(), gender2);
		}
		ActionDriver.type(firstName, fName);
		ActionDriver.type(lastName, lName);
		ActionDriver.type(password, pswd);
		ActionDriver.selectByValue(days, day);
		ActionDriver.selectByIndex(months, Integer.valueOf(month));
		ActionDriver.selectByValue(years, year);
		//ActionDriver.type(cfName, fName);
		//ActionDriver.type(clName, lName);
		ActionDriver.type(company, cmpy);
		ActionDriver.type(address1, address);
		ActionDriver.type(city, cty);
		ActionDriver.selectByVisibleText(state, ste);
		ActionDriver.type(postcode, postalCode);
		ActionDriver.selectByVisibleText(country, cntry);
		ActionDriver.type(mobile, mobileNum);
		ActionDriver.type(aliasAddress, address);	
	}
	
	public HomePage clickOnRegister() {
		ActionDriver.click(getDriver(), registerBtn);
		return new HomePage();
	}
	
	public boolean validateCreateAccntPageTitle() {
		return ActionDriver.isDisplayed(getDriver(), createAccntTitle);
	}

}
