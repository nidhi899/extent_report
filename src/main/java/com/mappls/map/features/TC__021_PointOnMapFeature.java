package com.mappls.map.features;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__008_MySavesPage;
import com.mappls.map.pages.TC__010_AddPlacesPage;
import com.mappls.map.pages.TC__012_QuickAccessMenuPage;
import com.mappls.map.pages.TC__020_MapLayerPage;
import com.mappls.map.pages.TC__021_PointOnMapPage;
import com.mappls.map.utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__021_PointOnMapFeature {

	private static final String USERNAME = "nidhi1234";
    private static final String PASSWORD = "Mvn@1234";
    private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful";

	
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	Actions ac;
	TC__021_PointOnMapPage pp;
	TC__020_MapLayerFeature mf;
	TC__020_MapLayerPage mlp;
	
	TC__008_MySavesPage msp;
	TC__012_QuickAccessMenuPage qcp;
	TC__010_AddPlacesPage ap;
	
	
	
	public TC__021_PointOnMapFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		ac = new Actions();
		pp = new TC__021_PointOnMapPage(driver);
		mf = new TC__020_MapLayerFeature(driver);
		mlp = new TC__020_MapLayerPage(driver);
		msp = new TC__008_MySavesPage(driver);
		qcp = new TC__012_QuickAccessMenuPage(driver);
		ap = new TC__010_AddPlacesPage(driver);
	}
	
	public void isUserAbleToLongPressOnMap() {
		bf.mapplsPermissions();
		
		ac = new Actions();
		ac.longPress();
		
		bf.sleepWait(3);
		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");
		Reporter.log("Point on map text present in the search input", true);
		
//		Assert.assertTrue(pp.pointMapTxt.isDisplayed(),"Failed to display");
		
		Assert.assertTrue(pp.ppBackBtn.isDisplayed(), "Failed to display back button");
		Reporter.log("point on map back button is present", true);
		
		
		Assert.assertTrue(pp.crrntLocationOverFlow.isDisplayed(), "Failed to display current location over flow ");
		Reporter.log("current location is present", true);
		
		Assert.assertTrue(pp.mpLayerIcon.isDisplayed(), "Failed to display map layer over flow icon");
		Reporter.log("Map Layer icon is present", true);
		
		
//		bf.scrollUp(1);
//		ac.swipeUp();
		bf.swipeUpUntilElementDisplayed(pp.saveIcon, 4);
		
		
		Assert.assertTrue(pp.placeDetail.isDisplayed(), "Failed to display place detail card");
		Reporter.log("place detail is display : "+ pp.placeDetail.getText(), true);
		
		Assert.assertTrue(pp.directionBtn.isDisplayed(), "Failed to display 'direction button'");
		Reporter.log("'direction button' is present ", true);
		
		Assert.assertEquals(pp.shareIcon.getText(), "Share");
		Reporter.log("point on map share icon is present", true);
		
		Assert.assertEquals(pp.saveIcon.getText(), "Save");
		Reporter.log("point on map save icon is present", true);
		
		Assert.assertEquals(pp.postIcon.getText(), "Post");
		Reporter.log("point on map post icon is present", true);
		
		Assert.assertTrue(pp.nearestLocation.isDisplayed(), "Failed to display nearest location");
		Reporter.log("nearest location is present : "+ pp.nearestLocation.getText(), true);
		
		
		Assert.assertTrue(pp.missingPlc.isDisplayed(), "Failed to display 'add a missing place'");
		Reporter.log("'Add a missing place' is present ", true);
	}
	
	
	//tc-2
	public void isUserAbleToEnterLblName() {
		bf.mapplsPermissions();

		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		bf.visibilitys(bp.hamburgerIconClick);
		ac = new Actions();
		ac.longPress();

		bf.sleepWait(3);
		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");
		
		bf.swipeUpUntilElementDisplayed(pp.saveIcon, 5);
		
		pp.saveIcon.click();
		
		bf.sleepWait(4);
		
		Assert.assertEquals(pp.enterLablHeaderTxt.getText(), "Please set a label");
		
		String labelName = RandomDataGenerator.generateRandomTestName1();
		
		pp.enterLabelName.sendKeys(labelName);
		
//		bf.sleepWait(4);
		bf.visibilitys(pp.labelDoneBtn);
		pp.labelDoneBtn.click();
		bf.visibilitys(pp.saveIcon);
//		alert window
		Assert.assertEquals(pp.savePlcExixtAlrtMsg.getText(), "Point saved in list \"Points on Map\"");
		Reporter.log("alert window :" + pp.savePlcExixtAlrtMsg.getText(), true);
		
		Assert.assertEquals(pp.saveIcon.getText(), "Saved");
		Reporter.log("Once a place is saved, the 'Save' button name changes to 'Saved'.", true);
		
		//again save place with same name
		pp.saveIcon.click();
		pp.enterLabelName.sendKeys(labelName);
		pp.labelDoneBtn.click();
		Assert.assertEquals(pp.savePlcExixtAlrtMsg.getText(), "Item already in list");
		Reporter.log("alert window :" + pp.savePlcExixtAlrtMsg.getText(), true);
		
		pp.ppBackArrowClick.click();
		
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to redirected to the home screen");
		
		bf.Hamburgerclick();
		
		msp.mySavesHambrgrMenu.click();
		
		Assert.assertEquals(msp.msHeader.getText(), "My Saves");
		
		msp.mySavesListText.get(5).click();
		
		String labelNameTxt = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_pin_name\" and @text=\"" + labelName + "\"]";
		WebElement pointOnMapListAdded =  driver.findElement(By.xpath(labelNameTxt));
		
		bf.swipeUpUntilElementDisplayed(pointOnMapListAdded, 10);
		Reporter.log("point on map added : " + pointOnMapListAdded.getText(), true);
		
		
	}
	
	
	
	//tc-3
	public void savePointPlcPopupHide() {
//		bf.mapplsPermissions();
//
//		ac = new Actions();
//		ac.longPress();
//
//		bf.sleepWait(3);
//		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");
//		
//		bf.swipeUpUntilElementDisplayed(pp.saveIcon, 4);
//		
//		pp.saveIcon.click();
//		
//		Assert.assertEquals(pp.popUpWindowLoginHdr.getText(), "Save to list");
//		
//		pp.cancelLogin.click();
//		
//		Reporter.log("cancel button clicked", true);
//		
//		bf.visibilitys(pp.directionBtn);
		
		bf.mapplsPermissions();

		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		
		ac = new Actions();
		ac.longPress();

		bf.sleepWait(3);
		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");
		
		bf.swipeUpUntilElementDisplayed(pp.saveIcon, 5);
		
		Assert.assertEquals(pp.saveIcon.getText(), "Save");
		
		pp.saveIcon.click();
		
		bf.sleepWait(4);
		
		Assert.assertEquals(pp.enterLablHeaderTxt.getText(), "Please set a label");
		Reporter.log("Alert window : " + pp.enterLablHeaderTxt.getText(), true);
		bf.back();
		
		Assert.assertEquals(pp.saveIcon.getText(), "Save");
		Reporter.log("Alert popup hide and back to the poin on map page", true);
		
		
		
		
		
	}
	
	
	
	public void isPostButtonClickable() {
		bf.mapplsPermissions();

		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		
		ac = new Actions();
		ac.longPress();

		bf.sleepWait(3);
		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");
		
		bf.swipeUpUntilElementDisplayed(pp.postIcon, 5);
		
		pp.postIcon.click();
		
		Assert.assertEquals(qcp.postMapHedrTxt.getText(), "Post on Map");
		
		qcp.anythingClick.click();
		
		qcp.anUpdateClick.click();
		
		qcp.postBtn.click();
			
		Assert.assertEquals(qcp.postMapPostedTxt.getText(), "Posted Successfully");
		Reporter.log("post has been submitted successfuly", true);
		
		Assert.assertTrue(pp.psotSbmittdDesc.isDisplayed(), "Failed");
		Reporter.log("Your post has been submitted successfully.", true);
		
		Assert.assertEquals(pp.viewPostButton.getText(), "View your Post");
		Reporter.log("View your Post is present", true);
		
		Assert.assertEquals(pp.shareBtn.getText(), "Share");
		Reporter.log("Share is present", true);
		
		pp.shareBtn.click();
		
		Reporter.log("link : "+pp.getLinkTxt.getText(), true);
		
		Assert.assertEquals(pp.quickShare.getText(), "QUICK SHARE");
		Reporter.log("'QUICK SHARE' is present", true);
		
		qcp.shareLinkCopyBtn.click();
		
		bf.toastMsg("Copied");
		
	}
	
	
	//tc - 5
	public void nearestLocation() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		ac = new Actions();
		ac.longPress();

		bf.sleepWait(3);
		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");
		
		bf.swipeUpUntilElementDisplayed(pp.postIcon, 5);
		
		Assert.assertEquals(pp.nearestLocation.getText(), "Nearest Location");
		Reporter.log("'Nearest Location' is present", true);
		
		
		Reporter.log("Nearest Location : " + pp.nearestLocationAdrss.getText(), true);
		
		pp.nrstLocationClick.click();
		
		
		Assert.assertTrue(pp.btmSheet.isDisplayed(), "Failed to redirected to the next page");
		Reporter.log("'Nearest Location' bottom sheet is present", true);
		
		Assert.assertEquals(pp.nearstLoctnSerchInput.getText(), pp.nearstLoctnBtmSheet.getText());
		
		Assert.assertTrue(pp.nearstLoctnIcon.isDisplayed(), "Failed to diplay nearest location distance");
		String nearestLocation = pp.nearstLoctnIcon.getText();
		Reporter.log("nearest location : " + nearestLocation, true);
		
		pp.nearstLoctnIcon.click();
		
		bf.swipeUpUntilElementDisplayed(pp.nearByIcon, 3);
		Reporter.log("Nearest page redirected", true);
		
	}
	
	
	//tc-
	public void isUserAbleToAddMissingPlc() {

		bf.mapplsPermissions();

		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("7788949567", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);


		ac = new Actions();
		ac.longPress();

		bf.sleepWait(3);
		Assert.assertEquals(pp.searchInput.getText(), "Point On Map");

		bf.swipeUpUntilElementDisplayed(pp.missingPlc, 5);

		Assert.assertEquals(pp.missingPlc.getText(), "Add A Missing Place");
		Reporter.log("'Add A Missing Place' is present", true);

		pp.missingPlc.click();

		Assert.assertEquals(pp.addPlcHeader.getText(), "Add a Place");
		Reporter.log("'Add a Place' is present", true);

		ap.categoryInput.click();
		List<MobileElement> categorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int listSize = categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(listSize);
			categorySelection.get(randomIndex).click();
			System.out.println("Clicked on random category selection.  - "+randomIndex);
		}
		//for subcategory selection
		ap.subCategoryInput.click();
		List<MobileElement> subCategorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int subCategorySize = subCategorySelection.size();
		if (subCategorySize >= 1) {
			Random rand = new Random();
			int randomSubCategoryIndex = rand.nextInt(subCategorySize);
			subCategorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}


		String plcName = RandomDataGenerator.generateRandomTestName1();

		pp.enterPlcName.sendKeys(plcName);

		pp.submitBtn.click();

		Assert.assertTrue(pp.plcAddedMsg.isDisplayed(),"Failed");

		pp.clickPlcCloseIcon.click();

		pp.ppBackBtn.click();

		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to home screen redirected");

		bf.Hamburgerclick();

		//		msp.plcDetailMySave.click();
		msp.mySavesHambrgrMenu.click();
		Reporter.log("my saves clicked", true);

		msp.mySavesListText.get(2).click();

		Reporter.log("contribution clicked", true);

		bf.visibilitys(pp.contributionList);
		
		
		//
		String ExpectedPlaceName = plcName;
		boolean isPlaceNameFound = false;

		for (WebElement element : pp.contributionList) {
		    String elementText = element.getText().trim(); 
		    
		    if (elementText.equalsIgnoreCase(ExpectedPlaceName)) {
		        Reporter.log(ExpectedPlaceName + " is present in the list.", true);
		        isPlaceNameFound = true;
		        break;
		    }
		}

		Assert.assertTrue(isPlaceNameFound, "Place name '" + ExpectedPlaceName + "' not found in the list.");

	}
	
}
