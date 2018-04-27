package com.komoot.library;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;

public class Config {

	public AndroidDriver driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Nexus 6 API 24");
		
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
}
