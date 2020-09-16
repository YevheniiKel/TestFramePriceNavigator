package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.ComparingPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparingTest extends BaseTestSetup {

    private int amountOfSubcategories;

    private CataloguePage cataloguePage;
    private ComparingPage comparingPage;

    @BeforeMethod
    public void comparingTestSetup() {
        openCataloguePageAndAddThreeProductsToComparing();
    }

    @Test
    public void threeProductsAddedToComparing() {
        int productsToCompare = 3;
        ComparingPage comparingPage = openCataloguePageAndAddThreeProductsToComparing();
        assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare))
                .isEqualTo(productsToCompare);
    }

    @Test
    public void deleteOneProductFromComparingList() {
        int productsToCompare = 2;
        comparingPage = openCataloguePageAndAddThreeProductsToComparing();
        comparingPage.deleteProductFromComparing();
        assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare))
                .isEqualTo(productsToCompare);
    }

    @Test
    public void comparingLinkGeneratorTest() {
        comparingPage = openCataloguePageAndAddThreeProductsToComparing()
                .clickGenerateComparingLink();
        comparingPage.setComparingLinkFromTheField();
        int amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        ComparingPage newComparingPage = new ComparingPage(driver);
        driver.get(ComparingPage.getComparingLink());
        assertThat(newComparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), ++amountOfComparingProducts))
                .isEqualTo(amountOfComparingProducts);
    }

    private void openAnyCataloguePage() {
        amountOfSubcategories = mainPage.subCategories.size();
        mainPage.subCategories//todo filter lambda findany
                .get(DataGenerator.intGenerator(amountOfSubcategories))
                .click();
    }

    private ComparingPage openCataloguePageAndAddThreeProductsToComparing() {
        openAnyCataloguePage();
        cataloguePage = new CataloguePage(driver);
        return addProductsToComparingAndClickCompare(cataloguePage);
    }

    private ComparingPage addProductsToComparingAndClickCompare(CataloguePage cataloguePage) {
        cataloguePage.addThreeProductsToComparing();
        cataloguePage.clickCompare();
        return new ComparingPage(driver);//TODO
    }
}
