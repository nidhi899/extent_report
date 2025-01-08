package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__007_MyWorldViewPage extends BasePage {

	
	public TC__007_MyWorldViewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "com.mmi.maps:id/layout_world_view")
	public @Getter WebElement myworldViewMenu;

	@FindBy(xpath = "//android.widget.TextView[@text=\"My World View\"]")
	public @Getter WebElement worldViewtext;

	@FindBy(id = "com.mmi.maps:id/coordinatorLayout")
	public @Getter WebElement wrldViewLayout;

	@FindBy(id = "com.mmi.maps:id/main_layout")
	public @Getter WebElement btmMainLayout;

	@FindBy(id = "com.mmi.maps:id/poi_list")
	public @Getter WebElement poiListLayout;

	@FindBy(id = "com.mmi.maps:id/main_layout")
	public @Getter WebElement poiMainLayout;

	@FindBy(id="com.mmi.maps:id/item_world_view_action_flag_txt")
	public @Getter WebElement flag;
	
	@FindBy(id="com.mmi.maps:id/parentPanel")
    public @Getter WebElement parentPanel;
	
	@FindBy(id="com.mmi.maps:id/text_view_title")
    public @Getter WebElement title;
	
	@FindBy(id="com.mmi.maps:id/text_view_description")
    public @Getter WebElement description;
	
	@FindBy(id="android:id/button1")
    public @Getter WebElement loginBtns;
	
	@FindBy(id="com.mmi.maps:id/flag_type_input")
    public @Getter WebElement violationfield;
	
	@FindBy(id="android:id/content")
    public @Getter WebElement violationImageTypeBox;
	
	@FindBy(id="com.mmi.maps:id/md_title")
    public @Getter WebElement violationImageBoxTitle;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\" and @text=\"Others\"]")
    public @Getter WebElement optionOthers;
	
	@FindBy(id="com.mmi.maps:id/flag_desc_wrapper")
	public @Getter WebElement violationDesc;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"Description\"]")
	public @Getter WebElement descText;
	
	@FindBy(xpath="//android.widget.Button[@text=\"DONE\"]")
	public @Getter WebElement doneBtn;
	
	@FindBy(id="com.mmi.maps:id/snackbar_text")
	public @Getter WebElement snackBarMessage;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement backBtn;
	
	@FindBy(id ="com.mmi.maps:id/item_world_view_action_like_txt")
	public @Getter WebElement helpful;
	
	@FindBy(id="com.mmi.maps:id/helpful_text")
	public @Getter WebElement helpfulText;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"My World View\"]")
	public @Getter WebElement toolbarText;
	
	@FindBy(id="com.mmi.maps:id/menu_contacts")
	public @Getter WebElement menu_contact;
	
	@FindBy(id="com.mmi.maps:id/map_layer_button")
	public @Getter WebElement mapLayerButton;
	
	@FindBy(id="com.mmi.maps:id/poi_list_current_location_button")
	public @Getter WebElement currentLocButton;
	
	@FindBy(id="com.mmi.maps:id/sc_searchview")
	public @Getter WebElement searchContact;
	
	@FindBy(id="com.mmi.maps:id/sc_contacts_rcv")
	public @Getter WebElement contactList;
	
	@FindBy(id="com.mmi.maps:id/three_d_switch_container")
	public @Getter WebElement threeDContainer;
	
	@FindBy(id="com.mmi.maps:id/text_view_3d")
	public @Getter WebElement ThreeDText;
	
	@FindBy(id="com.mmi.maps:id/switch_2d_3d")
	public @Getter WebElement switchToggle;
	
	@FindBy(id="com.mmi.maps:id/map_layer_image_container")
	public @Getter WebElement defaultMap;
	
	@FindBy(id="com.android.permissioncontroller:id/content_container")
	public @Getter WebElement controllerbox;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_message")
	public @Getter WebElement permissionMessage;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar_simple\"]/android.widget.ImageButton")
	public @Getter WebElement myworldviewbackbtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_share_txt\"]")
	public @Getter WebElement share;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_title\"]")
	public @Getter WebElement contactPermissionTitle;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_description\"]")
	public @Getter WebElement contactPermissionDesc;
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultNegative\"]")
	public @Getter WebElement cancelButton;
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")
	public @Getter WebElement continueButton;
//	@FindBy()
//	public @Getter WebElement ;
//	@FindBy()
//	public @Getter WebElement ;
}
