package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.DataGenerator;

import java.util.List;

import static util.elementUtils.WaitUtils.*;


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

    @FindBy(xpath = ".//form[@id='register-form']//button[@class='form-btn']")
    WebElement registerSignUpButton; //confirm registration

    @FindBy(xpath = ".//form[@id='login-form']/following::a[not(@class = 'forgot-password') and @onclick]")
    WebElement registrationButton; // open registration form

    @FindBy(xpath = ".//span[@class='user-info']//span")
    WebElement userName;

    @FindBy(xpath = ".//input[@id='login-form-password']/following-sibling::div[contains(@class, 'hint')]")
    WebElement invalidCredentialsNotification;

    @FindBy(xpath = ".//input[@id='login-form-login']/following-sibling::div[contains(@class, 'hint')]")
    WebElement invalidEmailNotification;

    @FindBy(xpath = ".//div[@class='pc-block']//a[@title]")
    public List<WebElement> subCategories;

    public void openLoginPopup() {
        waitTillElementClickable(loginButton);
        loginButton.click();
    }

    public MainPage enterLogin(String email) {
        waitTillElementPresent(emailLoginField);
        emailLoginField.sendKeys(email);
        return this;
    }

    public MainPage enterPass(String password) {
        waitTillElementPresent(passwordLoginField);
        passwordLoginField.sendKeys(password);
        return this;
    }

    public MainPage clickSignIn() {
        waitTillElementClickable(signButton);
        signButton.click();
        return this;
    }

    public void clickRegisterButton() {
        waitTillElementClickable(registrationButton);
        registrationButton.click();
    }

    public void enterRegEmail(String email) {
        waitTillElementPresent(emailLoginField);
        emailRegisterField
                .sendKeys(email);
    }

    public void regEnterFirstPassword(String password) {
        waitTillElementPresent(passwordRegisterFieldFirst);
        passwordRegisterFieldFirst
                .sendKeys(password);
    }

    public void regEnterSecondPassword(String password) {
        waitTillElementPresent(passwordRegisterFieldSecond);
        passwordRegisterFieldSecond
                .sendKeys(password);
    }

    public void clickRegisterSignUpButton() {
        waitTillElementClickable(registerSignUpButton);
        registerSignUpButton.click();
    }

    public String getLoggedInUserUsername() {
        waitTillElementContainText(userName);
        return userName.getText();
    }

    public boolean invalidCredentialsNotificationIsShown() {
        waitTillElementPresent(invalidCredentialsNotification);
        return invalidCredentialsNotification.isDisplayed();
    }

    public boolean invalidEmailNotificationIsShown() {
        waitTillElementPresent(invalidEmailNotification);
        return invalidEmailNotification.isDisplayed();
    }

    public void chooseSubCategory(int categoryNumber) {
        waitTillMultElementsPresent(subCategories);
        subCategories.get(categoryNumber).click();
    }

    public void openAnyCataloguePage() {
        chooseSubCategory(DataGenerator.intGenerator(subCategories.size()));
    }
}
