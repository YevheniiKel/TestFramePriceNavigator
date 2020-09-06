package pages;

import com.sun.jdi.event.StepEvent;
import util.UtilSleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    private By loginButton = By.className("user-info");
    private By emailLoginField = By.id("login-form-login");
    private By passwordLoginField = By.id("login-form-password");

    private By emailRegisterField = By.xpath("//input[@id='register-form-email']");
    private By passwordRegisterFieldFirst = By.className("form-group field-register-form-password required");
    private By passwordRegisterFieldSecond = By.className("form-group field-register-form-password_repeat");
    private By registerSignUpButton = By.xpath("//form[@id='register-form']//button[@class='form-btn']");

    private By signButton = By.id("loginButton");
    private By registrationButton = By.linkText("Зарегистрируйтесь");
    private By userName = By.xpath("//span[@class='user-info']//a//*[local-name()='svg']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage openLoginPopup() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        //todo logger
        return this;
    }

    public MainPage clickRegisterButton(){
        driver.findElement(registrationButton).click();
        return this;
    }
    public MainPage enterRegEmail(String email){
        driver.findElement(emailRegisterField)
                .sendKeys(email);
        return this;
    }
    public MainPage regEnterFirstPassword(String password){
        driver.findElement(passwordRegisterFieldFirst)
                .sendKeys(password);
        return this;
    }
    public MainPage regEnterSecondPassword(String password){
        driver.findElement(passwordRegisterFieldSecond)
                .sendKeys(password);
        return this;
    }
    public MainPage clickRegisterSignUpButton(){
        driver.findElement(registerSignUpButton).click();
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
        UtilSleep.sleep();
        return this;
    }

    public MainPage clickSignIn() throws InterruptedException {
        driver.findElement(signButton).click();
        UtilSleep.sleep();
    return this;
    }

    public String getLoggedInUserUsername(){

        System.out.println(driver.findElement(userName).getText());
        return driver.findElement(userName).getText();
    }
}
