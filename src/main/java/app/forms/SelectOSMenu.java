package app.forms;

import framework.elements.Button;
import framework.utils.Waiter;
import org.openqa.selenium.By;

public class SelectOSMenu {
    private final String PATTERN_FOR_OS = "//div[@data-at-selector='osName' and text()='%s']";

    public void select(String os) {
        getButtonForOs(os).click();
    }

    private Button getButtonForOs(String os) {
        Waiter.waitForClickAble(By.xpath(String.format(PATTERN_FOR_OS, os)));
        return new Button(By.xpath(String.format(PATTERN_FOR_OS, os)), String.format("Button to navigate for %s downloads", os));
    }
}
