package app.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class SelectProductMenu {
    private final String ID_ATTRIBUTE_NAME = "data-application-id";
    private final String DOWNLOAD_PRODUCT_PATTERN = "//kl-carousel-item[@aria-hidden='false']//button[contains(@class, 'jsDownloadApplications')]" +
        "[..//div[contains(text(), '%s')]]";

    public void downloadProduct(String product) {
        getDownloadProductButton(product).waitAndClick();
    }

    public int getAppId(String product) {
        return Integer.parseInt(getDownloadProductButton(product).getAttribute(ID_ATTRIBUTE_NAME));
    }

    private Button getDownloadProductButton(String product) {
        return new Button(By.xpath(String.format(DOWNLOAD_PRODUCT_PATTERN, product)), String.format("Download button for %s", product));
    }
}
