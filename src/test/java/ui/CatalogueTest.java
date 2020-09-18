package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import ui.driverSetup.BaseTestSetup;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @BeforeMethod
    public void catTestSetUp() {
        MainPage mainPage = new MainPage(driver).openPage();
        cataloguePage = mainPage.chooseAnySubCategory();
    }

    @Test
    public void openCataloguePageFromMainPage() {
        assertThat(cataloguePage.isCatalogueIsDisplayed())
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }
}
