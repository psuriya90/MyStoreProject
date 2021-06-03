/**
 * 
 */
package com.mystore.testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.AddToCartPage;
import com.mystore.page.AddressPage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;
import com.mystore.page.OrderConfirmationPage;
import com.mystore.page.OrderPage;
import com.mystore.page.OrderSummaryPage;
import com.mystore.page.PaymentPage;
import com.mystore.page.SearchResultPage;
import com.mystore.page.ShippingPage;
import com.mystore.utility.DataProviderUtility;
import com.mystore.utility.Log;

/**
 * @author Sys
 *
 */
public class OrderPurchasePageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,groups="Regression",dataProvider="getOrderDetails",dataProviderClass=DataProviderUtility.class)
	public void verifyProductPurchase(String uname,String pwd,String product,String qnty,String size) {
		indexPage=new IndexPage();
		Log.startTestCase("verifyProductPurchase");
		Log.info("Search product");
		searchResultPage=indexPage.searchProduct(product);
		Log.info("Select product");
		addToCartPage=searchResultPage.clickOnProduct();
		Log.info("Select quantity,size");
		addToCartPage.selectQuantity(qnty);
		addToCartPage.selectSize(size);
		Log.info("click on addtocart");
		addToCartPage.clickOnAddToCart();
		Log.info("click on checkout");
		orderPage=addToCartPage.clickOnProceedToChkOut();
		loginPage=orderPage.clickOnProceedToChkOut();
		Log.info("signin");
		addressPage=loginPage.loginFromOrder(uname, pwd);
		shippingPage=addressPage.clickOnProceedToChkOut();
		shippingPage.clickOnTerms();
		paymentPage=shippingPage.clickOnProceedToChkOut();
		Log.info("Payment process");
		orderSummaryPage=paymentPage.clickOnPayment();
		orderConfirmationPage=orderSummaryPage.clickOnConfirmOrder();
		Log.info("Confirm order");
		String actualMsg=orderConfirmationPage.validateOrderConfirmationMsg();
		Log.info("Confirm order msg"+actualMsg);
		Assert.assertEquals(actualMsg, prop.getProperty("orderConfirmationMsg"));
		Log.endTestCase("verifyProductPurchase");
	}

	
	/*
	 * @Test(priority=1,groups="Regression") public void verifyProductPurchase() {
	 * indexPage=new IndexPage();
	 * searchResultPage=indexPage.searchProduct(prop.getProperty("prodName"));
	 * addToCartPage=searchResultPage.clickOnProduct();
	 * addToCartPage.selectQuantity(prop.getProperty("quantity"));
	 * addToCartPage.selectSize(prop.getProperty("size"));
	 * addToCartPage.clickOnAddToCart();
	 * orderPage=addToCartPage.clickOnProceedToChkOut();
	 * loginPage=orderPage.clickOnProceedToChkOut();
	 * addressPage=loginPage.loginFromOrder(prop.getProperty("userName"),
	 * prop.getProperty("passWord"));
	 * shippingPage=addressPage.clickOnProceedToChkOut();
	 * shippingPage.clickOnTerms();
	 * paymentPage=shippingPage.clickOnProceedToChkOut();
	 * orderSummaryPage=paymentPage.clickOnPayment();
	 * orderConfirmationPage=orderSummaryPage.clickOnConfirmOrder(); String
	 * actualMsg=orderConfirmationPage.validateOrderConfirmationMsg();
	 * Assert.assertEquals(actualMsg, prop.getProperty("orderConfirmationMsg")); }
	 */

}
