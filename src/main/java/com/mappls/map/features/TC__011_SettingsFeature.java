package com.mappls.map.features;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.dataGenerator.Xls_Reader;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__011_SettingsPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__011_SettingsFeature {

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__011_SettingsPage sp;

	public TC__011_SettingsFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		sp = new TC__011_SettingsPage(driver);

	}

	// tc-1
	public void checkSttngsUI() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		Assert.assertEquals(sp.settingTxt.getText(), "Settings");
		Reporter.log("settings option available in hambrger menu", true);

		bf.settingClick();
		Assert.assertEquals(sp.sttngsPageHeader.getText(), "Settings");
		Reporter.log("settings page redirected", true);

		Assert.assertEquals(sp.gnralSttng.getText(), "General Settings");
		Reporter.log("general setting option available", true);

		Assert.assertEquals(sp.mapSetting.getText(), "Map Settings");
		Reporter.log("Map Settings option available", true);

		Assert.assertEquals(sp.unitOption.getText(), "Units");
		Reporter.log("Units option available", true);

		Assert.assertEquals(sp.navMenuOption.getText(), "Navigation Settings");
		Reporter.log("Navigation Settings option available", true);

//		bf.swipeUpUntilElementDisplayed(sp.navMarkerOption, 7);
//		Assert.assertEquals(sp.navMarkerOption.getText(), "Set Navigation Marker");
//		Reporter.log("Set Navigation Marker option available", true);
//		
//		//show current speed
//		bf.swipeUpUntilElementDisplayed(sp.showCrrntSpeed, 9);
//		Assert.assertEquals(sp.showCrrntSpeed.getText(), "Show Current Speed");
//		Reporter.log("Show Current Speed option available", true);
//		
//		//overspeeding alarm
//		bf.swipeUpUntilElementDisplayed(sp.overSpeadAlarm, 6);
//		Assert.assertEquals(sp.overSpeadAlarm.getText(), "Overspeeding Alarm");
//		Reporter.log("Overspeeding Alarm option available", true);
//		
//		//lane guidance
//		bf.swipeUpUntilElementDisplayed(sp.laneGuidance, 9);
//		Assert.assertEquals(sp.laneGuidance.getText(), "Lane guidance");
//		Reporter.log("Lane guidance option available", true);
//		
//		//junction view
//		bf.swipeUpUntilElementDisplayed(sp.junctionView, 9);
//		Assert.assertEquals(sp.junctionView.getText(), "Junction View");
//		Reporter.log("Junction View option available", true);
//		
//		//voice guidance
//		bf.swipeUpUntilElementDisplayed(sp.voiceGuidance, 9);
//		Assert.assertEquals(sp.voiceGuidance.getText(), "Voice Guidance");
//		Reporter.log("Voice Guidance option available", true);
//		
//		//visual allerts
//		bf.swipeUpUntilElementDisplayed(sp.visualAlarts, 9);
//		Assert.assertEquals(sp.visualAlarts.getText(), "Visual Alerts");
//		Reporter.log("Visual Alerts option available", true);
//		
//		//play voice during phone calls
//		bf.swipeUpUntilElementDisplayed(sp.playVoiceDrngCall, 9);
//		Assert.assertEquals(sp.playVoiceDrngCall.getText(), "Play voice during phone calls");
//		Reporter.log("Play voice during phone calls available", true);
//		
//		
//		//play voice over bluetooth
//		bf.swipeUpUntilElementDisplayed(sp.playVoiceOvrBltooth, 9);
//		Assert.assertEquals(sp.playVoiceOvrBltooth.getText(), "Play voice over Bluetooth");
//		Reporter.log("Play voice over Bluetooth is appear", true);
//		
//		//about
//		bf.swipeUpUntilElementDisplayed(sp.about, 9);
//		Assert.assertEquals(sp.about.getText(), "About");
//		Reporter.log("About is available", true);
//		
//		//account
//		bf.swipeUpUntilElementDisplayed(sp.account, 9);
//		Assert.assertEquals(sp.account.getText(), "Account");
//		Reporter.log("Account option available", true);
//		
//		//learn more
//		bf.swipeUpUntilElementDisplayed(sp.learnMore, 9);
//		Assert.assertEquals(sp.learnMore.getText(), "Learn More");
//		Reporter.log("Learn More option available", true);
//		
//		//privacy policy
//		bf.swipeUpUntilElementDisplayed(sp.privacyAndPolicy, 9);
//		Assert.assertEquals(sp.privacyAndPolicy.getText(), "Privacy Policy");
//		Reporter.log("Privacy Policy option available", true);
//		
//		//terms and conditions
//		bf.swipeUpUntilElementDisplayed(sp.trmsAndCondition, 9);
//		Assert.assertEquals(sp.trmsAndCondition.getText(), "Terms & Conditions");
//		Reporter.log("Terms & Conditions option available", true);
//		
//		//build
//		bf.swipeUpUntilElementDisplayed(sp.build, 9);
//		Assert.assertEquals(sp.build.getText(), "Build");
//		Reporter.log("build is available", true);
//		
//		//current build
//		bf.swipeUpUntilElementDisplayed(sp.getBuild, 9);
//		Assert.assertTrue(sp.getBuild.isDisplayed(), "Failed to display build");
//		Reporter.log("current build is : " + sp.getBuild.getText(), true);	
//	

	}

	// tc-2
	public void changePassword() {

		String userMobile = "9822980979";
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		String[][] passwords = getForChangePsw();

		for (String[] passwordPair : passwords) {
			String oldPSW = passwordPair[0];
			String newPSW = RandomDataGenerator.generateRandomPassword();

			System.out.println("Changing password from " + oldPSW + " to " + newPSW);
			bf.simpleHamburgerLogin(userMobile, oldPSW, "Login Successful");

			//login verification
			bf.Hamburgerclick();
			bf.loginbtnHamburgerclick();
			bf.isElementDisplay(bp.loginEditBtn, "user profile ");
			bf.back();
			
			bf.Hamburgerclick();
			hamburgerMenuSettingClick();

			bf.accountClick();
			changePsw();
			
			bf.isElementDisplay(sp.changePswUI, "change password input field ");
			changePasswordEnter(oldPSW, newPSW);
			continueBTN();
//			bf.toastMsg("Password changed successfully."); toast msg element not found
			updatePasswordInExcel(oldPSW, newPSW);

			bf.isElementDisplay(sp.mdCntnt, "login popup window ");
			Reporter.log("'We have updated some features which requires you to login again.' is displayed", true);
			sp.mdCntntLogin.click();

			Reporter.log("clicked login button", true);
			bf.visibilitys(sp.accntPageHeader);
			bf.back();
			
			bf.isElementDisplay(sp.sttngsPageHeader, "Setting header ");
			bf.back();
			 
			bf.isElementDisplay(bp.hamburgerIconClick, "Home Screen ");
			
			bf.Hamburgerclick();
			bf.simpleHamburgerLogin(userMobile, newPSW, "Login Successful");

		}
	}

	
	

//	--------------------------------------------
	
	
	
	public void hamburgerMenuSettingClick() {
		sp.hamBurgerMenuSetting.click();
		Reporter.log("clicked 'settings' on hamburger menu", true);
		bf.sleepWait(3);
	}

	public void changePsw() {
		sp.changePSW.click();
		bf.sleepWait(4);

		Reporter.log("clicked 'change password' on hamburger menu", true);
		bf.sleepWait(3);
	}

	public void continueBTN() {
		sp.continueBTN.click();
		Reporter.log("clicked 'continue button'", true);
		bf.sleepWait(3);
	}

	public String[][] getForChangePsw() {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("change_psw");
		String[][] data = new String[rowCount - 1][1];

		for (int i = 2; i <= rowCount; i++) {
			data[i - 2][0] = reader.getCellData("change_psw", "old", i);
		}
		return data;
	}

	// Method to enter new and old passwords
	public void changePasswordEnter(String oldPSW, String newPSW) {
		sp.oldPSW.sendKeys(oldPSW);
		Reporter.log("Entered old password: " + oldPSW, true);
		bf.sleepWait(3);

		sp.newPassword.sendKeys(newPSW);
		Reporter.log("Entered new password: " + newPSW, true);
		bf.sleepWait(3);

		sp.confirmPSW.sendKeys(newPSW);
		Reporter.log("Re-entered password for confirmation: " + newPSW, true);
		bf.sleepWait(3);
	}

	// Method to update the Excel sheet
	public void updatePasswordInExcel(String oldPSW, String newPSW) {
		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
		int rowCount = reader.getRowCount("change_psw");

		for (int i = 2; i <= rowCount; i++) {
			String cellData = reader.getCellData("change_psw", "old", i);
			if (cellData.equals(oldPSW)) {
				reader.setCellData("change_psw", "old", i, newPSW);
				break;
			}
		}
	}

	//
	// tc-3
	public void logOut() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();

		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");

		bf.Hamburgerclick();
		hamburgerMenuSettingClick();
		bf.accountClick();
		bf.logOutClick();
		bf.logOutYesClick();
		bf.loginTextView();

		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to home page redirected");
		Reporter.log("home page redirected", true);

		bf.Hamburgerclick();
		Assert.assertEquals(bp.loginText.getText(), "Login");
		Reporter.log("guest account", true);
		
	}

	private String getUnit(WebElement element) {
		String getUnits = element.getText();
		String parts[] = getUnits.split(" ");
		return parts[1];
	}

	private void placeDetailUnit(String unit) {
		bf.homeSearchClick();
		bf.homeSearchInputClick("Ranchi");
		bf.clickOnMatchedPlace("Ranchi");
		bf.swipeUpUntilElementDisplayed(sp.untilSaveAppear, 2);
		Reporter.log("place detail page redirected", true);
		String plcPageUnit = getUnit(sp.plcDetailPageDistanceUnit);
		Assert.assertEquals(unit, plcPageUnit);
		Reporter.log(unit + " is present", true);
		sp.plcDetailPageBck.click();
		sp.searchInputBackIcon.click();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to redirected home screen");
	}

	private void navPageUnit(String unit) {
		sp.navigationIcon.click();
		sp.clickSelctLoctn.click();
		sp.entrLoctn.sendKeys("Delhi");
		bf.visibilitys(sp.navAddrsList);
		bf.clickOnMatchedPlace("delhi");
		String navUnit = getUnit(sp.navPageUnit);
		Assert.assertEquals(unit, navUnit);
		Reporter.log(unit + " is present", true);
		sp.navPageBack.click();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to redirected home screen");

	}

	// tc-4
	public void sttngsUnitFeature() {
		bf.mapplsPermissions();

		// verify km for place detail suggestion list
		bf.Hamburgerclick();
		bf.settingClick();
		Assert.assertEquals(sp.unitTxt.getText(), "Units");
		Reporter.log("unit page redirected", true);

		String isKMSlected = sp.kmBtn.getAttribute("selected");
		Assert.assertEquals(isKMSlected, "true");
		Reporter.log("km/Hr is selected by default", true);
		sp.unitBckIcon.click();
		// verify km for place detail page
		placeDetailUnit("km");

		// verify km for navigation page
		navPageUnit("km");

		bf.Hamburgerclick();
		bf.settingClick();

		String isMLSlected = sp.milesBtn.getAttribute("selected");
		Assert.assertEquals(isMLSlected, "false");
		Reporter.log("ml/Hr is not selected by default", true);
		sp.milesBtn.click();
		Assert.assertEquals(sp.milesBtn.getAttribute("selected"), "true");
		Reporter.log("ml/Hr is selected", true);
		sp.unitBckIcon.click();
//	    	bf.back();

		// mi for place detail page
		placeDetailUnit("mi");

		// mi for navigation page
		navPageUnit("mi");

	}

	// new

	public void skipButtonClick() {
		sp.skipBTN.click();
		Reporter.log("clicked 'skip button' on hamburger menu", true);
		bf.sleepWait(3);
	}

	// 1
	public void withLoginSettingsSkipBtn() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		hamburgerMenuSettingClick();

		bf.scrollUp(20);
		bf.accountClick();
		changePsw();
		Assert.assertTrue(sp.changePswUI.isDisplayed(), "Failed");
		Reporter.log("change password interface display", true);
		skipButtonClick();
		Assert.assertTrue(sp.accountInterface.isDisplayed(), "Failed to click skip button");
		Reporter.log("skip button clicked successfully", true);
	}

	// tc-6
	public void toggleSwitch() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		hamburgerMenuSettingClick();
//			bf.swipeUpUntilElementDisplayed(sp.visualAlrts, 5);

	}

}
