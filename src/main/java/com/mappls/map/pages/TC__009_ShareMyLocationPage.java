package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__009_ShareMyLocationPage {

	public TC__009_ShareMyLocationPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/linear_layout_1\"])[1]")
	public @Getter WebElement fixMap;
	
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/linear_layout_2\"])[1]")
	public @Getter WebElement postOnMap;
	
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/linear_layout_1\"])[2]")
	public @Getter WebElement viewPostedEvents;
	                //android.widget.Button[@resource-id="com.mmi.maps:id/button_share_location"]
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/linear_layout_2\"])[2]")
	public @Getter WebElement shareLocation;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/recycler_view_banner\"]/android.widget.LinearLayout[3]")
	public @Getter WebElement getPin;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/constraint_layout_home\"]")
	public @Getter WebElement homeClick;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/constraint_layout_work\"]")
	public @Getter WebElement workclick;
	
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/linear_layout_with_share_location_and_view_reported\"]/android.widget.LinearLayout[2]")
	public @Getter WebElement culturalClick;
	
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/bottom_sheet_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]")
	public @Getter WebElement navisorClick;	
	
//	@FindAll({@FindBy(className = "android.view.ViewGroup")})
//    public List<WebElement> postMapSelCategory;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Anything\"]")
	public WebElement postMapSelCategory;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"an update\"]")
	public @Getter WebElement anUpdateClick;
	
	@FindBy(id="com.mmi.maps:id/done_report_button")
	public @Getter WebElement postButtonClick;
	
	
	@FindBy(id="com.mmi.maps:id/location")
	public @Getter WebElement postLocation;
	
	
	
	@FindBy(id="com.mmi.maps:id/point_on_map_address_txt")
	public @Getter WebElement pointOnMapAddressText;
	
	@FindBy(id="com.mmi.maps:id/choose_location_button")
	public @Getter WebElement locationDoneBTN;
	
	
	@FindBy(id="com.mmi.maps:id/marker_image_view")
	public @Getter WebElement marker;
	
	@FindBy(id="com.mmi.maps:id/shareBtn")
	public @Getter WebElement sharePostedLocation;
	
	@FindBy(id="com.mmi.maps:id/dismissBtn")
	public @Getter WebElement afterPostcontinueBtn;
	
	@FindBy(id="com.mmi.maps:id/viewBtn")
	public @Getter WebElement viewPost;
	
	@FindBy(id="com.mmi.maps:id/report_details_reported_date")
	public @Getter WebElement postedTime;
	
	@FindBy(id="com.mmi.maps:id/item_world_view_action_like_txt")
	public @Getter WebElement helpFulButton;
	
	@FindBy(id="com.mmi.maps:id/item_world_view_action_share_txt")
	public @Getter WebElement shareBTtnAgain;
	
	
	@FindBy(id="com.mmi.maps:id/helpful_text")
	public @Getter WebElement helpFulLike;
	
	
	@FindBy(id="com.mmi.maps:id/comment_text_view")
	public @Getter WebElement descClick;
	
	@FindBy(id="com.mmi.maps:id/comment_edit_text")
	public @Getter WebElement writeDesc;
	
	@FindBy(id="com.mmi.maps:id/report_done")
	public @Getter WebElement writeDescDoneBtn;
	
	
	
	@FindBy(id="com.mmi.maps:id/report_details_issue_desc")
	public @Getter WebElement descViewPost;
	
	
	@FindBy(id="com.mmi.maps:id/add_image_text")
	public @Getter WebElement addImage;
	
	
	@FindBy(id="com.mmi.maps:id/image_view_title")
	public @Getter WebElement imageTitle;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public @Getter WebElement imagePermission;
	
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public @Getter WebElement audioPermission;
	
	
	
	@FindBy(id="com.mmi.maps:id/image_view_take_picture")
	public @Getter WebElement takePicure;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_all_button")
	public @Getter WebElement allowall;
	
	
	
	
	
	
	@FindBy(id="com.mmi.maps:id/add_image_layout")
	public @Getter WebElement imLOut;
	
	@FindBy(id="com.mmi.maps:id/item_collage_image1")
	public @Getter WebElement adedImgVrfctn;
	
	@FindBy(id="com.mmi.maps:id/hide_my_name_check_box")
	public @Getter WebElement hideName;
	
	@FindBy(xpath="//android.widget.Button[@content-desc=\"Search\"]")
	public @Getter WebElement searchIcn;
	
	
	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement searchInput;
	
	
	@FindBy(id = "com.mmi.maps:id/suggestion_listView" )
	public @Getter WebElement suggestionList;
	
	@FindAll ({ @FindBy(id="com.mmi.maps:id/auto_list_icon")} )
	public @Getter List<WebElement> viewDistance;
	
	@FindAll ({ @FindBy(id="com.mmi.maps:id/auto_list_item")} )
	public @Getter List<WebElement> location;
	
	@FindAll ({ @FindBy(id="com.mmi.maps:id/auto_list_item_address")} )
	public @Getter List<WebElement> address;
	
//	==================Fix MAP============================
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/parent_category_recyclerview\"]/android.view.ViewGroup")
	public @Getter WebElement fixMapSelCat;
	
	@FindAll ({ @FindBy(id="com.mmi.maps:id/category_name")} )
	public @Getter List<WebElement> fixMapList;
	
	
//	view posted events==============
	@FindAll ({ @FindBy(id="com.mmi.maps:id/category_name")} )
	public @Getter List<WebElement> viewPostedEventsList;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/item_filter_menu_txt\" and @text=\"Sort\"]")
	public @Getter WebElement sortEvents;
	
	@FindBy(id="com.mmi.maps:id/search_filter")
	public @Getter WebElement searchFilter;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/item_filter_options_txt\" and @text=\"Newest\"]")
	public @Getter WebElement newest;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/item_filter_options_txt\" and @text=\"Oldest\"]")
	public @Getter WebElement oldest;
	
	
	@FindBy(id="com.mmi.maps:id/filter_apply_btn")
	public @Getter WebElement applyBTN;
	
	@FindBy(id="com.mmi.maps:id/filter_clear_btn")
	public @Getter WebElement clearAllBTN;
	
	@FindAll({ @FindBy(id="com.mmi.maps:id/item_date")})
	public @Getter List<WebElement> date;
	
//	share location
	@FindBy(id="com.mmi.maps:id/button_share_location")
	public @Getter WebElement shareLocationButon;
	
	@FindBy(id="com.mmi.maps:id/md_buttonDefaultPositive")
	public @Getter WebElement continueBtn;
	
	@FindBy(id="com.mmi.maps:id/textView_8_hour")
	public @Getter WebElement select8HourDuration;
	
	@FindBy(id="com.mmi.maps:id/button_select_contacts")
	public @Getter WebElement selectContactBtn;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public @Getter WebElement allowPermsn;
	
	
	@FindAll({ @FindBy(id="com.mmi.maps:id/ci_name_tv")})
	public @Getter List<WebElement> contactList;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/contact_explanation_text_view\"]")
	public @Getter WebElement contactListSend;
	
	@FindBy(id="com.mmi.maps:id/menu_done")
	public @Getter WebElement sendButton;
	
	@FindBy(id="com.mmi.maps:id/text_view_get_eloc")
	public @Getter WebElement pinVisibility;
	
	
//	set home address 
	@FindBy(id="com.mmi.maps:id/bottom_sheet_quick_access_home_duration")
	public @Getter WebElement homeAdrsAvailble;
	
	@FindBy(xpath="//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]")
	public @Getter WebElement fourWheeler;
	
	
	@FindBy(xpath="//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]")
	public @Getter WebElement twoWheeler;
	
	
	@FindBy(xpath="//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ImageView")
	public @Getter WebElement cab;
	
	
	@FindBy(xpath="//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.ImageView")
	public @Getter WebElement walking;
	
	
	@FindBy(id="com.mmi.maps:id/direction_time_text_view")
	public @Getter WebElement directionTime;
	
	@FindBy(id="com.mmi.maps:id/direction_distance_text_view")
	public @Getter WebElement directionDistance;
	
	@FindBy(id="com.mmi.maps:id/direction_eta_text_view")
	public @Getter WebElement arrivalTime;
	
	
	@FindBy(id="com.mmi.maps:id/bottom_sheet_quick_access_work_duration")
	public @Getter WebElement workAdrsAvailble;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"My Saves\"]")
	public @Getter WebElement mySavesHambrgrMenu;
	
	
	@FindBy(xpath="//android.widget.ImageButton")
	public @Getter WebElement postedPageCloseIcon;
	
	@FindBy(id="com.mmi.maps:id/text_view_title")
	public @Getter WebElement qcPageIsVisible;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/fragment_home_screen_toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement homePage;
	
	@FindBy(id="com.mmi.maps:id/image_view_back")
	public @Getter WebElement qcArrowButton;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/recycler_view_banner\"]/android.widget.LinearLayout[4]")
	public @Getter WebElement homeSectionVisble;
	
	@FindAll({@FindBy(id="com.mmi.maps:id/auto_list_item") }) 
	public @Getter List<WebElement> suggestionPlcList;
	
//	================
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/suggestion_listView\"]")
	public @Getter WebElement sgtnLstContainer;

	@FindAll({@FindBy(className="android.view.ViewGroup") }) 
	public @Getter List<WebElement> sugstnLst;

	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\\\"com.mmi.maps:id/auto_list_icon\\\"])[3]")
	public @Getter WebElement indxThree;	
	
	
	//========
	
	@FindBy(id = "com.android.permissioncontroller:id/entity_header_icon")
	public @Getter WebElement mplPrmsn;	
	
	@FindBy(id = "com.android.settings:id/entity_header_icon")
	public @Getter WebElement entityHdr;	
//	
//	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\\\"com.mmi.maps:id/auto_list_icon\\\"])[3]")
//	public @Getter WebElement indxThree;	
	
}