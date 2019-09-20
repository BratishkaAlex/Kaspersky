package app.appUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksChecker {
    private static final String REGEX_FOR_LINKS = "%s.+\\(https.+?applicationId(=|%s)%d.+?\\)";

    public static boolean containsLinkForProductAndOS(String mail, String os, int appId) {
        Pattern p = Pattern.compile(String.format(REGEX_FOR_LINKS, os, "%253D", appId));
        Matcher m = p.matcher(mail);
        return m.find();
    }
}
