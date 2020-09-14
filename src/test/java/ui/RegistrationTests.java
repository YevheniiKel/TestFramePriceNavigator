package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.driverSetup.BaseTestSetup;
import util.dataUtils.DataGenerator;

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
        Assert.assertEquals(mainPage.getLoggedInUserUsername(), login,
                "Logged in user's Username is not displayed in the right top corner of the page.\n" +
                        String.format("window's resolution is %s", driver.manage().window().getSize()));
    }
}
