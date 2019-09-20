package app.forms;

import framework.elements.Link;
import org.openqa.selenium.By;

public class PopUpDownloadProductForm {
    private By sendByEmailBtnLoc = By.xpath("//div[@class='w-downloadProductCard__sendLink']");

    public boolean isDisplayed() {
        return getSendByMailLink().isDisplayed();
    }

    public void sendByMail() {
        getSendByMailLink().click();
    }

    private Link getSendByMailLink() {
        return new Link(sendByEmailBtnLoc, "Link to send link for download product");
    }
}
