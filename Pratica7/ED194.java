import java.util.*;

public class ED194 {
    public static void reverse(MyStack<Integer> s, int n) {
        // Criar um array temporário para armazenar os elementos
        int[] tempArray = new int[n];

        // Remover os primeiros `n` elementos da pilha e armazená-los no array
        for (int i = 0; i < n; i++) {
            tempArray[i] = s.pop();
        }

        // Reempilhar os elementos na ordem correta (revertida)
        for (int i = 0; i < n; i++) {
            s.push(tempArray[i]);
        }
    }

    public static void main(String[] args) {
        // Criar uma pilha (utilizando, por exemplo, LinkedListStack)
        MyStack<Integer> s = new LinkedListStack<>();

        // Adicionar elementos na pilha
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("Pilha antes: " + s);

        // Reverter os primeiros 3 elementos
        ED194.reverse(s, 3);

        System.out.println("Pilha depois: " + s);
    }
}