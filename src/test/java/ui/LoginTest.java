package ui;

import org.testng.annotations.Test;
import pages.MainPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LoginTest extends BaseTestSetup {

    private String email;
    private String username;
    private String password;

    @Test
    public void validCredentialsLogin() {
        email = CharDataForTestSite.VALID_EMAIL;
        username = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;
        enterCredentials(mainPage);
        assertThat(mainPage.getLoggedInUserUsername())
                .as("Account username is not shown in the right top corner of the page")
                .isEqualTo(username);
    }

    @Test
    public void notRegisteredUserLogin() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        enterCredentials(mainPage);
        assertThat(mainPage.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Test
    public void testLoginWithInvalidEmail() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        enterCredentials(mainPage);
        assertThat(mainPage.invalidCredentialsNotificationIsShown())
                .as("Invalid email notification is not shown")
                .isTrue();
    }

    private void enterCredentials(MainPage mainPage) {
        mainPage.openLoginPopup();
        mainPage.enterLogin(email)
                .enterPass(password)
                .clickSignIn();
    }
}
