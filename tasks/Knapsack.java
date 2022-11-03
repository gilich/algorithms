import java.util.Scanner;

class Knapsack {
    public static void main(String[] args) {
        run();
    }
    public static void run () {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        int[] bullion = new int[n];
        for (int i = 0; i < n; i++) {
            bullion[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(findMaxWeight(W, n, bullion));
    }
    public static int findMaxWeight(int W, int n, int [] bullion) {
        int[][] table = new int[W + 1][n + 1];
        for (int i = 0; i <= W; i++) {
            table[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            table[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                table[j][i] = table[j][i - 1];
                if (bullion[i - 1] <= j) {
                    table[j][i] = Math.max(table[j][i - 1], table[j - bullion[i - 1]][i - 1] + bullion[i - 1]);
                }
            }
        }
        return table[W][n];
    }
}
