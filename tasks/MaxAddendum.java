import java.util.ArrayList;
import java.util.Scanner;

class MaxAddendum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if ((n == 0) || (n == 1)) {
            System.out.println(n);
            System.out.println(n);
        } else {
            ArrayList<Integer> result = findMaxAddendum(n);
            System.out.println(result.size());
            for (int s : result) {
                System.out.print(s + " ");
            }
        }
    }

    public static ArrayList<Integer> findMaxAddendum(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int difference;
        for (int i = 1; i < n; i++) {
            difference = n - i;
            if (difference >= i + 1) result.add(i);
            else result.add(n);
            n = n - i;
        }
        return result;
    }
}
