package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static util.elementUtils.WaitUtils.sleepSeconds;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='user-info']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='login-form-login']")
    WebElement emailLoginField;

    @FindBy(xpath = "//input[@id='login-form-password']")
    WebElement passwordLoginField;

    @FindBy(xpath = "//button[@id='loginButton']")
    WebElement signButton;

    @FindBy(xpath = "//span[@class='user-info']//span")
    WebElement userName;

    @FindBy(xpath = "//input[@id='login-form-password']/../div[contains(@class, 'hint')]")
    WebElement invalidCredentialsNotification;

    @FindBy(xpath = "//input[@id='login-form-login']/../div[contains(@class, 'hint')]")
    WebElement invalidEmailsNotification;

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
