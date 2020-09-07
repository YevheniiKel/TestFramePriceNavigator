import driverSetup.SeleniumSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.HeaderAnyPage;
import pages.MainPage;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

import static util.elementUtils.WaitUtils.sleep;

public class TestRunner extends SeleniumSetUp {

    private String email;
    private String username;
    private String password;

    @Test
    public void testProductNotFoundPageBySearch() throws InterruptedException {
        openMainPage();
        HeaderAnyPage page = new HeaderAnyPage(driver);
        sleep();
        page.enterSearchQueryIntoSearchFieldAndPressEnter(CharDataForTestSite.INVALID_SEARCH_QUERY);
        Assert.assertTrue(page.isProductNotFountNotificationIsShown());
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        email = CharDataForTestSite.VALID_EMAIL;
        username = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;
        System.out.println(email + " " + username + " " + password);
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertEquals(mainPage.getLoggedInUserUsername(), username);
    }

    @Test
    public void testLoginWithNotRegisteredEmailAndPassword() throws InterruptedException {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertTrue(mainPage.invalidCredentialsNotificationIsShown());
    }

    @Test
    public void testLoginWithInvalidEmail() throws InterruptedException {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertTrue(mainPage.invalidEmailNotificationIsShown());
    }

    @Test
    public void checkThatUserCanOpenCataloguePageFromTheMainPage() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.isCatalogueIsDisplayed());
    }

    @Test
    public ComparingPage checkThatThreeProductsCanBeAddedToComparing() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        addProductsToComparingAndClickCompare(cataloguePage);
        ComparingPage comparingPage = new ComparingPage(driver);
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), 3);
        return comparingPage;
    }


    @Test
    public ComparingPage checkThatProductCanBeDeletedFromTheComparing() throws InterruptedException {
        ComparingPage comparingPage = checkThatThreeProductsCanBeAddedToComparing();
        comparingPage.deleteProductFromComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), 2);
        return comparingPage;
    }

    @Test
    public void testThatComparingLinkCreationFeatureGeneratesLinkAndItWorksProperly() throws InterruptedException {
        ComparingPage comparingPage = checkThatThreeProductsCanBeAddedToComparing()
                .clickGenerateComparingLink();
        comparingPage.setComparingLinkFromTheField();
        int amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        ComparingPage newComparingPage = new ComparingPage(driver);
        driver.get(ComparingPage.getComparingLink());
        sleep();
        Assert.assertEquals(newComparingPage.amountOfComparingProducts(), amountOfComparingProducts);
    }

    @Test(enabled = false)
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
        sleep();
        return mainPage;
    }

    private void openProductPage() {
        driver.get(CharDataForTestSite.PRODUCT_URL);
    }

    private void openCataloguePage() throws InterruptedException {
        openMainPage().chooseSubategory(CharDataForTestSite.CATEGORIES.stream().findAny().get());
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

    private ComparingPage a() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        addProductsToComparingAndClickCompare(cataloguePage);
        return new ComparingPage(driver);
    }
}
