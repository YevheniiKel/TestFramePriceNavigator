package pages.base;

import org.openqa.selenium.support.PageFactory;
import utils.driverUtils.DriverWrapper;

public abstract class BasePage {
    protected DriverWrapper driver;

    public BasePage(DriverWrapper driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract void waitForMainElements();

    protected abstract <P> P openPage();
}
