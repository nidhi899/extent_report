package com.mappls.map.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__002_LoginPage;
import com.mappls.map.pages.TC__023WhatAndWherePage;
import com.mappls.map.utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__023WhatAndWhereFeature {
	
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__002_LoginPage lp;
	TC__023WhatAndWherePage wwp;
	Actions ac;

	public TC__023WhatAndWhereFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		lp = new TC__002_LoginPage(driver);
		wwp = new TC__023WhatAndWherePage(driver);
	    ac = new Actions();
	}
	
	
	
	
	//tc 1
	public void newarByUI() {
		bf.mapplsPermissions();
		Assert.assertTrue(wwp.nearByIcon.isDisplayed(), "Failed to display near by icon on search page");
		Reporter.log("near by icon present in the search page ", true);
		
		Assert.assertEquals(wwp.searchInputVisibility.getText(), "Search for places & Mappls Pin");
		Reporter.log("Search for places & Mappls Pin is visible", true);
		
		wwp.nearByIcon.click();
		bf.back();
		
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("Search Near page is available", true);
		
		Assert.assertTrue(wwp.searchNearPagePencilIcon.isDisplayed(),"Pencil Icon not available");
        Reporter.log("pencil icon is available on search near page", true);		

        Assert.assertEquals(wwp.searchBarTxt.getText(), "Search what are you in mood for?");
		Reporter.log("'Search what are you in mood for?' is appear in the search bar", true);
		
        
//        category list
        String[] expectedValues = {
                "Coffee",
                "Restaurant",
                "Pubs & Bars",
                "ATMs",
                "Pharmacy",
                "Parking",
                "EV Charging",
                "Petrol Pump",
                "Transport",
                "Entertainment",
                "Hotels",
                "Shopping",
                "Groceries",
                "Hospitals",
                "Police Stations",
                "Post Offices",
                "Banks",
                "Spas",
                "Toilets",
                "CNG Station",
                "Less"
            };
        for (WebElement element : wwp.catListTxt) {
        	String elementText = element.getText().trim(); 
        	boolean matchFound = false; 

        	for (String expectedValue : expectedValues) {
        		try {
        			Assert.assertTrue(elementText.equalsIgnoreCase(expectedValue),"Expected value '" + expectedValue + "' not found in element: " + elementText);

        			Reporter.log(expectedValue + " is present in the list.", true);
        			matchFound = true;
        			break;  
        		} catch (AssertionError e) {
        			continue;
        		}
        	}

        	if (!matchFound) {
        		throw new AssertionError("No expected value matched for element: '" + elementText+ "'. Expected one of: " + String.join(", ", expectedValues));
        	}
        }
	
		
		
	}
	
	//tc 2-3
	public void isNearByIconClickable() {
		bf.mapplsPermissions();
		nearByClick();
		
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("Search Near page is available", true);
		
		
	}
	
	
	

	
	
	//tc - 4
	public void isNearBySearchUIWorking() {
		bf.mapplsPermissions();
		nearByClick();
		
		wwp.searchNearPageBackBtn.click();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to back button clicked");
		Reporter.log("back button working properly", true);
		
		nearByClick();
		
		bf.visibilitys(wwp.isCrrntLocationAddrss);
		Assert.assertTrue(wwp.isCrrntLocationAddrss.isDisplayed(), "Failed to display current location");
		Reporter.log("current location is available : "+ wwp.isCrrntLocationAddrss.getText(), true);

		Assert.assertTrue(wwp.searchNearPagePencilIcon.isDisplayed(),"Pencil Icon not available");
        Reporter.log("pencil icon is available on search near page", true);		
		
	}
	
	public void isPencilIconClickable() {
		bf.mapplsPermissions();
		nearByClick();
		
		
		
		bf.visibilitys(wwp.isCrrntLocationAddrss);
		Assert.assertTrue(wwp.isCrrntLocationAddrss.isDisplayed(), "Failed to display current location");
		Reporter.log("current location is available : "+ wwp.isCrrntLocationAddrss.getText(), true);

		wwp.searchNearPagePencilIcon.click();
		
		Assert.assertEquals(wwp.searchNearPagePencilEdit.getText(),"Search");
		Reporter.log("pencil icon clickable and redirected to the next page", true);
		
		
		Assert.assertEquals(wwp.suggetionCrrntLocation.getText(),"Your current location");
		Reporter.log("'Your current location' option as a suggestion list present", true);
		
		
		Assert.assertEquals(wwp.suggestionChooseMap.getText(),"Choose On Map");
		Reporter.log("'Choose on Map' option as a suggestion list present", true);
		
		wwp.suggestionChooseMap.click();
		
		bf.visibilitys(wwp.aftrChooseMapPOMHeaderTxt);
		Assert.assertEquals(wwp.aftrChooseMapPOMHeaderTxt.getText(),"Point On Map");
		Reporter.log("Point on map page redirected", true);
		bf.visibilitys(wwp.pomAddrssTxt);
		wwp.pomDoneBtn.click();
		
		
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("point on map done button clicked and redirected to the search near page", true);
		
		
		//again click to the pencil icon for current location selection
		wwp.searchNearPagePencilIcon.click();
		Assert.assertEquals(wwp.searchNearPagePencilEdit.getText(),"Search");
		Reporter.log("pencil icon clickable and redirected to the next page", true);
		
		
		wwp.suggetionCrrntLocation.click();
		
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("current location selected successfuly", true);
		
		
		
	}
	
	//tc-6
	public void isWhtAreYouMoodClickable() {
		bf.mapplsPermissions();
		nearByClick();
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("search near page redirected", true);
		
		Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
		Reporter.log("Search what are you in mood for? text is available inside the input search", true);
		
		bf.visibilitys(wwp.searchNearPagePencilIcon);
		
		wwp.whatMoodForSearchOption.click();
		
//		wwp.whatMoodForSearchOption.sendKeys("coffee");
		
		
		
		  String plc = RandomDataGenerator.generateRandomPlace();
	       
	        wwp.searchInput.sendKeys(plc);

	        ac = new Actions();
	             bf.back();

	        List<WebElement> getDistance = wwp.sListViewSearchInput.findElements(By.id("com.mmi.maps:id/text_view_distance"));

	        System.out.println("my distance size ---  "+ getDistance.size());
	        if (!getDistance.isEmpty()) {
	            String[] distanceArray = new String[getDistance.size()]; 

	            for (int i = 0; i < getDistance.size(); i++) {
	                WebElement nearByDistance = getDistance.get(i);
	                bf.sleepWait(4);
	                String text = nearByDistance.getText();
	                bf.sleepWait(4);
	                System.out.println("get near by icons text =  " + text);
	                distanceArray[i] = text;
	            }
	            boolean isAscending = true;
	            for (int i = 0; i < distanceArray.length - 1; i++) {
	                if (distanceArray[i].compareTo(distanceArray[i + 1]) >= 0) {
	                    isAscending = false;
	                    break;
	                }
	            }
	            if (isAscending) {
	                System.out.println("Test Case Passed : Distances are in ascending order (verified).");
	            } else {
	                System.out.println("Distances are not in ascending order.");
	            }

	            Assert.assertTrue(isAscending, "Failed, Distances are not in ascending order.");
	        }
		
	}
	
	public void isSuggstAddrssClickable() {
		bf.mapplsPermissions();
		nearByClick();
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("search near page redirected", true);

		Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
		Reporter.log("Search what are you in mood for? text is available inside the input search", true);

		bf.visibilitys(wwp.searchNearPagePencilIcon);
		bf.back();



		//			Random random = new Random();
		//
		//			// Get a random index from the list of elements
		//			int randomIndex = random.nextInt(wwp.catNameTxt.size()); 
		//
		//			// Get the random WebElement using the random index
		//			WebElement randomElement = wwp.catNameTxt.get(randomIndex);
		//
		//			// Log the text of the random element
		//			Reporter.log(randomElement.getText(), true);
		//
		//			// Click on the random element
		//			randomElement.click();
		//			
		//			Assert.assertTrue(wwp.bttmSheetResult.isDisplayed(),"Failed to clicked category");
		//			Reporter.log("swipe up to view all lists", true);
		//			
		//			bf.scrollUp(1);
		//			
		//			Assert.assertTrue(!wwp.rsltPlcLists.isEmpty(),"Failed to view place list");
		//			for(WebElement plcLists: wwp.rsltPlcLists) {
		//				Reporter.log("-" + plcLists.getText(), true);
		//				
		//			}


		String[] expectedValues = {
				"Coffee",
				"Restaurant",
				"Pubs & Bars",
				"ATMs",
				"Pharmacy",
				"Parking",
				"EV Charging",
				"Petrol Pump",
				"Transport",
				"Entertainment",
				"Hotels",
				"Shopping",
				"Groceries",
				"Hospitals",
				"Police Stations",
				"Post Offices",
				"Banks",
				"Spas",
				"Toilets",
				"CNG Station",
				"Less"
		};

		for (int i = 0; i < wwp.catListTxt.size(); i++) {
			WebElement element = wwp.catListTxt.get(i); // Get the current element
			String elementText = element.getText().trim();

			// Skip "Less"
			if (elementText.equalsIgnoreCase("Less")) {
				Reporter.log("Skipping 'Less' category.", true);
				continue;
			}

			element.click();
			Reporter.log("Clicked on category: " + elementText, true);

			// Get and verify the header text
			String headerText = wwp.catClickHeaderTxt.getText().trim(); // Replace 'wwp.headerTextElement' with the correct locator for the header
			Assert.assertEquals(headerText, elementText+ " near", "Header text mismatch: Expected: " + elementText + ", but got: " + headerText);
			Reporter.log("Verified header text: " + headerText, true);

			// Navigate back
			wwp.catClickBackIcon.click();
			bf.visibilitys(wwp.nearByIcon); 
			wwp.nearByIcon.click();

			// Navigate back to the list again
			bf.back();
		}
	}


		
	
	
	//tc-8
	public void placeDetailPage() {
		bf.mapplsPermissions();
		nearByClick();
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("search near page redirected", true);
		
		Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
		Reporter.log("Search what are you in mood for? text is available inside the input search", true);
		
		bf.visibilitys(wwp.searchNearPagePencilIcon);
		bf.back();

	
			
			Random random = new Random();

			// Get a random index from the list of elements
			int randomIndex = random.nextInt(wwp.catNameTxt.size()); 

			// Get the random WebElement using the random index
			WebElement randomElement = wwp.catNameTxt.get(randomIndex);

			// Log the text of the random element
			Reporter.log(randomElement.getText(), true);

			// Click on the random element
			randomElement.click();
			
			Assert.assertTrue(wwp.bttmSheetResult.isDisplayed(),"Failed to clicked category");
			Reporter.log("swipe up to view all lists", true);
			
			bf.scrollUp(1);
			
			Assert.assertTrue(!wwp.rsltPlcLists.isEmpty(),"Failed to view place list");
			for(WebElement plcLists: wwp.rsltPlcLists) {
				Reporter.log("-" + plcLists.getText(), true);
				
			}
			
			int catIndex = random.nextInt(wwp.rsltPlcLists.size());
			
			WebElement rmElement = wwp.rsltPlcLists.get(catIndex);
			
			Reporter.log(rmElement.getText(), true);
			rmElement.click();
			
			bf.sleepWait(4);
			Assert.assertEquals(wwp.drctnBtnTxt.getText(), "Directions");
			Reporter.log("Direction page redirected", true);
			bf.scrollUp(1);
			
			Assert.assertTrue(wwp.plcDetailPage.isDisplayed(),"Failed to redirected place detail page");
			Reporter.log("place detail page redirected", true);
			
	}
	
	//tc-9
	public void evCharging() {
		bf.mapplsPermissions();
		nearByClick();
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("search near page redirected", true);
		
		Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
		Reporter.log("Search what are you in mood for? text is available inside the input search", true);
		
		bf.visibilitys(wwp.searchNearPagePencilIcon);
		bf.back();
		
		for (WebElement element : wwp.catNameTxt) {
		    Reporter.log(element.getText(), true);
		    if (element.getText().equals("EV Charging")) {
		        element.click();
		        break; 
		    }
		}
		Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
		Reporter.log("'EV Charging' page redirected", true);
		
		bf.scrollUp(1);
		
		wwp.evChrgingPageFilter.click();
		
		Assert.assertTrue(wwp.evChrgingPageResetFilter.isDisplayed(),"Failed");
		Reporter.log("filter page open", true);
	
		for (WebElement element : wwp.elctrcChrgngPlgClick) {
		    // Log the text of each element
		    Reporter.log(element.getText(), true);
		    
		    // Click on the current element
		    element.click();
		}
		
//		wwp.applyBtn.click();
//
//		Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
//		Reporter.log("'EV Charging' page redirected", true);
//		
//		Reporter.log("applied result total size : "+wwp.appliedRstList.size(), true);
//		
	}
	
	public void evFilterReset() {
		bf.mapplsPermissions();
		nearByClick();
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("search near page redirected", true);
		
		Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
		Reporter.log("Search what are you in mood for? text is available inside the input search", true);
		
		bf.visibilitys(wwp.searchNearPagePencilIcon);
		bf.back();
		
		for (WebElement element : wwp.catNameTxt) {
		    Reporter.log(element.getText(), true);
		    if (element.getText().equals("EV Charging")) {
		        element.click();
		        break; 
		    }
		}
		Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
		Reporter.log("'EV Charging' page redirected", true);
		bf.scrollUp(1);
		wwp.evChrgingPageFilter.click();
//		==========================
		
		List<String> idsBeforeReset = new ArrayList<>();
		for (WebElement element : wwp.elctrcChrgngPlgClick) {
			element.click();
		}
		for (WebElement element : wwp.elctrcChrgngPlgClick) {
			MobileElement mobileElement = (MobileElement) element; // Cast to MobileElement
			String elementId = mobileElement.getId();
			idsBeforeReset.add(elementId);
			Reporter.log("Element ID before reset: " + elementId, true);
		}

		Reporter.log("Clicking the reset button.", true);
		wwp.resetBtn.click();
		bf.sleepWait(5);

		List<String> idsAfterReset = new ArrayList<>();
		for (WebElement element : wwp.elctrcChrgngPlgClick) {
			MobileElement mobileElement = (MobileElement) element;
			String elementId = mobileElement.getId();
			idsAfterReset.add(elementId);
			Reporter.log("Element ID after reset: " + elementId, true);
		}

		for (String idBefore : idsBeforeReset) {
			if (idsAfterReset.contains(idBefore)) {
				Reporter.log("Matching element ID found after reset: " + idBefore, true);
				Assert.fail("Element ID " + idBefore + " should not match after reset.");
			}
		}
		Reporter.log("All element IDs are unique after reset button clicked.", true);

		
		
	}
	
	 private int rsltCountAftrAply; // Holds the latest result count

	 private int rsltCountBforAply;
	 // Reusable method to fetch and parse the result count
	 private int getResultCount() {
		 String afterApply = wwp.evRsltCount.getText();  // Fetch the text
		 String[] partsAfter = afterApply.split(" ");    // Split the string
		 int count = Integer.parseInt(partsAfter[0]);    // Parse the count
//		 System.out.println("Current result count: " + count);
		 return count;
	 }
	 
		private String getElementIdClick(WebElement elementToClick, String msg) {
			MobileElement mobileElement = (MobileElement) elementToClick;
			String elementId = mobileElement.getId();
			Reporter.log(msg + " category id is : " + elementId, true);
			return elementId;
		}
		
		private String getElementIdOnly(WebElement elementToClick) {
			MobileElement mobileElement = (MobileElement) elementToClick;
			String elementId = mobileElement.getId();
			return elementId;
		}
		
		private void evChargingFilterClick() {
			wwp.evChrgingPageFilter.click();
		}

		public void applyAnyOneFilter() {
			bf.mapplsPermissions();
			nearByClick();
			Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
			Reporter.log("search near page redirected", true);
			
			Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
			Reporter.log("Search what are you in mood for? text is available inside the input search", true);
			
			bf.visibilitys(wwp.searchNearPagePencilIcon);
			 
			bf.back();
			for (WebElement element : wwp.catNameTxt) {
			    Reporter.log(element.getText(), true);
			    if (element.getText().equals("EV Charging")) {
			        element.click();
			        break; 
			    }
			}
			Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
			Reporter.log("'EV Charging' page redirected", true);
			
			bf.scrollUp(1);
			rsltCountBforAply = getResultCount(); 
			System.out.println("Before apply count result: " + rsltCountBforAply);
			
			evChargingFilterClick();
			
			Assert.assertTrue(wwp.evChrgingPageResetFilter.isDisplayed(),"Failed");
			Reporter.log("filter page open", true);
		
			//========================
			
			wwp.elctrcChrgngPlgClick.get(1).click();
			
			wwp.applyBtn.click();
			rsltCountAftrAply = getResultCount();
			Reporter.log("after click apply button get total result count : " + rsltCountAftrAply, true);
			
			
		}
		
		public void applyAnyOneFilterAndReset() {
			bf.mapplsPermissions();
			nearByClick();
			Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
			Reporter.log("search near page redirected", true);
			
			Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
			Reporter.log("Search what are you in mood for? text is available inside the input search", true);
			
			bf.visibilitys(wwp.searchNearPagePencilIcon);
			 
			bf.back();
			for (WebElement element : wwp.catNameTxt) {
			    Reporter.log(element.getText(), true);
			    if (element.getText().equals("EV Charging")) {
			        element.click();
			        break; 
			    }
			}
			Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
			Reporter.log("'EV Charging' page redirected", true);
			
			bf.scrollUp(1);
			rsltCountBforAply = getResultCount(); 
			System.out.println("Before apply count result: " + rsltCountBforAply);
			
			evChargingFilterClick();
			
			Assert.assertTrue(wwp.evChrgingPageResetFilter.isDisplayed(),"Failed");
			Reporter.log("filter page open", true);
		
			//========================
			
			wwp.elctrcChrgngPlgClick.get(1).click();
			
			wwp.applyBtn.click();
			rsltCountAftrAply = getResultCount();
			Reporter.log("after click apply button get total result count : " + rsltCountAftrAply, true);
			
			//again click filter
			evChargingFilterClick();
			wwp.evChrgingPageResetFilter.click(); //click reset button
			wwp.applyBtn.click(); //click apply button
			
			rsltCountAftrAply = getResultCount(); //after reset get total count

			Assert.assertEquals(rsltCountAftrAply,rsltCountBforAply);
			Reporter.log("count matched", true);
			
			
		}
		
	 //new
	public void evChargingApplyBtn() {
		bf.mapplsPermissions();
		nearByClick();
		Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
		Reporter.log("search near page redirected", true);
		
		Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
		Reporter.log("Search what are you in mood for? text is available inside the input search", true);
		
		bf.visibilitys(wwp.searchNearPagePencilIcon);
		 
		bf.back();
		for (WebElement element : wwp.catNameTxt) {
		    Reporter.log(element.getText(), true);
		    if (element.getText().equals("EV Charging")) {
		        element.click();
		        break; 
		    }
		}
		Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
		Reporter.log("'EV Charging' page redirected", true);
		
		bf.scrollUp(1);
		rsltCountAftrAply = getResultCount(); 
		System.out.println("Before apply count: " + rsltCountAftrAply);

		
		wwp.evChrgingPageFilter.click();
		
		Assert.assertTrue(wwp.evChrgingPageResetFilter.isDisplayed(),"Failed");
		Reporter.log("filter page open", true);
	
		//========================
		getElementIdClick(wwp.elctrcChrgngPlgClick.get(1), "unselected");
		
		wwp.elctrcChrgngPlgClick.get(1).click();
		String expectedId = getElementIdOnly(wwp.elctrcChrgngPlgClick.get(1));
		getElementIdClick(wwp.elctrcChrgngPlgClick.get(1), "selected");
		
		
		wwp.applyBtn.click();

		Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
		Reporter.log("'EV Charging' page redirected after clicked apply button", true);
	    
		
		rsltCountAftrAply = getResultCount();
        Reporter.log("After clicked apply button total result is: " + rsltCountAftrAply, true);
	    
		wwp.evChrgingPageFilter.click();
		
		String elementID = getElementIdOnly(wwp.elctrcChrgngPlgClick.get(1));
		Assert.assertEquals(elementID, expectedId, "Filter is not selected by default. ");
		Reporter.log("Filter is selected by defualt", true);
//		wwp.applyBtn.click();
		
		
		Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
		Reporter.log("'EV Charging' page redirected", true);
	}
	
	
	//new
	public void chooseMapBackFunctionality() {
		bf.mapplsPermissions();
		nearByClick();
		bf.visibilitys(wwp.isCrrntLocationAddrss);
		wwp.searchNearPagePencilIcon.click();
		wwp.suggestionChooseMap.click();
		bf.visibilitys(wwp.pomAddrssTxt);
		
		wwp.pomBackBtn.click();
		
		Assert.assertEquals(wwp.searchNearPagePencilEdit.getText(),"Search");
		Reporter.log("point on map page back button working properly", true);
		
	}
	
//	public void searchNearPageUI() {
//	bf.mapplsPermissions();
//	nearByClick();
//	
//	Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
//	Reporter.log("Search Near page is available", true);
//	
//	
//	Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
//	Reporter.log("Search Near page is available", true);
//	
//	
//	
//	Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
//	Reporter.log("Search Near page is available", true);
//	
//	
//	
//	Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
//	Reporter.log("Search Near page is available", true);
//	
//	
//	
//	Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
//	Reporter.log("Search Near page is available", true);
//	
//}
	
//	=====================================
	
	
	 public void nearByClick() {
	        wwp.nearByIcon.click();    
	        Reporter.log("Near By Search clicked",true);    
	        bf.sleepWait(3);
	    }


	    public void getNearBySearch() {
	        bf.mapplsPermissions();
	        nearByClick();
	        
	        bf.sleepWait(3);
	        List<WebElement> suggestionItems = wwp.suggestionListView.findElements(By.className("android.widget.LinearLayout"));
	        List<WebElement> getAddressText = wwp.suggestionListView.findElements(By.id("com.mmi.maps:id/cat_name_textview"));

	        if (!suggestionItems.isEmpty()) {
	            if (wwp.moreBtn.isDisplayed()) {
	                wwp.moreBtn.click();
	                System.out.println("Clicked on more button to expand suggestions.");
	            }
	            Random random = new Random();
	            int randomIndex = random.nextInt(getAddressText.size());
	            System.out.println("Clicked on a nearby suggestion index number = "+randomIndex);
	        } else {
	            System.out.println("No nearby suggestions found.");
	        }

	    }



	    public void verifyNearBy() {
	        bf.sleepWait(3);
	        List<WebElement> getDistance = wwp.suggestionListViewVRFY.findElements(By.id("com.mmi.maps:id/text_view_distance"));
	if (!getDistance.isEmpty()) {
	            String[] distanceArray = new String[getDistance.size()]; 

	            for (int i = 0; i < getDistance.size(); i++) {
	                WebElement nearByDistance = getDistance.get(i);
	                bf.sleepWait(4);
	                String text = nearByDistance.getText();
	                bf.sleepWait(4);
	                System.out.println("get near by icons text =  " + text);
	                distanceArray[i] = text;
	            }
	            boolean isAscending = true;
	            for (int i = 0; i < distanceArray.length - 1; i++) {
	                if (distanceArray[i].compareTo(distanceArray[i + 1]) >= 0) {
	                    isAscending = false;
	                    break;
	                }
	            }
	            if (isAscending) {
	                System.out.println("Distances are in ascending order (verified).");
	            } else {
	                System.out.println("Distances are not in ascending order.");
	            }
	            Assert.assertTrue(isAscending, "Failed, Distances are not in ascending order.");
	        }
	    }


	    //    /====================================================add more



	    public void searchNearbyByEnteredPlace () {
	        bf.mapplsPermissions();
	        nearByClick();
	        
	        String plc = RandomDataGenerator.generateRandomPlace();
	       
	        wwp.searchInput.sendKeys(plc);

	        ac = new Actions();
	             bf.back();

	        List<WebElement> getDistance = wwp.sListViewSearchInput.findElements(By.id("com.mmi.maps:id/text_view_distance"));

	        System.out.println("my distance size ---  "+ getDistance.size());
	        if (!getDistance.isEmpty()) {
	            String[] distanceArray = new String[getDistance.size()]; 

	            for (int i = 0; i < getDistance.size(); i++) {
	                WebElement nearByDistance = getDistance.get(i);
	                bf.sleepWait(4);
	                String text = nearByDistance.getText();
	                bf.sleepWait(4);
	                System.out.println("get near by icons text =  " + text);
	                distanceArray[i] = text;
	            }
	            boolean isAscending = true;
	            for (int i = 0; i < distanceArray.length - 1; i++) {
	                if (distanceArray[i].compareTo(distanceArray[i + 1]) >= 0) {
	                    isAscending = false;
	                    break;
	                }
	            }
	            if (isAscending) {
	                System.out.println("Test Case Passed : Distances are in ascending order (verified).");
	            } else {
	                System.out.println("Distances are not in ascending order.");
	            }

	            Assert.assertTrue(isAscending, "Failed, Distances are not in ascending order.");
	        }
	    }
	    
	    
	    
	    
	    //new 
	    public void applyBtnWihOutFilter() {
			bf.mapplsPermissions();
			nearByClick();
			Assert.assertEquals(wwp.searchNearPage.getText(), "Search Near");
			Reporter.log("search near page redirected", true);
			
			Assert.assertEquals(wwp.whatMoodForSearchOption.getText(), "Search what are you in mood for?");
			Reporter.log("Search what are you in mood for? text is available inside the input search", true);
			
			bf.visibilitys(wwp.searchNearPagePencilIcon);
			 
			bf.back();
			for (WebElement element : wwp.catNameTxt) {
			    Reporter.log(element.getText(), true);
			    if (element.getText().equals("EV Charging")) {
			        element.click();
			        break; 
			    }
			}
			Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
			Reporter.log("'EV Charging' page redirected", true);
			
			bf.scrollUp(1);
			rsltCountBforAply = getResultCount(); 
			System.out.println("Before apply count result: " + rsltCountBforAply);

			
			wwp.evChrgingPageFilter.click();
			
			Assert.assertTrue(wwp.evChrgingPageResetFilter.isDisplayed(),"Failed");
			Reporter.log("filter page open", true);
		
			Reporter.log("Clicked the apply button without selecting any filter", true);
			wwp.applyBtn.click();

			Assert.assertEquals(wwp.evChrgingPage.getText(), "EV Charging near");
			Reporter.log("'EV Charging' page redirected after clicked apply button", true);
		    
			rsltCountAftrAply = getResultCount();
	        Reporter.log("After clicked apply button total result is: " + rsltCountAftrAply, true);
		    
			Assert.assertEquals(rsltCountAftrAply, rsltCountBforAply,"The result count has changed after clicking the apply button without selecting any filter");
		    Reporter.log("Verified that the result count remains unchanged after clicking the apply button without selecting any filter.", true);
	    
	    }

}
