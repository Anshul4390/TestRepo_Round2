package com.test.movies.imdb.tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.test.movies.imdb.sessionInitializer.TestSessionInitializer;
import com.test.movies.imdb.utilities.ConfigPropertyReader;

public class IMDBTopRatedMovieTestFlow {

	TestSessionInitializer test;
	int movieListSize;
	ConfigPropertyReader config;
	
	@BeforeClass
	public void setUp(){
		config = new ConfigPropertyReader();
		test = new TestSessionInitializer(config.getProperty("browser"));
		test.launchApplication(config.getProperty("url"));
		
	}
	
	@Test
	public void Step01_VerifyUserLandsOnIMDBPage(){
		test.topNavbar.verifyTopNavBarAppears();
	}
	
	@Test
	public void Step02_VerifyNavigationToTopRatedMovies(){
		test.topNavbar.navigateToTopRatedSection();
		test.movieRatingPage.verifyTopRatedMoveiPageLoaded(config.getProperty("headingOnRatePage"), config.getProperty("subHeadingOnRatePage"));
	}
	
	@Test
	public void Step03_VerifyListOfMoviesOnTopRatingPage(){
		movieListSize = test.movieRatingPage.verifyNumberOfMoviesOnTheListMatchesListerValue();
	}
	
	@Test
	public void Step04_getMovieInfoAndPublish(){
		Map<Integer, List<String>> movieMap = test.movieRatingPage.fetchMovieInformationFromRatingList(movieListSize);
		test.movieRatingPage.printMovieInformation(movieMap);
	}
	
	@AfterClass
	public void tearDown(){
		test.closeBrowserSession();
	}
}
