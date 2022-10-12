package Data_Structures;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sum implements Runnable {

    public static void main(String[] args) {
        new sum().run();
    }

    void print(int givenSum) {
        Expression expression = new Expression();
        for (int i = 0; i < Expression.EXP; i++, expression.next()) {
            if (expression.toInt() == givenSum) {
                expression.print();
            }
        }
    }

    void comment(String commentString) {
        System.out.println();
        System.out.println(commentString);
        System.out.println();
    }
    public void run() {
        final Stat stat = new Stat();

        System.out.println("The patterns which shows patterns  of 100");
        final int givenSum = 100;
        print(givenSum);

    }

    private static class Expression {

        private final static int N = 9;
        private final static byte A = 2;//for add
        private final static byte S = 3;//for subtract
        private final static byte J = 4;// for join

        final byte[] cd = new byte[N];
        final static int EXP = 2 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3;

        Expression next() {
            for (int i = 0; i < N; i++) {
                if (++cd[i] > J) {
                    cd[i] = A;
                } else {
                    break;
                }
            }
            return this;
        }

        int toInt() {
            int value = 0;
            int number = 0;
            int sign = (+1);
            for (int digit = 1; digit <= 9; digit++) {
                switch (cd[N - digit]) {
                    case A:
                        value += sign * number;
                        number = digit;
                        sign = (+1);
                        break;
                    case S:
                        value += sign * number;
                        number = digit;
                        sign = (-1);
                        break;
                    case J:
                        number = 10 * number + digit;
                        break;
                }
            }
            return value + sign * number;
        }
        public String toString() {
            StringBuilder s = new StringBuilder(2 * N + 1);
            for (int digit = 1; digit <= N; digit++) {
                switch (cd[N - digit]) {
                    case A:
                        if (digit > 1) {
                            s.append('+');
                        }
                        break;
                    case S:
                        s.append('-');
                        break;
                }
                s.append(digit);
            }
            return s.toString();
        }

        void print() {
            print(System.out);
        }

        void print(PrintStream printStream) {
            printStream.format("%9d", this.toInt());
            printStream.println(" = " + this);
        }
    }

    private static class Stat {

        final Map<Integer, Integer> count = new HashMap<>();
        final Map<Integer, Set<Integer>> sumc = new HashMap<>();

        Stat() {
            Expression exp = new Expression();
            for (int i = 0; i < Expression.EXP; i++, exp.next()) {
                int sum = exp.toInt();
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                Set<Integer> set;
                if (sumc.containsKey(entry.getValue())) {
                    set = sumc.get(entry.getValue());
                } else {
                    set = new HashSet<>();
                }
                set.add(entry.getKey());
                sumc.put(entry.getValue(), set);
            }
        }
    }
}