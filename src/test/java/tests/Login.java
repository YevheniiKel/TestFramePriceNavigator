package tests;

import dto.UserDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Login extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    private UserDto registeredUser;
    private UserDto notRegisteredUser;
    private UserDto invalidEmailUser;

    @BeforeTest
    public void initialization() {
        registeredUser = UserDto.createRegisteredUser();
        notRegisteredUser = UserDto.createNotRegisteredUser();
        invalidEmailUser = UserDto.createInvalidEmailUser();
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
