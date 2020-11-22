package src;

import java.util.Arrays;

public class Laba6 extends Laba{

    static int[] getLine(int n) {
        int[] line = new int[n];
        if (n == 1) {
            line[0] = 1;
            return line;
        }
        int[] prevLine = getLine(n-1);
        line[0] = prevLine[prevLine.length - 1];
        for (int i = 0; i < n - 1; i++) {
            line[i + 1] = line[i] + prevLine[i];
        }
        return line;
    }

    @Params(params = {"4"})
    @Params(params = {"5"})
    static int bell(int n) {
       int[] bellLine = getLine(n);
       return bellLine[bellLine.length - 1];
    }

    @Params(params = {"Apple"})
    static String translateWord(String word) {
        if (word.length() == 0) {
            return "";
        }
        String vowels = "aeiouy";
        boolean firstIsUpper = word.toUpperCase().charAt(0) == word.charAt(0);
        char firstChar = word.toLowerCase().charAt(0);
        if (vowels.indexOf(firstChar) != -1) {
            return word + "yay";
        } else {
            word = word.toLowerCase();
            String[] splitted = word.split("");
            for (String ch : splitted) {
                if (vowels.indexOf(ch) == -1) {
                    word = word.substring(1) + word.charAt(0);
                } else {
                    break;
                }
            }
            if (firstIsUpper) {
                word = word.toUpperCase().charAt(0) + word.substring(1);
            }
            return word + "ay";
        }
    }

    @Params(params = {"I like to eat honey waffles."})
    @Params(params = {"Do you think it is going to rain today?"})
    public static String translateSentence(String s) {
        String[] s2 = s.split("(?=[\\.\\?])");
        String[] words = s2[0].split(" "); 
        return String.join(" ", Arrays.stream(words).map(word -> Laba6.translateWord(word)).toArray(String[]::new)) + s2[1]; 
    }
}
