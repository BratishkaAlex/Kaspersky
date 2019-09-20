package app.appUtils;

public class Enums {
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

    public enum SignInMenuItems {
        EMAIL("email"), PASSWORD("password");
        private String item;

        SignInMenuItems(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }
    }

    public enum OS {
        Windows, Mac, Android, iOS
    }
}
