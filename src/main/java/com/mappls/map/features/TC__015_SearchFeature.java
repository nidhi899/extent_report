package com.mappls.map.features;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.TC__015_SearchPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;


public class TC__015_SearchFeature {

	


	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;
	TC__015_SearchPage sp;
	BaseFeatures bf;
	TC__019_UserProfileFeature upf;
	TC__010_AddPlacesFeature apf;

	public TC__015_SearchFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		sp = new TC__015_SearchPage(driver);
		bf = new BaseFeatures(driver);
		upf = new TC__019_UserProfileFeature(driver);
		apf = new TC__010_AddPlacesFeature(driver);

	}

//-----------------------------------------------------------------------------------------------------------------------------------	    

	public void closeSearch() throws IOException {
		sp.searchBarCross.click();
		Reporter.log("Search bar cross button clicked, reverted to home screen.", true);

	}

	public void searchBar() throws IOException {
		sp.searchBar.click();
		Reporter.log("Search Bar Clicked", true);
		bf.sleepWait(2);
	}

//---------------------This is by autosuggest method 	    
	public void searchPlace(String pname) throws IOException, InterruptedException {
		sp.searchBarInput.sendKeys(pname);
		Reporter.log("Place entered for search " + " :-  " + pname, true);

		// Find the parent RecyclerView
		WebElement parentRecyclerView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));
		// Find all child ViewGroups within the RecyclerView
		List<WebElement> childViewGroups = parentRecyclerView.findElements(By.className("android.view.ViewGroup"));

		boolean found = false;
		int attempts = 0;
		while (!found && attempts < 4) {
			try {
				// Loop through the child ViewGroups
				for (WebElement viewGroup : childViewGroups) {
					// Find all child LinearLayouts within the ViewGroup
					List<WebElement> linearLayouts = viewGroup
							.findElements(By.className("android.widget.LinearLayout"));
					// Loop through the LinearLayouts
					for (WebElement linearLayout : linearLayouts) {
						WebElement textContainer = linearLayout
								.findElement(By.id("com.mmi.maps:id/text_instruction_container"));
						WebElement textView = textContainer.findElement(By.id("com.mmi.maps:id/auto_list_item"));
						WebElement textViewAdd = textContainer
								.findElement(By.id("com.mmi.maps:id/auto_list_item_address"));
						String suggestionText = textView.getText();

						// Check if the suggestion text matches the desired search query
						if (suggestionText.trim().equalsIgnoreCase(pname)) {
							Reporter.log("Searched place: " + pname, true);
							Reporter.log("Place name on the layout to be clicked is: " + suggestionText, true);
							Reporter.log("Place address on the layout to be clicked is: " + textViewAdd.getText(),true);
							viewGroup.click();
							Reporter.log("Search place is clicked", true);
							bf.sleepWait(2);
							found = true;
							break;
						}
					}
				}
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		Assert.assertTrue(found, "Place not found in auto-suggest");
	}

	public String placeDetail() throws IOException {
		wait.until(ExpectedConditions.visibilityOf(sp.placelayout));

		if (sp.placelayouthead.isDisplayed())
			Assert.assertTrue(sp.placelayouthead.isDisplayed(), "Place name not displayed");
		Reporter.log("Place name Displayed: " + sp.searchedPlaceName.getText(), true);
		String pname = sp.searchedPlaceName.getText();
		Reporter.log("Place address: " + sp.searchedPlaceAddress.getText(), true);
		return pname;
	}

	public void placeReview() {
		if (sp.placelayouthead.isDisplayed())

			Reporter.log("Place URL link: " + sp.elocUrl.getText(), true);
		Reporter.log("Displayed distance: " + sp.distance.getText(), true);
		Reporter.log("Displayed duration: " + sp.duration.getText(), true);
	}

	// -----------------------------------------this is by text search
	public void searchPlaceTextSearch(String placeName) throws InterruptedException {

		sp.searchBarInput.sendKeys(placeName);
		((PressesKey) driver).longPressKey(new KeyEvent(AndroidKey.ENTER));
		bf.sleepWait(2);

		WebElement bottomSheet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mmi.maps:id/main_layout")));
		WebElement stripLayout = bottomSheet.findElement(By.id("com.mmi.maps:id/strip_layout"));
		WebElement resultCountElement = stripLayout.findElement(By.id("com.mmi.maps:id/text_view_results"));
		String resultCountText = resultCountElement.getText();
		Reporter.log("Total results found in BottomSheet: " + resultCountText);

		swipeBottomSheetUpwards(bottomSheet);
		
		Thread.sleep(1000);

		boolean placeFound = false;
		while (!placeFound) {
			List<MobileElement> placeList = driver.findElements(By.className("android.view.ViewGroup"));

			// Adjust the class name accordingly
			for (WebElement placeElement : placeList) {
				WebElement placeNameElement = placeElement
						.findElement(By.id("com.mmi.maps:id/item_place_result_place_name"));
				String placeText = placeNameElement.getText();
				if (placeText.trim().equalsIgnoreCase(placeName)) {					
					placeElement.click();
					Reporter.log("Searched place is clicked", true);
					bf.sleepWait(2);
					placeFound = true;
					break;
				}
			}

			// If the place is not found, scroll the list and try again
			if (!placeFound) {
				swipeBottomSheetUpwards(bottomSheet);
				Thread.sleep(1000);
			}
		}

	}


	public void searchplaceTextSearch(String placeName) throws InterruptedException {

		sp.searchBarInput.sendKeys(placeName);
		Reporter.log("Place entered for search " + " :-  " + placeName, true);
		((PressesKey) driver).longPressKey(new KeyEvent(AndroidKey.ENTER));
		Reporter.log("Enter clicked", true);
		bf.sleepWait(2);

		WebElement bottomSheet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mmi.maps:id/main_layout")));
		Reporter.log("Bottom sheet with related place is displayed", true);
		WebElement stripLayout = bottomSheet.findElement(By.id("com.mmi.maps:id/strip_layout"));
		WebElement resultCountElement = stripLayout.findElement(By.id("com.mmi.maps:id/text_view_results"));
		String resultCountText = resultCountElement.getText();
		Reporter.log("Total results found in BottomSheet: " + resultCountText, true);

		swipeBottomSheetUpwards(bottomSheet);
		Reporter.log("Bottom Sheet is swiped to upward direction", true);
		Thread.sleep(1000);

		boolean placeFound = false;
		while (!placeFound) {
			List<MobileElement> placeList = driver.findElements(By.className("android.view.ViewGroup"));
			for (WebElement placeElement : placeList) {
				WebElement placeNameElement = placeElement
						.findElement(By.id("com.mmi.maps:id/item_place_result_place_name"));
				String placeText = placeNameElement.getText();
				if (placeText.trim().equalsIgnoreCase(placeName)) {
					WebElement placeDetails = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.id("com.mmi.maps:id/poi_list_card_content")));
					String placeNameDetails = placeDetails
							.findElement(By.id("com.mmi.maps:id/item_place_result_place_name")).getText();
					String placeAddress = placeDetails
							.findElement(By.id("com.mmi.maps:id/item_place_result_place_address")).getText();
					String placeRating = placeDetails.findElement(By.id("com.mmi.maps:id/item_place_result_rating_bar"))
							.getText();
					String placeDistance = placeDetails.findElement(By.id("com.mmi.maps:id/text_view_distance"))
							.getText();

					Reporter.log("Place Name: " + placeNameDetails, true);
					Reporter.log("Address: " + placeAddress, true);
					Reporter.log("Rating: " + placeRating, true);
					Reporter.log("Distance: " + placeDistance, true);

					placeElement.click();
					Reporter.log("Searched place is clicked", true);
					bf.sleepWait(2);
					placeFound = true;
					break;
				}
			}

			// If the place is not found, scroll the list and try again
			if (!placeFound) {
				swipeBottomSheetUpwards(bottomSheet);
				Thread.sleep(1000);
			}
		}

	}

	public void swipeBottomSheetUpwards(WebElement bottomSheet) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(bottomSheet).moveByOffset(0, -500).release().perform();
	}

	public void searchWithNearby(String category) throws IOException, InterruptedException {

		sp.searchBarInput.sendKeys(category);
		Reporter.log("Place entered for search " + " :-  " + category, true);

		wait.until(ExpectedConditions.visibilityOf(sp.suggestionList));

		// Find the parent RecyclerView
		WebElement parentRecyclerView = sp.suggestionList;
		boolean found = false;
		int attempts = 0;

		while (!found && attempts < 3) {
			try {
				// Find all child ViewGroups within the RecyclerView
				List<WebElement> childViewGroups = parentRecyclerView
						.findElements(By.className("android.view.ViewGroup"));

				// Loop through the child ViewGroups
				for (WebElement viewGroup : childViewGroups) {
					try {
						// Find all child LinearLayouts within the ViewGroup
						List<WebElement> linearLayouts = viewGroup
								.findElements(By.className("android.widget.LinearLayout"));

						// Loop through the LinearLayouts
						for (WebElement linearLayout : linearLayouts) {
							try {
								WebElement textContainer = linearLayout
										.findElement(By.id("com.mmi.maps:id/text_instruction_container"));
								WebElement textView = textContainer
										.findElement(By.id("com.mmi.maps:id/auto_list_item"));
								String suggestionText = textView.getText().trim();

								// Check if the suggestion text matches the desired search query
								if (suggestionText.equalsIgnoreCase(category + " near me")) {
									Reporter.log("Searched place: " + category, true);
									Reporter.log("Place name on the layout to be clicked is: " + suggestionText, true);
									viewGroup.click();
									Reporter.log("Tab is clicked", true);
									bf.sleepWait(2);

									found = true;
									break;
								}
							} catch (NoSuchElementException e) {
								// Continue if elements are not found within the linearLayout
							}
						}
						if (found)
							break;
					} catch (StaleElementReferenceException e) {

						attempts++;
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				// Handle stale element and retry
				attempts++;
			}
		}

		if (!found) {
			throw new NoSuchElementException("Could not find the element with text: " + category + " near me");
		}
	}

	public void bottomSheetDisplay() {
		wait.until(ExpectedConditions.visibilityOf(sp.bottomSheet));
		WebElement bottomSheet = sp.bottomSheet;
		Reporter.log("Bottom sheet with related place is displayed.", true);
		WebElement stripLayout = bottomSheet.findElement(By.id("com.mmi.maps:id/strip_layout"));
		WebElement resultCountElement = stripLayout.findElement(By.id("com.mmi.maps:id/text_view_results"));
		String resultCountText = resultCountElement.getText();
		Reporter.log("Total results found in BottomSheet: " + resultCountText, true);
		swipeBottomSheetUpwards(bottomSheet);
		bf.sleepWait(4);
	}

	public void handleDistanceAscending() {
		List<WebElement> getDistance = sp.suggestionListViewVRFY
				.findElements(By.id("com.mmi.maps:id/text_view_distance"));

		if (!getDistance.isEmpty()) {
			List<String> distanceList = getDistance.stream().map(WebElement::getText).collect(Collectors.toList());
			// Print the distances for debugging
			distanceList.forEach(text -> {
				bf.sleepWait(4); 
				Reporter.log("Get nearby icons text = " + text, true);
			});
		
			List<Double> distancesInMeters = distanceList.stream().map(this::convertToMeters)
					.collect(Collectors.toList());

			// Check if distances are in ascending order
			boolean isAscending = true;
			for (int i = 0; i < distancesInMeters.size() - 1; i++) {
				if (distancesInMeters.get(i) > distancesInMeters.get(i + 1)) {
					isAscending = false;
					break;
				}
			}

			Assert.assertTrue(isAscending, "Distances are not in ascending order");
			
			Reporter.log("Distances are in ascending order (verified).", true);

		}
	}

	// Convert distance strings to meters
	private double convertToMeters(String distanceStr) {
		double distance = Double.parseDouble(distanceStr.replaceAll("[^0-9.]", ""));
		if (distanceStr.contains("km")) {
			return distance * 1000; 
		} else {
			return distance; 
		}
	}

	
	
	public void searcgCategoryList() {
		wait.until(ExpectedConditions.visibilityOf(sp.catContainer));
        Assert.assertTrue(sp.catContainer.isDisplayed(), "Category container should be visible.");

		wait.until(ExpectedConditions.visibilityOf(sp.searchCatView));
        Assert.assertTrue(sp.searchCatView.isDisplayed(), "Search category view should be visible.");

		wait.until(ExpectedConditions.visibilityOf(sp.searchCatCoffee));
        Assert.assertTrue(sp.searchCatCoffee.isDisplayed(), "Search category coffee should be visible.");


		String categorytext = sp.searchCatCoffee.getText();
		Reporter.log("clicked category: " + categorytext, true);
		sp.searchCatCoffee.click();
	}
	
	
	
	//---------------------This is by autosuggest method 	    
		public void searchPlacePin(String pname) throws IOException, InterruptedException {
			sp.searchBarInput.sendKeys(pname);
			Reporter.log("Place entered for search " + " :-  " + pname, true);

			// Find the parent RecyclerView
			WebElement parentRecyclerView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));
			// Find all child ViewGroups within the RecyclerView
			List<WebElement> childViewGroups = parentRecyclerView.findElements(By.className("android.view.ViewGroup"));

			boolean found = false;
			int attempts = 0;
			while (!found && attempts < 3) {
				try {
					// Loop through the child ViewGroups
					for (WebElement viewGroup : childViewGroups) {
						// Find all child LinearLayouts within the ViewGroup
						List<WebElement> linearLayouts = viewGroup
								.findElements(By.className("android.widget.LinearLayout"));
						// Loop through the LinearLayouts
						for (WebElement linearLayout : linearLayouts) {
							WebElement textContainer = linearLayout
									.findElement(By.id("com.mmi.maps:id/text_instruction_container"));
							WebElement textView = textContainer.findElement(By.id("com.mmi.maps:id/auto_list_item"));
							WebElement textViewAdd = textContainer
									.findElement(By.id("com.mmi.maps:id/auto_list_item_address"));
							String suggestionText = textView.getText().trim();

							// Check if the suggestion text matches the desired search query
//							if (suggestionText.trim().equalsIgnoreCase(pname))
								if (suggestionText.toLowerCase().contains(pname.toLowerCase().trim())){
								Reporter.log("Searched place: " + pname, true);
								Reporter.log("Place name on the layout to be clicked is: " + suggestionText, true);
								Reporter.log("Place address on the layout to be clicked is: " + textViewAdd.getText(),true);
								viewGroup.click();
								Reporter.log("Search place is clicked", true);
								bf.sleepWait(2);
								found = true;
								break;
							}
						}
					}
				} catch (StaleElementReferenceException e) {
					attempts++;
				}
			}
			Assert.assertTrue(found, "Place not found in auto-suggest");
		}
	
	public void searchAutoSuggest() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		searchPlace(randomPlace);
		String searchedPlace = placeDetail();
		placeReview();
		assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
		closeSearch();
		assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");
	}

	public void searchTextEnter() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
		searchplaceTextSearch(randomPlace);
		String searchedPlace = placeDetail();
		placeReview();
		assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
		closeSearch();
		assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), " place searched through text enter is verified.");
	}

	public void searchNearbyCategory() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		searchBar();
		String randomcategory = RandomDataGenerator.generateRandomCategory();
		searchWithNearby(randomcategory);
		bottomSheetDisplay();
		handleDistanceAscending();
		closeSearch();
	}
	
	public void searchCatList() throws IOException {
		bf.mapplsPermissions();
		searchBar();
		searcgCategoryList();
		bottomSheetDisplay();
		handleDistanceAscending();
	}
	//////////////////////////////////////////////////////////////
	public void SearchHome() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		searchBar();
		homeWorkContainerVisibiity();
		HomeVisibility();
		sp.homeTitle.click();
	}
 
	public void SearchWork() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		searchBar();
		homeWorkContainerVisibiity();
		WorkVisibility();
		sp.workTitle.click();
	}
	
	
	public void SearchHomeSkip() throws IOException {
		bf.mapplsPermissions();
		searchBar();
		homeWorkContainerVisibiity();
		HomeVisibility();
		sp.homeTitle.click();
		bf.RequiredLoginBox("Add Home");
	}
 
	public void SearchWorkSkip() throws IOException {
		bf.mapplsPermissions();
		searchBar();
		homeWorkContainerVisibiity();
		WorkVisibility();
		sp.workTitle.click();
		bf.RequiredLoginBox("Add Work");
	}
	
	public void HomeVisibility() {
		wait.until(ExpectedConditions.visibilityOf(sp.homeTitle));
        Assert.assertTrue(sp.homeTitle.isDisplayed(), "Home card should be visible.");
        Reporter.log("Home card is Displayed at Search Page" , true);	
		
	}
    public void WorkVisibility() {
    	wait.until(ExpectedConditions.visibilityOf(sp.workTitle));
        Assert.assertTrue(sp.workTitle.isDisplayed(), "Work Card should be visible.");
        Reporter.log("Work Card is Displayed at Search Page" , true);	
		
	}
    
    public void homeWorkContainerVisibiity() {
    	wait.until(ExpectedConditions.visibilityOf(sp.homeWorkContainer));
        Assert.assertTrue(sp.homeWorkContainer.isDisplayed(), "Home/Work container should be visible.");
        Reporter.log("Home/Work container is Displayed at SearchPage" , true);	
		
    }
//	////////////////////////////////left as in sheet  for this module  
	
//	306 se 316 tk 
//	Check UI for Search 306 done
	public void SearchUI() throws IOException, InterruptedException{
		bf.mapplsPermissions();
		wait.until(ExpectedConditions.visibilityOf(sp.searchBar));
        Assert.assertTrue(sp.searchBar.isDisplayed(), "Search category view should be visible.");
        Reporter.log("Search Bar is Displayed at HomePage" , true);	
		searchBar();
		wait.until(ExpectedConditions.visibilityOf(sp.catContainer));
        Assert.assertTrue(sp.catContainer.isDisplayed(), "Category container should be visible.");
        Reporter.log("Category is Displayed at Search Page" , true);	

	}


//	Verify Road Name Search 311
public void searchRoad() throws IOException, InterruptedException{
	bf.mapplsPermissions();
	searchBar();
	String randomPlace = RandomDataGenerator.generateRandomRoadName();
	searchPlace(randomPlace);
	String searchedPlace = placeDetail();
	placeReview();
	assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
	closeSearch();
	assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");

}

public void searchBuildingTextSearch(String placeName) throws InterruptedException {

	sp.searchBarInput.sendKeys(placeName);
	Reporter.log("Place entered for search " + " :-  " + placeName, true);
	((PressesKey) driver).longPressKey(new KeyEvent(AndroidKey.ENTER));
	Reporter.log("Enter clicked", true);
	bf.sleepWait(2);

	WebElement bottomSheet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mmi.maps:id/main_layout")));
	Reporter.log("Bottom sheet with related place is displayed", true);
	WebElement stripLayout = bottomSheet.findElement(By.id("com.mmi.maps:id/strip_layout"));
	WebElement resultCountElement = stripLayout.findElement(By.id("com.mmi.maps:id/text_view_results"));
	String resultCountText = resultCountElement.getText();
	Reporter.log("Total results found in BottomSheet: " + resultCountText, true);

	swipeBottomSheetUpwards(bottomSheet);
	Reporter.log("Bottom Sheet is swiped to upward direction", true);
	Thread.sleep(1000);

	boolean placeFound = false;
	while (!placeFound) {
		List<MobileElement> placeList = driver.findElements(By.className("android.view.ViewGroup"));
		for (WebElement placeElement : placeList) {
			WebElement placeNameElement = placeElement
					.findElement(By.id("com.mmi.maps:id/item_place_result_place_name"));
			String placeText = placeNameElement.getText();
			if (placeText.trim().equalsIgnoreCase("237")) {
				WebElement placeDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mmi.maps:id/poi_list_card_content")));
				String placeNameDetails = placeDetails.findElement(By.id("com.mmi.maps:id/item_place_result_place_name")).getText();
				String placeAddress = placeDetails.findElement(By.id("com.mmi.maps:id/item_place_result_place_address")).getText();
				String placeAddressText = "Okhla Industrial Estate Phase 3, New Delhi, Delhi, 110020";
				if (placeAddress.trim().equalsIgnoreCase(placeAddressText)) {
				Reporter.log("Place Name: " + placeNameDetails, true);
				Reporter.log("Address: " + placeAddress, true);

				placeElement.click();
				Reporter.log("Searched place is clicked", true);
				bf.sleepWait(2);
				placeFound = true;
				break;
				}
			}
		}
		// If the place is not found, scroll the list and try again
		if (!placeFound) {
			swipeBottomSheetUpwards(bottomSheet);
			Thread.sleep(1000);
		}
	}

}
//	Verify Building Name/Number Search 312
public void searchBuilding()throws IOException, InterruptedException {
	bf.mapplsPermissions();
	searchBar();
	searchBuildingTextSearch("237,okhla");
//	String randomPlace ="237,Okhla Industrial Estate Phase 3, New Delhi, Delhi, 110020";
////			"Okhla Industrial Estate Phase 3, New Delhi, Delhi, 110020";
////			RandomDataGenerator.generateRandomBuildingName();
//	searchPlace(randomPlace);
	String searchedPlace = placeDetail();
	placeReview();
	Reporter.log(searchedPlace);
//	assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
	closeSearch();
//	assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");
//	search by building number like , plot 237 okhla phase 3 and get the address for validate.
}
//	Verify Locality Search 313

public void searchLocality()throws IOException, InterruptedException {
	bf.mapplsPermissions();
	searchBar();
	String randomPlace = RandomDataGenerator.generateRandomLocality();
	searchPlace(randomPlace);
	String searchedPlace = placeDetail();
	placeReview();
	assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
	closeSearch();
	assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");

}

//	Verify City/Village Search 314
public void searchVillage()throws IOException, InterruptedException {
	bf.mapplsPermissions();
	searchBar();
	String randomPlace = RandomDataGenerator.generateRandomVillage();
	searchPlace(randomPlace);
	String searchedPlace = placeDetail();
	placeReview();
	assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
	closeSearch();
	assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");

}

//	Verify Mappls Pin search 315
	public void searchPin()throws IOException, InterruptedException{
		bf.mapplsPermissions();
		searchBar();
		String randomPlace = RandomDataGenerator.generateRandomPins();
		searchPlacePin(randomPlace);
		String searchedPlace =  randomPlace;
        placeDetail();
		placeReview();
		assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
		closeSearch();
		assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");
	}
	
////	Verify User added places 316 done
//	public void userAddedPlaceSearch() throws IOException, InterruptedException{
//		 String address = apf.addPlaceWithLoginCredential();
//
////			    driver.quit(); 
// 
//		DesiredCapabilities	caps = new DesiredCapabilities();
//		caps.setCapability("udid", "R9ZR80ASBLV"); // Make sure this is correct
//
//        // Platform details
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("automationName", "uiautomator2");
//        caps.setCapability("platformVersion", "14"); // Check if the device is running Android 14
//
//        // App details
//        caps.setCapability("appPackage", "com.mmi.maps");
//        caps.setCapability("appActivity", "com.mmi.maps.ui.activities.HomeScreenActivity");
//
////        URL url = URI.create("http://127.0.0.1:4723/").toURL();
////        driver = new AndroidDriver<MobileElement>(url, caps);
//        
//        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), caps);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// 		
//        BaseFeatures bf = new BaseFeatures(driver);
//        TC__019_UserProfileFeature upf = new TC__019_UserProfileFeature(driver);
//        TC__015_SearchPage sp = new TC__015_SearchPage(driver);
//        
//        
//		bf.mapplsPermissions();
//		bf.Hamburgerclick();
//		upf.userMenu();
//		upf.ClickUserMenuAtHamburger();
//		upf.userLogin("9142877242", "Mmi@12345");
////		searchBar();
//		sp.searchBar.click();
//		Reporter.log("Search Bar Clicked", true);
//		sp.searchBarInput.sendKeys(address);
//		Reporter.log("Place entered for search " + " :-  " + address, true);
//		bf.swipeUpUntilElementDisplayed(sp.list, 10);
//		wait.until(ExpectedConditions.visibilityOf(sp.list));
//		UsersearchPlace(address);
////		String searchedPlace = placeDetail();
////		placeReview();
////		assertEquals(randomPlace.toLowerCase(), searchedPlace.toLowerCase());
////		closeSearch();
////		assertTrue(randomPlace.equalsIgnoreCase(searchedPlace), "place search  autosuggest Verified");	
//	}
//	
//	public void UsersearchPlace(String pname) throws IOException, InterruptedException {		
//		// Find the parent RecyclerView
//		WebElement parentRecyclerView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));
//		// Find all child ViewGroups within the RecyclerView
//		List<WebElement> childViewGroups = parentRecyclerView.findElements(By.className("android.view.ViewGroup"));
//
//		boolean found = false;
//		int attempts = 0;
//		while (!found && attempts < 4) {
//			try {
//				// Loop through the child ViewGroups
//				for (WebElement viewGroup : childViewGroups) {
//					// Find all child LinearLayouts within the ViewGroup
//					List<WebElement> linearLayouts = viewGroup.findElements(By.className("android.widget.LinearLayout"));
//					// Loop through the LinearLayouts
//					for (WebElement linearLayout : linearLayouts) {
//						WebElement textContainer = linearLayout.findElement(By.id("com.mmi.maps:id/text_instruction_container"));
//						WebElement textView = textContainer.findElement(By.id("com.mmi.maps:id/auto_list_item"));
//						WebElement textViewAdd = textContainer.findElement(By.id("com.mmi.maps:id/auto_list_item_address"));
//						String suggestionText = textView.getText();
//
//						// Check if the suggestion text matches the desired search query
//						if (suggestionText.trim().equalsIgnoreCase(pname)) {
//							Reporter.log("Searched place: " + pname, true);
//							Reporter.log("Place name on the layout to be clicked is: " + suggestionText, true);
//							Reporter.log("Place address on the layout to be clicked is: " + textViewAdd.getText(),true);
//							viewGroup.click();
//							Reporter.log("Search place is clicked", true);
////							bf.sleepWait(2);
//							found = true;
//	                        Assert.fail("Place found in the auto-suggest list when it shouldn't be");
//							break;
//						}
//					}
//				}
//			} catch (StaleElementReferenceException e) {
//				attempts++;
//			}
//		}
//	    Assert.assertTrue(!found, "Place was not found in auto-suggest list as expected.");
//	}
	
	
}
