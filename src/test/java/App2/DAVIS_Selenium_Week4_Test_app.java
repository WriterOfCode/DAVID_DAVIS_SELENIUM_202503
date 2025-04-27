/**
 * Project Name: DAVID_DAVIS_SELENIUM_202503
 * File Name: DAVIS_Selenium_Week4_Test_app.java
 * Author: David Davis
 * Date: April 1, 2025
 */
package App2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import Base.DAVIS_BaseTestJunit;
import Pages.NewToursTestNgPage;
import Utils.ElementUtils;

public class DAVIS_Selenium_Week4_Test_app extends DAVIS_BaseTestJunit {
    @Test
    public void validateToursLogin() {
        // Create an instance of the GoogleHomePage
    	NewToursTestNgPage page4 = new NewToursTestNgPage(webdriver);
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
    }
}