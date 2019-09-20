package app.pageObject;

import app.forms.PopUpDownloadProductForm;
import app.forms.PopUpSendByEmailForm;
import app.forms.SelectOSMenu;
import app.forms.SelectProductMenu;
import framework.elements.Label;
import org.openqa.selenium.By;

public class DownloadsPage {
    private SelectOSMenu selectOSMenu;
    private SelectProductMenu selectProductMenu;
    private PopUpDownloadProductForm popUpDownloadProductForm;
    private PopUpSendByEmailForm popUpSendByEmailForm;
    private By downloadsLabelLoc = By.xpath("//h2[@data-at-selector='downloadBlockTrialAppsTitle']");

    public DownloadsPage() {
        selectOSMenu = new SelectOSMenu();
        selectProductMenu = new SelectProductMenu();
        popUpDownloadProductForm = new PopUpDownloadProductForm();
        popUpSendByEmailForm = new PopUpSendByEmailForm();
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

    public PopUpDownloadProductForm getPopUpDownloadProductForm() {
        return popUpDownloadProductForm;
    }

    public PopUpSendByEmailForm getPopUpSendByEmailForm() {
        return popUpSendByEmailForm;
    }

    private Label getDownloadLabel() {
        return new Label(downloadsLabelLoc, "Label for checking downloads page");
    }
}
