package App2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import Base.DAVIS_Selenium_Week3_BaseClass;
import Pages.DAVIS_Selenium_Week4_page;

import Utils.ElementUtils;

public class DAVIS_Selenium_Week4_Test_app extends DAVIS_Selenium_Week3_BaseClass {
    @Test
    public void validateNewToursLogin() {
        // Create an instance of the GoogleHomePage
        DAVIS_Selenium_Week4_page newToursPage = new DAVIS_Selenium_Week4_page(webdriver);
        
        // Open Google homepage
        newToursPage.open();
        
        // Perform a search for "Selenium Grid"
        newToursPage.login("test", "1234test");

        // Verify the page title co
        Assertions.assertTrue(newToursPage.getTitle().contains("Login: Mercury Tours"),
                "Title does not contain expected text.");
        
        // Verify login success message
        Assertions.assertTrue(ElementUtils.isElementPresent(webdriver, By.xpath("//h3[text()='Login Successfully']")),
                "Title does not contain expected text.");
    }
}
