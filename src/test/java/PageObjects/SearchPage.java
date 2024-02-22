package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	WebDriver driver;
	private WebElement wait;

	// Locators
	private final By searchResult = By.xpath("/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/a[1]");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchResultHasString(String name) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(searchResult));
		Assert.assertTrue(wait.getText().contains(name));
	}

}
