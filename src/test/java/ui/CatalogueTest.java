package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CataloguePage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @BeforeClass
    public void catalogueTestSetup() {
        cataloguePage = new CataloguePage(driver);
    }

    @Test
    public void openCataloguePageFromMainPage() throws InterruptedException {
        openCataloguePage();
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
