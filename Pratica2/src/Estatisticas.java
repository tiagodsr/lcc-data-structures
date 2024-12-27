import java.util.Scanner;

public class Estatisticas {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int min= 9999999;
        float media, soma = 0;
        int max = -9999999;
        int n = input.nextInt();

        for (int i = 0; i<n ; i++){
            int num = input.nextInt();
            if (num < min) min = num;
            if (num > max) max = num;
            soma += num;
        }

        media = soma / n;
        System.out.printf("%.2f\n", media);
        System.out.print(-(min - max));
        System.out.println();
        input.close();
    }
}
