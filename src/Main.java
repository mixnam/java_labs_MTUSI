package src;

public class Main {
    public static void main(String[] Args) {
        Laba[] labs = {
            new Laba1(),
            new Laba2(),
            new Laba3(),
            new Laba4(),
            new Laba5(),
            new Laba6()
        };

        for (Laba laba: labs) {
            laba.run();
        }
    }
}
