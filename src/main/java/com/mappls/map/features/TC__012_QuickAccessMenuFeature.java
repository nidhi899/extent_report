package com.mappls.map.features;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__008_MySavesPage;
import com.mappls.map.pages.TC__012_QuickAccessMenuPage;
import com.mappls.map.utils.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__012_QuickAccessMenuFeature extends DriverManager{

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__012_QuickAccessMenuPage qc;
	TC__008_MySavesPage mp;
//	TC__008_MySavesFeature msf;
	TC__008_MySavesPage msp;
	
	public TC__012_QuickAccessMenuFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		qc = new TC__012_QuickAccessMenuPage(driver);
		mp = new TC__008_MySavesPage(driver);
//		msf = new TC__008_MySavesFeature(driver);
		msp = new TC__008_MySavesPage(driver);
		
	}
	
	
	public void swipeCord() {
		bf.mapplsPermissions();

		bf.sleepWait(5);
		bf.scrollUp(7);
		

		bf.scrollDown(1);
		
	}
	
	
//	TC - 1
	public void uiVerify() {
		bf.mapplsPermissions();
		
		bf.sleepWait(5);
		bf.qcswipeUpUntilElementDisplayed(qc.postOnMap, 6);
		Reporter.log("post on map visible", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.fixMap, 4);
		Reporter.log("fix map is visible", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.viewPostedEvents, 6);
		Reporter.log("view posted events is visible", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.shareLocation, 7);
		Reporter.log("share location is visible", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.getPin, 7);
		Reporter.log("get mappls pin is visible", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.homeClick, 8);
		Reporter.log("home is visible", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.workclick, 9);
		Reporter.log("work isvisible", true);
	}
	
	
	public void fixMapAndVerification() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		fixMapClick();
		fixMapSelectCategory();
		qc.fixMapList.get(1).click();
		bf.sleepWait(4);
		imageUpload();
		bf.sleepWait(3);
		setLocationAndPostBtnClick();
		
		qc.postedPageCloseIcon.click();
		Assert.assertEquals(qc.wlcmMapplsPageQA.getText(), "Welcome to Mappls!");
		Reporter.log("cancel login clicked", true);	
		
		bf.back();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to redirected to the home page");
		Reporter.log("home page redirected", true);
		
		bf.Hamburgerclick();
		
		msp.mySavesHambrgrMenu.click();
		
		Assert.assertEquals(qc.msContributionClick.getText(), "Contributions");
		Reporter.log("contribution present in my saves list", true);	
		
		qc.msContributionClick.click();
		
		Assert.assertEquals(qc.msCntriMapIssue.getText(), "MAP ISSUE");
		Reporter.log("map issue present", true);
		
		bf.sleepWait(6);
		
		
		//
		Assert.assertTrue(qc.momentAgo.getText().equalsIgnoreCase("moments ago"), "Post Data on Map Failed");
		Reporter.log("Data posted successfully : " + qc.momentAgo.getText(), true);
		
		
	}
	
	
	public void reportedIssue() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("8887776565", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
		postOnMapClick();
		Assert.assertEquals(qc.anythingClick.getText(), "Anything");
		qc.anythingClick.click();
		Assert.assertEquals(qc.postMapHedrTxt.getText(), "Post on Map");
		qc.anUpdateClick.click();
		Assert.assertEquals(qc.chseLocationTxt.getText(), "Search or choose location from map");
		Reporter.log("post page visible", true);
		qc.postLocation.click();
		Reporter.log("clicked 'Post Location' ", true);
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();
		Assert.assertEquals(qc.postBtn.getText(), "Post");
		qc.postBtn.click();
		Reporter.log("post nutton clicked", true);
		Assert.assertEquals(qc.postMapPostedTxt.getText(), "Posted Successfully");
		Reporter.log("post has been submitted successfuly", true);
		qc.postedPageCloseIcon.click();
		Assert.assertEquals(qc.wlcmMapplsPageQA.getText(), "Welcome to Mappls!");
		Reporter.log("close button clicked", true);
		
		bf.qcswipeUpUntilElementDisplayed(qc.viewPostedEvents, 8);
		//bf.swipeDownUntilElementDisplayed(qc.viewPostedEvents, 6);
		
		qc.pstdEventClick.click();
		Assert.assertEquals(qc.pstEvntAnything.getText(), "Anything");
		qc.pstEvntAnything.click();
		
		Assert.assertEquals(qc.pstEvntAnythingHeader.getText(), "Anything");
		qc.filtrClick.click();
		Reporter.log("filter clicked", true);
		Assert.assertEquals(qc.fltrClckHeaderTxt.getText(), "Filter");
		qc.pstEvntSort.click();
		Reporter.log("sort clicked", true);
		Assert.assertEquals(qc.pstEvntSortByNewst.getText(), "Newest");
		qc.pstEvntSortByNewst.click();
		Reporter.log("'newest' clicked", true);
		
		qc.pstEvntSortByNwstApplyBtn.click();
		
//		bf.scrollUp(1);
		bf.visibilitys(qc.pstEvntAddrsLists);
		
		Assert.assertEquals(qc.momentsAgo.getText(), "moments ago");
		Reporter.log("post viewed", true);
		
		
	}
	
	
	public void isShareMyLocationVisible() {
			bf.mapplsPermissions();
			bf.qcswipeUpUntilElementDisplayed(qc.shareLocation, 9);
			//bf.swipeDownUntilElementDisplayed(qc.shareLocation, 6);
			Reporter.log("share my location is visible in quick access menu", true);
	}
	
	public void isShareMyLocationVisibleWL() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		bf.qcswipeUpUntilElementDisplayed(qc.shareLocation, 8);
		//bf.swipeDownUntilElementDisplayed(qc.shareLocation,6);
		Reporter.log("share my location is visible in quick access menu", true);
}
	
	public void isGetMapplsPinVisibleWOL() {
		bf.mapplsPermissions();
		bf.qcswipeUpUntilElementDisplayed(qc.getPin, 8);
		//bf.swipeDownUntilElementDisplayed(qc.getPin, 6);
		Reporter.log("Get mappls pin option visible in quick access menu", true);
	}
	
	public void isGetMapplsPinVisibleWL() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		bf.qcswipeUpUntilElementDisplayed(qc.getPin, 8);
		//bf.swipeDownUntilElementDisplayed(qc.getPin, 6);
		Reporter.log("Get mappls pin option visible in quick access menu", true);
	}
	

	//tc - 2
	public void isUserAbleToReportIssue() throws ParseException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		postOnMapClick();
		
		//'anything'
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		
		anUpdateClick();
		postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();
		imageUpload();
		postButtonClick();
		Assert.assertTrue(qc.viewPost.isDisplayed(),"Failed");
		
		qc.postMapCloseBtn.click();
		
		Assert.assertEquals(qc.wlcmMapplsPageQA.getText(), "Welcome to Mappls!");
		Reporter.log("close button clicked", true);
		
//		qc.qcArrowIcon.click();
//		
//		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
		
		
		bf.qcswipeUpUntilElementDisplayed(qc.viewPostedEvents, 8);
		//bf.swipeDownUntilElementDisplayed(qc.viewPostedEvents, 6);
		viewPostClick();
	
		
		qc.postMapSelCategory.click();
		bf.scrollUp(1);
		List<String> postedDates = new ArrayList<>();
		for (WebElement element : qc.date) {
			String postDateText = element.getText();
			postedDates.add(postDateText);
			System.out.println(postDateText);
		}
		qc.searchFilter.click();
		qc.sortEvents.click();
		qc.newest.click();
		qc.applyBTN.click();
		bf.sleepWait(4);
		bf.scrollUp(1);
		List<String> postedDatesNewest = new ArrayList<>();
		for (WebElement element : qc.date) {
			String postDateText = element.getText();
			postedDatesNewest.add(postDateText);
			System.out.println(postDateText);
		}

		// Verify dates are sorted by newest
		Assert.assertTrue(areDatesSortedNewestFirst(postedDatesNewest), "Dates are not sorted by newest first");

		//short by oldest 
		qc.searchFilter.click();
		qc.sortEvents.click();
		qc.oldest.click();
		qc.applyBTN.click();
		bf.sleepWait(4);
		bf.scrollUp(1);
		List<String> postedDatesOldest = new ArrayList<>();
		for (WebElement element : qc.date) {
			String postDateText = element.getText();
			postedDatesOldest.add(postDateText);
			System.out.println(postDateText);
		}

		Assert.assertTrue(areDatesSortedOldestFirst(postedDatesOldest), "Dates are not sorted by newest first");

	
//		viewPostClick();
//		postVerification();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	===============================================

	private static final String USERNAME = "nidhi1234";
    private static final String PASSWORD = "Mvn@1234";
    private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful";

    //common method 
    public void searchInput() {
		searchInputClick(RandomDataGenerator.generateRandomDistrictInJharkhand());
		bf.visibilitys(qc.viewDistance);
		bf.back();
		
		if (!qc.viewDistance.isEmpty()) {
			bf.sleepWait(4);
			bf.visibilitys(qc.viewDistance.get(6));
			qc.viewDistance.get(6).click();
			bf.sleepWait(5);
		} else {
			System.out.println("viewDistance list is empty. No element to click.");
		}
    }
    
    public void searchInputForMySaves() {
    	String location = RandomDataGenerator.generateRandomDistrictInJharkhand();
		searchInputClick(location);
		bf.clickOnMatchedPlace(location);
		bf.sleepWait(3);
    }
    
	public void postOnMapClick() {
		
		bf.qcswipeUpUntilElementDisplayed(qc.postOnMap, 8);
		//bf.swipeDownUntilElementDisplayed(qc.postOnMap, 6);
		
		Assert.assertTrue(qc.postOnMap.isDisplayed(), "Failed");
		
		qc.postOnMap.click();
		Reporter.log("clicked 'post on map' ", true);
	}

	public void anUpdateClick() {
		bf.visibilitys(qc.anUpdateClick);
		qc.anUpdateClick.click();
		Reporter.log("clicked 'an Update' ", true);
	}

	public void postButtonClick() {
		bf.visibilitys(qc.postButtonClick);
		qc.postButtonClick.click();
		Reporter.log("clicked 'Post Buton' ", true);
		bf.sleepWait(3);
	}

	public void postLocationClick() {
		bf.visibilitys(qc.postLocation);
		qc.postLocation.click();
		Reporter.log("clicked 'Post Location' ", true);
		
	}

	public void locationDoneBTNClick() {
		bf.visibilitys(qc.locationDoneBTN);
		qc.locationDoneBTN.click();
		Reporter.log("clicked 'Location Done Button' ", true);
	}

	public void sharePostedDataButtonClick() {
		bf.visibilitys(qc.sharePostedLocation);
		qc.sharePostedLocation.click();
		Reporter.log("clicked 'share location Button' ", true);
	}

	public void continueButton() {
		bf.visibilitys(qc.afterPostcontinueBtn);
		qc.afterPostcontinueBtn.click();
		Reporter.log("clicked 'continue Button' ", true);
	}

	public void viewPostClick() { //changed
		qc.viewPost.click();
		Reporter.log("clicked 'view post Button' ", true);
	}

	public String postedTimeText() {
		bf.visibilitys(qc.postedTime);
		Reporter.log("get posted time :  " + qc.postedTime.getText(), true);
		return qc.postedTime.getText();
	}

	public void helpFulClick() {
		bf.visibilitys(qc.helpFulButton);
		qc.helpFulButton.click();
		Reporter.log("clicked 'Helpful Button'", true);
	}

	public void descClick() {
		bf.visibilitys(qc.descClick);
		qc.descClick.click();
		Reporter.log("clicked 'Add Description' ", true);
	}

	public void descDoneBtn() {
		bf.visibilitys(qc.writeDescDoneBtn);
		qc.writeDescDoneBtn.click();
		Reporter.log("clicked 'Description Done Button ' ", true);
	}

	public void searchIconClick() {
		bf.visibilitys(qc.searchIcn);
		qc.searchIcn.click();
		Reporter.log("clicked 'search icon' ", true);
	}

	public void searchInputClick(String location) {
		bf.visibilitys(qc.searchInput);
		qc.searchInput.sendKeys(location);
		Reporter.log("Entered Location in 'search input' ", true);
	}

	public String helpFulLikeClick() {
		bf.visibilitys(qc.helpFulLike);
		
		Reporter.log("get 'Helpful Like Button' count : " + qc.helpFulLike.getText(), true);
		return qc.helpFulLike.getText();
	}
	
	//realme device
	public void imageUpload() {
	    try {
	        bf.visibilitys(qc.addImage);
	        qc.addImage.click();
	        Reporter.log("Add Image clicked", true);

	        try {
	            if (qc.imageTitle.isDisplayed()) {
	                bf.visibilitys(qc.imageTitle);
	                qc.imageTitle.click();
	                
	                bf.visibilitys(qc.imagePermission);
	                qc.imagePermission.click();
	                
	                bf.visibilitys(qc.audioPermission);
	                qc.audioPermission.click();
	                
	                bf.visibilitys(qc.addImage);
	                qc.addImage.click();
	                
	                qc.imageTitle.click();
	                qc.imgMediaAllow.click();
	                qc.addImage.click();
	            }
	        } catch (NoSuchElementException e) {
	            Reporter.log("Optional permissions not displayed, proceeding without them.", true);
	        }

	        bf.sleepWait(6);
	        Assert.assertEquals(qc.mpplsCamera.getText(), "Mappls Camera", "Mappls Camera text mismatch.");
	        Reporter.log("Mappls Camera is visible", true);

	        qc.mpplsCamera.click();

	        bf.visibilitys(qc.takePicure);
	        qc.takePicure.click();

	        bf.sleepWait(2);
	        Assert.assertTrue(qc.adedImgVrfctn.isDisplayed(), "Failed to upload image.");
	        Reporter.log("Image uploaded successfully.", true);
	        
	    } catch (NoSuchElementException e) {
	        Reporter.log("Required element not found: " + e.getMessage(), true);
	        throw e;
	    } catch (Exception e) {
	        Reporter.log("An unexpected error occurred: " + e.getMessage(), true);
	        throw e;
	    }
	}

	
	
	//samsung device
	public void imageUploads() {
		bf.visibilitys(qc.addImage);
		qc.addImage.click();
		
		bf.visibilitys(qc.imageTitle);
		qc.imageTitle.click();
		
		bf.visibilitys(qc.imagePermission);
		qc.imagePermission.click();
		
		bf.visibilitys(qc.audioPermission);
		qc.audioPermission.click();
		
		bf.visibilitys(qc.addImage);
		qc.addImage.click();
		
		bf.visibilitys(qc.imageTitle);
		qc.imageTitle.click();
		
		bf.visibilitys(qc.allowall);
		qc.allowall.click();
		
		bf.visibilitys(qc.addImage);
		qc.addImage.click();
		
		bf.visibilitys(qc.imageTitle);
		qc.imageTitle.click();
		
		
		bf.visibilitys(qc.takePicure);
		qc.takePicure.click();
		
		bf.sleepWait(2);
		Assert.assertTrue(qc.adedImgVrfctn.isDisplayed(), "Failed to image upload.");
		Reporter.log("Image uploaded..", true);
		}
	
	public void postVerification() {
		bf.visibilitys(qc.postedTime);
		Assert.assertTrue(qc.postedTime.getText().equalsIgnoreCase("moments ago"), "Post Data on Map Failed");
		Reporter.log("Data posted successfully : " + qc.postedTime.getText(), true);
	
	}

	
	//TC-1 post on map without location
	public void postMapWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);		
		postOnMapClick();
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		anUpdateClick();
		postButtonClick();
		
//		=====
//		=======
		
		Assert.assertEquals(qc.toastMsg.getText(), "Please select location first");
//		bf.toastMsg("Please select location first");
		bf.sleepWait(2);
		Assert.assertTrue(qc.postButtonClick.isDisplayed(), "Failed");		
	}
	
	//	TC-2 post on map with location
	public void postMapWithLoginAndLocation() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		postOnMapClick();
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		anUpdateClick();
		postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();
		imageUpload();
		postButtonClick();
		Assert.assertTrue(qc.viewPost.isDisplayed(),"Failed");
		viewPostClick();
		postVerification();
	}

//	TC-3
	public void postMapWithLoginMsg() {
		bf.mapplsPermissions();
		postOnMapClick();
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		anUpdateClick();
		postButtonClick();
		bf.toastMsg("Please select location first");
		postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();
		postButtonClick();
		Assert.assertEquals(qc.postMapPopUpMsgWOLTxt.getText(), "Post on Map");
		Reporter.log("post on map login pop up window visible", true);
		
		qc.postMapCancelLoginBtn.click();
		
		Assert.assertEquals(qc.afterClickCancelLogin.getText(), "Post on Map");
		Reporter.log("post on map redirected after clicked cancel login", true);
		
		
		
		
//		bf.mapplsLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
//		postButtonClick();
	}
	
	
	//TC-4 post share and close
	public void postedShareAndClose() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		postOnMapClick();
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		anUpdateClick();
		postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();
		postButtonClick();	
		sharePostedDataButtonClick();
		Assert.assertEquals(qc.shareLinkCopyBtn.getText(), "COPY");
//		driver.findElementByAccessibilityId("COPY").click(); 
		qc.shareLinkCopyBtn.click();
		bf.toastMsg("Copied");
		
		bf.sleepWait(4);
		Assert.assertTrue(qc.postedPageCloseIcon.isDisplayed(), "Failed to display close icon");
		Reporter.log("close icon display", true);
		qc.postedPageCloseIcon.click();
		
		bf.sleepWait(6);
//		bf.visibilitys(qc.qcArrowButton);
		Assert.assertTrue( qc.qcArrowButton.isDisplayed(), "Failed to close post successfully page");
		Reporter.log("Posted page closed ", true);		
	}
	
	//TC-5 post 
	public void postAndCntinue() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		postOnMapClick();
		
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		anUpdateClick();
		postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		
		locationDoneBTNClick();
		
		postButtonClick();			
		bf.visibilitys(qc.afterPostcontinueBtn);
		qc.afterPostcontinueBtn.click();
		Assert.assertTrue(qc.qcPageIsVisible.isDisplayed() || qc.qcArrowButton.isDisplayed(), "Failed to close post successfully page");
		Reporter.log("Posted page closed ", true);		
	}
	
	
	
	//TC-6
	public void shareAndHelpFulLike() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		postOnMapClick();
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		anUpdateClick();
		postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();
		imageUpload();
		postButtonClick();	
		viewPostClick();
		
		bf.visibilitys(qc.shareBTtnAgain);
		qc.shareBTtnAgain.click();
//		driver.findElementByAccessibilityId("Copy").click();
		Assert.assertEquals(qc.shareLinkCopyBtn.getText(), "COPY");
		qc.shareLinkCopyBtn.click();
		bf.toastMsg("Copied");
		helpFulClick();
		helpFulLikeClick();
	}
	
//	location , image 
	public void setLocationAndPostBtnClick() {
		postLocationClick();
		searchIconClick();
		searchInputClick(RandomDataGenerator.generateRandomDistrictInJharkhand());
		driver.navigate().back(); 
		bf.visibilitys(qc.viewDistance);
		qc.viewDistance.get(qc.viewDistance.size() - 1).click();
		bf.visibilitys(qc.pointOnMapAddressText);
		locationDoneBTNClick();       
//		imageUpload();
		postButtonClick();
	}
	
	public void postPageShareBtn() {
		sharePostedDataButtonClick();
//		driver.findElementByAccessibilityId("Copy").click(); 
//		bf.toastMsg("Copied to clipboard.");
		
		Assert.assertEquals(qc.shareLinkCopyBtn.getText(), "COPY");
//		driver.findElementByAccessibilityId("COPY").click(); 
		qc.shareLinkCopyBtn.click();
		bf.toastMsg("Copied");
	}

	//	===============TC - 10, Fix Map===============

	public void fixMapClick() {
		bf.qcswipeUpUntilElementDisplayed(qc.fixMap, 8);
//		bf.scrollUp(8);
		//bf.swipeDownUntilElementDisplayed(qc.fixMap, 6);
		Assert.assertTrue(qc.fixMap.isDisplayed(), "Failed");
		qc.fixMap.click();
		Reporter.log("clicked 'Fix Map' ", true);
		bf.sleepWait(1);
	} 

	public void fixMapSelectCategory() {
		qc.fixMapSelCat.click();
		Reporter.log("clicked 'Select category map' ", true);
		bf.sleepWait(3);
	}

	//TC-7
	public void fixMapWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		fixMapClick();
		fixMapSelectCategory();
		qc.fixMapList.get(1).click();
		bf.sleepWait(4);
		setLocationAndPostBtnClick();
		postPageShareBtn();
		viewPostClick();
		postVerification();
	}

	//TC-8
	public void fixMapWithOutLogin() {
		bf.mapplsPermissions();
		fixMapClick();
		fixMapSelectCategory();
		qc.fixMapList.get(1).click();
		bf.sleepWait(4);
		setLocationAndPostBtnClick();
		
		Assert.assertEquals(qc.postMapPopUpMsgWOLTxt.getText(), "Post an Issue");
		Reporter.log("'post an Issue' login pop up window visible", true);
		
		qc.postMapCancelLoginBtn.click();
		
		Assert.assertEquals(qc.afterClickCancelLogin.getText(), "Fix Map");
		Reporter.log("Fix Map redirected after clicked cancel login", true);
		
		
//		bf.mapplsLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
//		postButtonClick();
//		viewPostClick();
//		postVerification();
	}


//	Posted Events
	public void postedEventsClick() {
		bf.qcswipeUpUntilElementDisplayed(qc.viewPostedEvents, 8);
		//bf.swipeDownUntilElementDisplayed(qc.viewPostedEvents, 6);
		Assert.assertTrue(qc.viewPostedEvents.isDisplayed(), "Failed");
		qc.viewPostedEvents.click();
		Reporter.log("clicked 'posted events' ", true);
	}
	
	//TC-9
	public void viewPostedEvents() throws ParseException {
		bf.mapplsPermissions();
		postedEventsClick();
		bf.sleepWait(4);
		qc.postMapSelCategory.click();
		bf.scrollUp(1);
		List<String> postedDates = new ArrayList<>();
		for (WebElement element : qc.date) {
			String postDateText = element.getText();
			postedDates.add(postDateText);
			System.out.println(postDateText);
		}
		qc.searchFilter.click();
		qc.sortEvents.click();
		qc.newest.click();
		qc.applyBTN.click();
		bf.sleepWait(4);
		bf.scrollUp(1);
		List<String> postedDatesNewest = new ArrayList<>();
		for (WebElement element : qc.date) {
			String postDateText = element.getText();
			postedDatesNewest.add(postDateText);
			System.out.println(postDateText);
		}

		// Verify dates are sorted by newest
		Assert.assertTrue(areDatesSortedNewestFirst(postedDatesNewest), "Dates are not sorted by newest first");

		//short by oldest 
		qc.searchFilter.click();
		qc.sortEvents.click();
		qc.oldest.click();
		qc.applyBTN.click();
		bf.sleepWait(4);
		bf.scrollUp(1);
		List<String> postedDatesOldest = new ArrayList<>();
		for (WebElement element : qc.date) {
			String postDateText = element.getText();
			postedDatesOldest.add(postDateText);
			System.out.println(postDateText);
		}

		Assert.assertTrue(areDatesSortedOldestFirst(postedDatesOldest), "Dates are not sorted by newest first");


	}

	private boolean areDatesSortedNewestFirst(List<String> dates) throws ParseException {
		List<Date> parsedDates = parseDates(dates);
		List<Date> sortedDates = new ArrayList<>(parsedDates);
		Collections.sort(sortedDates, Collections.reverseOrder());
		return parsedDates.equals(sortedDates);
	}

	private boolean areDatesSortedOldestFirst(List<String> dates) throws ParseException {
		List<Date> parsedDates = parseDates(dates);
		List<Date> sortedDates = new ArrayList<>(parsedDates);
		Collections.sort(sortedDates);
		return parsedDates.equals(sortedDates);
	}
	private List<Date> parseDates(List<String> dates) throws ParseException {
		List<Date> parsedDates = new ArrayList<>();
		for (String dateStr : dates) {
			parsedDates.add(parseDate(dateStr));
		}
		return parsedDates;
	}

	private Date parseDate(String dateStr) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
		Date date;
		if (dateStr.contains("hours ago")) {
			int hoursAgo = Integer.parseInt(dateStr.split(" ")[0]);
			date = new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hoursAgo));
		} else if (dateStr.contains("minutes ago")) {
			int minutesAgo = Integer.parseInt(dateStr.split(" ")[0]);
			date = new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(minutesAgo));
		} else {
			date = dateFormat.parse(dateStr);
		}

		return date;
	}
	
	
	
	
//	==========share my location
	public void shareMyLocationClick() {
		bf.qcswipeUpUntilElementDisplayed(qc.shareLocation, 8);
		//bf.swipeDownUntilElementDisplayed(qc.shareLocation, 6);
		Assert.assertTrue(qc.shareLocation.isDisplayed(), "share location not display");
		qc.shareLocation.click();
		Reporter.log("clicked 'Share my location' ", true);
		bf.sleepWait(3);
	}
	
	public void shareMyLocationBTN() {
		qc.shareLocationButon.click();
		Reporter.log("clicked 'Share location Button' ", true);
		bf.sleepWait(3);
	}
	
	public void continueBtn() {
		Assert.assertTrue(qc.continueBtn.isDisplayed(),"continue button not displayed");
		if(qc.continueBtn.isDisplayed()) {
			qc.continueBtn.click();
			Reporter.log("clicked 'Continue Button' ", true);
			bf.sleepWait(3);
		}
		
	}
	
	public void shareLocationLink() {
		shareMyLocationClick();
		shareMyLocationBTN();
		if(qc.mplPrmsn.isDisplayed()) {
			
			driver.navigate().back();
		}
		continueBtn(); 
		if(qc.entityHdr.isDisplayed()) {
			
			driver.navigate().back();
		}
		Assert.assertTrue(qc.select8HourDuration.isDisplayed(),"select duration not display");
		qc.select8HourDuration.click();
		qc.selectContactBtn.click();
		
		Assert.assertTrue(qc.allowPermsn.isDisplayed(),"Failed");
		qc.allowPermsn.click();
		
		Assert.assertTrue(qc.contactList.get(1).isDisplayed(),"select duration not display");
		qc.contactList.get(1).click();
		
		Assert.assertTrue(qc.sendButton.isDisplayed(),"select duration not display");
		qc.sendButton.click();
		bf.toastMsg("Your location has been shared");
	}
	
	
	public void loginVerification() {
		bf.sleepWait(5);
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.ProfileEditIconclick();
		String uname = bp.loginUName.getText();
		String uemail = bp.loginUMail.getText();
		String umobile = bp.loginUNumber.getText();
		String userId = bp.loginUserId.getText();
		
		boolean credentialMatched = USERNAME.equals(uname) || USERNAME.equals(uemail) || USERNAME.equals(umobile) || USERNAME.equals(userId);
		Assert.assertTrue(credentialMatched , "Username mismatched");
		Reporter.log("Login and verification successfully " , true);
		bf.sleepWait(5);
		
		driver.navigate().back();
		bf.sleepWait(4);
		driver.navigate().back();
		bf.sleepWait(4);
		
	}

	//TC-10
	public void shareLocationWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		loginVerification();
		shareLocationLink();
	}
	
	//TC-11
	public void shareLocationWithOutLogin() {
		bf.mapplsPermissions();
		shareMyLocationClick();
		bf.mapplsLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		shareMyLocationClick();
		shareLocationLink();
	}

	
//	====================mapls pin visibility 
	public void mapplsPinClick() {
		bf.qcswipeUpUntilElementDisplayed(qc.getPin, 8);
		//bf.swipeDownUntilElementDisplayed(qc.getPin, 6);
		qc.getPin.click();
		Reporter.log("clicked 'Share my location' ", true);
		bf.sleepWait(3);
	}
	
	//TC-12
	public void getMapplsPin() {
		bf.mapplsPermissions();
		mapplsPinClick();
		Assert.assertTrue(qc.pinVisibility.isDisplayed(), "Mappls pin button not visible");
	    Reporter.log("Mappls Pin Button visible ", true);
	}


//	set home address login and without login
	public void setHomeClick() {
		bf.visibilitys(qc.homeClick);
		qc.homeClick.click();
	}
	
	public void fourWheelerClick() {
		qc.fourWheeler.click();
		bf.sleepWait(3);
	}
	
	public void twoWheelerClick() {
		qc.twoWheeler.click();
		bf.sleepWait(3);
	}
	
	public void cabClick() {
		qc.cab.click();
		bf.sleepWait(3);
	}
	
	public void walkClick() {
		qc.walking.click();
		bf.sleepWait(3);
	}
	
	 
	public void setHomeAddress() {
		bf.Hamburgerclick();
		bf.visibilitys(mp.mySavesHambrgrMenu);
		mp.mySavesHambrgrMenu.click();
		
		bf.visibilitys(mp.mySavesListText.get(0));
		mp.mySavesListText.get(0).click();
		searchInputForMySaves();
	}
	
	
	public void dlteHomeAddress() {
		bf.Hamburgerclick();
		bf.visibilitys(qc.mySavesHambrgrMenu);
		qc.mySavesHambrgrMenu.click();
		
		bf.visibilitys(mp.homeList);
		WebElement editBtn = mp.homeList.findElement(By.id("com.mmi.maps:id/btn_layout"));
        
		bf.visibilitys(editBtn);
		editBtn.findElement(By.id("com.mmi.maps:id/btn_more")).click();
		
		
		bf.visibilitys(mp.dltAddress);
        mp.dltAddress.click(); 
        
        bf.visibilitys(mp.cnfmDlt);
        mp.cnfmDlt.click();
	}

	public void qcHomeAddressVerification() {
		
		bf.qcswipeUpUntilElementDisplayed(qc.homeAdrsAvailble, 8);
		//bf.swipeDownUntilElementDisplayed(qc.homeAdrsAvailble, 6);
				
		if(qc.homeAdrsAvailble.getText().equalsIgnoreCase("Set Address")) {

			bf.back();
			bf.visibilitys(qc.homePage);
			
			//set home address from my-saves
			setHomeAddress();
			bf.sleepWait(5);
			bf.back(); 
			Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to home page redirected");
			Reporter.log("Home page redirected", true);
//			bf.visibilitys(qc.homePage); 
			
	        bf.qcswipeUpUntilElementDisplayed(qc.homeSectionVisble, 8);
	        //bf.swipeDownUntilElementDisplayed(qc.homeSectionVisble, 6);
	        
	        Assert.assertFalse(qc.homeAdrsAvailble.getText().equalsIgnoreCase("Set Address"),"Failed");
	        Reporter.log("home address added", true);
			
		} else {
			
			System.out.println("home address already set : " + qc.homeAdrsAvailble.getText());
			bf.back();
			
			dlteHomeAddress();
			
	        bf.back();
	        
	        bf.visibilitys(qc.homePage);
	        
	        Assert.assertTrue(qc.homeAdrsAvailble.getText().equalsIgnoreCase("Set Address"),"Failed");
	        Reporter.log("home address deleted", true);
		}
	}
	//TC-13
	public void setHomeAddressWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		qcHomeAddressVerification();
	}


	//TC-14
	public void setHomeAddressWithOutLogin() {
		bf.mapplsPermissions();
		bf.sleepWait(3);
		bf.qcswipeUpUntilElementDisplayed(qc.homeSectionVisble, 8);
		//bf.swipeDownUntilElementDisplayed(qc.homeSectionVisble, 6);
		setHomeClick();
		Assert.assertEquals(qc.postMapPopUpMsgWOLTxt.getText(), "Add Home");
		Reporter.log("'post an Issue' login pop up window visible", true);
		
		qc.postMapCancelLoginBtn.click();
		
		Assert.assertEquals(qc.wlcmMapplsPageQA.getText(), "Welcome to Mappls!");
		Reporter.log("cancel login clicked", true);
	}
	
//	============set work address=======================
	
	
	
	public void setWorkClick() {
		bf.visibilitys(qc.workclick);
		qc.workclick.click();
		Reporter.log("clicked 'Set Work' ", true);
	}
	
	public void setWorkAddress() {
		bf.Hamburgerclick();
		bf.visibilitys(mp.mySavesHambrgrMenu);
		mp.mySavesHambrgrMenu.click();
		bf.visibilitys(mp.mySavesListText);
		mp.mySavesListText.get(1).click();
		searchInputForMySaves();
	}
	
	public void dlteWorkAddress() {
		bf.Hamburgerclick();
		bf.visibilitys(qc.mySavesHambrgrMenu);
		qc.mySavesHambrgrMenu.click();
		WebElement editBtn = mp.workList.findElement(By.id("com.mmi.maps:id/btn_layout"));
        editBtn.findElement(By.id("com.mmi.maps:id/btn_more")).click();
        bf.visibilitys(mp.dltAddress);
        mp.dltAddress.click(); 
        bf.visibilitys(mp.cnfmDlt);
        mp.cnfmDlt.click();
	}
	
	public void qcWorkAddressVerification() {
		if(qc.workAdrsAvailble.getText().equalsIgnoreCase("Set Address")) {

			driver.navigate().back();
			
			setWorkAddress();
			bf.sleepWait(2);
			driver.navigate().back(); // back to the home page
			bf.visibilitys(bp.hamburgerIconClick);
	        
	        bf.qcswipeUpUntilElementDisplayed(qc.workAdrsAvailble, 8);
	        //bf.swipeDownUntilElementDisplayed(qc.workAdrsAvailble, 6);
	        Assert.assertFalse(qc.workAdrsAvailble.getText().equalsIgnoreCase("Set Address"),"Failed");
	        Reporter.log("work address added", true);
			
		} else {
			System.out.println("home address already set : " + qc.workAdrsAvailble.getText());
			driver.navigate().back();
			
			dlteWorkAddress();
			bf.sleepWait(2);
			driver.navigate().back(); // back to the home page
			bf.visibilitys(bp.hamburgerIconClick);
			bf.sleepWait(3);
			
	        bf.qcswipeUpUntilElementDisplayed(qc.workAdrsAvailble, 8);
	        //bf.swipeDownUntilElementDisplayed(qc.workAdrsAvailble, 6);
	        Assert.assertTrue(qc.workAdrsAvailble.getText().equalsIgnoreCase("Set Address"),"Failed");
	        Reporter.log("work address deleted", true);
		}
	}
	
	//TC-15
	public void setWorkAddressWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.qcswipeUpUntilElementDisplayed(qc.homeSectionVisble, 8);
		//bf.swipeDownUntilElementDisplayed(qc.homeSectionVisble, 6);
		qcWorkAddressVerification();
	}
	
	//TC-16
	public void setWorkAddressWithOutLogin() {
		bf.mapplsPermissions();
		bf.qcswipeUpUntilElementDisplayed(qc.homeSectionVisble, 8);
		//bf.swipeDownUntilElementDisplayed(qc.homeAdrsAvailble, 6);
		setWorkClick();
		
		Assert.assertEquals(qc.postMapPopUpMsgWOLTxt.getText(), "Add Work");
		Reporter.log("'post an Issue' login pop up window visible", true);
		
		qc.postMapCancelLoginBtn.click();
		bf.sleepWait(4);
		
		Assert.assertEquals(qc.wlcmMapplsPageQA.getText(), "Welcome to Mappls!");
		Reporter.log("cancel login clicked", true);	
	}
	
	public void swipeUpUntilHomeVisble() {
		bf.visibilitys(bp.btmSheet);
		if (bp.btmSheet.isDisplayed()) {
			
			int maxSwipes = 10; 
			for (int i = 0; i < maxSwipes; i++) {
				bf.scrollUp(1);
				bf.sleepWait(2);
				if (qc.homeSectionVisble.isDisplayed()) {
					System.out.println("Element is displayed after " + (i + 1) + " swipes");
					break; 
				}
			}
		}
	}

}

	
	

