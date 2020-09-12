package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.DataGenerator;

import java.util.List;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[@class='user-info']")
    WebElement loginButton;

    @FindBy(xpath = ".//input[@id='login-form-login']")
    WebElement emailLoginField;

    @FindBy(xpath = ".//input[@id='login-form-password']")
    WebElement passwordLoginField;

    @FindBy(xpath = ".//button[@id='loginButton']")
    WebElement signButton;

    @FindBy(xpath = ".//form[@id='register-form']")
    WebElement registerFrame;

    @FindBy(xpath = ".//input[@id='register-form-email']")
    WebElement emailRegisterField;

    @FindBy(xpath = ".//input[@id='register-form-password']")
    WebElement passwordRegisterFieldFirst;

    @FindBy(xpath = ".//input[@id='register-form-password_repeat']")
    WebElement passwordRegisterFieldSecond;

    @FindBy(xpath = ".//parent::form[@id='register-form']//button[@class='form-btn']")
    WebElement registerSignUpButton; //confirm registration

    @FindBy(xpath = ".//form[@id='login-form']/..//a[not(@class='forgot-password')]")
    WebElement registrationButton; // open registration form

    @FindBy(xpath = ".//span[@class='user-info']//span")
    WebElement userName;

    @FindBy(xpath = ".//input[@id='login-form-password']/following-sibling::div[contains(@class, 'hint')]")
    WebElement invalidCredentialsNotification;

    @FindBy(xpath = ".//input[@id='login-form-login']/following-sibling::div[contains(@class, 'hint')]")
    WebElement invalidEmailsNotification;

    @FindBy(xpath = ".//div[@class='pc-block']//a[@title]")
    public List<WebElement> subCategories;

    public void openLoginPopup() throws InterruptedException {
        loginButton.click();
        sleepSeconds(3);
    }

    public MainPage enterLogin(String email) {
        emailLoginField.sendKeys(email);
        return this;
    }

    public MainPage enterPass(String password) throws InterruptedException {
        passwordLoginField.sendKeys(password);
        sleepSeconds(3);
        return this;
    }

    public MainPage clickSignIn() throws InterruptedException {
        signButton.click();
        sleepSeconds(3);
        return this;
    }

    public MainPage clearEmailField() throws InterruptedException {
        emailLoginField.clear();
        System.out.println(emailLoginField.getText());
        sleepSeconds(3);
        return this;
    }

    public void clickRegisterButton() throws InterruptedException {
        registrationButton.click();
        sleepSeconds(1);
    }

    public void enterRegEmail(String email) {
        emailRegisterField
                .sendKeys(email);
    }

    public void regEnterFirstPassword(String password) {
        passwordRegisterFieldFirst
                .sendKeys(password);
    }

    public void regEnterSecondPassword(String password) {
        passwordRegisterFieldSecond
                .sendKeys(password);
    }

    public void clickRegisterSignUpButton() throws InterruptedException {
        registerSignUpButton.click();
        sleepSeconds(3);
    }

    public String getLoggedInUserUsername() {
        return userName.getText();
    }

    public boolean invalidCredentialsNotificationIsShown() {
        return invalidCredentialsNotification.isDisplayed();
    }

    public boolean invalidEmailNotificationIsShown() {
        return invalidEmailsNotification.isDisplayed();
    }

    public void chooseSubCategory(int categoryNumber) throws InterruptedException {
        subCategories.get(categoryNumber).click();
        sleepSeconds(3);
    }

    public void openAnyCataloguePage() throws InterruptedException {
        chooseSubCategory(DataGenerator.intGenerator(subCategories.size()));
    }
}
