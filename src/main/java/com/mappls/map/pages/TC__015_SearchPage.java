package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;


public class TC__015_SearchPage extends BasePage {

	public TC__015_SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.mmi.maps:id/fragment_home_search_txt")
	public @Getter WebElement searchBar;

	@FindBy(id = "com.mmi.maps:id/search_input")
	public @Getter WebElement searchBarInput;

	@FindBy(id = "com.mmi.maps:id/search_clear_btn")
	public @Getter WebElement searchBarCross;

	@FindBy(id = "com.mmi.maps:id/bottom_place_head")
	public @Getter WebElement placelayout;

	@FindBy(id = "com.mmi.maps:id/bottom_place_head")
	public @Getter WebElement placelayouthead;

	@FindBy(id = "com.mmi.maps:id/place_name")
	public @Getter WebElement searchedPlaceName;

	@FindBy(id = "com.mmi.maps:id/place_address")
	public @Getter WebElement searchedPlaceAddress;

	@FindBy(id = "com.mmi.maps:id/place_reviews_layout")
	public @Getter WebElement reviewLayout;

	@FindBy(id = "com.mmi.maps:id/place_rating_text")
	public @Getter WebElement ratingText;

	@FindBy(id = "com.mmi.maps:id/place_rating_bar")
	public @Getter WebElement ratingBarText;

	@FindBy(id = "com.mmi.maps:id/place_reviews_count")
	public @Getter WebElement reviewCount;

	@FindBy(id = "com.mmi.maps:id/place_eloc")
	public @Getter WebElement elocUrl;

	@FindBy(id = "com.mmi.maps:id/place_distance")
	public @Getter WebElement distance;

	@FindBy(id = "com.mmi.maps:id/place_duration")
	public @Getter WebElement duration;

	@FindBy(id = "com.mmi.maps:id/place_directions_button")
	public @Getter WebElement directionsBtn;

	@FindBy(id = "com.mmi.maps:id/suggestion_listView")
	public @Getter WebElement suggestionList;

	@FindBy(id = "com.mmi.maps:id/poi_list")
	public @Getter WebElement suggestionListViewVRFY;

	@FindBy(id = "com.mmi.maps:id/main_layout")
	public @Getter WebElement bottomSheet;

	
	//android.widget.LinearLayout
	@FindBy(id="com.mmi.maps:id/category_container")
	public @Getter WebElement catContainer;
	
	//androidx.recyclerview.widget.RecyclerView
	@FindBy(id="com.mmi.maps:id/cat_grid_view")
	public @Getter WebElement searchCatView;
	
	//android.widget.LinearLayout
	@FindBy(xpath ="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/cat_name_textview\" and @text=\"Coffee\"]")
	public @Getter WebElement searchCatCoffee;
	
	
	@FindBy(id="com.mmi.maps:id/home_work_container")
	public @Getter WebElement homeWorkContainer;
	
	@FindBy(id="com.mmi.maps:id/bottom_sheet_quick_access_home_title")
	public @Getter WebElement homeTitle;
	
	@FindBy(id="com.mmi.maps:id/bottom_sheet_quick_access_work_title")
	public @Getter WebElement workTitle;
	
	@FindBy(id="By.id(\"com.mmi.maps:id/suggestion_listView")
	public @Getter WebElement list;
}
