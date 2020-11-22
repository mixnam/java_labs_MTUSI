package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba3 extends Laba {
    @Params(params = {"1", "0", "-1"})
    static int solutions(int a, int b, int c) {
        int D = b * b - 4 * a * c;
        if (D == 0) {
            return 1;
        } else if (D > 0) {
            return 2;
        } else {
            return 0;
        }
    }

    @Params(params = {"all zip files are zipped"})
    @Params(params = {"all zip files are compressed"})
    static int findZip(String s) {
        int firstZipIndex = s.indexOf("zip");

        if (firstZipIndex > 0) {
            String newS = s.substring(firstZipIndex + 3);

            int secondZipIndexInNewLine = newS.indexOf("zip");
            if (secondZipIndexInNewLine > 0) {
                return firstZipIndex + 3 + secondZipIndexInNewLine;
            }
        }
        return -1;
    }

    @Params(params = {"6"})
    @Params(params = {"28"})
    @Params(params = {"496"})
    static boolean checkPerfect(int i) {
        int sum = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                sum += j;
            }
        }
        return sum == i;
    }

    @Params(params = {"Cat, dog, and mouse."})
    @Params(params = {"ada"})
    @Params(params = {"F"})
    static String flipEndChars(String s) {
        if (s.length() < 2) {
            return "Incompatible.";
        } else {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            
            if (first == last) {
                return "Two's a pair.";
            } else {
                return last + s.substring(1, s.length() - 1) + first;
            }
        }
    }

    @Params(params = {"#CD5C58C"})
    @Params(params = {"#C0C0C0"})
    static boolean isValidHexCode (String hex) {
        Pattern pattern = Pattern.compile("^#([A-Fa-f0-9]{6})$");
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
