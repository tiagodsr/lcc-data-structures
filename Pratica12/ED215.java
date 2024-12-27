import java.util.*;

public class ED215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Número de eventos
        sc.nextLine(); // Consumir o resto da linha

        // Usar um MaxHeap para encontrar a maior oferta
        PriorityQueue<Offer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            if (parts[0].equals("OFERTA")) {
                // Criar uma nova oferta
                String name = parts[1];
                int price = Integer.parseInt(parts[2]);
                maxHeap.offer(new Offer(name, price));
            } else if (parts[0].equals("VENDA")) {
                // Processar a venda: pegar a maior oferta disponível
                if (!maxHeap.isEmpty()) {
                    Offer bestOffer = maxHeap.poll();
                    System.out.println(bestOffer.price + " " + bestOffer.name);
                }
            }
        }
        sc.close();
    }
}

// Classe para representar uma oferta
class Offer implements Comparable<Offer> {
    String name;
    int price;

    Offer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Offer other) {
        // Comparar por preço; em caso de empate, usar ordem lexicográfica para o nome
        if (this.price != other.price) {
            return Integer.compare(this.price, other.price);
        }
        return this.name.compareTo(other.name);
    }
}