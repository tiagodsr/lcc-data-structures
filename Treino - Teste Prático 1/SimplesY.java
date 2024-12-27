import java.util.Scanner;

public class SimplesY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor ímpar para n: ");
        int n = scanner.nextInt();

        // Parte superior (o "V")
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || j == n - i - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        // Parte inferior (a "linha reta")
        for (int i = mid; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == mid) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
