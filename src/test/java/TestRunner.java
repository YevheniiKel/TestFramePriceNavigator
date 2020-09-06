import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import util.Generator;
import util.consts;

import static util.UtilSleep.sleep;


public class TestRunner {
    public static WebDriver driver;

    private static String email;
    private static String password;

    @BeforeClass
    public static void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void registrationTest() throws InterruptedException {
        openMainPage();
        MainPage page = new MainPage(driver);
        sleep();
        email = Generator.loginGenerator() + "@gmail.com";
        password = Generator.passGenerator();
        page.openLoginPopup()
                .clickRegisterButton()
                .enterRegEmail(email)
                .regEnterFirstPassword(password)
                .regEnterSecondPassword(password)
                .clickRegisterSignUpButton();
        Assert.assertEquals(email, page.getLoggedInUserUsername());
    }

    @Test
    public void testlogin() throws InterruptedException {
        openMainPage();
        MainPage page = new MainPage(driver);
        sleep();
        email = Generator.loginGenerator() + "@gmail.com";
        password = Generator.passGenerator();
        page.openLoginPopup().enterLogin(email).enterPass(password).clickSignIn();
        Assert.assertEquals(email, page.getLoggedInUserUsername());
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    private void openMainPage() {
        driver.get(consts.HOME_URL);

    }
}
