package tests;


import org.testng.annotations.Test;

import com.mappls.map.features.TC__024_EarthObsDataFeature;
import com.mappls.map.utils.DriverManager;

public class TC__024_EarthObsData extends DriverManager{
//558-562
	
	TC__024_EarthObsDataFeature ef;
	
	
//	Verify the User is able to see Earth Observation Data.	
//	User Should be able to see the Earth Observation Data after clicking on Map Layer Icon,on My Map Page and it should be clickable.
	@Test(priority = 1)
	public void isEarthObsDataVisible() throws InterruptedException {
		ef = new TC__024_EarthObsDataFeature(driver);
		ef.isEarthObsDataClickable();
	}
	
	
//	Verify  Earth Observation Data page.
//	On  Earth Observation Data  page ,there should be back button on top,current location icon on the map and on 
//	the scroll card different categories of earth observation data should display.
	
	@Test(priority = 2)
	public void earthObsDataPageVerify() throws InterruptedException {
		ef = new TC__024_EarthObsDataFeature(driver);
		ef.earthObsBackBtn();
	}
	
	
	
//	Verify category icons in Earth observation data	
//	On Earth Observation Data page, all the category icons should be available and visible
	@Test(priority = 3)
	public void verifyCatIcons() throws InterruptedException {
		ef = new TC__024_EarthObsDataFeature(driver);
		ef.allCategoryIconVisibility();
	}
	
//	Verify For  Earth Observation Data category and subcategory	
//	"User should be able to click on the Categories displaying below,
//	After clicking on that their sub-category should display .And there should be back and cancel button on all the pages. "
	@Test(priority = 4)
	public void earthObsDataCatAndSubCat() throws InterruptedException {
		ef = new TC__024_EarthObsDataFeature(driver);
		ef.earthObsDataClickCatAndSubCat();
	}
	
	
//	NA - Verify For  Earth Observation Data subcategory	
//	"After Clicking on the sub-categories .its data should reflect Over the map on India level with default color.
//	Also if for any particular categories ,date option is there , then User should be able select the date can view its data of that particular date on all over the Map."
	@Test(priority = 5) 
	public void verifyEarthobsDataSubCat() {
		ef = new TC__024_EarthObsDataFeature(driver);
	}
}
