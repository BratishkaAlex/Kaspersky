package app.forms;

import framework.elements.Link;
import org.openqa.selenium.By;

public class PopUpDownloadProductMenu {
    private By sendByEmailBtnLoc = By.xpath("//div[@class='w-downloadProductCard__sendLink']");

    private Link getSendByMailLink(){
        return new Link(sendByEmailBtnLoc, "Link to send link for download product");
    }

    public void sendByMail(){
        getSendByMailLink().click();
    }
}
