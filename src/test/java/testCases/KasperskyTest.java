package testCases;

import app.pageObject.DownloadsPage;
import app.pageObject.MainPage;
import app.pageObject.UnauthorizedPage;
import framework.base.BaseTest;
import framework.browser.Browser;
import framework.utils.EmailReader;
import framework.utils.PropertyManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KasperskyTest extends BaseTest {

    @Test
    @Parameters({"login", "password", "os", "product"})
    public void test(String login, String password, String os, String product) {
        String mail = EmailReader.check(login, password);
        mail = mail.replaceAll("%253D", "=");
        System.out.println(mail);
        Browser.enterUrl(PropertyManager.getConfigProperty("url"));

        UnauthorizedPage unauthorizedPage = new UnauthorizedPage();
        unauthorizedPage.signIn();
        unauthorizedPage.getPopUpSignInMenu().enterLogin(login);
        unauthorizedPage.getPopUpSignInMenu().enterPassword(password);
        unauthorizedPage.getPopUpSignInMenu().submit();

        MainPage mainPage = new MainPage();
        mainPage.getNavigationMenu().navigateToDownloads();

        DownloadsPage downloadsPage = new DownloadsPage();
        downloadsPage.getSelectOSMenu().select(os);
        downloadsPage.getSelectProductMenu().clickOnDownloadProduct(product, os);

        downloadsPage.getPopUpDownloadProductMenu().sendByMail();
        downloadsPage.getPopUpSendByEmailMenu().submitEmail();
    }
}
