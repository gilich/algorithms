import java.util.Scanner;

public class FibonacciRemainOfDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getFibonacciNumRemainOfDiv(scanner.nextInt()));
        scanner.close();
    }

    public static int getFibonacciNumRemainOfDiv(int n) {
        if (n <= 1) return n;
        int previous = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int number = (previous + current)%10;
            previous = current;
            current = number;
        }
        return current;
    }
}
