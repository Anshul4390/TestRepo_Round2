package com.test.movies.imdb.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.test.movies.imdb.utilities.ConfigPropertyReader;
import com.test.movies.imdb.utilities.SeleniumWaitProvider;


public class BasePageObject {
	
	protected WebDriver driver;
	SeleniumWaitProvider wait;
	
	public BasePageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new SeleniumWaitProvider(driver, Integer.parseInt(new ConfigPropertyReader().getProperty("explicitTimeOut")));
	}
	
	protected void isElementDisplayed(WebElement element){
		WebElement elem = null;
		try {
			elem = wait.waitForElementToAppearOnPage(element);
			Assert.assertTrue(elem.isDisplayed());
		} catch (NoSuchElementException excp) {
			Assert.fail();
		}

	}
	
	public void logMessage(String message){
		Reporter.log("[Test Step]: "+message,true);
	}
	
	
 
}
