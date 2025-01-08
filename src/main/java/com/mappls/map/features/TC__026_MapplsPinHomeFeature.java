package com.mappls.map.features;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__026_MapplsPinHomePage;
import com.mappls.map.utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__026_MapplsPinHomeFeature {

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__026_MapplsPinHomePage gp;
	Actions ac;
	
	public TC__026_MapplsPinHomeFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		gp = new TC__026_MapplsPinHomePage(driver);
		ac = new Actions();
		
	}
	
	
	
	
	public void isMapplsPinOnHomePage() {
		bf.mapplsPermissions();
		Assert.assertTrue(gp.isHomePageMapplPinPresesnt.isDisplayed(),"Failed to display mappls pin icon on home page");
		Reporter.log("Mappls pin visible on home page", true);
	}
	
	
	public void isShowMapplsPinPageOpen() {
		bf.mapplsPermissions();
		
		gp.isHomePageMapplPinPresesnt.click();
		
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		
		Assert.assertEquals(gp.isShowMpplsPinPageOpen.getText(),"Show Mappls Pin");
		Reporter.log("Show Mappls Pin is available", true);
	}
	
	
	public void verifyMapplsPinPageUI() {
		bf.mapplsPermissions();
		gp.isHomePageMapplPinPresesnt.click();
		
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		Assert.assertEquals(gp.searchere.getText(),"Search here");
		Reporter.log("'Search here' is present", true);
		
		Assert.assertEquals(gp.isShowMpplsPinPageOpen.getText(),"Show Mappls Pin");
		Reporter.log("Show Mappls Pin is available", true);
		
		Assert.assertTrue(gp.movePinIcon.isDisplayed(),"Failed");
		Reporter.log("Move map to adjust is available", true);
		
		
		Assert.assertEquals(gp.createMpplPinBtn.getText(),"Create Mappls Pin");
		Reporter.log("'Create Mappls Pin' is available", true);
		
		Assert.assertTrue(gp.crrntLocation.isDisplayed(),"Failed");
		Reporter.log("current location is available", true);
		
	}
	
	
	
	
	public void isShowMapplsPinClickable() {
		bf.mapplsPermissions();
		
		gp.isHomePageMapplPinPresesnt.click();
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		
		gp.isShowMpplsPinPageOpen.click();
		
		bf.visibilitys(gp.nearByPlc);
		Assert.assertTrue(gp.nearByPlc.isDisplayed(), "Failed");
		Reporter.log("Near by place available",true);
		
	}
	
	public void isSearchClickable() {
		bf.mapplsPermissions();
		
		gp.isHomePageMapplPinPresesnt.click();
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		gp.searchere.click();
		
		Assert.assertEquals(gp.viaSearchChooseMap.getText(), "Choose On Map");
		Reporter.log("Choose On Map option available", true);
		
		gp.enterPlcSearch.sendKeys("Delhi");
		bf.clickOnMatchedPlace("Delhi");
		
		bf.visibilitys(gp.againShowMpplPin);
		
		Assert.assertEquals(gp.againShowMpplPin.getText(), "Show Mappls Pin");
		Reporter.log("show mappls pin available", true);
		
		Assert.assertEquals(gp.createMpplPinBySearch.getText(), "Create Mappls Pin");
		Reporter.log("create mappls pin button available", true);
		
		
//		gp.bySearchBckButton.click();
	
	
		
	}
	
	public void verifyMapplsPinWOL() {
		bf.mapplsPermissions();
		gp.isHomePageMapplPinPresesnt.click();
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		
		gp.createMapplsPinBTN.click();
		Assert.assertEquals(gp.loginWindowPopUp.getText(), "Create Mappls Pin");
		Reporter.log("create mappls pin button is clickable", true);
		
		Assert.assertEquals(gp.loginWindowPopUpDesc.getText(), "Login to access this functionality.");
		Reporter.log("Login to access this functionality.", true);
		
		gp.loginWindowPopUpCancelBtn.click();
		
		Assert.assertEquals(gp.isShowMpplsPinPageOpen.getText(),"Show Mappls Pin");
		Reporter.log("login pop up window cancel button clicked", true);
		
		
		gp.createMapplsPinBTN.click();
		
		gp.loginWindowPopUpLoginBtn.click();
		
		Assert.assertEquals(gp.loginPage.getText(), "Login/Sign Up to manage your account   ");
		Reporter.log("Login/Sign Up to manage your account ", true);
		
		bf.enterUname("9835980977");
		bf.continueBTNClick();
		bf.enterPsw("Mvn@1234");
		bf.loginBTNClick();
		bf.toastMsg("Login Successful");
		
		Assert.assertEquals(gp.createMpplPinButtonTxt.getText(), "Create Mappls Pin");
		Reporter.log("create mappls pin button is present after login", true);
		
	}
	
	
	public void verifyMapplsPinWL() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("9835980977", "Mvn@1234", "Login Successful");
		gp.isHomePageMapplPinPresesnt.click();
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		
		gp.createMapplsPinBTN.click();
		
		Assert.assertEquals(gp.createMpplPinPageForm.getText(), "Create Mappls Pin");
		Reporter.log("Create Mappls Pin page is visible", true);
	
	}
	
	
	public void createMapplsPinWL() {
		
		
		bf.simpleHamburgerLogin("9835980977", "Mvn@1234", "Login Successful");
		gp.isHomePageMapplPinPresesnt.click();
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
			
			
		gp.createMapplsPinBTN.click();
			
		Assert.assertEquals(gp.createMpplPinPageForm.getText(), "Create Mappls Pin");
		Reporter.log("Create Mappls Pin page is visible", true);
		
//		verifyMapplsPinWL();
		
		Assert.assertEquals(gp.isCategoryVisible.getText(), "Category*");
		Reporter.log("Category field available", true);
		
		Assert.assertEquals(gp.isAddrssFieldVisible.getText(), "Address*");
		Reporter.log("address field available", true);
		
		gp.categoryInput.click();
		Reporter.log("click category drop-down", true);
		int listSize = gp.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gp.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		
		Assert.assertEquals(gp.isNameVisible.getText(), "Name*");
		Reporter.log("name field available", true);
		
		
		gp.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);
		int subCategorySize = gp.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gp.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		
		markLocationClick();
		markLocationDoneBtnClick();
			
		bf.toastMsg("Trying to fetch your location. Please wait.");
		markLocationDoneBtnClick();
			
		String address = gp.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);
		placeNameInputClick();
		submitBtn();
			
		bf.visibilitys(gp.mapplsPINGenerated);
		String mapplsPIN = gp.mapplsPINGenerated.getText();
		System.out.println("Got the generated map pin: " + mapplsPIN);
//		placeOnMap();
		
	}
	
	public void createMapplsPinWLAndVerification() {
		verifyMapplsPinWL();
		
		Assert.assertEquals(gp.isCategoryVisible.getText(), "Category*");
		Reporter.log("Category field available", true);
		
		Assert.assertEquals(gp.isAddrssFieldVisible.getText(), "Address*");
		Reporter.log("address field available", true);
		
		gp.categoryInput.click();
		Reporter.log("click category drop-down", true);
		int listSize = gp.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gp.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		
		Assert.assertEquals(gp.isNameVisible.getText(), "Name*");
		Reporter.log("name field available", true);
		
		
		gp.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);
		int subCategorySize = gp.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gp.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		
		
		placeOnMap();
		
	}
	
//	public void () 
	
	
	
	//TC - 9
	public void isUserAbleShareMapplsPin() {
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		
		
		createMapplsPinWL();
		
//		verifyMapplsPinWL();
		
		
		
		gp.mapplsPinShareImg.click();
		
//		Assert.assertEquals(gp.gmailShare.getText(), "Gmail");
//		Reporter.log("Gmail share is available", true);
//		
//		Assert.assertEquals(gp.gChatShare.getText(), "Chat");
//		Reporter.log("Gmail chat share is available", true);
//		
//		Assert.assertEquals(gp.msgShare.getText(), "Messages");
//		Reporter.log("sms share is available", true);
//		
//		gp.gChatShare.click();
		
		Assert.assertTrue(gp.bottomShareOption.isDisplayed(),"Failed to click share button");
		Reporter.log("mappls pin share button clicked succesfuly", true);
		
//		bf.visibilitys(gp.sentToPage);
//		
////		for (int i = 0; i < bp.emailNameList.size(); i++) {
////			WebElement fromMailId = bp.emailNameList.get(i);
////			String enTxt = fromMailId.getText();
////			if (enTxt.equalsIgnoreCase("muskan.kumari@mapmyindia.com")) {
////				bp.emailNameList.get(i).click(); 
////				break; 
////			}
////		}
//		bp.specificMailClick.click();
//		
//		
//		Assert.assertEquals(gp.chatPageHeaderTitle.getText(), "Muskan Kumari");
//		Reporter.log("gmail chat page redirected", true);
//		
//		gp.sentBtn.click();
//		
//		Assert.assertEquals(gp.sentNowTxt.getText(), "Now");
//		Reporter.log("mappls pin shared successfuly", true);
		
	}
	
	
	
	public void mapplsAccomplished() {
		
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		createMapplsPinWL();
		
//		verifyMapplsPinWL();
		
		Assert.assertEquals(gp.mpplsAccomplished.getText(), "Spread The Accomplishment");
		Reporter.log("Spread The Accomplishment is present", true);
		
		
		gp.mpplsAccomplished.click();
		
		Assert.assertTrue(gp.fb.isDisplayed(),"Failed");
		Reporter.log("facebook option is available", true);
		
		Assert.assertTrue(gp.twitter.isDisplayed(),"Failed");
		Reporter.log("twitter option is available", true);
		
		Assert.assertTrue(gp.instagram.isDisplayed(),"Failed");
		Reporter.log("instagram option is available", true);
		
		Assert.assertTrue(gp.moreShare.isDisplayed(),"Failed");
		Reporter.log("more option is available", true);
		
		gp.moreShare.click();
		
		Assert.assertTrue(gp.gmailShare.isDisplayed(),"Failed to click more option");
		Reporter.log("gmail share is available", true);
		
		gp.gmailShare2.click();
		bf.sleepWait(2);
		Assert.assertTrue(gp.frmAccntName.isDisplayed(), "From account name is not available");
		Reporter.log("From account name : " + gp.frmAccntName.getText(),true);
		
		
		gp.sentToEmailId.sendKeys("muskan.kumari@mapmyindia.com");
		bf.sleepWait(3);
		gp.confrmMailId.click();
		
		gp.mailSentButton.click();
		
		Assert.assertTrue(gp.fb.isDisplayed(),"Failed");
		Reporter.log("mail sent", true);
		
//		Random rmNum = new Random();
				
//		int rmSubject = rmNum.nextInt(89);
		
//		gp.gmailSubject.sendKeys(rmSubject);
		
		
		
		
		
		
	}
	
	
	public void spreadAccmplishmntUI() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		
		createMapplsPinWL();
		
		Assert.assertEquals(gp.mpplsAccomplished.getText(), "Spread The Accomplishment");
		Reporter.log("Spread The Accomplishment is present", true);
		
		
		gp.mpplsAccomplished.click();
		
		Assert.assertTrue(gp.fb.isDisplayed(),"Failed");
		Reporter.log("facebook option is available", true);
		
		Assert.assertTrue(gp.twitter.isDisplayed(),"Failed");
		Reporter.log("twitter option is available", true);
		
		Assert.assertTrue(gp.instagram.isDisplayed(),"Failed");
		Reporter.log("instagram option is available", true);
		
		Assert.assertTrue(gp.moreShare.isDisplayed(),"Failed");
		Reporter.log("more option is available", true);
		
		gp.moreShare.click();
		
		bf.sleepWait(3);
//		Assert.assertTrue(gp.gmailShare.isDisplayed(), "Failed to display gmail share option");
		
		Assert.assertTrue(gp.gmailShare.isDisplayed(),"Failed to click more option");
		Reporter.log("gmail share is available", true);
		
		gp.gmailShare2.click();
		
		Assert.assertTrue(gp.frmAccntName.isDisplayed(), "From account name is not available");
		Reporter.log("From account name : " + gp.frmAccntName.getText(),true);
		
		
		gp.sentToEmailId.sendKeys("muskan.kumari@mapmyindia.com");
		bf.visibilitys(gp.confrmMailId);
		gp.confrmMailId.click();
		gp.mailSentButton.click();
//		mapplsAccomplished();
		
		
		
		
		Assert.assertTrue(gp.fb.isDisplayed(),"Failed");
		Reporter.log("facebook option is available", true);
		
		
		driver.navigate().back();
		
		Assert.assertTrue(gp.congartulations.isDisplayed(), "Failed");
		Reporter.log("mappls pin created successfully", true);
//		
		
		Assert.assertTrue(gp.mapplsCpyIcon.isDisplayed(), "Failed");
		Reporter.log("mappls copy icon available", true);
		
		Assert.assertTrue(gp.mapplsQR.isDisplayed(), "Failed");
		Reporter.log("mappls QR image icon available", true);
		
		Assert.assertTrue(gp.mapplsDownloadIcon.isDisplayed(), "Failed");
		Reporter.log("download icon available", true);
		
		Assert.assertTrue(gp.mapplsPinCloseIcon.isDisplayed(), "Failed");
		Reporter.log("Close icon available", true);
		
		Assert.assertEquals(gp.mapplsPinForAdded.getText(), "Mappls Pin for your added place is");
		Reporter.log("'Mappls Pin for your added place is' available", true);
		
		Assert.assertEquals(gp.getAnotherMapplsPinBtn.getText(), "Get Another Mappls Pin");
		Reporter.log("Get Another Mappls Pin button is available", true);
		
		Assert.assertTrue(gp.feelFreeToShareTxt.isDisplayed(), "Failed");
		Reporter.log("Feel free to share this with friends and co-workers \\n Learn more about Mappls Pin", true);
	
	
	}
	
	public void againCreateMapplsPin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		createMapplsPinWL();
		gp.getAnotherMapplsPinBtn.click();
		
		gp.categoryInput.click();
		Reporter.log("click category drop-down", true);
		int listSize = gp.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gp.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		
		Assert.assertEquals(gp.isNameVisible.getText(), "Name*");
		Reporter.log("name field available", true);
		
		
		gp.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);
		int subCategorySize = gp.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gp.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		placeOnMap();
	}
	
	
	
	
	//13
	public void mapplsPinBackButton() {
		bf.mapplsPermissions();
		gp.isHomePageMapplPinPresesnt.click();
		bf.visibilitys(gp.searchHereBckBtn);
		gp.searchHereBckBtn.click();
		
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to click mappls pin back button");
		Reporter.log("mappls pin back button is working properly", true);
		
	}
	
	public void createMpplPinPageBackBtnFunctionality() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("9835980977", "Mvn@1234", "Login Successful");
		gp.isHomePageMapplPinPresesnt.click();
		Assert.assertTrue(gp.isShowMpplsPinPageOpen.isDisplayed(),"Failed to click mappls pin icon on home page");
		Reporter.log("Mappls pin clickable", true);
		
		
		gp.createMapplsPinBTN.click();
		
		Assert.assertEquals(gp.createMpplPinPageForm.getText(), "Create Mappls Pin");
		Reporter.log("Create Mappls Pin page is visible", true);
		
		gp.createMpplPinPageBackBtn.click();
		
		Assert.assertEquals(gp.searchere.getText(),"Search here");
		Reporter.log("'Search here' page redirected successfully from create mappls pin page", true);
		
	}
	
	
	
	
	
//	=====================================ooooooooooooooooooooo===============================
	
	
	public void getPinClick() {
		bf.swipeUpUntilElementDisplayed(gp.getPinClick, 20);
		gp.getPinClick.click();
		Reporter.log("Clicked on 'Get Pin'.", true);
	}

	
	public void getPinBTNClick() {
		bf.visibilitys(gp.getPinBTN);
		gp.getPinBTN.click();
		Reporter.log("Clicked on 'Get Pin' button.", true);
	}

	public void getStartedBtnClick() {
		bf.visibilitys(gp.getStartedBTN);
		gp.getStartedBTN.click();
		Reporter.log("Clicked on 'Get Started' button.", true);
		
	}
	
	public void createMPBTN() {
		bf.visibilitys(gp.createMapplsPinBTN);
		gp.createMapplsPinBTN.click();
		Reporter.log("Clicked on 'Create Mappls Pin' button.", true);
		
		bf.sleepWait(1);
		Assert.assertTrue(gp.submitBTN.isDisplayed(),"Failed to display pin creation form");
		bf.sleepWait(2);	
	}
	
	public void searchBoxClick() {
		bf.visibilitys(gp.searchBox);
		gp.searchBox.click();
		Reporter.log("click search box", true);
	}
	
	public void searchInput(String place) {
		bf.visibilitys(gp.searchInput);
		gp.searchInput.click();
		gp.searchInput.sendKeys(place);
		Reporter.log("enter random place : " + place , true);		
	}
	
	public void closeIconClick() {
		bf.visibilitys(gp.closeIcon);
		gp.closeIcon.click();
		Reporter.log("Clicked on the close icon.", true);
	}
	
	public void searchBoxPinVerification() {
		bf.visibilitys(gp.searchBOXForPinVerify);
		gp.searchBOXForPinVerify.click();
		Reporter.log("click search box for generated pin verification", true);
	}
	
	public void enterPinForVerification(String mapplsPIN) {
		bf.visibilitys(gp.searchInputForPinVerify);
		gp.searchInputForPinVerify.click();
		gp.searchInputForPinVerify.sendKeys(mapplsPIN);
		Reporter.log("entered pin on the search input field for pin verification : " + mapplsPIN, true);
	}
	
	public void createMPBtn() {
		bf.visibilitys(gp.createMapplsPinBUTTON);
		gp.createMapplsPinBUTTON.click();
		Reporter.log("click create mappls pin button", true);
	}
	
	public void categoryInput() {
		bf.visibilitys(gp.categoryInput);
		gp.categoryInput.click();
		Reporter.log("click category drop-down", true);
	}
	
	public void subCategoryInput() {
		bf.visibilitys(gp.subCategoryInput);
		gp.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);
	}
	
	public void markLocationClick() {
		bf.visibilitys(gp.markLocationOnMap);
		gp.markLocationOnMap.click();
		Reporter.log("click mark location on map", true);
	}
	
	public void markLocationDoneBtnClick() {
		bf.visibilitys(gp.doneBTN);
		gp.doneBTN.click();
		Reporter.log("click mark location done button ", true);
	}
	
	public void placeNameInputClick() {
		
		Random rand = new Random();
		int rmIndex = rand.nextInt(120);
		bf.visibilitys(gp.placeNameInput);
		gp.placeNameInput.click();
		
		gp.placeNameInput.sendKeys("Ranchi office" + rmIndex);
		Reporter.log("Clicked on the input field for the place name and enter name : "+"'Testing purpose'", true);
		
	}
	
	public void submitBtn() {
		bf.visibilitys(gp.submitBTN);
		gp.submitBTN.click();
		Reporter.log("Clicked on the 'Submit' button.", true);
	    bf.sleepWait(3);
	}
	
	
	public void hamburgerCreateMapplsPin() {
		bf.visibilitys(gp.hmbrgrGetPin);
		gp.hmbrgrGetPin.click();
		Reporter.log("Clicked on the 'Get Mappls Pin' on Hamburger menu.", true);
		
	}
	
	
	public void hmGtPinBTN() {
		bf.visibilitys(gp.hmGetMapplsPinBTN);
		gp.hmGetMapplsPinBTN.click();
		Reporter.log("Clicked on the 'Get Mappls Pin' Button.", true);
	
	}
	
	//TC -1 Quick access : login while creating pin
	public void getPinQuickAccessMenuLoginCredential () throws InterruptedException {
		bf.mapplsPermissions();
		getPinClick();
		getPinBTNClick();
		getStartedBtnClick();
		createMPBTN();
		bf.mapplsLogin("7903460942", "Pin@1234", "Login Successful");
		pinCreationMethod();
	}
	
	//TC-2 //Quick access : simple hamburger login
	public void qcSimpleLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("7903460942", "Pin@1234", "Login Successful");
		getPinClick();
		getPinBTNClick();
		getStartedBtnClick();
		createMPBTN();
		categoryInput();
		int listSize = gp.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gp.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		
		//for subcategory selection
		subCategoryInput();
//		List<MobileElement> subCategorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int subCategorySize = gp.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gp.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		placeOnMap();
	}
	
	//TC-3 //hamburger menu : login while creating pin
	public void getPinHmMenuLoginCredential () throws InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		hamburgerCreateMapplsPin();
		hmGtPinBTN();
		getStartedBtnClick();
		createMPBTN();
		bf.mapplsLogin("7903460942", "Pin@1234", "Login Successful");
		pinCreationMethod();		
	}
	
	//TC-4 	hamburger menu : simple login
	public void hambrgrSimpleLogin () throws InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		hamburgerCreateMapplsPin();
		hmGtPinBTN();
		getStartedBtnClick();
		createMPBTN();
		categoryInput();
		int listSize = gp.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gp.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		
		//for subcategory selection
		subCategoryInput();
		int subCategorySize = gp.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gp.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		placeOnMap();
		
	}
	
	//with hamburger login and create mappls pin b quick access menu click generate pin
	public void getPinQuickAccessMenuWithHambrgrLogin () throws InterruptedException {
		ac = new Actions();				
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");		
		ac.swipeUp();
		getPinClick();
		getPinBTNClick();
		getStartedBtnClick();
		createMPBTN();
		pinCreationMethod();
	}
	
	
	//common function for create mappls pin
	public void pinCreationMethod() {
		String rmp = RandomDataGenerator.generateRandomDistrictInJharkhand();
		searchBoxClick();
		searchInput(rmp);
		bf.clickOnMatchedPlace(rmp);
		createMPBtn();		
		categoryInput();
		int listSize = gp.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gp.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		
		//for subcategory selection
		subCategoryInput();
		gp.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);
		int subCategorySize = gp.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gp.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		placeOnMap();
	}
	
	public void placeOnMap() {
		markLocationClick();
		markLocationDoneBtnClick();
		
		bf.toastMsg("Trying to fetch your location. Please wait.");
		markLocationDoneBtnClick();
		
		String address = gp.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);
		placeNameInputClick();
		submitBtn();
		
		bf.visibilitys(gp.mapplsPINGenerated);
		String mapplsPIN = gp.mapplsPINGenerated.getText();
		System.out.println("Got the generated map pin: " + mapplsPIN);
		closeIconClick();
		searchBoxPinVerification();
		enterPinForVerification(mapplsPIN);
		
		List<WebElement> suggestionItems = gp.suggestionListView.findElements(By.className("android.view.ViewGroup"));
		
		List<WebElement> getAddressText = gp.suggestionListView.findElements(By.id("com.mmi.maps:id/auto_list_item_address"));
		
		bf.visibilitys(getAddressText);
		
		Assert.assertTrue(!suggestionItems.isEmpty() && !getAddressText.isEmpty(), "No suggestions found.");
		Reporter.log("suggestions list found ", true);
		
		Assert.assertEquals(getAddressText.get(0).getText(), address);
		Reporter.log("address matched by mappls pin : "  + getAddressText.get(0).getText(), true);
	}
	


}
