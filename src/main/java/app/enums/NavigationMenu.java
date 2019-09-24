package app.enums;

public class NavigationMenu {
    public enum NavigationMenuItems {
        DOWNLOADS("downloads");
        private String item;

        NavigationMenuItems(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }
    }
}
