package ui;

import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LoginTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    private UserDTO registeredUser;
    private UserDTO notRegisteredUser;
    private UserDTO invalidEmailUser;

    @BeforeTest
    public void initialization() {
        registeredUser = UserDTO.createRegisteredUser();
        notRegisteredUser = UserDTO.createNotRegisteredUser();
        invalidEmailUser = UserDTO.CreateInvalidEmailUser();
    }

    @BeforeMethod
    public void searchTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver).openPage();
    }

    @Test
    public void validCredentialsLogin() {
        headerAnyPage.enterCredentials(registeredUser);
        assertThat(headerAnyPage.isElementContainSomeText(headerAnyPage.userName, registeredUser.getLogin()))
                .as("Account username is not shown in the right top corner of the page")
                .isTrue();
    }

    @Test
    public void notRegisteredUser() {
        headerAnyPage.enterCredentials(notRegisteredUser);
        assertThat(headerAnyPage.invalidCredentialsNotificationIsShown())
                .as("Invalid credentials notification is not shown")
                .isTrue();
    }

    @Test
    public void testLoginWithInvalidEmail() {
        headerAnyPage.enterCredentials(invalidEmailUser);
        assertThat(headerAnyPage.invalidCredentialsNotificationIsShown())
                .as("Invalid email notification is not shown")
                .isTrue();
    }
}
