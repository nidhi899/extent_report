package tests;


import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__003_ForgotPswFeature;
import com.mappls.map.utils.DriverManager;

public class TC__003_ForgotPsw extends DriverManager{
	
	
	
	
//37-54
	TC__003_ForgotPswFeature fpsw;
	

	
//	Verify that UI is proper in Forgot Password page	
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1)
	public void forgotPswUIVerification() {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.forgotPswUI();
	}
	
	
//	Verify that the Forgot Password button is clickable.	
//	On clicking on the Forgot Password user should be directed to the Forgot Password Page
	@Test(priority = 2)
	public void isFPClickable() {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.forgotPswLinkVerification();
	}
	
	
	
//	Verify resetting with valid mobile number	
//	User should be redirected to OTP screen and the OTP should be received in SMS
//	@Test(priority = 3)  hold
	public void resetWithMobileNumber() throws MalformedURLException {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.resetWithValidMobile();
	}
	
//	Verify resetting with invalid mobile number	
//	Message: "Please enter a valid emai/phone number."
	@Test(priority = 3) 
	public void resettingWithInValidMobile() {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.resetWithInvalidMobile();
	}
	
//	Verify the users are able to click on Sign In link on the screen	
//	Sign In link should be clickable and open login page
	@Test(priority = 4)
	public void isSignInBtnClickableWithMobile() {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.isSignInClickable();
	}
	

//	Verify that the user is able to get resend OTP link after 10 min  if user has not enter any otp	
//	Resend OTP should be came after 10 min  if user is not enter any opt on otp field,check that the updated otp should work.
//	@Test()  manual
	public void resendOTP() {
		fpsw = new TC__003_ForgotPswFeature(driver);
	}
	
//	Verify the Users are able to click on Reset button with valid mobile number	
//	Reset button should be clickable and redirected  OTP page
   @Test(priority = 5)
	public void resetBtnClickableWithValidMobile() {
	   fpsw = new TC__003_ForgotPswFeature(driver);
	   fpsw.isResetBtnClickable();
    }
	
	
//	Verify that the user is able to get OTP on same mobile number
//	OTP should be came on same mobile number
	@Test(priority = 6)
	public void otpSameMobile() throws MalformedURLException {
		fpsw = new TC__003_ForgotPswFeature(driver);
		
		fpsw.isOTPSameMobile();
	}
	
	
//	Verify that the user is able to set Password with one upper case, one lower case, one special charater value and must be 8 value 
//	"Password should be confirmed after re-entering the Password on confirm field .
//	Thank you page should be open with a message and continue to login button
//	message:-""Your Password has been changed successfully"""
//	@Test(priority = 8) hold
	public void changePsw() {
		fpsw = new TC__003_ForgotPswFeature(driver);
	}
	
	
//	Verify that the user is able to click on continue to login button	
//	"Continue to login button should be clickable and open login page"
//	@Test(priority = 10) hold
	public void isLoginBtnClickable() {
		fpsw = new TC__003_ForgotPswFeature(driver);
	}
	
//	Verify that the user is not able to login with old Password	
//	User should be able to login with new Password only
//	@Test(priority = 11)  hold
	public void loginWithOldPsw() {
		fpsw = new TC__003_ForgotPswFeature(driver);
	}
	
//	Verify resetting with valid email ID
//	User should be redirected to OTP screen and the OTP should be received in mail
	@Test(priority = 7)
	public void resetingWithValidMail() throws MalformedURLException {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.resetWithEmail();
	}
	
	
//	Verify the users are able to click on Sign In link on the screen
//	Sign In link should be clickable and open login page
	@Test(priority = 8) 
	public void isSignInBtnClickableWithMail() {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.isSignInClickableEmail();
	}
	
	
//	Verify the Users are able to click on Reset button with valid email id	
//	Reset button should be clickable and redirected  OTP page
	@Test(priority = 9)
	public void isResetBtnClickableWithValidMail() {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.isResetBtnClickableMail();
	}
	
//	Verify that the user is able to get OTP on same email id	
//	OTP should be came on same email id
	@Test(priority = 10)
	public void getOTPSameEmailId() throws MalformedURLException {
		fpsw = new TC__003_ForgotPswFeature(driver);
		fpsw.resetWithEmail();
	}
	
	
//	Verify that the user is able to set Password with one upper case, one lower case, one special charater value and must be 8 value	
//	"Password should be confirmed after re-entering the Password on confirm field .
//	Thank you page should be open with a message and continue to login button
//	message:-""Your Password has been changed successfully"""
//	@Test(priority = 16) hold
	public void isUserSetPsw() {
		fpsw = new TC__003_ForgotPswFeature(driver);
	}
	
	
	
//	Verify that the user is able to click on continue to login button	
//	"Continue to login button should be clickable and open login page"
//	@Test(priority = 17) hold
	public void isUserClickContinueLoginBtn() {
		fpsw = new TC__003_ForgotPswFeature(driver);
	}
	
//	Verify that the user is not able to login with old Password	
//	User should be able to login with new Password only
//    @Test(priority = 18) hold
    public void isUserLoginWithOldPsw() {
    	fpsw = new TC__003_ForgotPswFeature(driver);
	}
}
