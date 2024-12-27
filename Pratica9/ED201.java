import java.util.Scanner;

public class ED201 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int D = scanner.nextInt();
        int N = scanner.nextInt();
        int[] duracoes = new int[N]; 

        for (int i = 0; i < N; i++) {
            duracoes[i] = scanner.nextInt();
        }

        // Variável para armazenar a melhor soma possível
        int melhorSoma = calcularMelhorPlaylist(D, duracoes);

        System.out.println(melhorSoma);

        scanner.close();
    }

    // Método para calcular a soma máxima de durações sem ultrapassar D
    static int calcularMelhorPlaylist(int D, int[] duracoes) {
        boolean[] usado = new boolean[duracoes.length];
        return calcularSubconjuntos(0, duracoes, usado, 0, D);
    }

    // Método recursivo para gerar todos os subconjuntos e calcular a melhor soma
    static int calcularSubconjuntos(int atual, int[] duracoes, boolean[] usado, int somaAtual, int limite) {
        if (somaAtual > limite) {
            return 0; // Ignorar subconjuntos que ultrapassam o limite
        }

        if (atual == duracoes.length) {
            return somaAtual; // Caso base: retornar a soma do subconjunto atual
        } else {
            // Subconjunto que inclui o elemento atual
            usado[atual] = true;
            int incluir = calcularSubconjuntos(atual + 1, duracoes, usado, somaAtual + duracoes[atual], limite);

            // Subconjunto que não inclui o elemento atual
            usado[atual] = false;
            int excluir = calcularSubconjuntos(atual + 1, duracoes, usado, somaAtual, limite);

            // Retornar o máximo entre incluir e excluir
            return Math.max(incluir, excluir);
        }
    }
}
