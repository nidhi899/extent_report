package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__024_EarthObsDataPage {
	public TC__024_EarthObsDataPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//android.widget.TextView[@text=\"Earth Observation Data\"]")
	public @Getter WebElement getTxt;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement backBtn;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
	public @Getter WebElement floatingLocationIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/earth_observation_text_view\"]")
	public @Getter WebElement earthObsTxt;
	
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
	public @Getter WebElement earthObsFloatingCrrntLctnIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/wms_name_text_view\" and @text=\"Water Spread\"]")
	public @Getter WebElement waterSpread;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Water Spread\"]")
	public @Getter WebElement wtrSpreadCategoyTitle;
	
	//get Water spread lists
	@FindAll({@FindBy(id = "com.mmi.maps:id/wms_name_text_view")})
	public @Getter List<WebElement> wtrSpreadLists;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement wtrSpreadBckBtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/wms_name_text_view\" and @text=\"Weather\"]")
	public @Getter WebElement weather;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Weather\"]")
	public @Getter WebElement weatherTitle;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/wms_name_text_view\" and @text=\"Surface Air Temperature - Night\"]")
	public @Getter WebElement weatherNightList;
	
	//get Weather lists 
	@FindAll({@FindBy(id = "com.mmi.maps:id/wms_name_text_view")})
	public @Getter List<WebElement> weatherCtaLists;
	
	//
	@FindBy(xpath="//android.widget.TextView[@text=\"Weather\"]")
	public @Getter WebElement weatherHedrTxt;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/wms_title_text_view\"]")
	public @Getter WebElement srfceAirTemp;
	
	
	
	
}
