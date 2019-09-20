package app.appUtils;

public class IdProvider {
    public static int getOSId(String os) {
        switch (Enums.OS.valueOf(os)) {
            case Windows:
                return 1;
            case Mac:
                return 2;
            case Android:
                return 3;
            case iOS:
                return 4;
            default:
                throw new IllegalArgumentException("Unknown OS!");
        }
    }
}
