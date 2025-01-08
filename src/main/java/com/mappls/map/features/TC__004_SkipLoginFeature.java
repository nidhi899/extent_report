package com.mappls.map.features;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__004_SkipLoginPage;
import com.mappls.map.pages.TC__007_MyWorldViewPage;
import com.mappls.map.pages.TC__012_QuickAccessMenuPage;
import com.mappls.map.pages.TC__015_SearchPage;
import com.mappls.map.pages.TC__016_PlaceDetailPage;
import com.mappls.map.pages.TC__019_UserProfilePage;
import com.mappls.map.pages.TC__020_MapLayerPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TC__004_SkipLoginFeature {

	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;
	BaseFeatures bf;
	BasePage bp;
	TC__007_MyWorldViewPage mww;
	TC__019_UserProfilePage uf;
	TC__019_UserProfileFeature upf;
	TC__020_MapLayerPage mp;
	TC__020_MapLayerFeature ml;
	TC__007_MyWorldViewFeature mwwf;
	TC__008_MySavesFeature msf;
	TC__016_PlaceDetailFeature pdf;
	TC__016_PlaceDetailPage pdp;
	TC__017_NavigationFeature ns;
	TC__015_SearchFeature sf;
	TC__015_SearchPage sp;
	TC__004_SkipLoginPage slp;
	TC__018_GetMapplsPinFeature gmp;
	TC__012_QuickAccessMenuFeature qam;
	TC__012_QuickAccessMenuPage qc;
	Actions ac;

	public TC__004_SkipLoginFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		ac = new Actions(driver);
		this.wait = new WebDriverWait(driver, 10);
		mww = new TC__007_MyWorldViewPage(driver);
		uf = new TC__019_UserProfilePage(driver);
		bf = new BaseFeatures(driver);
		upf = new TC__019_UserProfileFeature(driver);
		bp = new BasePage(driver);
		mp = new TC__020_MapLayerPage(driver);
		ml = new TC__020_MapLayerFeature(driver);
		mwwf = new TC__007_MyWorldViewFeature(driver);
		msf = new TC__008_MySavesFeature(driver);
		pdf = new TC__016_PlaceDetailFeature(driver);
		ns = new TC__017_NavigationFeature(driver);
		sf = new TC__015_SearchFeature(driver);
		sp = new TC__015_SearchPage(driver);
		slp = new TC__004_SkipLoginPage(driver);
		gmp = new TC__018_GetMapplsPinFeature(driver);
		qam = new TC__012_QuickAccessMenuFeature(driver);
		qc = new TC__012_QuickAccessMenuPage(driver);
		pdp = new TC__016_PlaceDetailPage(driver);
		
	}

// 1.	Check if Guest User can add contact via My World View
	public void guestContactWorldViewSkip() throws IOException, InterruptedException {
		mwwf.contactSyncGuest();
	}

//2.	Check if Guest User can like via My World View
	public void guestLikeWorldViewSkip() throws IOException, InterruptedException {
		mwwf.helpfulGuest();
	}

// 3.	Check if Guest User can flag via My World View
	public void guestFlagWorldViewSkip() throws IOException, InterruptedException {
		mwwf.myWorldViewFlagWL();
	}

//4. 	Check My Saves
	public void mySavesSkip() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		msf.mySavesClick();
		bf.RequiredLoginBox("My Saves");

	}

	public void myGadgetsClick() {
		bf.visibilitys(slp.myGadgetsInMenu);
		slp.myGadgetsInMenu.click();
		Reporter.log("Clicked 'My Gadgets'", true);
	}

//5.	Check My Gadgets
	public void myGadgetsSkip() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.sleepWait(2);
		myGadgetsClick();
		bf.RequiredLoginBox("My Gadgets");

	}

	public void shareMyLocationClick() {
		bf.visibilitys(slp.shareMyLocInMenu);
		slp.shareMyLocInMenu.click();
		Reporter.log("Clicked 'Share My Location'", true);
	}

//6.	Check Share My Location
	public void shareMyLocationSkip() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		shareMyLocationClick();
		bf.RequiredLoginBox("Share My Location");

	}

	public void getMapplsPinClick() {
		bf.visibilitys(slp.getMapplsPinInMenu);
		slp.getMapplsPinInMenu.click();
		Reporter.log("Clicked 'Get Mappls Pin'", true);
	}

//7.	Check Get Mappls pin
	public void getMapplsPinSkip() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		getMapplsPinClick();
		gmp.getPinBTNClick();
		gmp.getStartedBtnClick();
		gmp.createMPBTNClick();
		bf.RequiredLoginBox("Create Mappls Pin");
	}

	public void addAPlaceClick() {
		bf.visibilitys(slp.AddaPlaceInMenu);
		slp.AddaPlaceInMenu.click();
		Reporter.log("Clicked 'Add a place'", true);
	}

//8.	Check Add a Place
	public void addAPlaceSkip() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addAPlaceClick();
		bf.RequiredLoginBox("Add a place");

	}

//9.	Check Set Home on quick access menu
	public void setHomeQuickAccessMenuSkip() {
		bf.mapplsPermissions();
		bf.sleepWait(3);
		bf.swipeUpUntilElementDisplayed(qc.homeSectionVisble, 10);
		qam.setHomeClick();
		bf.RequiredLoginBox("Add Home");

	}

//10.	Check Set Work on quick access menu
	public void setWorkQuickAccessMenuSkip() {
		bf.mapplsPermissions();
		bf.swipeUpUntilElementDisplayed(qc.homeSectionVisble, 10);
		qam.setWorkClick();
		bf.RequiredLoginBox("Add Work");

	}

//11.	Check report an issue on quick access menu post on map
	public void reportIssueAccessMenuSkip() {
		bf.mapplsPermissions();
		qam.postOnMapClick();
		bf.visibilitys(qc.postMapSelCategory);
		qc.postMapSelCategory.click();
		qam.anUpdateClick();
		qam.postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		qam.locationDoneBTNClick();
		qam.postButtonClick();
		bf.RequiredLoginBox("Post on Map");

	}

//12.	Check Share My Location on quick access menu
	public void shareMyLocationQuickAccessMenuSkip() {
		bf.mapplsPermissions();
		qam.shareMyLocationClick();
		bf.RequiredLoginBox("Share My Location");
//   	shareLocationWithOutLogin();

	}

//13.	Check Get Mappls Pin on quick access menu
	public void getMapplsPinQuickAccessMenuSkip() {
		bf.mapplsPermissions();
		qam.mapplsPinClick();
		gmp.getPinBTNClick();
		gmp.getStartedBtnClick();
		gmp.createMPBTNClick();
		bf.RequiredLoginBox("Create Mappls Pin");

	}

	public void swipeBottomSheetUpwards(WebElement bottomSheet, int num) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(bottomSheet).moveByOffset(0, -num).release().perform();
	}
//     pdp.bottomSheetPlace

	public void reviewByUser() {
		wait.until(ExpectedConditions.visibilityOf(slp.reviewByUserHeader));
		Assert.assertTrue(slp.reviewByUserHeader.isDisplayed(), "Review by Users should appear");
		String txt = slp.reviewByUserHeader.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Reviews By Users";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");

		wait.until(ExpectedConditions.visibilityOf(slp.reviewViewAll));
		Assert.assertTrue(slp.reviewViewAll.isDisplayed(), "Review by Users  View All should appear");
		slp.reviewViewAll.click();
		Reporter.log("View All Clicked", true);
		bf.sleepWait(4);

		wait.until(ExpectedConditions.visibilityOf(slp.ReviewLayout));
		Assert.assertTrue(slp.ReviewLayout.isDisplayed(), "Review Layout should appear");
		slp.ReviewLayout.click();
		Reporter.log("LAyout is clicked", true);
		bf.sleepWait(4);

		wait.until(ExpectedConditions.visibilityOf(slp.reviewBtmLayer));
		Assert.assertTrue(slp.reviewBtmLayer.isDisplayed(), "Review  bottom Layout should appear");

		wait.until(ExpectedConditions.visibilityOf(slp.likeflagLayout));
		Assert.assertTrue(slp.likeflagLayout.isDisplayed(), "Like Flag Layout should appear");

	}

	public void likeReviewByUSer() {
		wait.until(ExpectedConditions.visibilityOf(slp.likeBtn));
		Assert.assertTrue(slp.likeBtn.isDisplayed(), "Helpful should appear");

		String txt = slp.likeBtn.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Helpful";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");

		slp.likeBtn.click();
	}

//14.	Check Like via Review By users
	public void likeReviewByUserSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		reviewByUser();
		likeReviewByUSer();
		bf.RequiredLoginBox("Make Review/Post as helpful");

	}

	public void flagReviewByUser() {
		wait.until(ExpectedConditions.visibilityOf(slp.flagbtn));
		Assert.assertTrue(slp.flagbtn.isDisplayed(), "Flag should appear");

		String txt = slp.flagbtn.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Flag";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");

		slp.flagbtn.click();
	}

//15.	Check Flag via Review By User
	public void flagReviewByUserSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);

		reviewByUser();
		flagReviewByUser();
		bf.RequiredLoginBox("Flag a Post / Review");
	}

	public void addAReview() {
		wait.until(ExpectedConditions.visibilityOf(slp.AddAREviewFooter));
		Assert.assertTrue(slp.AddAREviewFooter.isDisplayed(), "Add A Review Footer should  appear");

		String txt = slp.AddAREviewFooter.getText().trim();
		Reporter.log("Text found  : " + txt, true);
//   		String expectedTxt = "Add a review";
//  		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");

		slp.AddAREviewFooter.click();
	}

	
//16.	Check Add Review on place detail page
	public void addReviewOnPlaceDetailPageSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 500);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 300);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		addAReview();
		bf.RequiredLoginBox("Add a review");

	}
	
	


	public void longPress() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth()/2;
		int startY = 545;

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(400)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}
//17.	Check reporting through Point on Map
	public void addReportPointOnMapSkip() {
		bf.mapplsPermissions();
		longPress();
		bf.sleepWait(3);
		Assert.assertEquals(slp.SearchInput.getText(), "Point On Map");
		Reporter.log("Point on map text present in the search input", true);
		
		Assert.assertTrue(slp.backBtn.isDisplayed(), "Failed to display back button");
		Reporter.log("point on map back button is present", true);
		swipeBottomSheetUpwards(slp.BtmShtPOM, 200);
		bf.sleepWait(3);
		wait.until(ExpectedConditions.visibilityOf(slp.reportPOM));
		Assert.assertTrue(slp.reportPOM.isDisplayed(), "Post should  appear");
        slp.reportPOM.click();
        String randomtext = RandomDataGenerator.generateRandomExperience();
		pdf.postPlace(randomtext);
		pdf.innerPostClick();
		bf.RequiredLoginBox("Post an Issue");
//		RequiredLoginBox("Post an Issue");
		
	}

//18.	Check Save on Place Detail screen
	public void savePlaceDetailPageSkip() throws IOException, InterruptedException {
		pdf.placeDetailSaveWL();
	}

//19.	Check Report on Place Detail screen
	public void reportPlaceDetailPageSkip() throws IOException, InterruptedException {
		pdf.placeDetailPostWL();
	}

//20.	Check Review on place detail page
	public void reviewPlaceDetailPageSkip() throws IOException, InterruptedException {
		pdf.placeDetailReviewWL();
	}

	public void SuggestAnEdit() {
		wait.until(ExpectedConditions.visibilityOf(slp.suggestAnEdit));
		Assert.assertTrue(slp.suggestAnEdit.isDisplayed(), "Information location address should appear");
		String txt = slp.suggestAnEdit.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Suggest An Edit";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");
		slp.suggestAnEdit.click();

	}

//21.	Check Suggest an edit on Place Detail screen//75
	public void suggestAnEditPlaceDetailPageSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		SuggestAnEdit();
		bf.RequiredLoginBox("Edit a place");
	}

	public void postByUser() {
		wait.until(ExpectedConditions.visibilityOf(slp.postsByUSer));
		Assert.assertTrue(slp.postsByUSer.isDisplayed(), "Posts By User should appear");
		String txt = slp.postsByUSer.getText();
		Reporter.log("Text found  : " + txt, true);
		
		wait.until(ExpectedConditions.visibilityOf(slp.reportContainerLayout));
		Assert.assertTrue(slp.reportContainerLayout.isDisplayed(), "post layout should appear");
	    slp.reportContainerLayout.click();
	    Reporter.log("Layout is clicked", true);
		bf.sleepWait(4);

		wait.until(ExpectedConditions.visibilityOf(slp.reportBtmShtLayer));
		Assert.assertTrue(slp.reportBtmShtLayer.isDisplayed(), "Post Details   bottom Layout should appear");

		wait.until(ExpectedConditions.visibilityOf(slp.flagLikeCont));
		Assert.assertTrue(slp.flagLikeCont.isDisplayed(), "Like Flag Layout should appear");

		
	}
	public void likeONIssues() {
		wait.until(ExpectedConditions.visibilityOf(slp.postLike));
		Assert.assertTrue(slp.postLike.isDisplayed(), "Helpful Button  should appear");
		String txt = slp.postLike.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Helpful";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");
		slp.postLike.click();

	}

//22.	Check Like on Issues Reported Here
	public void likeOnIssuesPlaceDetailPageSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 500);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 400);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 300);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		postByUser();
		likeONIssues();
		bf.RequiredLoginBox("Make Review/Post as helpful");

	}

	public void flagOnIssues() {
		wait.until(ExpectedConditions.visibilityOf(slp.postFlag));
		Assert.assertTrue(slp.postFlag.isDisplayed(), "Flag Button should appear");
		String txt = slp.postFlag.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Flag";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");
		slp.postFlag.click();
	}

//23.	Check Flag on Issues Reported Here
	public void flagOnIssuesPlaceDetailPageSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 500);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 300);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 300);
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 300);
		postByUser();
		flagOnIssues();
		bf.RequiredLoginBox("Flag a Post / Review");

	}

	public void AddImage() {
		wait.until(ExpectedConditions.visibilityOf(slp.addAnImage));
		Assert.assertTrue(slp.addAnImage.isDisplayed(), "Information location address should appear");
		String txt = slp.addAnImage.getText();
		Reporter.log("Text found  : " + txt, true);
		String expectedTxt = "Add Image";
		Assert.assertEquals(txt.toLowerCase(), expectedTxt.toLowerCase(), "The text did not match the expected value.");
		slp.addAnImage.click();
	}

//24.	Check Add an Image on place detail screen
	public void addAnImagePlaceDetailPageSkip() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		sf.searchBar();
		String randomPlace = "Ranchi";
		sf.searchPlaceTextSearch(randomPlace);
		pdf.placeDetailLayoutClick();
		swipeBottomSheetUpwards(pdp.bottomSheetPlace, 200);
		AddImage();
		bf.RequiredLoginBox("Add an image");
	}

//25.	Check Set as Home on place detail screen
	public void setAsHomePlaceDetailPageSkip() throws InterruptedException, IOException {
		pdf.placeSetAsHomeWL();
	}

//26.	Check Set as Work on place detail screen
	public void setAsWorkPlaceDetailPageSkip() throws IOException, InterruptedException {
		pdf.placeSetAsWorkWL();
	}

	public void testFindFrameLayoutAndAddMissingPlaceNearbyCategories() {
		// Locate the RecyclerView using its resource ID
		MobileElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/poi_list"));

		boolean frameLayoutFound = false;

		// Loop until the FrameLayout is found
		while (!frameLayoutFound) {
			try {
				// Attempt to locate the FrameLayout within the RecyclerView
				MobileElement frameLayout = recyclerView.findElement(By.id("com.mmi.maps:id/card_view_missing_place"));
				frameLayoutFound = frameLayout.isDisplayed();

				if (frameLayoutFound) {
					Reporter.log("FrameLayout found at the end of the RecyclerView.", true);

					// Locate the RelativeLayout within the FrameLayout
					MobileElement relativeLayout = frameLayout
							.findElement(By.id("com.mmi.maps:id/fragment_poi_result_missing_place"));

					// Get the two TextViews inside the RelativeLayout
					MobileElement firstTextView = relativeLayout
							.findElement(By.id("com.mmi.maps:id/fragment_poi_result_missing_place_title"));
					MobileElement secondTextView = relativeLayout
							.findElement(By.id("com.mmi.maps:id/fragment_poi_result_missing_place_sub_title"));

					// Log the text of both TextViews
					Reporter.log("TextView 1: " + firstTextView.getText(), true);
					Reporter.log("TextView 2: " + secondTextView.getText(), true);

					// Check if the second TextView has the expected text
					String expectedText = "Add A Missing Place";
					if (secondTextView.getText().equals(expectedText)) {
						Reporter.log("Second TextView has the expected text: " + expectedText, true);

						// Click the second TextView
						secondTextView.click();
						Reporter.log("Clicked on 'Add a missing place' option.", true);
					} else {
						Reporter.log("Second TextView does not have the text: " + expectedText, true);
					}
				}
			} catch (NoSuchElementException e) {
				// If FrameLayout not found, swipe up to scroll through the RecyclerView
				Reporter.log("FrameLayout not found, scrolling down.", true);
				sf.swipeBottomSheetUpwards(recyclerView);
//    	            swipeUpInRecyclerView(recyclerView);
			}
		}

		// Final assertion to ensure FrameLayout was found and interacted with if
		// conditions met
		Assert.assertTrue(frameLayoutFound, "FrameLayout should be found at the end of the RecyclerView.");
	}

//27.	Check Add a missing place via Nearby Categories
	public void addMissingPlaceViaNearbyCategoriesSkip() throws IOException {
		bf.mapplsPermissions();
		sf.searchBar();
		sf.searcgCategoryList();
		sf.bottomSheetDisplay();
		sf.handleDistanceAscending();
		testFindFrameLayoutAndAddMissingPlaceNearbyCategories();
		bf.RequiredLoginBox("Add a place");

	}

//28.	Check Save route on navigation screen
	public void saveRouteOnNavigationScreenSkip() throws IOException, InterruptedException {
		ns.saveRouteWL();
	}

	public void testFindFrameLayoutAndAddMissingPlace() {
		// Locate the RecyclerView using its resource ID
		MobileElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));

		boolean viewGroupFound = false;
		while (!viewGroupFound) {
			try {
				// Attempt to locate the FrameLayout within the RecyclerView
				MobileElement frameLayout = recyclerView.findElement(By.className("android.widget.FrameLayout"));
				MobileElement viewGroup = frameLayout.findElement(By.className("android.view.ViewGroup"));
				viewGroupFound = viewGroup.isDisplayed();

				if (viewGroupFound) {
					Reporter.log("FrameLayout found at the end of the RecyclerView.", true);

					// Locate the two TextViews inside the FrameLayout
					MobileElement firstTextView = frameLayout
							.findElement(By.id("com.mmi.maps:id/fragment_poi_result_missing_place_title"));
					MobileElement secondTextView = frameLayout
							.findElement(By.id("com.mmi.maps:id/fragment_poi_result_missing_place_sub_title"));

					// Log the text of both TextViews
					Reporter.log("TextView 1: " + firstTextView.getText(), true);
					Reporter.log("TextView 2: " + secondTextView.getText(), true);

					// Check if the second TextView has the expected text
					String expectedText = "Add A Missing Place";
					if (secondTextView.getText().equals(expectedText)) {
						Reporter.log("Second TextView has the expected text: " + expectedText, true);

						// Click the second TextView
						secondTextView.click();
						Reporter.log("Clicked on 'Add a missing place' option.", true);
					} else {
						Reporter.log("Second TextView does not have the text: " + expectedText, true);
					}
				}
			} catch (NoSuchElementException e) {
				// If FrameLayout not found, swipe up to scroll through the RecyclerView
				Reporter.log("FrameLayout not found, scrolling down.", true);
				sf.swipeBottomSheetUpwards(recyclerView);
//    	            swipeUpInRecyclerView(recyclerView);
			}
		}

		// Final assertion to ensure FrameLayout was found and interacted with if
		// conditions met
		Assert.assertTrue(viewGroupFound, "FrameLayout should be found at the end of the RecyclerView.");
	}

//29.	Check Add a missing place by searching
	public void addMissingPlaceBySearchSkip() throws IOException {
		bf.mapplsPermissions();
		sf.searchBar();
		sp.searchBarInput.sendKeys("Ranchi");
		testFindFrameLayoutAndAddMissingPlace();
		bf.RequiredLoginBox("Add a place");
	}
//30.	Check Add a missing place via Nearby category  same as 27

//31.	Check Save via Point on map
	public void saveViaPointOnMap() {
		bf.mapplsPermissions();
		longPress();
		bf.sleepWait(3);
		Assert.assertEquals(slp.SearchInput.getText(), "Point On Map");
		Reporter.log("Point on map text present in the search input", true);
		
		Assert.assertTrue(slp.backBtn.isDisplayed(), "Failed to display back button");
		Reporter.log("point on map back button is present", true);
		swipeBottomSheetUpwards(slp.BtmShtPOM, 200);
		bf.sleepWait(3);
		wait.until(ExpectedConditions.visibilityOf(slp.savePOM));
		Assert.assertTrue(slp.savePOM.isDisplayed(), "Save should  appear");
       slp.savePOM.click();
       bf.RequiredLoginBox("Save to list");
	}

//32.	Check Set as Home/Work via Point on map
	public void workViaPointOnMap() {
		bf.mapplsPermissions();
		longPress();
		bf.sleepWait(3);
		Assert.assertEquals(slp.SearchInput.getText(), "Point On Map");
		Reporter.log("Point on map text present in the search input", true);
		
		Assert.assertTrue(slp.backBtn.isDisplayed(), "Failed to display back button");
		Reporter.log("point on map back button is present", true);
		swipeBottomSheetUpwards(slp.BtmShtPOM, 200);
		bf.sleepWait(3);
		wait.until(ExpectedConditions.visibilityOf(slp.overflow));
		Assert.assertTrue(slp.overflow.isDisplayed(), "three dots at corner should  appear");
       slp.overflow.click();
      pdf.clickRadioBtnWork();
      bf.RequiredLoginBox("Add Work");
	}

//33.	check share your Current Location via current location
	public void shareCurrentLocationViaCurrentLocation() {
		bf.mapplsPermissions();
	}

//34.	Check Set as home via current location
	public void setAsHomeViaCurrentLocation() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
	}

//35.	Check Set as work via current location
	public void setAsWorkViaCurrentLocation() {
		bf.mapplsPermissions();
	}

//36.	Check Report issue here via current location
	public void reportIssueHereViaCurrentLocation() {
		bf.mapplsPermissions();

	}

//37.	Check Share live location via current loaction
	public void shareLiveLocationViaCurrentLocation() {
		bf.mapplsPermissions();

	}

//38.	Check Add a place via current location
	public void addPlaceViaCurrentLocation() {
		bf.mapplsPermissions();

	}

//39.	Check add a missing place of nearby parking via current location
	public void addMissingPlaceViaCurrentLocation() {
		bf.mapplsPermissions();

	}

//40.	Check home via search
	public void homeViaSearchSkip() throws IOException {
		sf.SearchHomeSkip();
	}

//41.	Check Work via search
	public void workViaSearchSkip() throws IOException {
		sf.SearchWorkSkip();
	}

	// 42 check fix map at quick access menu
	public void fixMapQuickAccessMenuSkip() {
		bf.mapplsPermissions();
		qam.fixMapClick();
		qam.fixMapSelectCategory();
		qc.fixMapList.get(1).click();
		bf.sleepWait(4);
		qam.postLocationClick();
		bf.visibilitys(qc.pointOnMapAddressText);
		qam.locationDoneBTNClick();
		qam.postButtonClick();
		bf.RequiredLoginBox("Post an Issue");

	}
}
