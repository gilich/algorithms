import java.util.Arrays;
import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        findMinAmountOfOperations(number);
    }

    public static int[] findMinAmountOfOperations(int number) {
        if (number == 1) {
            System.out.println("0");
            System.out.println("1");
            return new int[0];
        }
        int[] array = new int[number + 1];
        array[0] = 0;
        array[1] = 0;
        int min = 0;
        for (int i = 2; i < array.length; i++) {
            min = array[i - 1] + 1;
            if (i % 2 == 0) min = Math.min(min, array[i / 2] + 1);
            if (i % 3 == 0) min = Math.min(min, array[i / 3] + 1);
            array[i] = min;
        }
        System.out.println(min);
        getIntermediateResults(min, array);
        return array;
    }

    public static String getIntermediateResults(int amountOfOperations, int[] operations) {
        int[] intermediateResults = new int[amountOfOperations];
        intermediateResults[0] = amountOfOperations;
        int k = 1;
        int j = operations.length - 1;
        for (int i = operations.length - 2; i >= 1; i--) {
            if (operations[i] == 0) break;
            if (operations[j] == operations[i] + 1) {
                if (i + 1 == j) {
                    intermediateResults[k] = i;
                    k++;
                    j = i;
                }
                if (i * 2 == j) {
                    intermediateResults[k] = i;
                    k++;
                    j = i;
                }
                if (i * 3 == j) {
                    intermediateResults[k] = i;
                    k++;
                    j = i;
                }
            }
        }
        Arrays.sort(intermediateResults);
        StringBuilder result = new StringBuilder();
        result.append(1 + " ");
        for (int a : intermediateResults) {
            result.append(a).append(" ");
        }
        System.out.println(result);
        return result.toString();
    }
}
