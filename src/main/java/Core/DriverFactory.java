package Core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private final String executionMode;
    private final String browser;
    private final String gridURL;
    private WebDriver driver;

    public DriverFactory() {
        this.executionMode = ConfigReader.getProperty("executionMode").toLowerCase();
        this.browser = ConfigReader.getProperty("browser").toLowerCase();
        this.gridURL = ConfigReader.getProperty("gridURL");
    }

    public WebDriver initializeDriver() {
        if ("remote".equals(executionMode)) {
            driver = createRemoteDriver();
        } else {
            driver = createLocalDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getIntProperty("implicitWait")));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (browser) {
            case "chrome":
                return new ChromeDriver(new ChromeOptions());
            case "firefox":
                return new FirefoxDriver(new FirefoxOptions());
            case "edge":
                return new EdgeDriver(new EdgeOptions());
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private WebDriver createRemoteDriver() {
        try {
            URL seleniumGridURL = new URL(gridURL + "/wd/hub");
            switch (browser) {
                case "chrome":
                    return new RemoteWebDriver(seleniumGridURL, new ChromeOptions());
                case "firefox":
                    return new RemoteWebDriver(seleniumGridURL, new FirefoxOptions());
                case "edge":
                    return new RemoteWebDriver(seleniumGridURL, new EdgeOptions());
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Selenium Grid URL: " + gridURL, e);
        }
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

