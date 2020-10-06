package steps;

import dto.UserDto;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import pages.MainPage;
import util.driverUtils.DriverProvider;
import util.driverUtils.DriverWrapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserAccountSteps {

    private DriverWrapper driver;
    private MainPage mainPage;

    private UserDto registeredUser;
    private UserDto notRegisteredUser;
    private UserDto invalidEmailUser;
    private UserDto currentUser;
    private UserDto newUser;

    public UserAccountSteps(DriverProvider driver) {
        this.driver = driver.getDriver();
        registeredUser = UserDto.createRegisteredUser();
        notRegisteredUser = UserDto.createNotRegisteredUser();
        invalidEmailUser = UserDto.createInvalidEmailUser();
        newUser = UserDto.createNewUser();
    }

    @ParameterType(".*")
    public UserDto userType(String user) {
        switch (user) {
            case "Registered" -> {
                currentUser = UserDto.createRegisteredUser();
                return currentUser;
            }
            case "NotRegistered" -> {
                currentUser = UserDto.createNotRegisteredUser();
                return currentUser;
            }
            case "InvalidInputData" -> {
                currentUser = UserDto.createInvalidEmailUser();
                return currentUser;
            }
            case "NewUser" -> {
                currentUser = UserDto.createNewUser();
                return currentUser;
            }
            default -> throw new IllegalArgumentException("Unknown userType");
        }
    }

    @Then("[Incorrect email or password] notification is shown")
    public void incorrectEmailOrPasswordIsShown() {
        mainPage = new MainPage(driver);
        assertThat(mainPage.header.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Then("[Incorrect email] notification is shown")
    public void incorrectEmailNotificationIsShown() {
        mainPage = new MainPage(driver);
        assertThat(mainPage.header.invalidEmailNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @When("User opens LogIn popup")
    public void userOpensLogInPopup() {
        mainPage = new MainPage(driver);
        driver.clickWhenReady(mainPage.header.loginButton);
    }

    @And("Clicks Register button")
    public void clicksSignUpButton() {
        mainPage = new MainPage(driver);
        driver.clickWhenReady(mainPage.header.registrationButton);
    }

    @And("Clicks SignUp button")
    public void clicksRegistrationButton() throws InterruptedException {
        mainPage = new MainPage(driver);
        driver.clickWhenReady(mainPage.header.registerSignUpButton);
        Thread.sleep(3000);
    }

    @When("User enters {userType} credentials")
    public void userEntersTypeCredentials(UserDto user) {
        mainPage = new MainPage(driver);
        mainPage.header.enterCredentials(user);
    }

    @Then("User is authorized")
    public void userIsAuthorizedIsAuthorized() {
        mainPage = new MainPage(driver);
        assertThat(driver.isElementContainSomeText(mainPage.header.userName, currentUser.getLogin()))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @When("{userType} user fills all required fields")
    public void usertypeUserFillsAllRequiredFields(UserDto user) {
        driver.sendKeysWhenReady(mainPage.header.emailRegisterField, user.getEmail());
        driver.sendKeysWhenReady(mainPage.header.passwordRegisterFieldFirst, user.getPassword());
        driver.sendKeysWhenReady(mainPage.header.passwordRegisterFieldSecond, user.getPassword());
    }

    @And("[Invalid credentials] notification is shown")
    public void invalidCredentialsNotificationIsShown() {
        mainPage = new MainPage(driver);
        assertThat(mainPage.header.invalidCredentialsNotification.isDisplayed());
    }

    @And("[Invalid email] notification is shown")
    public void invalidEmailNotificationIsShown() {
        mainPage = new MainPage(driver);
        assertThat(mainPage.header.invalidEmailNotification.isDisplayed());
    }

    @Then("{userType} user is authorized")
    public void userIsAuthorized(UserDto user) {
        mainPage = new MainPage(driver);
        assertThat(driver.isElementContainSomeText(mainPage.header.userName, user.getLogin()))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @Then("{userType} user is not authorized")
    public void usertypeUserIsNotAuthorized(UserDto user) {
        mainPage = new MainPage(driver);
        driver.waitTillElementPresent(mainPage.header.userName);
        assertThat(!mainPage.header.userName.getText().equals(user.getLogin()))
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }
}
