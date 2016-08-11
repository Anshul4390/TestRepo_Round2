package com.test.movies.imdb.sessionInitializer;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.test.movies.imdb.pageObjects.ImdbTopNavBar;
import com.test.movies.imdb.pageObjects.ImdbTopRatedMoviePage;

public class TestSessionInitializer {

	WebDriverCreator drCreator;
	WebDriver driver;
	
	public ImdbTopNavBar topNavbar;
	public ImdbTopRatedMoviePage movieRatingPage;
	
	public TestSessionInitializer(String browser){
		drCreator = new WebDriverCreator();
		_initiateDriver(browser);
		_initActions();
	}
	
	private void _initActions(){
		topNavbar = new ImdbTopNavBar(driver);
		movieRatingPage = new ImdbTopRatedMoviePage(driver);
	}
	
	private void _initiateDriver(String browser){
		driver = drCreator.getDriver(browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void launchApplication(String appUrl){
		driver.get(appUrl);
		Reporter.log("User launched the URL: "+appUrl,true);
	}
	
	public void closeBrowserSession(){
		driver.quit();
		Reporter.log("Browser close",true);
	}
	
}
