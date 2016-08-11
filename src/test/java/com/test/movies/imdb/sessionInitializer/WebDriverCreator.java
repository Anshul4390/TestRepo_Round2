package com.test.movies.imdb.sessionInitializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverCreator {

	public WebDriver getDriver(String browser){
		switch (browser) {
		case "Firefox":
			return getFirefox();
		case "Chrome":
			return getChrome();
		case "IE":
			return getIE();
		default:
			return null;
		}
	}
	
	private static FirefoxDriver getFirefox(){
		return new FirefoxDriver();
	}
	
	private static ChromeDriver getChrome(){
		if(System.getProperty("os.name").contains("Windows"))
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		else
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		return new ChromeDriver();
	}
	
	private static InternetExplorerDriver getIE(){
		if(System.getProperty("os.name").contains("Windows"))
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/IEDriverServer.exe");
		else
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/IEDriverServer");

		return new InternetExplorerDriver();
	}
}
