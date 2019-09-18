package app.forms;

import framework.elements.Link;
import org.openqa.selenium.By;

public class Header {
    private By loginLoc = By.xpath("//span[contains(@class,'user-email')]");

    private Link getLoginLink() {
        return new Link(loginLoc, "Link to check user");
    }

    public boolean isUserAuthorized(String login) {
        return getLoginLink().getText().equals(login);
    }
}
