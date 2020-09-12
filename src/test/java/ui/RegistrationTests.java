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
        email = login + "@gmail.com";
        password = DataGenerator.passGenerator();
        mainPage.openLoginPopup();
        mainPage.clickRegisterButton();
        mainPage.enterRegEmail(email);
        mainPage.regEnterFirstPassword(password);
        mainPage.regEnterSecondPassword(password);
        mainPage.clickRegisterSignUpButton();
        Assert.assertEquals(mainPage.getLoggedInUserUsername(), login);
    }
}
