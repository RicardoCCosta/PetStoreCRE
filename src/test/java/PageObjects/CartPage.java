package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	private WebElement wait;
	
	// Locators
	private final By shoppingCartTitle = By.xpath("//h2[normalize-space()='Shopping Cart']");
	private final By firstItemInCartRemoveCell = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[8]/a");
	private final By proceedToCheckOutButton = By.xpath("//a[normalize-space()='Proceed to Checkout']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	public void verifyShoppingCartURL() {
		// Verifies current URL is as expected
		assertTrue(driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Cart.action"));
	}

	public void verifyShoppingCartTitle() {
		// Verifies there is at least one product in the cart
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(shoppingCartTitle));
		Assert.assertEquals(wait.getText(), "Shopping Cart");
	}

	public void verifyThereIsOneProductInTheCart() {
		// Verifies there is at least one product in the cart
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(firstItemInCartRemoveCell));
		Assert.assertEquals(wait.getText(), "Remove");
	}

	public void clickOnProceedToCheckOut() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));
		wait.click();
	}
}
