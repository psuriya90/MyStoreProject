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
import com.mystore.page.HomePage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;
import com.mystore.utility.DataProviderUtility;
import com.mystore.utility.Log;

/**
 * @author Sys
 *
 */
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
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
	
	@Test(priority=1,dataProvider="credentials",dataProviderClass=DataProviderUtility.class,groups={"Smoke","Sanity"})
	public void verifyLogin(String username,String password) {
		Log.startTestCase("verifyLogin");
		indexPage=new IndexPage();
		Log.info("User is going to click on signin");
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter Username and password");
		homePage=loginPage.loginFromSignIn(username,password);
		String actualUrl=homePage.getCurrentUrl();
		Log.info("Verifying whether user is able to login");
		Assert.assertEquals(actualUrl, prop.getProperty("homePageUrl"));
		Log.info("login is success");
		Log.endTestCase("verifyLogin");
	}
	
	/*
	 * @Test(priority=1) public void verifyLogin() {
	 * Log.startTestCase("verifyLogin"); indexPage=new IndexPage();
	 * Log.info("User is going to click on signin");
	 * loginPage=indexPage.clickOnSignIn(); Log.info("Enter Username and password");
	 * homePage=loginPage.loginFromSignIn(prop.getProperty("userName"),
	 * prop.getProperty("passWord")); String actualUrl=homePage.getCurrentUrl();
	 * Log.info("Verifying whether user is able to login");
	 * Assert.assertEquals(actualUrl, prop.getProperty("homePageUrl"));
	 * Log.info("login is success"); Log.endTestCase("verifyLogin"); }
	 * 
	 */

}
