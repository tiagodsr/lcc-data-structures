import java.util.Scanner;

public class ED89 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDeEmpresas = scanner.nextInt();
        int flag = scanner.nextInt();
        scanner.nextLine();
        int[] codigosDeArea = new int[numeroDeEmpresas];
        int[] rendimentosTotais = new int[numeroDeEmpresas];
        int contadorAtividades = 0;

        for (int i = 0; i < numeroDeEmpresas; i++) {
            scanner.nextLine(); 
            scanner.nextLine(); 
            scanner.nextLine(); 
            int codigoArea = scanner.nextInt();
            int rendimentos = scanner.nextInt();
            scanner.nextLine();
            // Verificar se o código de área já existe no array
            boolean encontrado = false;
            for (int j = 0; j < contadorAtividades; j++) {
                if (codigosDeArea[j] == codigoArea) {
                    // Atualizar rendimentos
                    rendimentosTotais[j] += rendimentos;
                    encontrado = true;
                    break;
                }
            }
            // Se não encontrado, adicionar novo código de área
            if (!encontrado) {
                codigosDeArea[contadorAtividades] = codigoArea;
                rendimentosTotais[contadorAtividades] = rendimentos;
                contadorAtividades++;
            }
        }
        if (flag == 0) System.out.println(contadorAtividades);
        else if (flag == 1) {
            for (int i = 0; i < contadorAtividades - 1; i++) {
                for (int j = i + 1; j < contadorAtividades; j++) {
                    if (codigosDeArea[i] > codigosDeArea[j]) {
                        // Trocar códigos de área
                        int tempCodigo = codigosDeArea[i];
                        codigosDeArea[i] = codigosDeArea[j];
                        codigosDeArea[j] = tempCodigo;

                        // Trocar rendimentos correspondentes
                        int tempRendimentos = rendimentosTotais[i];
                        rendimentosTotais[i] = rendimentosTotais[j];
                        rendimentosTotais[j] = tempRendimentos;
                    }
                }
            }
            for (int i = 0; i < contadorAtividades; i++) {
                System.out.println(codigosDeArea[i] + " " + rendimentosTotais[i]);
            }
        }
        scanner.close();
    }
}
