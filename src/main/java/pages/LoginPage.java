package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.id("submit");
	private By sucessMessage = By.cssSelector("[id='loop-container'] [class='post-title']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	// [id='loop-container'] [class='post-title']
	public String getSucessMessage() {
		String message = driver.findElement(sucessMessage).getText();
		return message;

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public String getUrl(String url) {
		driver.get(url);
		return url;
	}
	public String getTitle() {
		String actTitle = driver.getTitle();
		return actTitle;
	}
}
