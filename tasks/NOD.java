import java.util.Scanner;

class NOD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        System.out.println(getNOD(a, b));
    }

    public static int getNOD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return (a >= b)?  getNOD(a % b, b):getNOD(a, b % a);
    }
}
