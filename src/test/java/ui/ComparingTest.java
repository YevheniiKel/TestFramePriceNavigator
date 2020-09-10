package ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.ComparingPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class ComparingTest extends BaseTestSetup {

    private CataloguePage cataloguePage;
    private ComparingPage comparingPage;

    @BeforeMethod
    public void comparingTestSetup() {
        cataloguePage = new CataloguePage(driver);
        comparingPage = new ComparingPage(driver);
    }

    @Test
    public void ThreeProductsAddedToComparing() throws InterruptedException {
        int productsToCompare = 3;
        ComparingPage comparingPage = openCataloguePageAndAddThreeProductsToComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), productsToCompare,
                String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare));
    }

    @Test
    public void deleteOneProductFromComparingList() throws InterruptedException {
        int productsToCompare = 2;
        comparingPage = openCataloguePageAndAddThreeProductsToComparing();
        comparingPage.deleteProductFromComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), productsToCompare,
                String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare));
    }

    @Test
    public void comparingLinkGeneratorTest() throws InterruptedException {
        comparingPage = openCataloguePageAndAddThreeProductsToComparing()
                .clickGenerateComparingLink();
        comparingPage.setComparingLinkFromTheField();
        int amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        ComparingPage newComparingPage = new ComparingPage(driver);
        driver.get(ComparingPage.getComparingLink());
        sleepSeconds(3);
        Assert.assertEquals(newComparingPage.amountOfComparingProducts(), amountOfComparingProducts,
                String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), ++amountOfComparingProducts));
    }

    private void openCataloguePage() throws InterruptedException {
        mainPage.chooseSubCategory(CharDataForTestSite
                .CATEGORIES
                .stream()
                .findAny()
                .get());
    }

    private ComparingPage openCataloguePageAndAddThreeProductsToComparing() throws InterruptedException {
        openCataloguePage();
        cataloguePage = new CataloguePage(driver);
        addProductsToComparingAndClickCompare(cataloguePage);
        comparingPage = new ComparingPage(driver);
        return comparingPage;
    }

    private void addProductsToComparingAndClickCompare(CataloguePage cataloguePage) {
        cataloguePage.addThreeProductsToComparing();
        cataloguePage.clickCompare();
    }
}
