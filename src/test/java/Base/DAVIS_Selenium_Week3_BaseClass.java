package Base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Utils.ConfigReader;
import java.time.Duration;

public class DAVIS_Selenium_Week3_BaseClass {

    protected WebDriver webdriver;

    @BeforeEach
    public WebDriver initializeChromeDriver() {
        webdriver = getWebDriver("chrome");
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("implicitWait")));
        webdriver.manage().window().maximize();
        return webdriver;
    }

    @AfterEach
    public void quitDriver() {
        if (webdriver != null) {
            webdriver.quit();
        }
    }
    
    public WebDriver getWebDriver() {
        return webdriver;
    }
        
    private WebDriver getWebDriver(String browserName) {
			switch (browserName.toLowerCase()) {
            case "chrome":
        		ChromeOptions chromeOptions = getDefaultChromeOptions();
	      	    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	      	    WebDriver driver = new ChromeDriver(chromeOptions);
	  			return driver;
            case "firefox":
            	throw new java.lang.UnsupportedOperationException("Firefox not supported yet.");
            case "edge":
            	throw new java.lang.UnsupportedOperationException("Edge not supported yet.");
            default:
            	throw new java.lang.UnsupportedOperationException("Not supported yet.");
 
			}
    }

    private ChromeOptions getDefaultChromeOptions() {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--no-sandbox");
	    options.addArguments("start-maximized");
	    return options;
  	}
}