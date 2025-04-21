/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_BaseTest.java
 * Author: David Davis
 * Date: April  14, 2025
 * Updated April 16, 2025
 */

package Base; 

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Core.DAVIS_DriverFactory;
import Utils.ConfigReader;

public class DAVIS_BaseTestJunit {
    
    protected WebDriver webdriver;
    private DAVIS_DriverFactory driverFactory;
    private String screenshotPath; // Path to save screenshots

    public DAVIS_BaseTestJunit() {
        this.screenshotPath = ConfigReader.getProperty("screenshotPath"); // Path to save screenshots
    }
 
    @BeforeEach// This annotation is used to indicate that the method should be executed before each test method in the current class.
    public void setUp() {
        driverFactory = new DAVIS_DriverFactory();
        webdriver = driverFactory.initializeDriver(); // Initialize the WebDriver using the DriverFactory class
    }
 
    @AfterEach
    public void tearDown() {
        if (webdriver != null) {
            webdriver.quit();
        }
        
        if (driverFactory != null) {
            driverFactory.quitDriver();
        }
    }
    
    public WebDriver getWebDriver() {
        return webdriver;
    }
    public String getScreenshotPath() {
        return screenshotPath;
    }
    /**
     * This function will take screenshot
     * @param TestName
     * @return
     */
    public Void takeSchreenshot(String TestName) { 
        String filePath = getScreenshotPathAndFile(TestName);
        try {
            TakeSnapShot(filePath); // Call the method to take a screenshot
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
        return null;    
    }
    /// This function will create the path and file name for the screenshot
    /// @param TestName 
    private String  getScreenshotPathAndFile(String TestName) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(System.currentTimeMillis());
        return screenshotPath + "/" + TestName + "/" + timestamp + ".png"; // Append timestamp to the screenshot file name
    }

    /**
    * This function will take screenshot
    * @param fileWithPath
    * @throws Exception
    */
    private void TakeSnapShot(String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot 
        TakesScreenshot scrShot =((TakesScreenshot)this.webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
    /**
     * This FluentWait function will wait for the element to be visible
     * @param locator
     */
    public void waitForElementToBeVisible(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(this.webdriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    /**
     * This FluentWait function will wait for the element to be clickable
     * @param locator
     */
    public void waitForElementToBeClickable( By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(this.webdriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        
        wait.until(ExpectedConditions.elementToBeClickable(locator));   
    }
}
