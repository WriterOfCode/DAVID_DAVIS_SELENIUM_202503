/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week5_Test_app.java
 * Author: David Davis
 * Date: Apral  14, 2025
 */
package Pages;

import Core.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class NewtoursLoginPage {
    protected  WebDriver driver;
    protected UserDto userInfo;
    public NewtoursLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='userName']")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@type='password' and @name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @name='submit']")
    private WebElement submitButton;

    public String getTitle() {
        return driver.getTitle();  
    }
    public void clickOnSubmitButton() {
        submitButton.click();
    }
    public void populateLogin(String username, String password) {
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    }
 
}