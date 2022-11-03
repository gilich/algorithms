import java.util.Scanner;

class FibonacciBig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciNumBig(n, m));
        scanner.close();
    }

    public static long getFibonacciNumBig(long n, long m) {
        if (n <= 1) return n % m;
        long previous = 0;
        long current = 1;
        long number = 0;
        for (long i = 2; i <= n; i++) {
            number = previous + current;
            previous = current;
            current = number;
        }
        return current%m;
    }
}
