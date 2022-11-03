import java.util.ArrayList;
import java.util.Scanner;

class FibonacciMod {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long n = scanner.nextLong();
//        long m = scanner.nextLong();
//        System.out.println(getFibMod(n, m));
//        scanner.close();

        //long n = 10;
//        long m = 2;
//        System.out.println(getFibModNew(n, m));
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        int[] array2 = new int[10];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        array2[array.length] = 6;
    }

    public static long getFibModNew(long n, long m) {
        if (n == 0) return 0L;
        if (n == 1) return n % m;
        ArrayList<Long> pizano = new ArrayList<>();
        pizano.add(0L);
        pizano.add(1L);
        for (int i = 2; i <= 6 * m; i++) {
            long current = (pizano.get(i - 1) + pizano.get(i - 2)) % m;
            pizano.add(current);
            int size = pizano.size() - 1;
            if (pizano.get(size) == 1 && pizano.get(size - 1) == 0) {
                pizano.remove(size);
                pizano.remove(size - 1);
                break;
            }
        }
        return pizano.get((int) (n % pizano.size()));
    }

    public static long getFibMod(long n, long m) {
        if (n == 0) return 0L;
        if (n == 1) return n % m;
        long previous = 0;
        long current = 1;
        ArrayList<Long> pizano = new ArrayList<>();
        pizano.add(current % m);
        for (long i = 1; i <= 6 * m; i++) {
            long number = (previous + current) % m;
            if ((number % m == 1) && (pizano.get((int) (i - 1)) == 0)) {
                break;
            }
            pizano.add(number % m);
            previous = current % m;
            current = number % m;
        }
        pizano.remove(pizano.size() - 1);
        pizano.add(0, 0L);
        return pizano.get((int) (n % pizano.size()));
    }
}
