package com.mappls.map.features;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__008_MySavesPage;
import com.mappls.map.utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__008_MySavesFeature {	
	
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__008_MySavesPage mp;
	TC__012_QuickAccessMenuFeature qcf;
	Actions ac;
	
	private String plc = RandomDataGenerator.generateRandomDistrictInJharkhand();
	
	public TC__008_MySavesFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
        qcf =  new TC__012_QuickAccessMenuFeature(driver);
        mp = new TC__008_MySavesPage(driver);
        ac = new Actions();
	}
	
	
//	Verify that UI is proper in My Saves	
//	UI for all screen should be properly visible and 
//	function should work properly
	//TC-1
	public void mySavesWithOutLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		
		Assert.assertEquals(mp.mySavesHambrgrMenu.getText(), "My Saves");
		Reporter.log("My saves is present in hamburger menu", true);
		mySavesClick();
		bf.mapplsLogin("7870194441", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();
		
		Assert.assertEquals(mp.msHeader.getText(), "My Saves");
		Reporter.log("header 'my-saves' present", true);
		
		Assert.assertEquals(mp.msCreateListTxt.getText(), "CREATE LIST");
		Reporter.log("Custom list create button present", true);
		
		String[] expectedValues = {"Home", "Work", "Contributions", "Favourites", "My Routes" , "Point on Map"};
		for (WebElement element : mp.msList) {
			String elementText = element.getText().trim(); 
			boolean matchFound = false; 

			for (String expectedValue : expectedValues) {
				try {
					Assert.assertTrue(elementText.equalsIgnoreCase(expectedValue), 
							"Expected value '" + expectedValue + "' not found in element: " + elementText);

					Reporter.log(expectedValue + " is present in the list.", true);
					matchFound = true;
					break;  
				} catch (AssertionError e) {
					continue;
				}
			}

			if (!matchFound) {
				throw new AssertionError("No expected value matched for element: '" + elementText 
						+ "'. Expected one of: " + String.join(", ", expectedValues));
			}
        }
		
		
	}

	
//	Verify that My Saves is clickable (without login)
//	User is asked to Login to access this functionality. with cancel and login buttons available.
//	1. On clicking Cancel it should takes back to previous page.
//	2. On clicking Login, should take to the welcome page for login
	public void loginAndCancel() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		mySavesClick();
		Assert.assertTrue(mp.msCancel.isDisplayed(), "Failed");
		Reporter.log("cancel button is visible", true);
		
		
		mp.msCancel.click();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed");
		Reporter.log("cancel button clicked", true);
		
		bf.Hamburgerclick();
		mySavesClick();
		bf.loginBTNMsg();
		
		Assert.assertEquals(bp.headerTitle.getText(), "Welcome");
		Reporter.log("Welcome text is visible", true);
		
	}
	
//	TC - 3
//	Verify that the user is able to open My Saves (If User is Logged-in)
//	1.My Saves should be clickable and open new page with 
//	 -Heading(My Saves), back button, + icon
//	 -Home, Work, Contributions, Favourites, My Routes, Point On Map.(with icons)
//	 -CREATE LIST (on top-right corner)
//	 -Custom List (If available) with public & private options	
	public void msUIVerificationWL() {
		bf.mapplsPermissions();
		
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("7870194441", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();		
		mySavesClick();
		
		String header = mp.msHeader.getText();
		Reporter.log("My saves header visible :- " + header, true);
		
		
		//back button icon 
		Assert.assertTrue(mp.backBtnIcon.isDisplayed(), "Failed");
		Reporter.log("Back button is visible in my saves page", true);
		
		// -Home, Work, Contributions, Favourites, My Routes, Point On Map.(with icons)
		String[] expectedValues = {"Home", "Work", "Contributions", "Favourites", "My Routes" , "Point on Map"};
		for (WebElement element : mp.msList) {
			String elementText = element.getText().trim(); 
			boolean matchFound = false; 

			for (String expectedValue : expectedValues) {
				try {
					Assert.assertTrue(elementText.equalsIgnoreCase(expectedValue), 
							"Expected value '" + expectedValue + "' not found in element: " + elementText);

					Reporter.log(expectedValue + " is present in the list.", true);
					matchFound = true;
					break;  
				} catch (AssertionError e) {
					continue;
				}
			}

			if (!matchFound) {
				throw new AssertionError("No expected value matched for element: '" + elementText 
						+ "'. Expected one of: " + String.join(", ", expectedValues));
			}
        }

		
		//create list 
		Assert.assertTrue(mp.createListBTN.isDisplayed(), "Failed");
		Reporter.log("create list present", true);
		
		//custom list
		mp.createListBTN.click();
		mp.dropDownClick.click();
		Assert.assertTrue(mp.isPublicDisplay.isDisplayed() & mp.isPrivateDisplay.isDisplayed(), "Failed");
		Reporter.log("custom list present in my saves", true);
		
	}
	
//	TC - 5
//	Verify saving a place to a list from its place details
//	Place should get saved in the list
	public void placeDetailSaveAddressWL() {
	System.out.println(plc);
		bf.mapplsPermissions();
		
		
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.homeSearchClick();
//		String plc = RandomDataGenerator.generateRandomDistrictInJharkhand();
		bf.homeSearchInputClick(plc);
		bf.clickOnMatchedPlace(plc);
		
		bf.swipeUpUntilElementDisplayed(mp.plcDetailMySave, 4);
		
		mp.plcDetailMySave.click();
		
		Assert.assertEquals(mp.createListFrmPlcDetail.getText(), "Create New List");
		Reporter.log("create list button present in the place detail page", true);
		
		mp.createListFrmPlcDetail.click();
		
		Assert.assertEquals(mp.listHeader.getText(), "Create New List");
		Reporter.log("'Create New List' is present in the place detail page", true);
		
		String testName = RandomDataGenerator.generateRandomTestName1();
		
		mp.enterTitle.sendKeys(testName);
		mp.dropDownClick.click();
		mp.privately.click(); 
		mp.okBTN.click();
		bf.sleepWait(3);
		String Actual = mp.listCreatingError.getText();
        String Expected = "List created successfully";
        
        Assert.assertEquals(Actual.toLowerCase(), Expected.toLowerCase(),"Unable to create list");
        Reporter.log("place saved from place detail page", true);
        
//        if(mp.favDismissBtn.isDisplayed()) {
        bf.swipeUpUntilElementDisplayed(mp.favDismissBtn, 2);
        Assert.assertEquals(mp.favDismissBtn.getText(), "DISMISS");
        Reporter.log("Click dismiss button", true);
        

		List<String> allListTexts = new ArrayList<>();
		boolean matchFound = false;
		for (WebElement customList : mp.cstmListInPlcDetailPage) {
			String listText = customList.getText();
			allListTexts.add(listText);

			if (listText.equals(testName)) {
				System.out.println("Matching text found: " + listText);
				matchFound = true;
			}
		}

		Assert.assertTrue(matchFound, "No matching text found in the list.");

        bf.back();
        
        Assert.assertEquals(mp.isDirectionBtn.getText(), "Directions");
        Reporter.log("direction page redirected", true);
        
        mp.directionBackClick.click();
        
       mp.dirctnBottmSheetBackClick.click();
       
       Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to redirected to the home page");
       bf.Hamburgerclick();
       mySavesClick();
       
//       mp.mySavesListText.get(2).click();
       
//       WebElement createdList =  driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.mmi.maps:id/my_saves_text_view\" and @text=\"  "+ testName +"\"]"));
		
      
       WebElement createdList = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.mmi.maps:id/my_saves_text_view' and @text='" + testName + "']"));

       
       bf.swipeUpUntilElementDisplayed(createdList, 5);
        
     
	}
	
	
	
	
	
	
	
	//add home address via search location
	public void setAddrsViaSearch(int index) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();	 

		if (mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address")) {
			System.out.println("Address not availavble");

			mp.mySavesListText.get(index).click();
			//current location
			qcf.searchInputForMySaves();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
		} 

		else {
			bf.visibilitys(mp.mySavesListText.get(index));
			System.out.println("Address already available :- " + mp.mySavesListText.get(index).getText() );
			if(index == 1) {
				dlteWorkAddress();
			} else if (index == 0 ) {
				dlteHomeAddress();
			}
			bf.visibilitys(mp.mySavesListText.get(index));
			mp.mySavesListText.get(index).click();
//			chooseMapAddress();
			qcf.searchInputForMySaves();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
		}
	}
	
	
	public void homeAddrssEdit() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();	 

		if (mp.mySavesListText.get(0).getText().equalsIgnoreCase("Set Address")) {
			System.out.println("Address not availavble");

			mp.mySavesListText.get(0).click();
			//current location
			qcf.searchInputForMySaves();

			bf.visibilitys(mp.mySavesListText.get(0));
			Assert.assertFalse(mp.mySavesListText.get(0).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
			
			
			homeEditAddrss();
		} else {
			System.out.println("Address already available: " + mp.mySavesListText.get(0).getText());
			homeEditAddrss();
		}
	}
	
	public void workAddrssEdit() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();	 

		if (mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address")) {
			System.out.println("Address not availavble");

			mp.mySavesListText.get(1).click();
			//current location
			qcf.searchInputForMySaves();

			bf.visibilitys(mp.mySavesListText.get(1));
			Assert.assertFalse(mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
			
			
//			homeEditAddrss();
			workEditAddrss();
		} else {
			System.out.println("Address already available: " + mp.mySavesListText.get(1).getText());
//			homeEditAddrss();
			workEditAddrss();
		}
	}
	
	
	//tc - 15
	public void isDirectionPageRedirectedViaHomeOrWork(int index) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();	 

		homeOrWorkDirectionPage(1);
		
		bf.back();
		
		homeOrWorkDirectionPage(0);
	}
	
	
//	==========
	//for home direction page 
	public void homeOrWorkDirectionPage(int index) {
		if (mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address")) {
			System.out.println("Address not availavble");

			mp.mySavesListText.get(index).click();
			currntLocation();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
			mp.mySavesListText.get(index).click();
			Assert.assertEquals(mp.directionPage.getText(), "Directions");
			Reporter.log("Directions page redirected", true);
		} 

		else {
			bf.visibilitys(mp.mySavesListText.get(index));
			System.out.println("Address already available :- " + mp.mySavesListText.get(index).getText() );
			if(index == 1) {
				dlteWorkAddress();
				bf.visibilitys(mp.mySavesListText.get(index));
			} else if (index == 0 ) {
				dlteHomeAddress();
			}
			bf.visibilitys(mp.mySavesListText.get(index));
			mp.mySavesListText.get(index).click();
			currntLocation();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
			mp.mySavesListText.get(index).click();
			Assert.assertEquals(mp.directionPage.getText(), "Directions");
			Reporter.log("Directions page redirected", true);
		}
	}
//	============
	
	//tc - 17
	public void isFavSavedFrmPlcDetailPge() {
		bf.mapplsPermissions();

		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.homeSearchClick();
		String plc = RandomDataGenerator.generateRandomDistrictInJharkhand();
		bf.homeSearchInputClick(plc);
		bf.clickOnMatchedPlace(plc);

		bf.swipeUpUntilElementDisplayed(mp.plcDetailMySave, 4);

		mp.plcDetailMySave.click();

		Assert.assertEquals(mp.isFavVisible.getText(), "Favourites");
		Reporter.log("'Favourites' is present in place detail page", true);

		Reporter.log("get fav count  "+mp.getPlcCountFrmPlcDetailPage.getText(), true);
		//		mp.createListFrmPlcDetail.click();
		
		
		String beforeAdd =  mp.getPlcCountFrmPlcDetailPage.getText();
		String[] beforeparts = beforeAdd.split(" ");
		String beforenumberString = beforeparts[0];
		int beforeCount = Integer.parseInt(beforenumberString);
		
		mp.favClickAddIconPlcDetail.click();
		
		bf.visibilitys(mp.getPlcCountFrmPlcDetailPage);
		String aftrAdd =  mp.getPlcCountFrmPlcDetailPage.getText();
		String[] aftrparts = aftrAdd.split(" ");
		String aftrnumberString = aftrparts[0];
		int aftrCount = Integer.parseInt(aftrnumberString);
		
		Assert.assertTrue(beforeCount < aftrCount,"FAILED");
		Reporter.log("Favourites added in placed detail page", true);
		
		//my saves verification
		bf.sleepWait(4);
		
		bf.back();
		Assert.assertEquals(mp.isDirectionBtn.getText(), "Directions");
		
		mp.directionBackClick.click();
		
		String favAddrssTxt = mp.getFavTxtFrmPlcDetailPage.getText();
		
		Assert.assertTrue(mp.bttmPlcBackIcon.isDisplayed(),"Failed");
		mp.bttmPlcBackIcon.click();
		
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to home page display");
		
		bf.Hamburgerclick();
		
		mySavesClick();
		
		
//		String text = mp.mySavesListText.get(3).getText();
//		String[] parts = text.split(" ");
//		String numberString = parts[0];
//		int aftrAddFavMS = Integer.parseInt(numberString);
		
		mp.mySavesListText.get(3).click();
		String addrsXpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_place_name\" and @text=\""  + favAddrssTxt + "\"]";
		WebElement favListAdded =  driver.findElement(By.xpath(addrsXpath));
//		
		bf.swipeUpUntilElementDisplayed(favListAdded, 5);
		Reporter.log("Favourites added ", true);
//		createdList.click();
		
		
		
		
	}
	
	public void homeDlt() {
		bf.mapplsPermissions();
	    bf.Hamburgerclick();
	    bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
	    bf.Hamburgerclick();
	    mySavesClick();	 
	    
	    if (mp.mySavesListText.get(0).getText().equalsIgnoreCase("Set Address")) {
	    	System.out.println("Address not availavble");
	    	
	    	setHomeAddress();
	        homeEditAddrss();
	        dlteHomeAddress();
	    } else {
	        System.out.println("Address already available: " + mp.mySavesListText.get(0).getText());
	        homeEditAddrss();
	        dlteHomeAddress();
	    }
	}
	
	
	
	public void workDlt() {
		bf.mapplsPermissions();
	    bf.Hamburgerclick();
	    bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
	    bf.Hamburgerclick();
	    mySavesClick();	 
	    
	    if (mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address")) {
	    	System.out.println("Address not availavble");
	    	
	    	setWorkAddress();
	        workEditAddrss();
	        dlteWorkAddress();
	    } else {
	        System.out.println("Address already available: " + mp.mySavesListText.get(0).getText());
	        workEditAddrss();
	        dlteWorkAddress();
	    }
	}
	
	
	
	
	
	
	
//	==========================================================
	
	private static final String USERNAME = "nidhi1234";
    private static final String PASSWORD = "Mvn@1234";
    private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful";

	
	public void mySavesClick() {
		bf.visibilitys(mp.mySavesHambrgrMenu);
		mp.mySavesHambrgrMenu.click();
		Reporter.log("Clicked 'My Saves'", true);
	}
	
	public void addrsDlt() {
		bf.visibilitys(mp.dltAddress);
		mp.dltAddress.click(); 
		
		bf.visibilitys(mp.cnfmDlt);
        mp.cnfmDlt.click();
		Reporter.log("Address deleted", true);
		
		bf.visibilitys(mp.mySavesListText.get(0));
		
	}
	
	public void setHomeAddress() {
		
		//search address and clicked
		mp.mySavesListText.get(0).click();
		qcf.searchInputForMySaves();
		bf.visibilitys(mp.mySavesListText.get(0));
        Assert.assertFalse(mp.mySavesListText.get(0).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
        Reporter.log("Address added");
	}
	
	public void homeEditAddrss() {
		Reporter.log("edit home address");
		String beforeEdited = mp.mySavesListText.get(0).getText();
		mp.homeList.findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
        mp.edit.click(); 
        qcf.searchInputForMySaves();
        bf.visibilitys(mp.mySavesListText.get(0));
        Assert.assertFalse(mp.mySavesListText.get(0).getText().equalsIgnoreCase(beforeEdited), "Failed to edit address");
        Reporter.log("Home Address edited",true);
	}
	
	public void dlteHomeAddress() {
		mp.homeList.findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
		bf.sleepWait(4);
        addrsDlt();
        bf.visibilitys(mp.mySavesListText.get(0));
        Assert.assertTrue(mp.mySavesListText.get(0).getText().equalsIgnoreCase("Set Address"), "Failed to delete address");
        Reporter.log("home address deleted",true);        
	}
	
	
	
	//TC-2
	public void homeWithLogin() {
	    bf.mapplsPermissions();
	    bf.Hamburgerclick();
	    bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
	    bf.Hamburgerclick();
	    mySavesClick();	 
	    
	    if (mp.mySavesListText.get(0).getText().equalsIgnoreCase("Set Address")) {
	    	System.out.println("Address not availavble");
	    	
	    	setHomeAddress();
	        homeEditAddrss();
	        dlteHomeAddress();
	    } else {
	        System.out.println("Address already available: " + mp.mySavesListText.get(0).getText());
	        homeEditAddrss();
	        dlteHomeAddress();
	        setHomeAddress();
	    }
	}
	
	
	
//================================================================
	
	public void setWorkAddress() {
		bf.visibilitys(mp.mySavesListText.get(1));
		mp.mySavesListText.get(1).click();
		
		
        qcf.searchInputForMySaves();
        bf.visibilitys(mp.mySavesListText.get(1));
        Assert.assertFalse(mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address"), "Failed");
        Reporter.log("Address added");
	}
	
	public void dlteWorkAddress() {
		mp.workList.findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
        addrsDlt();
        bf.sleepWait(4);
        Assert.assertTrue(mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address"), "Failed to delete address");
        Reporter.log("work address deleted",true);
	}

	public void workEditAddrss() {
//		bf.visibilitys(mp.mySavesListText.get(1));
//		String beforeEdited = mp.mySavesListText.get(1).getText();
//		
//		
//		bf.visibilitys(mp.workList);
//		mp.workList.findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
//        
//		bf.visibilitys(mp.edit);
//		mp.edit.click(); 
//		
//		
//        qcf.searchInputForMySaves();
//        
//        bf.visibilitys(mp.mySavesListText);
//        Assert.assertFalse(mp.mySavesListText.get(1).getText().equalsIgnoreCase(beforeEdited), "Failed to edit work address");
//        Reporter.log("Work Address edited");
		
		Reporter.log("edit work address");
		String beforeEdited = mp.mySavesListText.get(1).getText();
		mp.workList.findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
	    mp.edit.click(); 
	    qcf.searchInputForMySaves();
	    bf.visibilitys(mp.mySavesListText.get(1));
	    Assert.assertFalse(mp.mySavesListText.get(1).getText().equalsIgnoreCase(beforeEdited), "Failed to edit address");
	    Reporter.log("work Address edited",true);
	}
	
	
	//TC-3
	public void workWithLogin() {
		bf.mapplsPermissions();
	    bf.Hamburgerclick();
	    bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
	    bf.Hamburgerclick();
	    mySavesClick();	    
	    if (mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address")) {
	    	setWorkAddress();
	        workEditAddrss();
	        dlteWorkAddress();
	    } else {
	        System.out.println("Address already available: " + mp.mySavesListText.get(1).getText());
	        workEditAddrss();
	        dlteWorkAddress();
	        setWorkAddress();
	    }
	}
	
	public void isUserAddWork() {
		bf.mapplsPermissions();
	    bf.Hamburgerclick();
	    bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
	    bf.Hamburgerclick();
	    mySavesClick();	    
	    if (mp.mySavesListText.get(1).getText().equalsIgnoreCase("Set Address")) {
	    	setWorkAddress();
//	        workEditAddrss();
//	        dlteWorkAddress();
	    } else {
	        System.out.println("Address already available: " + mp.mySavesListText.get(1).getText());
	        workEditAddrss();
//	        dlteWorkAddress();
//	        setWorkAddress();
	    }
	}
	
//	================end work address=========================

	

	//TC-4
	public void mySavesContrbution() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("7902460918" ,"contri123", "Login Successful");
		bf.Hamburgerclick();
		mySavesClick();	    
		String text = mp.mySavesListText.get(2).getText();
		String[] parts = text.split(" ");
		String numberString = parts[0];
		int totalCount  = Integer.parseInt(numberString);

		mp.mySavesListText.get(2).click();
		bf.sleepWait(4);
		int totalCountVerication = mp.contributionList.size();	
		Assert.assertEquals(totalCountVerication, totalCount , "Contribution count should match the expected number");
	    Reporter.log("contribution count verified by matching contribution list size",true);
		
	    //add place 
	    bf.back();
	    bf.back();
	    
	    bf.Hamburgerclick();
	    
	    
	    
	}
	

	//TC-5 add new place and verification
//	public void mySavesAddNewContribution() {
//		bf.mapplsPermissions();
//		bf.Hamburgerclick();
//		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
//		bf.Hamburgerclick();
//
//		mySavesClick();	
//		
//		String text = mp.mySavesListText.get(2).getText();
//		String[] parts = text.split(" ");
//		String numberString = parts[0];
//		int beforeAddTotalCount  = Integer.parseInt(numberString);
//		System.out.println("my contri " + beforeAddTotalCount );
//
//		bf.sleepWait(4);
//		
//		//add new place for contribution
//		
//		driver.navigate().back();
//		bf.sleepWait(4);
//		bf.Hamburgerclick();
//		ap.addPlaceClick();
//		ap.addAPlaceForm();
//		gp.markLocationClick();   
//		gp.markLocationDoneBtnClick();
//		bf.toastMsg("Trying to fetch your location. Please wait.");
//		gp.markLocationDoneBtnClick();
//		bf.sleepWait(4);
//		gp.placeNameInputClick();
//		gp.submitBtn();
//		gp.closeIconClick();
//
//		bf.Hamburgerclick();
//		bf.sleepWait(4);
//		mySavesClick();
//
//		String text2 = mp.mySavesListText.get(2).getText();
//		String[] parts2 = text2.split(" ");
//		String numberString2 = parts2[0];
//		int afterAddTotalCount  = Integer.parseInt(numberString2);
//		Assert.assertTrue(beforeAddTotalCount < afterAddTotalCount, "Failed to add new contribution count");
//		Reporter.log("New Contribution added successfully", true);
//	}
	
	
	
//	common function for favourite, route and point on map 
	private void commonMethod(int num) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);

		bf.Hamburgerclick();

		mySavesClick();	
		
		String text = mp.mySavesListText.get(num).getText();
		System.out.println(text);
		String[] parts = text.split(" ");
		String numberString = parts[0];
		
		mp.mySavesListText.get(num).click();
		
		int befrDlt = mp.favList.size() ;
		
		System.out.println(befrDlt);
		if(!mp.favList.isEmpty()) {
			
			bf.sleepWait(4);
			Assert.assertTrue(befrDlt == Integer.parseInt(numberString), "Failed fav list ");
			Reporter.log(" ", true);
			
			mp.favList.get(mp.favList.size()-1).click();
			bf.sleepWait(4);
			mp.favDlte.click();
			bf.sleepWait(4);
			mp.favConfrmDlte.click();
			bf.sleepWait(4);
			int aftrDlt = mp.favList.size();
			
			bf.back();
			bf.visibilitys(mp.mySavesListText.get(0));
			System.out.println("Total count after deleted  : "+aftrDlt);
			Assert.assertTrue(aftrDlt < befrDlt, "Failed to delete");
			Reporter.log("Item deleted and Verified by  list count", true);
		} else {
			System.out.println("List empty ");
		}
	}

	

	//TC-6
	public void mySavesFavCount() {
		commonMethod(3);
	}
	
	//tc-19
	
	
	

	public void isRoutAdded() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		mp.homeScreenNavigation.click();
		
		Assert.assertTrue(mp.drctionTopView.isDisplayed(),"Failed to navigation clicked");
		
		mp.enterAddrss.click();
		String plc = RandomDataGenerator.generateRandomDistrictInJharkhand();
		bf.homeSearchInputClick(plc);
		bf.clickOnMatchedPlace(plc);
		Assert.assertEquals(mp.btmDirection.getText(), "Directions");
		mp.startClick.click();
		
		bf.visibilitys(mp.btmSheetController);
		
		bf.isElementDisplay(mp.btmSheetController, "route bottom sheet controller ");
		
//		Assert.assertEquals(mp.startingNavigationMenuWindow.getText(), "Starting Navigation");
//		Reporter.log("Starting Navigation window display", true);
		
		bf.visibilitys(mp.btmSheetController);
		mp.btmSheetController.click();
		
		bf.swipeUpUntilElementDisplayed(mp.isRouteSavedIcon, 5);
		
		mp.isRouteSavedIcon.click();
		
		Assert.assertEquals(mp.routeHeader.getText(), "Set Route Name");
		Reporter.log("Set Route Name is present", true);
		bf.sleepWait(5);		
		String rtName = RandomDataGenerator.generateRandomTestName1();
		mp.enterRouteName.sendKeys(rtName);
		
		mp.saveRoutBtn.click();
		
		bf.toastMsg("Route saved successfully");
		
		bf.back();
		bf.back();
		
		Assert.assertEquals(mp.btmDirection.getText(), "Directions");
		mp.drctnBackBtn.click();
		
		
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed to home page display");
		
		
		
		bf.Hamburgerclick();
		mySavesClick();	
		
		
		mp.mySavesListText.get(4).click();
		
		String addrsXpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/my_saves_text_view\" and @text=\"" + rtName + "\"]";
		WebElement rtAdded =  driver.findElement(By.xpath(addrsXpath));
		
		bf.swipeUpUntilElementDisplayed(rtAdded, 5);
		Reporter.log("Route added ", true);
		
	}
	
	
	
	//TC-6.1
	public void mySavesAddNewFavCount() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);

		bf.Hamburgerclick();
		mySavesClick();	

		//get fav text before add new one
		String text = mp.mySavesListText.get(3).getText();
		String[] parts = text.split(" ");
		String numberString = parts[0];
		int beforeAdFav = Integer.parseInt(numberString);

		//add new fav 
		bf.back();
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();


		//bf.scrollUp(2);
		mp.reviewbtn.click();
		bf.sleepWait(1);
		mp.addFavListLayOut.get(1).click();
		bf.sleepWait(3);


		if(mp.favBtmClick.isDisplayed()) {
			mp.favBtmClick.click();
			bf.sleepWait(3);
			if(mp.favBtmDirection.isDisplayed()) {
//				ac = new Actions();
				bf.scrollUp(1);
				bf.sleepWait(3);
				mp.favSaveBtn.click();
				bf.sleepWait(3);

				String favCountBeforAdd = mp.favGetCount.getText();
				String[] parts2 = favCountBeforAdd.split(" ");
				String num1String = parts2[0];
				int beforeAdd = Integer.parseInt(num1String);
				System.out.println("before  " + beforeAdd);

				mp.favSaveBtnImg.click();

				bf.sleepWait(4);

				String favCountAfterAdd = mp.favGetCount.getText();
				String[] parts3 = favCountAfterAdd.split(" ");
				String num2String = parts3[0];
				int aftrAdd = Integer.parseInt(num2String);
				System.out.println("after " +  aftrAdd);
				if(beforeAdd == aftrAdd) {
					Reporter.log("place already exist", true);
				} else if(beforeAdd < aftrAdd) {
					Reporter.log("place added to favourite", true);
					bf.back();
					bf.back();
					bf.back();
					bf.back();
					bf.Hamburgerclick();
					mySavesClick();	

					String text2 = mp.mySavesListText.get(3).getText();
					String[] aftrAddFavpPts = text2.split(" ");
					String afterAddFav = aftrAddFavpPts[0];
					Integer.parseInt(afterAddFav);

					Assert.assertTrue(beforeAdFav < Integer.parseInt(afterAddFav),"Failed to add");
					Reporter.log("Favourite added", true);
				}
			}
		}
	}
	
	//TC-7 routes 
	public void mySavesRoutesCount() {
		commonMethod(4);
	}
	
	//delete route
	public void isRoutDltAble() {
		bf.mapplsPermissions();
		
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();
		//get rout count before delete
		String msRotCount = mp.mySavesListText.get(4).getText();
		String parts[] = msRotCount.split(" ");
		Reporter.log("route count : "+parts[0] , true);
		String beforeDltRtCount = parts[0];
		int rtCountBeforeDlt = Integer.parseInt(beforeDltRtCount);
		
		mp.mySavesListText.get(4).click();
		Reporter.log("route clicked " , true);
		
		Assert.assertEquals(mp.routeHeader.getText(), "My Routes");
		Reporter.log("'My Routes'  page redirected", true);
		int beforDlt = mp.routeListSize.size();
		
		
//		mp.routesDlt.click();
		mp.routMoreBtnClick.get(0).click();
		Assert.assertEquals(mp.routeDltClick.getText(), "Delete");
		mp.routeDltClick.click();
		
	
		mp.routeConfirmDltWindow.click();
		
		Assert.assertEquals(mp.routeDltMsg.getText(), "Route deleted successfully!");
		
		int aftrDlt = mp.pointMapAllLists.size();
		
		Assert.assertTrue(aftrDlt < beforDlt , "Failed to delete routes");
		
		bf.back();
		
		//get route count after delete
		String msRtCount = mp.mySavesListText.get(4).getText();
		String rtParts[] = msRtCount.split(" ");
		String aftrDltRTCount = rtParts[0];
		Reporter.log("after deldeted route count : "+ rtParts[0] , true);
		int rtCountAftrDlt = Integer.parseInt(aftrDltRTCount);
		
//		Assert.assertTrue(aftrDltRTCount > rtCountAftrDlt, "");
		Assert.assertTrue(rtCountAftrDlt < rtCountBeforeDlt,"FAILED");
		Reporter.log("routes deleted succefully", true);
		
		
	}
	
	//TC-8
	public void mySavesPointMapCount() {
		commonMethod(5);
	}
	
	


//	//created list test cases====================================================================

	//TC-9
	public void mySavesCreateListPublically() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();

		mySavesClick();	
		
		
		String testName = RandomDataGenerator.generateRandomTestName1();
		mp.createListBTN.click();
		mp.enterTitle.sendKeys(testName);
		mp.dropDownClick.click();
		mp.publically.click(); 
		mp.okBTN.click();
		bf.sleepWait(3);
		String Actual = mp.listCreatingError.getText();
        String Expected = "List created successfully";
        //Assert.assertFalse(mp.listCreatingError.isDisplayed(),"Unable to create list");
        Assert.assertEquals(Actual.toLowerCase(), Expected.toLowerCase(),"Unable to create list");
	}
	//TC-13
	public void mySavesCreateListPrivatly() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("8887776565", PASSWORD, LOGIN_SUCCESS_MESSAGE);		
		bf.Hamburgerclick();
		mySavesClick();			
		String testName = RandomDataGenerator.generateRandomTestName1();
		mp.createListBTN.click();
		mp.enterTitle.sendKeys(testName);
		mp.dropDownClick.click();
		mp.privately.click(); 
		mp.okBTN.click();
		bf.sleepWait(3);
		String Actual = mp.listCreatingError.getText();
        String Expected = "List created successfully";
        //Assert.assertFalse(mp.listCreatingError.isDisplayed(),"Unable to create list");
        Assert.assertEquals(Actual.toLowerCase(), Expected.toLowerCase(),"Unable to create list");

        dlteCrtddList(testName); 
	
	}
	
	//TC-11
//	public void poinOnMapCopLink() {
//		bf.mapplsPermissions();
//		ac = new Actions();
//		ac.longPress();
//		if(mp.pmap.isDisplayed()) {
//			ac.pointOnMapSwipe();
//			bf.sleepWait(2);
//			if(mp.shareBTN.isDisplayed()) {
//				mp.shareBTN.click();
//				bf.sleepWait(3);
//				String link = mp.copyLink.getText();
//				System.out.println("link copied : " + link);
//				bf.sleepWait(4);
//				mp.copiedBtn.click();
//				bf.toastMsg("Copied to clipboard.");
//			}
//		}
//	}
	
	//TC-11
	public void pointOnMapSaveAndShare() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		
		//before add
		bf.Hamburgerclick();
		mySavesClick();
		String beforeAdd =  mp.mySavesListText.get(5).getText();
		String[] parts = beforeAdd.split(" ");
		String numberString = parts[0];
		int beforeCount = Integer.parseInt(numberString);
		Reporter.log("before add new point on map " + beforeCount , true);
		driver.navigate().back();
		bf.sleepWait(4);	
		
		
		ac = new Actions();
		ac.longPress();
		Reporter.log("long press on map", true);
		bf.visibilitys(mp.searchInput);
		Assert.assertEquals(mp.searchInput.getText(), "Point On Map");
		Reporter.log("Point on map display at bottom of the screen", true);
//		ac.pointOnMapSwipe();
		bf.swipeUpUntilElementDisplayed(mp.saveBTN, 3);
		
		//add new 
		mp.saveBTN.click();
		bf.sleepWait(2);
		String testName = RandomDataGenerator.generateRandomTestName1();
		bf.sleepWait(3);
		mp.enterLabel.click();
		mp.enterLabel.sendKeys(testName);
		mp.doneLabelBTN.click();
		//bf.sleepWait(3);
			
		driver.navigate().back();
		bf.Hamburgerclick();

		mySavesClick();

		String aftrAdd =  mp.mySavesListText.get(5).getText();
		String[] aftrparts = aftrAdd.split(" ");
		String aftrnumberString = aftrparts[0];
		int aftrCount = Integer.parseInt(aftrnumberString);
		Reporter.log("after add new point on map " + aftrCount , true);

		bf.sleepWait(4);

		Assert.assertTrue(beforeCount < aftrCount,"FAILED");
		Reporter.log("Point on map added", true);
		
		mp.mySavesListText.get(5).click();
		           
		bf.visibilitys(mp.pointMapAllLists);
		
		// Construct the dynamic XPath
		String pointMapXPath = String.format("//android.widget.TextView[@resource-id='com.mmi.maps:id/list_details_pin_name' and @text='%s']", testName);

		 WebElement pointMapListTxt = driver.findElement(By.xpath(pointMapXPath));

		bf.swipeUpUntilElementDisplayed(pointMapListTxt, 4);
		
		Assert.assertEquals(pointMapListTxt.getText(), testName);
		Reporter.log("point on map added succefully : " + pointMapListTxt.getText(), true);
		
	} 
		
		
	
	
//	new test cases 
	//TC-14
	public void cancelLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		mySavesClick();	
		bf.visibilitys(mp.msCancel);
		mp.msCancel.click();
		bf.visibilitys(bp.hamburgerIconClick);
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to click cancel button");
		Reporter.log("My saves with out login cancel button worked",true);
		
	}
		
		//TC-15
	public void goWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		mySavesClick();	
		bf.visibilitys(mp.msLogin);
		mp.msLogin.click();
		
		bf.visibilitys(mp.msLoginWelcomePage);
		Assert.assertTrue(mp.msLoginWelcomePage.isDisplayed(),"Failed to redirect welocome login page");
		Reporter.log("welcome login page is visible",true);
		
	}
	
	
	//TC - 16 
	public void mySvesList() {
		bf.mapplsPermissions();

		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);

		bf.Hamburgerclick();
		mySavesClick();

		for (int i = 0; i < 7; i++) {
			String oldData = mp.mySavesListText.get(i).getText();
			String label = mp.msList.get(i).getText();
			System.out.println(i + ">. old data of " + label + " is :" + oldData);

			switch (label) {
			case "Home":
			case "Work":
				// Validation for - Home and Work
				Assert.assertTrue(oldData.equalsIgnoreCase("Set Address") || !oldData.matches("\\d+ Places"),
						"Validation failed for " + label + ": Expected 'Set Address' or text data only, but found: "
								+ oldData);
				break;

			case "My Routes":
				// Validation for - My Routes
				validateSingularOrPlural(oldData, "Route", "Routes", "Validation failed for My Routes");
				break;

			case "Point on Map":
				// Validation for - Point on Map
				validateSingularOrPlural(oldData, "Point", "Points", "Validation failed for Point on Map");
				break;

			default:
				// Validation for all other categories - Contributions, Favorites, and custom
				// lists
				validateSingularOrPlural(oldData, "Place", "Places", "Validation failed for " + label);
				break;
			}
		}
	}
	
	private void validateSingularOrPlural(String oldData, String singular, String plural, String errorMessage) {
		if (oldData.matches("1 " + singular)) {
			Reporter.log("Validation passed for singular: " + oldData, true);
		} else if (oldData.matches("\\d+ " + plural)) {
//			Reporter.log("Validation passed for plural: " + oldData, true);
		} else {
			Assert.fail(errorMessage + ": Expected format '1 " + singular + "' or 'X " + plural + "', but found: "
					+ oldData);
		}
	}


	
	
	public void currntLocation() {
		bf.visibilitys(mp.currentLocation);
        mp.currentLocation.click();
        Reporter.log("Current location clicked ",true);
	}
	
	//Test- 17 & 18
	public void currentLocation(int index) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();	 

		if (mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address")) {
			System.out.println("Address not availavble");

			mp.mySavesListText.get(index).click();
			//current location
			currntLocation();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
		} 

		else {
			bf.visibilitys(mp.mySavesListText.get(index));
			System.out.println("Address already available :- " + mp.mySavesListText.get(index).getText() );
			if(index == 1) {
				dlteWorkAddress();
				bf.visibilitys(mp.mySavesListText.get(index));
			} else if (index == 0 ) {
				dlteHomeAddress();
			}
			bf.visibilitys(mp.mySavesListText.get(index));
			mp.mySavesListText.get(index).click();
			currntLocation();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
		}
	}
	
	
	
	public void chooseMapAddress() {
		bf.visibilitys(mp.chooseMap);
	    mp.chooseMap.click();
	    Reporter.log("choose on map location clicked ",true);
	    bf.sleepWait(4);
	    Assert.assertTrue(mp.pointMapAdrs.isDisplayed(),"Failed to click choose on map address");
	    bf.visibilitys(mp.ChooseMapDoneBtn);
	    mp.ChooseMapDoneBtn.click();
	}
	//Test- 19 & 20
	public void chooseOnMap(int index) {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		bf.Hamburgerclick();
		mySavesClick();	 

		if (mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address")) {
			System.out.println("Address not availavble");

			mp.mySavesListText.get(index).click();
			//current location
			chooseMapAddress();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
		} 

		else {
			bf.visibilitys(mp.mySavesListText.get(index));
			System.out.println("Address already available :- " + mp.mySavesListText.get(index).getText() );
			if(index == 1) {
				dlteWorkAddress();
				bf.visibilitys(mp.mySavesListText.get(index));
			} else if (index == 0 ) {
				dlteHomeAddress();
			}
			bf.visibilitys(mp.mySavesListText.get(index));
			mp.mySavesListText.get(index).click();
			chooseMapAddress();

			bf.visibilitys(mp.mySavesListText.get(index));
			Assert.assertFalse(mp.mySavesListText.get(index).getText().equalsIgnoreCase("Set Address"), "Failed to set address");
			Reporter.log("Address added");
		}
	}
	
	
	
		
	public void editList() {
		String updatedName = RandomDataGenerator.generateRandomTestName1();
		mp.relativeLO.get(mp.relativeLO.size()-1).findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
		mp.edit.click();
		mp.enterTitle.clear();
		mp.enterTitle.sendKeys(updatedName);
//		mp.dropDownClick.click();
//		mp.privately.click(); 
		mp.okBTN.click();
		
		
		boolean isUptedListFound = false;
		for (WebElement list : mp.msCreatedLists) {
			if (list.getText().equalsIgnoreCase(updatedName)) {
				isUptedListFound = true;
				System.out.println("updated list found " + list.getText());
				dlteCrtddList(updatedName);  
				verifyListDeletion(updatedName);
				break;
			}
		} 
		if (!isUptedListFound) {
			Assert.fail("updated list with name '" + updatedName + "' was not found in the created lists.");
		}
		
	}
	
		public void dlteCrtddList(String testName) {
			boolean isListFound = false;
			for (WebElement list : mp.msCreatedLists) {
				if (list.getText().equalsIgnoreCase(testName)) {
					bf.sleepWait(4);
					isListFound = true;
					System.out.println("list found " + list.getText());
					//delete created list 
					mp.relativeLO.get(mp.relativeLO.size()-1).findElement(By.id("com.mmi.maps:id/btn_layout")).findElement(By.id("com.mmi.maps:id/btn_more")).click();
					bf.visibilitys(mp.dltAddress);
					mp.dltAddress.click(); 
					bf.visibilitys(mp.cnfmDlt);
					mp.cnfmDlt.click();
					Reporter.log("created list deleted", true);
					//=========================
					break;
				}
			}
			if (!isListFound) {
				Assert.fail("Created list with name '" + testName + "' was not found in the created lists.");
			}
		}
		
		private void verifyListDeletion(String testName) {
		    boolean isDeleted = true;

		    // Check if the list still exists
		    for (WebElement list : mp.msCreatedLists) {
		        if (list.getText().equalsIgnoreCase(testName)) {
		            isDeleted = false; // List still exists
		            break;
		        }
		    }

		    // Assert based on deletion verification
		    if (!isDeleted) {
		        Assert.fail("Created list with name '" + testName + "' was not deleted.");
		    } else {
		        Reporter.log("Created list with name '" + testName + "' successfully deleted.", true);
		    }
		}
//		===================
		//TC-21
		public void mySavesCreateListPrivatlyEdit() {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);		
			bf.Hamburgerclick();
			mySavesClick();			
			String testName = RandomDataGenerator.generateRandomTestName1();
			mp.createListBTN.click();
			mp.enterTitle.sendKeys(testName);
			mp.dropDownClick.click();
			mp.privately.click(); 
			mp.okBTN.click();
			bf.sleepWait(3);
			String Actual = mp.listCreatingError.getText();
			String Expected = "List created successfully";

			Assert.assertEquals(Actual.toLowerCase(), Expected.toLowerCase(),"Unable to create list");

			bf.sleepWait(2);
			editList();
			dlteCrtddList(testName);  
			verifyListDeletion(testName);
		}
		
		public void delteList() {
			
			bf.mapplsPermissions();
			bf.Hamburgerclick();
//			bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);		
//			bf.simpleHamburgerLogin("9934445588", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
			bf.simpleHamburgerLogin("8887776565", PASSWORD, LOGIN_SUCCESS_MESSAGE);
			
			
			bf.Hamburgerclick();
			mySavesClick();			
			String testName = RandomDataGenerator.generateRandomTestName1();
			mp.createListBTN.click();
			mp.enterTitle.sendKeys(testName);
			mp.dropDownClick.click();
			mp.privately.click(); 
			mp.okBTN.click();
			bf.sleepWait(3);
			String Actual = mp.listCreatingError.getText();
			String Expected = "List created successfully";

			Assert.assertEquals(Actual.toLowerCase(), Expected.toLowerCase(),"Unable to create list");

			bf.sleepWait(2);
//			editList();
			dlteCrtddList(testName);  
			verifyListDeletion(testName);
			
		}
		
		//TC-22
		public void mySavesCreateListPubliclyEdit() {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);		
			bf.Hamburgerclick();
			mySavesClick();			
			String testName = RandomDataGenerator.generateRandomTestName1();
			mp.createListBTN.click();
			mp.enterTitle.sendKeys(testName);
			mp.dropDownClick.click();
			mp.publically.click(); 
			mp.okBTN.click();
			bf.sleepWait(3);
			String Actual = mp.listCreatingError.getText();
	        String Expected = "List created successfully";
	        //Assert.assertFalse(mp.listCreatingError.isDisplayed(),"Unable to create list");
	        Assert.assertEquals(Actual.toLowerCase(), Expected.toLowerCase(),"Unable to create list");

	        bf.sleepWait(2);
	        editList();
		}
		
		//==========================is route editable
		public void routeEditable() {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
//			bf.simpleHamburgerLogin("7870194441", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);		
			bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
			bf.Hamburgerclick();
			mySavesClick();	
			
			mp.mySavesListText.get(4).click();
			Reporter.log("'My Routes' Clicked", true);
			String beforeEdit = mp.routeTxt.get(0).getText();
			Reporter.log(beforeEdit, true);
			mp.routMoreBtn.get(0).click();
			
			mp.reName.click();
			
			mp.enterRoutName.clear();
			
			Random random = new Random();
			int randomNumber = 1000 + random.nextInt(9000);
			 
			mp.enterRoutName.sendKeys("route name " + randomNumber);
			
			mp.okBtnRoute.click();
			bf.visibilitys(mp.routeTxt.get(0));
			String afterEdit = mp.routeTxt.get(0).getText();
			Reporter.log(afterEdit, true);
			Assert.assertNotEquals(afterEdit, beforeEdit);
			Reporter.log("Route edited ", true);
			
			
		}
		
		
		private int getCount;
		public int getPlcCount(int index) {
			String getText = mp.mySavesListText.get(index).getText();
			String parts[] = getText.split(" ");
			
			getCount = Integer.parseInt(parts[0]);
			
			return getCount;
		}
		
		public void insideContributionList() {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			
			bf.simpleHamburgerLogin("9898987879", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
			bf.Hamburgerclick();
			mySavesClick();

			Reporter.log("Contribution Place count : " + getPlcCount(2), true);
			mp.mySavesListText.get(2).click();
			Reporter.log("Clicked contribution ", true);

			boolean isMapIssueFound = false;
			boolean isAddedPlaceFound = false;
			boolean isEditedPlaceFound = false;
			int swipeCount = 0;

			while (swipeCount < 50) {
				try {
					for (WebElement element : mp.contributionStatus) {
						String elementText = element.getText();
						if (!isMapIssueFound && elementText.equalsIgnoreCase("MAP ISSUE")) {
							System.out.println("Element text found: MAP ISSUE");
							isMapIssueFound = true;
						}

						if (!isAddedPlaceFound && elementText.equalsIgnoreCase("ADDED PLACE")) {
							System.out.println("Element text found: ADDED PLACE");
							isAddedPlaceFound = true;
						}
						
						if (!isEditedPlaceFound && elementText.equalsIgnoreCase("EDITED PLACE")) {
							System.out.println("Element text found: EDITED PLACE");
							isEditedPlaceFound = true;
						}
					}

					if (isMapIssueFound && isAddedPlaceFound && isEditedPlaceFound) {
						break;
					}

					bf.scrollUp(1);
					swipeCount++;
				} catch (NoSuchElementException e) {
					System.out.println("Element not found during swipe attempt " + swipeCount);
					break;
				}
			}

			Assert.assertTrue(isAddedPlaceFound  && isMapIssueFound && isEditedPlaceFound, "element not found after maximum swipes.");
			Reporter.log("Element found ", true);

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// bf.simpleHamburgerLogin("7870194441", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
					// bf.simpleHamburgerLogin("9833980977", "Mvn@1234", LOGIN_SUCCESS_MESSAGE);
		
}