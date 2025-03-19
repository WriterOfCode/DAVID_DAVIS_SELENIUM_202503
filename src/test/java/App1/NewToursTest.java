package App1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import Core.BaseTest;
import Pages.NewToursPage;
import Utils.ElementUtils;

public class NewToursTest extends BaseTest {

    @Test
    public void validateNewToursLogin() {
        // Create an instance of the GoogleHomePage
        NewToursPage newToursPage = new NewToursPage(driver);
        
        // Open Google homepage
        newToursPage.open();
        
        // Perform a search for "Selenium Grid"
        newToursPage.login("test", "1234test");

        // Verify the page title co
        Assertions.assertTrue(newToursPage.getTitle().contains("Login: Mercury Tours"),
                "Title does not contain expected text.");
        
        // Verify login success message
        Assertions.assertTrue(ElementUtils.isElementPresent(driver, By.xpath("//h3[text()='Login Successfully']")),
                "Title does not contain expected text.");
    }
}

