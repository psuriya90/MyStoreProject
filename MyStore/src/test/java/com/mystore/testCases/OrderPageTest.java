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
import com.mystore.page.OrderPage;
import com.mystore.page.SearchResultPage;
import com.mystore.utility.DataProviderUtility;

/**
 * @author Sys
 *
 */
public class OrderPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,groups="Regression",dataProvider="getProductDetails",dataProviderClass=DataProviderUtility.class)
	public void verifyProductPrice(String productName,String qnty,String size) {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectQuantity(qnty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnProceedToChkOut();
		double unitPrice=orderPage.getUnitPrice();
		System.out.println("verifyProductPrice()>>unitPrice<<"+unitPrice);
		double totalPrice=orderPage.getTotalPrice();
		System.out.println("verifyProductPrice()>>totalPrice<<"+totalPrice);
		double finalProductPrice = (unitPrice * Double.parseDouble(qnty)) + Double.parseDouble(prop.getProperty("shippingCharge"));
		System.out.println("verifyProductPrice()>>finalProductPrice<<"+finalProductPrice);
		Assert.assertEquals(totalPrice, finalProductPrice);
	}
	
	/*
	 * @Test(priority=1,groups="Regression") public void verifyProductPrice() {
	 * indexPage=new IndexPage();
	 * searchResultPage=indexPage.searchProduct(prop.getProperty("prodName"));
	 * addToCartPage=searchResultPage.clickOnProduct();
	 * addToCartPage.selectQuantity(prop.getProperty("quantity"));
	 * addToCartPage.selectSize(prop.getProperty("size"));
	 * addToCartPage.clickOnAddToCart();
	 * orderPage=addToCartPage.clickOnProceedToChkOut(); double
	 * unitPrice=orderPage.getUnitPrice();
	 * System.out.println("verifyProductPrice()>>unitPrice<<"+unitPrice); double
	 * totalPrice=orderPage.getTotalPrice();
	 * System.out.println("verifyProductPrice()>>totalPrice<<"+totalPrice); double
	 * finalProductPrice = (unitPrice *
	 * Double.parseDouble(prop.getProperty("quantity"))) +
	 * Double.parseDouble(prop.getProperty("shippingCharge"));
	 * System.out.println("verifyProductPrice()>>finalProductPrice<<"+
	 * finalProductPrice); Assert.assertEquals(totalPrice, finalProductPrice); }
	 */
}
