import driverSetup.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.ComparingPage;
import pages.HeaderAnyPage;
import pages.MainPage;
import util.PropertyReader;
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
                PropertyReader.getMessage("productNotFountNotificationIsShownMessage"));
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        email = CharDataForTestSite.VALID_EMAIL;
        username = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;
        System.out.println(email + " " + username + " " + password);
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertEquals(
                mainPage.getLoggedInUserUsername(), username,
                PropertyReader.getMessage("UsernameIsNotShownAfterLogin"));
    }

    @Test
    public void testLoginWithNotRegisteredEmailAndPassword() throws InterruptedException {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertTrue(
                mainPage.invalidCredentialsNotificationIsShown(),
                PropertyReader.getMessage("invalidCredentialsNotificationIsNotShown"));
    }

    @Test
    public void testLoginWithInvalidEmail() throws InterruptedException {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        MainPage mainPage = openMainPage();
        enterCredentialsOnTheMainPageToLogin(mainPage);
        Assert.assertTrue(
                mainPage.invalidEmailNotificationIsShown(),
                PropertyReader.getMessage("invalidEmailNotificationIsNotShown"));
    }

    @Test
    public void checkThatUserCanOpenCataloguePageFromTheMainPage() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.isCatalogueIsDisplayed(),
                PropertyReader.getMessage("catalogueIsNotDisplayed"));

    }

    @Test
    public ComparingPage checkThatThreeProductsCanBeAddedToComparing() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        addProductsToComparingAndClickCompare(cataloguePage);
        ComparingPage comparingPage = new ComparingPage(driver);
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), 3,
                PropertyReader.getMessage("ComparingAmountIsNotMeetExpected"));
        return comparingPage;
    }


    @Test
    public ComparingPage checkThatProductCanBeDeletedFromTheComparing() throws InterruptedException {
        ComparingPage comparingPage = checkThatThreeProductsCanBeAddedToComparing();
        comparingPage.deleteProductFromComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), 2,
                PropertyReader.getMessage("ComparingAmountIsNotMeetExpected"));

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
        sleepSeconds(3);
        Assert.assertEquals(newComparingPage.amountOfComparingProducts(), amountOfComparingProducts,
                PropertyReader.getMessage("ComparingAmountIsNotMeetExpected"));

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
        sleepSeconds(3);
        return mainPage;
    }

    private void openProductPage() {
        driver.get(CharDataForTestSite.PRODUCT_URL);
    }

    private void openCataloguePage() throws InterruptedException {
        openMainPage().chooseSubCategory(CharDataForTestSite.CATEGORIES.stream().findAny().get());
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
