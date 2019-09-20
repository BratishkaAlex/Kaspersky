package app.pageObject;

import app.forms.PopUpSignInMenu;
import framework.elements.Button;
import org.openqa.selenium.By;

public class UnauthorizedPage {
    private By signInBtnLoc = By.xpath("//div[@class='signin-invite']//button[contains(@class,'js-signin-button')]");
    private PopUpSignInMenu popUpSignInMenu;

    public UnauthorizedPage() {
        popUpSignInMenu = new PopUpSignInMenu();
    }

    public PopUpSignInMenu getPopUpSignInMenu() {
        return popUpSignInMenu;
    }

    public void signIn() {
        getSignInButton().click();
    }

    private Button getSignInButton() {
        return new Button(signInBtnLoc, "SignIn button");
    }
}
