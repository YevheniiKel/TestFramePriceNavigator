import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import util.Generator;
import util.Const;

import static util.UtilSleep.sleep;


public class TestRunner {
    public static WebDriver driver;

    private static String email;
    private static String username;
    private static String password;

    @BeforeMethod
    public static void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testProductNotFoundPageBySearch() throws InterruptedException {
        openMainPage();
        HeaderAnyPage page = new HeaderAnyPage(driver);
        sleep();
        page.enterSearchQueryIntoSearchFieldAndPressEnter(Const.INVALID_SEARCH_QUERY);
        Assert.assertTrue(page.isProductNotFountNotificationIsShown());
    }


    @Test(priority = 6)
    public void testLoginWithValidCredentials() throws InterruptedException {
        email = Const.VALID_EMAIL;
        username = Const.VALID_USERNAME;
        password = Const.VALID_PASSWORD;
        MainPage mainPage = openMainPage().openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertEquals(mainPage.getLoggedInUserUsername(),username);
    }
    @Test(priority = 3)
    public void testLoginWithNotRegisteredEmailAndPassword() throws InterruptedException {

        email = Generator.loginGenerator();
        password = Generator.passGenerator();
        MainPage mainPage = openMainPage().openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertTrue(mainPage.invalidCredentialsNotificationIsShown());
    }

    @Test(priority = 4)
    public void testLoginWithInvalidEmail() throws InterruptedException {
        email = Generator.loginGenerator();
        password = Generator.passGenerator();
        MainPage mainPage = openMainPage().openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertTrue(mainPage.invalidEmailNotificationIsShown());
    }


    @Test(priority = 5)
    public void checkThatUserCanOpenCataloguePageFromTheMainPage() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        Assert.assertTrue(cataloguePage.isCatalogueIsDisplayed());
    }

    @Test(priority = 1)
    public ComparingPage checkThatThreeProductsCanBeAddedToComparing() throws InterruptedException {
        openCataloguePage();
        CataloguePage cataloguePage = new CataloguePage(driver);
        cataloguePage.addThreeProductsToComparing().clickCompare();
        ComparingPage comparingPage = new ComparingPage(driver);
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), 3);
        return comparingPage;
    }


    @Test(priority = 2)
    public ComparingPage checkThatproductCanBeDeletedFromTheComparing() throws InterruptedException {
        ComparingPage comparingPage = checkThatThreeProductsCanBeAddedToComparing();
        comparingPage.deleteProductFromComparing();
        Assert.assertEquals(comparingPage.amountOfComparingProducts(), 2);
        return comparingPage;
    }

    @Test(priority = 2)
    public void testThatComparingLinkCreationFeatureGeneratesLinkAndItWorksProperly() throws InterruptedException {
        ComparingPage comparingPage = checkThatThreeProductsCanBeAddedToComparing().clickGenerateComparingLink();
        comparingPage.setComparingLinkFromTheField();
        int amountOfComparingProducts = comparingPage.amountOfComparingProducts();
        ComparingPage newComparingPage = new ComparingPage(driver);
        driver.get(ComparingPage.getComparingLink());
        sleep();
        Assert.assertEquals(newComparingPage.amountOfComparingProducts(), amountOfComparingProducts);
    }

    @Test(priority = 4,enabled=false)
    public void testFavoriteShopsFeature() throws InterruptedException {
//        openMainPage();
    //NOT IMPLEMENTED
    }

    @Test(priority = 4,enabled=false)
    public void test1() throws InterruptedException {
//        openMainPage();
        //NOT IMPLEMENTED
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }

    private MainPage openMainPage() throws InterruptedException {
        driver.get(Const.HOME_URL);
        MainPage mainPage = new MainPage(driver);
        sleep();
        return mainPage;
    }
    private void openProductPage() {
        driver.get(Const.PRODUCT_URL);
    }
    private void openCataloguePage() throws InterruptedException {
        openMainPage().chooseSubategory(Const.CATEGORIES.stream().findAny().get());
    }
}
