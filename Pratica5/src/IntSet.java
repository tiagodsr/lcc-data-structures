public interface IntSet {
    public boolean contains(int x);       // Retorna true se x está no conjunto
    public boolean add(int x);            // Adiciona x ao conjunto (devolve true se conseguir)
    public boolean remove(int x);         // Remove x do conjunto (devolve true se conseguir)
    public int size();                    // Retorna o número de elementos do conjunto
    public void clear();                  // Limpa o conjunto (torna-o vazio)

    // Métodos adicionais
    public boolean equals(IntSet s);      // Retorna true se ambos os conjuntos são iguais
    public IntSet intersection(IntSet s); // Devolve um novo conjunto: a interseção de ambos
}
