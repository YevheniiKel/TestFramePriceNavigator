package stepDefinitions;

import dto.UserDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.AssertionsForClassTypes;
import pages.HeaderAnyPage;

public class LoginTestSteps {
    private HeaderAnyPage headerAnyPage;
    private Controller controller;

    private UserDto registeredUser;

    public LoginTestSteps(Controller controller) {
        this.controller = controller;
        registeredUser = UserDto.createRegisteredUser();
    }

    @When("User opens main page with header1")
    public void user_opens_main_page_with_header() {
        headerAnyPage = new HeaderAnyPage(controller.getDriver()).openPage();
    }

    @When("User enters valid email and password")
    public void user_enters_valid_email_and_password() {
        headerAnyPage.enterCredentials(registeredUser);
    }

    @Then("User is logged in")
    public void user_is_logged_in() {
        AssertionsForClassTypes.assertThat(headerAnyPage.isElementContainSomeText(headerAnyPage.userName, registeredUser.getLogin()))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }
}
