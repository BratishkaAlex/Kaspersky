package app.forms;

import framework.elements.Button;
import framework.elements.InputField;
import org.openqa.selenium.By;

public class PopUpSignInMenu {
    private String PATTERN_FOR_INPUT_FIELD = "//input[@type='%s']";
    private By submitBtnLoc = By.xpath("//button[@data-at-selector='welcomeSignInBtn']");

    public void enterValue(String inputType, String value) {
        getInputField(inputType).sendKeys(value);
    }

    public void submit() {
        getSubmitButton().click();
    }

    private Button getSubmitButton() {
        return new Button(submitBtnLoc, "Submit login and password button");
    }

    private InputField getInputField(String inputType) {
        return new InputField(By.xpath(String.format(PATTERN_FOR_INPUT_FIELD, inputType)), String.format("Field for input %s", inputType));
    }
}
