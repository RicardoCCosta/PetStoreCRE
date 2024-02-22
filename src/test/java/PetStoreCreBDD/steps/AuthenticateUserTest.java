package PetStoreCreBDD.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticateUserTest {
	WebDriver driver;

	LoginPage loginPage;

	@Given("I have a Selenium using {string} authenticate")
	public void i_have_a_selenium_using(String browser) {
		// Initializes webdriver for a given browser
		driver = WebDriverConfig.startBrowser(browser);

		// Initializes the page objects needed
		loginPage = new LoginPage(driver);
	}

	@When("I enter the login page")
	public void i_enter_the_login_page() {
		loginPage.goToLoginPage();
	}

	@When("I input valid login data")
	public void i_input_valid_login_data() {
		loginPage.fillLoginForm("user_1233456", "1233456");
	}

	@When("I click on login")
	public void i_click_on_login() {
		loginPage.clickOnLoginButton();
	}

	@Then("I get redirected to homepage authenticate")
	public void i_get_redirected_to_homepage_authenticate() {
		// Validates the current URL with the expected result
		Assert.assertTrue(driver.getCurrentUrl().contains(
				"https://petstore.octoperf.com/actions/Catalog.action" 
				));
	}
	@After
	public void CloseBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
