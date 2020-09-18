package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    @BeforeMethod
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver).openPage();
    }

    @Test
    public void resultsNotFoundPageTest() {
        headerAnyPage.enterSearchQuery(CharDataForTestSite.INVALID_SEARCH_QUERY);
        assertThat(headerAnyPage.nothingToSHowInSearchResult.isDisplayed())
                .as("NothingToShow search notification is not shown").isTrue();
    }

    @Test
    public void textCanBeDeletedFromTheSearchField() {
        headerAnyPage.searchField.sendKeys(CharDataForTestSite.INVALID_SEARCH_QUERY);
        assertThat(headerAnyPage.searchField.getText())
                .as("NothingToShow search notification is not shown")
                .isEmpty();
    }
}
