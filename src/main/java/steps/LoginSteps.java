package steps;

import dto.UserDto;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import util.DriverManager;
import util.elementUtils.WaitUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSteps {
    private MainPage mainPage;
    private DriverManager driverManager;
    private WaitUtils wait;

    private UserDto registeredUser;
    private UserDto notRegisteredUser;
    private UserDto invalidEmailUser;

    private UserDto newUser;

    public LoginSteps(DriverManager driverManager) {
        this.driverManager = driverManager;
        wait = new WaitUtils(driverManager.getDriver());

        registeredUser = UserDto.createRegisteredUser();
        notRegisteredUser = UserDto.createNotRegisteredUser();
        invalidEmailUser = UserDto.createInvalidEmailUser();
        newUser = UserDto.createNewUser();
        mainPage = new MainPage(driverManager.getDriver());
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

    @Then("User is authorized")
    public void user_is_logged_in() {
        assertThat(wait.isElementContainSomeText(mainPage.userName, registeredUser.getLogin()))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
        assertThat(mainPage.userName.getText()).doesNotContain(registeredUser.getLogin())
                .as("Invalid credentials notification is not shown");
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

    @When("User fills all required fields \\(email, password and password confirmation)")
    public void userFillsAllRequiredFieldsEmailPasswordAndPasswordConfirmation() {
        wait.sendKeysWhenReady(mainPage.emailRegisterField, newUser.getEmail());
        wait.sendKeysWhenReady(mainPage.passwordRegisterFieldFirst,newUser.getPassword());
        wait.sendKeysWhenReady(mainPage.passwordRegisterFieldSecond,newUser.getPassword());
    }

    @And("Clicks SignUp button")
    public void clicksRegistrationButton() {
        wait.clickWhenReady(mainPage.registerSignUpButton);
    }
}
