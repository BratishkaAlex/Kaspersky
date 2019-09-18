package app.appUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksChecker {
    private static final String REGEX_FOR_LINKS = "%s.+\\(https.+?applicationId=%d.+?\\)";

    public static boolean containsLinkForProductAndOS(String mail, String product, String os) {
        Pattern p = Pattern.compile(String.format(REGEX_FOR_LINKS, os, IdProvider.getAppId(product, os)));
        Matcher m = p.matcher(preparedMailForChecking(mail));
        return m.find();
    }

    private static String preparedMailForChecking(String mail) {
        return mail.replaceAll("%253D", "=");
    }
}
