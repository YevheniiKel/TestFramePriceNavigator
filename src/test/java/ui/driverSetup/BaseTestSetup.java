package ui.driverSetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import util.dataUtils.CharDataForTestSite;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class BaseTestSetup {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUP() throws InterruptedException {
        driver = BrowserFactory.getDriver();
        sleepSeconds(3);
    }

    @BeforeMethod
    public void openMainPage() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(CharDataForTestSite.HOME_URL);
        mainPage = new MainPage(driver);
        sleepSeconds(2);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
