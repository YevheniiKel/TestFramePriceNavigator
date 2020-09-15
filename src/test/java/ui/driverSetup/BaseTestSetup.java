package ui.driverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import util.dataUtils.CharDataForTestSite;
import util.elementUtils.WaitUtils;

public class BaseTestSetup {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUP() {
        driver = BrowserFactory.getDriver();
        WaitUtils.webDriverWait = new WebDriverWait(driver, 10);
    }

    @BeforeMethod
    public void openMainPage() {
        driver.manage().deleteAllCookies();
        driver.get(CharDataForTestSite.HOME_URL);
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
