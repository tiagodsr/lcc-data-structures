import java.util.Scanner;

public class ED007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Número de expressões
        int n = Integer.parseInt(scanner.nextLine());
        
        // Processa cada expressão
        for (int i = 0; i < n; i++) {
            String expression = scanner.nextLine();
            String result = checkExpression(expression);
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    public static String checkExpression(String expression) {
        MyStack<Character> stack = new LinkedListStack<>(); // Substitua LinkedListStack por ArrayStack se preferir
        
        // Percorre a expressão
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                // Adiciona parênteses de abertura na pilha
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                // Verifica correspondência com o topo da pilha
                if (stack.isEmpty()) {
                    return "Erro na posicao " + i;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return "Erro na posicao " + i;
                }
            }
        }
        
        // Verifica se ainda há parênteses não fechados
        if (!stack.isEmpty()) {
            return "Ficam parenteses por fechar";
        }
        return "Expressao bem formada";
    }
    
    // Método auxiliar para verificar se os parênteses correspondem
    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}