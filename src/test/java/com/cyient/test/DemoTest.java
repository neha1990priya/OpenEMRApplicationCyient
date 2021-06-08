package com.cyient.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
  FileInputStream file = new FileInputStream("src/test/resources/data/OpenEMRData.xlsx");
  XSSFWorkbook book = new XSSFWorkbook(file);
  
  XSSFSheet sheet = book.getSheet("ValidCredentialTest");
  
  
  
  for(int r=0;r<3;r++) //Row
  {
	 // column
	  for(int c=0;c<4;c++) {
		  
		  
		  XSSFRow row = sheet.getRow(r);
		  
		  XSSFCell cell = row.getCell(c);
		  DataFormatter format = new DataFormatter();
		  String cellValue = format.formatCellValue(cell);
		  System.out.println(cellValue); 
	 }
  }
	}

}
