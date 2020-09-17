package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LoginTest extends BaseTestSetup {

    private HeaderAnyPage header;

    private String email;
    private String username;
    private String password;

    @BeforeMethod
    public void searchTestSetup() {
        driver.get(CharDataForTestSite.HOME_URL);
        header = new HeaderAnyPage(driver);
    }

    @Test
    public void validCredentialsLogin() {
        email = CharDataForTestSite.VALID_EMAIL;
        username = CharDataForTestSite.VALID_USERNAME;
        password = CharDataForTestSite.VALID_PASSWORD;
        header.enterCredentials(email, password);
        assertThat(header.isElementContainSomeText(header.userName, username))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @Test
    public void notRegisteredUserLogin() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        header.enterCredentials(email, password);
        assertThat(header.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Test
    public void testLoginWithInvalidEmail() {
        email = DataGenerator.loginGenerator();
        password = DataGenerator.passGenerator();
        header.enterCredentials(email, password);
        assertThat(header.invalidCredentialsNotificationIsShown())
                .as("Invalid email notification is not shown")
                .isTrue();
    }
}
