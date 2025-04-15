package App2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import Base.DAVIS_BaseTest;  
import Pages.DAVIS_Selenium_Week5_page;
import Utils.ElementUtils;

public class DAVIS_Selenium_Week5_Test_app extends DAVIS_BaseTest {
    @Test
    public void validateToursHomeAndLogin() {
        // Create an instance of the GoogleHomePage
         DAVIS_Selenium_Week5_page page4 = new DAVIS_Selenium_Week5_page(webdriver);
        // Open homepage
        page4.open();
        Assertions.assertTrue(page4.getTitle().contains("Welcome: Mercury Tours"),
        "Title does not contain expected text.");
     
        //login
        TakeSchreenshot("validateToursLogin");
        page4.login("test", "1234test");
        TakeSchreenshot("validateToursLogin");

        super.waitForElementToBeClickable( By.xpath("//input[@type='submit' and @name='submit']"));
        page4.clickOnSubmitButton(); 
        TakeSchreenshot("validateToursLogin");
        
        // Verify the page title co
        Assertions.assertTrue(page4.getTitle().contains("Login: Mercury Tours"),
               "Title does not contain expected text.");
        
        // Verify login success message
         Assertions.assertTrue(ElementUtils.isElementPresent(webdriver, 
            By.xpath("//h3[text()='Login Successfully']")),
            "Title does not contain expected text.");

        TakeSchreenshot("validateToursLogin");
    }
}