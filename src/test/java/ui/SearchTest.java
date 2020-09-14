package ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    @BeforeClass
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver);
    }

    @Test
    public void resultsNotFoundPageTest() throws InterruptedException {
        headerAnyPage.enterSearchQuery(CharDataForTestSite.INVALID_SEARCH_QUERY);
        assertThat(headerAnyPage.nothingToSHowInSearchResult.isDisplayed()).isTrue()
                .withFailMessage("NothingToShow search notification is not shown");
    }

    @Test
    public void textCanBeDeletedFromTheSearchField() {
        headerAnyPage.searchField.sendKeys(CharDataForTestSite.INVALID_SEARCH_QUERY);
        assertThat(headerAnyPage.searchField.getText().isEmpty())
                .overridingErrorMessage("NothingToShow search notification is not shown");
        //just using lazy initialization of string.
        // To use or not to use?
        // (In this usual case)
    }
}
