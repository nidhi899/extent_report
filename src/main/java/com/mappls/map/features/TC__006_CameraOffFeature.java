package com.mappls.map.features;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.TC__006_CameraOffPage;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__006_CameraOffFeature {


	BaseFeatures bf;
	TC__019_UserProfileFeature upf;
	TC__015_SearchFeature spf;
	TC__016_PlaceDetailFeature pdf;
	TC__006_CameraOffPage cfo;
	TC__005_LocationFeature lf;
	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public TC__006_CameraOffFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		
		bf = new BaseFeatures(driver);
		upf = new TC__019_UserProfileFeature(driver);
		spf = new TC__015_SearchFeature(driver);
		pdf = new TC__016_PlaceDetailFeature(driver);
		cfo = new TC__006_CameraOffPage(driver);
		lf = new TC__005_LocationFeature(driver);
		
	}

	//98 
//	Check for Camera pop up message (Place detail page)	
//	Verify that the user is getting the pop up message for photos access "Mappls Would like to access the Camera"	
//	A pop up message should appear while doing "Review and Report" "Mappls Would like to access the Camera"
	
public void cameraOffFeature() throws IOException, InterruptedException {
	bf.mapplsPermissions();
	bf.Hamburgerclick();
	upf.userMenu();
	upf.ClickUserMenuAtHamburger();
	upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
	upf.handleUpdate();
	spf.searchBar();
	String randomPlace = "Ranchi";
	spf.searchPlaceTextSearch(randomPlace);
	pdf.placeDetailLayoutClick();
	pdf.postClick();
	String randomtext = RandomDataGenerator.generateRandomExperience();
	pdf.postPlace(randomtext);
	addImageLayout();
	btmsheetDisplay();
	mapplsCameraDisplay();
	mapplsCameraClick();
	permissionforCamera();
	cfo.WhileUsingAppOption.click();
	recordAudioPErmission();
	lf.WhileUsingAppOption();
	cfo.WhileUsingAppOption.click();
	addImageLayout();
	btmsheetDisplay();
	mapplsCameraDisplay();
	mapplsCameraClick();
	photoAndVideoaccessPermission();
	lf.allowOption();
	lf.dontallowOption();
	cfo.allowOption.click();
	addImageLayout();
	btmsheetDisplay();
	mapplsCameraDisplay();
	mapplsCameraClick();
	wait.until(ExpectedConditions.visibilityOf(cfo.clickPictureBtn));
	Assert.assertTrue(cfo.clickPictureBtn.isDisplayed(), " Camera Layout should be displayed");
	Reporter.log("Camera  Is displayed", true);	
}

public void addImageLayout() {
	wait.until(ExpectedConditions.visibilityOf(cfo.addImageLayout));
	Assert.assertTrue(cfo.addImageLayout.isDisplayed(), "Add Image Layout should be displayed");
	
	wait.until(ExpectedConditions.visibilityOf(cfo.addImageText));
	Assert.assertTrue(cfo.addImageText.isDisplayed(), "Add Image Text should be displayed");
	String text = cfo.addImageText.getText();
	Reporter.log("Container Text : " +text, true);	
	cfo.addImageLayout.click();
	Reporter.log("Add Image Clicked ", true);
}
public void btmsheetDisplay() {
	wait.until(ExpectedConditions.visibilityOf(cfo.AddImageBtmSht));
	Assert.assertTrue(cfo.AddImageBtmSht.isDisplayed(), "Bottom Sheet Layout should be displayed");
	Reporter.log("Bottom Sheet with camera And Gallery Options Is displayed", true);	
}

public void mapplsCameraDisplay() {
	wait.until(ExpectedConditions.visibilityOf(cfo.mapplsCamCont));
	Assert.assertTrue(cfo.mapplsCamCont.isDisplayed(), "Mappls Camera Layout should be displayed");
	Reporter.log("Mappls Camera Options Is displayed", true);	
}

public void mapplsCameraClick() {
	wait.until(ExpectedConditions.visibilityOf(cfo.mapplsCamContText));
	Assert.assertTrue(cfo.mapplsCamContText.isDisplayed(), "Mappls Camera Layout should be displayed");
	String text = cfo.mapplsCamContText.getText();
	Assert.assertEquals(text,"Mappls Camera", "TExt does not match.");

	cfo.mapplsCamCont.click();
	Reporter.log("Mappls Camera Clicked ", true);
	}
public void permissionforCamera() {
	wait.until(ExpectedConditions.visibilityOf(cfo.permissionBoxTitle));
	Assert.assertTrue(cfo.permissionBoxTitle.isDisplayed(), "Allow Mappls MapmyIndia to take pictures and record video? is not displayed.");
	Assert.assertNotNull(cfo.permissionBoxTitle, "Allow Mappls MapmyIndia to take pictures and record video? is null.");
	String permissionTitleText = cfo.permissionBoxTitle.getText();
	Reporter.log("Title Text Displayed : " + permissionTitleText, true);
	Assert.assertEquals(permissionTitleText,"Allow Mappls MapmyIndia to take pictures and record video?", "Title does not match the expected message.");

	lf.WhileUsingAppOption();
	lf.OnlyThisTimeOption();
	lf.DenyOption();
}

public void recordAudioPErmission() {
	wait.until(ExpectedConditions.visibilityOf(cfo.permissionBoxTitle));
	Assert.assertTrue(cfo.permissionBoxTitle.isDisplayed(), "Allow Mappls MapmyIndia to record audio? is not displayed.");
	Assert.assertNotNull(cfo.permissionBoxTitle, "Allow Mappls MapmyIndia to record audio? is null.");
	String permissionTitleText = cfo.permissionBoxTitle.getText();
	Reporter.log("Title Text Displayed : " + permissionTitleText, true);
	Assert.assertEquals(permissionTitleText,"Allow Mappls MapmyIndia to record audio?", "Title does not match the expected message.");

}

public void photoAndVideoaccessPermission() {
	wait.until(ExpectedConditions.visibilityOf(cfo.permissionBoxTitle));
	Assert.assertTrue(cfo.permissionBoxTitle.isDisplayed(), "Allow Mappls MapmyIndia to access photos and videos on this device? is not displayed.");
	Assert.assertNotNull(cfo.permissionBoxTitle, "Allow Mappls MapmyIndia to access photos and videos on this device? is null.");
	String permissionTitleText = cfo.permissionBoxTitle.getText();
	Reporter.log("Title Text Displayed : " + permissionTitleText, true);
	Assert.assertEquals(permissionTitleText,"Allow Mappls MapmyIndia to access photos and videos on this device?", "Title does not match the expected message.");
}
}
