package app.forms;

import framework.elements.Button;
import org.openqa.selenium.By;

public class PopUpSendByEmailMenu {
    private By submitBtnLoc = By.xpath("//button[@data-at-selector='installerSendSelfBtn']");
    private By captchaSubmitLoc = By.id("recaptcha-verify-button");

    private Button getSubmitButton(){
        return new Button(submitBtnLoc, "Button to submit email");
    }

    public void submitEmail(){
        getSubmitButton().click();
    }
}
