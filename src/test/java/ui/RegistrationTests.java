package ui;

import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationTests extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;
    UserDTO newUser;

    @BeforeTest
    public void initialization() {
        newUser = UserDTO.createNewUser();
    }

    @BeforeMethod
    public void searchTestSetup() {
        driver.get(CharDataForTestSite.HOME_URL);
        headerAnyPage = new HeaderAnyPage(driver).openPage();
    }

    @Test
    public void registrationTest() {
        headerAnyPage.registerNewUser(newUser);
        assertThat(headerAnyPage.isElementContainSomeText(headerAnyPage.userName, newUser.getLogin()))
                .as("Logged in user's Username is not displayed in the right top corner of the page.\n" +
                        String.format("window's resolution is %s", driver.manage().window().getSize()))
                .isTrue();
    }
}
