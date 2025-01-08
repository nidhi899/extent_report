package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__017_NavigationPage extends BasePage {

	public TC__017_NavigationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.mmi.maps:id/fragment_home_direction")
	public @Getter WebElement homeDirection;

	@FindBy(id = "com.mmi.maps:id/direction_content_simple_layout")
	public @Getter WebElement ln;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Your current location\"]")
	public @Getter WebElement yrcurLoc;

	@FindBy(id = "com.mmi.maps:id/direction_stop_action")
	public @Getter WebElement actionDots;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Choose On Map\"]")
	public @Getter WebElement chooseOnMap;

	@FindBy(id = "com.mmi.maps:id/bottom_view")
	public @Getter WebElement bottomView;

	@FindBy(id = "com.mmi.maps:id/point_on_map_address_txt")
	public @Getter WebElement addChosenOnMap;

	@FindBy(id = "com.mmi.maps:id/choose_location_button")
	public @Getter WebElement doneBtn;

	@FindBy(id = "com.mmi.maps:id/direction_bottom_sheet")
	public @Getter WebElement directionBtmSht;

	@FindBy(id = "com.mmi.maps:id/direction_time_text_view")
	public @Getter WebElement directionTime;

	@FindBy(id = "com.mmi.maps:id/imageView_info")
	public @Getter WebElement directionSummary;

	@FindBy(id = "com.mmi.maps:id/imageViewClose")
	public @Getter WebElement closeBtn;

	@FindBy(id = "com.mmi.maps:id/direction_distance_text_view")
	public @Getter WebElement distance;

	@FindBy(id = "com.mmi.maps:id/direction_eta_text_view")
	public @Getter WebElement estArrivalTime;

	@FindBy(id = "com.mmi.maps:id/show_on_map_textView")
	public @Getter WebElement showOnMapBtn;

	@FindBy(id = "com.mmi.maps:id/directions_adivices_list_view")
	public @Getter WebElement directnAdviceList;

	@FindBy(id = "com.mmi.maps:id/direction_preview_text")
	public @Getter WebElement directionPText;

	@FindBy(id = "com.mmi.maps:id/direction_preview_dist")
	public @Getter WebElement directionPDist;

	@FindBy(id = "com.mmi.maps:id/btn_prev_down")
	public @Getter WebElement BtnPrevious;

	@FindBy(id = "com.mmi.maps:id/btn_next_up")
	public @Getter WebElement BtnNext;

	@FindBy(className = "android.widget.ImageButton")
	public @Getter WebElement pageBack;

	@FindBy(id ="com.mmi.maps:id/start_layout")
	public @Getter WebElement startBtn;
	
	@FindBy(id="com.mmi.maps:id/start_button")
	public @Getter WebElement startBTnText;

	@FindBy(id = "com.mmi.maps:id/strip_item_container")
	public @Getter WebElement stripContainer;

	@FindBy(id = "com.mmi.maps:id/navigation_strip_left_image_button")
	public @Getter WebElement stripLeft;

	@FindBy(id = "com.mmi.maps:id/navigation_strip_right_image_button")
	public @Getter WebElement stripRight;

	@FindBy(id = "com.mmi.maps:id/navigation_strip_dist")
	public @Getter WebElement stripDistance;

	@FindBy(id = "com.mmi.maps:id/navigation_strip_text")
	public @Getter WebElement stripText;

	@FindBy(id = "com.mmi.maps:id/directions_back_button")
	public @Getter WebElement directionBack;

	@FindBy(id = "com.mmi.maps:id/directions_get_route_button")
	public @Getter WebElement getRouteBtn;

	@FindBy(id = "com.mmi.maps:id/direction_error_text_view")
	public @Getter WebElement directionError;

	@FindBy(id = "com.mmi.maps:id/direction_stop_action")
	public @Getter WebElement stopAction;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Add stop\"]")
	public @Getter WebElement addStop;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_stop_label\" and @text=\"Select location\"]")
	public @Getter WebElement enterStopLocation;

	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/direction_stop_action\"])[2]")
	public @Getter WebElement reverseLocation;

	@FindBy(id = "com.mmi.maps:id/tab_layout")
	public @Getter WebElement tablyn;

	@FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]")
	public @Getter WebElement modecar;

	@FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]")
	public @Getter WebElement modebike;

	@FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[3]")
	public @Getter WebElement modetruck;

	@FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id=\"com.mmi.maps:id/tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]")
	public @Getter WebElement modewalk;

	@FindBy(id = "com.mmi.maps:id/searchButton")
	public @Getter WebElement srchIcon;

	@FindBy(id = "com.mmi.maps:id/add_stop_constraint_layout")
	public @Getter WebElement addContainer;

	@FindBy(id = "com.mmi.maps:id/startNewRouteTextView")
	public @Getter WebElement startNewRoute;

	@FindBy(id = "com.mmi.maps:id/addWayPointTextView")
	public @Getter WebElement addWayPoint;

	@FindBy(id = "com.mmi.maps:id/reportFab")
	public @Getter WebElement postIcn;

	@FindBy(id = "com.mmi.maps:id/report_category_container")
	public @Getter WebElement reportcategoryCont;

	@FindBy(id = "com.mmi.maps:id/text_view_parent_name")
	public @Getter WebElement pomCategory;

	@FindBy(id = "com.mmi.maps:id/category_recyclerview")
	public @Getter WebElement catRview;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/category_recyclerview\"]/android.view.ViewGroup[1]")
	public @Getter WebElement jam;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Light\"]")
	public @Getter WebElement light;

	@FindBy(id = "com.mmi.maps:id/add_place_title")
	public @Getter WebElement titleText;

	@FindBy(id = "com.mmi.maps:id/address_textView")
	public @Getter WebElement addressText;

	@FindBy(id = "com.mmi.maps:id/distance_textView")
	public @Getter WebElement disttext;

	// controlledbtmsheet
	@FindBy(id = "com.mmi.maps:id/bottom_sheet_controller_button")
	public @Getter WebElement bottomSheetControllerBtn;

	@FindBy(id = "com.mmi.maps:id/bottomView")
	public @Getter WebElement bottomViewStart;

	@FindBy(id = "com.mmi.maps:id/bottom_sheet_controller_close_navigation")
	public @Getter WebElement bottomSheetControllerClose;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Save Route\"]")
	public @Getter WebElement saveRouteBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Traffic: On\"]")
	public @Getter WebElement trafficOnBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Traffic: Off\"]")
	public @Getter WebElement trafficOffBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Direction List\"]")
	public @Getter WebElement directionlistBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Night Mode\"]")
	public @Getter WebElement nightModeBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Day Mode\"]")
	public @Getter WebElement dayModeBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Hybrid Satellite Map\"]")
	public @Getter WebElement hybridMapBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Mappls\"]")
	public @Getter WebElement MapplsMapBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Settings\"]")
	public @Getter WebElement settingsBtn;

	/// toggles
	@FindBy(id = "com.mmi.maps:id/switch_enable_current_speed_limit")
	public @Getter WebElement showCurrentSpeedToggle;

	@FindBy(id = "com.mmi.maps:id/text_view_show_current_speed_limit")
	public @Getter WebElement showCurrentTitle;

	@FindBy(id = "com.mmi.maps:id/text_view_current_speed_limit_description")
	public @Getter WebElement showCurrentSubtitle;

	@FindBy(id = "com.mmi.maps:id/switch_enable_over_speeding_alarm")
	public @Getter WebElement OverSpeedingAlarmToggle;

	@FindBy(id = "com.mmi.maps:id/text_view_over_speeding_alarm")
	public @Getter WebElement OverSpeedingTitle;

	@FindBy(id = "com.mmi.maps:id/text_view_over_speeding_set_limit")
	public @Getter WebElement OverSpeedingSubtitle;

	@FindBy(id = "com.mmi.maps:id/switch_enable_lane_guidance")
	public @Getter WebElement LaneGuidanceToggle;

	@FindBy(id = "com.mmi.maps:id/text_view_lane_guidance")
	public @Getter WebElement LaneGuidanceTitle;

	@FindBy(id = "com.mmi.maps:id/text_view_lane_guidance_description")
	public @Getter WebElement LaneGuidanceSubtitles;

	@FindBy(id = "com.mmi.maps:id/switch_enable_junction_view")
	public @Getter WebElement JunctionViewToggle;

	@FindBy(id = "com.mmi.maps:id/text_view_junction_view")
	public @Getter WebElement JunctionViewTitle;

	@FindBy(id = "com.mmi.maps:id/text_view_junction_view_description")
	public @Getter WebElement JunctionViewSubtitles;

	@FindBy(id = "com.mmi.maps:id/md_titleFrame")
	public @Getter WebElement setRouteNameBox;

	@FindBy(id = "com.mmi.maps:id/md_title")
	public @Getter WebElement setRouteNameBoxTitle;

	@FindBy(id = "android:id/input")
	public @Getter WebElement setRouteName;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")
	public @Getter WebElement setRouteNameSave;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/save_offline_textview\"]")
	public @Getter WebElement showOnMapDirectionList;

	///////////////////// for validating save route 
	
	@FindBy(id = "com.mmi.maps:id/bottom_sheet_controller_close_navigation")
	public @Getter WebElement closeBtmSheethavingController;
	
	@FindBy(className = "android.widget.ImageButton")
	public @Getter WebElement directionRoutepageBack;
	//hamburger menu
	//menu
	//saves 
	@FindBy(id = "com.mmi.maps:id/container_contributions")
	public @Getter WebElement savesContainerInProfile;
	//
	
	@FindBy(id = "com.mmi.maps:id/bottom_sheet_quick_access_home_title")
	public @Getter WebElement homeTitle;
	
	@FindBy(id = "com.mmi.maps:id/bottom_sheet_quick_access_work_title")
	public @Getter WebElement WorkTitle;
	
	
	@FindBy(id="com.mmi.maps:id/maptype_layer_button")
	public @Getter WebElement mapLayerbtn;
	
//	@FindBy(id="com.mmi.maps:id/imageView_info")
//	public @Getter WebElement routeinfo;
	
	@FindBy(id="com.mmi.maps:id/textViewRouteSummary")
	public @Getter WebElement textViewRouteSummary;
	
	@FindBy(id="com.mmi.maps:id/route_info_image_view")
	public @Getter WebElement route_info_image_view;
	
	@FindBy(id="com.mmi.maps:id/imageViewClose")
	public @Getter WebElement imageViewClose;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/imageView_info\"]")
	public @Getter WebElement routeinfo;
}
