package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderAnyPage;
import ui.driverSetup.BaseTestSetup;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationTest extends BaseTestSetup {

    private HeaderAnyPage headerAnyPage;

    @BeforeMethod
    public void localizationTestSetup() {
        headerAnyPage = new HeaderAnyPage(driver).openPage();
    }

    @Test
    public void siteDefaultCityIsKharkivTest() {
        assertThat(headerAnyPage.searchField.getAttribute("placeholder"))
                .as(String.format("The placeholder text is incorrect: %s", "Найти товар в Харькове"))
                .contains("Найти товар в Харькове")
                .doesNotContain("Киев")
                .doesNotContain("Винница");
    }
}