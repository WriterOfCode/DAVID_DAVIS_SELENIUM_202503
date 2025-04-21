/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week5_Test_app.java
 * Author: David Davis
 * Date: Apral  14, 2025
 */
package App2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By; 


import Core.UserDto;
import Utils.ElementUtils;
import Base.DAVIS_BaseTestJunit;
import Pages.DAVIS_Selenium_Newtours_login_page;
import Pages.DAVIS_Selenium_Newtours_page;
import Pages.DAVIS_Selenium_Register_Sucess_page;
import Pages.DAVIS_Selenium_Register_page;
 
// https://www.browserstack.com/guide/design-patterns-in-automation-framework
public class DAVIS_Selenium_Week5_Test_app extends DAVIS_BaseTestJunit {
    @Test
    @Order(2)
    @DisplayName("Validate New Tours Login")
    public void validateNewToursHomeAndLogin() { 
        DAVIS_Selenium_Newtours_page page4 = new DAVIS_Selenium_Newtours_page(webdriver);

        // Open homepage
        page4.open();
        Assertions.assertTrue(page4.getTitle().contains("Welcome: Mercury Tours"),
        "Title does not contain expected text.");
     
        //login
        takeSchreenshot("validateToursLogin");
        page4.populateLogin("test", "1234test");
        takeSchreenshot("validateToursLogin");

        super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
        page4.clickOnSubmitButton(); 
        takeSchreenshot("validateToursLogin");
        
        // Verify the page title co
        Assertions.assertTrue(page4.getTitle().contains("Login: Mercury Tours"),
               "Title does not contain expected text.");
        
        // Verify login success message
         Assertions.assertTrue(ElementUtils.isElementPresent(webdriver, 
            By.xpath("//h3[text()='Login Successfully']")),
            "Title does not contain expected text.");

        takeSchreenshot("validateToursLogin");
    };

    @Test
    @Order(1)
    @DisplayName("Validate Registration page")
    public void validateRegisterPage(){ 
        DAVIS_Selenium_Register_page register_page = new DAVIS_Selenium_Register_page(webdriver);   
        DAVIS_Selenium_Register_Sucess_page sucess_page = new DAVIS_Selenium_Register_Sucess_page(webdriver);  
        DAVIS_Selenium_Newtours_login_page login_page = new DAVIS_Selenium_Newtours_login_page(webdriver);
        
        // Define user
        UserDto userInfo = new UserDto();
        userInfo.setFirstName("David");
        userInfo.setLastName("Davis");
        userInfo.setPhone("8635143974");
        userInfo.setEmail("davis2go@hotmail.com");
        userInfo.setAddress1("123456 Geek way");
        userInfo.setCity("digital");
        userInfo.setState("informaion");    
        userInfo.setPostalcode("101010010");
        userInfo.setCountry("IRAN");
        userInfo.setUsername("writerofcode@gmail.com");
        userInfo.setPassword("12rdqw42!@SA");
        // -----------------------------
        //newtours register page
         // -----------------------------
        // Open the regiser page
        register_page.Open();
        //are we on the right page
        Assertions.assertTrue(register_page.getTitle().contains("Register: Mercury Tours"),
        "Title does not contain expected text.");
        //take picutre before any changes
        takeSchreenshot("validateRegisterPage");
        //fill out the form
        register_page.PopulateFormUserInformaion(userInfo);
        //take picutre of form filled out
        takeSchreenshot("validateRegisterPage");
        //wait for the submit button to be clickable. Assuming that the button would be 
        //defined not to allow someone to click on it untill the form is correctly filled out. 
        // If not you should raise and coner at the next meeting if we are in scrum then the int next scrum meeting.
        super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
        takeSchreenshot("validateRegisterPage");
        // submit the register form
        register_page.clickOnSubmitButton(); 
        // -----------------------------
        // navigate away form register page.
        // -----------------------------
        // this could be a long wait
        // A website page should ideally load in two seconds or less. 
        // This timeframe is considered fast for a positive user experience and can impact SEO.
        
        // -----------------------------
        // navigated to Register Sucess page
        // -----------------------------
        takeSchreenshot("validateRegisterPage");
        // Verify the page title so we know we are on the right page.
        Assertions.assertTrue( sucess_page.getTitle().contains("Register: Mercury Tours"),
               "Title does not contain expected text.");
         Assertions.assertTrue( sucess_page.getUserName().contains(userInfo.getUsername()),
        "Title does not contain expected text.");
        sucess_page.clickOnSignInLinkElement();
        // -----------------------------
        // navigate away form Register Sucess page
        // -----------------------------
        // -----------------------------
        // navigated to Register Sucess page
        // -----------------------------
        takeSchreenshot("validateRegisterPage"); 

        Assertions.assertTrue( login_page.getTitle().contains("Sign-on: Mercury Tours"),
        "Title does not contain expected text.");
        login_page.populateLogin(userInfo.getUsername(),userInfo.getPassword());    
        takeSchreenshot("validateRegisterPage");
        login_page.clickOnSubmitButton();
        takeSchreenshot("validateRegisterPage");

    };
}