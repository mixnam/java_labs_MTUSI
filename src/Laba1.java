package src;

import java.util.Arrays;

public class Laba1 extends Laba {
    @Params(params = {"4", "2"})
    @Params(params = {"4", "3"})
    static int mod(int a, int b)  {
        return a % b;
    }

    @Params(params = {"3", "4"})
    static int triArea(int a, int b) {
        return ( a * b ) / 2;
    }

    @Params(params = {"1", "1", "1"})
    static int animals(
        int chicken,
        int cows,
        int pigs
    ) {
        return chicken * 2 + cows * 4 + pigs * 4;
    }

    @Params(params = {"2", "2", "1"})
    static boolean profitableGamble(
        int prog,
        int prize,
        int pay
    ) {
        return prog * prize > pay;
    }

    @Params(params = {"3", "4", "7"})
    static String operation(
        int one,
        int two,
        int three
    ) {
        if (three == one + two) {
            return "added";
        } else if (three == one - two) {
            return "subtracted";
        } else if (three == one * two) {
            return "milt";
        } else if (three == one / two) {
            return "divided";
        } else {
            return "none";
        }
    }

    @Params(params = {"F"})
    static int ctoa(char ch) {
        return (int) ch;
    }

    @Params(params = {"3"})
    @Params(params = {"5"})
    @Params(params = {"10"})
    static int addUpTo(int i) {
        if (i == 0) {
            return 0;
        } else {
            return i + addUpTo(i - 1);
        }
    }

    @Params(params = {"3", "4"})
    @Params(params = {"4", "4"})
    static int sumOfCubes(int[] i) {
        return Arrays.stream(i).map(j -> j * j * j).sum();
    }

    @Params(params = {"1", "2", "3"})
    static boolean abcmath(int a, int b, int c) {
        int res = a;
        for (int i = 0; i < b; i++) {
            res = res * 2;
        }
        return res % c == 0;
    }

    @Params(params = {"4", "5"})
    static int nextEdge(int a, int b) {
        return a + b - 1;
    }
}

