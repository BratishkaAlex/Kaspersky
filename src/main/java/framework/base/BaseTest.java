package framework.base;

import framework.browser.Browser;
import framework.utils.PropertyManager;
import framework.utils.Waiter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUpBrowser() {
        Browser.maximize();
        Waiter.implicitWait(Integer.parseInt(PropertyManager.getConfigProperty("timeout")));
    }

    @AfterMethod
    public void closeBrowser() {
        Browser.closeBrowser();
    }
}
