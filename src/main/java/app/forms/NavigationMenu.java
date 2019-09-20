package app.forms;

import framework.elements.Link;
import org.openqa.selenium.By;

public class NavigationMenu {
    private final String PATTERN_FOR_MENU_LINK = "(//a[contains(@class,'%s')])[3]";

    public void navigateTo(String menuItem) {
        getNavigationMenuLink(menuItem).waitAndClick();
    }

    private Link getNavigationMenuLink(String menuItem) {
        return new Link(By.xpath(String.format(PATTERN_FOR_MENU_LINK, menuItem)), "Link to downloads");
    }
}
