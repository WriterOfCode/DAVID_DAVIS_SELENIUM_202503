package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class DAVIS_Selenium_Week4_page {
    protected  WebDriver driver;

    @FindBy(xpath = "//input[@type='text' and @name='userName']")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@type='password' and @name='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath = "//input[@type='submit' and @name='submit']")
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
    }

    public String getTitle() {
        return driver.getTitle();  
    }



    public void navagateToHomePage() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }
    public void clickOnSubmitButton() {
        submitButton.click();
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
