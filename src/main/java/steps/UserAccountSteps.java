package steps;

import dto.UserDto;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
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

    public UserAccountSteps(DriverWrapper driver) {
        this.driver = driver;
        registeredUser = UserDto.createRegisteredUser();
        notRegisteredUser = UserDto.createNotRegisteredUser();
        invalidEmailUser = UserDto.createInvalidEmailUser();
        newUser = UserDto.createNewUser();
    }

    @ParameterType(".*")
    public UserDto userType(String user) {
        switch (user) {
            case "registered" -> {
                currentUser = UserDto.createRegisteredUser();
                return currentUser;
            }
            case "notRegistered" -> {
                currentUser = UserDto.createNotRegisteredUser();
                return currentUser;
            }
            case "invalidInputData" -> {
                currentUser = UserDto.createInvalidEmailUser();
                return currentUser;
            }
            case "newUser" -> {
                currentUser = UserDto.createNewUser();
                return currentUser;
            }
            default -> throw new IllegalArgumentException("Unknown userType");
        }
    }

    @When("User enters valid email and password")
    public void user_enters_valid_email_and_password() {
        mainPage = new MainPage(driver);
        mainPage.header.enterCredentials(registeredUser);
    }

    @When("User enters not registered email and password")
    public void user_enters_not_registered_email_and_password() {
        mainPage = new MainPage(driver);
        mainPage.header.enterCredentials(notRegisteredUser);
    }

    @When("User enters invalid email and password")
    public void user_enters_invalid_email() {
        mainPage = new MainPage(driver);
        mainPage.header.enterCredentials(invalidEmailUser);
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
        driver.clickWhenReady(mainPage.header.loginButton);
    }

    @And("Clicks Register button")
    public void clicksSignUpButton() {
        driver.clickWhenReady(mainPage.header.registrationButton);
    }

    @And("Clicks SignUp button")
    public void clicksRegistrationButton() throws InterruptedException {
        driver.clickWhenReady(mainPage.header.registerSignUpButton);
        Thread.sleep(3000);
    }

    @When("User enters {userType} credentials")
    public void userEntersTypeCredentials(UserDto user) {
        mainPage.header.enterCredentials(user);
    }

    @Then("User is authorized is {string}")
    public void userIsAuthorizedIsAuthorized(String authorized) {
        boolean isAuthorized = Boolean.parseBoolean(authorized);
        if (isAuthorized) {
            mainPage = new MainPage(driver);
            assertThat(driver.isElementContainSomeText(mainPage.header.userName, currentUser.getLogin()))
                    .as("Account username is not shown in the right top corner of the page")
                    .isTrue();
        } else {
            assertThat(mainPage.header.invalidCredentialsNotification.isDisplayed())
                    .as("Invalid credentials notification is not shown")
                    .isTrue();
        }
    }

    @When("{userType} user fills all required fields")
    public void usertypeUserFillsAllRequiredFields(UserDto user) {
        driver.sendKeysWhenReady(mainPage.header.emailRegisterField, user.getEmail());
        driver.sendKeysWhenReady(mainPage.header.passwordRegisterFieldFirst, user.getPassword());
        driver.sendKeysWhenReady(mainPage.header.passwordRegisterFieldSecond, user.getPassword());
    }
}
