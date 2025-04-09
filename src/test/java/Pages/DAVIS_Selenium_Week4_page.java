package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class DAVIS_Selenium_Week4_page {
    private WebDriver driver;

    @FindBy(name = "userName")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButton;

    public DAVIS_Selenium_Week4_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    public void login(String username, String password) {
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    	submitButton.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
 
}
