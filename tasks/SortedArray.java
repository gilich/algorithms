import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    private static long result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = scanner.nextInt();
        }
        scanner.close();
        int[] sortedArray = mergeSort(originalArray);
        System.out.println(result);
    }

    public static int[] merge(int[] first, int[] second) {
        int i = 0;
        int j = 0;
        int[] sortedArray = new int[first.length + second.length];
        for (int k = 0; k < sortedArray.length; k++) {
            if ((i < first.length) && (j < second.length)) {
                if (first[i] <= second[j]) {
                    sortedArray[k] = first[i];
                    i++;
                } else {
                    sortedArray[k] = second[j];
                    j++;
                    result += first.length - i;
                }
            } else if (j < second.length) {
                sortedArray[k] = second[j];
                j++;
            } else {
                sortedArray[k] = first[i];
                i++;
            }
        }
        return sortedArray;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int m = array.length / 2;
        int[] firstPart = mergeSort(Arrays.copyOfRange(array, 0, m));
        int[] secondPart = mergeSort(Arrays.copyOfRange(array, m, array.length));
        return merge(firstPart, secondPart);
    }
}
