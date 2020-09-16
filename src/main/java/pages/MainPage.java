package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.DataGenerator;

import java.util.List;

public class MainPage extends BasePage {

    private String defaultUsernameFiledValue;

    public MainPage(WebDriver driver) {
        super(driver);
        wait.waitMainElementAppear(loginButton);
        defaultUsernameFiledValue = getLoggedInUserUsername();
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
        wait.clickWhenReady(loginButton);
    }

    public MainPage enterLogin(String email) {
        wait.sendKeysWhenReady(emailLoginField, email);
        return this;
    }

    public MainPage enterPass(String password) {
        wait.sendKeysWhenReady(passwordLoginField, password);
        return this;
    }

    public MainPage clickSignIn() {
        wait.clickWhenReady(signButton);
        return this;
    }

    public void clickRegisterButton() {
        wait.clickWhenReady(registrationButton);

    }

    public void enterRegEmail(String email) {
        wait.sendKeysWhenReady(emailRegisterField, email);
    }

    public void regEnterFirstPassword(String password) {
        wait.sendKeysWhenReady(passwordRegisterFieldFirst, password);
    }

    public void regEnterSecondPassword(String password) {
        wait.sendKeysWhenReady(passwordRegisterFieldSecond, password);
    }

    public void clickRegisterSignUpButton() {
        wait.clickWhenReady(registerSignUpButton);
    }

    public String getLoggedInUserUsername() {
        wait.tillTextInElementChanged(userName, defaultUsernameFiledValue);
        return userName.getText();
    }

    public boolean invalidCredentialsNotificationIsShown() {
        wait.tillElementPresent(invalidCredentialsNotification);
        return invalidCredentialsNotification.isDisplayed();
    }

    public boolean invalidEmailNotificationIsShown() {
        wait.tillElementPresent(invalidEmailNotification);
        return invalidEmailNotification.isDisplayed();
    }

    //todo iselemtainTExt(login) return bool

    public void chooseSubCategory(int categoryNumber) {
        wait.tillElementsPresent(subCategories);
        subCategories.get(categoryNumber).click();
    }

    public void openAnyCataloguePage() {
        chooseSubCategory(DataGenerator.intGenerator(subCategories.size()));
    }
}
