import java.util.Scanner;

public class ED005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler número de expressões
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String expression = scanner.nextLine();

            try {
                int result = evaluateRPN(expression);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Expressao Incorrecta");
            }
        }
        scanner.close();
    }

    private static int evaluateRPN(String expression) throws Exception {
        MyStack<Integer> stack = new ArrayStack<>(); // Usando a implementação concreta da interface
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Invalid Expression");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                throw new Exception("Invalid Token");
            }
        }

        if (stack.size() != 1) {
            throw new Exception("Invalid Expression");
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int applyOperation(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new Exception("Division by Zero");
                }
                return a / b;
            default:
                throw new Exception("Unknown Operator");
        }
    }
}
