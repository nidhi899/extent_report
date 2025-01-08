package com.mappls.map.features;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__020_MapLayerPage;
import com.mappls.map.utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__020_MapLayerFeature {

	TC__020_MapLayerPage mp;
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	BasePage bp;
	BaseFeatures bf;
	Actions ac;
	
	public TC__020_MapLayerFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		wait = new WebDriverWait(driver, 10);
		mp = new TC__020_MapLayerPage(driver);
		ac = new Actions();
				
	}


	


	
	
	
	//verify map layer button test case 1
	public void isMLButtonClickable() {
		bf.mapplsPermissions();
		mapLayerClick();
		Assert.assertEquals(mp.isMyMapVsble.getText(), "My Map");
		Reporter.log("Map layer button clickable", true);
	}
	
	
	//map layer button with valid credential or guest user test case -2
	public void withLoginMLButtonClick() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		mapLayerClick();
		Assert.assertTrue(mp.closeBTN.isDisplayed(), "Failed to click Map Layer Button");
		Reporter.log("Map Layer button clicked with login credential",true);
	}
	
	


	// TC - 3
	public void isMLWorking(int num) {
		bf.mapplsPermissions();

		if(num == 1) {
			bf.Hamburgerclick();
			bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");

		} else if(num == 2) {
			bf.Hamburgerclick();
			bf.simpleHamburgerLogin("mapmyindiasurveycar1", "mapmyindia", "Login Successful");
		}

		//check traffic
		mapLayerClick();
		mapPostsClick();

		//swachh bharat
		functionalityCheck("Swachh Bharat","Swachh Bharat");

		//community
		functionalityCheck("Community","Community");

		//Traffic
		functionalityCheck("Traffic", "Traffic");

		//safety
		functionalityCheck("Safety", "Safety");

		//Polluting Activity
		functionalityCheck("Polluting Activity", "Polluting Activity");


		bf.scrollUp(1);

		//UNICEF School Closure and toggle button is off
		functionalityCheck("UNICEF School Closure", "UNICEF School Closure");

		mp.mapLayerBackBtn.click();
		visualTraffic();

		threeDMap();

		//tap to customize category alerts
		//POC Mapmyindia street map and hybrid satellite map
	}

	//			3-D map
	public void threeDMap() {
		boolean isChecked = mp.switchElement3D.getAttribute("checked").equals("true");

		if (isChecked) {
			mp.switchElement3D.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("false");
			Assert.assertTrue(afterClicked, "Failed to checked");
			System.out.println("3-D MAP Switch toggled to unchecked is successfully.");
		} else {
			mp.switchElement3D.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("true");
			Assert.assertTrue(afterClicked, "Failed to unchecked");
			System.out.println("3-D MAP Switch toggled to checked is successfully.");

		}
	}


	//visual traffic 
	public void visualTraffic() {
		boolean isChecked = mp.visualTraffic.getAttribute("checked").equals("true");

		if (isChecked) {
			mp.visualTraffic.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("true");
			Assert.assertTrue(afterClicked, "Failed to checked");
			System.out.println("Visual Traffic Switch toggled to unchecked is successfully.");

		} else {
			mp.visualTraffic.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("true");
			Assert.assertFalse(afterClicked, "Failed to unchecked");
			System.out.println("Visual Traffic Switch toggled to checked is successfully.");
		}
	}

	//My saves button should not be highlighted on map layer 
	public void mySavesMLWOL() {
		bf.mapplsPermissions();
		mapLayerClick();
		mp.layers.click();
		
		
		WebElement mySaves = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[3]"));
		mySaves.click();
		Assert.assertEquals(mp.wolTxt.getText(), "Please login to use this feature");
	    Reporter.log("My saves button should not be highlighted on map layer ",true);
	    
	}
	
	//My Gadgets button should not be visible on map layer. 
	public void myGadgetMLWOL() {
		bf.mapplsPermissions();
		mapLayerClick();
		mp.layers.click();
		
		boolean myGadgetsVisible = false; // Flag to track visibility

	    for (WebElement element : mp.textViewLabelRow) {
	        String myGadgetTxt = element.getText();
	        if (myGadgetTxt.equals("MyGadgets")) {
	            myGadgetsVisible = true; // Set the flag if found
	            Assert.assertEquals(myGadgetTxt, "MyGadgets");
	            Reporter.log("My Gadgets button is visible on map layer.", true);
	            break; // Exit the loop since we found the element
	        }
	    }

	    // If myGadgetsVisible is still false, print the message
	    if (!myGadgetsVisible) {
	        Reporter.log("My Gadgets button not visible on map layer.", true);
	    }

		
//		for(WebElement element: mp.textViewLabelRow) {
//			String myGadgetTxt = element.getText();
//			Assert.assertEquals(myGadgetTxt, "MyGadgets");
//			Reporter.log("My Gadgets button should not be visible on map layer. ",true);
//		}
	    
	}
	
	
	//User should get the by default Mapmyindia Map 
	//Verify that user Open app without any login credentials.
	public void mapLayerDefaultMap() throws InterruptedException {
		bf.mapplsPermissions();
		mapLayerClick();
		bf.sleepWait(2);
		maplayersVerfication(1 , "Default Map already selected with out login");

	}
	
	
	public void mapLayerSatelliteMap() throws InterruptedException {
		bf.mapplsPermissions();
		mapLayerClick();
		mp.satelliteMap.click();
		bf.sleepWait(2);
		maplayersVerfication(2, "Satellite Map");
		
	}
	
	//map layer close button 10
	public void mapLayerCloseButtonClick() {
		bf.mapplsPermissions();
		mapLayerClick();
		mp.closeBTN.click();
		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),"Failed to click close button");
		Reporter.log("close button clickable", true);
	}
	

	//Verfiy that user is able to click on traffic events
	//	Traffic events should be clickable and open new sub category events
    public void mapLayerTrafficEventClickable() {
    	bf.mapplsPermissions();
    	mapLayerClick();
    	mapPostsClick();
    	subCategry("Traffic", "Traffic");
    }
	
    public void subCategry(String parentView ,String isPresent) {
		for (WebElement element : mp.parentView) {
			String elementText = element.getText(); // Store the text for comparison
			if (elementText.equals(parentView)) {
				element.click(); // Click the element if the text matches
				if(mp.verifyParentName.isDisplayed()) {
					Assert.assertEquals(mp.verifyParentName.getText(), isPresent);
					Reporter.log(parentView + " clicked", true);
					for(WebElement txtElement : mp.trficSubTxtView) {
						Reporter.log("sub category events : " + txtElement.getText(), true);
					}
				}
				
				break; // Optional: exit the loop after clicking
			}
		}
	}
    
    
    
    //sub category toggle 12
    public void trafficSubCatToggleClick() {
    	bf.mapplsPermissions();
    	mapLayerClick();
    	
    	bf.visibilitys(mp.closeBTN);
    	ac = new Actions();
    	
    	ac.swipeUp();
    			
    	mapPostsClick();
    	subCategry("Traffic", "Traffic");
    	
    	trafficSwitch();
		
    }
    
    public void trafficSwitch() {
    	mp.trafficSwitch.click();
    	boolean isChecked = mp.trafficSwitch.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println("traffic switch checked successfully");
    		
		mp.trafficSwitch.click();
		boolean isUnChecked = mp.trafficSwitch.getAttribute("checked").equals("true");
		Assert.assertFalse(isUnChecked, "Failed to unchecked");
		System.out.println("traffic switch unchecked successfully");

    }
    
    //sub category toggle 13
    //Verify that user is able to tap on toggle to OFF the traffic events
    //Every sub category of traffic events toggle should be off

    public void trafficEvrySubCatToggleOff() {
    	bf.mapplsPermissions();
    	mapLayerClick();
    	mapPostsClick();
    	subCategry("Traffic", "Traffic");
    	
    	mp.trafficSwitch.click();
    	boolean isChecked = mp.trafficSwitch.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println("traffic switch checked successfully");
    		
		isTrafficEvrySubCatOn(mp.trafficJamSwitch, "Jam");
		isTrafficEvrySubCatOn(mp.trafficAccidentSwitch, "Accident");
		isTrafficEvrySubCatOn(mp.trafficRDCloseSwitch, "Road close");
		isTrafficEvrySubCatOn(mp.trafficRDWorkSwitch, "Road work");
		isTrafficEvrySubCatOn(mp.traffiOthrIssuecSwitch, "Other issue");
		isTrafficEvrySubCatOn(mp.trafficBreakDownSwitch, "Break down");
		
		mp.trafficSwitch.click();
		boolean isunChecked = mp.trafficSwitch.getAttribute("checked").equals("false");
		Assert.assertTrue(isunChecked, "Failed to unchecked");
		System.out.println("traffic switch unchecked successfully");
		
		isTrafficEvrySubCatOff(mp.trafficJamSwitch, "Jam");
		isTrafficEvrySubCatOff(mp.trafficAccidentSwitch, "Accident");
		isTrafficEvrySubCatOff(mp.trafficRDCloseSwitch, "Road close");
		isTrafficEvrySubCatOff(mp.trafficRDWorkSwitch, "Road work");
		isTrafficEvrySubCatOff(mp.traffiOthrIssuecSwitch, "Other issue");
		isTrafficEvrySubCatOff(mp.trafficBreakDownSwitch, "Break down");
		
		
		
		
    }
    
    public void isTrafficEvrySubCatOn(WebElement element, String msg) {
    	boolean isChecked = element.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println(msg +" switch checked successfully");
    }
    
    public void isTrafficEvrySubCatOff(WebElement element, String msg) {
    	boolean isChecked = element.getAttribute("checked").equals("false");
		Assert.assertTrue(isChecked, "Failed to unchecked");
		System.out.println(msg +" switch unchecked successfully");
    }
    
    
//    public void trafficEvntToggle() {
//    	boolean isChecked = mp.dayModes.getAttribute("selected").equals("true");
//		Assert.assertTrue(isChecked, "Failed to checked");
//		System.out.println("Day Mode selected successfully");	
//    }
    
    
    
    //Verify that user is able to tap on back button - 14
    //Back button functionality should work
    public void backButton() {
    	bf.mapplsPermissions();
    	mapLayerClick();
    	mapPostsClick();
    	mp.mapLayerBackBtn.click();
    	Assert.assertTrue(mp.defaultMap.isDisplayed(), "Failed to click back button");
    	Reporter.log("Map layer back button clicked successfuly", true);
    }
    
    
    // tc - 15
    //Verfiy that user is able to click on safety events
    //Safety events should be clickable and open new sub category events
    public void safetyEvnt() {
    	bf.mapplsPermissions();
    	mapLayerClick();
    	mapPostsClick();
    	subCategry("Safety", "Safety");
    }
    
    
    //TC - 16
    //Verfiy that user is able to tap on toggle to On and Off safety event
    //Safety events toggle should be clickable and toggle On and Off all the sub category
    public void safetyTggleAllEvntSwitch() {
    	safetyEvnt();
    	mp.trafficSwitch.click();
    	boolean isChecked = mp.trafficSwitch.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println("safety switch checked successfully");
		
		
		isTrafficEvrySubCatOn(mp.trafficJamSwitch, "Police Checkpost");
		isTrafficEvrySubCatOn(mp.trafficAccidentSwitch, "Hazard");
		isTrafficEvrySubCatOn(mp.trafficRDCloseSwitch, "Water Logging");
		isTrafficEvrySubCatOn(mp.trafficRDWorkSwitch, "Unsafe Area");
		isTrafficEvrySubCatOn(mp.traffiOthrIssuecSwitch, "Landslide Prone Area");
		isTrafficEvrySubCatOn(mp.trafficBreakDownSwitch, "Bad Weather");
		
		
		mp.trafficSwitch.click();
		boolean isunChecked = mp.trafficSwitch.getAttribute("checked").equals("false");
		Assert.assertTrue(isunChecked, "Failed to unchecked");
		System.out.println("safety switch unchecked successfully");
		
		isTrafficEvrySubCatOff(mp.trafficJamSwitch, "Police Checkpost");
		isTrafficEvrySubCatOff(mp.trafficAccidentSwitch, "Hazard");
		isTrafficEvrySubCatOff(mp.trafficRDCloseSwitch, "Water Logging");
		isTrafficEvrySubCatOff(mp.trafficRDWorkSwitch, "Unsafe Area");
		isTrafficEvrySubCatOff(mp.traffiOthrIssuecSwitch, "Landslide Prone Area");
		isTrafficEvrySubCatOff(mp.trafficBreakDownSwitch, "Bad Weather");
		
    }
    
    
    //Verify that user is able to tap on toggle to OFF of any safety events
  	//Every sub category of Safety events toggle should be off
    //TC - 17
    public void saftyEvntClickAnySubCat() {
    	safetyEvnt();
    	
    	boolean isunChecked = mp.trafficJamSwitch.getAttribute("checked").equals("false");
    	Assert.assertTrue(isunChecked, "Failed to unchecked");
    	System.out.println("Police station switch unchecked successfully");
    	
    	mp.trafficSwitch.click();
    	boolean isChecked = mp.trafficJamSwitch.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println("Police station switch checked successfully");
    	
    }
    
    //TC - 18
    //Verify that user is able to tap on back button
  	//Back button functionality should work
    public void saftyEvntBackBtn() {
    	
    	safetyEvnt();
    	mp.mapLayerBackBtn.click();
    	Assert.assertEquals(mp.postsTxt.getText(), "Posts");
    	Reporter.log("back button clicked in safety event", true);
    }
    
    
    //TC - 19
    //Verfiy that user is able to click on community events
  	//Community events should be clickable and open new sub category events
    public void communityEvntToggle() {
    	bf.mapplsPermissions();
    	mapLayerClick();
    	mapPostsClick();
    	subCategry("Community", "Community");

    }
    
    //TC - 20
    //Verfiy that user is able to tap on toggle to On and Off community event
  	//Community events toggle should be clickable and toggle On and Off all the sub category
    public void communityEvntToggleOnnAndOff() {
    	communityEvntToggle();
    	mp.trafficSwitch.click();
    	boolean isChecked = mp.trafficSwitch.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println("Community switch checked successfully");
    	
    }
     
    
    //TC - 21
  	//Verify that user is able to tap on toggle to OFF of any community events
  	//Every sub category of Community events toggle should be off
    public void communityEvntSubCatToggleOff() {
    	communityEvntToggle();
    	mp.trafficSwitch.click();
    	boolean isChecked = mp.trafficSwitch.getAttribute("checked").equals("true");
		Assert.assertTrue(isChecked, "Failed to checked");
		System.out.println("community switch checked successfully");
		
		
		isTrafficEvrySubCatOn(mp.trafficJamSwitch, "Electricity Failure");
		isTrafficEvrySubCatOn(mp.trafficAccidentSwitch, "Water Wastage");
		isTrafficEvrySubCatOn(mp.trafficRDCloseSwitch, "Unpaved Road");
		isTrafficEvrySubCatOn(mp.trafficRDWorkSwitch, "Mobile Network No Coverage");
		isTrafficEvrySubCatOn(mp.traffiOthrIssuecSwitch, "Mobile Network Call Drop");
		isTrafficEvrySubCatOn(mp.trafficBreakDownSwitch, "Stagnant Water");
		
		
		mp.trafficSwitch.click();
		boolean isunChecked = mp.trafficSwitch.getAttribute("checked").equals("false");
		Assert.assertTrue(isunChecked, "Failed to unchecked");
		System.out.println("community switch unchecked successfully");
		
		isTrafficEvrySubCatOff(mp.trafficJamSwitch, "Electricity Failure");
		isTrafficEvrySubCatOff(mp.trafficAccidentSwitch, "Water Wastage");
		isTrafficEvrySubCatOff(mp.trafficRDCloseSwitch, "Unpaved Road");
		isTrafficEvrySubCatOff(mp.trafficRDWorkSwitch, "Mobile Network No Coverage");
		isTrafficEvrySubCatOff(mp.traffiOthrIssuecSwitch, "Mobile Network Call Drop");
		isTrafficEvrySubCatOff(mp.trafficBreakDownSwitch, "Stagnant Water");
    }
    
    
    //TC - 22
    //Verify that user is able to tap on back button
  	//Back button functionality should work
    public void communityEvntBackBtn() {
    	communityEvntToggle();
    	mp.mapLayerBackBtn.click();
    	Assert.assertEquals(mp.postsTxt.getText(), "Posts");
    	Reporter.log("back button clicked in safety event", true);
    }
    
    //TC - 23
    //Verify that user is able to tap on toggle ON
    //Toggle On functionality should work
    public void threeDViewsEnableAndDisabled() throws InterruptedException {
		bf.mapplsPermissions();
		mapLayerClick();
		boolean isChecked = mp.switchElement3D.getAttribute("checked").equals("true");

		if (isChecked) {
			mp.switchElement3D.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("false");
			Assert.assertTrue(afterClicked, "Failed to checked");
			System.out.println("Switch toggled to unchecked is successfully.");
		} else {
			mp.switchElement3D.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("true");
			Assert.assertTrue(afterClicked, "Failed to unchecked");
			System.out.println("Switch toggled to checked is successfully.");

		}

	}
    
    
    
    //TC - 24
    //Verify that user is able to tap on toggle Off
    //Toggle Off functionality should work
    public void visualTrafficEnableAndDisabled() throws InterruptedException {
		

		bf.mapplsPermissions();
		mapLayerClick();
		boolean isChecked = mp.visualTraffic.getAttribute("checked").equals("true");

		if (isChecked) {
			mp.visualTraffic.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("true");
			Assert.assertTrue(afterClicked, "Failed to checked");
			System.out.println("Switch toggled to unchecked is successfully.");

		} else {
			mp.visualTraffic.click();
			boolean afterClicked = mp.switchElement3D.getAttribute("checked").equals("true");
			Assert.assertFalse(afterClicked, "Failed to unchecked");
			System.out.println("Switch toggled to checked is successfully.");

		}
	}
    
    
    
    //TC - 25
    //Verify that user is able to tap on "i" button beside My map
  	//Help/ Information Icon (i) should be clickable for information about My map
  	public void mapInfoAndVerfication() {
  		bf.mapplsPermissions();
  		mapLayerClick();
  		mp.mapInfo.click();
  		bf.visibilitys(mp.mapInfoVerificaton);
  		Assert.assertTrue(mp.mapInfoVerificaton.isDisplayed(),"Failed to clicked map info 'i' button");
  		Reporter.log("map info 'i' button clicked", true);
  		
  	}
    
    
    //TC - 26
    //Verify that user is able to tap on "i" button beside Layers
    //Help/ Information Icon (i) should be clickable for information about Layers
  	public void mapLayerIndoAndVerification() {
  		bf.mapplsPermissions();
  		mapLayerClick();
  		mp.layerInfo.click();
  		bf.visibilitys(mp.layerInfoVerification);
  		Assert.assertTrue(mp.layerInfoVerification.isDisplayed(), "Failed to clicked map info 'i' button");
  		Reporter.log("layer info 'i' button clicked", true);
  		
  	}
    
    
    
    //TC - 27
	//Verify that user is able to tap on 3D
	//3D view should show on the map
    
    
    
    
    
    
    
    
//	=========================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  public void maplayersVerfication(int index, String msg) throws InterruptedException {
	        // Locate the second map layer container
		  bf.visibilitys(mp.defaultMap);
	        MobileElement selectedLayer = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("(//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/map_layer_image_container\"])[" + index + "]")));

	        // Find all ImageView elements within the selected layer container
	        List<MobileElement> imageViews = selectedLayer.findElements(By.className("android.widget.ImageView"));

	        // Check if any ImageView contains the resource ID "com.mmi.maps:id/layer_image_view"
	        boolean isLayerImageViewPresent = imageViews.stream().anyMatch(imageView -> "com.mmi.maps:id/selected_layer_image_view".equals(imageView.getAttribute("resource-id")));
	        // Print the result
	        if (isLayerImageViewPresent) {
	            System.out.println(msg + " Layer image view is present.");
	        } else {
	            System.out.println(msg + " Layer image view is not present. Test case failed.");
	        }

	        // Assert the result to pass/fail the test case
	        Assert.assertTrue(isLayerImageViewPresent, msg + " Layer image view not found in the selected layer container.");
	   
	    }

	    
	    public void mapLayerClick() {
	    	mp.mpLayerIcon.click();
	    	Reporter.log("Map Layer Icon  click",true);	
			bf.sleepWait(3);
	    }
		public void defaultMap() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			bf.sleepWait(2);
			maplayersVerfication(1 , "Default Map already selected");

		}
		
		public void defaultMapUnChecked() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Satellite Map
			mp.satelliteMap.click();
			bf.sleepWait(2);
			// Locate the second map layer container
	        MobileElement selectedLayer = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("(//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/map_layer_image_container\"])[1]")));

	        // Find all ImageView elements within the selected layer container
	        List<MobileElement> imageViews = selectedLayer.findElements(By.className("android.widget.ImageView"));
	        boolean isLayerImageViewPresent =  !"com.mmi.maps:id/selected_layer_image_view".equals(imageViews.get(0).getAttribute("resource-id"));
	       
	        System.out.println("is default - " + isLayerImageViewPresent);

	        // Assert the result to pass/fail the test case
	        Assert.assertTrue(isLayerImageViewPresent,  " Layer image view not found in the selected layer container.");
	   
	        System.out.println("defualt map unchecked ");

		}

		public void satelliteMap() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Satellite Map
			mp.satelliteMap.click();
			bf.sleepWait(2);
			maplayersVerfication(2, "Satellite Map");
		}

		public void terrainMap() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Terrain Map
			mp.terrainMap.click();
			bf.sleepWait(2);
			maplayersVerfication(3, "Terrain Map");
		}

		public void grayMap() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Gray Map
			mp.grayMap.click();
			bf.sleepWait(2);
			maplayersVerfication(4, "Gray Map");
		}

		public void sublimeGreayMap() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Sublime Gray Map
			mp.sublimeGreayMap.click();
			bf.sleepWait(2);
			maplayersVerfication(5, "Sublime Map");
		}

		public void darkClassicMap() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Dark Classic Map
			mp.darkClassicMap.click();
			bf.sleepWait(2);
			maplayersVerfication(6, "Dark Classic Map");
		}


		public void autoModesIsChecked() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			bf.sleepWait(4);
			boolean isChecked = mp.autoModes.getAttribute("selected").equals("true");
			Assert.assertTrue(isChecked, "Failed to checked");
			System.out.println("Auto Mode already selected");		
		}
		
		public void autoModesIsunChecked() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			bf.sleepWait(4);
			mp.dayModes.click();
			boolean isChecked = mp.autoModes.getAttribute("selected").equals("false");
			Assert.assertTrue(isChecked, "Failed to checked");
			System.out.println("Auto Mode un-checked successfully");		
		}

		public void dayModes() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Day Modes
			mp.dayModes.click();
			boolean isChecked = mp.dayModes.getAttribute("selected").equals("true");
			Assert.assertTrue(isChecked, "Failed to checked");
			System.out.println("Day Mode selected successfully");	
		}


		public void nightMode() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			// Night Mode
			mp.nightMode.click();
			boolean isChecked = mp.nightMode.getAttribute("selected").equals("true");
			Assert.assertTrue(isChecked, "Failed to checked");
			System.out.println("Night Mode selected successfully");
		}



		
		



		public void userLogin() throws InterruptedException {
			mp.login.click();
			mp.enterUserId.sendKeys("nidhi1234");
			bf.sleepWait(2);
			mp.continueBTN.click();
			mp.enterPSW.sendKeys("Mvn@1234");
			bf.sleepWait(2);
			mp.loginBTN.click();
			bf.sleepWait(2);
			String msg = bp.toastMsg.getAttribute("name");
			System.out.println("Toast message: " + msg);
			Assert.assertEquals(msg, "Login Successful");
		}


		public void myLayersClick() {
	    	mp.myLayersClick.click();
	    	Reporter.log("My Layers  click",true);	
			bf.sleepWait(3);
	    }

		//my-layers with login for my saves
		public void myLayerHome() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			myLayersClick();
			userLogin();
			WebElement home = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[1]"));
			String homeCheckedAttribute = home.getAttribute("checked");
			if ("true".equals(homeCheckedAttribute)) {
				System.out.println("Home is enabled. Clicking to disable.");
				home.click();
				Assert.assertFalse("false".equals(homeCheckedAttribute),"Failed to unchecked");
				System.out.println("Switch toggled to unchecked is successfully.");

			} else {
				System.out.println("Home is disabled. Clicking to enable.");
				home.click();
				Assert.assertFalse("true".equals(homeCheckedAttribute),"Failed to checked");
				System.out.println("Switch toggled to unchecked is successfully.");

			} 
		}

		//my-layers with login for my saves
		public void myLayerWork() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			myLayersClick();
			userLogin();
			WebElement work = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[2]"));
			String workCheckedAttribute = work.getAttribute("checked");
			System.out.println("checkedAttribute value = " + workCheckedAttribute);
			if ("true".equals(workCheckedAttribute)) {
				System.out.println("work is enabled. Clicking to disable.");
				work.click();
				Assert.assertFalse("false".equals(workCheckedAttribute),"Failed to unchecked");
				System.out.println("Switch toggled to unchecked is successfully.");

			} else {
				System.out.println("work is disabled. Clicking to enable.");
				work.click();
				Assert.assertTrue("true".equals(workCheckedAttribute),"Failed to checked");
				System.out.println("Switch toggled to unchecked is successfully.");

			} 
		}


		//my-layers with login for my saves
		public void myLayerMySaves() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			myLayersClick();
			userLogin();
			//for my-saves
			bf.sleepWait(4);
			WebElement mySaves = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[3]"));
			String mySavesCheckedAttribute = mySaves.getAttribute("checked");
			System.out.println("checkedAttribute value = " + mySavesCheckedAttribute);

			if ("true".equals(mySavesCheckedAttribute)) {
				System.out.println("my-saves is enabled. Clicking to disable.");
				mySaves.click();
				bf.sleepWait(4);
				Assert.assertFalse("false".equals(mySavesCheckedAttribute),"Failed to unchecked");
				System.out.println("Switch toggled to unchecked is successfully.");

			} else {
				System.out.println("my-saves is disabled. Clicking to enable.");
				mySaves.click();
				bf.sleepWait(4);
				Assert.assertTrue("true".equals(mySavesCheckedAttribute),"Failed to checked");
				System.out.println("Switch toggled to unchecked is successfully.");

			}
		}


		public void mapPostsClick() {
			bf.swipeUpUntilElementDisplayed(mp.postClick, 3);
	    	mp.postClick.click();
	    	Reporter.log("Map Posts  click",true);	
			bf.sleepWait(3);
	    }

		public void mapPost() {
			ac = new Actions();
			bf.mapplsPermissions();
			mapLayerClick();
			mapPostsClick();
			ac = new Actions();
			bf.scrollUp(1);

			WebElement earthObsList = driver.findElement(By.id("com.mmi.maps:id/parent_recycler_view"));
			List<WebElement> mySavesList = earthObsList.findElements(By.className("android.view.ViewGroup"));
			
			Assert.assertTrue(mySavesList.size() >0);
			System.out.println("Passed");
			
			Random rm = new Random();
		    int randomNum = rm.nextInt(mySavesList.size()) + 0; 
		    System.out.println("clicked index number : "+ randomNum);
		    mySavesList.get(randomNum).click();
			
		    
		    //inside posts
		    WebElement dataList = driver.findElement(By.id("com.mmi.maps:id/recycler_view_event"));
			List<WebElement> data = dataList.findElements(By.className("android.view.ViewGroup"));

			Assert.assertTrue(data.size() >0);
			System.out.println("Passed");
			
			//for toggle
			int randomNumData = rm.nextInt(data.size()) + 0; 
			WebElement toggleBTN = data.get(randomNumData).findElement(By.className("android.widget.Switch"));
		    boolean isChecked = toggleBTN.getAttribute("checked").equals("true");

		    if (isChecked) {
		    	toggleBTN.click();
				boolean afterClicked = toggleBTN.getAttribute("checked").equals("true");
				Assert.assertTrue(afterClicked, "Failed to checked");
				System.out.println("Switch toggled to unchecked is successfully.");

			} else {
				toggleBTN.click();
				bf.sleepWait(5);
				boolean afterClicked = toggleBTN.getAttribute("checked").equals("true");
				Assert.assertTrue(afterClicked, "Failed to unchecked");
				System.out.println("Switch toggled to checked is successfully.");

			}
		}



		//without login
		public void myLayersWithOutLogin() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			myLayersClick();
			//for home
			WebElement home = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[1]"));
			String homeCheckedAttribute = home.getAttribute("checked");
			System.out.println("checkedAttribute value = " + homeCheckedAttribute);
			home.click();

			Assert.assertEquals(homeCheckedAttribute, "false", "Home switch should not be checked");

			if ("true".equals(homeCheckedAttribute)) {
				System.out.println("Home is not enabled. You need to login first for access toggle");
			} else {
				System.out.println("Toggle could not be checked without login");
				return;
			}
		}

		 public void earthObservationClick() {
		    	mp.earthObsClick.click();
		    	Reporter.log("Earth Observation  click",true);	
				bf.sleepWait(3);
		    }

		//earth observation data
		public void earthObservationList() throws InterruptedException {
			bf.mapplsPermissions();
			mapLayerClick();
			earthObservationClick();
			System.out.println("Clicked on Earth Observation option.");
			ac = new Actions();
			Thread.sleep(4000);
			bf.scrollUp(1);
			System.out.println("Performed swipe action on map layers.");
			bf.sleepWait(4);
			List<WebElement> androidView = mp.recyclerView.findElements(By.className("android.view.ViewGroup"));
			boolean index = androidView.size()>0;
			Assert.assertTrue(index, "Failed, data is empty");
			System.out.println("total size of eath observation data :" + androidView.size());
		}

		//common locators
		public void commonLocatorsClick(int index, String msg) throws InterruptedException {
			Thread.sleep(5000);
			WebElement androidVG = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/recycler_view_layer\"]/android.view.ViewGroup[" + index + "]"));
			List<WebElement> androidView = androidVG.findElements(By.className("android.widget.TextView"));
			System.out.println(androidView.get(0).getText());
			Assert.assertEquals(androidView.get(0).getText(), msg);
//			System.out.println("passed : " + androidView.get(0).getText());
			androidView.get(1).click();
			
			
			WebElement headerTxt = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + msg + "\"]"));
			Assert.assertEquals(headerTxt.getText(), msg);
			
			mp.earthObsBackBtn.click();
			
			Assert.assertEquals(mp.earthObsBackVerification.getText(), "Earth Observation Data");
			
			
			ac = new Actions();
			bf.scrollUp(1);
			
//			mp.mapLayerBackBtn.click();
		}
		
		public void commonLocators(int index, String msg) throws InterruptedException {
			Thread.sleep(5000);
			WebElement androidVG = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/recycler_view_layer\"]/android.view.ViewGroup[" + index + "]"));
			List<WebElement> androidView = androidVG.findElements(By.className("android.widget.TextView"));
			System.out.println(androidView.get(0).getText());
			Assert.assertEquals(androidView.get(0).getText(), msg);
			System.out.println("passed : " + androidView.get(0).getText());
//			androidView.get(1).click();
//			ac = new Actions();
//			bf.scrollUp(1);
		}

		//1
		public void nlData() throws InterruptedException {
			earthObservationList();
			String msg = "Night Light Data";
			commonLocators(1, msg);
		}

		//2
		public void digitalData() throws InterruptedException {
			earthObservationList();
			String msg = "Digital Elevation Model";
			commonLocators(2, msg);
		}

		//3
		public void weatherData() throws InterruptedException {
			earthObservationList();
			String msg = "Weather";
			commonLocators(3,msg);
			List<WebElement> dataList = mp.weatherRecyclerView.findElements(By.className("android.view.ViewGroup"));
			dataList.get(1).click();
			bf.sleepWait(4);
			bf.scrollUp(2);
		    String nnn = driver.findElement(By.id("com.mmi.maps:id/wms_description_text_view")).getText();
		    System.out.println(nnn);
		}

		//4
		public void landuseData() throws InterruptedException {
			earthObservationList();
			String msg = "Landuse & Landcover";
			commonLocators(4,msg);
		}

		//5
		public void waterSpreadData() throws InterruptedException {
			earthObservationList();
			String msg = "Water Spread";
			commonLocators(5,msg);
		}

		//6
		public void satelliteData() throws InterruptedException {
			earthObservationList();
			String msg = "Satellite Image";
			commonLocators(6,msg);
		}

		//7
		public void vegIndicesData() throws InterruptedException {
			earthObservationList();
			String msg = "Vegetation Indices";
			commonLocators(7,msg);
		}

		//8
		public void weatherForecadtData() throws InterruptedException {
			earthObservationList();
			String msg = "Weather Forecast";
			commonLocators(8,msg);
		}

		//9
		public void sarBIData() throws InterruptedException {
			earthObservationList();
			String msg = "SAR Backscatter Image";
			commonLocators(9,msg);
		}

		//10
		public void soilData() throws InterruptedException {
			earthObservationList();
			String msg = "Soil Moisture & Temperature Data";
			commonLocators(10,msg);
		}

		//11
		public void seaData() throws InterruptedException {
			earthObservationList();
			
			ac = new Actions();
			Thread.sleep(5000);
			ac.scrollDown();
			String msg = "Sea Surface Salinity";
			commonLocators(11,msg);

		}

		//12
		public void snowData() throws InterruptedException {
			earthObservationList();
			ac = new Actions();
			Thread.sleep(5000);
			ac.scrollDown();
			String msg = "Snow Cover";
			commonLocators(12,msg);
		}
		
		
		
		
		
//		=====================new test cases reggression
		
		
//		------------------ TC-31
		public void functionalityCheck(String parentView ,String isPresent) {
			for (WebElement element : mp.parentView) {
				String elementText = element.getText(); // Store the text for comparison
				if (elementText.equals(parentView)) {
					element.click(); // Click the element if the text matches
					if(mp.verifyParentName.isDisplayed()) {
						Assert.assertEquals(mp.verifyParentName.getText(), isPresent);
						Reporter.log(parentView + " clicked", true);
						mp.mapLayerBackBtn.click();
					}
					
					break; // Optional: exit the loop after clicking
				}
			}
		} 
		
		
		
//		TC -32
//		Elements of Map Layers such as,Traffic (6), Community (11), Safety
//		(12), Swachh Bharat (3), Polluting Activity (4) and UNICEF School Closure (1),
//		Tap to customize the category of alerts, 
//		Visual Traffic,
//		My Saves,
//		Map Type including 2D and 3D should be visible and 
//		POC MapmyIndia Street Map and Hybrid Satellite Map
		public void isMLWorkingWL() {
			bf.mapplsPermissions();

			bf.Hamburgerclick();
			bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
			
			
			//check traffic
			mapLayerClick();
			mapPostsClick();
			
			//swachh bharat
			functionalityCheck("Swachh Bharat","Swachh Bharat");
			
			//community
			functionalityCheck("Community","Community");
			
			//Traffic
			functionalityCheck("Traffic", "Traffic");
			
			//safety
			functionalityCheck("Safety", "Safety");

			//Polluting Activity
			functionalityCheck("Polluting Activity", "Polluting Activity");
			

			bf.scrollUp(1);
			
			//UNICEF School Closure and toggle button is off
			functionalityCheck("UNICEF School Closure", "UNICEF School Closure");
			
			
			//tap to customize category alerts
			//visual traffic
			// map type - 2d,3d
			//POC Mapmyindia street map and hybrid satellite map
		}
		
		
		
		
		
		public void isMLWorkingIOT() {
			bf.mapplsPermissions();

			bf.Hamburgerclick();
			bf.simpleHamburgerLogin("mapmyindiasurveycar1","mapmyindia", "Login Successful");
			
			
			//check traffic
			mapLayerClick();
			mapPostsClick();
			
			//swachh bharat
			functionalityCheck("Swachh Bharat","Swachh Bharat");
			
			//community
			functionalityCheck("Community","Community");
			
			//Traffic
			functionalityCheck("Traffic", "Traffic");
			
			//safety
			functionalityCheck("Safety", "Safety");

			//Polluting Activity
			functionalityCheck("Polluting Activity", "Polluting Activity");
			

			bf.scrollUp(1);
			
			//UNICEF School Closure and toggle button is off
			functionalityCheck("UNICEF School Closure", "UNICEF School Closure");
			
			
			//tap to customize category alerts
			//visual traffic
			// map type - 2d,3d
			//POC Mapmyindia street map and hybrid satellite map
		}
		
		
	}
