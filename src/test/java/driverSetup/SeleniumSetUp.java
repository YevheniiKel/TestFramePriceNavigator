package driverSetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumSetUp {
    public WebDriver driver;

    @BeforeMethod
    public void setUP() {
        driver = BrowserFactory.getDriver1("BROWSER");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
