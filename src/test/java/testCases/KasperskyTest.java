package testCases;

import app.appUtils.LinksChecker;
import app.pageObject.DownloadsPage;
import app.pageObject.MainPage;
import app.pageObject.UnauthorizedPage;
import framework.base.BaseTest;
import framework.browser.Browser;
import framework.mail.EmailReader;
import framework.utils.PropertyManager;
import framework.utils.Waiter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static framework.utils.LoggerUtil.LOGGER;
import static framework.utils.LoggerUtil.step;
import static org.testng.Assert.assertTrue;

public class KasperskyTest extends BaseTest {
    private int counter;

    // //button[@id='recaptcha-verify-button']
    @BeforeMethod
    @Parameters({"login", "password"})
    public void cleanMail(String login, String password) {
        LOGGER.info("NEW TEST STARTED");
        LOGGER.info("Deleting all mails before");
        EmailReader.delete(login, password);
        counter = 1;
    }

    @Test
    @Parameters({"login", "password", "os", "product"})
    public void test(String login, String password, String os, String product) {
        LOGGER.info("Enter https://my.kaspersky.com");
        Browser.enterUrl(PropertyManager.getConfigProperty("url"));

        step("Authorize on my.kaspersky.com", counter++);
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage();
        unauthorizedPage.signIn();
        unauthorizedPage.getPopUpSignInMenu().enterLogin(login);
        unauthorizedPage.getPopUpSignInMenu().enterPassword(password);
        unauthorizedPage.getPopUpSignInMenu().submit();

        MainPage mainPage = new MainPage();
        LOGGER.info("Checking that user authorized successfully");
        assertTrue(mainPage.getHeader().isUserAuthorized(login), "User didn't authorize");
        step("Click on downloads", counter++);
        mainPage.getNavigationMenu().navigateToDownloads();

        DownloadsPage downloadsPage = new DownloadsPage();
        LOGGER.info("Checking opening the download page");
        assertTrue(downloadsPage.isDisplayed(), "This is not the downloads page");
        downloadsPage.getSelectOSMenu().select(os);
        step("Click on download product for expected os", counter++);
        downloadsPage.getSelectProductMenu().clickOnDownloadProduct(product, os);

        LOGGER.info("Checking opening the dialogue window for downloading");
        assertTrue(downloadsPage.getPopUpDownloadProductMenu().isDisplayed(), "Dialogue window is not opened");
        step("Click on send link by email", counter++);
        downloadsPage.getPopUpDownloadProductMenu().sendByMail();
        LOGGER.info("Checking opening the dialogue window for sending link by email");
        assertTrue(downloadsPage.getPopUpSendByEmailMenu().isDisplayedLogin(login), "Login is not entered automatically in input field");
        step("Click on submit", counter++);
        downloadsPage.getPopUpSendByEmailMenu().submitEmail();
        Waiter.waitForMail(login, password);
        LOGGER.info("Checking that received mail contains link to download expected product");
        assertTrue(LinksChecker.containsLinkForProductAndOS(EmailReader.check(login, password), product, os), "Mail doesn't contain link for wanted product");
    }
}
