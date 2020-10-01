package steps;

import io.cucumber.java.en.Then;
import pages.CataloguePage;
import util.DriverManager;
import util.elementUtils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogueSteps {
    private CataloguePage cataloguePage;
    private WaitUtils wait;


    public CatalogueSteps(DriverManager driverManager) {
        cataloguePage = new CataloguePage(driverManager.getDriver());
        wait = new WaitUtils(driverManager.getDriver());
    }

    @Then("Catalogue is displayed")
    public void catalogueIsDisplayed() {
        assertThat(wait.isElementDisplayed(cataloguePage.catalogue))
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }
}
