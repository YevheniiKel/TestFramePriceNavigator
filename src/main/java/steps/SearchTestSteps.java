package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.MainPage;


public class SearchTestSteps {
    private MainPage mainPage;
    private DriverManager driverManager;

    public SearchTestSteps(DriverManager driverManager) {
        mainPage = new MainPage(driverManager.getDriver());
        this.driverManager = driverManager;
    }

    @When("Enter {string} into search field and press enter")
    public void enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) {
        mainPage.enterSearchQuery(searchQuery);
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
