package framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberReader {

    public static int getIntNumber(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        int number = 0;
        while (matcher.find()) {
            number = Integer.valueOf(line.substring(matcher.start(), matcher.end()));
        }
        return number;
    }


    public static Double getDoubleNumber(String line) {
        Pattern pattern = Pattern.compile("\\d+.\\d+");
        Matcher matcher = pattern.matcher(line);
        Double number = 0.;
        while (matcher.find()) {
            number = Double.valueOf(line.substring(matcher.start(), matcher.end()));
        }
        return number;
    }
}
