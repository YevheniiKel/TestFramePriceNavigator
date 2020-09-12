package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import ui.driverSetup.BaseTestSetup;

public class CatalogueTest extends BaseTestSetup {

    private CataloguePage cataloguePage;

    @Test
    public void openCataloguePageFromMainPage() throws InterruptedException {
        mainPage.openAnyCataloguePage();
        cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.isCatalogueIsDisplayed(),
                "Catalogue is not displayed on the catalogue page");
    }
}
