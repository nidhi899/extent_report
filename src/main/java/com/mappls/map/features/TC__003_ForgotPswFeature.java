package com.mappls.map.features;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__003_ForgotPswPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TC__003_ForgotPswFeature {

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__003_ForgotPswPage fp;
//	TC__001_RegistrationFeature nrp;

	public TC__003_ForgotPswFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		fp = new TC__003_ForgotPswPage(driver);
//		nrp = new TC__001_RegistrationFeature(driver);
				
	}
	
	public void forgotPswLinkClick() {
		Assert.assertEquals(fp.forgotPswLink.getText(), "Forgot Password?");
		Reporter.log("Forgot Password link is visible with text - 'Forgot Password?'", true);
	    fp.forgotPswLink.click();
	    
	    bf.visibilitys(fp.mapplsLogo);
	    Assert.assertTrue(fp.mapplsLogo.isDisplayed(), "Failed to redirect the next page");
	    Reporter.log("forgot password link clickable.", true);
	}
	//TC 1
	public void forgotPswUI() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("9835980977");
		bf.continueBTNClick();
		forgotPswLinkClick();
		
		Assert.assertEquals(fp.mapplsLogo.getText(), "logo");
		Reporter.log("mappls logo is visible", true);
		
		Assert.assertEquals(fp.mailOrMobileInputField.getText(), "Email / Mobile number");
		Reporter.log("Email / Mobile number input field is visible", true);
		
		
		
		
		
	}
	
	//TC 2
	public void forgotPswLinkVerification() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("9835980977");
		bf.continueBTNClick();
		forgotPswLinkClick();
		
	}
	
	
	//TC 3
	public void resetWithValidMobile() throws MalformedURLException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("7870194441");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.resetBtn.click();
//		bf.appLaunched("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.ConversationListActivity");
		
		
		
		DesiredCapabilities	caps = new DesiredCapabilities();
		caps.setCapability("udid", "0002203R600009E8");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

        // Initialize AndroidDriver
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        


		
		TC__003_ForgotPswPage fp = new TC__003_ForgotPswPage(driver);

		
//		String otp = fp.msgList.get(0).getText();
		
		bf.visibilitys(fp.mapplsMsg);
		
		 String otpMessage = fp.msgList.get(0).getText();

	        // Define the regex pattern to match the OTP (6 digits)
	        Pattern pattern = Pattern.compile("\\d{6}");
	        Matcher matcher = pattern.matcher(otpMessage);

	        // Check if the pattern matches and print the OTP
	        if (matcher.find()) {
	            String otp = matcher.group();
	            System.out.println("OTP: "+otp);  // This will print only '******'
	            driver.navigate().back();
//	            driver.navigate().back();
	            bf.visibilitys(fp.enterOTP);
	            
	            fp.enterOTP.click();
	            
	            bf.sleepWait(3);
	            bf.visibilitys(fp.enterOtpField);
	            Assert.assertTrue(fp.enterOtpField.isDisplayed(),"not display");
	            fp.enterOtpField.click();
	            fp.enterOtpField.sendKeys("1");
	            
	            fp.verifyOtp.click();
	            
	            fp.password.sendKeys("Mmi@1234");
	            fp.confirmPsw.sendKeys("Mmi@1234");
	            
	            fp.submitBtn.click();
	            
	            fp.pswNotSave.click();
	            
	            Assert.assertEquals(fp.pswChanged.getText(), "Your password has been changed successfully.");
	            
	            
	            
	        
	        } else {
	            System.out.println("OTP not found");
	        }
		
		
		
	}
	
	
	//TC 4
	public void resetWithInvalidMobile() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("7870194441");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.getMobileTxt.clear();
		fp.getMobileTxt.sendKeys("990555545s");
		
		fp.resetBtn.click();
		
		Assert.assertEquals(fp.alrtMsg.getText(), "Please enter a valid email / phone number");
	}
	
	public void isSignInClickable() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("7870194441");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.signInLink.click();
		
		Assert.assertEquals(bp.headerTitle.getText(), "Welcome");
		Reporter.log("Welcome text is visible", true);
		
		
	}
	
	public void isResetBtnClickable() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("7870194441");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.resetBtn.click();
		
		Assert.assertEquals(fp.resetClickNxtPage.getText(), "Enter One Time Password");
		Reporter.log("reset button is clickable ", true);
		
		
	}
	
	
	
	public void isOTPSameMobile() throws MalformedURLException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("7870194441");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.resetBtn.click();
//		bf.appLaunched("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.ConversationListActivity");
		
		
		
		DesiredCapabilities	caps = new DesiredCapabilities();
		caps.setCapability("udid", "0002203R600009E8");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

        // Initialize AndroidDriver
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        


		
		TC__003_ForgotPswPage fp = new TC__003_ForgotPswPage(driver);

		
//		String otp = fp.msgList.get(0).getText();
		
		bf.visibilitys(fp.mapplsMsg);
		
		 Assert.assertTrue(fp.mapplsMsg.isDisplayed(),"Failed to get OTP on same Mobile number");
         
		
		 String otpMessage = fp.msgList.get(0).getText();

		 Reporter.log(otpMessage,true);
	       

	       
	}
	
	
	public void resetWithEmail() throws MalformedURLException {
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("nidhi@mapmyindia.com");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.resetBtn.click();
//		bf.appLaunched("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.ConversationListActivity");
		
		
		
		DesiredCapabilities	caps = new DesiredCapabilities();
		caps.setCapability("udid", "0002203R600009E8");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("appPackage", "com.google.android.gm");
		caps.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

        // Initialize AndroidDriver
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        


		
		TC__003_ForgotPswPage fp = new TC__003_ForgotPswPage(driver);

		//mail
		fp.gotItClick.click();
		bf.visibilitys(fp.mailUserName);
		fp.takeToMeClick.click();
		
		fp.closeDesc.click();
		
		bf.visibilitys(fp.mailMapplsApp);
		
//		fp.mailMapplsApp.click();
		
		String otpMsg = fp.mailMsg.get(0).getText();
		
		System.out.println(otpMsg);
		
		
    }

	
	public void isSignInClickableEmail() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("nidhi@mapmyindia.com");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.signInLink.click();
		
		Assert.assertEquals(bp.headerTitle.getText(), "Welcome");
		Reporter.log("Welcome text is visible", true);
		
		
	}
	
	
	public void isResetBtnClickableMail() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.enterUname("nidhi@mapmyindia.com");
		bf.continueBTNClick();
		
		forgotPswLinkClick();
		
		fp.resetBtn.click();
		
		Assert.assertEquals(fp.resetClickNxtPage.getText(), "Enter One Time Password");
		Reporter.log("reset button is clickable ", true);
		
		
	}
   

	
	
}
