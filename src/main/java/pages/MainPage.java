package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class MainPage {

    private WebDriver driver;

    @FindBy(className = "search-text-input")
    WebElement searchField;

    @FindBy(className = "user-info")
    WebElement loginButton;

    @FindBy(id = "login-form-login")
    WebElement emailLoginField;
    @FindBy(id = "login-form-password")
    WebElement passwordLoginField;

    @FindBy(css = "#register-form-container #register-form")
    WebElement registerFrame;
    @FindBy(css = "#register-form-email")
    WebElement emailRegisterField;
    @FindBy(css = "#register-form-password")
    WebElement passwordRegisterFieldFirst;
    @FindBy(css = "#register-form-password_repeat")
    WebElement passwordRegisterFieldSecond;
    @FindBy(css = ".form-btn")
    WebElement registerSignUpButton;

    @FindBy(id = "loginButton")
    WebElement signButton;
    @FindBy(linkText = "Зарегистрируйтесь")
    WebElement registrationButton;
    @FindBy(css = "div.base:nth-child(3) div.base-container header.header div.td-table div.td-block:nth-child(2) div.links.dropdown nav.links-nav:nth-child(1) ul:nth-child(1) li:nth-child(4) span.user-info a:nth-child(1) > span:nth-child(2)")
    WebElement userName;
    @FindBy(xpath = "//div[@class='form-group field-login-form-password required has-error']//div[@class='dropdown-hint afterLeft']")
    WebElement invalidCredentialsNotification;
    @FindBy(xpath = "//div[@class='form-group field-login-form-login required has-error']//div[@class='dropdown-hint afterLeft']")
    WebElement invalidEmailsNotification;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public String getLoggedInUserUsername() {
        return userName.getText();
    }

    public boolean invalidCredentialsNotificationIsShown() {
        return invalidCredentialsNotification.isDisplayed();
    }

    public boolean invalidEmailNotificationIsShown() {
        return invalidEmailsNotification.isDisplayed();
    }

    public void chooseSubCategory(String category) throws InterruptedException {
        driver.findElement(By.linkText(category)).click();
        sleepSeconds(3);
    }
}
