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

/**
 * @author Sys
 *
 */
public class HomePageTest extends BaseClass {

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
	
	@Test(priority=1,groups="Smoke",dataProvider="credentials",dataProviderClass=DataProviderUtility.class)
	public void verifyMyWishList(String username,String password) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.loginFromSignIn(username,password);
		boolean flag=homePage.validateMyWishList();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2,groups="Smoke",dataProvider="credentials",dataProviderClass=DataProviderUtility.class)
	public void verifyOrderHistoryDetails(String username,String password) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.loginFromSignIn(username,password);
		boolean flag=homePage.validateOrderHistoryDetails();
		Assert.assertTrue(flag);
	}
}
