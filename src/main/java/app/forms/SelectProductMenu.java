package app.forms;

import framework.elements.Label;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectProductMenu {
    private final String PATTERN_FOR_PRODUCT = "//kl-carousel-item[@aria-hidden='false']//div[@class='u-productLogotype__name' and text()='%s']";
    private By downloadProductButtonLoc = By.xpath("..//..//..//..//button[contains(@class,'jsDownloadApplications')]");

    private Label getLabelForProduct(String product){
        Waiter.waitForClickAble(By.xpath(String.format(PATTERN_FOR_PRODUCT, product)));
        return new Label(By.xpath(String.format(PATTERN_FOR_PRODUCT, product)), String.format("Label for %s", product));
    }

    private WebElement getDownloadProductButton(String product){
       return getLabelForProduct(product).findElementFromCurrent(downloadProductButtonLoc);
    }

    public void clickOnDownloadProduct(String product){
        getDownloadProductButton(product).click();
    }
}
