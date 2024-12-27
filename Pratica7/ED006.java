import java.util.Scanner;

public class ED006 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i<n; i++){
            //ler a frase
            in.nextLine(); // escapar final da linha anterior
            int count = in.nextLine().split(" ").length;

            //ler criancas
            int k = in.nextInt();
            CircularLinkedList<String> q = new CircularLinkedList<String>();
            for (int j=0; j<k; j++){
                q.addLast(in.next());
            }

            //simular jogo
            for (int j=1; j<k; j++){
                for (int m=1; m<count ;m++) q.rotate();
                q.removeFirst();
            }

            if (q.getFirst().equals("Carlos"))
                System.out.println("O Carlos nao se livrou");
            else
                System.out.println("O Carlos livrou-se (coitado do " + q.getFirst() + "!)");
        }
    }
}