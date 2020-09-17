package ui.driverSetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestSetup {
    protected WebDriver driver;


    @BeforeMethod
    public void getNewDriver() {
        driver = BrowserFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
