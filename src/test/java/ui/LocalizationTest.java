package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class LocalizationTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    @BeforeMethod
    public void localizationTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver);
    }

    @Test
    public void siteDefaultCityIsKharkivTest() throws InterruptedException {
        sleepSeconds(3);
        Assert.assertEquals(headerAnyPage.searchField.getAttribute("placeholder"), "Найти товар в Харькове",
                String.format("The placeholder text is incorrect: %s", "Найти товар в Харькове"));
    }
}