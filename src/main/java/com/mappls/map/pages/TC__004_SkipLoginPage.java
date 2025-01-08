package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__004_SkipLoginPage {
	
	public TC__004_SkipLoginPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"My Gadgets\"]")
	public @Getter WebElement myGadgetsInMenu;
	
	@FindBy(id="com.mmi.maps:id/nav_share_location")
	public @Getter WebElement shareMyLocInMenu;
	
	@FindBy(id="com.mmi.maps:id/nav_add_a_place")
	public @Getter WebElement AddaPlaceInMenu;
	
	@FindBy(id="com.mmi.maps:id/nav_get_eloc")
	public @Getter WebElement getMapplsPinInMenu;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_footer_value\" and @text=\"Suggest An Edit\"]")
	public @Getter WebElement suggestAnEdit;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_footer_value\" and @text=\"Add Image\"]")
	public @Getter WebElement addAnImage;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Reviews By Users\"]")
	public @Getter WebElement reviewByUserHeader;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_view_all\"]")
	public @Getter WebElement reviewViewAll;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/common_reviews_recycler_view\"]/android.widget.LinearLayout[2]")
	public @Getter WebElement ReviewLayout;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/layout_bottom_review_detail\"]")
	public @Getter WebElement reviewBtmLayer;

	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/like_flag_layout\"]")
	public @Getter WebElement likeflagLayout;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_like_txt\"]")
	public @Getter WebElement likeBtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_flag_txt\"]")
	public @Getter WebElement flagbtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/review_footer\"]")
	public @Getter WebElement AddAREviewFooter;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Posts By Users\"]")
	public @Getter WebElement postsByUSer;
	
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/report_container\"])[1]")
	public @Getter WebElement reportContainerLayout;

@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/report_details_container\"]")
public @Getter WebElement reportBtmShtLayer;

@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/like_flag_layout\"]")
public @Getter WebElement flagLikeCont;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_like_txt\"]")
public @Getter WebElement postLike;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_world_view_action_flag_txt\"]")
public @Getter WebElement postFlag;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/search_input\"]")
public @Getter WebElement SearchInput;
@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
public @Getter WebElement backBtn;

@FindBy(xpath="//android.widget.ScrollView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_bottom_sheet\"]")
public @Getter WebElement BtmShtPOM;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_action_report\"]")
public @Getter WebElement reportPOM;

@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_action_save\"]")
public @Getter WebElement savePOM;

@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/overflow_image_button\"]")
public @Getter WebElement overflow;


}
