package app.forms;

import framework.elements.Button;
import framework.elements.InputField;
import framework.utils.Waiter;
import org.openqa.selenium.By;

public class PopUpSendByEmailForm {
    private final String INPUT_LOGIN_PATTERN = "//input[@id='Email' and @value='%s']";
    private By submitBtnLoc = By.xpath("//button[@data-at-selector='installerSendSelfBtn']");
    private By captchaFormLoc = By.cssSelector("div[style*='visible;'] iframe[title*='recaptcha']");

    public boolean isDisplayedLogin(String login) {
        Waiter.waitForClickAble(By.xpath(String.format(INPUT_LOGIN_PATTERN, login)));
        return getInputLoginField(login).isDisplayed();
    }

    public void submitEmail() {
        Waiter.waitUntilElementIsVisible(captchaFormLoc);
        getSubmitButton().click();
    }

    private InputField getInputLoginField(String login) {
        return new InputField(By.xpath(String.format(INPUT_LOGIN_PATTERN, login)), "Input field for sending link to email");
    }

    private Button getSubmitButton() {
        return new Button(submitBtnLoc, "Button to submit email");
    }
}
