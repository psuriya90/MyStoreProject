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
public class IndexPage extends BaseClass{
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
    WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		ActionDriver.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		boolean flag=ActionDriver.isDisplayed(getDriver(), logo);
		return flag;
	}
	
	public String getMyStoreTitle() {
		String title=getDriver().getTitle();
		return title;
	}
	
	public SearchResultPage searchProduct(String productName) {
		ActionDriver.type(searchBox,productName);
		ActionDriver.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}

}
