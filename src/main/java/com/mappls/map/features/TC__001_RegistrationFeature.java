package com.mappls.map.features;

import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__001_RegistrationPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__001_RegistrationFeature {


	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__001_RegistrationPage nrp;


	public TC__001_RegistrationFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		nrp = new TC__001_RegistrationPage(driver);
	}



	//	===============tc - 1
	//	Verify that UI is proper in Welcome page
	public void isWelcomeVisible() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		Assert.assertEquals(bp.headerTitle.getText(), "Welcome");
		Reporter.log("Welcome text is visible", true);

		Assert.assertEquals(bp.headerSubTitle.getText(), "Login/Sign Up to manage your account   ");
		Reporter.log("'Login/Sign Up to manage your account' text is visible", true);


		Assert.assertEquals(bp.headerSkipBtn.getText(), "SKIP");
		Reporter.log("Skip button is visible", true);

		Assert.assertEquals(bp.userName.getText(), "Email/Phone Number/ Username");
		Reporter.log("'Email/Phone Number/ Username' text is visible in input field", true);

		Assert.assertEquals(bp.continueBTN.getText(), "Continue");
		Reporter.log("Continue button is present", true);

	}



	//	==============tc-2
	//	Verify Register/Login screen flow
	public void loginAndRegisterFlow() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("9934450244"); //new user
		Reporter.log("proceed with new mobile number", true);
		bf.continueBTNClick();

		bf.visibilitys(nrp.enterNewName);
		Assert.assertEquals(bp.headerTitle.getText(), "Sign Up");
		Reporter.log("registration page is diplayed", true);

		bp.skipBTN.click();

		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		Assert.assertEquals(bp.headerTitle.getText(), "Welcome");
		Reporter.log("Skip button clicked", true);

		//proceed with already existing mobile number 
		bp.userName.clear();
		bf.enterUname("nidhi1234");
		Reporter.log("Proceed with existing user id ");
		bf.continueBTNClick();

		bf.visibilitys(bp.enterpsw);
		Assert.assertEquals(bp.headerSubTitle.getText(), "Enter password to Login");
		Reporter.log("Enter password to Login text is display ", true);

	}

	public void registerWithNEmail() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("43212nidhikumari@gmail.com"); //new user
		Reporter.log("proceed with new new email id ", true);
		bf.continueBTNClick();

		bf.visibilitys(nrp.enterNewName);
		Assert.assertEquals(bp.headerTitle.getText(), "Sign Up");
		Reporter.log("registration page is diplayed", true);
	}

	public void registerWithExistingEmail() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("nidhi@mapmyindia.com"); //new user
		Reporter.log("proceed with new existing email id ", true);
		bf.continueBTNClick();

		bf.visibilitys(bp.enterpsw);
		Assert.assertEquals(bp.headerSubTitle.getText(), "Enter password to Login");
		Reporter.log("Enter password to Login text is display ", true);

	}
	
	public void registerWithExistingMobile() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("9835980977"); //new user
		Reporter.log("proceed with new existing mobile", true);
		bf.continueBTNClick();

		bf.visibilitys(bp.enterpsw);
		Assert.assertEquals(bp.headerSubTitle.getText(), "Enter password to Login");
		Reporter.log("Enter password to Login text is display ", true);

	}






	//		invalid mail tc - 6
	public void invalidMail() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("nidhi@gmail.come.gma.nidhi"); //new user
		Reporter.log("proceed with new invalid email id ", true);
		bf.continueBTNClick();


		bf.sleepWait(20);
		//			bf.visibilitys(nrp.enterNewName);
		bf.toastMsg("Username doesn't Exist/Sign up with Mobile or Email");

	}

	//test-8 new user register with two character name	
	public void registerWithInValidName() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(rmMobileNumber);
		bf.regstrContinueBTNClick();
		enterUserFullName("mn");    

		nrp.continueBtnTxt.click();
		String cntinueTxt = nrp.continueBtnTxt.getText();
		Assert.assertEquals(cntinueTxt, "Name should be of at least 3 characters");
		Reporter.log("Name should be of at least 3 characters",true);
	}


	
	//	tc-7

	//TC-1 with number 
	public void registerWithNumber() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();
		String rmName = RandomDataGenerator.generateRandomName();
		String rmPassword = RandomDataGenerator.generateRandomPassword();
		registerWithNumber(rmMobileNumber,rmName,rmPassword);
		newUserValidation(rmName, rmPassword);
	}
	
	
//	   tc- 8
	public void guestUser() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("9934450244"); //new user
		Reporter.log("proceed with new mobile number", true);
		bf.continueBTNClick();

		bf.visibilitys(nrp.enterNewName);
		Assert.assertEquals(bp.headerTitle.getText(), "Sign Up");
		Reporter.log("registration page is diplayed", true);

		bp.skipBTN.click();
		
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
		Reporter.log("guest user verified", true);
	}


	//	=================================================

	public void registerWithCntctNum() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(null);
	}

	public void enterUserFullName(String fullname) {
		bf.visibilitys(nrp.enterUserFullName);
		nrp.enterUserFullName.sendKeys(fullname);
		Reporter.log("Entered full name: " + fullname, true); 

	}

	public void enterPsw(String psw) {
		bf.visibilitys(nrp.enterPsw);
		nrp.enterPsw.sendKeys(psw);
		Reporter.log("Entered password : " + psw, true);
	}

	public void enterCNPsw(String cnpsw) {
		bf.visibilitys(nrp.reEnterPsw);
		nrp.reEnterPsw.sendKeys(cnpsw);
		Reporter.log("Confirmed password - " + "'" + cnpsw + "'", true);

	}

	public void registerContinueBtn() {
		//        bf.visibilitys(nrp.continueBtn);
		Assert.assertTrue(nrp.continueBtn.isDisplayed(),"Failed");
		nrp.continueBtn.click();
		Reporter.log("Continue button clicked.", true);
		bf.sleepWait(5);

		  String message = "Sign Up Successful. \nYour account will be verified later.";

		  // Remove extra spaces (if needed, but in this case, it seems you want to keep the line break)
		  String cleanedMessage = message.trim();
		
		bf.toastMsg(cleanedMessage);
	}

	public void skipBTNHandle() {    
		bf.visibilitys(nrp.skipBtn);
		Assert.assertTrue(nrp.skipBtn.isDisplayed(), "Failed");
		nrp.skipBtn.click();
		Reporter.log("Clicked 'skip'", true);
	}    

	//validation
	public void newUserValidation(String credential, String psw) {
		bf.Hamburgerclick();
		Assert.assertTrue(nrp.hmUName.getText().equalsIgnoreCase(credential),"User name mismatch");
		bf.sleepWait(3);
		bf.loginbtnHamburgerclick();
//		bf.isUserPrVisible();
		bf.isElementDisplay(bp.isUserProfileVisible, "after registeration user details ");
		bf.ProfileEditIconclick();
		String uname = bp.loginUName.getText();
		String uemail = bp.loginUMail.getText();
		String umobile = bp.loginUNumber.getText();
		boolean credentialMatched = credential.equals(uname) || credential.equals(uemail) || credential.equals(umobile);
		Assert.assertTrue(credentialMatched , "Username mismatched");
		Reporter.log("register and verification successffuly " , true);
		bf.sleepWait(4);
	}

	//validation
	public void registerWithNumber(String userContactNo, String fullName, String psw) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(userContactNo);
		//        bf.continueBTNClick();
		bf.regstrContinueBTNClick();
		enterUserFullName(fullName);    
		enterPsw(psw);
		bf.back();
		enterCNPsw(psw);
		registerContinueBtn(); 
		
		
	}

	

	//TC-2 with mail
	public void registerWithEmail() {
		String rmEmail = RandomDataGenerator.generateRandomEmail();
		String rmName = RandomDataGenerator.generateRandomName();
		String rmPassword = RandomDataGenerator.generateRandomPassword();
		registerWithNumber(rmEmail,rmName,rmPassword);
		skipBTNHandle();
		newUserValidation(rmName, rmPassword);

	}
	//TC-3 with In-valid number 
	public void registerWithInvalidNumber(String userContactNo) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(userContactNo);
		//        bf.continueBTNClick();
		bf.regstrContinueBTNClick();
		
		Assert.assertEquals(bp.headerTitle.getText(), "Welcome");
		Reporter.log("please enter a valid number", true);
//		if (nrp.continueBtnLocator.isDisplayed()) {
//			System.out.println("Invalid number");
//		} 
	}


	//TC-4 with with user-id or random number
	public void registerWithRmName() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("abcd");
		bf.regstrContinueBTNClick();
		boolean isvalid = bp.enterpsw.isDisplayed();
		Assert.assertTrue(isvalid, "Failed");
		Reporter.log("this user-id already exist", true);
	}
	
	public void cntinueBtnTillTwoCharactr() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(rmMobileNumber);
		bf.regstrContinueBTNClick();
		
		enterUserFullName("ni");
		Assert.assertEquals(nrp.enterFullNameTxt.getText(), "Full Name must be of at least 3 alphabets");
		Reporter.log("user is not able to register with 2 character",true);
	
		nrp.enterUserFullName.clear();
		
		enterUserFullName("nid");
		Assert.assertEquals(nrp.enterFullNameTxt.getText(), "Enter Password");
		Reporter.log("user is able to register with 3 character",true);
	
		
		
	}

	public void registerWithRandomCharacter() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();

		bf.enterUname("#@18900");
		bf.regstrContinueBTNClick();
		boolean inValid = bp.continueBTN.isDisplayed();
		Assert.assertTrue(inValid, "Failed");
		Reporter.log("please enter a valid number or email for new account creation", true);

	}


	public void accountDeleteBtn() {
		nrp.deleteAcount.click();
		Reporter.log("clicked ' Delete Account'",true);
		bf.sleepWait(3);
	}

	public void enterMailForDeletion(String name) {
		bf.visibilitys(nrp.enterMailForDltion);
		nrp.enterMailForDltion.sendKeys(name);
		Reporter.log("entered name",true);
		bf.sleepWait(3);
	}

	public void enterPswForDeletion(String psw) {
		nrp.enterPswForDltion.sendKeys(psw);
		Reporter.log("entered password",true);
		bf.sleepWait(3);
	}

	public void goAhead() {
		nrp.goAheadBtn.click();
		Reporter.log("clicked 'Go Ahead'",true);
		bf.sleepWait(3);
	}

	public void cancelDelete() {
		nrp.cancelDltBtn.click();
		Reporter.log("clicked ' don't delete'",true);
		bf.sleepWait(3);
	}

	public void newRegisterContinueBtn() {

		try {


			nrp.continueBtn.click();

			String buttonText = bp.continueBTN.getText();
			Reporter.log("Proceeded with Register continue button", true);

			if ("Error. Retry?".equals(buttonText)) {
				Reporter.log("Retrying...", true);
				nrp.continueBtn.click(); 
			} else if ("Loading".equals(buttonText)) {
				Reporter.log("Loading... Waiting for home page to appear.", true);

				while (!bp.hamburgerIconClick.isDisplayed()) {
					bf.sleepWait(1); 
				}
				Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Password field not displayed after 'Loading'");
			}
		} catch (Exception e) {
			Assert.assertTrue(false, "Failed"); 
		}
	}
	public void createNewAccountAndDelete() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();
		String rmName = RandomDataGenerator.generateRandomName();
		String rmPassword = RandomDataGenerator.generateRandomPassword();
		registerWithNumber(rmMobileNumber,rmName,rmPassword);
		newUserValidation(rmName, rmPassword);
		bf.back();
		bf.sleepWait(3);
		bf.back();
		bf.Hamburgerclick();
		bf.settingClick();
		bf.scrollUp(10);
		bf.accountClick();
		bf.othersClick();
		accountDeleteBtn();
		enterMailForDeletion(rmMobileNumber);
		bf.scrollUp(2);
		enterPswForDeletion(rmPassword);
		goAhead();

		bf.toastMsg("Deleted successfully");
		bf.sleepWait(3);
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed");
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(rmMobileNumber);
		bf.regstrContinueBTNClick();
		Assert.assertTrue(nrp.enterUserFullName.isDisplayed(),"Failed");
		Reporter.log("Account create and delete succefully", true);

	}



	//new test cases
	//test-7 new user register with empty name	
	public void registerWithEmptyName() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();
		//	        
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(rmMobileNumber);
		bf.regstrContinueBTNClick();
		enterUserFullName("");    

		String cntinueTxt = nrp.continueBtnTxt.getText();
		Assert.assertEquals(cntinueTxt, "Enter Full Name");
		Reporter.log("Full Name must be of at least 3 alphabets",true);
	}



	public void registerWithEmptyField() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(rmMobileNumber);
		bf.regstrContinueBTNClick();
		nrp.rgisterSkipBtn.click();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
		Reporter.log("user is able to use the maps as a guest user",true);
	}
	
	public void registerWithEmptyFieldMsgWithEnterName() {
		String rmMobileNumber = RandomDataGenerator.generateRandomMobileNumber();
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname(rmMobileNumber);
		bf.regstrContinueBTNClick();
		Assert.assertEquals(nrp.enterFullNameTxt.getText(), "Enter Full Name");
		Reporter.log("user is not able to register with empty field",true);
	
	}


}



