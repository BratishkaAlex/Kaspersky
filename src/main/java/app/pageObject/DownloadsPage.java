package app.pageObject;

import app.forms.PopUpDownloadProductMenu;
import app.forms.PopUpSendByEmailMenu;
import app.forms.SelectOSMenu;
import app.forms.SelectProductMenu;

public class DownloadsPage {
    private SelectOSMenu selectOSMenu;
    private SelectProductMenu selectProductMenu;
    private PopUpDownloadProductMenu popUpDownloadProductMenu;
    private PopUpSendByEmailMenu popUpSendByEmailMenu;

    public DownloadsPage(){
        selectOSMenu = new SelectOSMenu();
        selectProductMenu = new SelectProductMenu();
        popUpDownloadProductMenu = new PopUpDownloadProductMenu();
        popUpSendByEmailMenu = new PopUpSendByEmailMenu();
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
