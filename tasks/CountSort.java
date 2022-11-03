import java.util.HashMap;
import java.util.Scanner;

class CountSort {
    public static void main(String[] args) {
        run();
    }
    public static void run () {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int maxNumber = 10;
        getSortedArray(countQuantity(array), maxNumber);
    }
    public static HashMap countQuantity (int [] array) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int a:array) {
            if (map.containsKey(a)) map.merge(a, 1, Integer::sum);
            else map.put(a, 1);
        }
        return map;
    }
    public static void getSortedArray (HashMap<Integer, Integer> map, int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            for (int key: map.keySet()) {
                if (key == i) {
                    for (int j = 1; j <= map.get(key); j++) {
                        System.out.print(key + " ");
                    }
                }
            }
        }
    }
}
