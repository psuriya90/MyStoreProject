/**
 * 
 */
package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.AccountCreationPage;
import com.mystore.page.HomePage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;

/**
 * @author Sys
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accntPage;
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,groups="Sanity")
	public void createNewAccount() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accntPage=loginPage.createNewAccnt(prop.getProperty("newEmail"));
		boolean flag=accntPage.validateCreateAccntPageTitle();
		Assert.assertTrue(flag);
	}
	

}
