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

    public SinglyLinkedList reverse(){
        SinglyLinkedList<T> reversa = new SinglyLinkedList<>();
        Node<T> curr = first;
        for (int i=0; i<size; i++){
            reversa.addFirst(curr.getValue());
            curr = curr.getNext();
        }
        return reversa;
    }

    public int[] occurrences(T elem){
        int iLista = 0;
        Node<T> curr = first;
        for(int i=0; i<size; i++){
            if(curr.getValue().equals(elem)){
                iLista++;
            }
            curr = curr.getNext();
        }
        int[] array = new int[iLista];
        int ind = 0;
        curr = first;
        for(int i=0; i<size; i++){
            if(curr.getValue().equals(elem)){
                array[ind]=i;
                ind++;
            }
            curr = curr.getNext();
        }
        if (iLista == 0) return null;
        return array;
    }

    public void remove(SinglyLinkedList<T> toRemove) {
        if (toRemove == null || toRemove.isEmpty()) return;
    
        Node<T> cur = first;
        Node<T> prev = null;
    
        while (cur != null) {
            if (toRemove.contains(cur.getValue())) {
                // Remove the current node
                if (prev == null) {
                    // Removing the first node
                    first = cur.getNext();
                } else {
                    prev.setNext(cur.getNext());
                }
                size--;
            } else {
                prev = cur; // Update the previous node
            }
            cur = cur.getNext(); // Move to the next node
        }
    }
    
    // Helper method to check if the list contains a specific element
    public boolean contains(T value) {
        Node<T> cur = first;
        while (cur != null) {
            if (cur.getValue().equals(value)) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public SinglyLinkedList<T> cut(int a, int b) {
      SinglyLinkedList<T> result = new SinglyLinkedList<>();
      if (a > b || a < 0 || b >= size) return result;
      Node<T> cur = first;
      int index = 0;
      while (cur != null) {
          if (index >= a && index <= b) {
              result.addLast(cur.getValue());
          }
          if (index > b) break; 
          cur = cur.getNext();
          index++;
      }
      return result;
   }  

   public void shift(int k) {
      if (isEmpty() || k <= 0 || k >= size) return; // No change for edge cases
  
      k = k % size; // To handle k > size
      int splitPoint = size - k; // Determine the point where the list splits
  
      // Find the split node and the last node
      Node<T> splitNode = first;
      Node<T> lastNode = first;
  
      for (int i = 1; i < size; i++) {
          if (i < splitPoint) {
              splitNode = splitNode.getNext(); // Split at the (size-k)-th node
          }
          lastNode = lastNode.getNext(); // Track the last node
      }
  
      // Adjust the pointers to rotate the list
      lastNode.setNext(first); // Connect the last node to the first node
      first = splitNode.getNext(); // Update the first node
      splitNode.setNext(null); // Disconnect the new last node
  }


  // Exercicios do Teste Singly Linked Lists

  public void insert (T v, int pos){
      Node<T> novoNo = new Node<>(v, null);
      if (pos == 0){
         novoNo.setNext(first);
         first = novoNo;
      }
      else{
         Node <T> curr = first;
         for(int i=0; i<pos-1; i++){
            curr = curr.getNext();
         }
         novoNo.setNext(curr.getNext());
         curr.setNext(novoNo);
      }
      size++;
  }

/* 

   // GPT

   public void insert(T v, int pos) {
      Node<T> newNode = new Node<>(v, null);
      if (pos == 0) {
         // Insert at the beginning
         newNode.setNext(first);
         first = newNode;
      } 
      else {
         // Traverse to the position just before the desired index
         Node<T> cur = first;
         for (int i = 0; i < pos - 1; i++) {
            cur = cur.getNext();
         }
         // Insert the new node
         newNode.setNext(cur.getNext());
         cur.setNext(newNode);
      }

      size++; // Increase the size of the list
   }
*/

   public SinglyLinkedList<T> remove(int[] pos) {
      SinglyLinkedList<T> result = new SinglyLinkedList<>(); // New list to store the remaining elements
      boolean[] toRemove = new boolean[size]; // Boolean array to mark positions to remove
  
      // Mark the positions to remove in the boolean array
      for (int p : pos) {
          if (p >= 0 && p < size) {
              toRemove[p] = true;
          }
      }
      Node<T> cur = first;
      int index = 0;
      while (cur != null) {
          if (!toRemove[index]) {
              result.addLast(cur.getValue());
          }
          cur = cur.getNext();
          index++;
      }
  
      return result;
   }
  
  
    
}