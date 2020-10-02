package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderAnyPage extends BasePage {

    public HeaderAnyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@class = 'search-text-input']")
    public WebElement searchField;

    @FindBy(xpath = ".//div[@class='no-block']")
    public WebElement nothingToSHowInCatalogue;

    @FindBy(xpath = ".//div[@class='search-info']")
    public WebElement nothingToSHowInSearchResult;

    @FindBy(xpath = ".//span[@class='user-info']")
    public WebElement loginButton;

    @FindBy(xpath = ".//input[@id='login-form-login']")
    public WebElement emailLoginField;

    @FindBy(xpath = ".//input[@id='login-form-password']")
    public WebElement passwordLoginField;

    @FindBy(xpath = ".//button[@id='loginButton']")
    public WebElement signButton;

    @FindBy(xpath = ".//form[@id='register-form']")
    public WebElement registerFrame;

    @FindBy(xpath = ".//input[@id='register-form-email']")
    public WebElement emailRegisterField;

    @FindBy(xpath = ".//input[@id='register-form-password']")
    public WebElement passwordRegisterFieldFirst;

    @FindBy(xpath = ".//input[@id='register-form-password_repeat']")
    public WebElement passwordRegisterFieldSecond;

    @FindBy(xpath = ".//form[@id='register-form']//button[@class='form-btn']")
    public WebElement registerSignUpButton; //confirm registration

    @FindBy(xpath = ".//form[@id='login-form']/following::a[not(@class = 'forgot-password') and @onclick]")
    public WebElement registrationButton; // open registration form

    @FindBy(xpath = ".//span[@class='user-info']//span")
    public WebElement userName;

    @FindBy(xpath = ".//input[@id='login-form-password']/following-sibling::div[contains(@class, 'hint')]")
    public WebElement invalidCredentialsNotification;

    @FindBy(xpath = ".//input[@id='login-form-login']/following-sibling::div[contains(@class, 'hint')]")
    public WebElement invalidEmailNotification;

    @FindBy(xpath = ".//div[@class='popup-content-text']")
    public WebElement loginPopup;

    @FindBy(xpath = ".//div[contains(@class, 'popup-register')]")
    public WebElement registrationPopup;

    @Override
    public void waitForMainElements() {
        wait.tillElementPresent(searchField);
        wait.tillElementPresent(loginButton);
    }

    @Override
    public HeaderAnyPage openPage() {
        throw new UnsupportedOperationException("This page should not be loaded directly");
    }

    public void enterCredentials(UserDto userDto) {
        wait.sendKeysWhenReady(emailLoginField, userDto.getEmail());
        wait.sendKeysWhenReady(passwordLoginField, userDto.getPassword());
        wait.clickWhenReady(signButton);
    }

    public boolean invalidCredentialsNotificationIsShown() {
        wait.tillElementPresent(invalidCredentialsNotification);
        return invalidCredentialsNotification.isDisplayed();
    }

    public boolean invalidEmailNotificationIsShown() {
        wait.tillElementPresent(invalidEmailNotification);
        return invalidEmailNotification.isDisplayed();
    }
}
