package com.test.movies.imdb.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitProvider {

	WebDriverWait wait;	
	public SeleniumWaitProvider(WebDriver driver, int timeOut) {
		wait = new WebDriverWait(driver, timeOut);
	}
	
	public WebElement waitForElementToAppearOnPage(WebElement element){
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForPageToLoadCompletely(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}
}
