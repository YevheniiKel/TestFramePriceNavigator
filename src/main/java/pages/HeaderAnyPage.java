package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.dataUtils.CharDataForTestSite;
import valueObjects.User;

public class HeaderAnyPage extends BasePage {

    private String defaultUsernameFiledValue;

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
    public WebElement userName;

    @FindBy(xpath = ".//input[@id='login-form-password']/following-sibling::div[contains(@class, 'hint')]")
    WebElement invalidCredentialsNotification;

    @FindBy(xpath = ".//input[@id='login-form-login']/following-sibling::div[contains(@class, 'hint')]")
    WebElement invalidEmailNotification;

    @FindBy(xpath = ".//div[@class='popup-content-text']")
    WebElement loginPopup;

    @FindBy(xpath = ".//div[contains(@class, 'popup-register')]")
    WebElement registrationPopup;

    @Override
    public void waitForMainElements() {
        wait.tillElementPresent(searchField);
        wait.tillElementPresent(loginButton);
    }

    @Override
    public HeaderAnyPage openPage() {
        driver.get(CharDataForTestSite.HOME_URL);
        defaultUsernameFiledValue = getLoggedInUserUsername();
        waitForMainElements();
        return new HeaderAnyPage(driver);
    }


    public void enterSearchQuery(String searchQuery) {
        wait.sendKeysWhenReadyThenEnter(searchField, searchQuery);
    }

    public void enterCredentials(User user) {
        openLoginPopup();
        enterEmail(user.getEmail());
        enterPass(user.getPassword());
        clickSignIn();
    }

    public void openLoginPopup() {
        wait.clickWhenReady(loginButton);
    }

    public void enter(WebElement field, String value) {
        wait.sendKeysWhenReady(field, value);
    }

    public void enterEmail(String email) {
        wait.sendKeysWhenReady(emailLoginField, email);
    }

    public void enterPass(String password) {
        wait.sendKeysWhenReady(passwordLoginField, password);
    }

    public void clickSignIn() {
        wait.clickWhenReady(signButton);
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
        wait.tillElementInvisible(registrationPopup);
    }

    public String getLoggedInUserUsername() {
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

    public boolean isElementContainSomeText(WebElement element, String text) {
        return wait.tillTextEqualsValue(element, text);
        //element.getText().contains(text);
    }
}
