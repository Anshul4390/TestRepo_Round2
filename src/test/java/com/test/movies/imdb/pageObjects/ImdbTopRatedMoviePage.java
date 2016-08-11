package com.test.movies.imdb.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.test.movies.imdb.utilities.OutputFileWriter;

public class ImdbTopRatedMoviePage extends BasePageObject {

	WebDriver driver;

	public ImdbTopRatedMoviePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = ".header")
	private WebElement txt_heading;

	@FindBy(css = ".byline")
	private WebElement txt_subheading;

	@FindBy(css = ".lister .desc>span")
	private WebElement txt_numberOfTitlesShown;

	@FindBy(css = ".lister-list>tr")
	private List<WebElement> rows_listOfMovies;
	
	@FindBy(css=".lister-list>tr>.titleColumn>a")
	private List<WebElement> list_movieTitleLinks;
	
	@FindBy(css=".lister-list>tr>.titleColumn>span")
	private List<WebElement> list_movieReleaseYears;
	
	@FindBy(css=".lister-list>tr>.imdbRating>strong")
	private List<WebElement> list_movieRatingLinks;

	public void verifyTopRatedMoveiPageLoaded(String heading, String subheading) {
		wait.waitForPageToLoadCompletely();
		isElementDisplayed(txt_heading);
		Assert.assertTrue(txt_heading.getText().trim().equals(heading), "Header text for 'Top Rated Movies' page is incorrect!");
		isElementDisplayed(txt_subheading);
		Assert.assertTrue(txt_subheading.getText().trim().equals(subheading),
				"Sub-Header text for 'Top Rated Movies' page is incorrect!");
		logMessage("User has successfully landed on IMDB 'Top Rated Movie' page");
	}

	public int verifyNumberOfMoviesOnTheListMatchesListerValue() {
		int showingXTitles = Integer.parseInt(txt_numberOfTitlesShown.getText().trim());
		int numberOfRowsInMovieList = rows_listOfMovies.size();
		Assert.assertEquals(numberOfRowsInMovieList, showingXTitles,
				"Number of movies in the list doesn't match the number displayed at the top");
		logMessage("Number of movies in the list matches the number displayed at the top, which is:- "
				+ numberOfRowsInMovieList);
		return numberOfRowsInMovieList;
	}

	public Map<Integer, List<String>> fetchMovieInformationFromRatingList(int numberOfEnteries){
		logMessage("Movie information fetched for "+numberOfEnteries+" movies available on the list");
		Map<Integer, List<String>> movieMap = new HashMap<Integer, List<String>>();
		List<String> movieInfo;
		for(int i=0;i<numberOfEnteries;i++){
			movieInfo = new ArrayList<String>();
			//System.out.println(list_movieTitleLinks.get(i).getText()+list_movieReleaseYears.get(i).getText().split("\\(")[1].split("\\)")[0].trim()+list_movieRatingLinks.get(i).getText().trim());
			movieInfo.add(list_movieTitleLinks.get(i).getText());
			movieInfo.add(list_movieReleaseYears.get(i).getText().split("\\(")[1].split("\\)")[0].trim());
			movieInfo.add(list_movieRatingLinks.get(i).getText().trim());
			movieMap.put(new Integer(i+1), movieInfo);
		}
		return movieMap;
	}
	
	public void printMovieInformation(Map<Integer, List<String>> movieMap){
		logMessage("Rank"+" | "+"Movie Name"+" | "+"Movie Release Year"+" | "+"Movie Rating");
		for(Map.Entry<Integer, List<String>> entries : movieMap.entrySet()){
			logMessage(entries.getKey()+" | "+entries.getValue().get(0)+" | "+entries.getValue().get(1)
					+" | "+entries.getValue().get(2));
			OutputFileWriter.writeIntoFile(entries.getKey()+" | "+entries.getValue().get(0)+" | "+entries.getValue().get(1)
					+" | "+entries.getValue().get(2));
		}
	}
	

}
