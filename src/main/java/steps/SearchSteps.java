package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.MainPage;
import util.driverUtils.DriverProvider;
import util.driverUtils.DriverWrapper;


public class SearchSteps {

    private DriverWrapper driver;
    private MainPage mainPage;

    public SearchSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
    }

    @When("User searches for {string}")
    public void enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) {
        mainPage = new MainPage(driver);
        driver.sendKeysWhenReadyThenEnter(mainPage.header.searchField, searchQuery);
    }

    @Then("NothingToShow search notification is be shown")
    public void textCanBeDeletedFromTheSearchField() {
        mainPage = new MainPage(driver);
        Assertions.assertThat(mainPage.header.searchField.getText())
                .as("NothingToShow search notification is not shown")
                .isEmpty();
    }

    @Then("Product not found page is displayed")
    public void productNotFoundPageIsDisplayed() {
        mainPage = new MainPage(driver);
        Assertions.assertThat(mainPage.header.nothingToSHowInSearchResult.isDisplayed())
                .as("NothingToShow search notification is not shown").isTrue();
    }
}
