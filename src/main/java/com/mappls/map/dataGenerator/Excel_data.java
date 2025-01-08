package com.mappls.map.dataGenerator;

import org.testng.annotations.DataProvider;

public class Excel_data {
	

//	//user logged in by name------------------------------------------------------------------------------1
	@DataProvider(name = "username")
	public Object[][] getLoginDataWithName() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("name");
		Object[][] data = new Object[rowCount - 1][3];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("name", "Username", i);
			data[i - 2][1] = reader.getCellData("name", "Password", i);
			data[i - 2][2] = reader.getCellData("name", "credential", i);
		}
		return data;
	}
	
	//user login by number-----------------------------------------------------------------2
	@DataProvider(name = "number")
	public Object[][] getLoginDataWithNumber() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("number");
		Object[][] data = new Object[rowCount - 1][3];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("number", "Username", i);
			data[i - 2][1] = reader.getCellData("number", "Password", i);
			data[i - 2][2] = reader.getCellData("number", "credential", i);
		}
		return data;
	}


	//user login by email--------------------------------------------------------------------3
	@DataProvider(name = "email")
	public Object[][] getLoginDataWithInvalidEmail() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("email");
		Object[][] data = new Object[rowCount - 1][3];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("email", "Username", i);
			data[i - 2][1] = reader.getCellData("email", "Password", i);
			data[i - 2][2] = reader.getCellData("email", "credential", i);
		}
		return data;
	}
	
	//	//user login and logout -------------------------------------------------------------------------4
	@DataProvider(name = "loginLogout")
	public Object[][] getLoginData() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("login");
		Object[][] data = new Object[rowCount - 1][3];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("login", "Username", i);
			data[i - 2][1] = reader.getCellData("login", "Password", i);
			data[i - 2][2] = reader.getCellData("login", "credential", i);
		}
		return data;
	}


	//user login by invalid number------------------------------------------------------------------5
	@DataProvider(name = "invalidNumber")
	public Object[][] getLoginDataWithInvalidNumber() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("invalidnumber");
		Object[][] data = new Object[rowCount - 1][3];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("invalidnumber", "Username", i);
			data[i - 2][1] = reader.getCellData("invalidnumber", "Password", i);
			data[i - 2][2] = reader.getCellData("invalidnumber", "credential", i);
		}
		return data;
	}

	//user login by inavlid user name---------------------------------------------------------------------6
	@DataProvider(name = "invalidUserName")
	public Object[][] getLoginDataWithInvalidUsername() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("invalidname");
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("invalidname", "Username", i);
			data[i - 2][1] = reader.getCellData("invalidname", "Password", i);
		}
		return data;
	}


	//user login by inavlid user psw---------------------------------------------------------------------7
	@DataProvider(name = "invalidUserpsw")
	public Object[][] getLoginDataWithInvalidUserPsw() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("invalidpsw");
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("invalidpsw", "Username", i);
			data[i - 2][1] = reader.getCellData("invalidpsw", "Password", i);
		}
		return data;
	}

}
