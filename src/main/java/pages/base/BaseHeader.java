package pages.base;

import dto.UserDto;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.driverUtils.DriverWrapper;

public class BaseHeader extends BasePage {

    public BaseHeader(DriverWrapper driver) {
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

    @Override
    public void waitForMainElements() {
        driver.waitTillElementPresent(searchField);
        driver.waitTillElementPresent(loginButton);
    }

    @Override
    public BaseHeader openPage() {
        throw new UnsupportedOperationException("This page should not be loaded directly");
    }

    public void enterCredentials(UserDto userDto) {
        driver.sendKeysWhenReady(emailLoginField, userDto.getEmail());
        driver.sendKeysWhenReady(passwordLoginField, userDto.getPassword());
        driver.clickWhenReady(signButton);
    }
}
