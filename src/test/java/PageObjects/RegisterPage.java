package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;
	private WebElement wait;

	// Locators
	private final By userIDInput = By.xpath("//input[@name='username']");
	private final By newPasswordInput = By.xpath("//input[@name='password']");
	private final By repeatPasswordInput = By.xpath("//input[@name='repeatedPassword']");

	private final By firstNameInput = By.xpath("//input[@name='account.firstName']");
	private final By lastNameInput = By.xpath("//input[@name='account.lastName']");
	private final By emailInput = By.xpath("//input[@name='account.email']");
	private final By phoneInput = By.xpath("//input[@name='account.phone']");
	private final By address1Input = By.xpath("//input[@name='account.address1']");
	private final By address2Input = By.xpath("//input[@name='account.address2']");
	private final By cityInput = By.xpath("//input[@name='account.city']");
	private final By stateInput = By.xpath("//input[@name='account.state']");
	private final By zipInput = By.xpath("//input[@name='account.zip']");
	private final By countryInput = By.xpath("(//input[@name='account.country'])[1]");

	private final By saveAccountButton = By.xpath("//input[@name='newAccount']");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToRegisterPage() {
		// Navigates the driver to the register page
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
	}

	public void fillRegisterForm() {
		// User Info
		// UserName

		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(userIDInput));
		// Generates an unique userName to be used 
		String accountName = Helpers.Helper.getUniqueUsername(); 
		wait.sendKeys(accountName);

		// Password
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(newPasswordInput));
		wait.sendKeys("123456");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(repeatPasswordInput));
		wait.sendKeys("123456");

		// Account Info
		// First Name
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(firstNameInput));
		wait.sendKeys("First");

		// Last Name
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(lastNameInput));

		wait.sendKeys("Last");

		// Email
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(emailInput));
		wait.sendKeys("email@test.com");

		// Phone Number
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(phoneInput));
		wait.sendKeys("912345678");
		// Address 1
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(address1Input));

		wait.sendKeys("Test Street 1");
		// Address 2
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(address2Input));

		wait.sendKeys("Test Street 2");
		// City
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(cityInput));

		wait.sendKeys("Test City");

		// State
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(stateInput));

		wait.sendKeys("Test State");

		// ZIP
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(zipInput));

		wait.sendKeys("1234 1234");

		// Country
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(countryInput));

		wait.sendKeys("Test Country");
	}

	public void clickSaveAccountInfo() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(saveAccountButton));
		wait.click();
	}
}
