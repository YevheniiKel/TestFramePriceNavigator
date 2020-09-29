package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.HeaderAnyPage;


public class SearchTestSteps {
    private HeaderAnyPage headerAnyPage;
    private Controller controller;

    public SearchTestSteps(Controller controller) {
        this.controller = controller;
    }

    @When("Open main page with header")
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(controller.getDriver()).openPage();
    }

    @When("Enter {string} into search field and press enter")
    public void enterSearchQueryIntoSearchFieldAndPressEnter(String searchQuery) {
        headerAnyPage.enterSearchQuery(searchQuery);
    }

    @Then("NothingToShow search notification should be shown")
    public void textCanBeDeletedFromTheSearchField() {
        Assertions.assertThat(headerAnyPage.searchField.getText())
                .as("NothingToShow search notification is not shown")
                .isEmpty();
    }

    @Then("Product not found page is displayed")
    public void productNotFoundPageIsDisplayed() {
        Assertions.assertThat(headerAnyPage.nothingToSHowInSearchResult.isDisplayed())
                .as("NothingToShow search notification is not shown").isTrue();
    }


}
