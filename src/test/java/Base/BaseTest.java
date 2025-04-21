package Base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import Core.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    private DriverFactory driverFactory;
    
    @BeforeEach
    protected void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver();
    }

    @AfterEach
    protected void tearDown() {
        if (driverFactory != null) {
            driverFactory.quitDriver();
        }
    }
}

