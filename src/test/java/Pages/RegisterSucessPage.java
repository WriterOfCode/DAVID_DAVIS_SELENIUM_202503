/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week5_Test_app.java
 * Author: David Davis
 * Date: Apral  14, 2025
 * On of the disscusion I have about he pom. Some examples show the pom or this fille would contain 
 * validations such as assert's.
 * I think that you can clasify this better. have more granularity.
 * so I defined this page as enclapselating the simplification of access the elements of a web page for 
 * the specific domain i.e. the test. 
 * It is not a do all. It should not do both the wraping the elements needed to test and doing the actural test.
 * So what I would want in here is one thing (give me a simplified )
 */

package Pages;

import Core.UserDto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class RegisterSucessPage {

    protected  WebDriver driver;
    protected UserDto userInfo;

    public RegisterSucessPage(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='login.php' and contains(text(),'sign-in') ]") 
    private WebElement signInLinkElement;

    public void clickOnSignInLinkElement(){
        signInLinkElement.click();
    }

    public String getTitle() {
        return driver.getTitle();  
    }
    
    public String getUserName(){
        WebElement m = driver.findElement (By.xpath ("//*[contains(text(),'Note: Your user name is ')]"));  
        return  m.getText();
    }
}
