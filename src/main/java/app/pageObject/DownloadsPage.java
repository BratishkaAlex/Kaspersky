package app.pageObject;

import app.forms.PopUpDownloadProductMenu;
import app.forms.PopUpSendByEmailMenu;
import app.forms.SelectOSMenu;
import app.forms.SelectProductMenu;
import framework.elements.Label;
import org.openqa.selenium.By;

public class DownloadsPage {
    private SelectOSMenu selectOSMenu;
    private SelectProductMenu selectProductMenu;
    private PopUpDownloadProductMenu popUpDownloadProductMenu;
    private PopUpSendByEmailMenu popUpSendByEmailMenu;
    private By downloadsLabelLoc = By.xpath("//h2[@data-at-selector='downloadBlockTrialAppsTitle']");

    public DownloadsPage() {
        selectOSMenu = new SelectOSMenu();
        selectProductMenu = new SelectProductMenu();
        popUpDownloadProductMenu = new PopUpDownloadProductMenu();
        popUpSendByEmailMenu = new PopUpSendByEmailMenu();
    }

    private Label getDownloadLabel() {
        return new Label(downloadsLabelLoc, "Label for checking downloads page");
    }

    public boolean isDisplayed() {
        return getDownloadLabel().isDisplayed();
    }

    public SelectOSMenu getSelectOSMenu() {
        return selectOSMenu;
    }

    public SelectProductMenu getSelectProductMenu() {
        return selectProductMenu;
    }

    public PopUpDownloadProductMenu getPopUpDownloadProductMenu() {
        return popUpDownloadProductMenu;
    }

    public PopUpSendByEmailMenu getPopUpSendByEmailMenu() {
        return popUpSendByEmailMenu;
    }
}
