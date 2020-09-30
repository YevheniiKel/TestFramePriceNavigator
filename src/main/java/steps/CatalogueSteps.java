package steps;

import io.cucumber.java.en.Then;
import pages.CataloguePage;

import static org.assertj.core.api.Assertions.assertThat;
import static util.DriverW8Wrapper.isElementDisplayed;

public class CatalogueSteps {
    private CataloguePage cataloguePage;

    public CatalogueSteps(DriverManager driverManager) {
        cataloguePage = new CataloguePage(driverManager.getDriver());
    }

    @Then("Catalogue is displayed")
    public void catalogueIsDisplayed() {
        assertThat(isElementDisplayed(cataloguePage.catalogue))
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }
}
