package steps;

import dto.UserDto;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import util.DriverProvider;
import util.elementUtils.WaitUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserAccountSteps {
    private MainPage mainPage;
    private DriverProvider driverProvider;
    private WaitUtils wait;

    private UserDto registeredUser;
    private UserDto notRegisteredUser;
    private UserDto invalidEmailUser;
    private UserDto currentUser;

    private UserDto newUser;

    public UserAccountSteps(DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
        wait = new WaitUtils(driverProvider.getDriver());

        registeredUser = UserDto.createRegisteredUser();
        notRegisteredUser = UserDto.createNotRegisteredUser();
        invalidEmailUser = UserDto.createInvalidEmailUser();
        newUser = UserDto.createNewUser();
        mainPage = new MainPage(driverProvider.getDriver());
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
        mainPage.enterCredentials(registeredUser);
    }

    @When("User enters not registered email and password")
    public void user_enters_not_registered_email_and_password() {
        mainPage.enterCredentials(notRegisteredUser);
    }

    @When("User enters invalid email and password")
    public void user_enters_invalid_email() {
        mainPage.enterCredentials(invalidEmailUser);
    }


    @Then("[Incorrect email or password] notification is shown")
    public void incorrectEmailOrPasswordIsShown() {
        assertThat(mainPage.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Then("[Incorrect email] notification is shown")
    public void incorrectEmailNotificationIsShown() {
        assertThat(mainPage.invalidEmailNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @When("User opens LogIn popup")
    public void userOpensLogInPopup() {
        wait.clickWhenReady(mainPage.loginButton);
    }

    @And("Clicks Register button")
    public void clicksSignUpButton() {
        wait.clickWhenReady(mainPage.registrationButton);
    }

    @And("Clicks SignUp button")
    public void clicksRegistrationButton() throws InterruptedException {
        wait.clickWhenReady(mainPage.registerSignUpButton);
        Thread.sleep(3000);
    }

    @When("User enters {userType} credentials")
    public void userEntersTypeCredentials(UserDto user) {
        mainPage.enterCredentials(user);
    }

    @Then("User is authorized is {string}")
    public void userIsAuthorizedIsAuthorized(String authorized) {
        boolean isAuthorized = Boolean.parseBoolean(authorized);
        if (isAuthorized) {
            mainPage = new MainPage(driverProvider.getDriver());
            assertThat(wait.isElementContainSomeText(mainPage.userName, currentUser.getLogin()))
                    .as("Account username is not shown in the right top corner of the page")
                    .isTrue();
        } else {
            assertThat(mainPage.invalidCredentialsNotification.isDisplayed())
                    .as("Invalid credentials notification is not shown")
                    .isTrue();
        }
    }

    @When("{userType} user fills all required fields")
    public void usertypeUserFillsAllRequiredFields(UserDto user) {
        wait.sendKeysWhenReady(mainPage.emailRegisterField, user.getEmail());
        wait.sendKeysWhenReady(mainPage.passwordRegisterFieldFirst, user.getPassword());
        wait.sendKeysWhenReady(mainPage.passwordRegisterFieldSecond, user.getPassword());
    }
}
