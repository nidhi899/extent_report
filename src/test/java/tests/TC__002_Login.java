package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.dataGenerator.Excel_data;
import com.mappls.map.features.BaseFeatures;
import com.mappls.map.features.TC__001_RegistrationFeature;
import com.mappls.map.features.TC__002_LoginFeature;
import com.mappls.map.utils.DriverManager;


public class TC__002_Login extends DriverManager {

	TC__002_LoginFeature lp;
	BaseFeatures bpf;
	TC__001_RegistrationFeature nrp;	


	// Verify that UI is proper in Login page
		// UI for all screen should be properly visible and function should work
		// properly
		@Test(priority = 1)
		public void loginUICheck() {
			nrp = new TC__001_RegistrationFeature(driver);
//			lp.verifyLognAndRgster();
			nrp.isWelcomeVisible();
		}

		// NA-Check the UI of the Login Page
		// Welcome should be written with Bold letters on the top left corner of the
		// page, Skip button should be on the top right corner. There Should be the
		// space to enter the Email/Phone Number/ Username. Just below it should be the
		// Continue button in Teal Color.

		// Verify Login/Register screen flow
		// Now there should be a single screen for login and register, if any account
		// already exist with the given mobile number or email id, then the password
		// screen will be displayed next, and if it is not registered, then the
		// registration page will be displayed.
		@Test(priority = 2)
		public void verifyLoginAndRegister() {
			lp = new TC__002_LoginFeature(driver);
			lp.verifyLognAndRgster();
		}

		// Verify tapping on Skip and use maps as guest
		// User should be able to use the maps as a guest user
		@Test(priority = 3)
		public void guestUser() {
			lp = new TC__002_LoginFeature(driver);
			lp.guestUser();
		}

		// Verify Login with valid credentials
		// "User should get logged in successfully
		// Toast Message: ""Login Successful"""
		@Test(dataProvider = "email", dataProviderClass = Excel_data.class, priority = 4)
		public void userLoginWithEmail(String username, String password, String credential)
				throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsUserLogin(new String[] { credential, username, password });
			lp.loginCredentialVerification(username);
		}

		// Verify Login with invalid mail id
		// "User should not be able to login and error message should be displayed as
		// ""Username doesn't Exist/Sign up with Mobile or Emai"""
		@Test(priority = 5)
		public void userLoginWithInvalidMail() {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsUserNonExistent("nidhi@gmail", "");
		}

		// Verify signing in with invalid Password (fnhgdhfmdchf)
		// The Login button will be turned to "Error. Retry?" and Toast Message will
		// appear as: "Invalid password, please re-enter and try again"
		@Test(priority = 6)
		public void userLoginWithValidNameInvalidPsw() {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsInvalidPSW("nidhi@mapmyindia.com", "123nN@hy");
		}

		// NA-Verify that the user is not able to Login with empty email id / phone
		// number/ username
		// The Continue button should not be highlighted till 2 characters or numbers
		// are entered

		// NA-Verify that the user is not able to Login with empty Password
		// The Login button should not be highlighted till 6 characters or numbers are
		// entered

		// NA - Verify that while typing Password , it shows *******
		// Password should be displayed as ***********

		// Verify tapping on Skip and use maps as guest user
		// User should be able to use the maps as a guest user (Login text is showing on
		// hamburger)
		@Test(priority = 7)
		public void guestUserHMLoginTxt() {
			lp = new TC__002_LoginFeature(driver);
			lp.gstUserAccessMap("nidhi@mapmyindia.com");
		}

		// Verify signing in with valid credentials
		// "User should get logged in successfully
		// Toast Message: ""Login successful"""
		@Test(dataProvider = "number", dataProviderClass = Excel_data.class, priority = 8)
		public void userLoginWithNumber(String username, String password, String credential)
				throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsUserLogin(new String[] { credential, username, password });
			lp.loginCredentialVerification(username);
		}

		// Verify signing in with invalid credentials
		// Toast Message: "Invalid password, please re-enter and try again"
		@Test(priority = 9)
		public void userLoginValidNumberInvalidPsw() throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsInvalidPSW("9835980977", "nnhhyy@e");
		}

		// Verify that the user is not able to Login with 9or 11 digit mobile number and
		// Password
		// "User should not be able to login and error message should be displayed as
		// ""Username doesn't Exist/Sign up with Mobile or Email"""
		@Test(priority = 10)
		public void userLoginWithInvalidMobile() throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsUserNonExistent("98359809777", "iounn");
		}

		// Verify that the user is not able to Login with special character in mobile
		// number and Password
		// "User should not be able to login and error message should be displayed as
		// ""Username doesn't Exist/Sign up with Mobile or Email"""
		@Test(priority = 11)
		public void userLohinWithInvalidPsw() throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsUserNonExistent("@985436", "psw99988@");
		}

		// Verify tapping on Skip and use maps as guest user
		// User should be able to use the maps as a guest user (Login text is showing on
		// hamburger)
		@Test(priority = 12)
		public void guestUserHMLoginTxtMobile() {
			lp = new TC__002_LoginFeature(driver);
			lp.gstUserAccessMap("9835980977");
		}

		// Verify signing in with valid Username
		// "User should get logged in successfully
		// Toast Message: ""Login Successful"""
		@Test(dataProvider = "username", dataProviderClass = Excel_data.class, priority = 13)
		public void userLoginWithUserId(String username, String password, String credential)
				throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsUserLogin(new String[] { credential, username, password });
			lp.loginCredentialVerification(username);
		}

		// Verify signing in with invalid credentials
		// Toast Message: "Invalid Password, please re-enter and try again"
		@Test(priority = 14)
		public void userLoginWithValidUserIdInvalidPsw() throws IOException, InterruptedException {
			lp = new TC__002_LoginFeature(driver);
			lp.mapplsInvalidPSW("nidhi1234", "psw99988@");
		}
	}