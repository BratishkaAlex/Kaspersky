package app.pageObject;

import app.forms.NavigationMenu;

public class MainPage {
    private NavigationMenu navigationMenu;

    public MainPage(){
        navigationMenu = new NavigationMenu();
    }

    public NavigationMenu getNavigationMenu() {
        return navigationMenu;
    }
}
