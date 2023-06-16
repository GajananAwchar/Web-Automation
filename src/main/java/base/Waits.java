package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

	private WebDriver driver;
	private WebDriverWait wait;
	private Wait<WebDriver> fluentWait;
	private Wait<WebDriver> explicitWait;

	public Waits(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.fluentWait = new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class); 
	}

	public void setImplicitWait(int timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
	}

	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(driver -> driver.findElement(locator).isEnabled() ? driver.findElement(locator) : null);
	}

	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(driver -> driver.findElement(locator).isDisplayed() ? driver.findElement(locator) : null);
	}

	public boolean waitForElementToBeInvisible(By locator) {
		return fluentWait.until(driver -> driver.findElements(locator).isEmpty());
	}

	public boolean waitForTextToBePresentInElement(By locator, String text) {
		return fluentWait.until(driver -> driver.findElement(locator).getText().contains(text));
	}

	public WebElement waitForElementToBeClickableExplicitWait(By locator) {
		return explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
