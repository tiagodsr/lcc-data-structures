// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Interface para o TAD Fila
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public interface MyQueue<T> {

    // Metodos que modificam a fila
    public void enqueue(T v); // Coloca um valor no final da fila
    public T dequeue();       // Retira e retorna o valor no inicio da fila
 
    // Metodos que acedem a informacao (sem modificar)
    public T first();         // Retorna valor no inicio da fila
    public int size();        // Retorna quantidade de elementos na fila
    public boolean isEmpty(); // Indica se a fila esta vazia
 }