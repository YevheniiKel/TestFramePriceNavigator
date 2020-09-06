package pages;

import com.sun.jdi.event.StepEvent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import util.UtilSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.UtilSleep.sleep;

public class MainPage {

    private WebDriver driver;

    private By loginButton = By.className("user-info");
    private By emailLoginField = By.id("login-form-login");
    private By passwordLoginField = By.id("login-form-password");

    private By registerFrame = By.cssSelector("#register-form-container #register-form");
    private By emailRegisterField = By.cssSelector("#register-form-email");
    private By passwordRegisterFieldFirst = By.cssSelector("#register-form-password");
    private By passwordRegisterFieldSecond = By.cssSelector("#register-form-password_repeat");
    private By registerSignUpButton = By.cssSelector(".form-btn");

    private By signButton = By.id("loginButton");
    private By registrationButton = By.linkText("Зарегистрируйтесь");
    private By userName = By.cssSelector("div.base:nth-child(3) div.base-container header.header div.td-table div.td-block:nth-child(2) div.links.dropdown nav.links-nav:nth-child(1) ul:nth-child(1) li:nth-child(4) span.user-info a:nth-child(1) > span:nth-child(2)");

    private By invalidCredentialsNotification = By.xpath("//div[@class='form-group field-login-form-password required has-error']//div[@class='dropdown-hint afterLeft']");
    private By invalidEmailsNotification = By.xpath("//div[@class='form-group field-login-form-login required has-error']//div[@class='dropdown-hint afterLeft']");
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage openLoginPopup() throws InterruptedException {
        driver.findElement(loginButton).click();
        sleep();
        //todo logger
        return this;
    }

    public MainPage enterLogin(String email){
        //todo logger
        driver.findElement(emailLoginField)
                .sendKeys(email);

        return this;
    }

    public MainPage enterPass(String password) throws InterruptedException {
        //todo logger
        driver.findElement(passwordLoginField)
                .sendKeys(password);
        sleep();
        return this;
    }

    public MainPage clickSignIn() throws InterruptedException {
        driver.findElement(signButton).click();
        sleep();
    return this;
    }

    public String getLoggedInUserUsername(){
        return driver.findElement(userName).getText();
    }

    public boolean invalidCredentialsNotificationIsShown() {
        return driver.findElement(invalidCredentialsNotification).isDisplayed();
    }
    public boolean invalidEmailNotificationIsShown() {
        return driver.findElement(invalidEmailsNotification).isDisplayed();
    }
}
