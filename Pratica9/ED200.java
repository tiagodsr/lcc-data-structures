import java.util.Scanner;

public class ED200 {

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] resultados = new int[N];
        
        for (int caso = 0; caso < N; caso++) {
            int L = scanner.nextInt();
            int C = scanner.nextInt();
            scanner.nextLine(); 
            
            char[][] matriz = new char[L][C];
            for (int i = 0; i < L; i++) {
                matriz[i] = scanner.nextLine().toCharArray();
            }
            
            boolean[][] visitado = new boolean[L][C];
            int maiorMicrorganismo = 0;
            
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < C; j++) {
                    if (matriz[i][j] == '#' && !visitado[i][j]) {
                        int tamanhoAtual = contarCelulas(matriz, visitado, i, j, L, C);
                        maiorMicrorganismo = Math.max(maiorMicrorganismo, tamanhoAtual);
                    }
                }
            }
            
            resultados[caso] = maiorMicrorganismo;
        }
        
        for (int resultado : resultados) {
            System.out.println(resultado);
        }
        
        scanner.close();
    }

    // Método recursivo para contar células conectadas
    private static int contarCelulas(char[][] matriz, boolean[][] visitado, int i, int j, int L, int C) {
        // Verificar limites e se já foi visitado ou se é uma posição vazia
        if (i < 0 || i >= L || j < 0 || j >= C || matriz[i][j] == '.' || visitado[i][j]) {
            return 0;
        }
        
        // Marcar a célula como visitada
        visitado[i][j] = true;
        
        // Contar a célula atual
        int tamanho = 1;
        
        // Verificar todas as direções (vertical, horizontal, diagonal)
        tamanho += contarCelulas(matriz, visitado, i - 1, j, L, C); // Cima
        tamanho += contarCelulas(matriz, visitado, i + 1, j, L, C); // Baixo
        tamanho += contarCelulas(matriz, visitado, i, j - 1, L, C); // Esquerda
        tamanho += contarCelulas(matriz, visitado, i, j + 1, L, C); // Direita
        tamanho += contarCelulas(matriz, visitado, i - 1, j - 1, L, C); // Diagonal superior esquerda
        tamanho += contarCelulas(matriz, visitado, i - 1, j + 1, L, C); // Diagonal superior direita
        tamanho += contarCelulas(matriz, visitado, i + 1, j - 1, L, C); // Diagonal inferior esquerda
        tamanho += contarCelulas(matriz, visitado, i + 1, j + 1, L, C); // Diagonal inferior direita
        
        return tamanho;
    }
}
