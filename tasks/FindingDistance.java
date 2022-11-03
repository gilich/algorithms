import java.util.Scanner;

class FindingDistance {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();
        scanner.close();
        System.out.println(findDistance(firstString, secondString));
    }

    public static int findDistance(String firstString, String secondString) {
        int[][] table = new int[firstString.length() + 1][secondString.length() + 1];
        for (int i = 0; i <= firstString.length(); i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= secondString.length(); j++) {
            table[0][j] = j;
        }

        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                int value = firstString.charAt(i - 1) == secondString.charAt(j - 1) ? 0 : 1;
                table[i][j] = min(table[i][j - 1] + 1, table[i - 1] [j] + 1, table[i - 1][j - 1] + value);
            }
        }

        return table[firstString.length()][secondString.length()];
    }

    public static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}
