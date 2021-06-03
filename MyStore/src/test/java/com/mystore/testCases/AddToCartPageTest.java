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
public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,groups={"Regression","Sanity"},dataProvider="getProductDetails",dataProviderClass=DataProviderUtility.class)
	public void clickOnProduct(String productName,String qnty,String size) {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectQuantity(qnty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean flag=addToCartPage.validateAddToCart();
		Assert.assertTrue(flag);
	}
	
	/*
	 * @Test(priority=1,groups={"Regression","Sanity"}) public void clickOnProduct()
	 * { indexPage=new IndexPage();
	 * searchResultPage=indexPage.searchProduct(prop.getProperty("prodName"));
	 * addToCartPage=searchResultPage.clickOnProduct();
	 * addToCartPage.selectQuantity(prop.getProperty("quantity"));
	 * addToCartPage.selectSize(prop.getProperty("size"));
	 * addToCartPage.clickOnAddToCart(); boolean
	 * flag=addToCartPage.validateAddToCart(); Assert.assertTrue(flag); }
	 */

}
