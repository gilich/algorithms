import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4, 2, 1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] unsortedArray, int left, int right) {
        if ((left >= right) || (unsortedArray.length == 0)) return;
        int referenceElement = partition(unsortedArray, left, right);
        quickSort(unsortedArray, left, referenceElement - 1);
        quickSort(unsortedArray, referenceElement + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int index = left;
        int referenceElement = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] <= referenceElement) {
                index++;
                swap(array, i, index);
            }
        }
        swap(array, index, left);
        return index;
    }

    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
