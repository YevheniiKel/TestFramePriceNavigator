package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @Test
    public void openCataloguePageFromMainPage() throws InterruptedException {
        openCataloguePage();
        cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.isCatalogueIsDisplayed(),
                "Catalogue is not displayed on the catalogue page");
    }

    private void openCataloguePage() throws InterruptedException {
        mainPage.chooseSubCategory(CharDataForTestSite
                .CATEGORIES
                .stream()
                .findAny()
                .get());
    }
}
