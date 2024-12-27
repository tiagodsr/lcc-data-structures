import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++) {
            m[i] = in.next().toCharArray();
        }
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;

        // Verifica todas as 8 direções ao redor da célula
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignora a própria célula

                int newY = y + i;
                int newX = x + j;

                // Verifica se está dentro dos limites da matriz
                if (newY >= 0 && newY < rows && newX >= 0 && newX < cols) {
                    if (m[newY][newX] == ALIVE) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        char[][] newGeneration = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countAlive(i, j);

                if (m[i][j] == ALIVE) {
                    // Regra 1 e 3: Se viva, sobrevive se 2 ou 3 vizinhos vivos, caso contrario morre
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        newGeneration[i][j] = DEAD;
                    } else {
                        newGeneration[i][j] = ALIVE;
                    }
                } else {
                    // Regra 4: Se morta, revive se exatamente 3 vizinhos vivos
                    if (aliveNeighbors == 3) {
                        newGeneration[i][j] = ALIVE;
                    } else {
                        newGeneration[i][j] = DEAD;
                    }
                }
            }
        }

        // Atualiza o estado do jogo para a nova geração
        m = newGeneration;
    }

}

// Classe principal com o main()
public class JogodaVida {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = in.nextInt();
        int cols = in.nextInt();
        int n = in.nextInt();

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(in);

        // Realizar n iteracoes
        for (int i = 0; i < n; i++) {
            g.iterate();
        }

        // Imprimir o estado final do jogo
        g.write();
    }
}
