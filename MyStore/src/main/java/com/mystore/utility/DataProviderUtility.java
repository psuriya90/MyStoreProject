/**
 * 
 */
package com.mystore.utility;



import org.testng.annotations.DataProvider;

/**
 * @author Sys
 *
 */
public class DataProviderUtility {

	ExcelLibrary obj= new ExcelLibrary();
	
	@DataProvider(name="credentials")
	public Object[][] getCredentialsFromExcel(){
		int rows=obj.getRowCount("credentials");
		int columns=obj.getColumnCount("credentials");
		Object[][] data= new Object[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				data[i][j]=obj.getCellData("credentials", j, i+2);
			}
		}
		return data;
	}
	
	@DataProvider(name="getProductName")
	public Object[][] getProductNameFromExcel(){
		int rows=obj.getRowCount("searchproduct");
		System.out.println("getProductNameFromExcel()>>"+rows);
		int columns=obj.getColumnCount("searchproduct");
		System.out.println("getProductNameFromExcel()>><<"+columns);
		//int actualRows= rows-1;
		Object[][] data= new Object[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				data[i][j]=obj.getCellData("searchproduct", j, i+2);
				System.out.println("getProductNameFromExcel()>><<::"+data[i][j]);
			}
		}
		return data;
	}
	
	@DataProvider(name="getProductDetails")
	public Object[][] getProductDetailsFromExcel(){
		int rows=obj.getRowCount("productdetails");
		int columns=obj.getColumnCount("productdetails");
		//int actualRows= rows-1;
		Object[][] data= new Object[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				data[i][j]=obj.getCellData("productdetails", j, i+2);
			}
		}
		return data;
	}
	
	@DataProvider(name="getOrderDetails")
	public Object[][] getOrderDetailsFromExcel(){
		int rows=obj.getRowCount("OrderDetails");
		int columns=obj.getColumnCount("OrderDetails");
		//int actualRows= rows-1;
		Object[][] data= new Object[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				data[i][j]=obj.getCellData("OrderDetails", j, i+2);
			}
		}
		return data;
	}
}
