import java.util.Scanner;

class Tabuleiro{
    int nRowsandCols;
    char[][] data;

    Tabuleiro(int num){
        nRowsandCols = num;
        data = new char[num][num];
    }

    public void ler(Scanner input){
        for(int i=0; i<nRowsandCols; i++){
            String linha = input.nextLine();
            for(int j=0; j<nRowsandCols; j++){
                data[i][j] = linha.charAt(j); //armazenar os .,O,X no tab
            }
        }
    }

    public void resultado(){
        boolean jogoIncompleto = false; // Verificar se o jogo está incompleto

        // Verificação em Linhas
        for(int i = 0; i < nRowsandCols; i++){
            int contadorX = 0;
            int contadorO = 0;
            for (int j = 0; j < nRowsandCols; j++){
                if (data[i][j] == 'X'){
                    contadorX ++;
                } else if (data[i][j] == 'O'){
                    contadorO ++;
                } else {
                    jogoIncompleto = true; // Se houver '.', o jogo está incompleto
                }
            }
            if (contadorX == nRowsandCols){
                System.out.println("Ganhou o X");
                return;
            }
            if (contadorO == nRowsandCols){
                System.out.println("Ganhou o O");
                return;
            }
        }

        // Verificação em Colunas
        for(int j = 0; j < nRowsandCols; j++){
            int contadorX = 0;
            int contadorO = 0;
            for (int i = 0; i < nRowsandCols; i++){
                if (data[i][j] == 'X'){
                    contadorX ++;
                } else if (data[i][j] == 'O'){
                    contadorO ++;
                } else {
                    jogoIncompleto = true; // Se houver '.', o jogo está incompleto
                }
            }
            if (contadorX == nRowsandCols){
                System.out.println("Ganhou o X");
                return;
            }
            if (contadorO == nRowsandCols){
                System.out.println("Ganhou o O");
                return;
            }
        }

        // Verificação da Diagonal Principal
        int contadorX = 0;
        int contadorO = 0;
        for(int i = 0; i < nRowsandCols; i++){
            if(data[i][i] == 'X'){
                contadorX ++;
            } else if (data[i][i] == 'O'){
                contadorO ++;
            } else {
                jogoIncompleto = true; // Se houver '.', o jogo está incompleto
            }
        }
        if (contadorX == nRowsandCols){
            System.out.println("Ganhou o X");
            return;
        }
        if (contadorO == nRowsandCols){
            System.out.println("Ganhou o O");
            return;
        }

        // Verificação da Diagonal Secundária
        contadorX = 0;
        contadorO = 0;
        for(int i = 0; i < nRowsandCols; i++){
            if(data[i][nRowsandCols - i - 1] == 'X'){
                contadorX ++;
            } else if (data[i][nRowsandCols - i - 1] == 'O'){
                contadorO ++;
            } else {
                jogoIncompleto = true; // Se houver '.', o jogo está incompleto
            }
        }
        if (contadorX == nRowsandCols){
            System.out.println("Ganhou o X");
            return;
        }
        if (contadorO == nRowsandCols){
            System.out.println("Ganhou o O");
            return;
        }

        // Se o jogo estiver incompleto
        if (jogoIncompleto) {
            System.out.println("Jogo incompleto");
        } else {
            // Se não houver vencedor e o tabuleiro estiver completo, é empate
            System.out.println("Empate");
        }
    }
}

public class JogodoGalo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tamanho = input.nextInt(); // tamanho do tabuleiro
        input.nextLine(); // consumir o newline
        Tabuleiro tab = new Tabuleiro(tamanho);
        tab.ler(input);
        tab.resultado();
    }
}
