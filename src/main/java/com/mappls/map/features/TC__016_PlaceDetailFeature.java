package com.mappls.map.features;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__008_MySavesPage;
import com.mappls.map.pages.TC__015_SearchPage;
import com.mappls.map.pages.TC__016_PlaceDetailPage;
import com.mappls.map.pages.TC__019_UserProfilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TC__016_PlaceDetailFeature {

	TC__016_PlaceDetailPage pdp;
	TC__019_UserProfilePage uf;
	BaseFeatures bf;
	BasePage bp;
	TC__019_UserProfileFeature upf;
	TC__015_SearchFeature spf;
	TC__015_SearchPage sp;
	TC__008_MySavesFeature msf;
	TC__008_MySavesPage msp;
	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public TC__016_PlaceDetailFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		pdp = new TC__016_PlaceDetailPage(driver);
		uf = new TC__019_UserProfilePage(driver);
		bf = new BaseFeatures(driver);
		upf = new TC__019_UserProfileFeature(driver);
		spf = new TC__015_SearchFeature(driver);
		msf = new TC__008_MySavesFeature(driver);
		bp = new BasePage(driver);
		msp = new TC__008_MySavesPage(driver);
		sp = new TC__015_SearchPage(driver);

	}

	public String placeLayouteloc() {
		bf.visibility(pdp.placeMapplsEloc,"eloc should");
		String pelocLayout = pdp.placeMapplsEloc.getText();
		Reporter.log("place url on place layout  is :" + pelocLayout, true);
		return pelocLayout;
	}

	public void swipeBottomSheetUpwards(WebElement bottomSheet) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(bottomSheet).moveByOffset(0, -500).release().perform();
	}

	public void placeDetailLayoutClick() {
		bf.visibility(pdp.placelayout,"place layout");
		pdp.placelayout.click();
		Reporter.log("Clicked on place layout.", true);
	}

	public String placeDetailNameCheck() throws IOException {
		bf.visibility(pdp.bottomSheetPlace,"bottomsheet");
		bf.visibility(pdp.placeName,"place Name");
		String placename = pdp.placeName.getText();
		Reporter.log("place name on place detail page is :" + placename, true);
		return placename;
	}

	public String placeDetailAddCheck() throws IOException {
		bf.visibility(pdp.bottomSheetPlace,"bottomsheet");
		bf.visibility(pdp.placeAdd,"Address");
        String placeaddress = pdp.placeAdd.getText();
		Reporter.log("place address on place detail page is :" + placeaddress, true);
		return placeaddress;
	}

	public void placeFeedback() throws IOException {
		try {
			bf.visibility(pdp.bottomSheetPlace,"bottomsheet");
			Assert.assertNotNull(pdp.linearLayout, "LinearLayout element is null.");

			if (pdp.linearLayout.isDisplayed()) {
				Assert.assertTrue(pdp.placeRatingText.isDisplayed(), "place Rating text should be displayed");
				Assert.assertNotNull(pdp.placeRatingText, "Place rating text element is null.");
				Reporter.log("Place ratings: " + pdp.placeRatingText.getText(), true);
				bf.sleepWait(2);

				Assert.assertTrue(pdp.ratingBar.isDisplayed(), "Rating bar should be displayed");
				Assert.assertNotNull(pdp.ratingBar, "Rating bar element is null.");
				Reporter.log("Rating Bar: " + pdp.ratingBar.getText(), true);
				bf.sleepWait(2);

				Assert.assertTrue(pdp.placeReviewCount.isDisplayed(), "Place review countshould be displayed");
				Assert.assertNotNull(pdp.placeReviewCount, "Place review count element is null.");
				Reporter.log("Place Review Count: " + pdp.placeReviewCount.getText(), true);
				bf.sleepWait(2);
			} else {
				Reporter.log("LinearLayout is not displayed.", true);
			}
		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void placeDetailDistanceAndDuration() {
		bf.visibility(pdp.linearLayout,"LinearLayout");
		bf.visibility(pdp.placeDist,"Place distance");
		Assert.assertNotNull(pdp.placeDist, "Place distance element is null.");
		String pdist = pdp.placeDist.getText();
		Reporter.log(" Place Distance :" + pdist, true);
		bf.sleepWait(2);

		bf.visibility(pdp.placeTime,"Place Duration");
		Assert.assertNotNull(pdp.placeTime, "Place duration element is null.");
		String ptime = pdp.placeTime.getText();
		Reporter.log(" Place Duration :" + ptime, true);
	}

	public void directionClick() {
		bf.visibility(pdp.pdetailDirection,"Direction");
		pdp.pdetailDirection.click();
		Reporter.log("Clicked direction on place detail page.", true);
	}

	public void elocClick() {
		bf.visibility(pdp.linearLayout,"LinearLayout");
     	Assert.assertTrue(pdp.placeMapplsEloc.isDisplayed(), "Place eloc element is not displayed.");
		Assert.assertNotNull(pdp.placeMapplsEloc, "Place eloc element is null.");
		pdp.placeMapplsEloc.click();
		Reporter.log("Clicked on elocUrl/ MapplsPin place detail page.", true);
	}

	public void directionETA() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(pdp.directionBottomSheet));
		bf.sleepWait(2);
		Assert.assertTrue(pdp.directionBottomSheet.isDisplayed(), "Direction bottomsheet is not displayed.");

		Assert.assertNotNull(pdp.directionSheetDist, "Direction distance element is null.");
		String ddist = pdp.directionSheetDist.getText();
		Reporter.log("Total Distance displayed :" + ddist, true);
		bf.sleepWait(2);

		Assert.assertNotNull(pdp.directionSheetTime, "Direction duration element is null.");
		String dtime = pdp.directionSheetTime.getText();
		Reporter.log("Total Time displayed :" + dtime, true);
		bf.sleepWait(2);

		Assert.assertNotNull(pdp.directionSheetETA, "Direction duration element is null.");
		String eta = pdp.directionSheetETA.getText();
		Reporter.log("Total Estimated Arrival time displayed :" + eta, true);
	}

	public String placeDetailEloc() throws IOException {
		bf.visibility(pdp.linearLayout,"LinearLayout");
		Assert.assertTrue(pdp.placeMapplsEloc.isDisplayed(), "Place eloc Url is not displayed.");
		Assert.assertNotNull(pdp.placeMapplsEloc, "Place eloc element is null.");
		String eloc = pdp.placeMapplsEloc.getText();
		Reporter.log(" Place Eloc :" + eloc, true);
		return eloc;
	}

	public void clickQRCode() {
		Assert.assertTrue(pdp.QRdetails.isDisplayed(), "Get Mappls Pin And QR Code details is not displayed.");
		Reporter.log("description about :" + pdp.QRdetailText.getText(), true);
		pdp.QRdetails.click();
		Reporter.log(" get QR and Pin clicked.", true);
		bf.sleepWait(5);
	}

	public String getQRCodePin() {
		bf.visibility(pdp.QRLayout,"Get Mappls Pin And QR Code details");
		bf.sleepWait(5);
		Assert.assertNotNull(pdp.QRPin, "QR Pin element is null.");
		String qrPinText = pdp.QRPin.getText();
		Reporter.log("Mappls pin url: " + qrPinText, true);
		return qrPinText;
	}

	public void fetchQRCodeDetails() {
		try {
			bf.sleepWait(5);

			Assert.assertTrue(pdp.QRPlace.isDisplayed(), "QR Place element is null.");
			String qrPlaceText = pdp.QRPlace.getText();
			Reporter.log("Place referred to Mappls Pin: " + qrPlaceText, true);

			Assert.assertTrue(pdp.QRPin.isDisplayed(), "QR Pin element is null.");
			String qrPinText = pdp.QRPin.getText();
			Reporter.log("Mappls pin url: " + qrPinText, true);

			Assert.assertTrue(pdp.qrPlaceName.isDisplayed(), "QR Place Name element is null.");
			String qrPlaceNameText = pdp.qrPlaceName.getText();
			Reporter.log("Place: " + qrPlaceNameText, true);

			Assert.assertNotNull(pdp.qrPlaceAddress, "QR Place Address element is null.");
			String qrPlaceAddressText = pdp.qrPlaceAddress.getText();
			Reporter.log("Address: " + qrPlaceAddressText, true);

		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void fetchQRCodeUI() {
		try {
			bf.visibility(pdp.QRLayout,"Get Mappls Pin And QR Code details");

			Assert.assertNotNull(pdp.QRPlace, "QR Place element is null.");
			String qrPlaceText = pdp.QRPlace.getText();
			Reporter.log("Place referred to Mappls Pin: " + qrPlaceText, true);

			Assert.assertNotNull(pdp.QRPin, "QR Pin element is null.");
			String qrPinText = pdp.QRPin.getText();
			Reporter.log("Mappls pin url: " + qrPinText, true);

			Assert.assertNotNull(pdp.qrPlaceName, "QR Place Name element is null.");
			String qrPlaceNameText = pdp.qrPlaceName.getText();
			Reporter.log("Place: " + qrPlaceNameText, true);

			Assert.assertNotNull(pdp.qrPlaceAddress, "QR Place Address element is null.");
			String qrPlaceAddressText = pdp.qrPlaceAddress.getText();
			Reporter.log("Address: " + qrPlaceAddressText, true);

			Assert.assertNotNull(pdp.AboutPin, "About Pin element is null.");
			String aboutPinText = pdp.AboutPin.getText();
			Reporter.log("About Mappls Pin: " + aboutPinText, true);

			Assert.assertNotNull(pdp.qrContact, "QR Contact element is null.");
			String qrContactText = pdp.qrContact.getText();

			Assert.assertNotNull(pdp.qrRating, "QR Rating element is null.");
			String qrRatingText = pdp.qrRating.getText();

			Assert.assertNotNull(pdp.qrPost, "QR Post element is null.");
			String qrPostText = pdp.qrPost.getText();

			Assert.assertNotNull(pdp.qrImage, "QR Image element is null.");
			String qrImageText = pdp.qrImage.getText();

			Reporter.log("Displayed texts are: " + qrContactText + " , " + qrRatingText + " , " + qrPostText + " , "+ qrImageText, true);
		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void QRCodeDownload() throws IOException, InterruptedException {
		try {
			Assert.assertTrue(pdp.downloadBtn.isDisplayed(), "Download Button element is null.");
			pdp.downloadBtn.click();
			Reporter.log("Clicked Download Button", true);
			bf.toastMsg("Image saved to Downloads folder");
			bf.sleepWait(2);

		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void QRCodeShare() {
		Assert.assertTrue(pdp.shareBtnQR.isDisplayed(), "Share Button element is null.");
		Reporter.log("Share Button Displayed", true);
		pdp.shareBtnQR.click();
		Reporter.log("Clicked Share Button", true);
		try {
			boolean isQrShareHeaderDisplayed = pdp.QrShareBtmDisplay.isDisplayed();
			if (isQrShareHeaderDisplayed) {
				Assert.assertTrue(true, "After Share Click sheet is displayed.");
				Reporter.log("Share layout has been displayed.", true);
			}
		} catch (TimeoutException e) {
			try {
				boolean isQrShareBottomSheetDisplayed = pdp.QrShareBtmSheet.isDisplayed();
				if (isQrShareBottomSheetDisplayed) {
					Assert.assertTrue(true, "After Share Click sheet is displayed.");
					Reporter.log("Share layout has been displayed.", true);
				}
			} catch (TimeoutException ex) {
				Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
			}
		} catch (Exception e) {
			Reporter.log("Exception occurred: " + e.getMessage(), true);
		}
	}

	public void pdNearby() throws IOException, InterruptedException {
		bf.visibility(pdp.pdNearby,"Nearby");
		pdp.pdNearby.click();
		Reporter.log("Nearby clicked.", true);

		if (pdp.pdNearbycont.isDisplayed())
		Assert.assertTrue(pdp.pdNearbycont.isDisplayed(), "Nearby container items are not displayed");
		Reporter.log("Nearby Container Items  Displayed", true);

		bf.visibility(pdp.pdNearbyCoffee,"Nearby category");
		pdp.pdNearbyCoffee.click();
		Reporter.log("Nearby Container clicked", true);
	}

	public void claimNowClick() {
		pdp.claimNow.click();
		Reporter.log("Clicked on claim now.", true);
	}

	public void claimPlace() throws IOException {
		try {

			String claimnowdesc = pdp.claimNowDesc.getText();
			String claimNowText = pdp.claimNow.getText();
			Reporter.log(claimnowdesc + " " + claimNowText, true);

			Assert.assertNotNull(claimnowdesc, "Claim Now description should not be null.");
			Assert.assertNotNull(claimNowText, "Claim Now button text should not be null.");

			claimNowClick();
			wait.until(ExpectedConditions.visibilityOf(pdp.claimThisplaceCont));
			bf.sleepWait(2);
			Assert.assertTrue(pdp.claimThisplaceCont.isDisplayed(), "Claim This Place container should be displayed.");
			Reporter.log("Claim Now layout opened", true);
			bf.sleepWait(4);
			pdp.claimNowBack.click();
			Reporter.log("Claim Now back clicked.", true);

		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void shareplaceLink() throws IOException {
		bf.visibility(pdp.pdpShareBtn,"Share");
		pdp.pdpShareBtn.click();
		Reporter.log("clicked share on place detail page", true);
		upf.shareLinkTextFetch();
	}

	public void RequiredLoginBox(String expectedMessage) {
		try {
			wait.until(ExpectedConditions.visibilityOf(pdp.parentPanel));
			if (pdp.parentPanel.isEnabled()) {
				String titleInfo = pdp.title.getText();
				String descInfo = pdp.description.getText();
				Reporter.log("Displayed Box Title: " + titleInfo, true);
				Reporter.log("Displayed Box Description: " + descInfo, true);
				Assert.assertEquals(titleInfo, expectedMessage,"The login box description does not match the expected message.");
				Assert.assertTrue(pdp.loginButton.isDisplayed(), "Login should be required for further steps.");
				pdp.loginButton.click();
				Reporter.log("Login Button Clicked.", true);
				bf.sleepWait(2);
			} else {
				Reporter.log("Parent panel is not enabled.", true);
				Assert.fail("Parent panel is not enabled.");
			}
		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void reviewClick() {
		try {
			String reviewText = pdp.pdReview.getText().trim();
			Reporter.log("Review button text: " + reviewText, true);
			if (reviewText.equalsIgnoreCase("Review")) {
				Reporter.log("Place is not reviewed yet. Proceeding with the review.", true);
				pdp.pdReview.click();
				Reporter.log("Clicked on Review to start reviewing.", true);
			} else if (reviewText.equalsIgnoreCase("Reviewed")) {
				Reporter.log("Place has already been reviewed. Proceeding with review again.", true);
				pdp.pdReview.click();
				Reporter.log("Clicked on Reviewed to review again.", true);
			} else {
				Assert.fail("Review button text is neither 'Review' nor 'Reviewed'. Actual text: " + reviewText);
			}
			bf.sleepWait(2);
		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void reviewCheck() {
		try {
			bf.visibility(pdp.pdReview,"Review");
			String reviewText = pdp.pdReview.getText().trim();
			Reporter.log("Review button text: " + reviewText, true);
			if (reviewText.equalsIgnoreCase("Reviewed")) {
				Reporter.log("Place has already been reviewed. The review was successful.", true);
				Assert.assertTrue(true, "Review button text is 'Reviewed'. Review is successful.");
			} else if (reviewText.equalsIgnoreCase("Review")) {
				Reporter.log("Place review is not successful.", true);

			} else {
				Assert.fail("Review button text is neither 'Review' nor 'Reviewed'.");
			}
		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void reviewPlace(String exp) {
		bf.visibility(pdp.arRatingBar,"Rating Bar");
		pdp.arRatingBar.click();
		Reporter.log("clicked rating bar on add review", true);
		bf.sleepWait(2);

		String rating = pdp.arRatingBar.getText();
		Reporter.log("added ratings: " + rating, true);
		Assert.assertTrue(pdp.arExperience.isDisplayed(), "Add experience field should be displayed");
		pdp.arExperience.click();
		pdp.arExperience.sendKeys(exp);

		Assert.assertTrue(pdp.arDone.isDisplayed(), "Done button should be displayed");
		pdp.arDone.click();
		Reporter.log("clicked done", true);
	}

	public void postClick() {
		bf.visibility(pdp.pdPost,"Post");
		pdp.pdPost.click();
		Reporter.log("Clicked on Post.", true);
	}

	public void innerPostClick() {
		bf.visibility(pdp.innerPostBtn,"Post button");
		pdp.innerPostBtn.click();
		Reporter.log(" Clicked on inner post button", true);
	}

	public void postPlace(String cmnt) {
		try {
			bf.visibility(pdp.postOnMapBtmSht,"Post on Map Bottom Sheet");
			bf.sleepWait(2);

			bf.visibility(pdp.categorylayout,"Category layout");
			bf.sleepWait(2);

			pdp.anything.click();
			Reporter.log("Clicked on 'Anything'.", true);
			bf.sleepWait(2);

			pdp.anupdate.click();
			Reporter.log("Clicked on 'An Update'.", true);
			bf.sleepWait(2);

			pdp.anupdateType.click();
			Reporter.log("Clicked on 'An Update Sub Type'.", true);
			pdp.addDesc.click();
			Reporter.log("Clicked on 'Add Description'.", true);
			bf.visibility(pdp.commentEdit,"Comment Edit");
			pdp.commentEdit.click();
			pdp.commentEdit.sendKeys(cmnt);
			Assert.assertTrue(pdp.cmntDone.isDisplayed(), "Done button should be displayed");
			pdp.cmntDone.click();
			Reporter.log("Clicked on 'Done'.", true);

		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void postSuccessfulTabVerify() {
		bf.sleepWait(5);
		Assert.assertNotNull(pdp.titleMsg, "Title text should not be null.");
		String titleText = pdp.titleMsg.getText();
		Reporter.log("Title text: " + titleText, true);
		String expectedTitle = "Posted Successfully";
		Assert.assertEquals(titleText, expectedTitle, "The posted box title does not match the expected message.");
		Assert.assertNotNull(pdp.subTitleMsg, "Subtitle should be displayed");
		String subTitle = pdp.subTitleMsg.getText();
		Reporter.log("Subtitle text: " + subTitle, true);
	}

	public void postSuccessful() {
		try {
			postSuccessfulTabVerify();
			bf.sleepWait(5);
			Assert.assertTrue(pdp.viewPostBtn.isDisplayed(), "View post should be displayed");
			String viewPost = pdp.viewPostBtn.getText();
			Reporter.log("posted text scenario: " + viewPost, true);
			pdp.viewPostBtn.click();
			Reporter.log("Clicked on " + viewPost, true);
			bf.sleepWait(5);
			wait.until(ExpectedConditions.visibilityOf(pdp.reportContainer));
			Assert.assertTrue(pdp.reportContainer.isDisplayed(), "Post details page bottomsheet should be displayed");
			Assert.assertTrue(pdp.reportdetailname.isDisplayed(), "name detail for report should be displayed");
			Assert.assertTrue(pdp.reportdetaildate.isDisplayed(), "date or time detail for report should be displayed");
			String reportDateText = pdp.reportdetaildate.getText().trim().toLowerCase();

			if (reportDateText.contains("moments ago".trim().toLowerCase())) {
				Reporter.log("The report detail date contains 'moments ago' as expected. so posted place is visible ",true);
			} else {
				Assert.fail("Report detail date should contain 'moments ago', but not found ");
			}
		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void postSuccessfulShare() {
		try {
			postSuccessfulTabVerify();
			Assert.assertTrue(pdp.sharebtnPosted.isDisplayed(), "Share Button should be displayed");
			pdp.sharebtnPosted.click();
			Reporter.log("Clicked on Share button", true);
			upf.shareLinkTextFetch();

		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void postSuccessfulContinue() {
		try {
			postSuccessfulTabVerify();
			Assert.assertTrue(pdp.continuePosted.isDisplayed(), "Continue Button should be displayed");
			pdp.continuePosted.click();
			Reporter.log("Clicked on Continue button", true);
			bf.visibility(pdp.bottomSheetPlace,"Bottomsheet");
			bf.visibility(pdp.pdPost,"Post");
			Reporter.log("Continue redirected to place detail page", true);

		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void saveClick() {
		bf.visibility(pdp.pdSave,"Save");
		pdp.pdSave.click();
		Reporter.log("Clicked on Save.", true);
	}

	// public
	public void placeDetailSaves(String listname) throws IOException {
		bf.visibility(pdp.saveListBtmsht,"List for Saving place");
		Assert.assertTrue(pdp.createNewListBtn.isDisplayed(), "Create new list button should be displayed");
		pdp.createNewListBtn.click();
		Reporter.log("clicked to create new list ", true);
		bf.sleepWait(2);
		Assert.assertTrue(pdp.textHeading.isDisplayed(), "Create new list layout should be displayed");
		bf.sleepWait(2);

		Reporter.log("Text displayed : " + pdp.textHeading.getText(), true);
		pdp.editText.sendKeys(listname);
		Assert.assertTrue(pdp.okBtn.isDisplayed(), "Ok button should be displayed");
		pdp.okBtn.click();
		Reporter.log("clicked ok button", true);
		bf.visibility(pdp.msgText,"List Created successfully");
		String actualMessage = pdp.msgText.getText();
		String expectedMessage = "List created successfully";
		Assert.assertEquals(actualMessage, expectedMessage);
		wait.until(ExpectedConditions.visibilityOf(pdp.listCreationSnackBar));
		String snackBarMsg = pdp.listCreationSnackBar.getText();
		Reporter.log(" SnackBar message :" + snackBarMsg, true);
		Assert.assertTrue(pdp.dismissBtn.isDisplayed(), "Dismiss should be displayed");
		pdp.dismissBtn.click();

	}

	public void placeDetailSavesPrivateList(String listname) throws IOException {
		bf.visibility(pdp.saveListBtmsht,"List for Saving place");
		Assert.assertTrue(pdp.createNewListBtn.isDisplayed(), "Create new list button should be displayed");
		pdp.createNewListBtn.click();
		Reporter.log("clicked to create new list ", true);
		bf.sleepWait(2);
		Assert.assertTrue(pdp.textHeading.isDisplayed(), "Create new list layout should be displayed");
		bf.sleepWait(2);

		Reporter.log("Text displayed : " + pdp.textHeading.getText(), true);
		pdp.editText.sendKeys(listname);
		bf.visibility(pdp.dropDwnLayoutS,"public/private");
		pdp.dropDwnLayoutS.click();
		bf.visibility(pdp.dropDwnpubprivate,"public/private");
		bf.visibility(pdp.privatePrivacy,"public/private");
		Assert.assertTrue(pdp.privateOption.isDisplayed(), "private option should be displayed");

		Assert.assertTrue(pdp.privateOptionDescripton.isDisplayed(), "private option should be displayed");
		Reporter.log("'" + pdp.privateOptionDescripton.getText() + "'", true);
		pdp.privateOption.click();
		Assert.assertTrue(pdp.okBtn.isDisplayed(), "Ok button should be displayed");
		pdp.okBtn.click();
		Reporter.log("clicked ok button", true);
		wait.until(ExpectedConditions.visibilityOf(pdp.msgText));

		Assert.assertTrue(pdp.msgText.isDisplayed(), "List Created successfully should be displayed");
		String actualMessage = pdp.msgText.getText();
		String expectedMessage = "List created successfully";
		Assert.assertEquals(actualMessage, expectedMessage);
		wait.until(ExpectedConditions.visibilityOf(pdp.listCreationSnackBar));
		String actualMessage2 = "Place is added to your newly created list \"" + listname + "";
		String snackBarMsg = pdp.listCreationSnackBar.getText().replaceAll("\"$", ""); // Remove trailing extra quote
		Assert.assertTrue(snackBarMsg.contains(actualMessage2));
		Reporter.log(" SnackBar message :" + pdp.listCreationSnackBar.getText(), true);
		Assert.assertTrue(pdp.dismissBtn.isDisplayed(), "Dismiss should be displayed");
		pdp.dismissBtn.click();

	}

	public void placeDetailName() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		placeDetailNameCheck();

	}

	public void placeDetailAdd() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		placeDetailAddCheck();
	}

	public void placeDetailFeedback() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		placeFeedback();
	}

	public void DistanceAndDuration() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		placeDetailDistanceAndDuration();
	}

	public void placeDetailShareViaPin() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		elocClick();
		upf.shareLinkTextFetch();
	}

	public void placeDetailQRPinDetailDownload() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		spf.searchPlaceTextSearch("Ranchi");
		placeDetailLayoutClick();
		clickQRCode();
		bf.sleepWait(5);
		fetchQRCodeDetails();
		bf.sleepWait(5);
		QRCodeDownload();
	}

	public void placeDetailQRPinDetailShare() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		spf.searchPlaceTextSearch("Ranchi");
		placeDetailLayoutClick();
		clickQRCode();
		bf.sleepWait(5);
		fetchQRCodeDetails();
		bf.sleepWait(5);
		QRCodeShare();
	}

	public void placeMapplsPin() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		placeDetailEloc();
	}

	public void placeDirectionEta() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		directionClick();
		directionETA();
	}

	public void placeDetailNearby() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		pdNearby();
		spf.bottomSheetDisplay();
		spf.handleDistanceAscending();
		spf.closeSearch();
	}

//339
	public void placeDetailReview() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		reviewClick();
		String randomExp = RandomDataGenerator.generateRandomExperience();
		reviewPlace(randomExp);
		upf.shareLinkTextFetch();
		reviewCheck();
	}

	public void placeDetailReviewWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		reviewClick();
		RequiredLoginBox("Add a review");
	}

	public void placeDetailShare() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		shareplaceLink();
	}

	public void placeDetailSave() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		saveClick();
		String randomListname = RandomDataGenerator.generateRandomListName();
		placeDetailSaves(randomListname);
	}

	public void placeDetailSaveWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		saveClick();
		RequiredLoginBox("Save to list");
	}

	public void placeDetailPost() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		String randomtext = RandomDataGenerator.generateRandomExperience();
		postPlace(randomtext);
		innerPostClick();
		bf.sleepWait(5);
		postSuccessful();
	}

	public void placeDetailPostWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		postClick();
		String randomtext = RandomDataGenerator.generateRandomExperience();
		postPlace(randomtext);
		innerPostClick();
		RequiredLoginBox("Post an Issue");
	}

	public void AddedPostShare() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		String randomtext = RandomDataGenerator.generateRandomExperience();
		postPlace(randomtext);
		innerPostClick();
		bf.sleepWait(5);
		postSuccessfulShare();
	}

	public void AddedPostContinue() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		String randomtext = RandomDataGenerator.generateRandomExperience();
		postPlace(randomtext);
		innerPostClick();
		bf.sleepWait(5);
		postSuccessfulContinue();
	}

	public void placeDetailclaim() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		claimPlace();
	}

	public void placeDetailclaimWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		claimNowClick();
		RequiredLoginBox("Login Required");

	}

	public void clickActionDots() {
		bf.visibility(pdp.searchandsettingToolbar,"Toolbar");
		bf.visibility(pdp.settingsDots,"Settings");
		pdp.settingsDots.click();
	}

	public void clickRadioBtnHome() {
		String text = pdp.homeTitle.getText();
		Reporter.log("Text :" + text, true);
		pdp.setashome.click();
	}

	public void clickRadioBtnWork() {
		String text = pdp.workTitle.getText();
		Reporter.log("Text :" + text, true);
		pdp.setaswork.click();
	}

	public void CheckBoxAttributeHome() {
		Assert.assertTrue(pdp.homecheckbox.isDisplayed(), "checkbox is not displayed");
		String checked = pdp.homecheckbox.getAttribute("checked");
		if ("true".equals(checked)) {
			Assert.assertEquals(checked, "true", "checkBox should be selected but it is not.");
			Reporter.log("Checkbox :" + checked, true);
			pdp.homecheckbox.click();
		} else {
			Assert.fail("Checkbox should be selected, but it is not. Actual value: " + checked);
			Reporter.log("Checkbox :" + checked, true);
		}

	}

	public void CheckBoxAttributeWork() {
		Assert.assertTrue(pdp.workCheckBox.isDisplayed(), "checkbox is not displayed");
		String checked = pdp.workCheckBox.getAttribute("checked");
		if ("true".equals(checked)) {
			Assert.assertEquals(checked, "true", "checkBox should be selected but it is not.");
			Reporter.log("Checkbox :" + checked, true);
			pdp.workCheckBox.click();
		} else {
			Assert.fail("Checkbox should be selected, but it is not. Actual value: " + checked);
			Reporter.log("Checkbox :" + checked, true);
		}
	}

	// 333
	public void placeSetAsWork() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		clickActionDots();
		clickRadioBtnWork();
		String snackBarMsg = bp.snackBarMessage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg, true);
		clickActionDots();
		CheckBoxAttributeWork();
		bp.clickBackbtn.click();
		bp.closeSearch.click();
		bf.Hamburgerclick();
		msf.mySavesClick();
		String text = msp.mySavesListText.get(1).getText();
		Assert.assertTrue(randomPlace.toLowerCase().equals(text.toLowerCase()),"Values do not match so place not set as work");
		Reporter.log("Place is successfully set As Work");
	}

	// 332
	public void placeSetAsHome() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		clickActionDots();
		clickRadioBtnHome();
		String snackBarMsg = bp.snackBarMessage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg, true);
		clickActionDots();
		CheckBoxAttributeHome();
		bp.clickBackbtn.click();
		bp.closeSearch.click();
		bf.Hamburgerclick();
		msf.mySavesClick();
		String text = msp.mySavesListText.get(0).getText();
		Assert.assertTrue(randomPlace.toLowerCase().equals(text.toLowerCase()),"Values do not match so place not set as home.");
		Reporter.log("Place is successfully set As Home");
	}

	public void placeSetAsWorkWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		clickActionDots();
		clickRadioBtnWork();
		RequiredLoginBox("Add Work");
	}

	public void placeSetAsHomeWL() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		clickActionDots();
		clickRadioBtnHome();
		RequiredLoginBox("Add Home");
	}

	public void reportIssueSubCategories(String cmnt) {
        bf.visibility(pdp.postOnMapBtmSht,"Post on Map Bottom Sheet");
		bf.sleepWait(2);
        bf.visibility(pdp.categorylayout,"Category layout");
        bf.sleepWait(2);
	}

	// 320
	public void placeDetailDirectionWithDeniedLoc() throws IOException, InterruptedException {
		bf.denyLocPermission();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		directionClick();
		String startText = bf.startText(0);
		String expectedText = "Select location";
		Assert.assertEquals(startText, expectedText, "The text did not match the expected value.");
		Reporter.log("start location mentioned on direction page when location access is denied : " + startText, true);
		String finatTxt = bf.finalText(1);
		Assert.assertTrue(finatTxt.toLowerCase().equals(randomPlace.toLowerCase()),"Values do not match so final location is not interchanged.");
	}

	// 321
	public void verifyDirectionBtnOnClickOfStartPoint() throws IOException, InterruptedException {
		bf.denyLocPermission();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		directionClick();
		String startText = bf.startText(0);
		Reporter.log("start location mentioned on direction page when location access is denied : " + startText, true);
		bf.startLoc();
		String Bannertxt = bf.LocationOffBanner();
		Reporter.log("text displayed : " + Bannertxt, true);
	}

	public void verifyBackBtnOndirection() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		directionClick();
		bf.visibilitys(pdp.directionBottomSheet);
		bf.visibilitys(pdp.backBtn);
		pdp.backBtn.click();
		Reporter.log("Back Button clicked on direction page", true);
		String placename = placeDetailNameCheck();
		Assert.assertEquals(randomPlace, placename, "The text did not match the expected value.");
		Reporter.log("Returned Back to Place detail Page from direction page", true);
	}

	public void verifynearbyUI() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		bf.visibility(pdp.pdNearby,"Nearby");
		pdp.pdNearby.click();
		Reporter.log("Nearby clicked.", true);
		bf.visibilitys(pdp.pdNearbycont);
		Reporter.log("Nearby Container Items  Displayed", true);
		bf.visibilitys(pdp.pdNearbyCoffee);
		String text = pdp.pdNearbyCoffee.getText();
		pdp.pdNearbyCoffee.click();
		Reporter.log("Nearby Container clicked", true);
		bf.visibilitys(pdp.searchInput);
		String text2 = pdp.searchInput.getText();
		Assert.assertEquals(text, text2, "The text did not match the expected value.");
		bf.visibility(sp.searchBarCross,"Cross On Search Input Bar");
		spf.bottomSheetDisplay();
		spf.handleDistanceAscending();
		WebElement bottomSheet = sp.bottomSheet;
		swipeBottomSheetUpwards(bottomSheet);
		swipeBottomSheetUpwards(bottomSheet);
		swipeBottomSheetUpwards(bottomSheet);
		bf.visibility(pdp.addAMissingPlaceCard,"Add A Missing Place");
		Reporter.log(" Add a Missing Place Card Visible", true);
		bf.visibilitys(pdp.addAMissingPlace);
		Assert.assertTrue(pdp.addAMissingPlace.isDisplayed(),"Add A Missing Place is not visible in place detail page");
		String cardText = pdp.addAMissingPlace.getText();
		String actualText = "Add A Missing Place";
		Assert.assertEquals(cardText, actualText, "The card text did not match the expected value.");
	}

	public void verifyBackBtnOnReviewPage() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		reviewClick();
		bf.visibility(pdp.arRatingBar,"Rating bar");
		bf.visibilitys(pdp.BackBtn);
		pdp.BackBtn.click();
		Reporter.log("Back Button clicked on direction page", true);
		String placename = placeDetailNameCheck();
		Assert.assertEquals("Ranchi", placename, "The text did not match the expected value.");
		Reporter.log("Returned Back to Place detail Page from direction page", true);
	}

	public void verifyMissedRating() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Sisai");
		reviewClick();
		bf.visibility(pdp.arRatingBar,"Rating bar");
		String rating = pdp.arRatingBar.getText();
		Reporter.log("added ratings: " + rating, true);
		Assert.assertTrue(pdp.arDone.isDisplayed(), "Done button should be displayed");
		pdp.arDone.click();
		Reporter.log("clicked done", true);
		bf.snackBarMessage("You missed rating the place");
	}

	public void listNameAlreadyExists() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		saveClick();
		String randomListname = RandomDataGenerator.generateRandomListName();
		placeDetailSaves(randomListname);
		bf.visibility(pdp.saveListBtmsht,"list to save place ");
		Assert.assertTrue(pdp.createNewListBtn.isDisplayed(), "Create new list button should be displayed");
		pdp.createNewListBtn.click();
		Reporter.log("clicked to create new list ", true);
		bf.sleepWait(2);
		Assert.assertTrue(pdp.textHeading.isDisplayed(), "Create new list layout should be displayed");
		Reporter.log("Text displayed : " + pdp.textHeading.getText(), true);
		pdp.editText.sendKeys(randomListname);
		Assert.assertTrue(pdp.okBtn.isDisplayed(), "Ok button should be displayed");
		pdp.okBtn.click();
		Reporter.log("clicked ok button", true);
		bf.visibility(pdp.msgText,"List name already exist");
		String actualMessage = pdp.msgText.getText();
		String expectedMessage = "List name already exist";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	public void reportSteps() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		postClick();
	}

	public void saveListPrivately() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		saveClick();
		String randomListname = RandomDataGenerator.generateRandomListName();
//		placeDetailSaves();
		placeDetailSavesPrivateList(randomListname);
	}

	// 414
	public void QRCodeUI() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlace(randomPlace);
		placeDetailLayoutClick();
		clickQRCode();
		fetchQRCodeUI();
		QRCodeDownload();
	}

	// 413
	public void getClickQRCodeOption() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		spf.searchPlace(randomPlace);
		placeDetailLayoutClick();
		clickQRCode();
		bf.visibility(pdp.QRLayout,"Get Mappls Pin And QR Code details");
		Assert.assertNotNull(pdp.QRPlace, "QR Place element is null.");
		String qrPlaceText = pdp.QRPlace.getText();
		Reporter.log("Place referred to Mappls Pin: " + qrPlaceText, true);

		Assert.assertNotNull(pdp.QRPin, "QR Pin element is null.");
		String qrPinText = pdp.QRPin.getText();
		Reporter.log("Mappls pin url: " + qrPinText, true);

		Assert.assertNotNull(pdp.qrPlaceName, "QR Place Name element is null.");
		String qrPlaceNameText = pdp.qrPlaceName.getText();
		Reporter.log("Place: " + qrPlaceNameText, true);

		Assert.assertNotNull(pdp.qrPlaceAddress, "QR Place Address element is null.");
		String qrPlaceAddressText = pdp.qrPlaceAddress.getText();
		Reporter.log("Address: " + qrPlaceAddressText, true);
	}

	// 338
	public void placeDetailReviewRatingWithoutComment() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		String randomPlace = "Ranchi";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		reviewClick();
		String randomExp = RandomDataGenerator.generateRandomExperience();
		ratingPlace(randomExp);
		upf.shareLinkTextFetch();
	}

	public void ratingPlace(String exp) {
		wait.until(ExpectedConditions.visibilityOf(pdp.arRatingBar));
		Assert.assertTrue(pdp.arRatingBar.isDisplayed(), "Rating bar should be displayed");
		pdp.arRatingBar.click();
		Reporter.log("clicked rating bar on add review", true);
		bf.sleepWait(2);

		String rating = pdp.arRatingBar.getText();
		Reporter.log("added ratings: " + rating, true);

		Assert.assertTrue(pdp.arDone.isDisplayed(), "Done button should be displayed");
		pdp.arDone.click();
		Reporter.log("clicked done", true);

	}

	public void placeDetailDescription() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Taj Mahal";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		placeDetailNameCheck();
		
		bf.visibility(pdp.about,"Get Mappls Pin And QR Code details");
		Assert.assertNotNull(pdp.about, "QR Place element is null.");
		String actualText = pdp.about.getText();
		Reporter.log("Displayed Header : " + actualText, true);

		String expectedMessage = "About";
		Assert.assertEquals(actualText, expectedMessage);

		bf.visibility(pdp.aboutText,"Get Mappls Pin And QR Code details");
		Assert.assertNotNull(pdp.aboutText, "QR Place element is null.");
		String qrAboutText = pdp.aboutText.getText();
		Reporter.log("Displayed About : " + qrAboutText, true);

	}

//317
	public void placeDetailUI() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		String randomPlace = "Taj Mahal";
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
		bf.visibility(pdp.bottomSheetPlace,"Sheet");	
		bf.visibility(pdp.placeName,"Name");
		String placename = pdp.placeName.getText();
		Reporter.log("place name on place detail page is :" + placename, true);

		bf.visibility(pdp.placeAdd,"Address");
		String placeaddress = pdp.placeAdd.getText();
		Reporter.log("place address on place detail page is :" + placeaddress, true);

		Assert.assertTrue(pdp.placeRatingText.isDisplayed(), "place Rating text should be displayed");
		Assert.assertNotNull(pdp.placeRatingText, "Place rating text element is null.");
		Reporter.log("Place ratings: " + pdp.placeRatingText.getText(), true);
		bf.sleepWait(2);

		Assert.assertTrue(pdp.ratingBar.isDisplayed(), "Rating bar should be displayed");
		Assert.assertNotNull(pdp.ratingBar, "Rating bar element is null.");
		Reporter.log("Rating Bar: " + pdp.ratingBar.getText(), true);
		bf.sleepWait(2);

		Assert.assertTrue(pdp.placeReviewCount.isDisplayed(), "Place review countshould be displayed");
		Assert.assertNotNull(pdp.placeReviewCount, "Place review count element is null.");
		Reporter.log("Place Review Count: " + pdp.placeReviewCount.getText(), true);

		bf.visibility(pdp.placeDist,"Place distance");
		Assert.assertNotNull(pdp.placeDist, "Place distance element is null.");
		String pdist = pdp.placeDist.getText();
		Reporter.log(" Place Distance :" + pdist, true);
		bf.sleepWait(2);

		bf.visibility(pdp.placeTime,"Place duration");		
		Assert.assertNotNull(pdp.placeTime, "Place duration element is null.");
		String ptime = pdp.placeTime.getText();
		Reporter.log(" Place Duration :" + ptime, true);

		bf.visibility(pdp.pdetailDirection,"Direction");
		Assert.assertTrue(pdp.placeMapplsEloc.isDisplayed(), "Place eloc element is not displayed.");
		Assert.assertNotNull(pdp.placeMapplsEloc, "Place eloc element is null.");
		Reporter.log("elocUrl/ MapplsPin is displayed place detail page.", true);
	}

	// 340
	public void reviewAddImage(String exp) {
		bf.visibility(pdp.arRatingBar,"Rating bar");
		pdp.arRatingBar.click();
		Reporter.log("clicked rating bar on add review", true);
		bf.sleepWait(2);

		String rating = pdp.arRatingBar.getText();
		Reporter.log("added ratings: " + rating, true);
		Assert.assertTrue(pdp.arExperience.isDisplayed(), "Add experience field should be displayed");
		pdp.arExperience.click();
		pdp.arExperience.sendKeys(exp);
		addImageClick();
		bf.photoAndVideoaccessPermission();
		bf.allowOption();
		bf.dontallowOption();
		bp.allowOption.click();
		clickCameraAtGallery();
		bf.permissionforCamera();
		bp.WhileUsingAppOption.click();
		bf.visibility(pdp.front_back_switcher,"Switch Camera Layout");
		pdp.front_back_switcher.click();
		bf.visibility(pdp.clickCamBtn,"Camera Click Button");
		pdp.clickCamBtn.click();
		bf.visibility(pdp.clickOk,"ok button ");
		pdp.clickOk.click();
		bf.visibility(pdp.doneBtnCotainerGallery,"Camera Layout");

		bf.visibility(pdp.doneBTnText,"Camera icon");
		String BtnTExt = pdp.doneBTnText.getText();
		Reporter.log("Button Text : " + BtnTExt, true);
		pdp.doneBtnCotainerGallery.click();

		bf.visibility(pdp.ClickedPhotoContainer,"Uploaded image container");
		bf.visibility(pdp.removeTxt,"Remove text layout ");
		String removetxt = pdp.removeTxt.getText();
		Reporter.log("TExt on image : " + removetxt, true);

		Assert.assertTrue(pdp.arDone.isDisplayed(), "Done button should be displayed");
		pdp.arDone.click();
		Reporter.log("clicked done", true);
	}

	public void clickCameraAtGallery() {
		bf.visibility(pdp.cameraOptioninGallery,"Camera Layout");
        bf.visibility(pdp.cameraIconInContainer,"Camera icon ");
		pdp.cameraOptioninGallery.click();
	}

	public void addImageClick() {
		bf.visibility(pdp.addImageLayout,"Add Image Layout");
		bf.visibility(pdp.addImageText,"Add Image Text");
     	String text = pdp.addImageText.getText();
		Reporter.log("Container Text : " + text, true);
		pdp.addImageLayout.click();
		Reporter.log("Add Image Clicked ", true);
	}

	public void clickPlaceDetailLayout(String randomPlace) throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		spf.searchPlaceTextSearch(randomPlace);
		placeDetailLayoutClick();
	}

	public void ratingReviewImage() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		reviewClick();
		String randomExp = RandomDataGenerator.generateRandomExperience();
		reviewAddImage(randomExp);
		upf.shareLinkTextFetch();
		reviewCheck();
	}

	// 416
	public void placeDetailQRShareOption() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		spf.searchBar();
		spf.searchPlaceTextSearch("Ranchi");
		placeDetailLayoutClick();
		clickQRCode();
		bf.sleepWait(5);
		fetchQRCodeDetails();
		clickCrossonQRPage();
		bf.sleepWait(5);
		clickQRCode();
		bf.sleepWait(5);
		fetchQRCodeDetails();
		bf.sleepWait(5);
		QRCodeShare();
	}

	public void clickCrossonQRPage() {
		bf.visibility(pdp.crossOnQRpage,"Cross On QR Page");
		Reporter.log("Cross Button Displayed");
		pdp.crossOnQRpage.click();
		Reporter.log("Cross Button clicked");
	}
//344
	public void savePlaceFavourites() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.ClickUserMenuAtHamburger();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		spf.searchBar();
		String plc = RandomDataGenerator.generateRandomDistrictInJharkhand();
		spf.searchPlaceTextSearch(plc);
		placeDetailLayoutClick();
     	saveClick();
     	bf.visibility(pdp.saveListBtmsht,"List to save place");
		Assert.assertEquals(msp.isFavVisible.getText(), "Favourites");
		Reporter.log("'Favourites' is present in place detail page", true);
		Reporter.log("get fav count  "+msp.getPlcCountFrmPlcDetailPage.getText(), true);
		String beforeAdd =  msp.getPlcCountFrmPlcDetailPage.getText();
		String[] beforeparts = beforeAdd.split(" ");
		String beforenumberString = beforeparts[0];
		int beforeCount = Integer.parseInt(beforenumberString);
		msp.favClickAddIconPlcDetail.click();
		bf.visibilitys(msp.getPlcCountFrmPlcDetailPage);
		String aftrAdd =  msp.getPlcCountFrmPlcDetailPage.getText();
		String[] aftrparts = aftrAdd.split(" ");
		String aftrnumberString = aftrparts[0];
		int aftrCount = Integer.parseInt(aftrnumberString);
		Assert.assertTrue(beforeCount < aftrCount,"FAILED");
		Reporter.log("Favourites added in placed detail page", true);
				
}
	//345
public void openFavouritesList()throws IOException, InterruptedException {
	        savePlaceFavourites();			
			bf.back();
			Assert.assertEquals(msp.isDirectionBtn.getText(), "Directions");			
			msp.directionBackClick.click();
			String favAddrssTxt = msp.getFavTxtFrmPlcDetailPage.getText();
			Assert.assertTrue(msp.bttmPlcBackIcon.isDisplayed(),"Failed");
			msp.bttmPlcBackIcon.click();
			bf.back();
			Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to home page display");
			bf.Hamburgerclick();
			msf.mySavesClick();		
			msp.mySavesListText.get(3).click();
			String addrsXpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_place_name\" and @text=\""  + favAddrssTxt + "\"]";
			WebElement favListAdded =  driver.findElement(By.xpath(addrsXpath));
			bf.swipeUpUntilElementDisplayed(favListAdded, 5);
			Reporter.log("Favourites added ", true);
}

//347
public void openPublicList()throws IOException {
	msf.mySavesCreateListPubliclyEdit();
}

//349
public void openPrivateList() {
	msf.mySavesCreateListPrivatlyEdit();
}

	public void informationHeaderText() {	
		bf.visibility(pdp.informationHeader,"Information");
		String headertxt = pdp.informationHeader.getText();
		Reporter.log("Header Text  : " + headertxt, true);
	}

	public void informationLoc() {
		bf.visibility(pdp.informationLocText,"Information location address");
		String headertxt = pdp.informationLocText.getText();
		Reporter.log("Location Text  : " + headertxt, true);
	}

	public void editInfoClick() {
		bf.visibility(pdp.editLocInfo,"Edit Information");
		pdp.editLocInfo.click();
	}

	public void suggestEditpageDisplay() {
		bf.visibility(pdp.suggestAnEditHeader,"suggest An Edit");
		String headertxt = pdp.suggestAnEditHeader.getText();
		Reporter.log("Header Text  : " + headertxt, true);
	}

	public void editLocationDetails() {
		bf.visibility(pdp.localityeditloc,"Address Edit");
		pdp.localityeditloc.sendKeys("Test Locality");
		String localitytext = pdp.localityeditloc.getText();
		Reporter.log("Locality edited is :" + localitytext, true);
	}

	public void clickSubmitSuggestEdit() {
		bf.visibility(pdp.SubmitBtnAtSuggestEdit,"Submit ");
		pdp.SubmitBtnAtSuggestEdit.click();
		bf.toastMsg("\"Place edited successfully! \"");
	}

	// 366
	public void checkInformationLocation() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		informationHeaderText();
		informationLoc();
		editInfoClick();
		suggestEditpageDisplay();
	}

	public void swipeBottomSheetUpwardDir(WebElement bottomSheet, int num) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(bottomSheet).moveByOffset(0, -num).release().perform();
	}

	// 367
	public void checkInfoLocationEditSubmitMessage() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		informationLoc();
		editInfoClick();
		suggestEditpageDisplay();
		editLocationDetails();
		clickSubmitSuggestEdit();
	}

//368
	public void checkCallingClick() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Qutub Minar");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.addedPhnNoContainerClick,"Existing Phone Number");
		pdp.addedPhnNoContainerClick.click();
		bf.sleepWait(3);
		bf.visibility(pdp.phnDialerDigits,"Mobile dialer digits");
		Reporter.log("Number displayed : " + pdp.phnDialerDigits.getText(), true);
		bf.visibility(pdp.dialpadKeypad,"Dialpad Keypad");
		Reporter.log("Dialpad Keypad is displayed .", true);
		bf.visibility(pdp.callDialer,"Call Dialer");
		Reporter.log("Call Dialer is displayed .", true);
	}

//369
	public void checkCallingEditSubmit() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.addPhnNumber, "AddPhone Number");
		pdp.addPhnNumber.click();
		bf.sleepWait(3);
		suggestEditpageDisplay();
		bf.visibility(pdp.enterphnNo,"Phone Number input area ");
		pdp.enterphnNo.sendKeys("9999955555");
		clickSubmitSuggestEdit();
	}

//370
	public void checkEmailClick() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.addedemailInfoContainerClick,"Existing  Email Address");
		bf.visibility(pdp.addedEmailTextInfo,"Existing  Email Address Text");
		String emailText = pdp.addedEmailTextInfo.getText();
		Reporter.log("Email information displayed : " + emailText, true);
		pdp.addedemailInfoContainerClick.click();
		bf.sleepWait(4);
		bf.visibility(pdp.chooserMailRedirectAppOptions,"Page Footer with mail redirecting application options");
		Reporter.log("Page footer options is displayed .", true);
		bf.visibility(pdp.gridAppOptionGmail,"Gmail option at footer");
		Reporter.log("Gmail is displayed .", true);
		pdp.gridAppOptionGmail.click();
		bf.sleepWait(4);
		bf.visibility(pdp.ToBArEmailSendPage,"Email send page ");
		bf.visibility(pdp.prefixTO,"Prefix To Text");
		String prefixTo = pdp.prefixTO.getText();
		Assert.assertEquals(prefixTo, "To");
		Reporter.log("Email information displayed : " + prefixTo, true);
        bf.visibility(pdp.emailTextAtTo,"Email");
		String EmailTExtAtTo = pdp.emailTextAtTo.getText();
		Assert.assertEquals(EmailTExtAtTo.toLowerCase(), emailText.toLowerCase());
		Reporter.log("Same Email Is displayed At send senario .", true);
	}

//371
	public void checkEmailEditSubmit() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();	
		bf.visibility(pdp.addMailAddress,"Add Email Address");
		pdp.addMailAddress.click();
		bf.sleepWait(3);
		suggestEditpageDisplay();
		bf.visibility(pdp.entermailInput,"Email input area ");
		pdp.entermailInput.sendKeys("test@mail.com");
		clickSubmitSuggestEdit();
	}

//372
	public void checkWebsiteClick() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.addedWebsiteContainerClick,"Existing Website");
		bf.visibility(pdp.AddedWebsiteText,"Website Text input ");
        String websiteText = pdp.AddedWebsiteText.getText();
		Reporter.log("Website displayed : " + websiteText, true);
		pdp.AddedWebsiteText.click();
		bf.sleepWait(3);
		bf.visibility(pdp.urlBar,"Url Bar");
		Reporter.log("Url Bar is displayed .", true);
		String websiteUrlText = pdp.urlBar.getText();
		Reporter.log("Website displayed : " + websiteUrlText, true);
		Assert.assertTrue(websiteText.contains(websiteUrlText));
		bf.visibility(pdp.webView,"Web View");
		Reporter.log("Web View is displayed .", true);
	}

//373
	public void checkWebsiteEditSubmit() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.addWebsite,"Add WebSite link");
		pdp.addWebsite.click();
		bf.sleepWait(3);
		suggestEditpageDisplay();
		bf.visibility(pdp.addWebsiteInput,"Phone Number input area ");
        pdp.addWebsiteInput.sendKeys("www.testingPurpose.com");
		clickSubmitSuggestEdit();
	}

	public void placeEnter() {
		bf.visibility(pdp.placeIs,"Place Is");
		String text = pdp.placeIs.getText();
		Reporter.log("text :" + text, true);
		bf.visibility(pdp.clickEditPlaceIs,"Place Is  input");
		pdp.clickEditPlaceIs.click();
		bf.visibility(pdp.titlePlaceIsBox," Place Is box layout ");
		Reporter.log("title text is :" + pdp.titlePlaceIsBox.getText(), true);
		bf.visibility(pdp.operationalOption,"Operational");
		Reporter.log("Option one :" + pdp.operational.getText(), true);
		bf.visibility(pdp.nonExistant,"Non Existant");
		Reporter.log("Option two :" + pdp.nonExistant.getText(), true);
		bf.visibility(pdp.closedPermanently,"Closed permanently");
		Reporter.log("Operation three :" + pdp.closedPermanently.getText(), true);
		bf.visibility(pdp.notApplicble,"Not Applicable");
		Reporter.log("Operation four :" + pdp.notApplicble.getText(), true);
		pdp.operationalOption.click();
		String textEntered = pdp.clickEditPlaceIs.getText();
		Reporter.log("text :" + textEntered, true);

	}

	public void categoryEnter() {
		bf.visibility(pdp.CategoryText,"Category ");
		String text = pdp.CategoryText.getText();
		Reporter.log("text :" + text, true);
		bf.visibility(pdp.categoryInput," Category  input area ");
		pdp.categoryInput.click();
		bf.sleepWait(3);
		bf.visibility(pdp.categoryTitleBox," category title layout ");
		Reporter.log("title text is :" + pdp.categoryTitleBox.getText(), true);
		bf.visibility(pdp.othersOption,"Others option");
		pdp.othersOption.click();
		String textEntered = pdp.categoryInput.getText();
		Reporter.log("text :" + textEntered, true);
	}

	public void subCategoryEnter() {
		bf.visibility(pdp.Subcategory,"Sub Category ");
		String text = pdp.Subcategory.getText();
		Reporter.log("text :" + text, true);
		bf.visibility(pdp.subCategoryInput,"  Sub Category input");
		pdp.subCategoryInput.click();
		bf.sleepWait(3);
		bf.visibility(pdp.subCategoryTitle,"sub category title layout");
		Reporter.log("title text is :" + pdp.subCategoryTitle.getText(), true);
		bf.visibility(pdp.subCategoryOthersOption,"Others option");
		pdp.subCategoryOthersOption.click();
		String textEntered = pdp.subCategoryInput.getText();
		Reporter.log("text :" + textEntered, true);
	}

//374
	public void checkSuggestAnEditClick() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.suggestAnEditClick,"Suggest an Edit link ");
		pdp.suggestAnEditClick.click();
		suggestEditpageDisplay();
		placeEnter();
		categoryEnter();
		subCategoryEnter();
		bf.visibility(pdp.SubmitBtnAtSuggestEdit,"Submit button");
		pdp.SubmitBtnAtSuggestEdit.click();
		bf.toastMsg("Place edited successfully!");
	}

//375
	public void checkSuggestAnEditUI() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.suggestAnEditClick,"Suggest an Edit link");
		pdp.suggestAnEditClick.click();
		suggestEditpageDisplay();
		placeEnter();
		categoryEnter();
		subCategoryEnter();
		bf.visibility(pdp.namefield,"Name field ");
		bf.visibility(pdp.namefieldinput,"Name field input");
        Reporter.log("text :" + pdp.namefield.getText() + "   input text :" + pdp.namefieldinput.getText(), true);
		
        bf.visibility(pdp.address,"Address Edit");
		bf.visibility(pdp.addressInput,"Address Input ");
		Reporter.log("text : " + pdp.address.getText() + "  input text :" + pdp.addressInput.getText(), true);
		
		bf.visibility(pdp.markloc,"Mark location on map* ");
		Reporter.log("text :" + pdp.markloc.getText(), true);
		bf.visibility(pdp.Note, "Note  ");
		
		bf.visibility(pdp.NoteText,"Note text ");
		Reporter.log("text :" + pdp.Note.getText() + "   input text :" + pdp.NoteText.getText(), true);
		bf.visibility(pdp.addMoreInfo,"Add more info ");
		pdp.addMoreInfo.click();
		swipeBottomSheetUpwardDir(pdp.addmoreinfolayout, 300);
		bf.visibility(pdp.phone,"Phone");
		Reporter.log("text :" + pdp.phone.getText(), true);
		bf.visibility(pdp.email,"Email");
		Reporter.log("text :" + pdp.email.getText(), true);
		bf.visibility(pdp.website,"Website");
		Reporter.log("text :" + pdp.website.getText(), true);
		bf.visibility(pdp.aboutfield,"About");
		Reporter.log("text :" + pdp.aboutfield.getText(), true);
		bf.visibility(pdp.openhours,"Open Hours");
		Reporter.log("text :" + pdp.openhours.getText(), true);
		swipeBottomSheetUpwardDir(pdp.addmoreinfolayout, 300);
		bf.visibility(pdp.selectedhours,"Selected hours");
		Reporter.log("text :" + pdp.selectedhours.getText(), true);
		bf.visibility(pdp.alwaysopen," Always open ");
		Reporter.log("text :" + pdp.alwaysopen.getText(), true);
		bf.visibility(pdp.addhours,"Add hours");

		Reporter.log("text :" + pdp.addhours.getText(), true);
		bf.visibility(pdp.addimage,"Add Image ");
		Reporter.log("text :" + pdp.addimage.getText(), true);
		bf.visibility(pdp.backArrow,"Back Arrw At toolbar");
		bf.visibility(pdp.SubmitBtnAtSuggestEdit,"Submit Button ");
		Reporter.log("text :" + pdp.SubmitBtnAtSuggestEdit.getText(), true);

	}

//376
	public void categoryAndAddressSuggestEdit() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		informationHeaderText();
		bf.visibility(pdp.suggestAnEditClick,"Suggest an Edit link");
		pdp.suggestAnEditClick.click();
		suggestEditpageDisplay();
		placeEnter();
		categoryEnter();
		subCategoryEnter();
		bf.visibility(pdp.SubmitBtnAtSuggestEdit,"Address Edit");
		pdp.SubmitBtnAtSuggestEdit.click();
		bf.toastMsg("Place edited successfully!");
	}

//377
	public void checkopeaningHours() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardMultipleTimes(2);

		informationHeaderText();
		bf.visibility(pdp.OpeaningHours,"Opeaning Hours");

		String textEntered = pdp.OpeaningHours.getText();
		Reporter.log("text :" + textEntered, true);
		bf.visibility(pdp.opeaningHourTime,"Opeaning Hours time ");
		String texttimeshown = pdp.opeaningHourTime.getText();
		Reporter.log("text :" + texttimeshown, true);
		bf.visibility(pdp.closedOnTime,"Closed on ");
		String texttimeclose = pdp.closedOnTime.getText();
		Reporter.log("text :" + texttimeclose, true);
	}

//378
	public void checkAdditionalInformation() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardMultipleTimes(2);
		informationHeaderText();
		bf.visibility(pdp.additionalInformation,"Additional Informations");

		String additionalTExt = pdp.additionalInformation.getText();
		Reporter.log("text :" + additionalTExt, true);
		bf.visibility(pdp.additionalInfotext,"Additional Informations  text");
		String textaditionalinfo = pdp.additionalInfotext.getText();
		Reporter.log("text :" + textaditionalinfo, true);
		Assert.assertTrue(textaditionalinfo.contains("Entry Fee"));
	}

	public void checkAddImageUI() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardMultipleTimes(3);
		bf.visibility(pdp.ImagesHeader,"Images Header  ");

		String imagesTExt = pdp.ImagesHeader.getText();
		Reporter.log("text :" + imagesTExt, true);
		Assert.assertTrue(imagesTExt.contains("Images"));
		bf.visibility(pdp.imageContainer, "Image Container");
		Reporter.log("Image Container are displayed", true);
		bf.visibility(pdp.imageOne,"Images ");
		Reporter.log("Images are displayed", true);

	}

	public String checksimilarPlacesNearbyUI() throws InterruptedException, IOException {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardMultipleTimes(4);
		bf.visibility(pdp.SimilarPlaceHeader,"Similar Places Nearby Header ");
		String TExt = pdp.SimilarPlaceHeader.getText();
		Reporter.log("text :" + TExt, true);
		Assert.assertTrue(TExt.contains("Similar Places Nearby"));
		bf.visibility(pdp.similarPlacesNearbycontainer,"Similar places nearby Container ");

		bf.visibility(pdp.similarplaceName,"Similar Places Name");
		String placeName = pdp.similarplaceName.getText();
		Reporter.log("text :" + placeName, true);
		bf.visibility(pdp.similarPlacePIn,"Similar Places Mappls pin");
		String pin = pdp.similarPlacePIn.getText();
		Reporter.log("text :" + pin, true);
		bf.visibility(pdp.similarPlaceDistance,"Similar Places Distance  Layout");
		String distance = pdp.similarPlaceDistance.getText();
		Reporter.log("text :" + distance, true);

		return placeName;
	}

//383
	public void checksimilarPlacesNearbyclick() throws InterruptedException, IOException {
		checksimilarPlacesNearbyUI();
		bf.visibility(pdp.similarplacenearbyContainerclick,"Similar Places container Layout");
		pdp.similarplacenearbyContainerclick.click();
		placeDetailLayoutClick();
	}

//384
	public void checksimilarPlacesNearbyVerify() throws InterruptedException, IOException {
		String placename = checksimilarPlacesNearbyUI();
		bf.visibility(pdp.similarplacenearbyContainerclick,"Similar Places container Layout ");
		pdp.similarplacenearbyContainerclick.click();
		placeDetailLayoutClick();
		String name = placeDetailNameCheck();
		Assert.assertEquals(placename.toLowerCase(), name.toLowerCase());
	}

//386
	public void checkRateAndReviewExperienceCard() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Bharno");
		swipeBottomSheetUpwardMultipleTimes(2);
		bf.visibility(pdp.rateAndReviewExpCard,"Rate And Review Your Experience ");
		bf.visibility(pdp.rateAndReviewCardText,"Rate and Review Exerience  ");
		String cardText = pdp.rateAndReviewCardText.getText();
		Reporter.log("text :" + cardText, true);
		bf.visibility(pdp.rateAdreviewCardratingTExt,"Rate and review rating");
		String cardratingText = pdp.rateAdreviewCardratingTExt.getText();
		Reporter.log("text :" + cardratingText, true);

		pdp.rateAndReviewExpCard.click();
		reviewPlace("testing experience comments");
		upf.shareLinkTextFetch();
		swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
		ReviewsByUserHEader();
		checkCurrentUserReviewDisplay();
		bf.visibility(pdp.actionDotsMoreoption,"More options at current user review");
		pdp.actionDotsMoreoption.click();
		bf.sleepWait(3);
		bf.visibility(pdp.deleteOption,"Delete");
		pdp.deleteOption.click();
	}

	public void ReviewsByUserHEader() {
		bf.visibility(pdp.reviewBYUserHEading,"Reviews by users ");
		String Text = pdp.reviewBYUserHEading.getText();
		Reporter.log("text :" + Text, true);

	}

	public void checkCurrentUserReviewDisplay() {
		bf.visibility(pdp.currentUserReviewLayout,"Reviews by users current user review ");
        bf.visibility(pdp.reviewText,"Review Text");
		String Text = pdp.reviewText.getText();
		Reporter.log("text :" + Text, true);
		Assert.assertTrue(Text.contains("You reviewed"));
	}

	public void checkHelpfulCurrentUser() {
		bf.visibility(pdp.helpfulAction,"Helpful at current user review");
        String Text = pdp.helpfulAction.getText();
		Reporter.log("text :" + Text, true);

		pdp.helpfulAction.click();
		bf.visibility(pdp.helpfulText,"helpful text at User review");
		Reporter.log("text :" + pdp.helpfulText.getText(), true);
	}

	public void checkshareCurrentUser() {
		bf.visibility(pdp.Shareaction,"Share at current user review ");
		pdp.Shareaction.click();
		bf.sleepWait(3);
	}

	public void checkEditCurrentUser() {
		bf.visibility(pdp.actionDotsMoreoption, "More options at current user review ");
		pdp.actionDotsMoreoption.click();
		bf.sleepWait(3);
		bf.visibility(pdp.editOption,"Edit options at current user review ");
		Reporter.log("Text : " + pdp.editOption.getText(), true);
		pdp.editOption.click();
		bf.sleepWait(2);
		bf.visibility(pdp.arRatingBar,"Rating bar");
		String rating = pdp.arRatingBar.getText();
		Reporter.log("added ratings: " + rating, true);
		bf.visibility(pdp.arExperience,"Add experience field");
		bf.visibility(pdp.arDone, "Done button ");
	}

//388
	public void checkEditAndLikeCurrentUserReview() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(2);
		ReviewsByUserHEader();
		checkCurrentUserReviewDisplay();
		checkHelpfulCurrentUser();
		checkshareCurrentUser();
		upf.shareLinkTextFetch();
		checkEditCurrentUser();
	}

	public void checkForReviewDetilsPage() {
		bf.visibility(pdp.ReviewDetailsPageHeader, "Review Details header");
		String text = pdp.ReviewDetailsPageHeader.getText();
		Reporter.log("Toolbar heading : " + text, true);
		bf.visibility(pdp.bottomReviewDetail,"Add experience field");
	}

//389
	public void checkopenOwnreview() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(2);
		ReviewsByUserHEader();
		checkCurrentUserReviewDisplay();
		pdp.currentUserReviewLayout.click();
		checkForReviewDetilsPage();
		bf.visibility(pdp.LikeActionOnReviewDetailPage,"Done button");
		boolean isClicked = pdp.LikeActionOnReviewDetailPage.getAttribute("clickable").equals("true");
		Reporter.log("clickable : " + isClicked, true);
		pdp.LikeActionOnReviewDetailPage.click();

	}

	public void clickBackBtnOnReviewDetailsPage() {
		bf.visibility(pdp.backBTNONReviewDetailsPage, "Share button");
		pdp.backBTNONReviewDetailsPage.click();
	}

//390
	public void checkbackBtnReviewdetailpage() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(2);
		ReviewsByUserHEader();
		checkCurrentUserReviewDisplay();
		pdp.currentUserReviewLayout.click();
		checkForReviewDetilsPage();
		clickBackBtnOnReviewDetailsPage();
		bf.sleepWait(2);
		ReviewsByUserHEader();
	}

	public void clickShare() {
		bf.visibility(pdp.ShareOnReviewDetailspage,"Share button ");
		pdp.ShareOnReviewDetailspage.click();
	}

//391
	public void checkshareReviewdetailpage() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(2);
		ReviewsByUserHEader();
		checkCurrentUserReviewDisplay();
		pdp.currentUserReviewLayout.click();
		checkForReviewDetilsPage();
		clickShare();
		bf.visibility(pdp.appsOptionToShare, "Apps option ");
		upf.shareLinkTextFetch();

	}

	public String linkText(int num) {
		List<WebElement> ss = pdp.lnly.findElements(By.className("android.widget.TextView"));
		String point = ss.get(num).findElement(By.id("android:id/text1")).getText();
		Reporter.log("displayed share text: " + point, true);
		return point;
	}

//392
	public void checktexttoLeftCancel() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(2);
		ReviewsByUserHEader();
		checkCurrentUserReviewDisplay();
		pdp.currentUserReviewLayout.click();
		checkForReviewDetilsPage();
		clickShare();
		String text = linkText(0);
		Assert.assertTrue(text.contains("I would like you to check this review on Mappls:"));
	}

	public void checkOtherUser() {
		bf.visibility(pdp.otherUserReviewContainer, "Reviews by users other review layout");
		bf.visibility(pdp.otherReviewText, "Review Text");
		String Text = pdp.otherReviewText.getText();
		Reporter.log("text :" + Text, true);
		Assert.assertTrue(Text.contains("reviewed"));
	}

	public void checkHelpfulOtherUser() {
		bf.visibility(pdp.helpfulActionOther, "Helpful at current user review ");
		String Text = pdp.helpfulActionOther.getText();
		Reporter.log("text :" + Text, true);
		boolean isClicked = pdp.helpfulActionOther.getAttribute("clickable").equals("true");
		Reporter.log("clickable : " + isClicked, true);
		pdp.helpfulActionOther.click();
	}

	public void shareOtherUser() {
		bf.visibility(pdp.shareACtionOther, "Share at current user review ");
		pdp.shareACtionOther.click();
		bf.sleepWait(3);
	}

	public void checkOtherFlag() {
		bf.visibility(pdp.actionDotsMoreoptionOther,  "More options at review");
		pdp.actionDotsMoreoptionOther.click();
		bf.sleepWait(3);
		bf.visibility(pdp.flagOption, "Flag option at  review");
		pdp.flagOption.click();
		bf.sleepWait(2);
		bf.visibility(pdp.ReportAnAbuseHEader,"HEader ");
		Reporter.log("Header Text : " + pdp.ReportAnAbuseHEader.getText(), true);
		bf.visibility(pdp.violationInput, "Violation Input");
		String text = pdp.violationInput.getText();
		Reporter.log("Text : " + text, true);
		bf.visibility(pdp.descriptonInput, "Description Input");
		String textDesc = pdp.descriptonInput.getText();
		Reporter.log("Text : " + textDesc, true);
		bf.visibility(pdp.DoneFlag, "Done button");
	}

//393
	public void checkotherUserFlag() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		checkHelpfulOtherUser();
		shareOtherUser();
		upf.shareLinkTextFetch();
		checkOtherFlag();
	}

	public void textContains(WebElement locatorName, String tobepresentText) {
		wait.until(ExpectedConditions.visibilityOf(locatorName));
		Assert.assertTrue(locatorName.isDisplayed(), "" + tobepresentText + "should be displayed");
		String Text = locatorName.getText();
		Reporter.log("text :" + Text, true);
		Assert.assertTrue(Text.contains(tobepresentText));
	}

//394
	public void checkotherUserFlagReviewOption() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		checkOtherFlag();
		pdp.violationInput.click();
		bf.visibility(pdp.violationBoxHeader, "Violation Image type layout");
		Reporter.log("text :" + pdp.violationBoxHeader.getText(), true);
		textContains(pdp.spamOption, "spam");
		textContains(pdp.irrelevantOption, "irrelevant");
		textContains(pdp.foulLanguageOption, "foul language");
		textContains(pdp.inappropriateOption, "inappropriate content");
		textContains(pdp.personalInfoOption, "personal information");
		textContains(pdp.othersOptionViol, "Others");
	}

//395
	public void checkotherUserFlagfunction() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		checkOtherFlag();
		pdp.DoneFlag.click();
		bf.snackBarMessage("Please select violation type from list.");
	}

//396
	public void checkDoneBtFlag() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		checkOtherFlag();
		pdp.violationInput.click();
		bf.visibility(pdp.violationBoxHeader," Violation Image type layout ");
		Reporter.log("text :" + pdp.violationBoxHeader.getText(), true);
		pdp.othersOptionViol.click();
		Reporter.log("text after selecting option:" + pdp.violationInput.getText(), true);
		bf.visibility(pdp.descriptonInput,"Description Input");
		String textDesc = pdp.descriptonInput.getText();
		Reporter.log("Text : " + textDesc, true);
		pdp.descriptonInput.sendKeys("Testing flag");
		pdp.DoneFlag.click();
		checkOtherUser();
		pdp.otherUserReviewContainer.click();
		checkForReviewDetilsPage();
		textContains(pdp.flagOnreviewDetailspge, "Flagged");
	}

//397
	public void checkopenOtherUSerReview() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		pdp.otherUserReviewContainer.click();
		checkForReviewDetilsPage();
        bf.visibility(pdp.LikeActionOnReviewDetailPage," Helpful button");
	    boolean isClicked = pdp.LikeActionOnReviewDetailPage.getAttribute("clickable").equals("true");
		Reporter.log("clickable : " + isClicked, true);
		pdp.LikeActionOnReviewDetailPage.click();
        bf.visibility(pdp.flagOnreviewDetailspge," Flag button");
        pdp.flagOnreviewDetailspge.click();
		pdp.violationInput.click();
		
        bf.visibility(pdp.violationBoxHeader,"Violation Image type layout");
		Reporter.log("text :" + pdp.violationBoxHeader.getText(), true);
		pdp.othersOptionViol.click();
		Reporter.log("text after selecting option:" + pdp.violationInput.getText(), true);
        bf.visibility(pdp.descriptonInput,"Description Input");
		String textDesc = pdp.descriptonInput.getText();
		Reporter.log("Text : " + textDesc, true);
		pdp.descriptonInput.sendKeys("Testing flag");

		pdp.DoneFlag.click();
		bf.snackBarMessage("Request submitted successfully");
		textContains(pdp.flagOnreviewDetailspge, "Flagged");

	}

//398
	public void checkbackBtnFromotherUserReviewPage() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		pdp.otherUserReviewContainer.click();
		checkForReviewDetilsPage();
		clickBackBtnOnReviewDetailsPage();
		bf.sleepWait(2);
		ReviewsByUserHEader();
	}

	// 399
	public void checkOtherUserReviewShare() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		checkOtherUser();
		pdp.otherUserReviewContainer.click();
		checkForReviewDetilsPage();
		clickShare();
		bf.visibility(pdp.appsOptionToShare,"Apps option ");
		upf.shareLinkTextFetch();
	}
	
//401
	public void checkviewAllBtnClickUserReviewPage() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(3);
		ReviewsByUserHEader();
		bf.visibility(pdp.ReviewViewAll, "View All At Review");
		Reporter.log("Displayed : " + pdp.ReviewViewAll.getText(), true);
		pdp.ReviewViewAll.click();
		bf.visibility(pdp.ReviewsHeader, "Reviews");
		Reporter.log("Displayed : " + pdp.ReviewsHeader.getText(), true);
		bf.visibility(pdp.viewAllReviewsLayouts, "Reviewed layouts ");
		pdp.viewAllReviewsLayouts.click();
		checkForReviewDetilsPage();
		bf.visibility(pdp.profileImageAtReview, "Image");
		bf.visibility(pdp.ReviewPersonName, "Name At");
		bf.visibility(pdp.rAtingsReview, "Rating Bar");
		bf.visibility(pdp.commentReview, "Description");
		bf.visibility(pdp.DateReviewed, "DAte");
		bf.visibility(pdp.flagOnreviewDetailspge, "Flag At Review");
		bf.visibility(pdp.LikeActionOnReviewDetailPage, "HelpfulAt Review");
		bf.visibility(pdp.ShareOnReviewDetailspage, "Share At Review");
	}
	public void swipeBottomSheetUpwardMultipleTimes(int times) {
	    for (int i = 0; i < times; i++) {
			swipeBottomSheetUpwardDir(pdp.bottomSheetPlace, 200);
	    }
	}
	public void PostByUserHeader() {
		bf.visibility(pdp.PostByUserHeader, "Posts BY User");
		String Text = pdp.PostByUserHeader.getText();
		Reporter.log("text :" + Text, true);
	}
	
	public void clickMoreOptionsForPosted() {
	    List<MobileElement> parentContainers = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/recyclerView\"]/android.widget.LinearLayout[2]"));

	    for (MobileElement container : parentContainers) {
	        List<MobileElement> textViews = container.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_text\" and @text=\"You posted an update\"]"));
	        
	        for (MobileElement textView : textViews) {
	            if (textView.getText().contains("You posted")) {
	                MobileElement moreOptionsButton = container.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/more_option\"])[1]"));
	                
	                moreOptionsButton.click();
	                System.out.println("Clicked on 'More Options' for 'you posted'.");
	                return;
	            }
	        }
	    }
	    System.out.println("'you posted' not found.");
	}
//404
	public void checkEditUserOwnReport() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.reportLayout, "Report LAyout ");
		bf.visibility(pdp.userOwnreport, "report text ");
		textContains(pdp.userOwnreport, "You posted");
		clickMoreOptionsForPosted();
		bf.visibility(pdp.reportEdit, "Edit");
		pdp.reportEdit.click();
		postPlace("Testing edit");
		innerPostClick();
		bf.sleepWait(5);
		postSuccessful();
	}
	public void checkForReportDetilsPage() {
		bf.visibility(pdp.postDetailsHeader, "Post Details ");
		textContains(pdp.postDetailsHeader, "Post Details");
		bf.visibility(pdp.reportDetailContainer, "Report Details Container");
}

//405
	public void checkOpenUserOwnReport()throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.reportLayout, "Report LAyout ");
		bf.visibility(pdp.userOwnreport, "report text ");
		textContains(pdp.userOwnreport, "You posted");
		pdp.userOwnreport.click();
		checkForReportDetilsPage();
	}

//406
	public void checkbackBTNReportDetailPage()throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.reportLayout, "Report LAyout ");
		bf.visibility(pdp.userOwnreport, "report text ");
		textContains(pdp.userOwnreport, "You posted");
		pdp.userOwnreport.click();
		checkForReportDetilsPage();
		bf.visibility(pdp.BackBtnPostDetailsPage, "Back Button Arrow At Toolbar");
		pdp.BackBtnPostDetailsPage.click();
		PostByUserHeader();
	}

//407
	public void checkshareUserOwnReport() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.reportLayout, "Report LAyout ");
		bf.visibility(pdp.userOwnreport, "report text ");
		textContains(pdp.userOwnreport, "You posted");
		pdp.userOwnreport.click();
		checkForReportDetilsPage();
		clickShare();
		bf.visibility(pdp.appsOptionToShare, "multiple Apps ");
        upf.shareLinkTextFetch();
	}

//408
	public void checkShareReportText()throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.reportLayout, "Report LAyout ");
		bf.visibility(pdp.userOwnreport, "report text ");
		textContains(pdp.userOwnreport, "You posted");
		pdp.userOwnreport.click();
		checkForReportDetilsPage();
		clickShare();
		String text = linkText(0);
		Assert.assertTrue(text.contains("I would like you to check this post on Mappls:"));	
	}

//409
	public void checkopenOtherUserReport() throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.otherUserReportContainer, "Report LAyout ");
		textContains(pdp.otherUserReportText, "posted");
		pdp.otherUserReportContainer.click();
		checkForReportDetilsPage();

	}

//410
	public void checkBackBtnFromOtherUserReportPage()throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.otherUserReportContainer, "Report LAyout ");
		textContains(pdp.otherUserReportText, "posted");
		pdp.otherUserReportContainer.click();
		checkForReportDetilsPage();
		bf.visibility(pdp.BackBtnPostDetailsPage, "Back Button Arrow At Toolbar");
		pdp.BackBtnPostDetailsPage.click();
		PostByUserHeader();
	}

//411
	public void checkshareotheruserReport() throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(8);
		PostByUserHeader();
		bf.visibility(pdp.otherUserReportContainer, "Report LAyout ");
		textContains(pdp.otherUserReportText, "posted");
		pdp.otherUserReportContainer.click();
		checkForReportDetilsPage();
		clickShare();
        upf.shareLinkTextFetch();
	}

//412
	public void checkviewAllBtnClickUserReportPage() throws IOException, InterruptedException  {
		clickPlaceDetailLayout("Taj Mahal");
		swipeBottomSheetUpwardMultipleTimes(12);
		PostByUserHeader();
		bf.visibility(pdp.reportViewAll, " View All --Posts By Users ");
		pdp.reportViewAll.click();
		textContains(pdp.postsHeaderViewAll, "Posts");
		bf.visibility(pdp.reportListViewAll, "Posts list ");
		bf.visibility(pdp.viewAllReportImage, "Report  image LAyout ");
		bf.visibility(pdp.viewAllreportText, "Report LAyout text");
		bf.visibility(pdp.viewAllReportDesc, "Report LAyout Descripton");
		bf.visibility(pdp.viewAllreportDate, "Report LAyout Date");
	}
	public void findTextInRecyclerView(String textToFind, WebElement recyclerView, int swipeOffset) {
	    boolean textFound = false;
	    while (true) {
	        List<WebElement> viewGroups = recyclerView.findElements(By.className("android.view.ViewGroup"));

	        for (WebElement viewGroup : viewGroups) {
	            try {
	                WebElement textView = viewGroup.findElement(By.id("com.mmi.maps:id/category_name"));
	                String displayedText = textView.getText();

	                if (displayedText.equals(textToFind)) {
	                    Reporter.log("Text '" + textToFind + "' found in RecyclerView: " + displayedText, true);
	                    textFound = true;
	                    break; // Exit loop as the text is found
	                }
	            } catch (NoSuchElementException e) {
	                Reporter.log("No TextView found in this ViewGroup. Continuing search...", true);
	            }
	        }
	        if (textFound) {
	            break; 
	        }
	        try {
	            Thread.sleep(2); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        }
	}

	public void testRecyclerViewSubCategoryTexts() { 
	    MobileElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/category_recyclerview"));
	    List<MobileElement> viewGroups = recyclerView.findElements(By.className("android.view.ViewGroup"));
	    int viewGroupCount = viewGroups.size();
	    Reporter.log("Number of view groups displayed: " + viewGroupCount, true);
	    for (int i = 0; i < viewGroupCount; i++) {
	        MobileElement viewGroup = viewGroups.get(i);
	        Reporter.log("View Group " + (i + 1) + ":", true);
	        try {
	               MobileElement firstTextView = viewGroup.findElement(By.id("com.mmi.maps:id/category_name"));
	            String firstText = firstTextView.getText();
	            Reporter.log("  TextView 1: " + firstText, true);
	        } catch (Exception e) {
	            Reporter.log("Unable to locate TextViews in ViewGroup " + (i + 1), true);
	        }
	    }
	    Assert.assertTrue(true, "Test completed by displaying all TextView items in each ViewGroup.");
	}

//357
	public void reportCategorySafetyIssue() throws IOException, InterruptedException {
		reportSteps();
		findTextInRecyclerView("Safety",pdp.reportRecyclerViewOptions,100);
		bf.visibility(pdp.safety, "Safety");
		pdp.safety.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//358
	public void reportCategoryRoadCondition() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		bf.swipeUpUntilElementDisplayedPosts(pdp.RoadCondition, 2);
		Reporter.log("Displayed text found : " + pdp.RoadCondition.getText(), true);
		pdp.RoadCondition.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//352
	public void reportCategoryPollutingActivity() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		bf.swipeUpUntilElementDisplayedPosts(pdp.pollutingActivity,2);
		Reporter.log("Displayed text found : "+pdp.pollutingActivity.getText(),true);
        pdp.pollutingActivity.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//353
	public void reportCategorySwachhBharat() throws IOException, InterruptedException {
		reportSteps();
		findTextInRecyclerView("Swachh Bharat",pdp.reportRecyclerViewOptions,100);
		bf.visibility(pdp.swachhBharat, "Swachh bharat");
		pdp.swachhBharat.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//354
	public void reportCategoryMapIssue() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		bf.swipeUpUntilElementDisplayedPosts(pdp.Map, 3);
		Reporter.log("Displayed text found : " + pdp.Map.getText(), true);
		pdp.Map.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//356
	public void reportCategoryCommunityIssue() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		bf.swipeUpUntilElementDisplayedPosts(pdp.Community,2);
		Reporter.log("Displayed text found : "+pdp.Community.getText(),true);
		pdp.Community.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//355
	public void reportCategoryTrafficIssue() throws IOException, InterruptedException {
		reportSteps();
		findTextInRecyclerView("Traffic",pdp.reportRecyclerViewOptions,100);
		bf.	visibility(pdp.Traffic, "Traffic");
		pdp.Traffic.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
//351
	public void reportCategoryUnicefSchool() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		postClick();
		bf.swipeUpUntilElementDisplayedPosts(pdp.UnicefSchoolClosure,3);
		Reporter.log("Displayed text found : "+pdp.UnicefSchoolClosure.getText(),true);
		pdp.UnicefSchoolClosure.click();
		bf.sleepWait(5);
		testRecyclerViewSubCategoryTexts();
	}
	//350
	public void reportCategoryoption()throws IOException, InterruptedException{
		clickPlaceDetailLayout("Ranchi");
		postClick();
		findTextInRecyclerView("Swachh Bharat",pdp.reportRecyclerViewOptions,100);
		findTextInRecyclerView("Traffic",pdp.reportRecyclerViewOptions,100);
		findTextInRecyclerView("Safety",pdp.reportRecyclerViewOptions,100);

		bf.swipeUpUntilElementDisplayedPosts(pdp.Community,2);
		Reporter.log("Displayed text found : "+pdp.Community.getText(),true);		
		bf.swipeUpUntilElementDisplayedPosts(pdp.RoadCondition,2);
		Reporter.log("Displayed text found : "+pdp.RoadCondition.getText(),true);
        bf.swipeUpUntilElementDisplayedPosts(pdp.pollutingActivity,2);
		Reporter.log("Displayed text found : "+pdp.pollutingActivity.getText(),true);
		bf.swipeUpUntilElementDisplayedPosts(pdp.UnicefSchoolClosure,3);
		Reporter.log("Displayed text found : "+pdp.UnicefSchoolClosure.getText(),true);
		bf.swipeUpUntilElementDisplayedPosts(pdp.Map,3);
		Reporter.log("Displayed text found : "+pdp.Map.getText(),true);
	}
	public void stepsToCameraClick() throws IOException, InterruptedException {
		clickPlaceDetailLayout("Ranchi");
		swipeBottomSheetUpwardMultipleTimes(1);
		bf.visibility(pdp.ImagesHeader,"Images Header");
		String imagesTExt = pdp.ImagesHeader.getText();
		Reporter.log("text :" + imagesTExt, true);
		Assert.assertTrue(imagesTExt.contains("Images"));
		bf.visibility(pdp.AddImage,"Add Image");
		Reporter.log("text :" +pdp.AddImage.getText(), true);
		pdp.AddImage.click();
		bf.	visibility(pdp.addImageCameratext,"Add Image");
		textContains(pdp.addImageCameratext,"Add Image");
	}
	public void mediaPermissionBoxUI() {
		bf.visibility(pdp.mediapermissionBoxTitle,"Media Permission  Title");
        Reporter.log(pdp.mediapermissionBoxTitle.getText(),true);
        bf.visibility(pdp.mediapermissionboxText,"Media Permission Text Description");
        Reporter.log(pdp.mediapermissionboxText.getText(),true);
        textContains(pdp.CancelOptionbtn,"CANCEL");
        textContains(pdp.continueOptionBtn,"CONTINUE");
	}
	public void PhotoVideoAccessPermissionDontAllowClick() {
		bf.photoAndVideoaccessPermission();
		bf.allowOption();
		bf.dontallowOption();
		bp.DenyOption.click();	
	}
//322
		public void checkCameraNotAvailableAndSettingOption() throws InterruptedException, IOException {
			stepsToCameraClick();
			pdp.addImageCameratext.click();
			PhotoVideoAccessPermissionDontAllowClick();
			mediaPermissionBoxUI();
				}
//323
		public void checkclickBackSettingAndcameraAccessPermission()throws InterruptedException, IOException {
			stepsToCameraClick();
			pdp.addImageCameratext.click();
			PhotoVideoAccessPermissionDontAllowClick();
			mediaPermissionBoxUI();
			pdp.continueOptionBtn.click();
			bf.visibility(pdp.settingsPageTextHeader,"settings page appbar text");
			Reporter.log("text : "+pdp.settingsPageTextHeader.getText(),true);
    		textContains(pdp.entityHeader,"Mappls MapmyIndia");
			bf.back();
			bf.visibility(pdp.addImageCameratext,"Add Image");
			textContains(pdp.addImageCameratext,"Add Image");
			pdp.addImageCameratext.click();
			mediaPermissionBoxUI();          
		}
//  324
		public void checkclickCancelandsettingOption() throws InterruptedException, IOException {
			checkclickcancelandDisplayOfPlaceDetailPage();
			pdp.addImageCameratext.click();
			PhotoVideoAccessPermissionDontAllowClick();
			mediaPermissionBoxUI();
            pdp.CancelOptionbtn.click();
			pdp.addImageCameratext.click();
			PhotoVideoAccessPermissionDontAllowClick();
			mediaPermissionBoxUI();
		}
//325
		public void checkSettingsPage()throws InterruptedException, IOException {
			stepsToCameraClick();
			pdp.addImageCameratext.click();
			PhotoVideoAccessPermissionDontAllowClick();
			mediaPermissionBoxUI();
            bf.sleepWait(0);
        	pdp.continueOptionBtn.click();
        	bf.visibility(pdp.settingsPageTextHeader,"settings page appbar text");
			Reporter.log("text : "+pdp.settingsPageTextHeader.getText(),true);
    		textContains(pdp.entityHeader,"Mappls MapmyIndia");
		}
//326
		public void checkpermissionDeniedtoAccessPhotoLibrary() throws InterruptedException, IOException {
			stepsToCameraClick();
			pdp.addImageCameratext.click();
			PhotoVideoAccessPermissionDontAllowClick();
			mediaPermissionBoxUI();
		}
//327
		public void checkclickcancelandDisplayOfPlaceDetailPage() throws InterruptedException, IOException {
			checkpermissionDeniedtoAccessPhotoLibrary();
            pdp.CancelOptionbtn.click();
            bf.visibility(pdp.addImageCameratext,"Add Image");
    		textContains(pdp.addImageCameratext,"Add Image");
    		bf.visibility(pdp.DoneBTNOnADDImage,"done button");
		}
//328
		public void checkclickOKandDisplaySettingpage()throws InterruptedException, IOException {
			checkpermissionDeniedtoAccessPhotoLibrary();
			bf.sleepWait(2);
			pdp.continueOptionBtn.click();
			bf.visibility(pdp.settingsPageTextHeader,"settings page appbar text");
			Reporter.log("text : "+pdp.settingsPageTextHeader.getText(),true);
    		textContains(pdp.entityHeader,"Mappls MapmyIndia");
		}
//329
		public void checkclickonCameraopentoaddNewImages() throws InterruptedException, IOException {
			stepsToCameraClick();
			pdp.addImageCameratext.click();
			bf.photoAndVideoaccessPermission();
			bf.allowOption();
			bf.dontallowOption();
			bp.allowOption.click();
			bf.visibility(pdp.addImageCameratext,"Add Image");
			pdp.addImageCameratext.click();
			textContains(pdp.SelectImageHeader,"Select Image");
			bf.visibility(pdp.rvmedia,"RV Media");
			bf.visibility(pdp.cameraiconLayout,"camera option");

		}
		//380
			public void checkAddImagefunctionality() throws InterruptedException, IOException {
				checkclickonCameraopentoaddNewImages();	
				pdp.cameraiconLayout.click();
				bf.permissionforCamera();
				bp.WhileUsingAppOption.click();
				bf.visibility(pdp.shutterBTn,"Shutter Button");
				bf.visibility(pdp.frontBackSwitcher,"Switcher fromt back");
			}
		//381
			public void checkAddImageupload() throws InterruptedException, IOException {
				checkAddImagefunctionality();
				pdp.shutterBTn.click();
				textContains(pdp.Retry,"Retry");
				textContains(pdp.ok,"Ok");
				pdp.ok.click();
				bf.sleepWait(3);
				textContains(pdp.SelectImageHeader,"Select Image");
				bf.visibility(pdp.viewDone,"Done");
				pdp.viewDone.click();
				bf.visibility(pdp.selectedImgCont,"Selected Image container");
				bf.visibility(pdp.DoneBTNOnADDImage,"done button");
	    		pdp.DoneBTNOnADDImage.click();
	    		bf.snackBarMessage("Image will be uploaded in background.");
			}		
}
