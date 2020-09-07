import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HeaderPageFactory;
import pages.MainPage;
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
        HeaderPageFactory page = new HeaderPageFactory(driver);
        sleep();
        page.enterSearchQueryIntoSearchFieldAndPressEnter(Const.INVALID_SEARCH_QUERY);
        Assert.assertTrue(page.isProductNotFountNotificationIsShown());
    }


    @Test(priority = 2)
    public void testLoginWithValidCredentials() throws InterruptedException {
        openMainPage();
        MainPage page = new MainPage(driver);
        sleep();
        email = Const.VALID_EMAIL;
        username = Const.VALID_USERNAME;
        password = Const.VALID_PASSWORD;
        page.openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertEquals(page.getLoggedInUserUsername(),username);
    }
    @Test(priority = 3)
    public void testLoginWithNotRegisteredEmailAndPassword() throws InterruptedException {
        openMainPage();
        MainPage page = new MainPage(driver);
        sleep();
        email = Generator.loginGenerator();
        password = Generator.passGenerator();
        page.openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertTrue(page.invalidCredentialsNotificationIsShown());
    }

    @Test(priority = 4)
    public void testLoginWithInvalidEmail() throws InterruptedException {
        openMainPage();
        MainPage page = new MainPage(driver);
        sleep();
        email = Generator.loginGenerator();
        password = Generator.passGenerator();
        page.openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertTrue(page.invalidEmailNotificationIsShown());
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }

    private void openMainPage() {
        driver.get(Const.HOME_URL);

    }
}
