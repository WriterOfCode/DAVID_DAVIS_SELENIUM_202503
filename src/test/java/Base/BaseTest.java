package Base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import Core.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    private DriverFactory driverFactory;
    
    @BeforeEach
    public void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driverFactory != null) {
            driverFactory.quitDriver();
        }
    }
}

