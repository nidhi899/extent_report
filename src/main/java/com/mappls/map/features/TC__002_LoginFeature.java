package com.mappls.map.features;

import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__002_LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__002_LoginFeature {

	
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__002_LoginPage lp;

	public TC__002_LoginFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		lp = new TC__002_LoginPage(driver);
				
	}
	public void logOutYesButton() {
		driver.navigate().back();
		bf.sleepWait(2);
		driver.navigate().back();
		bf.Hamburgerclick();
		
		bf.settingClick();
		bf.accountClick();
		bf.logOutClick();
		bf.logOutYesClick();
		bf.loginTextView();
	}
	
	public void logOutNoButton() {
		bf.back();
		bf.back();
		bf.Hamburgerclick();
		bf.settingClick();
		bf.scrollUp(7);
		bf.accountClick();
		bf.logOutClick();
		bf.logOutNoClick();
		Assert.assertTrue(bp.logOut.isDisplayed(),"Failed");
		Reporter.log("cancel logout successful",true);
	}
	
	
	public void mapplsUserLogin(String[] rowData) {
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		String identifier = rowData[0];
		String credential = rowData[1];
		String psw = rowData[2];

		switch (identifier.toLowerCase()) {
		case "number":
			bp.userName.sendKeys(credential);

			if (!isValidPhoneNumber(credential)) {

				System.out.println("Invalid phone number format.");
				driver.navigate().back();
				return;
			}
			break;
		case "email":
			bp.userName.sendKeys(credential);
			if (!isValidEmail(credential)) {
				System.out.println("Invalid email format.");
				driver.navigate().back();
				return;
			}
			break;
		case "name":
			bp.userName.sendKeys(credential);
			bf.sleepWait(3);
			break;
		default:
			// Invalid identifier
			return;
		}
		bf.sleepWait(4);
		bf.continueBTNClick();
		bf.enterPsw(psw);
		bf.loginBTNClick();
		bf.toastMsg("Login Successful");
	}

	
	
	
	
	
	
	
	
	
	
	//login credentials verification
	public void loginCredentialVerification(String credential) {
		
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.ProfileEditIconclick();
		
		String uname = bp.loginUName.getText();
		String uemail = bp.loginUMail.getText();
		String umobile = bp.loginUNumber.getText();
		String userId = bp.loginUserId.getText();
		boolean credentialMatched = credential.equals(uname) || credential.equals(uemail) 
				|| credential.equals(umobile) || credential.equals(userId);
		Assert.assertTrue(credentialMatched , "Username mismatched");
		Reporter.log("Login and verification successfully " , true);
		
	}
	
	
	
	
	
	
	
	
	
	

	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return email != null && email.matches(emailRegex);
	}

	private boolean isValidPhoneNumber(String number) {
		return number != null && number.matches("^\\d{10}$");
	}

	//--non existent user-name-------------------------------------------------------------
	public void mapplsUserNonExistent(String username, String psw) {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bp.userName.sendKeys(username);
		System.out.println("enter user name : "+username);
		bp.continueLGBtn.click();
		System.out.println("click continue button");
		boolean isDisplay = bp.continueLGBtn.isDisplayed();
		Assert.assertTrue(isDisplay, "Test Case Failed ");
		System.out.println("invalid credential ");
	}

	//--non existent invalid password-------------------------------------------------------------
	public void mapplsInvalidPSW(String username, String psw) {
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		
		bp.userName.sendKeys(username);
		bp.continueLGBtn.click();
		bp.enterpsw.sendKeys(psw);
		bp.loginBTN .click();
		String msg = bp.toastMsg.getAttribute("name");
		System.out.println("Toast message: " + msg);
		Assert.assertEquals(msg, "Invalid password, please re-enter and try again");
        Reporter.log(msg, true);
		
		Assert.assertEquals(bp.loginBTN.getText(), "Error. Retry?");
	    Reporter.log(bp.loginBTN.getText(),true);
	}
	
	public void loginSkip() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.skipBtnClick();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to click Skip button.");
		Reporter.log("Login skip button working", true);
		
	}
	
	public void guestUser() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.skipBtnClick();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to click Skip button.");
		Reporter.log("Login skip button working", true);
		bf.visibilitys(bp.hamburgerIconClick);
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
		Reporter.log("Home Page display", true);
		
	}
	
	//new test cases
	public void gstUserAccessMap(String uname) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(uname);
		bf.skipBtnClick();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to click Skip button.");
		Reporter.log("Login skip button working", true);
		bf.visibilitys(bp.hamburgerIconClick);
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
		Reporter.log("Home Page display", true);
		
		bf.Hamburgerclick();
		
		Assert.assertEquals(bp.loginText.getText(), "Login");
		Reporter.log(bp.loginText.getText()+" text is visible", true);
		
	}
	
	public void guestUserLoginTxt() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.skipBtnClick();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to click Skip button.");
		Reporter.log("Login skip button working", true);
		bf.visibilitys(bp.hamburgerIconClick);
		bp.hamburgerIconClick.click();
		String lgnTxt = lp.loginTxt.getText();
		Assert.assertEquals(lgnTxt, "Login");
		Reporter.log("Login text is showing on hamburger",true);
		
		
	}

//	=======================new test cases 14th oct
	public void verifyLognAndRgster() {
		
		//mappls permission
		//hamburger click
		//login click
		//enter existing name and click continue
		//verify psw visibility
		//click skip
		//hamburger again click
		//login click 
		//enter new number (non existing) and click continue button
		//verify registration page visibility
		
		
		bf.mapplsPermissions();
		bp.hamburgerIconClick.click();
		bf.loginbtnHamburgerclick();
		Assert.assertEquals(bp.headerSubTitle.getText(), "Login/Sign Up to manage your account   ");
		Reporter.log("login verified ", true);
		
		bf.enterUname("nidhi1234");
		bf.continueBTNClick();
		bf.visibilitys(bp.loginBTN);
		Assert.assertEquals(bp.headerSubTitle.getText(), "Enter password to Login");
		Reporter.log("password field visible",true);
		
		bp.headerSkipBtn.click();
		bp.hamburgerIconClick.click();
		bf.loginbtnHamburgerclick();
		bf.enterUname("9932455607");
		bf.continueBTNClick();
		bf.visibilitys(lp.isRgistrPageVisible);
		Assert.assertEquals(bp.headerSubTitle.getText(), "Please provide details to create your account");
		Reporter.log("register page verified", true);
	}
}
