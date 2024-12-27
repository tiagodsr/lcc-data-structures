import java.util.Scanner;
import java.util.ArrayList;

public class Pizza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Lê o número de ingredientes que o Mario não gosta e os ingredientes
        int N = input.nextInt();
        ArrayList<Integer> naogosta = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int ing = input.nextInt();
            naogosta.add(ing);
        }
        // Lê o número de pizzas
        int nPizzas = input.nextInt();
        int totalPizzasValidas = 0; // Contador de pizzas que o Mario pode comer
        // Verifica cada pizza
        for (int i = 0; i < nPizzas; i++) {
            int nIng = input.nextInt();
            boolean pizzaValida = true; // Assume que a pizza é válida até encontrar um ingrediente indesejado
            // Verifica os ingredientes da pizza
            for (int j = 0; j < nIng; j++) {
                int ing = input.nextInt();
                // Se a pizza contém algum ingrediente que o Mario não gosta, invalida a pizza
                if (naogosta.contains(ing)) {
                    pizzaValida = false;
                }
            }
            // Se a pizza é válida (não contém ingredientes indesejados), conta como válida
            if (pizzaValida) {
                totalPizzasValidas++;
            }
        }
        input.close();
        System.out.println(totalPizzasValidas); // Imprime o número de pizzas válidas
    }
}
