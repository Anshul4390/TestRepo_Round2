package com.test.movies.imdb.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ImdbTopNavBar extends BasePageObject {
	
	WebDriver driver;

	public ImdbTopNavBar(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css="#home_img")
	private WebElement lnk_imdbLogo;
	
	@FindBy(css="#navTitleMenu>p>a:nth-child(1)")
	private WebElement lnk_movies;
	
	@FindBy(linkText="Top Rated Movies")
	private WebElement lnk_topRatedMovies;
	
	public void verifyTopNavBarAppears(){
		wait.waitForPageToLoadCompletely();
		isElementDisplayed(lnk_imdbLogo);
		isElementDisplayed(lnk_movies);
		logMessage("User is able to view the IMDB top navigation bar");
	}
	
	public void navigateToTopRatedSection(){
		new Actions(driver).moveToElement(lnk_movies).build().perform();
		lnk_topRatedMovies.click();
		logMessage("User clicked on 'Top Rated Movies' link");
	}

}
