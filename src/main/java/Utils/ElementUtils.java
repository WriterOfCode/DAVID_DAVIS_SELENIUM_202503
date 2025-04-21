package Utils; 

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver; 

public class ElementUtils {

    /**
     * Checks if an element is present on the page.
     * 
     * @param driver WebDriver instance
     * @param locator By locator of the element
     * @return true if element is present, false otherwise
     */
    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

