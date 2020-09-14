package ui;

import org.testng.annotations.Test;
import pages.CataloguePage;
import ui.driverSetup.BaseTestSetup;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @Test
    public void openCataloguePageFromMainPage() throws InterruptedException {
        mainPage.openAnyCataloguePage();
        cataloguePage = new CataloguePage(driver);
        assertThat(cataloguePage.isCatalogueIsDisplayed()).isTrue()
                .overridingErrorMessage("Catalogue is not displayed on the catalogue page");
    }
}
