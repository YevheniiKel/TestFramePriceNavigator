import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {
    public static WebDriver driver;

    public static void setUP(){
        driver = new ChromeDriver();
    }

    public static void test() throws InterruptedException {
        driver.get("https://pn.com.ua/");
        System.out.println("driver=" + driver);
        MainPage page = new MainPage(driver);
        System.out.println("driver=" + driver);
        Thread.sleep(1000);
        // page.openLoginPopup().enterLogin().enterPass();



    }
    public static void tearDown(){
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        setUP();
        test();
    }
}
