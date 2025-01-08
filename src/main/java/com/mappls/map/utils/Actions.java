package com.mappls.map.utils;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Actions extends DriverManager{


	public void swipeUp() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth()/2;
		int startY = size.getHeight()-366;
		int endX = startX;
		int endY = (int) (size.getHeight()-566);

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}
	
	public void pointOnMapSwipe() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth()/2;
		int startY = size.getHeight()-266;
		int endX = startX;
		int endY = (int) (size.getHeight()-566);

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}

	//================
	public void scrollDown() {
//		Dimension size = driver.manage().window().getSize();
//		int startX = size.width / 2;
//		int startY = (int) (size.height * 0.8);
//		int endY = (int) (size.height * 0.2);
//
//		TouchAction<?> touchAction = new TouchAction<>(driver);
//		touchAction.longPress(PointOption.point(startX, startY))
//		.moveTo(PointOption.point(startX, endY))
//		.release()
//		.perform();
		
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth()/2;
		int startY = size.getHeight()-266;
		int endX = startX;
		int endY = (int) (size.getHeight()-566);
		System.out.println("start x : " + startX + " , start y : " + startY);
		System.out.println("end x : " + endX + " , end y : " + endY);

		
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}

	public void swipeUpForMySaves() {
		Dimension size = driver.manage().window().getSize();
		//starting coordinate
		int startX = size.getWidth()/2;
		int startY = size.getHeight()-766;
		//end coordinate
		int endX = startX;
		int endY = (int) (size.getHeight()-466);
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}

	public void btmShtScrollUp() {
	    // Functionality for swipe up 
	    // Get screen size 
	    Dimension size = driver.manage().window().getSize();
	    
	    // Starting coordinate
	    int startX = size.getWidth() / 2;
	    int startY = size.getHeight() - 366;

	    // End coordinate (3x scroll)
	    int endX = startX;
	    int endY = (int) (size.getHeight() - 966); // Increased by 3x from 200 to 600 pixels

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

	    Sequence sq = new Sequence(finger1, 1)
	            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	            .addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
	            .addAction(new Pause(finger1, Duration.ofMillis(200)))
	            .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
	            .addAction(finger1.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
	    
	    driver.perform(Collections.singletonList(sq));
	}

	public void btmShtScrollUpPosts() {
	    // Functionality for swipe up 
	    // Get screen size 
	    Dimension size = driver.manage().window().getSize();
	    
	    // Starting coordinate
	    int startX = size.getWidth() / 2;
	    int startY = size.getHeight() - 366;

	    // End coordinate (3x scroll)
	    int endX = startX;
	    int endY = (int) (size.getHeight() - 966); // Increased by 3x from 200 to 600 pixels

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

	    Sequence sq = new Sequence(finger1, 1)
	            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	            .addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
	            .addAction(new Pause(finger1, Duration.ofMillis(200)))
	            .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY))
	            .addAction(finger1.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
	    
	    driver.perform(Collections.singletonList(sq));
	}

	
	
	public void btmShtScrollUp1() {
	    // Get screen size
	    Dimension size = driver.manage().window().getSize();
	    // Starting coordinate
	    int startX = size.getWidth() / 2;
	    int startY = size.getHeight() - 366;

	    // Increase scroll size by changing endY
	    int endX = startX;
	    int endY = size.getHeight() - 766; // Adjusted for a larger scroll distance

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

	    Sequence sq = new Sequence(finger1, 1)
	            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	            .addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
	            .addAction(new Pause(finger1, Duration.ofMillis(200)))
	            .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY)) // Increased duration
	            .addAction(finger1.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
	    driver.perform(Collections.singletonList(sq));
	}

	
	
	public void longPress() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth()/2;
		int startY = 545;

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(400)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}
	
	
	//=========================================
	//for new user registration 
	public void swipeRegistration(int x2, int y2) {
		
		Dimension size = driver.manage().window().getSize();
		//starting coordinate
		int startX = size.getWidth()/2;
		int startY = size.getHeight()-x2;
		//end coordinate
		int endX = startX;
		int endY = (int) (size.getHeight()-y2);
		
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sq = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
		driver.perform(Collections.singletonList(sq));
	}
	//============================================
	
	
@SuppressWarnings("rawtypes")
TouchAction action;
    
    @SuppressWarnings("rawtypes")
	public  void swipe(int fromX,int fromY,int toX,int toY) {

        action = new TouchAction(driver);
        action.press(PointOption.point(fromX,fromY))
        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))) //you can change wait durations as per your requirement
        .moveTo(PointOption.point(toX, toY))
        .release()
        .perform();
    }
    
    
    //new 
    public void swipeFun() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth()/2;
        int startY = size.getHeight()/2;
        //end coordinate
        int endX = startX;
        int endY = (int) (size.getHeight()*0.25);
        
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp((PointerInput.MouseButton.MIDDLE.asArg())));
        driver.perform(Collections.singletonList(sq));
    }
    
    
    
    //zoom in zoom out
    
    
    
    
    
    
    

}
