package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @BeforeMethod
    public void catTestSetUp() {
        driver.get(CharDataForTestSite.HOME_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseAnySubCategory();
        cataloguePage = new CataloguePage(driver);
    }

    @Test
    public void openCataloguePageFromMainPage() {
        assertThat(cataloguePage.isCatalogueIsDisplayed())
                .as("Catalogue is not displayed on the catalogue page")
                .isTrue();
    }
}
