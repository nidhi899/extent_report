package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__023WhatAndWherePage {
	public TC__023WhatAndWherePage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_home_search_txt\"]")
	public @Getter WebElement searchInputVisibility;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_what_and_where_search\"]")
	public @Getter WebElement nearByIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search\"]")
	public @Getter WebElement searchNearPage;
	
	//
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search_address\"]")
	public @Getter WebElement isCrrntLocationAddrss;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_back\"]")
	public @Getter WebElement searchNearPageBackBtn;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_edit\"]")
	public @Getter WebElement searchNearPagePencilIcon;
	//
	
	//after click the pencil icon search page redirected 
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input\"]")
	public @Getter WebElement searchNearPagePencilEdit;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Your current location\"]")
	public @Getter WebElement suggetionCrrntLocation; //Your current location
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Choose On Map\"]")
	public @Getter WebElement suggestionChooseMap; // Choose On Map
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input_what\"]")
	public @Getter WebElement whatMoodForSearchOption;
	
	
	@FindAll({@FindBy(id="com.mmi.maps:id/cat_name_textview") }) 
	public @Getter List<WebElement> catNameTxt;
	
	@FindAll({@FindBy(id="com.mmi.maps:id/item_place_result_place_name") }) 
	public @Getter List<WebElement> rsltPlcLists;
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Directions\"]")
	public @Getter WebElement drctnBtnTxt;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/place_layout\"]/android.view.ViewGroup")
	public @Getter WebElement plcDetailPage;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search\"]")
	public @Getter WebElement evChrgingPage;
	
	
	@FindAll({@FindBy(id="com.mmi.maps:id/text_view_item") }) 
	public @Getter List<WebElement> elctrcChrgngPlgClick;
	
	
	@FindAll({@FindBy(id="com.mmi.maps:id/item_place_result_place_name") }) 
	public @Getter List<WebElement> appliedRstList;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_apply\"]")
	public @Getter WebElement applyBtn;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/search_filter_what_and_where\"]")
	public @Getter WebElement evChrgingPageFilter;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/reset\"]")
	public @Getter WebElement evChrgingPageResetFilter;
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search\"]")
//	public @Getter WebElement evChrgingPage;
//	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search\"]")
//	public @Getter WebElement evChrgingPage;
//	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search\"]")
//	public @Getter WebElement evChrgingPage;
	
	
	//
	
	
	
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_results\"]")
	public @Getter WebElement bttmSheetResult;
	
	//=============
	@FindBy(xpath="//android.widget.TextView[@text=\"Point On Map\"]")
	public @Getter WebElement aftrChooseMapPOMHeaderTxt; //
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/choose_location_button\"]")
	public @Getter WebElement pomDoneBtn; // Choose On Map
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement pomBackBtn;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/point_on_map_address_txt\"]")
	public @Getter WebElement pomAddrssTxt;
	
	
	
	//
	

	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/cat_icon_imageview\"])[4]")
	public @Getter WebElement moreBtn;
	
	@FindBy(id="com.mmi.maps:id/cat_grid_view")
	public @Getter WebElement suggestionListView;

	@FindBy(id="com.mmi.maps:id/poi_list")
	public @Getter WebElement suggestionListViewVRFY;

	//for search
	@FindBy(id="com.mmi.maps:id/search_input_what")
	public @Getter WebElement searchInput;
	
	@FindBy(id="com.mmi.maps:id/suggestion_listView")
	public @Getter WebElement sListViewSearchInput;
	
	@FindBy(id="com.mmi.maps:id/image_view_edit")
	public @Getter WebElement editIcon;
//
//	
//	@FindBy(id="com.mmi.maps:id/poi_list")
//	public @Getter WebElement suggestionListViewVRFY;

	@FindBy(id="com.mmi.maps:id/auto_list_icon")
	public @Getter WebElement crrntLocation;
	
	@FindBy(id="com.mmi.maps:id/image_view_edit")
	public @Getter WebElement chooseMap;
	
	
	//===================
	@FindAll({@FindBy(id="com.mmi.maps:id/cat_name_textview") }) 
	public @Getter List<WebElement> catListTxt;
	
	@FindAll({@FindBy(id = "com.mmi.maps:id/text_view_item")})
	public @Getter List<WebElement> evFilters;
	
	
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input_what\"]")
	public @Getter WebElement searchBarTxt;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_search\"]")
	public @Getter WebElement catClickHeaderTxt;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_back\"]")
	public @Getter WebElement catClickBackIcon;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_results\"]")
	public @Getter WebElement evRsltCount;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/reset\"]")
	public @Getter WebElement resetBtn;


//	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/cat_icon_imageview\"])[4]")
//	public @Getter WebElement moreBtn;		

   


}
