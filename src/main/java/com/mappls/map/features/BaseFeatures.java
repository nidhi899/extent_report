package com.mappls.map.features;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
//import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class BaseFeatures extends DriverManager {
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	Actions ac;
	WebDriverWait wait;

	
	public BaseFeatures(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;
		bp = new BasePage(driver);
		ac = new Actions();
		this.wait = new WebDriverWait(driver, 40);
		
//		 this.wait = new WebDriverWait(driver, Duration.ofMinutes(10));
	}

	public void scrollUp(int count) {
		ac = new Actions();
		for (int i = 0; i < count; i++) {
			sleepWait(1);
			ac.btmShtScrollUp();
		}
	}

	public void scrollDown(int count) {
    	ac = new Actions();
		for(int i=0; i<count; i++) {
			sleepWait(1);
			ac.scrollDown();
		}
    }
	
	public void scrollUpposts(int count) {
		ac = new Actions();
		for (int i = 0; i < count; i++) {
			sleepWait(1);
			ac.btmShtScrollUpPosts();
		}
	}

	public boolean visibilitys(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean visibilitys(List<WebElement> elements) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void clickOnMatchedPlace(String myplaceName) {
	    sleepWait(5);
	    for (int i = 0; i < bp.plcLst.size(); i++) {
	        WebElement place = bp.plcLst.get(i);
	        String placeText = place.getText();
	        System.out.println("places: " + placeText);

	        if (!visibilitys(bp.isAdrssVisble)) {
	            continue; 
	        }
	        
	        if (placeText.equalsIgnoreCase(myplaceName) && 
	            !placeText.equalsIgnoreCase("Your current location") && 
	            !placeText.equalsIgnoreCase("Choose On Map")) {
	            bp.plcLst.get(i).click(); 
	            break; // Exit loop after clicking the matched place
	        }
	    }
	}
	
	public void isElementDisplay(WebElement element, String msg) {
		boolean isElementFound = false;
		if(isElementVisible(element)) {
			isElementFound = true;
			Reporter.log(msg + "is present ", true);
		} 
		Assert.assertTrue(isElementFound, msg + "Element not found");
	}
	
	public void swipeUpUntilElementDisplayed(WebElement element, int maxSwipes) {
		boolean isElementFound = false;
		for (int i = 0; i < maxSwipes; i++) {
			if (isElementVisible(element)) {
//	            System.out.println("Element is displayed after " + (i + 1) + " swipes");
				isElementFound = true;
				break;
			} else {
				scrollUp(1);
				sleepWait(1);
			}
		}

		// Assert after all swipes
		Assert.assertTrue(isElementFound, "Element was not displayed");
	}

	public void swipeUpUntilElementDisplayedPosts(WebElement element, int maxSwipes) {
		boolean isElementFound = false;
		for (int i = 0; i < maxSwipes; i++) {
			if (isElementVisible(element)) {
//	            System.out.println("Element is displayed after " + (i + 1) + " swipes");
				isElementFound = true;
				break;
			} else {
				scrollUpposts(1);
				sleepWait(1);
			}
		}

		// Assert after all swipes
		Assert.assertTrue(isElementFound, "Element was not displayed");
	}

	//quick access menu scroll up 
	public void qcswipeUpUntilElementDisplayed(WebElement element, int maxSwipes) {
		sleepWait(4);
		boolean isElementDisplay = false;
		for (int i = 0; i < maxSwipes; i++) {
			sleepWait(4);
			if (isElementVisible(element)) {
				isElementDisplay = true;
				break;
			} else {
				scrollUp(1);  
				sleepWait(1);  
			}
		}
		
		for(int i=0; i<maxSwipes; i++ ) {
			sleepWait(3);
			if(isElementVisible(element)) {
				isElementDisplay = true;
				break;
			} else {
				scrollDown(1);
			}
		}
		
		Assert.assertTrue(isElementDisplay, "Element not found");
	}
	
	public void swipeDownUntilElementDisplayed(WebElement element, int maxSwipes) {
	    boolean isElementFound = false;
	    for (int i = 0; i < maxSwipes; i++) {
	        if (isElementVisible(element)) {
//	            System.out.println("Element is displayed after " + (i + 1) + " swipes");
	            isElementFound = true;
	            break;
	        } else {
	            scrollDown(1);  
	            sleepWait(1);  
	        }
	    }
	    
	    // Assert after all swipes
	    Assert.assertTrue(isElementFound, "Element was not displayed");
	}
	
	public boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void back() {
		driver.navigate().back();
		sleepWait(5);
	}

	public void longPress() {
		ac = new Actions();
		ac.longPress();
		sleepWait(4);
	}

	public void sleepWait(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepWaits(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sleepWait2(int sec) {
	    try {
	        Thread.sleep(sec * 1000L); // Convert seconds to milliseconds
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public void homeSearchClick() {
		visibilitys(bp.homeSearch);
		bp.homeSearch.click();
		Reporter.log("home search click", true);
	}

	public void homeSearchInputClick(String plc) {
		visibilitys(bp.homeSearchInput);
		bp.homeSearchInput.sendKeys(plc);
		Reporter.log("home search input : " + plc, true);
	}

	public void Hamburgerclick() {
		sleepWait(3);
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
		bp.hamburgerIconClick.click();
		Reporter.log("Clicked 'Hamburger Icon'", true);
	}

	public void loginbtnHamburgerclick() {
		visibilitys(bp.loginTextClick);
		bp.loginTextClick.click();
		Reporter.log("Clicked 'login' in hamburger menu", true);
	}

	public void clickLoginBtn() {
		visibilitys(bp.loginBTN);
		bp.loginBTN.click();
		Reporter.log("Login button clicked", true);
		toastMsg("Login Successful");
	}

	public void ProfileEditIconclick() {
		visibilitys(bp.loginEditBtn);
		bp.loginEditBtn.click();
		Reporter.log("Clicked 'edit profile icon'.", true);
	}

	public void settingClick() {
		visibilitys(bp.setting);
		bp.setting.click();
		Reporter.log("Clicked 'settings'", true);
	}

	public void accountClick() {
		swipeUpUntilElementDisplayed(bp.account, 5);
		Assert.assertTrue(bp.account.isDisplayed(), "Account is not visible");
		bp.account.click();
		Reporter.log("Clicked 'account'", true);
	}

	public void accountWithOutLoginClick() {
		visibilitys(bp.account);
		Assert.assertTrue(bp.account.isDisplayed(), "Account is not visible");
		bp.account.click();
		Assert.assertTrue(bp.account.isDisplayed(), "Failed");
		Reporter.log("login please", true);
	}

	public void changePSWClick() {
		visibilitys(bp.changePSW);
		bp.changePSW.click();
		Reporter.log("Clicked 'change password", true);
	}

	public void logOutClick() {
		visibilitys(bp.logOut);
		bp.logOut.click();
		Reporter.log("Clicked 'log out'", true);
	}

	public void logOutYesClick() {
		visibilitys(bp.logOutYes);
		bp.logOutYes.click();
		Reporter.log("Clicked 'Yes'", true);
	}

	public void logOutNoClick() {
		visibilitys(bp.logOutNo);
		bp.logOutNo.click();
		Reporter.log("Clicked 'No' for cancel logout", true);
	}

	public void loginTextView() {
		Hamburgerclick();
		Assert.assertTrue(bp.loginText.getText().contentEquals("Login"), "Failed to logout");
		Reporter.log("Logout successfully", true);
	}

	public void accountBackArrwClick() {
		visibilitys(bp.accountBackImage);
		bp.accountBackImage.click();
		Reporter.log("Clicked back arrow Icon in account page", true);
	}

	public void settingBackArrwClick() {
		visibilitys(bp.settingsBackImage);
		bp.settingsBackImage.click();
		Reporter.log("Clicked back arrow Icon in settings page", true);
	}

	public void loginUserTextView() {
		Hamburgerclick();
		String login_Text = bp.loginText.getText();
		Assert.assertFalse(login_Text.contentEquals("Login"), "Failed to cancel logout");
		Reporter.log("Canceled Logout successfully", true);
	}

	public void othersClick() {
		visibilitys(bp.others);
		bp.others.click();
		Reporter.log("Clicked 'others", true);
	}

	public void loginBTNMsg() {
		visibilitys(bp.loginBTNMsg);
		bp.loginBTNMsg.click();
		Reporter.log("Performing login credential", true);
	}

	public void enterUname(String username) {
		sleepWait(3);
		Assert.assertTrue(bp.userName.isDisplayed(), "Failed");
		bp.userName.sendKeys(username);
		Reporter.log("enter user name : " + username, true);
	}

	public void regstrContinueBTNClick() {
		visibilitys(bp.continueBTN);
		bp.continueBTN.click();
		Reporter.log("proceed with continue button", true);
		sleepWait(4);
	}

	public void continueBTNClick1() {
		try {
			visibilitys(bp.continueBTN);
			bp.continueBTN.click();
			sleepWait(1);
			String buttonText = bp.continueBTN.getText();
			Reporter.log("Proceeded with continue button", true);
			System.out.println("button - "+buttonText );

			if ("Error. Retry?".equals(buttonText)) {
				Reporter.log("Retrying...", true);
				bp.continueBTN.click(); 
			} else if ("Loading".equals(buttonText)) {
				Reporter.log("Loading... Waiting for password field to appear.", true);

				while (!bp.enterpsw.isDisplayed()) {
					sleepWait(1); 
				}
				Assert.assertTrue(bp.enterpsw.isDisplayed(), "Password field not displayed after 'Loading'");
			}
		} catch (Exception e) {
			Assert.assertTrue(false, "Failed"); 
		}
	}

	public void continueBTNClick() {
		try {
			visibilitys(bp.continueBTN);
			bp.continueBTN.click();
			sleepWait(1);
		} catch (Exception e) {

		}
	}

	public void enterPsw(String psw) {
		visibilitys(bp.enterpsw);
		bp.enterpsw.sendKeys(psw);
		Reporter.log("enter password name : " + psw, true);
	}

	public void loginBTNClick() {
		visibilitys(bp.loginBTN);
		bp.loginBTN.click();
		Reporter.log("proceed with login button", true);
	}

	public void skipBtnClick() {
		visibilitys(bp.skipBTN);
		bp.skipBTN.click();
		Reporter.log("Clicked 'Skip Button'", true);
	}

	public void toastMsg(String toastmsg) {
		String msg = bp.toastMsg.getAttribute("name");
		Reporter.log("Toast message: " + msg, true);
		Assert.assertEquals(msg, toastmsg);
	}

	// 2
	public void mySavesToastMsg(String toastmsg) {
		String msg = bp.mySavesToastMsg.getAttribute("name");
		Reporter.log("Toast message: " + msg, true);
		Assert.assertEquals(msg, toastmsg);
	}

	public void snackBarMessage(String msg) {
		String snackBarMsg = bp.snackBarMessage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg, true);
		Assert.assertEquals(snackBarMsg, msg);
	}

//	public void isUserPrVisible() {
//		if (bp.isUserProfileVisible.isDisplayed()) {
//			Assert.assertTrue(bp.isUserProfileVisible.isDisplayed(), "Failed");
//			Reporter.log("user profile visible", true);
//
//		} else if (bp.userName.isDisplayed()) { // user name input field, that means failed to logged in
//			Assert.assertFalse(bp.userName.isDisplayed(), "Failed");
//		}
//	}
	


	public void mapplsLogin(String username, String psw, String toastmsg) {
		loginBTNMsg();
		enterUname(username);
		continueBTNClick();
		enterPsw(psw);
		loginBTNClick();
		toastMsg(toastmsg);
	}

	public void simpleHamburgerLogin(String username, String psw, String toastmsg) {
		loginbtnHamburgerclick();
		enterUname(username);
		continueBTNClick();
		enterPsw(psw);
		loginBTNClick();
		toastMsg(toastmsg);
		sleepWait(3);
	}

	public void mapplsPermissions() {
		visibilitys(bp.whileUsingApp);
		bp.whileUsingApp.click();
//		visibilitys(bp.allow);
//		bp.allow.click();
	}
	
	public void mapplsPermissions2() {
//		visibilitys(bp.whileUsingApp);
		
		if(bp.whileUsingApp.isDisplayed()) {
			bp.whileUsingApp.click();
		}
//		bp.whileUsingApp.click();
//		if(bp.allow.isDisplayed()) {
//			bp.allow.click();
//		} 
		
	}

	public void loginCredentialVerification(String credential) {

		Hamburgerclick();
		loginbtnHamburgerclick();
		ProfileEditIconclick();
		String uname = bp.loginUName.getText();
		String uemail = bp.loginUMail.getText();
		String umobile = bp.loginUNumber.getText();
		boolean credentialMatched = credential.equals(uname) || credential.equals(uemail) || credential.equals(umobile);
		Assert.assertTrue(credentialMatched, "Username mismatched");
		Reporter.log("Login and verification successfully ", true);

	}

	public void appLaunched(String appPackage, String appActivity) throws MalformedURLException {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("udid", "0002203R600009E8");
			caps.setCapability("platformName", "Android");
			caps.setCapability("automationName", "uiautomator2");
			caps.setCapability("platformVersion", "14");
			caps.setCapability("appPackage", appPackage);
			caps.setCapability("appActivity", appActivity);

			URL url = URI.create("http://127.0.0.1:4723/").toURL();

			// Initialize AndroidDriver
			driver = new AndroidDriver<MobileElement>(url, caps);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("cause is : " + e.getCause());
			System.out.println("cause is : " + e.getMessage());
			e.printStackTrace();
		}

	}


//	public void deepLinkGchatShare() {
//
//        bp.gmailShare.click();
//        visibilitys(bp.gmailChat);
//        bp.gmailChat.click();
//        
//        
//        for (int i = 0; i < bp.gmailList.size(); i++) {
//            WebElement emailName = bp.gmailList.get(i);
//            String enTxt = emailName.getText();
//            if (enTxt.equalsIgnoreCase("nidhi@mapmyindia.com")) {
//                bp.gmailList.get(i).click(); 
//                break; 
//            }
//        }
////        =======
//        visibilitys(bp.gmailSendList);
//        for (int i = 0; i < bp.gmailSendList.size(); i++) {
//            WebElement emailSendName = bp.gmailSendList.get(i);
//            String senTxt = emailSendName.getText();
//            if (senTxt.equalsIgnoreCase("muskan.kumari@mapmyindia.com")) {
//                bp.gmailSendList.get(i).click(); 
//                break; 
//            }
//        }
//        String sendLink = bp.getLink.getText();
//        reader.setCellData("deeplink", "expected", 2, sendLink);
//        System.out.println("sended link : - " + sendLink);
//        
//            
//        sleepWait(3);
//        bp.postMsg.click();
//        
//        sleepWait(3);
//        
//        bp.clickSharedLink.click();
//        sleepWait(3);
//    }

//    public void deepLinkGmailShare() {
//        bp.gmailShare.click();
//        visibilitys(bp.gmailOnly);
//        bp.gmailOnly.click();
//        visibilitys(bp.fromMailId);
//        bp.fromMailId.click();
//        for (int i = 0; i < bp.fromMailIdList.size(); i++) {
//            WebElement fromMailId = bp.fromMailIdList.get(i);
//            String enTxt = fromMailId.getText();
//            if (enTxt.equalsIgnoreCase("nidhi@mapmyindia.com")) {
//                bp.fromMailIdList.get(i).click(); 
//                break; 
//            }
//        }
////        =======
//        sleepWait(3);
//        bp.toMailId.sendKeys("muskan.kumari@mapmyindia.com");
//        
//            
//        sleepWait(3);
//        bp.fromMailIdSendBtn.click();
//        
//        sleepWait(3);
//        back();
//        sleepWait(3);
//        bp.openGmail.click();
//        visibilitys(bp.gmailMenu);
//        bp.gmailMenu.click();
//        visibilitys(bp.gmailSentButton);
//        bp.gmailSentButton.click();
//        
//        visibilitys(bp.openSentMail);
//        bp.openSentMail.click();
//        
//        visibilitys(bp.clickSentLink);
//        bp.clickSentLink.click();
//        
//    }
	public void gshare() {
		bp.gmailShare.click();
		visibilitys(bp.gmailOnly);
		bp.gmailOnly.click();
		visibilitys(bp.fromMailId);
		bp.fromMailId.click();
		for (int i = 0; i < bp.fromMailIdList.size(); i++) {
			WebElement fromMailId = bp.fromMailIdList.get(i);
			String enTxt = fromMailId.getText();
			if (enTxt.equalsIgnoreCase("nidhi@mapmyindia.com")) {
				bp.fromMailIdList.get(i).click();
				break;
			}
		}
	}

	public void denyLocPermission() {
		visibilitys(bp.denyLocWhileUsingApp);
		Reporter.log("Don't Allow visible", true);
		bp.denyLocWhileUsingApp.click();
		visibilitys(bp.LocPermissionCancel);
		bp.LocPermissionCancel.click();
		visibilitys(bp.allow);
		bp.allow.click();
	}

	public void startLoc() {
		cmm(0);
		Reporter.log("start loc clicked", true);
	}

	public void finalLoc() {
		cmm(1);
		Reporter.log("final loc layout clicked", true);
	}

	public void cmm(int num) {
		List<WebElement> ss = bp.ln.findElements(By.className("android.view.ViewGroup"));
		ss.get(num).findElement(By.className("android.widget.TextView")).click();
	}

	public String finalText(int num) {
		List<WebElement> ss = bp.ln.findElements(By.className("android.view.ViewGroup"));
		String point = ss.get(num).findElement(By.className("android.widget.TextView")).getText();
		Reporter.log("entered  final location : " + point, true);
		return point;
	}

	public String startText(int num) {
		List<WebElement> ss = bp.ln.findElements(By.className("android.view.ViewGroup"));
		String point = ss.get(num).findElement(By.className("android.widget.TextView")).getText();
		Reporter.log("entered  start location : " + point, true);
		return point;
	}

	public String LocationOffBanner() {
		visibilitys(bp.locOffInfoBanner);
		Reporter.log("Banner displayed for switching on the location", true);
		visibilitys(bp.locOffBAnnerTExt);
		String text = bp.locOffBAnnerTExt.getText();
		Reporter.log("text available on Banner: " + text, true);
		String actualText = "Switch on your location services to get better search results";
		Assert.assertEquals(text, actualText, "The banner text did not match the expected value.");
		boolean isCurrentLocVisible = visibilitys(bp.currentLoc);
		boolean isChooseOnMapVisible = visibilitys(bp.chooseOnMAp);
		Assert.assertTrue(isCurrentLocVisible, "Current Location element is not visible");
		Assert.assertTrue(isChooseOnMapVisible, "Choose on Map element is not visible");
		return text;
	}

	public void RequiredLoginBox(String expectedMessage) {
		try {
			wait.until(ExpectedConditions.visibilityOf(bp.parentPanel));
			if (bp.parentPanel.isEnabled()) {
				String titleInfo = bp.title.getText();
				String descInfo = bp.description.getText();
				Reporter.log("Displayed Box Title: " + titleInfo, true);
				Reporter.log("Displayed Box Description: " + descInfo, true);
				Assert.assertEquals(titleInfo, expectedMessage,"The login box description does not match the expected message.");

				Assert.assertTrue(bp.loginButton.isDisplayed(), "Login should be displayed.");
				Assert.assertTrue(bp.cancelButton.isDisplayed(), "Cancel should be displayed.");

				bp.loginButton.click();
				Reporter.log("Login Button Clicked.", true);
				sleepWait(2);
			} else {
				Reporter.log("Parent panel is not enabled.", true);
				Assert.fail("Parent panel is not enabled.");
			}
		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void visibilityofMapLayer() {
		wait.until(ExpectedConditions.visibilityOf(bp.MapLayerButton));
		Assert.assertTrue(bp.MapLayerButton.isEnabled(), "Followers on User Profile Page is not enabled");

	}

	public void visibilityofCurrentLocation() {
		wait.until(ExpectedConditions.visibilityOf(bp.CurrentLocationButton));
		Assert.assertTrue(bp.CurrentLocationButton.isEnabled(), "Followers on User Profile Page is not enabled");

	}

	public void permissionforCamera() {
		visibility(bp.permissionBoxTitle, "Allow Mappls MapmyIndia to take pictures and record video? ");
		Assert.assertNotNull(bp.permissionBoxTitle,
				"Allow Mappls MapmyIndia to take pictures and record video? is null.");
		String permissionTitleText = bp.permissionBoxTitle.getText();
		Reporter.log("Title Text Displayed : " + permissionTitleText, true);
		Assert.assertEquals(permissionTitleText, "Allow Mappls MapmyIndia to take pictures and record video?",
				"Title does not match the expected message.");

		WhileUsingAppOption();
		OnlyThisTimeOption();
		DenyOption();
	}

	public void recordAudioPErmission() {
		visibility(bp.permissionBoxTitle, "Allow Mappls MapmyIndia to record audio?");
		Assert.assertNotNull(bp.permissionBoxTitle, "Allow Mappls MapmyIndia to record audio? is null.");
		String permissionTitleText = bp.permissionBoxTitle.getText();
		Reporter.log("Title Text Displayed : " + permissionTitleText, true);
		Assert.assertEquals(permissionTitleText, "Allow Mappls MapmyIndia to record audio?",
				"Title does not match the expected message.");

	}

	public void photoAndVideoaccessPermission() {
		visibility(bp.permissionBoxTitle, "Allow Mappls MapmyIndia to access photos and videos on this device?");
		Assert.assertNotNull(bp.permissionBoxTitle,
				"Allow Mappls MapmyIndia to access photos and videos on this device? is null.");
		String permissionTitleText = bp.permissionBoxTitle.getText();
		Reporter.log("Title Text Displayed : " + permissionTitleText, true);
		Assert.assertEquals(permissionTitleText, "Allow Mappls MapmyIndia to access photos and videos on this device?",
				"Title does not match the expected message.");
	}

	public void WhileUsingAppOption() {
		visibility(bp.WhileUsingAppOption, "While using the app");
		Assert.assertNotNull(bp.WhileUsingAppOption, "While using the app is null.");
		String whileUsingAppOption = bp.WhileUsingAppOption.getText();
		Reporter.log("Option 1 Displayed : " + whileUsingAppOption, true);
		Assert.assertEquals(whileUsingAppOption, "While using the app",
				"Option 1 does not match the expected message.");
	}

	public void OnlyThisTimeOption() {
		visibility(bp.onlyThisTimeOption, "Only this time");
		Assert.assertNotNull(bp.onlyThisTimeOption, "Only this time is null.");
		String onlythistimeText = bp.onlyThisTimeOption.getText();
		Reporter.log("Option 2 Displayed : " + onlythistimeText, true);
		Assert.assertEquals(onlythistimeText, "Only this time", "Option 2 does not match the expected message.");

	}

	public void DenyOption() {
		visibility(bp.dontAllowOption, "Don’t Allow ");
		Assert.assertNotNull(bp.dontAllowOption, "Don’t allow is not displayed.");
		String dontAllowOption = bp.dontAllowOption.getText();
		Reporter.log("Option 3 Displayed : " + dontAllowOption, true);
		Assert.assertEquals(dontAllowOption, "Don’t allow", "Option 3 does not match the expected message.");

	}

	public void allowOption() {
		visibility(bp.allowOption, "Allow ");
		Assert.assertNotNull(bp.allowOption, " Allow is not displayed.");
		String allowText = bp.allowOption.getText();
		Reporter.log("Option Displayed : " + allowText, true);
		Assert.assertEquals(allowText, "Allow", "Allow does not match the expected message.");

	}

	public void dontallowOption() {
		visibility(bp.DenyOption, "Don’t allow ");
		Assert.assertNotNull(bp.DenyOption, "Don’t allow is not displayed.");
		String denyText = bp.DenyOption.getText();
		Reporter.log("Option Displayed : " + denyText, true);
		Assert.assertEquals(denyText, "Don’t allow", "Don’t allow does not match the expected message.");

	}

	public void visibility(WebElement locatorsName, String Statement) {
		wait.until(ExpectedConditions.visibilityOf(locatorsName));
		Assert.assertTrue(locatorsName.isDisplayed(), Statement + "should be displayed");
	}

}
