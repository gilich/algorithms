import java.util.Arrays;
import java.util.Scanner;

class FindingSubsequence {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(LISBottomUp(originalArray, originalArray.length));
    }
    public static int LISBottomUp(int [] array, int length) {
        if ((length == 0) || (length == 1)) return 0;
        int [] lengths = new int[length];
        lengths[0] = 1;
        for (int i = 1; i < length; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((array[j] >= array[i]) & ((lengths[j] + 1) > lengths[i])) {
                    lengths[i] = lengths[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(lengths));
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if (maxLength < lengths[i]) maxLength = lengths[i];
        }
        return maxLength;
    }
}
