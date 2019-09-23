package app.forms;

import app.appUtils.IdProvider;
import framework.elements.Button;
import org.openqa.selenium.By;

public class SelectOSMenu {
    private final String PATTERN_FOR_OS = "//div[@data-os='%d']";

    public void selectOs(String os) {
        getButtonForOs(os).waitAndClick();
    }

    private Button getButtonForOs(String os) {
        return new Button(By.xpath(String.format(PATTERN_FOR_OS, IdProvider.getOSId(os))), String.format("Button to navigate for %s downloads", os));
    }
}
