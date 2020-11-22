package src;

import java.util.Arrays;

public class Laba2 extends Laba {
    @Params(params = {"test", "4"})
    static String repeat(String s, int count) {
        return String.join("", Arrays.stream(s.split("")).map(s2 -> s2.repeat(count)).toArray(String[]::new));
    }

    @Params(params = {"-3", "5", "0"})
    static int differenceMaxMin(int[] arr) {
        int max = 0;
        int min = 0;

        for (int i: arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        return max - min;
    }

    @Params(params = {"2", "2"})
    @Params(params = {"2", "1"})
    static boolean isAvgWhole(int[] arr) {
        double sum = 0;
        for (int i: arr) {
            sum += i;
        }
        return (sum / arr.length) % 1 == 0;
    }

    @Params(params = {"2", "3", "4"})
    static int[] cumulativeSum(int[] arr) {
        int prev = 0;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i] + prev;
            prev += arr[i];
        }
        return res;
    }

    @Params(params = {"123.32"})
    @Params(params = {"400"})
    static int getDecimalPlaces(String s) {
        String[] splited = s.split("\\.");
        if (splited.length == 2){
            return splited[1].length();
        } else {
            return 0;
        }
    }
}
