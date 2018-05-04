package LeetCode.appTemplates.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // find with regexp
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        String input = "FOO[BAR] FOO1[BAR1] FOO2[BAR2] {BAZZ}";
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        // update with regexp
        // String replacedStr = str.replaceAll("\\^(\\d+)", "<sup>\$1</sup>");
        Pattern updPattern = Pattern.compile("\\^([0-9]+)", Pattern.CASE_INSENSITIVE);
        String updInput = "TEXT 123 HELLO World";
        Matcher updMatcher = updPattern.matcher(updInput);
        String output = updMatcher.replaceAll("RPL");
        System.out.println(output);
    }
}


