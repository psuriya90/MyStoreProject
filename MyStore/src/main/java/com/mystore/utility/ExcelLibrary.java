package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	 String path=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
	 public File file = null;
	 public FileInputStream fis = null;
	 public FileOutputStream fos = null;
	 private XSSFWorkbook workbook = null;
	 private XSSFSheet sheet = null;
	 private XSSFRow row = null;
	 private XSSFCell cell = null;
	
	public ExcelLibrary() {
		this.path=path;
		try {
			file=new File(path);
			fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ExcelLibrary(String path) {
		this.path=path;
		try {
			file=new File(path);
			fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//to get total row count
	public int getRowCount(String sheetName) {
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		System.out.println("getRowCount()::"+rowCount);
		return rowCount;
	}
	
	//to add a New work sheet
	public boolean createSheet(String sheetName){
		try {
			fos= new FileOutputStream(path);
			workbook.createSheet(sheetName);
			workbook.write(fos);
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//to remove a work sheet
	public boolean removeSheet(String sheetName) {
		
		int sheetIndex=workbook.getSheetIndex(sheetName);
		System.out.println("removeSheet():: "+sheetIndex);
		if(sheetIndex == -1) {
			return false;
		}
		try {
			workbook.removeSheetAt(sheetIndex);
			fos=new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//check whether sheet exists or not
	public boolean isSheetExist(String sheetName) {
		int sheetCnt=workbook.getSheetIndex(sheetName);
		System.out.println("isSheetExist()1:: "+sheetCnt);
		if(sheetCnt==-1) {
			sheetCnt=workbook.getSheetIndex(sheetName.toUpperCase());
			System.out.println("isSheetExist()2:: "+sheetCnt);
			if(sheetCnt==-1) {
				return false;
			}
			else {
				return true;
			}
		}else {
			return true;
		}
	}
	
	//to get a column count
	public int getColumnCount(String sheetName) {
		System.out.println("getColumnCount()1:: "+sheetName);
		if(!isSheetExist(sheetName))
			return -1;
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		if(row==null)
			return -1;
		int columnCnt=row.getLastCellNum();
		System.out.println("getColumnCount()2:: "+columnCnt);
		return columnCnt;
	}
	
	//add new column
	public boolean addColumn(String sheetName,String columnName) {
		try {
			fis=new FileInputStream(path);
			workbook= new XSSFWorkbook(fis);
			int sheetIndex=workbook.getSheetIndex(sheetName);
			System.out.println("addColumn()1:: "+sheetIndex);
			if(sheetIndex==-1)
				return false;
			sheet=workbook.getSheetAt(sheetIndex);
			row=sheet.getRow(0);
			if(row==null)
				row=sheet.createRow(0);
			if(row.getLastCellNum()==-1)
				cell=row.createCell(0);
			else
				cell=row.createCell(row.getLastCellNum());
			
			cell.setCellValue(columnName);
			System.out.println("addColumn()2:: ");
			fos=new FileOutputStream(path);
			workbook.write(fos);
			fos.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	//remove column
	public boolean removeColumn(String sheetName,int columnNum) {
		try {
			
			if(!isSheetExist(sheetName))
				return false;
			
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			int rowCnt=getRowCount(sheetName);
			System.out.println("removeColumn()1:: "+rowCnt);
			for(int i=1;i<=rowCnt;i++)
			{
				row=sheet.getRow(i);
				if(row!=null) {
					cell=row.getCell(columnNum);
					if(cell!=null)
						row.removeCell(cell);
				}
			}
			fos= new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
			System.out.println("removeColumn()2:: ");
			}catch(Exception e) {
				e.printStackTrace();
		}
		return true;
	}
	
	public String getCellData(String sheetName,String colName,int rowNum){
		   try{
		    if(rowNum <=0)
		     return "";
		   
		   int index = workbook.getSheetIndex(sheetName);
		   int col_Num=-1;
		   if(index==-1)
		    return "";
		   
		   sheet = workbook.getSheetAt(index);
		   row=sheet.getRow(0);
		   for(int i=0;i<row.getLastCellNum();i++){
		    //System.out.println(row.getCell(i).getStringCellValue().trim());
		    if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
		     col_Num=i;
		   }
		   if(col_Num==-1)
		    return "";
		   
		   sheet = workbook.getSheetAt(index);
		   row = sheet.getRow(rowNum-1);
		   if(row==null)
		    return "";
		   cell = row.getCell(col_Num);
		   
		   if(cell==null)
		    return "";
		   //System.out.println(cell.getCellType());
		   if(cell.getCellType().name().equals("STRING"))
		      return cell.getStringCellValue();
		   else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){
		      
		      String cellText  = String.valueOf(cell.getNumericCellValue());
		      if (HSSFDateUtil.isCellDateFormatted(cell)) {
		              // format in form of M/D/YY
		       double d = cell.getNumericCellValue();

		       Calendar cal =Calendar.getInstance();
		       cal.setTime(HSSFDateUtil.getJavaDate(d));
		               cellText =
		                (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		              cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                         cal.get(Calendar.MONTH)+1 + "/" + 
		                         cellText;
		              
		              //System.out.println(cellText);

		            }

		      
		      
		      return cellText;
		     }else if(cell.getCellType().name().equals("BLANK"))
		         return ""; 
		     else 
		      return String.valueOf(cell.getBooleanCellValue());
		   
		   }
		   catch(Exception e){
		    
		    e.printStackTrace();
		    return "row "+rowNum+" or column "+colName +" does not exist in xls";
		   }
		  }
		 
		  // returns the data from a cell
		  public String getCellData(String sheetName,int colNum,int rowNum){
		   try{
		    if(rowNum <=0)
		     return "";
		   
		   int index = workbook.getSheetIndex(sheetName);

		   if(index==-1)
		    return "";
		   
		  
		   sheet = workbook.getSheetAt(index);
		   row = sheet.getRow(rowNum-1);
		   if(row==null)
		    return "";
		   cell = row.getCell(colNum);
		   if(cell==null)
		    return "";
		   
		    if(cell.getCellType().name().equals("STRING"))
		     return cell.getStringCellValue();
		    else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){
		     
		     String cellText  = String.valueOf(cell.getNumericCellValue());
		     if (HSSFDateUtil.isCellDateFormatted(cell)) {
		             // format in form of M/D/YY
		      double d = cell.getNumericCellValue();

		      Calendar cal =Calendar.getInstance();
		      cal.setTime(HSSFDateUtil.getJavaDate(d));
		              cellText =
		               (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		             cellText = cal.get(Calendar.MONTH)+1 + "/" +
		                        cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                        cellText;
		             
		            // System.out.println(cellText);

		           }

		     
		     
		     return cellText;
		    }else if(cell.getCellType().name().equals("BLANK"))
		        return "";
		    else 
		     return String.valueOf(cell.getBooleanCellValue());
		   }
		   catch(Exception e){
		    
		    e.printStackTrace();
		    return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		   }
		  }
		  
		  // returns true if data is set successfully else false
		  public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		   try{
		   fis = new FileInputStream(path); 
		   workbook = new XSSFWorkbook(fis);

		   if(rowNum<=0)
		    return false;
		   
		   int index = workbook.getSheetIndex(sheetName);
		   int colNum=-1;
		   if(index==-1)
		    return false;
		   
		   
		   sheet = workbook.getSheetAt(index);
		   

		   row=sheet.getRow(0);
		   for(int i=0;i<row.getLastCellNum();i++){
		    //System.out.println(row.getCell(i).getStringCellValue().trim());
		    if(row.getCell(i).getStringCellValue().trim().equals(colName))
		     colNum=i;
		   }
		   if(colNum==-1)
		    return false;

		   sheet.autoSizeColumn(colNum); 
		   row = sheet.getRow(rowNum-1);
		   if (row == null)
		    row = sheet.createRow(rowNum-1);
		   
		   cell = row.getCell(colNum); 
		   if (cell == null)
		          cell = row.createCell(colNum);

		      // cell style
		      //CellStyle cs = workbook.createCellStyle();
		      //cs.setWrapText(true);
		      //cell.setCellStyle(cs);
		      cell.setCellValue(data);

		      fos = new FileOutputStream(path);

		   workbook.write(fos);

		   fos.close(); 

		   }
		   catch(Exception e){
		    e.printStackTrace();
		    return false;
		   }
		   return true;
		  }

}
