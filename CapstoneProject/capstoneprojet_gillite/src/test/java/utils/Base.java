package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;
	public static FileInputStream file;
	public static Properties prop;
	public static WebDriverWait wait;
	public String userDir = System.getProperty("user.dir");

	public void openBrowser() {
		prop = PropertyReader.loadProperties();
		String browserName = prop.getProperty("browser");

		switch (browserName.toLowerCase()) {
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
			System.err.println("Unsupported browser: " + browserName);
			break;
		}

		if (driver != null)

		{
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.get(prop.getProperty("url"));
		}
		
		// Dont remove the listener Object

	//WebDriverListener listener = new EventHandler();
		//driver = new EventFiringDecorator<>(listener).decorate(driver);

	
	}
	public static void pause(int millSec) {
		try {
			Thread.sleep(millSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	

