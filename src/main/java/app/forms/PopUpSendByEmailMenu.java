package app.forms;

import framework.elements.Button;
import framework.elements.InputField;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class PopUpSendByEmailMenu {
    private final String INPUT_LOGIN_PATTERN = "//input[@id='Email' and @value='%s']";
    private By submitBtnLoc = By.xpath("//button[@data-at-selector='installerSendSelfBtn']");
    private By captchaSubmitLoc = By.id("recaptcha-verify-button");

    private InputField getInputLoginField(String login) {
        Waiter.waitForClickAble(By.xpath(String.format(INPUT_LOGIN_PATTERN, login)));
        return new InputField(By.xpath(String.format(INPUT_LOGIN_PATTERN, login)), "Input field for sending link to email");
    }

    public boolean isDisplayedLogin(String login) {
        return getInputLoginField(login).isDisplayed();
    }

    private Button getSubmitButton() {
        return new Button(submitBtnLoc, "Button to submit email");
    }

    public void submitEmail() {
        if (isCaptchaDisplayed()) {
            System.out.println("Captcha");
        }
        getSubmitButton().click();
    }

    public void submitCaptcha() {
        getSubmitButton().click();
        System.out.println("Clicked");
        if (isCaptchaDisplayed()) {
            System.out.println("CAPTCHA");
            Waiter.waitUntilElementIsPresent(captchaSubmitLoc);
            getSubmitButton().click();
        }
    }

    public Boolean isCaptchaDisplayed() {
        try {
            return getCaptchaButton().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private Button getCaptchaButton() {
        return new Button(captchaSubmitLoc, "Send Captcha Button");
    }
}
