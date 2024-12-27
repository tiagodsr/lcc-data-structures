public class TestSinglyLinkedList {
    public static void main(String[] args) {
 
       // Criacao de lista de inteiros
       SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
 
       // Escrevendo lista (no inicio esta vazia)
       System.out.println(list);
 
       // Verificando se esta vazia
       System.out.println("isEmpty? " + list.isEmpty());     
       
       // Adicionando numeros de 1 a 5 ao final da lista
       for (int i=1; i<=5; i++)
          list.addLast(i);
       System.out.println(list);
 
       // Adicionando numeros de 6 a 10 ao inicio da lista
       for (int i=6; i<=10; i++)
          list.addFirst(i);
       System.out.println(list);
 
       // Verificando o tamanho da lista
       System.out.println("size = " + list.size());
 
       // Retirando o primeiro elemento
       list.removeFirst();
       System.out.println(list);
 
       // Retirando o ultimo elemento
       list.removeLast();
       System.out.println(list);
 
       // Verificando se esta vazia
       System.out.println("isEmpty? " + list.isEmpty());
 
       // Escreve o primeiro e ultimo elementos
       System.out.println("getFirst() = " + list.getFirst());
       System.out.println("getLast() = " + list.getLast());
       System.out.println("posicao 0: " + list.get(0));
       System.out.println("posicao -1: " + list.get(-1));
       System.out.println("posicao 9: " + list.get(10)); // maior que o tamanho da lista 
       System.out.println("remove posicao 2: " + list.remove(2));
       System.out.println(list);
    }
 }