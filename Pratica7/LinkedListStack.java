// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Implementacao do TAD Pilha usando lista duplamente ligada
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class LinkedListStack<T> implements MyStack<T> {
    private DoublyLinkedList<T> list;
 
    LinkedListStack() { list = new DoublyLinkedList<T>();}
    
    public void push(T v) { list.addFirst(v); }   
    public T pop() {
       T ans = list.getFirst();
       list.removeFirst();
       return ans;
    }
    public T top() { return list.getFirst();}
    public int size() {return list.size();}
    public boolean isEmpty() {return list.isEmpty();}
 
    public String toString() {return list.toString();}
 }