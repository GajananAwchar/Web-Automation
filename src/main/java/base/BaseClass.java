package base;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	protected static WebDriver driver;
	protected static PageObjectManager pageObjectManager;
	protected static ReadConfig readConfig;
	protected static Logger logger;
	protected static SoftAssert softAssert;
	protected static SeleniumFunctions seleniumFunctions;

	@Parameters("browser")
	@BeforeClass
	public static void setUp(String browser) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name: " + browser);
		}
		pageObjectManager = new PageObjectManager(driver);
		readConfig = new ReadConfig();
		PropertyConfigurator.configure("log4j.properties");
		seleniumFunctions  = new SeleniumFunctions(driver);
	}

	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("driver Session Closed Sucessfully");
		}
	}
}
