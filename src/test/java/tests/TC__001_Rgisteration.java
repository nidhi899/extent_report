package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.BaseFeatures;
import com.mappls.map.features.TC__001_RegistrationFeature;
import com.mappls.map.features.TC__002_LoginFeature;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;


public class TC__001_Rgisteration extends DriverManager{
	//	3-18

	TC__001_RegistrationFeature   newUser;
	Actions ac;
	TC__002_LoginFeature lf;
	BaseFeatures bpf;
	
	
//	1-Verify that UI is proper in Welcome page	
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1) //done
	public void welcomPageRegster() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.isWelcomeVisible();
	}
		
//	2-Verify Register/Login screen flow	
//	Now there should be a single screen for login and register, if any account already exist with the entered mobile number or email id, then the password screen will be displayed next, and if it is not registered, then the registration page will be displayed.
	@Test(priority = 2) //done
	public void verifyLoginAndRegisterFlow() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.loginAndRegisterFlow();
	}
	
//	3-Verify that the user is able to register with new email	
//	User should be redirected to the Sign Up page to register
	@Test(priority = 3)
	public void registrationWithNewEmail() throws IOException, InterruptedException {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithNEmail();
	}
	
//	4-Verify that the user is not able to register with existing email	
//	If user enters already registered email, User should be directed to password page
	@Test(priority = 4)
	public void registrationWithExistingEmail() throws IOException, InterruptedException {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithExistingEmail();
	}
	
//	5-Verify that the user is not able to register with empty field	
//	The Continue button should not be highlighted till 2 characters are entered
	@Test(priority = 5) 
	public void newRegisterWithUserId() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.cntinueBtnTillTwoCharactr();
	}
	
//	6-NA/ Verify that the user is not able to register with invalid email id	 
//	Message should be displayed under the email text field. Toast Message: "Username doesn't Exist/Sign up with Mobile or Email"
	
	
//	7-Verify that the user is not able to register with empty field	
//	User should not be able to register with empty name field. A messsge should be displayed as "Enter Name" below the Name field
	@Test(priority = 6)
	public void newRegisterWithEmptyFields() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithEmptyFieldMsgWithEnterName();

		//		newUser.registerWithEmptyName();
	}  
	
//	8-Verify that the user is not able to register with name that is less than 3 characters	
//	The user should not be able to register with less than 3 characters name. A message should appear "Please enter atleast 3 character" below the name field and the text of the Continue button should change to "Please enter atleast 3 character name"
	@Test(priority = 7) 
	public void registerWithlessThanThreeCharacterName() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithInValidName();
	}
	
//	9-Verify that the user is able to set Password (including a capital letter and a special character)	
//	User should be able to set Password & Re Enter Password and open home page with a toast message "Login Successful" 
	@Test(priority = 8)
	public void registerWithStrongPsw() throws IOException, InterruptedException {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithNumber();

	}
	
//	10-Verify tapping on Skip and use maps as guest user	
//	User should be able to use the maps as a guest user
	@Test(priority = 9)	
	public void useMapGuestUser() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.guestUser();
	}
	
//	11-Verify that the user is able to register with new valid Mobile number	
//	User should be directed to Registration screen to register
	@Test(priority = 10)
	public void registerWithNewMobileNummber() throws IOException, InterruptedException {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithNumber();

	}
	
//	12-Verify that the user is not able to register with existing Mobile number	
//	User should be directed to the Password page
	@Test(priority = 11)
	public void registrationWithExistingMobile() throws IOException, InterruptedException {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithExistingEmail();
	}
	
	
//	13-Verify that the user is not able to register with 9 or 11 digit number	
//	Message should be displayed under the text field as. "Username doesn't Exist/Sign up with Mobile or Email"
	@Test(priority = 12)
	
	public void registerWithInvalidNumber() throws IOException, InterruptedException {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithInvalidNumber("98764539879");
	}
	
//	14-Verify that the user is not able to register with special character or invalid mobile number.	
//	Message should be displayed under the text field as. "Username doesn't Exist/Sign up with Mobile or Email"
	@Test(priority = 13)
	public void newRegisterWithInvalidUserId() {
		newUser = new TC__001_RegistrationFeature(driver);
		newUser.registerWithRandomCharacter();
	}
	
	
//	15-	NA/ Verify that the user is able to set Password (including a capital letter and a special character)	
//	"User should be able to set Password and open home page with a toast message
//	Toast message:- ""Login successful"""
	
	
//	16-Same as TC - 12 / Verify tapping on Skip and use maps as guest user	
//	User should be able to use the maps as a guest user
	
	
	
	
	
//	===========================================================



	
	
	
	//	============================================

	//	@Test(priority = 6)
	//	public void newRegisterAndDeleteAccount() {
	//		newUser = new TC__001_RegistrationFeature(driver);
	//		newUser.createNewAccountAndDelete();
	//	}




}




