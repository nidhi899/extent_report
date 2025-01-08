package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__013_MapDisplayPage {

	
	public TC__013_MapDisplayPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}


//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/real_view_button\"]")
//	public @Getter WebElement s360View;
//
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_home_search_txt\"]")
//	public @Getter WebElement isSearchBarVisible;
//	
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/map_layer_button\"]")
//	public @Getter WebElement isMapLayerVisisble;
//
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/geo_cam_button\"]")
//	public @Getter WebElement isCamVisible;
//	
//	
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/mappls_pin\"]")
//	public @Getter WebElement isPinVisible;
//
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
//	public @Getter WebElement isLocationVisible;
//	
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/real_view_button\"]")
//	public @Getter WebElement isurHereVisible;
//
//	@FindBy(xpath="//android.view.View[@resource-id=\"com.mmi.maps:id/scroll_indicator_thumb\"]")
//	public @Getter WebElement isbtmSheetVisible;
//	
////	tc - 2
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_direction\"]")
//	public @Getter WebElement isNavigationVisible;
//	
//	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_what_and_where_search\"]")
//	public @Getter WebElement isWhatAndWhereBtnVisible;

	@FindBy(xpath="//android.widget.ImageView")
	public @Getter WebElement mpplsLogoImg;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_layers_value\"]")
	public @Getter WebElement myLayerMySave;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"My Layers\"]")
	public @Getter WebElement myLayerPageTitle;
	
	@FindBy(xpath="new UiSelector().className(\"android.widget.ImageButton\")")
	public @Getter WebElement myLayersBackBtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_label_of_row\" and @text=\"My Saves\"]")
	public @Getter WebElement myLayerMySavesPresent;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[3]")
	public @Getter WebElement myLayerMySavesToggle;
	
	//
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_direction\"]")
	public @Getter WebElement homeScreenDirection;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_stop_label\" and @text=\"Your current location\"]")
	public @Getter WebElement urCrrntLoction;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/bottom_sheet_quick_access_home_title\"]")
	public @Getter WebElement home;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/bottom_sheet_quick_access_work_title\"]")
	public @Getter WebElement work;
	
//	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[3]")
//	public @Getter WebElement myLayerMyToggle;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[3]")
	public @Getter WebElement myLayerMySaveeesToggle;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
