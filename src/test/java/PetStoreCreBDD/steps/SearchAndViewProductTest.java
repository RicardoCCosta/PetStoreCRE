package PetStoreCreBDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import PageObjects.HomePage;
import PageObjects.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchAndViewProductTest {
	WebDriver driver;

	HomePage homePage;
	SearchPage searchPage;

	@Given("I have a Selenium using {string} search")
	public void i_have_a_selenium_using(String browser) {
		// Initializes webdriver for a given browser
		driver = WebDriverConfig.startBrowser(browser);

		// Initializes the page objects needed
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
	}

	@When("I am at the homepage")
	public void I_am_at_the_homepage() {
		homePage.goToHomePage();
	}

	@When("I search for product {string} and press ENTER")
	public void i_search_for_product_name_and_press_enter(String name) {
		homePage.searchProduct(name);
	}

	@Then("I have the {string} in the search results")
	public void i_have_the_name_in_the_search_results(String name) {
		searchPage.searchResultHasString(name);
	}
	
	@Then("I get redirected to homepage")
	public void i_get_redirected_to_homepage() {
		// Validates the current URL with the expected result
		Assert.assertEquals(
				"https://petstore.octoperf.com/actions/Catalog.action", 
				driver.getCurrentUrl());
	}
	@After
	public void CloseBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
