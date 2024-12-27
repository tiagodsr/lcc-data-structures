import java.util.Scanner;

class Matrix1 {
    int rows,cols;
    char[][] data;

    //Construtor
    Matrix1(int r,int c){
        data = new char[r][c];
        rows = r;
        cols = c;
    }

    public void ler(Scanner input){
        for(int i=0; i<rows; i++){
            String linha = input.nextLine();
            for(int j=0; j<cols; j++){
                data[i][j] = linha.charAt(j); //armazena os caracteres na matriz
            }
        }
    }

    public int[] contarCardinais(){
        int tamanhoMaxSeg = 0;
        int nSegmentos = 0;
        // contar os horizontais
        for(int i=0; i<rows; i++){
            int j = 0;
            while (j<cols){
                if(data[i][j] == '#'){
                    int tamanhoSeg = 0;
                    while( j<cols && data[i][j] == '#'){
                        tamanhoSeg++;
                        j++;
                    }
                    if (tamanhoSeg > tamanhoMaxSeg){
                        tamanhoMaxSeg = tamanhoSeg;
                        nSegmentos = 1;
                    }
                    else if (tamanhoSeg == tamanhoMaxSeg) nSegmentos++;
                }
                else j++;
            }
        }

        // contar os verticais
        for (int i=0; i<cols; i++){
            int j=0;
            while (j<rows){
                if(data[j][i] == '#'){
                    int tamanhoSeg = 0;
                    while (j<rows && data[j][i] == '#'){
                        tamanhoSeg ++;
                        j++;
                    }
                    if (tamanhoSeg > tamanhoMaxSeg){
                        tamanhoMaxSeg = tamanhoSeg;
                        nSegmentos = 1;
                    }
                    else if (tamanhoSeg == tamanhoMaxSeg) nSegmentos++;
                }
                else{
                    j++;
                }
            }
        }
        return new int [] {tamanhoMaxSeg, nSegmentos};
    }
}

public class ContandoCardinais {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int L = input.nextInt(); // número de linhas
        int C = input.nextInt(); // número de colunas
        input.nextLine();  // Consumir a quebra de linha após ler C

        // Criar a matriz
        Matrix1 matriz = new Matrix1(L, C);

        // Ler os elementos da matriz usando o método read
        matriz.ler(input);

        // Exibir a matriz
        // System.out.println(matriz);

        int[] res = matriz.contarCardinais();
        System.out.println(res[0] + " " + res[1]);

        input.close();
    }
}
