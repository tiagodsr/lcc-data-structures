import java.util.Scanner;

class SL {
    private char[][] grid;
    private int linhas, colunas;

    public SL(int linhas, int colunas, char[][] grid) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.grid = grid;
    }

    public void destacarPalavras(String[] palavras) {
        // Cria uma matriz de pontos
        char[][] resultado = new char[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado[i][j] = '.';
            }
        }

        // Procura e destaca cada palavra
        for (String palavra : palavras) {
            procurarEAdicionar(palavra, resultado);
        }

        // Imprime o resultado final
        imprimirResultado(resultado);
    }

    private void procurarEAdicionar(String palavra, char[][] resultado) {
        // Procura horizontalmente
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j <= colunas - palavra.length(); j++) {
                if (verificarHorizontal(i, j, palavra)) {
                    for (int k = 0; k < palavra.length(); k++) {
                        resultado[i][j + k] = grid[i][j + k];
                    }
                }
            }
        }

        // Procura horizontalmente da direita para a esquerda
        for (int i = 0; i < linhas; i++) {
            for (int j = palavra.length() - 1; j < colunas; j++) {
                if (verificarHorizontalReverso(i, j, palavra)) {
                    for (int k = 0; k < palavra.length(); k++) {
                        resultado[i][j - k] = grid[i][j - k];
                    }
                }
            }
        }

        // Procura verticalmente
        for (int i = 0; i <= linhas - palavra.length(); i++) {
            for (int j = 0; j < colunas; j++) {
                if (verificarVertical(i, j, palavra)) {
                    for (int k = 0; k < palavra.length(); k++) {
                        resultado[i + k][j] = grid[i + k][j];
                    }
                }
            }
        }

        // Procura verticalmente de baixo para cima
        for (int i = palavra.length() - 1; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (verificarVerticalReverso(i, j, palavra)) {
                    for (int k = 0; k < palavra.length(); k++) {
                        resultado[i - k][j] = grid[i - k][j];
                    }
                }
            }
        }
    }

    private boolean verificarHorizontal(int linha, int coluna, String palavra) {
        for (int k = 0; k < palavra.length(); k++) {
            if (grid[linha][coluna + k] != palavra.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarHorizontalReverso(int linha, int coluna, String palavra) {
        for (int k = 0; k < palavra.length(); k++) {
            if (grid[linha][coluna - k] != palavra.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarVertical(int linha, int coluna, String palavra) {
        for (int k = 0; k < palavra.length(); k++) {
            if (grid[linha + k][coluna] != palavra.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarVerticalReverso(int linha, int coluna, String palavra) {
        for (int k = 0; k < palavra.length(); k++) {
            if (grid[linha - k][coluna] != palavra.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private void imprimirResultado(char[][] resultado) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(resultado[i][j]);
            }
            System.out.println();
        }
    }
}

public class SopaDeLetras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caso = 1;

        while (true) {
            int linhas = sc.nextInt();
            int colunas = sc.nextInt();

            if (linhas == 0 && colunas == 0) break;

            sc.nextLine();  // Limpa a linha

            // Lê a sopa de letras
            char[][] grid = new char[linhas][colunas];
            for (int i = 0; i < linhas; i++) {
                String linha = sc.nextLine();
                grid[i] = linha.toCharArray();
            }

            // Lê as palavras a procurar
            int numPalavras = sc.nextInt();
            sc.nextLine();  // Limpa a linha
            String[] palavras = new String[numPalavras];
            for (int i = 0; i < numPalavras; i++) {
                palavras[i] = sc.nextLine();
            }

            // Cria e processa a sopa de letras
            SL sopa = new SL(linhas, colunas, grid);
            System.out.println("Input #" + caso);
            sopa.destacarPalavras(palavras);
            caso++;
        }

        sc.close();
    }
}
