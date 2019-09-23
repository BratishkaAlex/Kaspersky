package app.forms;

import framework.elements.Link;
import org.openqa.selenium.By;

public class NavigationMenu {
    private final String PATTERN_FOR_MENU_LINK = ".is-showing-on-top .js-%s-nav-link";

    public void navigateTo(String menuItem) {
        getNavigationMenuLink(menuItem).waitAndClick();
    }

    private Link getNavigationMenuLink(String menuItem) {
        return new Link(By.cssSelector(String.format(PATTERN_FOR_MENU_LINK, menuItem)), "Link to downloads");
    }
}
