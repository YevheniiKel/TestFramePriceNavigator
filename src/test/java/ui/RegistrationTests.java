package ui;

import org.testng.annotations.Test;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.DataGenerator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationTests extends BaseTestSetup {

    private String login;
    private String email;
    private String password;

    @Test
    public void registrationTest() throws InterruptedException {
        openMainPage();
        login = DataGenerator.loginGenerator();
        email = String.format("%s@gmail.com", login);
        password = DataGenerator.passGenerator();
        mainPage.openLoginPopup();
        mainPage.clickRegisterButton();
        mainPage.enterRegEmail(email);
        mainPage.regEnterFirstPassword(password);
        mainPage.regEnterSecondPassword(password);
        mainPage.clickRegisterSignUpButton();
        assertThat(mainPage.getLoggedInUserUsername())
                .as("Logged in user's Username is not displayed in the right top corner of the page.\n" +
                        String.format("window's resolution is %s", driver.manage().window().getSize()))
                .containsOnlyOnce(login);
    }
}
