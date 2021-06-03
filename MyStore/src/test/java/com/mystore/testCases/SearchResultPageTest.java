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
import com.mystore.page.AddToCartPage;
import com.mystore.page.IndexPage;
import com.mystore.page.SearchResultPage;
import com.mystore.utility.DataProviderUtility;

/**
 * @author Sys
 *
 */
public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,dataProvider="getProductName",dataProviderClass=DataProviderUtility.class)
	public void verifyProdAvailability(String productName) {
		indexPage=new IndexPage();
		System.out.println("Begins::verifyProdAvailability()");
		searchResultPage=indexPage.searchProduct(productName);
		boolean flag=searchResultPage.isProductAvailable();
		System.out.println("verifyProdAvailability()"+flag);
		Assert.assertTrue(flag);
	}
	
	/*
	 * @Test(priority=1,groups="Smoke") public void verifyProdAvailability( {
	 * indexPage=new IndexPage();
	 * searchResultPage=indexPage.searchProduct(prop.getProperty("prodName"));
	 * boolean flag=searchResultPage.isProductAvailable(); Assert.assertTrue(flag);
	 * }
	 */
	
}
