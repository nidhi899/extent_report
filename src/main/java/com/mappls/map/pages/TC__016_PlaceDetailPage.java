package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__016_PlaceDetailPage extends BasePage{
	

	public TC__016_PlaceDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.mmi.maps:id/bottomSheetPlace")
	public @Getter WebElement bottomSheetPlace;

	@FindBy(id = "com.mmi.maps:id/place_layout")
	public @Getter WebElement place_Layout;

	@FindBy(id = "com.mmi.maps:id/bottom_place_head")
	public @Getter WebElement placelayout;

	@FindBy(className = "android.view.ViewGroup")
	public @Getter WebElement viewGrp;

	@FindBy(id = "com.mmi.maps:id/place_name")
	public @Getter WebElement placeName;

	@FindBy(id = "com.mmi.maps:id/place_address")
	public @Getter WebElement placeAdd;

	@FindBy(className = "android.widget.LinearLayout")
	public @Getter WebElement linearLayout;

	@FindBy(id = "com.mmi.maps:id/place_rating_text")
	public @Getter WebElement placeRatingText;

	@FindBy(className = "android.widget.RatingBar")
	public @Getter WebElement ratingBar;

	@FindBy(id = "com.mmi.maps:id/place_reviews_count")
	public @Getter WebElement placeReviewCount;

	@FindBy(id = "com.mmi.maps:id/place_eloc")
	public @Getter WebElement placeMapplsEloc;

	@FindBy(id = "com.mmi.maps:id/place_distance")
	public @Getter WebElement placeDist;
	
	@FindBy(id = "com.mmi.maps:id/place_duration")
	public @Getter WebElement placeTime;

	@FindBy(id = "com.mmi.maps:id/place_directions_button")
	public @Getter WebElement pdetailDirection;

	@FindBy(id = "com.mmi.maps:id/bottom_sheet_container")
	public @Getter WebElement directionBottomSheet;

	@FindBy(id = "com.mmi.maps:id/direction_time_text_view")
	public @Getter WebElement directionSheetTime;

	@FindBy(id = "com.mmi.maps:id/direction_distance_text_view")
	public @Getter WebElement directionSheetDist;

	@FindBy(id = "com.mmi.maps:id/direction_eta_text_view")
	public @Getter WebElement directionSheetETA;

	// QR

	@FindBy(id = "com.mmi.maps:id/qr_text_linear_layout")
	public @Getter WebElement QRdetails;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Get Mappls Pin QR code details\"]")
	public @Getter WebElement QRdetailText;

	@FindBy(className ="android.view.ViewGroup")
	public @Getter WebElement QRLayout;
	
	@FindBy(xpath="//android.view.ViewGroup")
	public @Getter WebElement QRMapplsLayout;

	@FindBy(id = "com.mmi.maps:id/place_name_tag_text_view")
	public @Getter WebElement QRPlace;

	@FindBy(id = "com.mmi.maps:id/pin_url_text_view")
	public @Getter WebElement QRPin;

	@FindBy(id = "com.mmi.maps:id/place_name_text_view")
	public @Getter WebElement qrPlaceName;

	@FindBy(id = "com.mmi.maps:id/place_address_text_view")
	public @Getter WebElement qrPlaceAddress;

	@FindBy(id = "com.mmi.maps:id/pin_explained_text_view")
	public @Getter WebElement AboutPin;
	
	@FindBy(id = "com.mmi.maps:id/contect_text_view")
	public @Getter WebElement qrContact;

	@FindBy(id = "com.mmi.maps:id/ratting_text_view")
	public @Getter WebElement qrRating;

	@FindBy(id = "com.mmi.maps:id/post_text_view")
	public @Getter WebElement qrPost;

	@FindBy(id = "com.mmi.maps:id/image_text_view")
	public @Getter WebElement qrImage;
	@FindBy(id = "com.mmi.maps:id/download_btn")
	public @Getter WebElement downloadBtn;
	
	@FindBy(id="com.mmi.maps:id/share_btn")
	public @Getter WebElement shareBtnQR;
	
	@FindBy(id="android:id/sem_chooser_recycler_ranked_app")
	public @Getter WebElement QrShareBtmDisplay;
	
	@FindBy(id="com.android.intentresolver:id/sem_chooser_main_title")
	public @Getter WebElement QrShareBtmSheet;
	
	// place detail page nearby
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Nearby\"]")
	public @Getter WebElement pdNearby;

	@FindBy(id = "com.mmi.maps:id/category_container")
	public @Getter WebElement pdNearbycont;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/cat_name_textview\" and @text=\"Coffee\"]")
	public @Getter WebElement pdNearbyCoffee;

//	Claim Place 	
	@FindBy(id = "com.mmi.maps:id/button_claim_now")
	public @Getter WebElement claimNow;

	@FindBy(id = "com.mmi.maps:id/text_view_description")
	public @Getter WebElement claimNowDesc;

	@FindBy(id = "com.mmi.maps:id/coordinator_container")
	public @Getter WebElement claimThisplaceCont;

	@FindBy(id = "com.mmi.maps:id/backToMove")
	public @Getter WebElement claimNowBack;

	// handling required login box
	@FindBy(id = "com.mmi.maps:id/parentPanel")
	public @Getter WebElement parentPanel;

	@FindBy(id = "com.mmi.maps:id/text_view_title")
	public @Getter WebElement title;

	@FindBy(id = "com.mmi.maps:id/text_view_description")
	public @Getter WebElement description;

	@FindBy(id = "android:id/button1")
	public @Getter WebElement loginButton;
// share in place detail page

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Share\"]")
	public @Getter WebElement pdpShareBtn;

	@FindBy(id = "android:id/chooser_header")
	public @Getter WebElement btmShtHeader;

	@FindBy(id = "android:id/profile_tabhost")
	public @Getter WebElement btmShtTabHost;

	@FindBy(id = "android:id/content_preview_container")
	public @Getter WebElement btmShtContainer;

	@FindBy(id = "android:id/text1")
	public @Getter WebElement shareText;

	@FindBy(id = "android:id/sem_chooser_chip_button")
	public @Getter WebElement copyBtn;

// review	

	@FindBy(xpath = "(//*[@resource-id='com.mmi.maps:id/poi_action_btn'])[2]")
	public @Getter WebElement pdReview;

	// after review click on add review page
	@FindBy(id = "com.mmi.maps:id/wr_rating_bar")
	public @Getter WebElement arRatingBar;

	@FindBy(id = "com.mmi.maps:id/wr_review_et")
	public @Getter WebElement arExperience;

	@FindBy(id = "com.mmi.maps:id/done")
	public @Getter WebElement arDone;

	// save

	@FindBy(xpath = "(//*[@resource-id='com.mmi.maps:id/poi_action_btn'])[4]")
	public @Getter WebElement pdSave;

	@FindBy(id = "com.mmi.maps:id/design_bottom_sheet")
	public @Getter WebElement saveListBtmsht;

	@FindBy(id = "com.mmi.maps:id/create_list_text_view")
	public @Getter WebElement createNewListBtn;

	@FindBy(className = "android.widget.RelativeLayout")
	public @Getter WebElement relLayout;

	@FindBy(id = "com.mmi.maps:id/text_view_heading")
	public @Getter WebElement textHeading;

	@FindBy(id = "com.mmi.maps:id/name_edit_text")
	public @Getter WebElement editText;

	@FindBy(id = "com.mmi.maps:id/btn_create")
	public @Getter WebElement okBtn;

	@FindBy(id = "com.mmi.maps:id/msg_txt")
	public @Getter WebElement msgText;
	/// List created successfully

	@FindBy(id = "com.mmi.maps:id/text_view_snackbar_msg")
	public @Getter WebElement listCreationSnackBar;

	@FindBy(id = "com.mmi.maps:id/text_view_dismiss")
	public @Getter WebElement dismissBtn;

	/// post

	@FindBy(xpath = "(//*[@resource-id='com.mmi.maps:id/poi_action_btn'])[5]")
	public @Getter WebElement pdPost;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/content\"]/android.view.ViewGroup/android.view.ViewGroup")
	public @Getter WebElement postOnMapBtmSht;

	@FindBy(id = "com.mmi.maps:id/parent_category_recyclerview")
	public @Getter WebElement categorylayout;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Anything\"]")
	public @Getter WebElement anything;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"an update\"]")
	public @Getter WebElement anupdate;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/sub_category_recyclerview\"]/android.view.ViewGroup")
	public @Getter WebElement anupdateType;

	@FindBy(id = "com.mmi.maps:id/add_comment_issue_layout")
	public @Getter WebElement addDesc;

	@FindBy(id = "com.mmi.maps:id/comment_edit_text")
	public @Getter WebElement commentEdit;

	@FindBy(id = "com.mmi.maps:id/report_done")
	public @Getter WebElement cmntDone;

	@FindBy(id = "com.mmi.maps:id/done_report_button")
	public @Getter WebElement innerPostBtn;

	// for Posted Successfully
	@FindBy(className ="android.view.ViewGroup")
	public @Getter WebElement postedView;

	@FindBy(id = "com.mmi.maps:id/content")
	public @Getter WebElement postedContent;

	@FindBy(id = "com.mmi.maps:id/title")
	public @Getter WebElement titleMsg;

	@FindBy(id = "com.mmi.maps:id/subTitle")
	public @Getter WebElement subTitleMsg;
	
	@FindBy(id="com.mmi.maps:id/viewBtn")
	public @Getter WebElement viewPostBtn;

	@FindBy(id = "com.mmi.maps:id/shareBtn")
	public @Getter WebElement sharebtnPosted;

	@FindBy(id = "com.mmi.maps:id/dismissBtn")
	public @Getter WebElement continuePosted;

	// post successful verification
	@FindBy(id="com.mmi.maps:id/report_details_container")
	public @Getter WebElement reportContainer;
	
	@FindBy(id="com.mmi.maps:id/report_details_user_name")
	public @Getter WebElement reportdetailname;
	
	@FindBy(id="com.mmi.maps:id/report_details_reported_date")
	public @Getter WebElement reportdetaildate;
	
	
	//set as home set as work
	@FindBy(id="com.mmi.maps:id/collapsed_toolbar_overflow")
	public @Getter WebElement searchandsettingToolbar;
	
	@FindBy(id="com.mmi.maps:id/overflow_image_button")
	public @Getter WebElement settingsDots;
	
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/content\"])[1]")
	public @Getter WebElement setashome;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Set as Home\"]")
	public @Getter WebElement homeTitle;
	
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/content\"])[2]")
	public @Getter WebElement setaswork;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\" and @text=\"Set as Work\"]")
	public @Getter WebElement workTitle;
	
	@FindBy(id="com.mmi.maps:id/checkbox")
	public @Getter WebElement checkbox;
	
	@FindBy(xpath="(//android.widget.CheckBox[@resource-id=\"com.mmi.maps:id/checkbox\"])[1]")
	public @Getter WebElement homecheckbox;
	
	@FindBy(xpath="(//android.widget.CheckBox[@resource-id=\"com.mmi.maps:id/checkbox\"])[2]")
	public @Getter WebElement workCheckBox;
	
	@FindBy(xpath ="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/directions_back_button\"]")
	public @Getter WebElement backBtn;
	
	@FindBy(className="android.widget.ImageButton")
	public @Getter WebElement BackBtn;
	
	@FindBy(id="com.mmi.maps:id/snackbar_text")
	public @Getter WebElement snackBarText;
	
	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement searchInput;
	
	@FindBy(id="com.mmi.maps:id/card_view_missing_place")
	public @Getter WebElement addAMissingPlaceCard;
	
	@FindBy(id="com.mmi.maps:id/fragment_poi_result_missing_place_sub_title")
	public @Getter WebElement addAMissingPlace;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_select_category\"]")
	public @Getter WebElement subCategory;
	
	@FindBy(id="ccom.mmi.maps:id/parent_category_recyclerview")
	public @Getter WebElement subCatRecyclerView;
	
	@FindBy(className="android.view.ViewGroup")
	public @Getter WebElement subCatViewGrp;
	
	//android.widget.TextView
	@FindBy(id="com.mmi.maps:id/category_name")
	public @Getter WebElement subCatTextView;
	
	/// Anything ,Swachh Bharat, Traffic ,Safety, Vijayawada Flood Relief, Emergency Response, Traffic Violation, Clean Air Revolution ,Community ,Road Condition
//Polluting Activity, Fit India, UNICEF School Closure,Map
	
	@FindBy(id="com.mmi.maps:id/report_category_container")
	public @Getter WebElement repostSubCatCont;
		
	@FindBy(id="com.mmi.maps:id/text_view_parent_name")
	public @Getter WebElement subCatParentName ;
		
	@FindBy(id="com.mmi.maps:id/category_recyclerview")
	public @Getter WebElement reportCatRecycleriew;
		
	@FindBy(className="android.view.ViewGroup")
	public @Getter WebElement reportVG;
		
	@FindBy(className="android.widget.TextView")
	public @Getter WebElement reportTV;
	
	///for private list 
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/drop_down_layout\"]")
	public @Getter WebElement dropDwnLayoutS;
	
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/public_private_view\"]")
	public @Getter WebElement dropDwnpubprivate;
	
	@FindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/privacy_private_layout\"]")
	public @Getter WebElement privatePrivacy;
	
	@FindBy(id="com.mmi.maps:id/private_text")
	public @Getter WebElement privateOption;
	
	@FindBy(id="com.mmi.maps:id/private_description_text")
	public @Getter WebElement privateOptionDescripton;
	//"Place is added to your newly created list "Private
	//com.mmi.maps:id/text_view_snackbar_msg
	
	@FindBy(id="com.mmi.maps:id/header_text")
	public @Getter WebElement AboutHeader;
//	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_text\"]")
	public @Getter WebElement about;
//	
	@FindBy(id="com.mmi.maps:id/item_value")
	public @Getter WebElement aboutText;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/rcv_photos\"]/android.widget.FrameLayout")
	public @Getter WebElement addImageLayout;

	@FindBy(id="com.mmi.maps:id/add_image")
	public @Getter WebElement addImageText;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/rv_media\"]/android.view.ViewGroup")
	public @Getter WebElement cameraOptioninGallery;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/iv_image\"])[1]")
	public @Getter WebElement cameraIconInContainer;
	
	@FindBy(id="com.sec.android.app.camera:id/front_back_switcher")
	public @Getter WebElement front_back_switcher;
	
	@FindBy(id="com.sec.android.app.camera:id/shutter_button")
	public @Getter WebElement clickCamBtn;
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Ok\"]")
	public @Getter WebElement clickOk;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/view_done_top\"]")
	public @Getter WebElement doneBtnCotainerGallery;
	
@FindBy(xpath="//android.widget.TextView[@text=\"Done\"]")
public @Getter WebElement doneBTnText;

@FindBy(id="com.mmi.maps:id/item_photos_rv")
public @Getter WebElement ClickedPhotoContainer;

@FindBy(id="com.mmi.maps:id/item_remove_iv")
public @Getter WebElement removeTxt;

@FindBy(id="com.mmi.maps:id/cross_image_view")
public @Getter WebElement crossOnQRpage;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_text\" and @text=\"Information\"]")
public @Getter WebElement informationHeader;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\"]")
public @Getter WebElement informationLocText;

@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/edit_place_info\"]")
public @Getter WebElement editLocInfo;

@FindBy(xpath="//android.widget.TextView[@text=\"Suggest an Edit\"]")
public @Getter WebElement suggestAnEditHeader;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/edit_locality\"]")
public @Getter WebElement localityeditloc;

@FindBy(xpath="//android.widget.Button[@text=\"SUBMIT\"]")
public @Getter WebElement SubmitBtnAtSuggestEdit;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_missing_value\" and @text=\"Add phone number\"]")
public @Getter WebElement addPhnNumber;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/edit_phone_number\"]")
public @Getter WebElement enterphnNo;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_missing_value\" and @text=\"Add mail address\"]")
public @Getter WebElement addMailAddress;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/edit_email\"]")
public @Getter WebElement entermailInput;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_missing_value\" and @text=\"Add website link\"]")
public @Getter WebElement addWebsite;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/edit_website\"]")
public @Getter WebElement addWebsiteInput;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_footer_value\" and @text=\"Suggest An Edit\"]")
public @Getter WebElement suggestAnEditClick;

@FindBy(xpath="//android.widget.TextView[@text=\"Place is*\"]")
public @Getter WebElement placeIs;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/add_edit_place_is_input\"]")
public @Getter WebElement clickEditPlaceIs;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Place is\"]")
public @Getter WebElement titlePlaceIsBox;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/md_contentRecyclerView\"]/android.widget.LinearLayout[1]")
public @Getter WebElement operationalOption;

@FindBy(xpath="//android.widget.TextView[@text=\"Category*\"]")
public @Getter WebElement CategoryText;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/add_edit_place_category_input\"]")
public @Getter WebElement categoryInput;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Category\"]")
public @Getter WebElement categoryTitleBox;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/md_contentRecyclerView\"]/android.widget.LinearLayout[11]")
public @Getter WebElement othersOption;

@FindBy(xpath="//android.widget.TextView[@text=\"Sub Category\"]")
public @Getter WebElement Subcategory;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/add_edit_place_sub_category_input\"]")
public @Getter WebElement subCategoryInput;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Sub Category\"]")
public @Getter WebElement subCategoryTitle;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/md_contentRecyclerView\"]/android.widget.LinearLayout")
public @Getter WebElement subCategoryOthersOption;

@FindBy(xpath="(//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/item_container\"])[3]")
public @Getter WebElement addedPhnNoContainerClick;
//////////////////////////these can be device specific for call dialer 
@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.samsung.android.dialer:id/digits\"]")
public @Getter WebElement phnDialerDigits;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.samsung.android.dialer:id/dialpad_keypad_only\"]")
public @Getter WebElement dialpadKeypad;

@FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Call\"]")
public @Getter WebElement callDialer;
/////////////////////////////////////////////
@FindBy(xpath="(//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/item_container\"])[4]")
public @Getter WebElement addedemailInfoContainerClick;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"info@tajmahal.gov.in\"]")
public @Getter WebElement addedEmailTextInfo;

///////////////////////////these can be device specific for redirecting to gmail page on device
@FindBy(xpath="//com.android.internal.widget.RecyclerView[@resource-id=\"android:id/sem_chooser_recycler_ranked_app\"]")
public @Getter WebElement chooserMailRedirectAppOptions;

@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"android:id/sem_chooser_grid_item_view\"])[1]")
public @Getter WebElement gridAppOptionGmail;

@FindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.google.android.gm:id/peoplekit_autocomplete_bar_to\"]")
public @Getter WebElement ToBArEmailSendPage;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/to_prefix_text\"]")
public @Getter WebElement prefixTO;

@FindBy(xpath="//android.widget.Button[@content-desc=\"info@tajmahal.gov.in, info@tajmahal.gov.in\"]")
public @Getter WebElement emailTextAtTo;

////////////////////////////
@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"www.tajmahal.gov.in\"]")
public @Getter WebElement AddedWebsiteText;

@FindBy(xpath="(//android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/item_container\"])[5]")
public @Getter WebElement addedWebsiteContainerClick;

///////////////////////these be specific for device opeaning browser on click of website link
@FindBy(xpath="//android.webkit.WebView[@text=\"Taj Mahal-Official Website of Taj Mahal, Government of Uttar Pradesh (India)\"]")
public @Getter WebElement webView;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.chrome:id/url_bar\"]")
public @Getter WebElement urlBar;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"Opening Hours\"]")
public @Getter WebElement OpeaningHours;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"Mon-Sun 11:00-23:00\"]")
public @Getter WebElement opeaningHourTime;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"Closed On Friday \"]")
public @Getter WebElement closedOnTime;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"Additional Informations\"]")
public @Getter WebElement additionalInformation;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value\" and @text=\"Entry Fee: Indians Rs 20, Foreigners Rs 750, Citizens of SAARC and BIMSTEC Countries Rs 510\"]")
public @Getter WebElement additionalInfotext;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_text\" and @text=\"Images\"]")
public @Getter WebElement ImagesHeader;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/image_container\"]")
public @Getter WebElement imageContainer;

@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/item_poi_image_view_1\"]")
public @Getter WebElement imageOne;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_text\" and @text=\"Similar Places Nearby\"]")
public @Getter WebElement SimilarPlaceHeader;

@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/similar_place_container\"])[1]")
public @Getter WebElement similarPlacesNearbycontainer;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_title\" and @text=\"Mehmaan Khana\"]")
public @Getter WebElement similarplaceName;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_id\" and @text=\"mappls.com/trlz61\"]")
public @Getter WebElement similarPlacePIn;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_directions_button\" and @text=\"140 mtr\"]")
public @Getter WebElement similarPlaceDistance;

@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/place_container\"])[1]")
public @Getter WebElement similarplacenearbyContainerclick;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Non Existent\"]")
public @Getter WebElement nonExistant;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Closed Permanently\"]")
public @Getter WebElement closedPermanently;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"NOT APPLICABLE\"]")
public @Getter WebElement notApplicble;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Operational\"]")
public @Getter WebElement operational;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_add_place_name\"]")
public @Getter WebElement namefield;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/add_edit_place_name_input\"]")
public @Getter WebElement namefieldinput;

@FindBy(xpath="//android.widget.TextView[@text=\"Address*\"]")
public @Getter WebElement address;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/add_edit_place_address_input\"]")
public @Getter WebElement addressInput;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/add_edit_place_map_image_overlay_text\"]")
public @Getter WebElement markloc;

@FindBy(xpath="//android.widget.TextView[@text=\"Note:\"]")
public @Getter WebElement Note;

@FindBy(xpath="//android.widget.TextView[@text=\"Your edits will be published on Mappls shortly.Mappls will Email you about the status of your edits and may contact you for further details.\"]")
public @Getter WebElement NoteText;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_add_more_info\"]")
public @Getter WebElement addMoreInfo;

@FindBy(xpath="//android.widget.TextView[@text=\"Phone\"]")
public @Getter WebElement phone;

@FindBy(xpath="//android.widget.TextView[@text=\"E-Mail\"]")
public @Getter WebElement email;

@FindBy(xpath="//android.widget.TextView[@text=\"Website\"]")
public @Getter WebElement website;

@FindBy(xpath="//android.widget.TextView[@text=\"About\"]")
public @Getter WebElement aboutfield;

@FindBy(xpath="//android.widget.TextView[@text=\"Open Hours\"]")
public @Getter WebElement openhours;

@FindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.mmi.maps:id/add_edit_place_open_hours_radio1\"]")
public @Getter WebElement selectedhours;

@FindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.mmi.maps:id/add_edit_place_open_hours_radio2\"]")
public @Getter WebElement alwaysopen;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/add_edit_place_add_hours_btn\"]")
public @Getter WebElement addhours;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/add_image\"]")
public @Getter WebElement addimage;

@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
public @Getter WebElement backArrow;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/add_edit_place_further_layout\"]")
public @Getter WebElement addmoreinfolayout;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/review_place_holder_container\"]")
public @Getter WebElement rateAndReviewExpCard;

@FindBy(xpath="//android.widget.TextView[@text=\"Rate & Review Your Experience\"]")
public @Getter WebElement rateAndReviewCardText;

@FindBy(xpath="//android.widget.RatingBar[@resource-id=\"com.mmi.maps:id/item_rating\"]")
public @Getter WebElement rateAdreviewCardratingTExt;

@FindBy(xpath="//android.widget.TextView[@text=\"Reviews By Users\"]")
public @Getter WebElement reviewBYUserHEading;

@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/main_layout\"])[1]")
public @Getter WebElement currentUserReviewLayout;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_text\" and @text=\"You reviewed \"]")
public @Getter WebElement reviewText;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_review_heading_action_like_txt\"]")
public @Getter WebElement helpfulAction;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/helpful_text\"]")
public @Getter WebElement helpfulText;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_share_txt\"]")
public @Getter WebElement Shareaction;
@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/more_option\"])[1]")
public @Getter WebElement actionDotsMoreoption;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit\"]")
public @Getter WebElement editOption;

@FindBy(xpath="//android.widget.TextView[@text=\"Review Details\"]")
public @Getter WebElement ReviewDetailsPageHeader;

@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/layout_bottom_review_detail\"]")
public @Getter WebElement bottomReviewDetail;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_like_txt\"]")
public @Getter WebElement LikeActionOnReviewDetailPage;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_share_txt\"]")
public @Getter WebElement ShareOnReviewDetailspage;

@FindBy(xpath="//com.android.internal.widget.RecyclerView[@resource-id=\"android:id/sem_chooser_recycler_ranked_app\"]")
public @Getter WebElement appsOptionToShare;

@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
public @Getter WebElement backBTNONReviewDetailsPage;

@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"android:id/content\"])[2]")
public @Getter WebElement deleteOption;

@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content_preview_container\"]/android.widget.LinearLayout/android.widget.LinearLayout")
public @Getter WebElement lnly;

@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/main_layout\"])[2]")
public @Getter WebElement otherUserReviewContainer;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_text\" and @text=\"Muskan Kumari reviewed \"]")
public @Getter WebElement otherReviewText;

@FindBy(xpath="(//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_like_txt\"])[1]")
public @Getter WebElement helpfulActionOther;
@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/helpful_text\"]")
public @Getter WebElement helpfulTextOther;

@FindBy(xpath="(//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_share_txt\"])[2]")
public @Getter WebElement shareACtionOther;

@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/more_option\"])[2]")
public @Getter WebElement actionDotsMoreoptionOther;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"android:id/content\"]")
public @Getter WebElement flagOption;

@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/flag_type_input\"]")
public @Getter WebElement violationInput;

@FindBy(xpath="//android.widget.EditText[@text=\"Description\"]")
public @Getter WebElement descriptonInput;

@FindBy(xpath="//android.widget.Button[@text=\"DONE\"]")
public @Getter WebElement DoneFlag;
@FindBy(xpath="//android.widget.TextView[@text=\"Report an Abuse\"]")
public @Getter WebElement ReportAnAbuseHEader;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Violation ImageType\"]")
public @Getter WebElement violationBoxHeader;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"It is spam\"]")
public @Getter WebElement spamOption;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"It is irrelevant\"]")
public @Getter WebElement irrelevantOption;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"It contains profanity or foul language\"]")
public @Getter WebElement foulLanguageOption;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"It contains inappropriate content\"]")
public @Getter WebElement inappropriateOption;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"It contains personal information about me which I do not want to be made public\"]")
public @Getter WebElement personalInfoOption;
@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Others\"]")
public @Getter WebElement othersOptionViol;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_flag_txt\"]")
public @Getter WebElement flagOnreviewDetailspge;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_share_txt\"]")
public @Getter WebElement otherUserReviewShare;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_view_all\"]")
public @Getter WebElement ReviewViewAll;

@FindBy(xpath="//android.widget.TextView[@text=\"Reviews\"]")
public @Getter WebElement ReviewsHeader;

@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/main_layout\"])[2]")
public @Getter WebElement viewAllReviewsLayouts;

@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/review_details_user_image\"]")
public @Getter WebElement profileImageAtReview;
@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_details_user_name\"]")
public @Getter WebElement ReviewPersonName;

@FindBy(xpath="//android.widget.RatingBar[@resource-id=\"com.mmi.maps:id/item_world_view_rating_bar\"]")
public @Getter WebElement rAtingsReview;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_details_issue_desc\"]")
public @Getter WebElement commentReview;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_date_text\"]")
public @Getter WebElement DateReviewed;

@FindBy(xpath="//android.widget.TextView[@text=\"Posts By Users\"]")
public @Getter WebElement PostByUserHeader;

@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/main_layout\"])[2]")
public @Getter WebElement reportLayout;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_text\" and @text=\"You posted an update\"]")
public @Getter WebElement userOwnreport;
@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/more_option\"])[1]")
public @Getter WebElement reportMoreOption;

@FindBy(xpath="//android.widget.TextView[@text=\"Post Details\"]")
public @Getter WebElement postDetailsHeader;

@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/report_details_container\"]")
public @Getter WebElement reportDetailContainer;

@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
public @Getter WebElement BackBtnPostDetailsPage;

@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/main_layout\"])[3]")
public @Getter WebElement otherUserReportContainer;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_text\" and @text=\"nidhi posted an update\"]")
public @Getter WebElement otherUserReportText;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_view_all\"]")
public @Getter WebElement reportViewAll;
@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/common_reviews_recycler_view\"]")
public @Getter WebElement reportListViewAll;

@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/report_user_image\"])[1]")
public @Getter WebElement viewAllReportImage;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_text\" and @text=\"Kajal posted Incorrect Name\"]")
public @Getter WebElement viewAllreportText;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_issue_desc\"]")
public @Getter WebElement viewAllReportDesc;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/report_reported_date\" and @text=\"Aug 22, 2024\"]")
public @Getter WebElement viewAllreportDate;

@FindBy(xpath="//android.widget.TextView[@text=\"Posts\"]")
public @Getter WebElement postsHeaderViewAll;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"android:id/content\"]")
public @Getter WebElement reportEdit;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/parent_category_recyclerview\"]")
public @Getter WebElement reportRecyclerViewOptions;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/parent_category_recyclerview\"]/android.view.ViewGroup[2]")
public @Getter WebElement swachhBharat;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/parent_category_recyclerview\"]/android.view.ViewGroup[3]")
public @Getter WebElement Traffic;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/parent_category_recyclerview\"]/android.view.ViewGroup[4]")
public @Getter WebElement safety;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Community\"]")
public @Getter WebElement Community;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Road Condition\"]")
public @Getter WebElement RoadCondition;
@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Polluting Activity\"]")
public @Getter WebElement pollutingActivity;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"UNICEF School Closure\"]")
public @Getter WebElement UnicefSchoolClosure;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/category_name\" and @text=\"Map\"]")
public @Getter WebElement Map;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_footer_value\" and @text=\"Add Image\"]")
public @Getter WebElement AddImage;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/add_image\"]")
public @Getter WebElement addImageCameratext;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/rv_media\"]")
public @Getter WebElement rvmedia;

@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/iv_image\"])[1]")
public @Getter WebElement cameraiconLayout;
@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_title\"]")
public @Getter WebElement mediapermissionBoxTitle;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_description\"]")
public @Getter WebElement mediapermissionboxText;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultNegative\"]")
public @Getter WebElement CancelOptionbtn;

@FindBy(id="com.mmi.maps:id/md_buttonDefaultPositive")
public @Getter WebElement continueOptionBtn;

@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/image_view_send\"]")
public @Getter WebElement DoneBTNOnADDImage;

@FindBy(xpath="//android.widget.TextView[@text=\"App info\"]")
public @Getter WebElement settingsPageTextHeader;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.settings:id/entity_header_title\"]")
public @Getter WebElement entityHeader;

@FindBy(xpath="//android.widget.TextView[@text=\"Select Image\"]")
public @Getter WebElement SelectImageHeader;

@FindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.sec.android.app.camera:id/rl_shutterbutton\"]")
public @Getter WebElement shutterBTn;

@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Switch to front camera\"]")
public @Getter WebElement frontBackSwitcher;

@FindBy(xpath="//android.widget.TextView[@content-desc=\"Retry\"]")
public @Getter WebElement Retry;

@FindBy(xpath="//android.widget.TextView[@content-desc=\"Ok\"]")
public @Getter WebElement ok;

@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/view_done_top\"]")
public @Getter WebElement viewDone;

@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/add_photos_recycler_view\"]/android.widget.FrameLayout[2]/android.widget.ImageView[2]")
public @Getter WebElement selectedImgCont;
//
//@FindBy()
//public @Getter WebElement ;
//
//@FindBy()
//public @Getter WebElement ;
//
//@FindBy()
//public @Getter WebElement ;





}
