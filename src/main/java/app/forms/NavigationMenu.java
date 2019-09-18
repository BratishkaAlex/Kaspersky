package app.forms;

import framework.elements.Link;
import framework.utils.Waiter;
import org.openqa.selenium.By;

public class NavigationMenu {
    private By downloadsLoc = By.xpath("(//a[contains(@class,'downloads')])[3]");

    private Link getLinkToDownloads() {
        Waiter.waitForClickAble(downloadsLoc);
        return new Link(downloadsLoc, "Link to downloads");
    }

    public void navigateToDownloads() {
        getLinkToDownloads().click();
    }
}
