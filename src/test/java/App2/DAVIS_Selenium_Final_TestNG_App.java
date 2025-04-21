/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week5_Test_app.java
 * Author: David Davis
 * Date: Apral  14, 2025
 */
package App2;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import Base.DAVIS_BaseTestNG;
import Core.UserDto;
import Pages.DAVIS_Selenium_Newtours_login_page;
import Pages.DAVIS_Selenium_Newtours_page;
import Pages.DAVIS_Selenium_Register_Sucess_page;
import Pages.DAVIS_Selenium_Register_page;
import Utils.ElementUtils;



public class DAVIS_Selenium_Final_TestNG_App extends DAVIS_BaseTestNG {
    @Test(description ="Validate New Tours Page")
    public void validateNewToursHomeAndLogin() { 
        DAVIS_Selenium_Newtours_page page4 = new DAVIS_Selenium_Newtours_page(webdriver);

        // Open homepage
        page4.open(); 
        assertTrue(page4.getTitle().contains("Welcome: Mercury Tours"),
        "Title does not contain expected text.");
     
        //login
        takeSchreenshot("validateToursLoginNG");
        page4.populateLogin("test", "1234test");
        takeSchreenshot("validateToursLogin");

        super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
        page4.clickOnSubmitButton(); 
        takeSchreenshot("validateToursLoginNG");
        
        // Verify the page title co
        assertTrue(page4.getTitle().contains("Login: Mercury Tours"),
               "Title does not contain expected text.");
        
        // Verify login success message
         assertTrue(ElementUtils.isElementPresent(webdriver, 
            By.xpath("//h3[text()='Login Successfully']")),
            "Title does not contain expected text.");

        takeSchreenshot("validateToursLoginNG");
    };
    
 
    @Test(description ="Validate Register Page")
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
        assertTrue(register_page.getTitle().contains("Register: Mercury Tours"),
        "Title does not contain expected text.");
        //take picutre before any changes
        takeSchreenshot("validateRegisterPageNGTest");
        //fill out the form
        register_page.PopulateFormUserInformaion(userInfo);
        //take picutre of form filled out
        takeSchreenshot("validateRegisterPageNGTest");
        //wait for the submit button to be clickable. Assuming that the button would be 
        //defined not to allow someone to click on it untill the form is correctly filled out. 
        // If not you should raise and coner at the next meeting if we are in scrum then the int next scrum meeting.
        super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
        takeSchreenshot("validateRegisterPageNGTest");
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
        takeSchreenshot("validateRegisterPageNGTest");
        // Verify the page title so we know we are on the right page.
        assertTrue( sucess_page.getTitle().contains("Register: Mercury Tours"),
               "Title does not contain expected text.");
        assertTrue( sucess_page.getUserName().contains(userInfo.getUsername()),
        "Title does not contain expected text.");
        sucess_page.clickOnSignInLinkElement();
        // -----------------------------
        // navigate away form Register Sucess page
        // -----------------------------
        // -----------------------------
        // navigated to Register Sucess page
        // -----------------------------
        takeSchreenshot("validateRegisterPageNGTest");
        assertTrue( login_page.getTitle().contains("Sign-on: Mercury Tours"),
        "Title does not contain expected text.");
        login_page.populateLogin(userInfo.getUsername(),userInfo.getPassword());    
        takeSchreenshot("validateRegisterPageNGTest");
        login_page.clickOnSubmitButton();
        takeSchreenshot("validateRegisterPageNGTest");

    };
}