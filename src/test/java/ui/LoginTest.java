package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;
import valueObjects.User;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LoginTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    private String email;
    private String login;
    private String password;

    @BeforeMethod
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver).openPage();
    }

    @Test
    public void validCredentialsLogin() {
        email = CharDataForTestSite.VALID_EMAIL;
        login = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;  //todo REFACTOR! User user = createValidUser();
        User validUser = new User(email, login, password);
        headerAnyPage.enterCredentials(validUser);
        assertThat(headerAnyPage.isElementContainSomeText(headerAnyPage.userName, validUser.getLogin()))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @Test
    public void notRegisteredUserLogin() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        User invalidUser = new User(email, password);
        headerAnyPage.enterCredentials(invalidUser);
        assertThat(headerAnyPage.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Test
    public void testLoginWithInvalidEmail() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        User invalidUser = new User(email, password);
        headerAnyPage.enterCredentials(invalidUser);
        assertThat(headerAnyPage.invalidCredentialsNotificationIsShown())
                .as("Invalid email notification is not shown")
                .isTrue();
    }
}
