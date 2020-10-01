package util;

import org.openqa.selenium.WebDriver;
import util.BrowserFactory;

import java.util.Objects;

public class DriverManager {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setupController() {
        this.driver = BrowserFactory.getDriver();
        this.driver.manage().window().maximize();
    }

    public void teardownController() {
        if (Objects.nonNull(driver))
            try {
                driver.manage().deleteAllCookies();
            } catch (Exception ex) {
                System.out.println(String.format("An  exception  occurred while cookie deleting: %s", ex));
            }try {
                driver.close();
            } catch (Exception ex) {
                System.out.println(String.format("An  exception  occurred while driver closing: %s", ex));
            }try {
                driver.quit();
            } catch (Exception ex) {
                System.out.println(String.format("An  exception  occurred while cookie deleting: %s", ex));
            }
        driver = null;
    }
}