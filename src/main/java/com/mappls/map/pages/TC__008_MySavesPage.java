package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__008_MySavesPage {

	public TC__008_MySavesPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"My Saves\"]")
	public @Getter WebElement mySavesHambrgrMenu;

	@FindAll({@FindBy(id="com.mmi.maps:id/home_address_text_view") }) 
	public @Getter List<WebElement> mySavesListText;

	@FindBy(id="android:id/button1")
	public @Getter WebElement loginBTNMsg;

	@FindBy(xpath="(//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/relative_layout\"])[1]")
	public @Getter WebElement homeList;

	@FindBy(xpath="(//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/relative_layout\"])[2]")
	public @Getter WebElement workList;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Edit\"]") 
	public @Getter WebElement edit; 

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Delete\"]")
	public @Getter WebElement dltAddress;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement cnfmDlt;

	//contribution
	@FindAll({@FindBy(id = "com.mmi.maps:id/list_details_image_view")}) 
	public @Getter List<WebElement> contributionList;

	@FindAll({@FindBy(id = "com.mmi.maps:id/list_details_more_image_view")})
	public @Getter List<WebElement> favList;

	@FindAll({@FindBy(id = "com.mmi.maps:id/main_layout")})
	public @Getter List<WebElement> addFavListLayOut;

	@FindBy(id="com.mmi.maps:id/report_details_user_name")
	public @Getter WebElement favBtmClick;

	@FindBy(id="com.mmi.maps:id/bottom_place_head")
	public @Getter WebElement favBtmDirection;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Save\"]")
	public @Getter WebElement favSaveBtn;

	@FindBy(id="com.mmi.maps:id/add_image_view")
	public @Getter WebElement favSaveBtnImg;

	@FindBy(id="com.mmi.maps:id/place_count_text_view")
	public @Getter WebElement favGetCount;

	@FindBy(id="com.mmi.maps:id/title")
	public @Getter WebElement favDlte;

	//	@FindBy(id="com.mmi.maps:id/report_details_user_name")
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement favConfrmDlte;

	@FindBy(id="android:id/button2")
	public @Getter WebElement favCancelDlte;

	@FindBy(id="com.mmi.maps:id/text_view_create_list")
	public @Getter WebElement createListBTN;

	@FindBy(id="com.mmi.maps:id/name_edit_text")
	public @Getter WebElement enterTitle;

	@FindBy(id="com.mmi.maps:id/drop_down_image")
	public @Getter WebElement dropDownClick;

	@FindBy(id="com.mmi.maps:id/public_text")
	public @Getter WebElement publically;

	@FindBy(id="com.mmi.maps:id/private_text")
	public @Getter WebElement privately;	

	@FindBy(id="com.mmi.maps:id/btn_create")
	public @Getter WebElement okBTN;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/msg_txt\"]")
	public @Getter WebElement listCreatingError;

	//	//poin on map
	@FindBy(id="com.mmi.maps:id/fragment_dropped_pin_place_title")
	public @Getter WebElement pmap;

	@FindBy(id="com.mmi.maps:id/fragment_dropped_pin_action_share")
	public @Getter WebElement shareBTN;

	@FindBy(id = "android:id/text1")
	public @Getter WebElement copyLink;

	@FindBy(id = "com.mmi.maps:id/fragment_dropped_pin_action_save")
	public @Getter WebElement saveBTN;

	@FindBy(id = "android:id/input")
	public @Getter WebElement enterLabel;


	@FindBy(id = "com.mmi.maps:id/md_buttonDefaultPositive")
	public @Getter WebElement doneLabelBTN;

	@FindBy(id = "android:id/text")
	public @Getter WebElement copiedBtn;

	@FindAll({@FindBy(id="com.mmi.maps:id/auto_list_item") }) 
	public @Getter List<WebElement> suggestionPlcList;

	@FindBy(id = "com.mmi.maps:id/check_box_review")
	public @Getter WebElement reviewbtn;




	//    ==========================
	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/suggestion_listView\"]")
	public @Getter WebElement sgtnLstContainer;

	@FindAll({@FindBy(className="android.view.ViewGroup") }) 
	public @Getter List<WebElement> sugstnLst;

	//new test cases

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	public @Getter WebElement msCancel;



	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement msLogin;


	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_title\"]")
	public @Getter WebElement msLoginWelcomePage;

	@FindAll({@FindBy(id=" com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> msLists;

	//    ===
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_title\"]")
	public @Getter WebElement msHeading;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_title\"]")
	public @Getter WebElement msBackBTN;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_title\"]")
	public @Getter WebElement msLoginWelcomePajge;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Your current location\"]")
	public @Getter WebElement currentLocation;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Choose On Map\"]")
	public @Getter WebElement chooseMap;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/point_on_map_address_txt\"]")
	public @Getter WebElement pointMapAdrs;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.mmi.maps:id/choose_location_button\"]")
	public @Getter WebElement ChooseMapDoneBtn;

	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> msCreatedLists;




	//    ==========
	@FindBy(xpath="//android.widget.TextView[@text=\"My Saves\"]")
	public @Getter WebElement msHeader;

	@FindAll({@FindBy(id="com.mmi.maps:id/relative_layout") }) 
	public @Getter List<WebElement> relativeLO;

	@FindAll({@FindBy(id="com.mmi.maps:id/btn_layout") }) 
	public @Getter List<WebElement> creatdListsThreeDt;

	//    @FindAll({@FindBy(id="com.mmi.maps:id/btn_layout") }) 
	//    public @Getter List<WebElement> creatdListsThreeDt;


	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> msList;


	@FindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/strip_layout\"]")
	public @Getter WebElement msBottomSheetIsVisisble;

	@FindAll({@FindBy(id="com.mmi.maps:id/btn_layout") }) 
	public @Getter List<WebElement> plcResults;


	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Save\"]")
	public @Getter WebElement saveIcon;

	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	public @Getter WebElement saveToFavList;



	//    ===========================nov
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement backBtnIcon;

	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> msTxtView;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/public_text\"]")
	public @Getter WebElement isPublicDisplay;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/private_text\"]")
	public @Getter WebElement isPrivateDisplay;

	//    @FindAll({@FindBy(id="(//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/my_saves_overflow_btn\"])[1]") }) 
	//    public @Getter List<WebElement> routMoreBtn;



	//route edit

	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> routeTxt;

	//    @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/private_text\"]")
	//    public @Getter WebElement routMoreBtn;

	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_overflow_btn") }) 
	public @Getter List<WebElement> routMoreBtn;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Rename\"]")
	public @Getter WebElement reName;

	@FindBy(xpath="//android.widget.EditText[@resource-id=\"android:id/input\"]")
	public @Getter WebElement enterRoutName;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")
	public @Getter WebElement okBtnRoute;





	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/search_clear_btn\"]")
	public @Getter WebElement searchClearBtn;


	@FindBy(id="com.mmi.maps:id/search_icon")
	public @Getter WebElement searchIcon;


	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/search_input\"]")
	public @Getter WebElement searchInput;
	//android.widget.TextView[@resource-id="com.mmi.maps:id/public_text"]



	//place detail my saves


	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Save\"]")
	public @Getter WebElement plcDetailMySave;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_results\"]")
	public @Getter WebElement rsltFound;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/create_list_text_view\"]")
	public @Getter WebElement createListFrmPlcDetail;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_heading\"]")
	public @Getter WebElement listHeader;



	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> createListFrmPlcDetailVerfctn;



	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_list_textview\"]")
	public @Getter WebElement directionPage;


	//fav list from place detail page
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_title_text_view\" and @text=\"Favourites\"]")
	public @Getter WebElement isFavVisible;


	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_count_text_view\" and contains(@text, 'Places')]")
	public @Getter WebElement getPlcCountFrmPlcDetailPage;

	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	public @Getter WebElement favClickAddIconPlcDetail;

	@FindBy(xpath="//android.widget.TextView[@text=\"Directions\"]")
	public @Getter WebElement isDirectionBtn;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/collapsed_toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement directionBackClick;


	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement bttmPlcBackIcon;

	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input\"]")
	public @Getter WebElement getFavTxtFrmPlcDetailPage;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_direction\"]")
	public @Getter WebElement homeScreenNavigation;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/directions_top_view\"]")
	public @Getter WebElement drctionTopView;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_stop_label\" and @text=\"Select location\"]")
	public @Getter WebElement enterAddrss;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_list_textview\"]")
	public @Getter WebElement btmDirection;

	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/start_layout\"]")
	public @Getter WebElement startClick;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/navigationLayout\"]")
	public @Getter WebElement navigationLayOut;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/nav_bottom_sheet_text\" and @text=\"Save Route\"]")
	public @Getter WebElement isRouteSavedIcon;

	@FindBy(xpath="//android.widget.TextView[@text=\"My Routes\"]")
	public @Getter WebElement routeHeader;

	@FindBy(xpath="//android.widget.EditText[@resource-id=\"android:id/input\"]")
	public @Getter WebElement enterRouteName;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")
	public @Getter WebElement saveRoutBtn;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/directions_back_button\"]")
	public @Getter WebElement drctnBackBtn;

	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/bottom_sheet_controller_button\"]")
	public @Getter WebElement btmSheetController;

	////=================================
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_dismiss\"]")
	public @Getter WebElement favDismissBtn;

	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement dirctnBottmSheetBackClick;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text\"]")
	public @Getter WebElement startingNavigationMenuWindow;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	//@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/add_image_view\"])[1]")
	//public @Getter WebElement favAddPlcDetail;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/snackbar_text\"]")
	public @Getter WebElement routeDltMsg;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement routeConfirmDltWindow;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Delete\"]")
	public @Getter WebElement routeDltClick;

	//@FindBy(xpath="(//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/my_saves_overflow_btn\"])[1]")
	//public @Getter WebElement routesDlt;

	@FindBy(xpath="//android.widget.TextView[@text=\"My Routes\"]")
	public @Getter WebElement routesHeader;

	@FindAll({@FindBy(id="com.mmi.maps:id/list_details_pin_name") }) 
	public @Getter List<WebElement> pointMapAllLists;


	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_overflow_btn") }) 
	public @Getter List<WebElement> routMoreBtnClick;


	@FindAll({@FindBy(id="com.mmi.maps:id/my_saves_text_view") }) 
	public @Getter List<WebElement> routeListSize;

	//==========================
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_create_list\"]")
	public @Getter WebElement msCreateListTxt;
	
	
	
	@FindAll({@FindBy(id="com.mmi.maps:id/list_title_text_view") }) 
	public @Getter List<WebElement> cstmListInPlcDetailPage;


	@FindAll({@FindBy(id="com.mmi.maps:id/item_world_view_status_text_view") }) 
	public @Getter List<WebElement> contributionStatus;
	
}

