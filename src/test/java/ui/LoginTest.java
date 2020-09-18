package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LoginTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    private String email;
    private String username;
    private String password;

    @BeforeMethod
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver);
        headerAnyPage.openPage(driver);
    }

    @Test
    public void validCredentialsLogin() {
        email = CharDataForTestSite.VALID_EMAIL;
        username = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;
        headerAnyPage.enterCredentials(email, password);
        assertThat(headerAnyPage.isElementContainSomeText(headerAnyPage.userName, username))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @Test
    public void notRegisteredUserLogin() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        headerAnyPage.enterCredentials(email, password);
        assertThat(headerAnyPage.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Test
    public void testLoginWithInvalidEmail() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        headerAnyPage.enterCredentials(email, password);
        assertThat(headerAnyPage.invalidCredentialsNotificationIsShown())
                .as("Invalid email notification is not shown")
                .isTrue();
    }
}
