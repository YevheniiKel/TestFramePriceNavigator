import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    private WebElement loginButton = driver.findElement(By.className("user-info"));
    private WebElement emailField;// = driver.findElement(By.id("login-form-login"));
    private WebElement passwordField;// = driver.findElement(By.id("login-form-password"));

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public MainPage openLoginPopup(){
        loginButton.click();
        //todo logger
        return this;
    }

    public MainPage enterLogin(){
        //todo logger
        emailField = driver.findElement(By.id("login-form-login"));
        emailField.sendKeys("emaisdfaskjdfnl@mail.mail");
        return this;
    }
    public MainPage enterPass(){
        //todo logger
        passwordField = driver.findElement(By.id("login-form-password"));
        passwordField.sendKeys("password");
        return this;
    }
}
