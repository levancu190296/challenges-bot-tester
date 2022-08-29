package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	private String projectPath=System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
			System.out.println("run on " + browserName);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("h_firefox")) {
			System.out.println("run on " + browserName);
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless"); 
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}else if(browserName.equals("chrome")) {
			System.out.println("run on " + browserName);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("h_chrome")) {
			System.out.println("run on " + browserName);
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}else if(browserName.equals("edge")) {
			System.out.println("run on " + browserName);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://react-redux.realworld.io/");
		return driver;
		// apply any version that you want
		//WebDriverManager.chromedriver().browserVersion("94.5.7").setup();
		
	}
	
}
