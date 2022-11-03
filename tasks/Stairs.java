import java.util.Scanner;

class Stairs {
    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        stairs.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int amountOfStages = scanner.nextInt();
        int[] stages = new int[amountOfStages + 1];
        stages[0] = 0;
        for (int i = 1; i < stages.length; i++) {
            stages[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(findMaxSum(stages));
    }

    public long findMaxSum(int[] stages) {
        if (stages.length == 2) return stages[1];
        for (int i = 2; i < stages.length; i++) {
            stages[i] = Math.max(stages[i - 1], stages[i - 2]) + stages[i];
        }
        return stages[stages.length - 1];
    }
}
