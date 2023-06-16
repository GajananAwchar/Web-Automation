package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private By logoutBtn = By.cssSelector("div[id='loop-container'] div>a");
	private By menuItemCount = By.cssSelector("[id='menu-primary-items'] li");
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickLogoutBtn() {
		driver.findElement(logoutBtn).click();
	}
	public String getTitle() {
		String actTitle = driver.getTitle();
		return actTitle;
	}
	public int getMenuItemsSize() {
		return driver.findElements(menuItemCount).size();
	}
}
