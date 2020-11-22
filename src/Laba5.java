package src;

import java.util.Arrays;

public class Laba5 extends Laba {
    @Params(params = {"Test"})
    static int[] decrypt(String s) {
        return Arrays.stream(s.split("")).mapToInt(c -> (int) c.charAt(0)).toArray();
    }   

    @Params(params = {"84", "101", "115", "116"})
    static String encrypt(int[] arr) {
        return String.join("", Arrays.stream(arr).mapToObj(Character::toString).toArray(String[]::new));
    } 
    
    @Params(params = {"84", "101", "115", "116"})
    static String encrypt2(int[] arr) {
        String res = "";
        for (int i : arr) {
            res += (char) i;
        }
        return res;
    } 

    @Params(params = {"Pawn", "A1", "A2"})
    @Params(params = {"Rook", "A1", "A8"})
    @Params(params = {"Bishop", "A7", "G1"})
    @Params(params = {"Knight", "A1", "C2"})
    @Params(params = {"Queen", "A1", "C3"})
    @Params(params = {"King", "A1", "B3"})
    static boolean canMove(String figure, String start, String end) {
        int startL = (int) start.charAt(0);
        int startP = (int) start.charAt(1);
        int endL = (int) end.charAt(0);
        int endP = (int) end.charAt(1);

        if (startL == endL && startP == endP) {
            return false;
        }

        switch (figure) {
            case "Pawn":
                return Math.abs(startP - endP) == 1 && startL == endL;
            case "Rook":
                return (startL == endL) || (startP == endP);
            case "Knight":
                if (Math.abs(startL - endL) == 1 && Math.abs(startP - endP) == 2) {
                    return true;
                }
                if (Math.abs(startL - endL) == 2 && Math.abs(startP - endP) == 1) {
                    return true;
                }
                return false;
            case "Bishop":
                return Math.abs(startL - endL) == Math.abs(startP - endP);
            case "Queen":
                return canMove("Bishop", start, end) || canMove("Rook", start, end);
            case "King":
                if (Math.abs(startL - endL) == 1 && Math.abs(startP - endP) == 1) {
                    return canMove("Quenn", start, end);
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}
