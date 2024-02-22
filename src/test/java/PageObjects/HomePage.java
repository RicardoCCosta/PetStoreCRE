package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	private WebElement wait;

	// Locators
	private final By searchInput = By.xpath("//input[@name='keyword']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToHomePage() {		
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	public void searchProduct(String productName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(searchInput));
		wait.sendKeys(productName);
		wait.sendKeys(Keys.ENTER);
	}
}
