About the Codebase :

A maven project that uses a combination of Selenium Webdriver and TestNG to create test automation framework for imdb website.

The test workflow incluides following steps  :
1. Launch the IMDB website
2. Navigate to Top Rated Movies page
3. Fetch information about top movies with their titles, release year and ratings
4. Prints the movie details in TestNG output file along with a text file placed at 'src/test/resources/output.txt' location

The project is driven through a file called 'Configuration_Data.properties' that provided execution paramters like URL, browser, global timeout and other test data. The framwork is built based on PageObject modal and is modularized in a way to keep consistency of coding standards intact.

Execution Methodology

1. Pre-requisites
a. JDK 1.8 or higher
b. Maven 3.0.3 or higher

2. Command for executing the test 
a. Open command prompt
b. Go to the location of the project's POM file
c. Type : 'mvn clean verify -Dtest=IMDBTopRatedMovieTestFlow'