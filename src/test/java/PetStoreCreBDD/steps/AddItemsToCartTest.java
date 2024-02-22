package PetStoreCreBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import PageObjects.CartPage;
import PageObjects.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemsToCartTest {
	WebDriver driver;

	CartPage cartPage;
	ProductPage productPage;

	@Given("I have a Selenium using {string} add")
	public void i_have_a_selenium_using(String browser) {
		// Initializes webdriver for a given browser
		driver = WebDriverConfig.startBrowser(browser);

		// Initializes the page objects needed
		productPage = new ProductPage(driver);
		cartPage= new CartPage(driver);
	}

	@Given("I am at the Categoty page for {string}")
	public void I_am_at_the_Categoty_page_for_String(String string) {
		productPage.goToCategoryPage(string);
	}

	@When("I press on the first product")
	public void When_I_press_on_the_first_product() {
		productPage.clickOnFirstProduct();
	}

	@When("I press Add To Cart")
	public void i_press_add_to_cart() {
		productPage.addFirstProductToCart();
	}

	@Then("I should be on the shopping cart page")
	public void i_should_be_on_the_shopping_cart_page() {
		cartPage.verifyShoppingCartURL();
		cartPage.verifyShoppingCartTitle();

	}

	@Then("There should be one item in the cart")
	public void there_should_be_one_item_in_the_cart() {
		cartPage.verifyThereIsOneProductInTheCart();
	}
	@After
	public void CloseBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}
	
}
