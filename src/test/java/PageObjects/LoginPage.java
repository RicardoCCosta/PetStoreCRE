package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	private WebElement wait;

	// Locators
	private final By userNameInput = By.xpath("//input[@name='username']");
	private final By passwordInput = By.xpath("//input[@name='password']");
	private final By loginButton = By.xpath("//input[@name='signon']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToLoginPage() {
		// Navigates the driver to the register page
		driver.get("https://petstore.octoperf.com/actions/Account.action");
	}

	public void fillLoginForm(String userName, String password) {
		// UserName
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(userNameInput));
		wait.clear();
		wait.sendKeys(userName);

		// Password
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(passwordInput));
		wait.clear();
		wait.sendKeys(password);
	}

	public void clickOnLoginButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(loginButton));
		wait.click();
	}

	public void verifyIAmAtTheLoginPage() {
		assertTrue(driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Order.action?newOrderForm="));
	}
}
