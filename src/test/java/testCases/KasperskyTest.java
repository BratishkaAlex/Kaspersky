package testCases;

import app.appUtils.LinksChecker;
import app.pageObject.DownloadsPage;
import app.pageObject.MainPage;
import app.pageObject.UnauthorizedPage;
import framework.base.BaseTest;
import framework.browser.Browser;
import framework.models.Mail;
import framework.utils.EmailReader;
import framework.utils.PropertyManager;
import framework.utils.Waiter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static app.Enums.NavigationMenu.NavigationMenuItems;
import static framework.utils.LoggerUtil.LOGGER;
import static framework.utils.LoggerUtil.step;
import static framework.utils.PropertyManager.getPropertyForMail;
import static org.testng.Assert.assertTrue;

public class KasperskyTest extends BaseTest {
    private int counter;
    private Mail mail;

    @BeforeMethod
    @Parameters( {"login", "password"})
    public void cleanMail(String login, String password) {
        LOGGER.info("NEW TEST STARTED");
        LOGGER.info("Deleting all mails before");
        mail = new Mail(login, password, getPropertyForMail("mail.store.protocol"), getPropertyForMail("mail.host"));
        EmailReader.deleteAllMails(mail);
        counter = 1;
    }

    @Test
    @Parameters( {"login", "password", "os", "product"})
    public void test(String login, String password, String os, String product) {
        LOGGER.info("Enter https://my.kaspersky.com");
        Browser.enterUrl(PropertyManager.getConfigProperty("url"));

        step("Authorize on my.kaspersky.com", counter++);
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage();
        unauthorizedPage.signIn();
        unauthorizedPage.getPopUpSignInMenu().logIn(login, password);

        MainPage mainPage = new MainPage();
        LOGGER.info("Checking that user authorized successfully");
        assertTrue(mainPage.getHeader().isUserAuthorized(login), "User didn't authorize");

        step("Click on downloads", counter++);
        mainPage.getNavigationMenu().navigateTo(NavigationMenuItems.DOWNLOADS.getItem());

        DownloadsPage downloadsPage = new DownloadsPage();
        LOGGER.info("Checking opening the download page");
        assertTrue(downloadsPage.isDisplayed(), "This is not the downloads page");
        downloadsPage.getSelectOSMenu().selectOs(os);

        step("Click on download product for expected os", counter++);
        int appId = downloadsPage.getSelectProductMenu().getAppId(product);
        downloadsPage.getSelectProductMenu().downloadProduct(product);

        LOGGER.info("Checking opening the dialogue window for downloading");
        assertTrue(downloadsPage.getPopUpDownloadProductForm().isDisplayed(), "Dialogue window is not opened");

        step("Click on send link by email", counter++);
        downloadsPage.getPopUpDownloadProductForm().sendByMail();
        LOGGER.info("Checking opening the dialogue window for sending link by email");
        assertTrue(downloadsPage.getPopUpSendByEmailForm().isDisplayedLogin(login), "Login is not entered automatically in input field");

        step("Click on submit", counter++);
        downloadsPage.getPopUpSendByEmailForm().submitEmail();
        Waiter.waitWhileMailReceived(mail);
        LOGGER.info("Checking that received mail contains link to download expected product");
        assertTrue(LinksChecker.containsLinkForProductAndOS(EmailReader.getFirstMail(mail), os, appId), "Mail doesn't contain link for wanted product");
    }
}
