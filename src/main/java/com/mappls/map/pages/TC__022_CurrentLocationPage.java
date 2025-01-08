package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__022_CurrentLocationPage {
	
	public TC__022_CurrentLocationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.mmi.maps:id/current_location_button")
	public @Getter WebElement currentLocationIcon;
//	@FindBy()
//	public @Getter WebElement ;
	

}
