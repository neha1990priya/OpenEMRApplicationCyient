package com.cyient.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	@DataProvider
	public Object[][] validCredentialExcelData()throws IOException {
		Object [][] main = ExcelUtils.getsheetIntoObjectArray("src/test/resources/data/OpenEMRData.xlsx","ValidCredentialTest");
	return main;
	}

	@DataProvider
	public Object[][] validCredential(){
		
		Object[][] main = new Object[3][4];
		
		main[0][0] = "admin";
		main[0][1] = "pass";
		main[0][2] = "English(Indian)";
		main[0][3] = "OpenEMR";
		
		main[1][0] = "physician";
		main[1][1] = "physician";
		main[1][2] = "English(Indian)";
		main[1][3] = "OpenEMR";
		
		main[2][0] = "accountant";
		main[2][1] = "accountant";
		main[2][2] = "English(Indian)";
		main[2][3] = "OpenEMR";
		
		return main;
		
	}
	
	@DataProvider
	public Object[][] invalidCredentialData(){
		Object[][] main = new Object[2][4];
		
		main[0][0] = "jhon";
		main[0][1] = "jhon123";
		main[0][2] = "Dutch";
		main[0][3] = "Invalid username and password";
		
		main[1][0] = "peter";
		main[1][1] = "peter123";
		main[1][2] = "German";
		main[1][3] = "Invalid username and password";
		
		
		return main;
		
	}
	
	
}
