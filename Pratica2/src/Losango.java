import java.util.Scanner;

class Losango {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        for (int i=1; i<=n; i+= 2){
            int nPontos = (n-i) / 2;
            int nCardinais = i; 
            for (int j = 0; j< nPontos; j++){
                System.out.print(".");
            }
            for (int j = 0; j< nCardinais; j++){
                System.out.print("#");
            }
            for (int j = 0; j< nPontos; j++){
                System.out.print(".");
            }

            System.out.println();
        }

        for (int i = n-2; i>=1; i-= 2){
            int nPontos = (n-i)/2;
            int nCardinais = i;

            for (int j = 0; j < nPontos; j++){
                System.out.print(".");
            }
            for (int j = 0; j < nCardinais; j++){
                System.out.print("#");
            }
            for (int j = 0; j < nPontos; j++){
                System.out.print(".");
            }
            System.out.println();
        }
    }
}