package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
public class TC__014_HomeScreenPage{
	public  TC__014_HomeScreenPage (WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/real_view_button\"]")
	public @Getter WebElement s360View;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_home_search_txt\"]")
	public @Getter WebElement isSearchBarVisible;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/map_layer_button\"]")
	public @Getter WebElement isMapLayerVisisble;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/geo_cam_button\"]")
	public @Getter WebElement isCamVisible;
	
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/mappls_pin\"]")
	public @Getter WebElement isPinVisible;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
	public @Getter WebElement isLocationVisible;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/real_view_button\"]")
	public @Getter WebElement isurHereVisible;

	@FindBy(xpath="//android.view.View[@resource-id=\"com.mmi.maps:id/scroll_indicator_thumb\"]")
	public @Getter WebElement isbtmSheetVisible;
	
//	tc - 2
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_direction\"]")
	public @Getter WebElement isNavigationVisible;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_what_and_where_search\"]")
	public @Getter WebElement isWhatAndWhereBtnVisible;

//	@FindBy(xpath="//android.view.View[@resource-id=\"com.mmi.maps:id/scroll_indicator_thumb\"]")
//	public @Getter WebElement isbtmSheetVisible;
	
	
	
}
