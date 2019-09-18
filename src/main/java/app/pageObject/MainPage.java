package app.pageObject;

import app.forms.Header;
import app.forms.NavigationMenu;

public class MainPage {
    private NavigationMenu navigationMenu;
    private Header header;

    public MainPage() {
        header = new Header();
        navigationMenu = new NavigationMenu();
    }

    public NavigationMenu getNavigationMenu() {
        return navigationMenu;
    }

    public Header getHeader() {
        return header;
    }
}
