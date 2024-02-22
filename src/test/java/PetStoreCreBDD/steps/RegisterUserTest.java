package PetStoreCreBDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import PageObjects.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUserTest {
	WebDriver driver;
	RegisterPage registerPage;
	
	@Given("I have a Selenium using {string} register")
	public void i_have_a_selenium_using(String browser) {
		// Initializes webdriver for a given browser
		driver = WebDriverConfig.startBrowser(browser);

		// Initializes the page objects needed
		registerPage = new RegisterPage(driver);
	}

	@When("I enter the register page")
	public void i_enter_the_register_page() {
		// Navigates the driver to the register page
		registerPage.goToRegisterPage();

	}

	@When("I input valid register data")
	public void i_input_valid_register_data() {
		// Fills each individual input necessary to register a new user
		registerPage.fillRegisterForm();

	}

	@When("I click on save account info")
	public void i_click_on_save_account_info() {
		// Clicks on the final button of the register process
		registerPage.clickSaveAccountInfo();
	}

	@Then("I get redirected to homepage register")
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
