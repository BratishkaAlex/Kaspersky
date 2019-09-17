package framework.utils;

import com.google.common.base.Function;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Waiter {

    private static int timeout = Integer.parseInt(PropertyManager.getConfigProperty("timeout"));

    public static void implicitWait(int timeout) {
        Browser.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void waitForClickAble(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(Browser.getDriver(), timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void waitForFile(File file) {
        FluentWait wait = new FluentWait(Browser.getDriver()).withTimeout(timeout, TimeUnit.SECONDS).
            pollingEvery(1, TimeUnit.SECONDS);
        wait.until((Function) (webDriver) -> file.exists());
    }
}
