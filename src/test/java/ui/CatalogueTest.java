package ui;

import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import ui.driverSetup.BaseTestSetup;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @Test
    public void openCataloguePageFromMainPage() {
        MainPage mainPage = new MainPage(driver).openPage();
        cataloguePage = mainPage.chooseAnySubCategory();
        assertThat(cataloguePage.isCatalogueIsDisplayed())
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }
}
