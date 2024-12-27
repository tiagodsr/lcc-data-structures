// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Classe com um no generico (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class Node<T> {
    private T value;      // Valor guardado no no
    private Node<T> next; // Referencia para o proximo no da lista
 
    // Construtor
    Node(T v, Node<T> n) {
       value = v;
       next = n;
    }
 
    // Getters e Setters
    public T getValue() { return value; }
    public Node<T> getNext()  { return next; }
    public void setValue(T v) { value=v; }
    public void setNext(Node<T> n) { next = n; }
 }