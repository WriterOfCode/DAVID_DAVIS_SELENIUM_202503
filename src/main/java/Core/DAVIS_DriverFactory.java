package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Utils.ConfigReader;
import java.time.Duration;


public class DAVIS_DriverFactory {
    private final String browser;

    private WebDriver driver;

    public DAVIS_DriverFactory() {
        this.browser = ConfigReader.getProperty("browser").toLowerCase();
    }
    public WebDriver initializeDriver() {
        driver = buildSpecifiedDriver(browser) ;
        return driver;
    }
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    private WebDriver buildSpecifiedDriver(String browserName) {
        if (browserName == null || browserName.isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty.");
        }
        
        // Convert the browser name to lowercase for case-insensitive comparison
        // Initialize the WebDriver based on the requested browser name
			switch (browserName.toLowerCase()) {
            case "chrome":
	  			return initializeChromeDriver();
            case "firefox":
            	throw new java.lang.UnsupportedOperationException("Firefox not supported yet.");
            case "edge":
            	throw new java.lang.UnsupportedOperationException("Edge not supported yet.");
            default:
            	throw new java.lang.UnsupportedOperationException("Not supported yet.");
 
			}
    }
    public WebDriver initializeChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // Start the browser maximized   
        WebDriver webdriver = new ChromeDriver(chromeOptions);
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("implicitWait")));
        webdriver.manage().window().maximize();
        return webdriver;
    }
}

