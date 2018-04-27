package com.komoot.library;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;

public class Utility extends Config{
	
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
	
	public void validateLogin(String name, String validEmail, String password, String expectedWelcomeMessage){
		
		Reporter.log("=====Entered validateLogin Method Successfully=====", true);
		
		driver.findElement(By.id("de.komoot.android:id/button_mail_register")).click();
		
		WebElement nameTextField = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/edittext_display_name")));
		nameTextField.click();
		nameTextField.sendKeys(name);
																		
		WebElement emailTextField = driver.findElement(By.id("de.komoot.android:id/edittext_email"));
		emailTextField.sendKeys(validEmail);		
		
		WebElement passwordTextField = driver.findElement(By.id("de.komoot.android:id/edittext_password"));
		passwordTextField.sendKeys(password);
		
		driver.navigate().back();
		
		WebElement loginButton = driver.findElement(By.id("de.komoot.android:id/button_register"));
		loginButton.click();
		
		WebElement welcomeTextField = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/oia_title")));
		String actualWelcomeMessage = welcomeTextField.getText();
		System.out.println(actualWelcomeMessage);
		
		Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Fail: Welcome Message did not appear");
		
		Reporter.log("=====Exited validateLogin Method Successfully=====", true);
	}

	public void validateErrorMessageNameField(String expectedErrorMessageNameField){
		
		Reporter.log("=====Entered validateErrorMessageNameField Method Successfully=====", true);
		
		WebElement errorMessage = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/message")));
		
		String actualErrorMessageNameField = errorMessage.getText();
		
		Assert.assertEquals(actualErrorMessageNameField, expectedErrorMessageNameField, "FAIL: Mandatory test for Name Field does not work");
		
		Reporter.log("=====Exited validateErrorMessageNameField Method Successfully=====", true);
	}
	
	public void validateErrorMessageInvalidEmailField(String expectedErrorMessageInvalidEmail){
		
		Reporter.log("=====Entered validateErrorMessageInvalidEmailField Method Successfully=====", true);
		
		WebElement errorMessage = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/message")));
		
		String actualErrorMessageIvalidEmail = errorMessage.getText();
		
		Assert.assertEquals(actualErrorMessageIvalidEmail, expectedErrorMessageInvalidEmail, "FAIL: Invalid Email test does not work");
		
		Reporter.log("=====Exited validateErrorMessageInvalidEmailField Method Successfully=====", true);
	}
	
	public void validateErrorMessageEmailField(String expectedErrorMessageEmailField){
		
		Reporter.log("=====Entered validateErrorMessageEmailField Method Successfully=====", true);
		
		WebElement errorMessage = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")));
		
		String actualErrorMessageEmailField = errorMessage.getText();
		System.out.println("Actual Error Message: " +actualErrorMessageEmailField);
		
		Assert.assertEquals(actualErrorMessageEmailField, expectedErrorMessageEmailField, "FAIL: Mandatory test for Email Field does not work");
		
		Reporter.log("=====Exited validateErrorMessageEmailField Method Successfully=====", true);
		
	}
	
	public void validateErrorMessagePasswordField(String expectedErrorMessagePasswordField){
		
		Reporter.log("=====Entered validateErrorMessagePasswordField Method Successfully=====", true);
		
		WebElement errorMessage = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")));
		
		String actualErrorMessagePasswordField = errorMessage.getText();
		
		Assert.assertEquals(actualErrorMessagePasswordField, expectedErrorMessagePasswordField, "FAIL: Mandatory test for Password Field does not work");
		
		Reporter.log("=====Exited validateErrorMessagePasswordField Method Successfully=====", true);
	}
	
	
}
