package PetStoreCreBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FinalizeOrderTest {
	WebDriver driver;

	CartPage cartPage;
	LoginPage loginPage;
	ProductPage productPage;

	@Given("I have a Selenium using {string} finalize")
	public void i_have_a_selenium_using(String browser) {
		// Initializes webdriver for a given browser
		driver = WebDriverConfig.startBrowser(browser);

		// Initializes the page objects needed
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
	}

	@Given("I have added a Product in the Cart")
	public void Given_I_have_added_a_Product_in_the_Cart() {
		// Goes to a categoryPage
		productPage.goToCategoryPage("FISH");
		// Goes to the product page of the first product of that category
		productPage.clickOnFirstProduct();
		// Adds the first product of that page to the cart
		productPage.addFirstProductToCart();
		// Verifies that the cart cast has at least one product
		cartPage.verifyThereIsOneProductInTheCart();
	}

	@Given("I am at the Shopping Cart Page")
	public void I_am_at_the_Shopping_Cart_Page() {
		cartPage.verifyShoppingCartURL();
	}

	@When("I click Proceed to Checkout")
	public void I_click_Proceed_to_Checkout() {
		cartPage.clickOnProceedToCheckOut();
	}

	@Then("I should be on the Login Page")
	public void I_should_be_on_the_Login_Page() {
		loginPage.verifyIAmAtTheLoginPage();
	}
	@After
	public void CloseBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
}
