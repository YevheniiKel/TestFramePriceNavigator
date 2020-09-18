package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.MainPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparingTest extends BaseTestSetup {

    private CataloguePage cataloguePage;
    private ComparingPage comparingPage;
    private MainPage mainPage;

    @BeforeMethod
    public void comparingTestSetup() {
        driver.get(CharDataForTestSite.HOME_URL);
        mainPage = new MainPage(driver);
        cataloguePage = mainPage.chooseAnySubCategory();
        cataloguePage.addThreeProductsToComparing();
        comparingPage = cataloguePage.clickCompare();
    }

    @Test
    public void threeProductsAddedToComparing() {

        int productsToCompare = 3;
        assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare))
                .isEqualTo(productsToCompare);
    }

    @Test
    public void deleteOneProductFromComparingList() {
        cataloguePage = mainPage.chooseAnySubCategory();
        cataloguePage.addThreeProductsToComparing();
        comparingPage = cataloguePage.clickCompare();
        int productsToCompare = 2;
        comparingPage.deleteProductFromComparing();
        assertThat(comparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare))
                .isEqualTo(productsToCompare);
    }

    @Test
    public void comparingLinkGeneratorTest() {
        comparingPage.clickGenerateComparingLink();
        comparingPage.setComparingLinkFromTheField();
        int amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        ComparingPage newComparingPage = new ComparingPage(driver);
        driver.get(ComparingPage.getComparingLink());
        assertThat(newComparingPage.amountOfComparingProducts())
                .as(String.format("Amount of comparing products = %s doesn't meet expected amount = %s.\n",
                        comparingPage.amountOfComparingProducts(), amountOfComparingProducts))
                .isEqualTo(amountOfComparingProducts);
    }
}
