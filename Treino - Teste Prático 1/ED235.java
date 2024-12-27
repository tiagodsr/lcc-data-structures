import java.util.Scanner;

public class ED235 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTriangulos = scanner.nextInt();
        for (int i = 0; i < nTriangulos; i++) {
            int t = scanner.nextInt(); 
            for (int linha = t; linha > 0; linha--) {
                for (int coluna = 0; coluna < t; coluna++) {
                    if (coluna >= linha) {
                        System.out.print(".");
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
