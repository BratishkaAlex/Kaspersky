package app.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class SelectProductMenu {
    private final String ID_ATTRIBUTE_NAME = "data-application-id";
    private final String DOWNLOAD_PRODUCT_PATTERN = "//kl-carousel-item[@aria-hidden='false']//div[@class='u-productLogotype__name' and contains(text(),'%s')]" +
            "//..//..//..//..//button[contains(@class,'jsDownloadApplications')]";

    public void clickOnDownloadProduct(String product) {
        getDownloadProductButton(product).waitAndClick();
    }

    public int getAppId(String product) {
        return Integer.parseInt(getDownloadProductButton(product).getAttribute(ID_ATTRIBUTE_NAME));
    }

    private Button getDownloadProductButton(String product) {
        return new Button(By.xpath(String.format(DOWNLOAD_PRODUCT_PATTERN, product)), String.format("Download button for %s", product));
    }
}
