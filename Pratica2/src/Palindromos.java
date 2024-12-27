import java.util.Scanner;

public class Palindromos {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        input.nextLine(); // Consumir o '\n' deixado pelo nextInt()
        String v[] = new String[n];
        String frase2 = "";

        // Leitura das frases
        for (int i=0; i<n ; i++){
            v[i] = input.nextLine();
        }

        // Processamento para transformar as frases em letras minúsculas e sem espaços
        for (int i=0 ; i<n ; i++){
            String frase = v[i];
            int len = frase.length();

            for (int j=0; j<len; j++){
                char caracter = frase.charAt(j);
                if (Character.isLetter(caracter)){
                    caracter = Character.toLowerCase(caracter);
                    frase2 = frase2 + caracter;
                }
            }
            v[i] = frase2;
            frase2 = "";
        }
        System.out.println(n);

        // Verificação se as frases são palíndromos
        for (int i = 0; i<n; i++){
            String frase = v[i];
            int len = frase.length();

            for (int j=len-1; j>=0; j--){ // Corrigir o início do loop
                char character = frase.charAt(j);
                frase2 = frase2 + character;
            }

            if (frase.equals(frase2)) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }

            frase2 = ""; // Resetar frase2 após cada verificação
        }
        input.close();
    }
}
