import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

class Brackets {
    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        brackets.run();

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        char[] symbols = string.toCharArray();
        System.out.println(checkBrackets(symbols));
    }

    public String checkBrackets(char[] symbols) {
        String result = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < symbols.length; i++) {
            if ((symbols[i] == '(') || (symbols[i] == '[') || (symbols[i] == '{')) {
                stack.push(symbols[i] + ":" + (i + 1));
            }
            if (symbols[i] == ')') {
                if ((!stack.isEmpty()) && Objects.equals(stack.peek().substring(0, 2), "(:")) {
                    stack.pop();
                } else return Integer.toString(i + 1);
            }
            if (symbols[i] == ']') {
                if ((!stack.isEmpty()) && Objects.equals(stack.peek().substring(0, 2), "[:")) {
                    stack.pop();
                } else return Integer.toString(i + 1);
            }
            if (symbols[i] == '}') {
                if ((!stack.isEmpty()) && Objects.equals(stack.peek().substring(0, 2), "{:")) {
                    stack.pop();
                } else return Integer.toString(i + 1);
            }
        }
        if (stack.isEmpty()) result = "Success";
        else result = stack.peek().substring(2);
        return result;
    }
}
