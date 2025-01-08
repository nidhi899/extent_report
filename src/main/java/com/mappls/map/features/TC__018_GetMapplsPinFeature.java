package com.mappls.map.features;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__018_GetMapplsPinPage;
import com.mappls.map.pages.TC__026_MapplsPinHomePage;
import com.mappls.map.utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__018_GetMapplsPinFeature {

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__018_GetMapplsPinPage gp;
	Actions ac;
	TC__026_MapplsPinHomeFeature mpf;
	TC__026_MapplsPinHomePage getmp;
	
	
	public TC__018_GetMapplsPinFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		gp = new TC__018_GetMapplsPinPage(driver);
		ac = new Actions();
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		getmp = new TC__026_MapplsPinHomePage(driver);
		
	}
	
	
	
	
	
//	TC - 1
	public void mapplsPinUIVerification() {
		bf.mapplsPermissions();
		Assert.assertTrue(gp.isMapplsPinHomeScreen.isDisplayed(), "Failed");
		Reporter.log("mappls pin icon is visible in home screen", true);
		
		
		bf.Hamburgerclick();
		hamburgerCreateMapplsPin();
		
		Assert.assertEquals(gp.mpHeaderTxt.getText(), "What is Mappls Pin?");
		Reporter.log("mappls pin top nav is visible with text 'what is mappls pin?'", true);
		
		Assert.assertTrue(gp.mapplsPinBackBtn.isDisplayed(), "Failed");
		Reporter.log("mappls pin back button is visible", true);
		
		
		gp.mapplsPinVidePlayButton.click();
		
		Assert.assertTrue(gp.mapplsPinVideo.isDisplayed(), "Failed");
		Reporter.log("mappls pin video is playing in youtube", true);
		
		
	}
	
	
//	TC - 2
	public void isMapplsPinVideoLandscap() {
		isMapplsPinVideoPlayINYoutube();
		
		gp.isLandScapVideoPlay.click();
		
	}
	
	
//	TC - 3
	public void isMapplsPinVideoPlayINYoutube() {
		bf.mapplsPermissions();
		
		bf.Hamburgerclick();
		hamburgerCreateMapplsPin();
		
		gp.mapplsPinVidePlayButton.click();
		
		Assert.assertTrue(gp.mmiYoutube.isDisplayed(), "Failed to redirect youtube");
		Reporter.log("mappls pin video is playing in youtube", true);
		
//		Assert.assertTrue(gp.mapplsPinVideo.isDisplayed(), "Failed");
//		Reporter.log("mappls pin video is playing in youtube", true);
		
	
	
	}
	
	
	// TC - 4
	public void isShowMapplsPinClickable() {
		mpf.isShowMapplsPinPageOpen();
		Assert.assertEquals(getmp.createMpplPinBtn.getText(),"Create Mappls Pin");
		Reporter.log("'Create Mappls Pin' is available", true);
	}
	
	
	
//	TC-5
	public void createMpplPinUI() {
		mpf.createMapplsPinWLAndVerification();
	}
	
	
//	TC - 6
	public void isUserAbleToShareCreatedPin() {
		mpf.isUserAbleShareMapplsPin();
	}
	
	
	
	
	
	
	
//	===================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void getPinClick() {
//	    ac = new Actions();
//	    ac.swipeUp();
//	    while (!gp.getPinClick.isDisplayed()) {
//	        ac.swipeUp(); 
//	    }
//	    gp.getPinClick.click();
//	    Reporter.log("Clicked on 'Get Pin'.", true);
		bf.swipeUpUntilElementDisplayed(gp.getPinClick, 10);
//		bf.scrollUp(1);
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
	public void createMPBTNClick()
	{	bf.visibilitys(gp.createMapplsPinBTN);
	gp.createMapplsPinBTN.click();
	Reporter.log("Clicked on 'Create Mappls Pin' button.", true);
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
//		Assert.assertTrue(gp.);
//		bf.toastMsg("A place with the same name already exists at this location.");
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
//		pinCreationMethod();
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
		bf.simpleHamburgerLogin("8887776565", "Mvn@1234", "Login Successful");
//		bf.Hamburgerclick();
//		getPinClick();
//		getPinBTNClick();
//		getStartedBtnClick();
//		createMPBTN();
//		pinCreationMethod();
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
//		List<MobileElement> categorySelection = driver.findElements(By.className("android.widget.RadioButton"));
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
		
		
//		=============modified============
		
		
//		Assert.assertEquals(getAddressText.get(0).getText(), address);
//		Reporter.log("address matched by mappls pin : "  + getAddressText.get(0).getText(), true);
	    
		for(int i=0; i<getAddressText.size(); i++) {
			if(address.equalsIgnoreCase(getAddressText.get(i).getText())) {
				Reporter.log("address matched by mappls pin : "  + getAddressText.get(i).getText(), true);
				break;	
			} 
			Assert.assertEquals(getAddressText.get(i).getText(), address);
		}
		
	}
	
	
	public void elocShare() {
		markLocationClick();
		markLocationDoneBtnClick();
		
		bf.toastMsg("Trying to fetch your location. Please wait.");
		markLocationDoneBtnClick();
		
		String address = gp.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);
		placeNameInputClick();
		submitBtn();
		
		bf.visibilitys(gp.mapplsPINGenerated);
//		String mapplsPIN = gp.mapplsPINGenerated.getText();
		gp.elocShareIcon.click();
//		=========================
		
		
		
		
		
		
	}


}
