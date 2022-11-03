import java.util.*;

class HuffmanDecode {
    public static void main(String[] args) {
        Map<Character, String> lettersAndCodes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
//        int numberOfSymbols = scanner.nextInt();
        String twoLengths = scanner.nextLine();
        int numberOfSymbols = Integer.parseInt(twoLengths.substring(0, 1));
        for (int i = 0; i < numberOfSymbols; i++) {
            String element = scanner.nextLine();
            lettersAndCodes.put(element.charAt(0), element.substring(3));
        }
        String encodedString = scanner.nextLine();
        scanner.close();
        System.out.println(numberOfSymbols);
        System.out.println(encodedString);
        encode(encodedString, lettersAndCodes);
    }

    public static void encode(String encodedString, Map<Character, String> lettersAndCodes) {
        StringBuilder sb = new StringBuilder();
        char[] array = encodedString.toCharArray();
        for (char c : array) {
            String tmp = "";
        }
        System.out.println(sb);
    }
}
