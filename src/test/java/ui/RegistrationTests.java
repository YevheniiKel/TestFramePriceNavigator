package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.CharDataForTestSite;
import util.dataUtils.DataGenerator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationTests extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    private String login;
    private String email;
    private String password;

    @BeforeMethod
    public void searchTestSetup() {

        driver.get(CharDataForTestSite.HOME_URL);
        headerAnyPage = new HeaderAnyPage(driver).openPage();
    }

    @Test
    public void registrationTest() {
        login = DataGenerator.loginGenerator();
        email = String.format("%s@gmail.com", login);
        password = DataGenerator.passGenerator();
        headerAnyPage.openLoginPopup();
        headerAnyPage.clickRegisterButton();
        headerAnyPage.enterRegEmail(email);
        headerAnyPage.regEnterFirstPassword(password);
        headerAnyPage.regEnterSecondPassword(password);
        headerAnyPage.clickRegisterSignUpButton();
        assertThat(headerAnyPage.getLoggedInUserUsername())
                .as("Logged in user's Username is not displayed in the right top corner of the page.\n" +
                        String.format("window's resolution is %s", driver.manage().window().getSize()))
                .containsOnlyOnce(login);
    }
}
