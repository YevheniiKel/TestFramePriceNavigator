package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.MainPage;
import util.DriverManager;
import util.elementUtils.WaitUtils;


public class SearchSteps {
    private MainPage mainPage;
    private DriverManager driverManager;
    private WaitUtils wait;


    public SearchSteps(DriverManager driverManager) {
        wait = new WaitUtils(driverManager.getDriver());
        mainPage = new MainPage(driverManager.getDriver());
        this.driverManager = driverManager;
    }

    @When("Enter {string} into search field and press enter")
    public void enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) {
        wait.sendKeysWhenReadyThenEnter(mainPage.searchField, searchQuery);
    }

    @Then("NothingToShow search notification should be shown")
    public void textCanBeDeletedFromTheSearchField() {
        Assertions.assertThat(mainPage.searchField.getText())
                .as("NothingToShow search notification is not shown")
                .isEmpty();
    }

    @Then("Product not found page is displayed")
    public void productNotFoundPageIsDisplayed() {
        Assertions.assertThat(mainPage.nothingToSHowInSearchResult.isDisplayed())
                .as("NothingToShow search notification is not shown").isTrue();
    }


}
