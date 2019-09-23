package app.forms;

import framework.elements.Button;
import framework.elements.InputField;
import org.openqa.selenium.By;

public class PopUpSignInMenu {
    private By inputLoginLoc = By.xpath("//input[@type='email']");
    private By inputPasswordLoc = By.xpath("//input[@type='password']");
    private By submitBtnLoc = By.xpath("//button[@data-at-selector='welcomeSignInBtn']");

    public void logIn(String login, String password) {
        getLoginField().sendKeys(login);
        getPasswordField().sendKeys(password);
        getSubmitButton().click();
    }

    private Button getSubmitButton() {
        return new Button(submitBtnLoc, "Submit login and password button");
    }

    private InputField getLoginField() {
        return new InputField(inputLoginLoc, "Field for input login");
    }

    private InputField getPasswordField() {
        return new InputField(inputPasswordLoc, "Field for input password");
    }
}
