package app.forms;

import framework.elements.Button;
import framework.elements.InputField;
import org.openqa.selenium.By;

public class PopUpSignInMenu {
    private By inputLoginLoc = By.xpath("//input[@type='email']");
    private By inputPasswordLoc = By.xpath("//input[@type='password']");
    private By submitBtnLoc = By.xpath("//button[@data-at-selector='welcomeSignInBtn']");

    private InputField getInputEmailField() {
        return new InputField(inputLoginLoc, "Field for input login");
    }

    private InputField getInputPasswordField() {
        return new InputField(inputPasswordLoc, "Field for input password");
    }

    public void enterLogin(String login) {
        getInputEmailField().sendKeys(login);
    }

    public void enterPassword(String password) {
        getInputPasswordField().sendKeys(password);
    }

    public void submit() {
        getSubmitButton().click();
    }

    private Button getSubmitButton() {
        return new Button(submitBtnLoc, "Submit login and password button");
    }
}
