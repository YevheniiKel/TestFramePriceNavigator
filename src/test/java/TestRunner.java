import driverSetup.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.HeaderAnyPage;
import pages.MainPage;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class TestRunner extends BaseTestSetup {

    private String email;
    private String username;
    private String password;

    @Test
    public void testProductNotFoundPageBySearch() throws InterruptedException {
        openMainPage();
        HeaderAnyPage page = new HeaderAnyPage(driver);
        sleepSeconds(3);
        page.enterSearchQueryIntoSearchFieldAndPressEnter(CharDataForTestSite.INVALID_SEARCH_QUERY);
        Assert.assertTrue(page.isProductNotFountNotificationIsShown(),
                "NothingToShow search notification is not shown");
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        email = CharDataForTestSite.VALID_EMAIL;
        username = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertEquals(
                mainPage.getLoggedInUserUsername(), username,
                "Account username is not shown in the right top corner of the page");
    }

    @Test
    public void testLoginWithNotRegisteredEmailAndPassword() throws InterruptedException {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertTrue(
                mainPage.invalidCredentialsNotificationIsShown(),
                "Invalid credentials notification is not shown");
    }

    @Test
    public void testLoginWithInvalidEmail() throws InterruptedException {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertTrue(
                mainPage.invalidEmailNotificationIsShown(),
                "Invalid email notification is not shown");
    }

    @Test
    public void checkThatUserCanOpenCataloguePageFromTheMainPage() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.isCatalogueIsDisplayed(),
                "Catalogue is not displayed on the catalogue page");

    }

    @Test
    public void checkThatThreeProductsCanBeAddedToComparing() throws InterruptedException {
        int productsToCompare = 3;
        ComparingPage comparingPage = openCataloguePageAndAddThreeProductsToComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), productsToCompare,
                String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare));
    }


    @Test
    public void checkThatProductCanBeDeletedFromTheComparing() throws InterruptedException {
        int productsToCompare = 2;
        ComparingPage comparingPage = openCataloguePageAndAddThreeProductsToComparing();
        comparingPage.deleteProductFromComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), productsToCompare,
                String.format("Amount of comparing products = %s doesn't meet expected amount %s.\n",
                        comparingPage.amountOfComparingProducts(), productsToCompare));
    }

    @Test
    public void testThatComparingLinkCreationFeatureGeneratesLinkAndItWorksProperly() throws InterruptedException {
        ComparingPage comparingPage = openCataloguePageAndAddThreeProductsToComparing()
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
//______________________________________________________________________________

    @Test(enabled = true)
    public void testFavoriteShopsFeature() throws InterruptedException {
//        openMainPage();
        //NOT IMPLEMENTED
    }

    @Test(enabled = false)
    public void test1() throws InterruptedException {
//        openMainPage();
        //NOT IMPLEMENTED
    }

    private MainPage openMainPage() throws InterruptedException {
        driver.get(CharDataForTestSite.HOME_URL);
        MainPage mainPage = new MainPage(driver);
        sleepSeconds(3);
        return mainPage;
    }

    private void openProductPage() {
        driver.get(CharDataForTestSite.PRODUCT_URL);
    }

    private void openCataloguePage() throws InterruptedException {
        openMainPage().chooseSubCategory(CharDataForTestSite.CATEGORIES.stream().findAny().get());
    }

    private ComparingPage openCataloguePageAndAddThreeProductsToComparing() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        addProductsToComparingAndClickCompare(cataloguePage);
        ComparingPage comparingPage = new ComparingPage(driver);
        return comparingPage;
    }


    private void enterCredentialsOnTheMainPageToLogin(MainPage mainPage) throws InterruptedException {
        mainPage.openLoginPopup();
        mainPage.enterLogin(email)
                .enterPass(password)
                .clickSignIn();
    }

    private void addProductsToComparingAndClickCompare(CataloguePage cataloguePage) {
        cataloguePage.addThreeProductsToComparing();
        cataloguePage.clickCompare();
    }
}
