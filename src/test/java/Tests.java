import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
    public static WebDriver driver;

    public static WebElement loginButton;
    public static     WebElement emailField;
    public static     WebElement passwordField;


    public static void setUP(){
        driver = new ChromeDriver();
    }

    public static void test() throws InterruptedException {
        driver.get("https://pn.com.ua/");

        System.out.println("driver=" + driver);
//        MainPage page = new MainPage(driver);
        loginButton = driver.findElement(By.xpath("//span[@class='user-info']"));

        loginButton.click();
        Thread.sleep(3000);
        emailField = driver.findElement(By.xpath("//input[@id='login-form-login']"));
        passwordField = driver.findElement(By.xpath("//input[@id='login-form-password']"));
        emailField.sendKeys("dkjasdjk@CSJankd.ds");

        Thread.sleep(1000);
        passwordField.sendKeys("password");

        Thread.sleep(1000);

    }
    public static void tearDown(){
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        setUP();
        test();
    }
}
