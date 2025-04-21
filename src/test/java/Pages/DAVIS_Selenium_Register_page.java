/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week5_Test_app.java
 * Author: David Davis
 * Date: Apral  14, 2025
 */
package Pages;

import Core.UserDto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select; 

public class DAVIS_Selenium_Register_page {
    protected  WebDriver driver;
    protected UserDto userInfo;

    public DAVIS_Selenium_Register_page(WebDriver driver ) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

//---------------------------------------
// Contact Information
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneInput;

    // there is a bug in this page where the lable is email and the input name is username  
    @FindBy(xpath = "//input[@name='userName']")
    private WebElement emailInput;
//Mailing Information

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address1Input;


    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;


    @FindBy(xpath = "//input[@name='state']")
    private WebElement stateInput;


    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countrysWebInput;

//User Informaion
    
    // there is a bug in this page where the lable is User Name and the input name is email
    //@FindBy(xpath = "//input[@type='text' and @name='userName']")
    @FindBy(xpath = "//input[@id='email']")
    private WebElement usernameInput;
    
    @FindBy(xpath = "//input[@type='password' and @name='password']")
    private WebElement passwordInput;
    
    @FindBy(xpath = "//input[@type='password' and @name='confirmPassword']")
    private WebElement confirmPasswordInput;

    
    
    @FindBy(xpath = "//input[@type='submit' and @name='submit']")
    private WebElement submitButton;

    public void Open() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    public String getTitle() {
        return driver.getTitle();  
    }
    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void selectCountry(String countryname) {
        Select contries_dropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        if (contries_dropdown.isMultiple()) contries_dropdown.deselectAll();

        contries_dropdown.selectByValue(countryname);
    }

    public void selectCountryByMouseClick(String countryname) {
        Select contries_dropdown = new Select(driver.findElement(By.name("country")));
        if (contries_dropdown.isMultiple()) contries_dropdown.deselectAll();


        List<WebElement> allOptions =  contries_dropdown.getOptions(); 

        // Iterate the list using for loop

        for (int i = 0; i < allOptions.size(); i++) {

            if (allOptions.get(i).getText().contains(countryname)) {
    
            allOptions.get(i).click();
    
            System.out.println("clicked");
    
            break;
    
            }
    
        }
 
    }

    public void PopulateFormUserInformaion(UserDto userInfo){ 
        this.userInfo = userInfo;
        firstNameInput.sendKeys(userInfo.getFirstName());
        lastNameInput.sendKeys(userInfo.getLastName());
        phoneInput.sendKeys(userInfo.getPhone());
        emailInput.sendKeys(userInfo.getEmail());
        address1Input.sendKeys(userInfo.getAddress1());
        cityInput.sendKeys(userInfo.getCity());
        stateInput.sendKeys(userInfo.getState());
        postalCodeInput.sendKeys(userInfo.getPostalcode());
        //countrysWebInput.sendKeys(userInfo.getCountry());
        selectCountry(userInfo.getCountry());
        usernameInput.sendKeys(userInfo.getUsername());
        passwordInput.sendKeys(userInfo.getPassword());
        confirmPasswordInput.sendKeys(userInfo.getPassword());
    }
}





