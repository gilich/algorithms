import java.util.Scanner;

public class FibonacciFourty {
    public static void main(String[] args) {
        System.out.println(getFibonacciNum(93));
    }

    public static long getFibonacciNum(long n) {
        if (n <= 1) return n;
        long previous = 0;
        long current = 1;
        for (long i = 2; i <= n; i++) {
            long number = previous + current;
            previous = current;
            current = number;
        }
        return current;
    }
}
