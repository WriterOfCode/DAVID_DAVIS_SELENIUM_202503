/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week5_Test_app.java
 * Author: David Davis
 * Date: Apral  14, 2025
 */
package Pages; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class DAVIS_Selenium_Week4_page {
    protected  WebDriver driver;

    public DAVIS_Selenium_Week4_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@type='text' and @name='userName']")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@type='password' and @name='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath = "//input[@type='submit' and @name='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href='register.php' and  text()='REGISTER']")
    private WebElement registerLink;
    
    public void open() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    public void populateLogin(String username, String password) {
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    }

    public String getTitle() {
        return driver.getTitle();  
    }
    
    public void clickOnSubmitButton() {
        submitButton.click();
    }
    
    public void clickOnRegisterLink(){
        registerLink.click();
    }

    public void navagateToHomePage() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    public void navigateToLoginPage() {
        driver.get("https://demo.guru99.com/test/newtours/login.php");
    }
    
    public void navigateToRegisterPage() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }
    
    public void navigateforwardandbackPage() {
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
