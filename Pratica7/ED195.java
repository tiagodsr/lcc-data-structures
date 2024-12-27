public class ED195 {
    public static boolean balanced(String s) {
        // Criar uma pilha para armazenar os caracteres
        MyStack<Character> stack = new LinkedListStack<>(); // Ou ArrayStack<Character>

        // Iterar sobre cada caractere da string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Se for um parêntese de abertura, empilhá-lo
            if (c == '(' || c == '[') {
                stack.push(c);
            } 
            // Se for um parêntese de fechamento
            else if (c == ')' || c == ']') {
                // Se a pilha estiver vazia, significa que está mal balanceado
                if (stack.isEmpty()) {
                    return false;
                }

                // Verificar se o topo da pilha corresponde ao tipo de fechamento
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // No final, a pilha deve estar vazia para ser bem balanceada
        return stack.isEmpty();
    }
        public static void main(String[] args) {
            System.out.println(ED195.balanced("((()))")); // true
            System.out.println(ED195.balanced("(()())")); // true
            System.out.println(ED195.balanced("(())]"));  // false
            System.out.println(ED195.balanced("[[[]]]")); // true
            System.out.println(ED195.balanced("[[[]]"));  // false
        }
}