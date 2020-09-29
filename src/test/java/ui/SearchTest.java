package ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import util.dataUtils.CharDataForTestSite;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private HeaderAnyPage headerAnyPage;
    WebDriver driver;

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
