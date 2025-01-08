package com.mappls.map.features;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__007_MyWorldViewPage;
import com.mappls.map.pages.TC__015_SearchPage;
import com.mappls.map.pages.TC__016_PlaceDetailPage;
import com.mappls.map.pages.TC__017_NavigationPage;
import com.mappls.map.pages.TC__019_UserProfilePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__017_NavigationFeature {

	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;
	TC__017_NavigationPage dr;
	Actions act;
	BaseFeatures bf;
	BasePage bp;
	TC__015_SearchFeature spf;
	TC__015_SearchPage sp;
	TC__016_PlaceDetailFeature pdf;
	TC__016_PlaceDetailPage pdp;
	TC__019_UserProfileFeature upf;
	TC__019_UserProfilePage uf;
	TC__007_MyWorldViewPage mww;
	TC__020_MapLayerFeature ml;

	public TC__017_NavigationFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		dr = new TC__017_NavigationPage(driver);
		bf = new BaseFeatures(driver);
		spf = new TC__015_SearchFeature(driver);
		sp = new TC__015_SearchPage(driver);
		pdf = new TC__016_PlaceDetailFeature(driver);
		pdp = new TC__016_PlaceDetailPage(driver);
		upf = new TC__019_UserProfileFeature(driver);
		uf = new TC__019_UserProfilePage(driver);
		mww = new TC__007_MyWorldViewPage(driver);
		bp = new BasePage(driver);
		ml = new TC__020_MapLayerFeature(driver);
	}

//================================================================
	public void homeDirection() {
		Assert.assertNotNull(dr.homeDirection, "Home direction element is null.");
		Assert.assertTrue(dr.homeDirection.isDisplayed(), "Home direction element is not displayed.");

		dr.homeDirection.click();
		Reporter.log("Direction Button on HomePage is clicked", true);
        bf.visibility(dr.ln,"Direction layout");
		Reporter.log("Direction layout is visible", true);
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
		List<WebElement> ss = dr.ln.findElements(By.className("android.view.ViewGroup"));
		ss.get(num).findElement(By.className("android.widget.TextView")).click();
	}

	public String finalText(int num) {
		List<WebElement> ss = dr.ln.findElements(By.className("android.view.ViewGroup"));
		String point = ss.get(num).findElement(By.className("android.widget.TextView")).getText();
		Reporter.log("entered  final location : " + point, true);
		return point;
	}

	public String startText(int num) {
		List<WebElement> ss = dr.ln.findElements(By.className("android.view.ViewGroup"));
		String point = ss.get(num).findElement(By.className("android.widget.TextView")).getText();
		Reporter.log("entered  start location : " + point, true);
		return point;
	}

	public void chooseYourCurLoc() {
		Assert.assertNotNull(dr.yrcurLoc, "Choose on map element is null.");
		wait.until(ExpectedConditions.visibilityOf(dr.yrcurLoc));
		Assert.assertTrue(dr.yrcurLoc.isDisplayed(), "Choose on map element is not displayed.");
		dr.yrcurLoc.click();
		Reporter.log("Clicked Your current location ", true);
		bf.sleepWait(2);
	}

	public void chooseLocOnMap() {
		Assert.assertNotNull(dr.chooseOnMap, "Choose on map element is null.");
		wait.until(ExpectedConditions.visibilityOf(dr.chooseOnMap));
		Assert.assertTrue(dr.chooseOnMap.isDisplayed(), "Choose on map element is not displayed.");
		dr.chooseOnMap.click();
		Reporter.log("clicked choose on map ", true);
		bf.sleepWait(2);
		wait.until(ExpectedConditions.visibilityOf(dr.bottomView));
		Assert.assertNotNull(dr.bottomView, "Choose on map bottomsheet is null.");
		Assert.assertTrue(dr.bottomView.isDisplayed(), "Choose on map bottomsheet is not displayed.");
		Reporter.log("point on map :" + dr.addChosenOnMap.getText(), true);
		Assert.assertNotNull(dr.doneBtn, "Done button should be displayed.");
		Assert.assertTrue(dr.doneBtn.isDisplayed(), "Done button is not displayed.");
		dr.doneBtn.click();
		Reporter.log("clicked done location  ", true);
	}

	public void reverse() {
		wait.until(ExpectedConditions.visibilityOf(dr.reverseLocation));
		Assert.assertNotNull(dr.reverseLocation, "Reverse location element is null.");
		Assert.assertTrue(dr.reverseLocation.isDisplayed(), "Reverse location element is not displayed.");
		dr.reverseLocation.click();
		Reporter.log("interchange clicked", true);
	}

	public void routedetails() {
		wait.until(ExpectedConditions.visibilityOf(dr.directionBtmSht));
		Assert.assertNotNull(dr.directionBtmSht, "Direction bottom sheet element is null.");
		Assert.assertTrue(dr.directionBtmSht.isDisplayed(), "Direction bottom sheet element is not displayed.");

		bf.sleepWait(10);

		wait.until(ExpectedConditions.visibilityOf(dr.directionTime));
		Assert.assertNotNull(dr.directionTime, "Direction time element is null.");
		Assert.assertTrue(dr.directionTime.isDisplayed(), "Direction time element is not displayed.");

		String duration = dr.directionTime.getText();
		Reporter.log("Duration: " + duration, true);

		wait.until(ExpectedConditions.visibilityOf(dr.distance));
		Assert.assertNotNull(dr.distance, "Distance element is null.");
		Assert.assertTrue(dr.distance.isDisplayed(), "Distance element is not displayed.");

		String distance = dr.distance.getText();
		Reporter.log("Distance: " + distance, true);

		wait.until(ExpectedConditions.visibilityOf(dr.estArrivalTime));
		Assert.assertNotNull(dr.estArrivalTime, "Estimated arrival time element is null.");
		Assert.assertTrue(dr.estArrivalTime.isDisplayed(), "Estimated arrival time element is not displayed.");

		String estTime = dr.estArrivalTime.getText();
		Reporter.log("Estimated Time: " + estTime, true);
	}

	public void addStop() throws IOException, InterruptedException {
		Assert.assertNotNull(dr.stopAction, "Stop action element is null.");
		Assert.assertTrue(dr.stopAction.isDisplayed(), "Stop action element is not displayed.");

		dr.stopAction.click();
		Reporter.log("Action dots clicked", true);
		Assert.assertNotNull(dr.addStop, "Add stop element is null.");
		Assert.assertTrue(dr.addStop.isDisplayed(), "Add stop element is not displayed.");

		dr.addStop.click();
		Reporter.log("Add stop clicked", true);

		Assert.assertNotNull(dr.enterStopLocation, "Enter stop location element is null.");
		Assert.assertTrue(dr.enterStopLocation.isDisplayed(), "Enter stop location element is not displayed.");

		dr.enterStopLocation.click();
		String placeStart = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeStart, 2);

		wait.until(ExpectedConditions.visibilityOf(dr.getRouteBtn));
		Assert.assertNotNull(dr.getRouteBtn, "Get Route button element is null.");
		Assert.assertTrue(dr.getRouteBtn.isDisplayed(), "Get Route button element is not displayed.");

		dr.getRouteBtn.click();
		Reporter.log("Get Route Clicked", true);
	}

	public void navigateAndFetchDirectionsPreview() throws IOException {

		try {
			while (true) {
				// Fetch and print direction and distance
				String direction = getDirectionText();
				String distance = getDistanceText();
				Reporter.log("Direction: " + direction + " , " + "Distance: " + distance, true);
				// Check if distance is zero, click back button and stop navigation if so
				if (distance.equals("0 m")) {
					Reporter.log("Distance is zero, clicking back button and stopping navigation.", true);
					dr.pageBack.click();
					break; // Exit the loop if distance is zero
				}
				dr.BtnNext.click();

				// Wait for the text to be updated
				wait.until(ExpectedConditions.textToBePresentInElement(dr.directionPText, getDirectionText()));
				wait.until(ExpectedConditions.textToBePresentInElement(dr.directionPDist, getDistanceText()));
			}
		} catch (Exception e) {
			Reporter.log("Exception occurred during navigation: " + e.getMessage(), true);
			e.printStackTrace();
		}
	}

	private String getDirectionText() {
		return dr.directionPText.getText();
	}

	private String getDistanceText() {
		return dr.directionPDist.getText();
	}

	// ========================================================================================================================================================
	public void navigateAndFetchDirectionStart(String pname) throws IOException {
		wait.until(ExpectedConditions.visibilityOf(dr.stripContainer));
		bf.sleepWait(3);

		try {
			while (true) {
				String direction = getDirectionStripText();
				String distance = getDistanceStripText();
				Reporter.log("Direction: " + direction + " , " + "Distance: " + distance, true);
				if (direction.equals(pname)) {
					Reporter.log("Final direction location found, stopping  further navigation.", true);
					dr.bottomSheetControllerClose.click();
					break;
				}

				dr.stripRight.click();
				wait.until(ExpectedConditions.textToBePresentInElement(dr.stripText, getDirectionStripText()));
				wait.until(ExpectedConditions.textToBePresentInElement(dr.stripDistance, getDistanceStripText()));
			}
		} catch (Exception e) {
			Reporter.log("Exception occurred during navigation: " + e.getMessage(), true);
			e.printStackTrace();
		}
	}

	private String getDirectionStripText() {
		return dr.stripText.getText();
	}

	private String getDistanceStripText() {
		return dr.stripDistance.getText();
	}

	public void closeDirection() {
		Assert.assertNotNull(dr.directionBack, "Direction back element is null.");
		Assert.assertTrue(dr.directionBack.isDisplayed(), "Direction back element is not displayed.");

		dr.directionBack.click();
		Reporter.log("Direction back clicked", true);

	}

	public void btmshtSwipe() {
		WebElement bottomSheet = wait.until(ExpectedConditions.visibilityOf(dr.directionBtmSht));
		Assert.assertNotNull(bottomSheet, "Bottom sheet element is null.");

		Assert.assertTrue(bottomSheet.isDisplayed(), "Bottom sheet element is not displayed.");

		swipeBtmShtUp(bottomSheet);
		bf.sleepWait(3);
		Reporter.log("Swiped the bottom sheet on direction page", true);
	}

	private void swipeBtmShtUp(WebElement bottomSheet) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(bottomSheet).moveByOffset(0, -500).release().perform();
	}

	public void showOnMapBtn() {
		wait.until(ExpectedConditions.visibilityOf(dr.showOnMapBtn));
		Assert.assertNotNull(dr.showOnMapBtn, "Show on Map button element is null.");
		Assert.assertTrue(dr.showOnMapBtn.isDisplayed(), "Show on Map button element is not displayed.");

		dr.showOnMapBtn.click();
		Reporter.log("Show on Map button clicked", true);
	}

	public void carMode() {
		wait.until(ExpectedConditions.visibilityOf(dr.tablyn));

		Assert.assertNotNull(dr.tablyn, "Tab layout element is null.");
		Assert.assertTrue(dr.tablyn.isDisplayed(), "Tab layout element is not displayed.");

		Assert.assertNotNull(dr.modecar, "Car mode element is null.");
		Assert.assertTrue(dr.modecar.isDisplayed(), "Car mode element is not displayed.");

		dr.modecar.click();
		boolean isSelected = dr.modecar.getAttribute("selected").equals("true");
		if (isSelected) {
			Reporter.log("Car Mode is selected.", true);
			Assert.assertTrue(isSelected, "Car Mode should be selected, but it is not.");
		} else {
			Reporter.log("Car Mode is not selected.", true);
			Assert.fail("Car Mode is not selected.");
		}
	}

	public void bikemode() {
		wait.until(ExpectedConditions.visibilityOf(dr.tablyn));
		Assert.assertNotNull(dr.tablyn, "Tab layout element is null.");
		Assert.assertTrue(dr.tablyn.isDisplayed(), "Tab layout element is not displayed.");

		Assert.assertNotNull(dr.modebike, "Bike mode element is null.");
		Assert.assertTrue(dr.modebike.isDisplayed(), "Bike mode element is not displayed.");

		dr.modebike.click();
		boolean isSelected = dr.modebike.getAttribute("selected").equals("true");
		if (isSelected) {
			Reporter.log("Bike Mode is selected.", true);
			Assert.assertTrue(isSelected, "Bike Mode should be selected, but it is not.");
		} else {
			Reporter.log("Bike Mode is not selected.", true);
			Assert.fail("Bike Mode is not selected.");
		}

	}

	public void truckMode() {
		wait.until(ExpectedConditions.visibilityOf(dr.tablyn));
		Assert.assertNotNull(dr.tablyn, "Tab layout element is null.");
		Assert.assertTrue(dr.tablyn.isDisplayed(), "Tab layout element is not displayed.");

		Assert.assertNotNull(dr.modetruck, "Truck mode element is null.");
		Assert.assertTrue(dr.modetruck.isDisplayed(), "Truck mode element is not displayed.");

		dr.modetruck.click();
		boolean isSelected = dr.modetruck.getAttribute("selected").equals("true");
		if (isSelected) {
			Reporter.log("Truck Mode is selected.", true);
			Assert.assertTrue(isSelected, "Truck Mode should be selected, but it is not.");
		} else {
			Reporter.log("Truck Mode is not selected.", true);
			Assert.fail("Truck Mode is not selected.");
		}

	}

	public void walkMode() {
		wait.until(ExpectedConditions.visibilityOf(dr.tablyn));
		Assert.assertNotNull(dr.tablyn, "Tab layout element is null.");
		Assert.assertTrue(dr.tablyn.isDisplayed(), "Tab layout element is not displayed.");

		Assert.assertNotNull(dr.modewalk, "Walk mode element is null.");
		Assert.assertTrue(dr.modewalk.isDisplayed(), "Walk mode element is not displayed.");

		dr.modewalk.click();
		boolean isSelected = dr.modewalk.getAttribute("selected").equals("true");
		if (isSelected) {
			Reporter.log("Walk Mode is selected.", true);
			Assert.assertTrue(isSelected, "Walk Mode should be selected, but it is not.");
		} else {
			Reporter.log("Walk Mode is not selected.", true);
			Assert.fail("Walk Mode is not selected .");
		}

	}

	public void enterPlace(String pname, int num) throws IOException, InterruptedException {
		sp.searchBarInput.sendKeys(pname);
		Reporter.log("Place entered for search :- " + pname, true);

		WebElement parentRecyclerView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));

		boolean found = false;
		int attempts = 0;

		while (!found) {
			try {
				List<WebElement> childViewGroups = parentRecyclerView.findElements(By.className("android.view.ViewGroup"));

				// Start loop from the third ViewGroup (index 2)
				for (int i = num; i < childViewGroups.size(); i++) {
					WebElement viewGroup = childViewGroups.get(i);
					List<WebElement> linearLayouts = viewGroup.findElements(By.className("android.widget.LinearLayout"));

					for (WebElement linearLayout : linearLayouts) {
						try {
							WebElement textContainer = linearLayout.findElement(By.id("com.mmi.maps:id/text_instruction_container"));
							WebElement textView = textContainer.findElement(By.id("com.mmi.maps:id/auto_list_item"));

							String suggestionText = textView.getText();
							if (suggestionText.trim().equalsIgnoreCase(pname)) {
								Reporter.log("Found place: " + pname, true);
								Reporter.log("Place name on the layout to be clicked is: " + suggestionText, true);
								viewGroup.click();
								Reporter.log("Search place clicked", true);
								found = true;
								break;
							}
						} catch (NoSuchElementException e) {
							// Continue to the next linear layout
						}
					}

					if (found)
						break;
				}
				if (!found) {
					attempts++;
					bf.sleepWait(4);
				}
			} catch (StaleElementReferenceException e) {
				Reporter.log("Encountered StaleElementReferenceException, retrying...", true);
				attempts++;
				parentRecyclerView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));
			}
		}

		Assert.assertTrue(found, "Place not found in auto-suggest after " + attempts + " attempts.");
	}

	public void clickSrchIcon() {
		wait.until(ExpectedConditions.visibilityOf(dr.srchIcon));
		Assert.assertNotNull(dr.srchIcon, "Search icon element is null.");
		Assert.assertTrue(dr.srchIcon.isDisplayed(), "Search icon element is not displayed.");

		dr.srchIcon.click();
		Reporter.log("Search button clicked", true);
	}

	public void startNewRoute() {
		wait.until(ExpectedConditions.visibilityOf(dr.addContainer));

		Assert.assertNotNull(dr.addContainer, "Add container element is null.");
		Assert.assertTrue(dr.addContainer.isDisplayed(), "Add container element is not displayed.");

		Assert.assertNotNull(dr.titleText, "Title text element is null.");
		Assert.assertTrue(dr.titleText.isDisplayed(), "Title text element is not displayed.");
		Reporter.log("place :" + dr.titleText.getText(), true);

		Assert.assertNotNull(dr.addressText, "Address text element is null.");
		Assert.assertTrue(dr.addressText.isDisplayed(), "Address text element is not displayed.");
		Reporter.log("Address :" + dr.addressText.getText(), true);

		Assert.assertNotNull(dr.disttext, "Distance text element is null.");
		Assert.assertTrue(dr.disttext.isDisplayed(), "Distance text element is not displayed.");
		Reporter.log("Distance :" + dr.disttext.getText(), true);

		wait.until(ExpectedConditions.visibilityOf(dr.startNewRoute));

		Assert.assertNotNull(dr.startNewRoute, "Start new route element is null.");
		Assert.assertTrue(dr.startNewRoute.isDisplayed(), "Start new route element is not displayed.");
		dr.startNewRoute.click();
		Reporter.log("Start new Route button clicked", true);
		String snackBarMsg = mww.snackBarMessage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg.trim(), true);
		Assert.assertEquals(snackBarMsg, "Ratu is successfully added to your destination");

	}

	public void addWayPt() {
		wait.until(ExpectedConditions.visibilityOf(dr.addContainer));

		Assert.assertNotNull(dr.addContainer, "Add container element is null.");
		Assert.assertTrue(dr.addContainer.isDisplayed(), "Add container element is not displayed.");

		Assert.assertNotNull(dr.titleText, "Title text element is null.");
		Assert.assertTrue(dr.titleText.isDisplayed(), "Title text element is not displayed.");
		Reporter.log("place :" + dr.titleText.getText(), true);

		Assert.assertNotNull(dr.addressText, "Address text element is null.");
		Assert.assertTrue(dr.addressText.isDisplayed(), "Address text element is not displayed.");
		Reporter.log("Address :" + dr.addressText.getText(), true);

		Assert.assertNotNull(dr.disttext, "Distance text element is null.");
		Assert.assertTrue(dr.disttext.isDisplayed(), "Distance text element is not displayed.");
		Reporter.log("Distance :" + dr.disttext.getText(), true);

		wait.until(ExpectedConditions.visibilityOf(dr.addWayPoint));
		Assert.assertNotNull(dr.addWayPoint, "Add Way Point button element is null.");
		Assert.assertTrue(dr.addWayPoint.isDisplayed(), "Add Way Point button element is not displayed.");

		dr.addWayPoint.click();
		Reporter.log("Add Way Point button clicked", true);

		String snackBarMsg = mww.snackBarMessage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg.trim(), true);
		Assert.assertEquals(snackBarMsg, "Ratu is successfully added to your way point");

	}

	public void clickStartBtn() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(dr.startBtn));
		Assert.assertNotNull(dr.startBtn, "Start button element is null.");
		Assert.assertTrue(dr.startBtn.isDisplayed(), "Start button element is not displayed.");
		bf.visibility(dr.startBTnText, "Start button");
		String expectedText = "Start";
		String foundText =dr.startBTnText.getText();
		Assert.assertEquals(expectedText.toLowerCase(),foundText.toLowerCase(),"text did not match ");
		dr.startBtn.click();
		Reporter.log("Start clicked", true);
		Thread.sleep(2000);
	}

	public void clickpostReport() {
		Assert.assertNotNull(dr.postIcn, "Post icon element is null.");
		Assert.assertTrue(dr.postIcn.isDisplayed(), "Post icon element is not displayed.");

		dr.postIcn.click();
		Reporter.log("Report Post clicked", true);
	}

	public void postingDetails(String cmnt) {
		try {
			wait.until(ExpectedConditions.visibilityOf(dr.reportcategoryCont));
			Assert.assertTrue(dr.reportcategoryCont.isDisplayed(), "Post on Map Bottom Sheet should be displayed");
			bf.sleepWait(2);

			Reporter.log("category found here is :-" + dr.pomCategory.getText(), true);

			wait.until(ExpectedConditions.visibilityOf(dr.catRview));
			Assert.assertTrue(dr.catRview.isDisplayed(), "Category layout should be displayed");
			bf.sleepWait(2);

			dr.jam.click();
			Reporter.log("Clicked on 'Jam'.", true);
			bf.sleepWait(2);

			dr.light.click();
			Reporter.log("Clicked on 'Light'.", true);
			bf.sleepWait(2);

			pdp.addDesc.click();
			Reporter.log("Clicked on 'Add Description'.", true);

			wait.until(ExpectedConditions.visibilityOf(pdp.commentEdit));
			Assert.assertTrue(pdp.commentEdit.isDisplayed(), "Comment Edit field should be displayed");

			pdp.commentEdit.click();
			pdp.commentEdit.sendKeys(cmnt);

			Assert.assertTrue(pdp.cmntDone.isDisplayed(), "Done button should be displayed");
			pdp.cmntDone.click();
			Reporter.log("Clicked on 'Done'.", true);

		} catch (Exception e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}

	public void clickbtmShtController() {
		Assert.assertNotNull(dr.bottomSheetControllerBtn, "Bottom sheet controller button is null.");

		dr.bottomSheetControllerBtn.click();
		Reporter.log("Bottom Sheet controller clicked");
	}

	public void directionlist() {
		Assert.assertNotNull(dr.directionlistBtn, "Direction list button is null.");
		Reporter.log("Direction list button is found", true);

		dr.directionlistBtn.click();
		Reporter.log("Direction list button clicked", true);

	}

	public void clickSaveRoute() {
		Assert.assertNotNull(dr.saveRouteBtn, "Save route button is null.");
		Reporter.log("Save route button is found", true);

		dr.saveRouteBtn.click();
		Reporter.log("Save route button clicked", true);
	}

	public void enterRouteTosave(String routeName) {
		wait.until(ExpectedConditions.visibilityOf(dr.setRouteNameBox));
		Assert.assertTrue(dr.setRouteNameBox.isDisplayed(), "Done button should be displayed");
		bf.visibilitys(dr.setRouteNameBoxTitle);

		Assert.assertTrue(dr.setRouteNameBoxTitle.isDisplayed(), "Done button should be displayed");
		Reporter.log("title :-" + dr.setRouteNameBoxTitle.getText(), true);

		wait.until(ExpectedConditions.visibilityOf(dr.setRouteName));
		Assert.assertTrue(dr.setRouteName.isDisplayed(), "Done button should be displayed");
		dr.setRouteName.sendKeys(routeName);

		wait.until(ExpectedConditions.visibilityOf(dr.setRouteNameSave));
		Assert.assertTrue(dr.setRouteNameSave.isDisplayed(), "Done button should be displayed");
		dr.setRouteNameSave.click();

		bf.toastMsg("Route saved successfully");

	}

	public void closebtmShtControllerPage() {
		wait.until(ExpectedConditions.visibilityOf(dr.closeBtmSheethavingController));
		Assert.assertTrue(dr.closeBtmSheethavingController.isDisplayed(), "cross button should be displayed");
		dr.closeBtmSheethavingController.click();
	}

	// 1
	public void ChooseOnMapLocStart() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseLocOnMap();
		startText(0);
		finalLoc();
		String place = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(place, 2);
		finalText(1);
		bf.sleepWait(15);
		routedetails();
	}

	public void CurrentLocStart() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		startText(0);
		finalLoc();
		String place = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(place, 1);
		finalText(1);
		bf.sleepWait(15);
		routedetails();
	}

	public void ChooseOnMapLocEnd() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		String place = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(place, 2);
		startText(0);
		finalLoc();
		chooseLocOnMap();
		finalText(1);
		bf.sleepWait(15);
		routedetails();
	}

	// 2
	public void CurrentLocFinal() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		String place = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(place, 2);
		startText(0);
		finalLoc();
		chooseYourCurLoc();
		finalText(1);
		bf.sleepWait(15);
		routedetails();
	}

	// 3
	public void StartandFinalLoc() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		String placeStart = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeStart, 2);
		startText(0);
		finalLoc();
		String placeFinal = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeFinal, 2);
		finalText(1);
		bf.sleepWait(15);
		routedetails();
	}

	// 4
	public void interchangeStartAndFinal() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		String placeStart = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeStart, 2);
		String startText = startText(0);
		finalLoc();
		String placeFinal = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeFinal, 2);
		String finatTxt = finalText(1);
		bf.sleepWait(15);
		routedetails();
		bf.sleepWait(15);
		reverse();
		String startTextreversed = startText(0);
		String finatTxtreversed = finalText(1);
		bf.sleepWait(15);
		routedetails();
		Assert.assertTrue(startText.toLowerCase().equals(finatTxtreversed.toLowerCase()),"Values do not match so start location is not interchanged.");
		Assert.assertTrue(finatTxt.toLowerCase().equals(startTextreversed.toLowerCase()),"Values do not match so final location is not interchanged.");

	}

	// 5
	public void addingStop() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		String placeStart = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeStart, 2);
		finalLoc();
		String placeFinal = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeFinal, 2);
		bf.sleepWait(15);
		addStop();
		bf.sleepWait(15);
		routedetails();
	}

	// 6
	public void PreviewRoute() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		enterPlace("Gumla", 2);
		finalLoc();
		enterPlace("Ranchi", 2);
		bf.sleepWait(15);
		routedetails();
		bf.sleepWait(15);
        bf.visibility(dr.startBtn,"Route Details layout");
		bf.visibility(dr.startBTnText, "Start/preview Button in Route detail layout");
		String requiredText = "Preview";
		String foundText = dr.startBTnText.getText();
		Assert.assertEquals(requiredText.toLowerCase(), foundText.toLowerCase(),"text did not match ");
		dr.startBtn.click();
		Reporter.log("clicked preview", true);
		navigateAndFetchDirectionsPreview();
	}

	// 7
	public void StartRoute() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		navigateAndFetchDirectionStart("Ranchi");
	}

	// 8
	public void directionBtmshtShowOnMap() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		enterPlace("Ranchi", 2);
		finalLoc();
		enterPlace("Gumla", 2);
		bf.sleepWait(15);
		routedetails();
		btmshtSwipe();
		showOnMapBtn();
		navigateAndFetchDirectionsPreview();
	}

	// 9
	public void modeCar() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		carMode();
		bf.sleepWait(15);
		routedetails();
	}

	// 10
	public void modeBike() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		bikemode();
		bf.sleepWait(15);
		routedetails();
	}

	// 11
	public void modeTruck() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		truckMode();
		bf.sleepWait(15);
		routedetails();
	}

	// 12
	public void modeWalk() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		walkMode();
		bf.sleepWait(15);
		routedetails();
	}

	// 13
	public void searchStartNewRoute() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		bf.sleepWait(15);
		routedetails();
		bf.sleepWait(15);
		clickStartBtn();
		clickSrchIcon();
		spf.searchPlace("Ratu");
		startNewRoute();
	}

	// 14
	public void searchAddWayPoint() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		bf.sleepWait(15);
		routedetails();
		bf.sleepWait(15);
		clickStartBtn();
		clickSrchIcon();
		spf.searchPlace("Ratu");
		addWayPt();
	}

	// 15
	public void postonmap() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.UserClickOnHamburgerMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		String placeEnter = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeEnter, 1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		clickpostReport();
		String randomtext = RandomDataGenerator.generateRandomTrafficReport();
		postingDetails(randomtext);
		pdf.innerPostClick();
		bf.sleepWait(5);
		pdf.postSuccessful();
	}

	// 16
	public void postOnMapWL() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		String placeEnter = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeEnter, 1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		clickpostReport();
		String randomtext = RandomDataGenerator.generateRandomExperience();
		postingDetails(randomtext);
		pdf.innerPostClick();
		pdf.RequiredLoginBox("Post an Issue");
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		bf.sleepWait(5);
		pdf.innerPostClick();
		bf.sleepWait(5);
		pdf.postSuccessful();

	}

	// 17
	public void saveRoute() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.UserClickOnHamburgerMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		String placeEnter = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeEnter, 1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		clickbtmShtController();
		clickSaveRoute();
		String route = RandomDataGenerator.generateRandomRouteName();
		enterRouteTosave(route);
		savedRouteVerification();
		verifyItemInMyRoutes(route);

	}

	// 18
	public void saveRouteWL() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		String placeEnter = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeEnter, 1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		clickbtmShtController();
		clickSaveRoute();
		pdf.RequiredLoginBox("Save Route");
	}

	public void savedRouteVerification() {
		clickbtmShtController();
		closebtmShtControllerPage();
		dr.directionRoutepageBack.click();
		bf.Hamburgerclick();
		uf.user.click();
		Reporter.log("menu clicked", true);
		uf.mysaves.click();
		Reporter.log("saves clicked", true);
		clickItemMyRoute("My Routes");
	}

	public void savedRouteVerificationWL() {
		clickbtmShtController();
		closebtmShtControllerPage();
		dr.directionRoutepageBack.click();
		upf.handleUpdate();
		bf.Hamburgerclick();
		uf.user.click();
		Reporter.log("menu clicked", true);
		uf.mysaves.click();
		Reporter.log("saves clicked", true);
		clickItemMyRoute("My Routes");
	}

	public void clickItemMyRoute(String expectedItem) {
		// Wait until the RecyclerView is visible
		WebElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/quick_links_recycler_view"));
		// Retrieve the list of relative layouts from the RecyclerView
		List<WebElement> relativeLayouts = recyclerView.findElements(By.className("android.widget.RelativeLayout"));
		boolean itemFound = false;

		for (WebElement relativeLayout : relativeLayouts) {
			// Retrieve the list of linear layouts within each relative layout
			List<WebElement> linearLayouts = relativeLayout.findElements(By.className("android.widget.LinearLayout"));

			for (WebElement linearLayout : linearLayouts) {
				// Retrieve the text views within each linear layout
				List<WebElement> textViews = linearLayout.findElements(By.className("android.widget.TextView"));
				for (WebElement textView : textViews) {
					String text = textView.getText().trim();

					// Check if the text matches the expected item (ignoring case)
					if (text.equalsIgnoreCase(expectedItem.trim())) {
						itemFound = true;
						textView.click(); // Click on the matched item
						System.out.println("Clicked on the item: " + expectedItem);
						break;
					}
				}

				if (itemFound) {
					break;
				}
			}

			if (itemFound) {
				break;
			}
		}

		// Assert that the item was found and clicked
		Assert.assertTrue(itemFound, "Item not found: " + expectedItem);
		System.out.println("Item " + expectedItem + " was found and clicked successfully.");
	}

	public void verifyItemInMyRoutes(String expectedName) {
		// Locate the RecyclerView
		WebElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/my_routes_recycler_view"));

		// Retrieve the list of relative layouts from the RecyclerView
		List<WebElement> relativeLayouts = recyclerView.findElements(By.className("android.widget.RelativeLayout"));

		boolean itemFound = false;

		for (WebElement relativeLayout : relativeLayouts) {
			// Retrieve the list of linear layouts within each relative layout
			List<WebElement> linearLayouts = relativeLayout.findElements(By.className("android.widget.LinearLayout"));
			Assert.assertFalse(linearLayouts.isEmpty(), "No saved routes  found in my routes.");

			for (WebElement linearLayout : linearLayouts) {
				// Retrieve the text views within each linear layout
				List<WebElement> textViews = linearLayout.findElements(By.className("android.widget.TextView"));
				Assert.assertFalse(textViews.isEmpty(), "No TextViews found in LinearLayout.");

				for (WebElement textView : textViews) {
					String text = textView.getText().trim();

					// Check if the text matches the expected name (ignoring case)
					if (text.equalsIgnoreCase(expectedName.trim())) {
						itemFound = true;
						System.out.println("Found the item in the list : " + expectedName);
						break;
					}
				}

				if (itemFound) {
					break;
				}
			}

			if (itemFound) {
				break;
			}
		}

		// Assert that the item was found
		Assert.assertTrue(itemFound, "Item not found: " + expectedName);
		System.out.println("Item " + expectedName + " was found successfully.");
	}

	// 19
	public void DirectionList() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		String placeEnter = "Ranchi";
		enterPlace(placeEnter, 1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		clickbtmShtController();
		directionlist();
		dr.showOnMapDirectionList.click();
		Reporter.log("Clicked Show On map", true);
		navigateAndFetchDirectionStart(placeEnter);
	}

	// check route location set as home and set as work
	public void directionToHome() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.UserClickOnHamburgerMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		startText(0);
		dr.homeTitle.click();
		finalText(1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		navigateAndFetchDirectionStart("Home");
	}

	public void directionToWork() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.UserClickOnHamburgerMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		startText(0);
		dr.WorkTitle.click();
		finalText(1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		navigateAndFetchDirectionStart("Work");
	}

	public void directionToHomeWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		startText(0);
		dr.homeTitle.click();
		pdf.RequiredLoginBox("Add Home");
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		bp.clickBackbtn.click();
		upf.handleUpdate();
		homeDirection();
		dr.homeTitle.click();
		finalText(1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		navigateAndFetchDirectionStart("Home");
	}

	public void directionToWorkWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		startText(0);
		dr.WorkTitle.click();
		pdf.RequiredLoginBox("Add Work");
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		bp.clickBackbtn.click();
		upf.handleUpdate();
		homeDirection();
		dr.WorkTitle.click();
		finalText(1);
		bf.sleepWait(15);
		routedetails();
		clickStartBtn();
		navigateAndFetchDirectionStart("Work");
	}

//		418	Check UI for Navigation Page -  Verify the UI is proper in Navigation	UI for all screen should be properly visible and function should work properly  wip
	public void NavigationPageui() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		wait.until(ExpectedConditions.visibilityOf(dr.tablyn));

		Assert.assertNotNull(dr.tablyn, "Tab layout element is null.");
		Assert.assertTrue(dr.tablyn.isDisplayed(), "Tab layout element is not displayed.");
		Reporter.log("Transportation mode layout is Displayed  ", true);

		Assert.assertNotNull(dr.homeTitle, "Home layout element is null.");
		Assert.assertTrue(dr.homeTitle.isDisplayed(), "Home layout element is not displayed.");
		Reporter.log("Home layout is Displayed  ", true);

		Assert.assertNotNull(dr.WorkTitle, "Work layout element is null.");
		Assert.assertTrue(dr.WorkTitle.isDisplayed(), "Work layout element is not displayed.");
		Reporter.log("Work layout is Displayed  ", true);

		startLoc();
		String placeStart = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeStart, 2);
		startText(0);
		finalLoc();
		String placeFinal = RandomDataGenerator.generateRandomPlaceName();
		enterPlace(placeFinal, 2);
		finalText(1);
		bf.sleepWait(15);
		routedetails();
		bf.sleepWait(15);

		wait.until(ExpectedConditions.visibilityOf(dr.startBtn));
		Assert.assertNotNull(dr.startBtn, "Start button element is null.");
		Assert.assertTrue(dr.startBtn.isDisplayed(), "Start button element is not displayed.");
		Reporter.log("Start Button Displayed  ", true);

		Assert.assertNotNull(dr.stopAction, "Stop action element is null.");
		Assert.assertTrue(dr.stopAction.isDisplayed(), "Stop action element is not displayed.");
		Reporter.log("Action dots Displayed  ", true);

		wait.until(ExpectedConditions.visibilityOf(dr.reverseLocation));
		Assert.assertNotNull(dr.reverseLocation, "Reverse location element is null.");
		Assert.assertTrue(dr.reverseLocation.isDisplayed(), "Reverse location element is not displayed.");
		Reporter.log("Interchange/Reverse  is displayed  ", true);

	}

//		419	Verify Navigation without via points - Search for a route without Via Point	Route should get draw by providing starting and destination point(without get route button)	Automation	WIP
	public void NavigationWithoutgetroute() throws IOException, InterruptedException {
		StartandFinalLoc();

	}

//		420	Verify Navigation with via points  -  Route should get draw after clicking on 'Get Route' button by providing starting, destination and via point(s)	Automation	WIP
	public void NavigationWithgetroute() throws IOException, InterruptedException {
		addingStop();
	}

//		423	Verify Navigation in MapmyIndia layer mode - Search for a route in MapmyIndia Map layer	MapmyIndia map layer should be display while navigating wip
	public void NavigationMmiLayer() throws IOException, InterruptedException {
		StartandFinalLoc();
		wait.until(ExpectedConditions.visibilityOf(dr.mapLayerbtn));

		Assert.assertNotNull(dr.mapLayerbtn, "Map Layer Button element is null.");
		Assert.assertTrue(dr.mapLayerbtn.isDisplayed(), "Map Layer Button element is not displayed.");
		Reporter.log("Map Layer Button layout is Displayed  ", true);
		dr.mapLayerbtn.click();
		bf.sleepWait(2);
		ml.maplayersVerfication(1, "Default Map already selected");

	}

//		424	Verify the Start button in Direction card ===Start button should be available on direction card	===Automation ==	Done
	public void NavigationStartbtnavailability() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		startText(0);
		finalLoc();
		enterPlace("Ranchi", 1);
		finalText(1);
		bf.sleepWait(15);
		routedetails();
		bf.visibility(dr.startBtn,"route detail layout");
		bf.visibility(dr.startBTnText, "Start button");
		String expectedText = "Start";
		String foundText =dr.startBTnText.getText();
		Assert.assertEquals(expectedText.toLowerCase(),foundText.toLowerCase(),"text did not match ");
		Reporter.log("button text : " +foundText , true);
	}

//		425	Verify the Start button in Direction card =====Checking the start is clicklable	Start button should be clickable and open the navigation page====Automation	==Done
	public void NavigationClickStartbtn() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Ranchi", 1);
		bf.sleepWait(15);
		routedetails();
		bf.sleepWait(15);
		clickStartBtn();
		wait.until(ExpectedConditions.visibilityOf(dr.stripContainer));
		Assert.assertNotNull(dr.stripContainer, "Post icon element is null.");
		Assert.assertTrue(dr.stripContainer.isDisplayed(), "Post icon element is not displayed.");
		Reporter.log("Instuctions container is  displayed", true);

		Assert.assertNotNull(dr.postIcn, "Post icon element is null.");
		Assert.assertTrue(dr.postIcn.isDisplayed(), "Post icon element is not displayed.");
		Reporter.log("Report icon displayed", true);

		wait.until(ExpectedConditions.visibilityOf(dr.srchIcon));
		Assert.assertNotNull(dr.srchIcon, "Search icon element is null.");
		Assert.assertTrue(dr.srchIcon.isDisplayed(), "Search icon element is not displayed.");
		Reporter.log("Search icon displayed", true);

		Assert.assertNotNull(dr.bottomSheetControllerBtn, "Bottom sheet controller button is null.");
		Assert.assertTrue(dr.bottomSheetControllerBtn.isDisplayed(),"Bottom sheet controller button is not displayed.");
		Reporter.log("Bottom sheet controller button is displayed", true);

	}

//		428	Verify for Route summary UI =========Check that all the texts and icons are proper and correct	All the texts and icons should be clearly visible and correct =done
	public void NavigationRouteSummaryui() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		homeDirection();
		startLoc();
		chooseYourCurLoc();
		finalLoc();
		enterPlace("Gumla", 1);
		bf.sleepWait(15);
		routedetails();
//		bf.sleepWait(15);
		Assert.assertNotNull(dr.routeinfo, "Route information button is null.");
		Assert.assertTrue(dr.routeinfo.isDisplayed(), "Route information button is not displayed.");
		Reporter.log("Route information button is displayed", true);
		dr.routeinfo.click();

		Assert.assertNotNull(dr.route_info_image_view, "Route information icon is null.");
		Assert.assertTrue(dr.route_info_image_view.isDisplayed(), "Route information icon is not displayed.");
		Reporter.log("Route information icon is displayed", true);

		Assert.assertNotNull(dr.textViewRouteSummary, "Route Summary is null.");
		Assert.assertTrue(dr.textViewRouteSummary.isDisplayed(), "Route Summary is not displayed.");
		Reporter.log("Route Summary is displayed", true);
		String text = dr.textViewRouteSummary.getText();
		Reporter.log("text displayed : " + text, true);

		Assert.assertNotNull(dr.imageViewClose, "close icon is null.");
		Assert.assertTrue(dr.imageViewClose.isDisplayed(), "close icon is not displayed.");
		Reporter.log("close icon is displayed", true);

	

	}

}
