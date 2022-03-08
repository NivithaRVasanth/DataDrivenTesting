package testCases;

// setup - open browser,logger ,teardown
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.readConfig;

public class BaseClass {

	readConfig read=new readConfig();

	String url=read.getUrl();
	String email=read.getEmail();
	String password=read.getPassword();

	String chromePath=read.getChromePath();
	String IEPath=read.getIEPath();
	String firefoxPath=read.getFirefoxPath();

	WebDriver driver;
	Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		logger=Logger.getLogger("DataDrivenTesting");
		PropertyConfigurator.configure("log4j.properties");

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver=new ChromeDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", IEPath);
			driver=new EdgeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println("Set A Browser at XML");
			break;
		}
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
