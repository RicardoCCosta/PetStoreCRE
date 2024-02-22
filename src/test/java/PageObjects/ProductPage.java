package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {
	WebDriver driver;
	private WebElement wait;

	// Locators
	private final By firstProductCell = By.xpath("/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/a[1]");
	private final By addToCartButton = By.xpath("//tbody/tr[2]/td[5]/a[1]");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToCategoryPage(String category) {
		driver.get(
				"https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId="+category);
	}
	
	public void clickOnFirstProduct() {
		Helpers.Helper.waitLoad();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(firstProductCell));
		wait.click();
	}
	
	public void addFirstProductToCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		wait.click();
	}


	
}
