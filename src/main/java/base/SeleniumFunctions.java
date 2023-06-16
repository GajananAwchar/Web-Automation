package base;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie;

public class SeleniumFunctions {
	private WebDriver driver;
	private Actions actions;
	private Select select;
	private Alert alert;

	public SeleniumFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void click(By locator) {
		findElement(locator).click();
	}

	public void sendKeys(By locator, String text) {
		findElement(locator).sendKeys(text);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public WebElement waitForElement(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElement(By locator, int timeoutInSeconds, int pollingIntervalInMillis) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingIntervalInMillis));

		return wait.until((Function<WebDriver, WebElement>) d -> d.findElement(locator));
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		driver.manage().addCookie(cookie);
	}

	public Cookie getCookie(String name) {
		return driver.manage().getCookieNamed(name);
	}

	public void deleteCookie(String name) {
		driver.manage().deleteCookieNamed(name);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void moveToElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	public void click(WebElement element) {
		actions.click(element).perform();
	}

	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void deselectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}

	public void deselectByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}

	public void deselectByValue(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);
	}

	public void deselectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);
	}

	public boolean isMultiple(WebElement element) {
		select = new Select(element);
		return select.isMultiple();
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeysToAlert(String text) {
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void openUrl(String url) {
		driver.get(url);
	}
	public String getTItle() {
		return driver.getTitle();
	}

}
