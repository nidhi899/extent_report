package com.mappls.map.utils;

import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

    public static AndroidDriver<MobileElement> driver;

    @BeforeMethod
//    @BeforeTest
    public void initializeDriver() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
//          virtual device
//            caps.setCapability("udid", "emulator-5554");
            
            // Samsung USB
//            caps.setCapability("udid", "R9ZR80ASBLV");

            caps.setCapability("udid", "0002203R600009E8");
            caps.setCapability("deviceName", "realme C11 2021");
            
            // Platform details
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "uiautomator2");
            caps.setCapability("platformVersion", "14"); // Check if the device is running Android 14

            // App details
            caps.setCapability("appPackage", "com.mmi.maps");
            caps.setCapability("appActivity", "com.mmi.maps.ui.activities.HomeScreenActivity");

            // Ensure the correct Appium server URL with /wd/hub
            URL url = URI.create("http://127.0.0.1:4723/").toURL();

            // Initialize AndroidDriver
            driver = new AndroidDriver<MobileElement>(url, caps);
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
            
//            BaseFeatures bf = new BaseFeatures(driver);
//            bf.mapplsPermissions();

        } catch (Exception e) {
            System.out.println("Cause is: " + e.getCause());
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterMethod
//    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
