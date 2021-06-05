/**
 * 
 */
package com.mystore.testCases;

import java.util.HashMap;

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
import com.mystore.utility.DataProviderUtility;
import com.mystore.utility.Log;

/**
 * @author Sys
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accntPage;
	HomePage homePage;
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,groups="Sanity",dataProvider="getCreateAccountDetails",dataProviderClass=DataProviderUtility.class)
	public void createAccount(HashMap<String,String> hMap) {
		indexPage=new IndexPage(); 
		Log.startTestCase("createAccount()");
		Log.startTestCase("createAccount()>> Click on signin");
		loginPage=indexPage.clickOnSignIn();
		Log.startTestCase("createAccount()>> access data from excel"+hMap.get("Email"));
		accntPage=loginPage.createNewAccnt(hMap.get("Email"));
		accntPage.createNewAccount(hMap.get("Gender"),hMap.get("FirstName"),hMap.get("LastName"),
				hMap.get("Password"),hMap.get("Day"),hMap.get("Month"),
				hMap.get("Year"),hMap.get("Company"),hMap.get("Address"),
				hMap.get("City"),hMap.get("State"),hMap.get("PostalCode"),
				hMap.get("Country"),hMap.get("Mobile"));
		homePage=accntPage.clickOnRegister();
		String actualUrl=homePage.getCurrentUrl();
		Assert.assertEquals(actualUrl, prop.get("homePageUrl"));
	}
	
	/*
	 * @Test(priority=1,groups="Sanity") public void createNewAccount() {
	 * indexPage=new IndexPage(); loginPage=indexPage.clickOnSignIn();
	 * accntPage=loginPage.createNewAccnt(prop.getProperty("newEmail")); boolean
	 * flag=accntPage.validateCreateAccntPageTitle(); Assert.assertTrue(flag); }
	 */
	

}
