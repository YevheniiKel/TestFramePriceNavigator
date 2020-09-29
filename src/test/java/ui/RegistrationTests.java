package ui;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationTests {
    WebDriver driver;

    private HeaderAnyPage headerAnyPage;
    private UserDto newUser;

    @BeforeTest
    public void initialization() {
        newUser = UserDto.createNewUser();
    }

    @BeforeMethod
    public void searchTestSetup() {
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
