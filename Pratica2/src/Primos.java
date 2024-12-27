import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        sc.close();
        // Usaremos o Crivo de Eratóstenes para gerar números primos até B
        boolean[] isPrime = new boolean[B + 1];
        for (int i = 2; i <= B; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= B; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= B; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Contagem de números primos no intervalo [A, B]
        int primeCount = 0;
        for (int i = Math.max(2, A); i <= B; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }

        System.out.println(primeCount);
    }
}
