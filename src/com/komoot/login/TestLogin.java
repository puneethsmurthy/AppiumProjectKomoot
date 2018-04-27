package com.komoot.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.komoot.library.Config;
import com.komoot.library.Utility;

import io.appium.java_client.android.AndroidDriver;

public class TestLogin extends Utility {

	private String name = "Puneeth";
	private String invalidEmail = "invalidEmail";
	private String validEmail = "puneeth.shanthamurthy@gmail.com";
	private String password = "12345678";
	private String expectedErrorMessage = "The email you entered is incorrect. Please re-enter it and try again.";
	private String expectedErrorMessageNameField = "Please enter your name and try again.";
	private String expectedErrorMessageEmailField = "Please enter your email and try again.";
	private String expectedErrorMessagePasswordField = "Please enter your password and try again.";
	private String expectedWelcomeMessage = "Puneeth, Ready For Your First Adventure?";
	
	
	@Test(description="Verify validation for Invalid Email ID", priority=0)
	public void testWithInvalidEmailId() throws Exception{	
		
		Reporter.log("=====Entered Invalid EmailID Test=====", true);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("de.komoot.android:id/button_mail_register")).click();
		
		WebElement nameTextField = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/edittext_display_name")));
		nameTextField.click();
		nameTextField.sendKeys(name);
																		
		WebElement emailTextField = driver.findElement(By.id("de.komoot.android:id/edittext_email"));
		emailTextField.sendKeys(invalidEmail);		
		
		WebElement passwordTextField = driver.findElement(By.id("de.komoot.android:id/edittext_password"));
		passwordTextField.sendKeys(password);
		
		driver.navigate().back();
		
		WebElement loginButton = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/button_register")));
		loginButton.click();
		
		validateErrorMessageInvalidEmailField(expectedErrorMessage);
		
		Thread.sleep(5000);
		
		Reporter.log("=====Exited Invalid EmailID Test=====", true);
	}
	
	@Test(description="Verify Mandatory field validation for Name field", priority=1)
	public void testForMandatoryFieldName() throws Exception{
		
		Reporter.log("=====Entered Mandatory Field: Name Test=====", true);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("de.komoot.android:id/button_mail_register")).click();
		
		WebElement nameTextField = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/edittext_display_name")));
		nameTextField.click();
		
		driver.navigate().back();
		
		WebElement loginButton = driver.findElement(By.id("de.komoot.android:id/button_register"));
		loginButton.click();
		
		validateErrorMessageNameField(expectedErrorMessageNameField);
		
		Thread.sleep(5000);
		
		Reporter.log("=====Exited Mandatory Field: Name Test=====", true);
	}
	
	@Test(description="Verify Mandatory field validation for Email field",priority=2)
	public void testForMandatoryFieldEmail() throws Exception{
		
		Reporter.log("=====Entered Mandatory Field: Email Test=====", true);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("de.komoot.android:id/button_mail_register")).click();
		
		WebElement nameTextField = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/edittext_display_name")));
		nameTextField.click();
		nameTextField.sendKeys(name);
		
		driver.navigate().back();
		
		WebElement loginButton = driver.findElement(By.id("de.komoot.android:id/button_register"));
		loginButton.click();
		
		validateErrorMessageEmailField(expectedErrorMessageEmailField);
		
		Thread.sleep(5000);
		
		Reporter.log("=====Exited Mandatory Field: Email Test=====", true);
	}
	
	@Test(description="Verify Mandatory field validation for Password field",priority=3)
	public void testForMandatoryFieldPassword() throws Exception{
		
		Reporter.log("=====Entered Mandatory Field: Password Test=====", true);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("de.komoot.android:id/button_mail_register")).click();
		
		WebElement nameTextField = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("de.komoot.android:id/edittext_display_name")));
		nameTextField.click();
		nameTextField.sendKeys(name);
		
		WebElement emailTextField = driver.findElement(By.id("de.komoot.android:id/edittext_email"));
		emailTextField.sendKeys(validEmail);	
		
		driver.navigate().back();
		
		WebElement loginButton = driver.findElement(By.id("de.komoot.android:id/button_register"));
		loginButton.click();
		
		validateErrorMessagePasswordField(expectedErrorMessagePasswordField);
		
		Thread.sleep(5000);
		
		Reporter.log("=====Exited Mandatory Field: Password Test=====", true);
	}
	
	@Test(description="Verify Sign up functionality by providing valid values", priority=4)
	public void validateSignup(){
		
		Reporter.log("=====Entered Sign Up Test=====", true);
		
		validateLogin(name, validEmail, password, expectedWelcomeMessage);
		
		Reporter.log("=====Exited Sign Up Test=====", true);
	}
	
}
