import java.util.ArrayList;
import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        long n = 1000000;
        int m = 25;
        System.out.println(getFibMod(n, m));
    }

    public static long getFibMod(long n, int m) {
        if (n == 0) return 0L;
        if (n == 1) return n % m;
        int previous = 0;
        int current = 1;
        ArrayList<Integer> pizano = new ArrayList<>();
        pizano.add(current % m);
        for (int i = 1; i <= 6 * m; i++) {
            int number = previous + current;
            if ((number % m == 1) && (pizano.get(i - 1) == 0)) {
                break;
            }
            pizano.add((number) % m);
            previous = current;
            current = number;
        }
        pizano.remove(pizano.size() - 1);
        pizano.add(0, 0);
        System.out.println(pizano);
        System.out.println(pizano.size());
        return (long)pizano.get((int) (n % pizano.size()));
    }
}
