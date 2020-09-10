package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

public class SearchTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    @BeforeClass
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver);
    }

    @Test
    public void resultsNotFoundProductPageTest() throws InterruptedException {
        headerAnyPage.enterSearchQuery(CharDataForTestSite.INVALID_SEARCH_QUERY);
        Assert.assertTrue(headerAnyPage.isProductNotFountNotificationIsShown(),
                "NothingToShow search notification is not shown");
    }

    @Test
    public void textCanBeDeletedFromTheSearchField() {
        headerAnyPage.searchField.sendKeys(CharDataForTestSite.INVALID_SEARCH_QUERY);
        Assert.assertEquals(headerAnyPage.searchField.getText(), "",
                "NothingToShow search notification is not shown");
    }
}
