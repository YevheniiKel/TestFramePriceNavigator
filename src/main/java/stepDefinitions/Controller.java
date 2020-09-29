package stepDefinitions;

import org.openqa.selenium.WebDriver;
import util.BrowserFactory;

public class Controller {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setupController() {
        this.driver = BrowserFactory.getDriver();
        this.driver.manage().window().maximize();
    }

    public void teardownController() {
        driver.quit();
    }
}