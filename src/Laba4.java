package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Laba4 extends Laba {
    
    @Params(params = {"10", "7", "hello my name is Bessie and this is my essay"})
    static String bessy(int n, int k, String s) {
        String[] splited = s.split(" ");
        LinkedList<LinkedList<String>> lines = new LinkedList<LinkedList<String>>();
        LinkedList<String> line = new LinkedList<String>();

        for (String w : splited) {
            String[] lineS = line.toArray(new String[line.size()]);
            if (String.join("", lineS).length() + w.length() <= k) {
                line.add(w);
            } else {
                lines.add(line);
                line = new LinkedList<String>();
                line.add(w);
            }
        }
        lines.add(line);

        String res = "";
        for (LinkedList<String> l : lines) {
            res += String.join(" ", l.toArray(new String[l.size()]));
            res += "\n";
        }
        return res;
    }

    @Params(params = {"()()()"})
    @Params(params = {"((()))(())()()(()())"})
    static String[] split (String s) {
        String[] splited = s.split("");
        Stack<String> stack = new Stack<String>();

        LinkedList<String> res = new LinkedList<String>();

        String brackets = "";

        for (String ch: splited) {
            brackets += ch;
            if (ch.equals("(")) {
                stack.push(ch);
            } if (ch.equals(")")) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res.add(brackets);
                brackets = "";
            }
        }

        return res.toArray(new String[res.size()]);
    }

    @Params(params = {"thisIsCamelCase"})
    static String toCamelCase(String s) {
        String[] splited = s.split("(?=[A-Z][a-z])");
        return String.join("_", Arrays.stream(splited).map(w -> w.toLowerCase()).toArray(String[]::new));
    }

    @Params(params = {"this_is_snake_case"})
    static String toSnakeCase(String s) {
        String[] splited = s.split("_");

        String res = splited[0];
        for (int i = 1; i < splited.length; i ++) {
            String w = splited[i];
            res += w.substring(0, 1).toUpperCase() + w.substring(1);
        }

        return res;
    }
    
}
