package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.MainPage;
import utils.driverUtils.DriverProvider;
import utils.driverUtils.DriverWrapper;


public class SearchSteps {

    private DriverWrapper driver;

    public SearchSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
    }

    @When("User searches for {string}")
    public void enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) {
        var mainPage = new MainPage(driver);
        driver.sendKeysWhenReadyThenEnter(mainPage.header.searchField, searchQuery);
    }

    @Then("NothingToShow search notification is be shown")
    public void textCanBeDeletedFromTheSearchField() {
        var mainPage = new MainPage(driver);
        Assertions.assertThat(mainPage.header.searchField.getText())
                .as("NothingToShow search notification is not shown")
                .isEmpty();
    }

    @Then("Product not found page is displayed")
    public void productNotFoundPageIsDisplayed() {
        var mainPage = new MainPage(driver);
        Assertions.assertThat(mainPage.header.nothingToSHowInSearchResult.isDisplayed())
                .as("NothingToShow search notification is not shown").isTrue();
    }
}
