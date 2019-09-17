package app.appUtils;

public class IdProvider {
    public static int getAppId(String product, String os) {
        switch (product) {
            case "Anti-Virus":
                switch (os) {
                    case "Windows":
                        return 1953;
                    default:
                        throw new IllegalArgumentException("There is no such product for this os");
                }

            case "Internet Security":
                switch (os) {
                    case "Windows":
                        return 1954;
                    case "Mac":
                        return 2006;
                    case "Android":
                        return 1904;
                    default:
                        throw new IllegalArgumentException("There is no such product for this os");
                }
            case "Total Security":
                switch (os) {
                    case "Windows":
                        return 1955;
                    default:
                        throw new IllegalArgumentException("There is no such product for this os");
                }
            case "Safe Kids":
                switch (os) {
                    case "Windows":
                        return 1773;
                    case "Mac":
                        return 1774;
                    case "Android":
                        return 1776;
                    case "iOS":
                        return 1775;
                    default:
                        throw new IllegalArgumentException("There is no such product for this os");
                }
            case "Password Manager":
                switch (os) {
                    case "Windows":
                        return 1514;
                    case "Mac":
                        return 1937;
                    case "Android":
                        return 1623;
                    case "iOS":
                        return 1622;
                    default:
                        throw new IllegalArgumentException("There is no such product for this os");
                }
            default:
                throw new IllegalArgumentException("Unknown product!");
        }
    }

    public static int getOSId(String os) {
        switch (os) {
            case "Windows":
                return 1;
            case "Mac":
                return 2;
            case "Android":
                return 3;
            case "iOS":
                return 4;
            default:
                throw new IllegalArgumentException("Unknown OS!");
        }
    }
}
