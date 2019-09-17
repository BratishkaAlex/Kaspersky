package app.forms;

import app.appUtils.IdProvider;
import framework.elements.Button;
import framework.elements.Label;
import framework.utils.Waiter;
import org.openqa.selenium.By;

public class SelectProductMenu {
    private final String Res = "//kl-carousel-item[@aria-hidden='false']//div[@data-application-id='%d']//button[contains(@class,'jsDownloadApplications')]";
    private final String PATTERN_FOR_PRODUCT = "//kl-carousel-item[@aria-hidden='false']//div[@class='u-productLogotype__name' and text()='%s']";
    private By downloadProductButtonLoc = By.xpath("..//..//..//..//button[contains(@class,'jsDownloadApplications')]");

    private Label getLabelForProduct(String product) {
        Waiter.waitForClickAble(By.xpath(String.format(PATTERN_FOR_PRODUCT, product)));
        return new Label(By.xpath(String.format(PATTERN_FOR_PRODUCT, product)), String.format("Label for %s", product));
    }

    private Button getDownloadProductButton(String product, String os) {
        Waiter.waitForClickAble(By.xpath(String.format(Res, IdProvider.getAppId(product, os))));
        return new Button(By.xpath(String.format(Res, IdProvider.getAppId(product, os))), String.format("Download button for %s", product));
    }

    public void clickOnDownloadProduct(String product, String os) {
        getDownloadProductButton(product, os).click();
    }
}
