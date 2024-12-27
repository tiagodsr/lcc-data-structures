// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Lista ligada simples (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private int size;         // Tamanho da lista
 
    // Construtor (cria lista vazia)
    SinglyLinkedList() {
       first = null;
       size = 0;
    }
 
    // Retorna o tamanho da lista
    public int size() {
       return size;
    }
 
    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
       return (size == 0);
    }
    
    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
       Node<T> newNode = new Node<T>(v, first); 
       first = newNode;
       size++;
    }
 
    // Adiciona v ao final da lista
    public void addLast(T v) {
       Node<T> newNode = new Node<T>(v, null); 
       if (isEmpty()) {
          first = newNode;
       } else {
          Node<T> cur = first;
          while (cur.getNext() != null)
             cur = cur.getNext();
          cur.setNext(newNode);         
       }
       size++;
    }
 
    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
       if (isEmpty()) return null;
       return first.getValue();
    }
 
    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
       if (isEmpty()) return null;
       Node<T> cur = first;
       while (cur.getNext() != null)
          cur = cur.getNext();
       return cur.getValue();      
    }
 
    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
       if (isEmpty()) return;
       first = first.getNext();
       size--;
    }
 
    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
       if (isEmpty()) return;
       if (size == 1) {
          first = null;
       } else {
          // Ciclo com for e uso de de size para mostrar alternativa ao while
          Node<T> cur = first;
          for (int i=0; i<size-2; i++)
             cur = cur.getNext();
          cur.setNext(cur.getNext().getNext());
       }
       size--;
    }
    
    // Converte a lista para uma String
    public String toString() {
       String str = "{";      
       Node<T> cur = first;
       while (cur != null) {
          str += cur.getValue();
          cur = cur.getNext();
          if (cur != null) str += ",";                     
       }      
       str += "}";
       return str;
    }

    // RESOLUÇÃO FICHA 6

    // Devolve o elemento na dada posição
    public T get(int pos){
        Node<T> cur = first;
        if (pos<0 || pos >= size || isEmpty())  return null;
        else{
            for(int i=0; i<pos; i++){
                cur = cur.getNext();
            }
        }
        return cur.getValue();
    }

    // remove o elemento na dada posição
    public T remove(int pos){
        if (pos<0 || pos >= size || isEmpty()) return null;
        T ans = get(pos);
        if (pos == 0){
            first = first.getNext();
            size--;
            return ans;
        }
        else{
            Node<T> cur = first;
            for(int i=1; i < pos; i++){
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
            size--;
        }
        return ans;
    }

    // cria uma nova lista igual à que entra na função
    public SinglyLinkedList<T> copy(){
        SinglyLinkedList <T> newList = new SinglyLinkedList<T> ();
        Node<T> cur = first;
        while (cur != null){
            newList.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return newList;
    }

    // duplicar os elementos da lista
    public void duplicate(){
        Node<T> cur = first;
        while (cur != null){
            Node<T> aux = new Node<T>(cur.getValue(), cur.getNext());
            cur.setNext(aux);
            size++;
            cur = aux.getNext();
        }   
    }

    // conta todas as ocorrências de um valor na lista
    public int count(T value){
        int total = 0;
        Node<T> cur = first;
        while (cur != null){
            T comp = cur.getValue();
            if (value.equals(comp)) total++;
            cur = cur.getNext();
        }
        return total;
    }

    // remove todas as ocorrências de um valor na lista
    public void removeAll(T value) {
        Node<T> cur = first;
        Node<T> prev = null;
        while (cur != null) {
            if (cur.getValue().equals(value)) {
                // Remover o nó se o valor for encontrado
                if (prev == null) {
                    // Se for o primeiro nó
                    first = cur.getNext();
                } else {
                    // Se não for o primeiro nó
                    prev.setNext(cur.getNext());
                }
                size--;
            } else {
                // Avançar para o próximo nó
                prev = cur;
            }
            // atenção a isto !!
            cur = cur.getNext();
        }
    }
 }