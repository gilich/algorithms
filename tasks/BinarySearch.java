import java.util.Scanner;

class BinarySearch {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] givenArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            givenArray[i] = scanner.nextInt();
        }
        int amountOfNumbersToFind = scanner.nextInt();
        int[] numbersToFind = new int[amountOfNumbersToFind];
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < amountOfNumbersToFind; k++) {
            numbersToFind[k] = scanner.nextInt();
            result.append(search.findNumbers(givenArray, numbersToFind[k])).append(" ");
        }
        scanner.close();
        System.out.println(result.toString().trim());
    }

    public int findNumbers(int[] givenArray, int neededNumber) {
        int begin = 0;
        int end = givenArray.length - 1;
        int middle;

        while (begin <= end) {
            middle = (begin + end) / 2;
            if (givenArray[middle] == neededNumber) return middle + 1;
            else if (givenArray[middle] > neededNumber) end = middle - 1;
            else begin = middle + 1;
        }
        return -1;
    }
}
