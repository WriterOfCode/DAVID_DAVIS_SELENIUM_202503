package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class DAVIS_Selenium_Week5_page  {
 
    public DAVIS_Selenium_Week5_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected  WebDriver driver;

    @FindBy(xpath = "//input[@type='text' and @name='userName']")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@type='password' and @name='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath = "//input[@type='submit' and @name='submit']")
    private WebElement submitButton;


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



//specflow
//https://demo.guru99.com/test/newtours/support.php
// Flightshotells https://demo.guru99.com/test/newtours/reservation.php
// Hotel https://demo.guru99.com/test/newtours/support.php
//https://www.lambdatest.com/blog/specflow-tutorial-for-automation-testing/
//https://testng.org/
//https://learn.microsoft.com/en-us/dotnet/csharp/programming-guide/classes-and-structs/access-modifiers
//https://www.google.com/search?q=selenium+screenshot&sca_esv=563a49081b992b59&rlz=1C1GEWG_enUS1072US1072&ei=S4n4Z-W-CrCawbkP_NDawAg&oq=selenium+screens&gs_lp=Egxnd3Mtd2l6LXNlcnAiEHNlbGVuaXVtIHNjcmVlbnMqAggAMgUQABiABDIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyBRAAGIAEMgcQABiABBgKSJaXAVCCA1jLeHAIeAGQAQCYAW2gAeMKqgEEMTcuMbgBAcgBAPgBAZgCGqAC0AyoAhTCAgoQABiwAxjWBBhHwgINEAAYgAQYsAMYQxiKBcICExAAGIAEGEMYtAIYigUY6gLYAQHCAhAQABgDGLQCGOoCGI8B2AECwgIQEC4YAxi0AhjqAhiPAdgBAsICChAAGIAEGEMYigXCAgoQLhiABBhDGIoFwgILEC4YgAQYsQMYgwHCAg4QLhiABBjHARiOBRivAcICBRAuGIAEwgILEAAYgAQYsQMYgwHCAgsQLhiABBjRAxjHAcICDRAAGIAEGLEDGEMYigXCAggQLhiABBixA8ICDhAuGIAEGLEDGNEDGMcBwgIIEAAYgAQYsQPCAhAQABiABBixAxhDGIMBGIoFwgILEAAYgAQYkQIYigXCAgcQABiABBgNwgIJEAAYgAQYChgNmAMG8QV0HRL0Gv3pzogGAZAGCroGBAgBGAe6BgYIAhABGAqSBwQyNC4yoAegigGyBwQxNi4yuAfyCw&sclient=gws-wiz-serp
//https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver