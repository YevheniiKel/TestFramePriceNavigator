package ui.driverSetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import util.dataUtils.CharDataForTestSite;

public class BaseTestSetup {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUP() {
        driver = BrowserFactory.getDriver();
    }

    @BeforeMethod
    public void openMainPage() {
        driver.manage().deleteAllCookies();
        driver.get(CharDataForTestSite.HOME_URL);//todo open method in base page
        mainPage = new MainPage(driver);
    }

    @AfterClass//TODO
    public void tearDown() {
        driver.quit();
    }
}
